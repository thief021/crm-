package com.zhongfeng.api.modules.end.service.impl;

import com.baomidou.mybatisplus.extension.api.R;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.zhongfeng.api.modules.end.mapper.EndMapper;
import com.zhongfeng.api.modules.end.service.EndService;
import com.zhongfeng.api.modules.end.vo.EndVo;
import com.zhongfeng.api.modules.end.vo.IPVo;
import com.zhongfeng.api.modules.end.vo.params.EndParams;
import com.zhongfeng.api.modules.utils.function.Transfer;
import com.zhongfeng.api.modules.utils.pojo.PageDataInfo;
import com.zhongfeng.api.modules.utils.pojo.Result;
import com.zhongfeng.api.modules.utils.service.HttpStatus;
import com.zhongfeng.api.modules.utils.service.ReturnCodes;
import com.zhongfeng.api.modules.utils.service.ReturnMessage;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletRequest;
import java.util.Arrays;
import java.util.List;

/**
 * @author blueCat
 * @date 2023/2/2 14:02
 * @motto life is a gift
 */
@Service
@Slf4j
public class EndServiceImpl implements EndService {
    @Autowired
    private EndMapper endMapper;

    /**
     * 查询全部下游信息
     *
     * @param params
     * @return
     */
    @Override
    public Result queryAllEnd(EndParams params, HttpServletRequest request) {
        params.setUserId((Integer) request.getSession().getAttribute("userId"));
        params.setUserType((Integer) request.getSession().getAttribute("userType"));
        Page<EndVo> page = new Page<>(params.getPageNum(), params.getPageSize());
        List<EndVo> endVos = endMapper.queryAllEnd(page, params);
        return Result.setSuccess(HttpStatus.SUCCESS, "", new PageDataInfo(page, endVos));
    }

    /**
     * 新增下游信息
     *
     * @param params
     * @return
     */
    @Override
    public Result addEnd(EndParams params,HttpServletRequest request) {
        params.setUserId((Integer) request.getSession().getAttribute("userId"));
        params.setUserType((Integer) request.getSession().getAttribute("userType"));
        int i = endMapper.addEnd(params);
        if (i == 1) {
            return Result.setSuccess(HttpStatus.SUCCESS, "添加下游成功！");
        } else {
            return Result.setFail(ReturnCodes.ADD_END_FAIL, ReturnMessage.ADD_END_FAIL);
        }
    }

    /**
     * 删除下游信息
     *
     * @param id
     * @return
     */
    @Override
    public Result deleteEnd(Integer id) {
        int i = endMapper.deleteEnd(id);
        if (i == 1) {
            return Result.setSuccess(HttpStatus.SUCCESS, "删除下游成功！");
        } else {
            return Result.setFail(ReturnCodes.DELETE_END_FAIL, ReturnMessage.DELETE_END_FAIL);
        }
    }

    /**
     * 修改下游信息
     *
     * @param params
     * @return
     */
    @Override
    public Result updateEnd(EndParams params) {
        int i = endMapper.updateEnd(params);
        if (i == 1){
            return Result.setSuccess(HttpStatus.SUCCESS, "修改下游成功！");
        }else {
            return Result.setFail(ReturnCodes.UPDATE_END_FAIL, ReturnMessage.UPDATE_END_FAIL);
        }
    }

    /**
     * 查询全部IP
     *
     * @param params
     * @return
     */
    @Override
    public Result queryAllIp(EndParams params) {
        Page<IPVo> page = new Page<>(params.getPageNum(), params.getPageSize());
        List<IPVo> ipVos = endMapper.queryAllIp(page, params);
        return Result.setSuccess(HttpStatus.SUCCESS, "", new PageDataInfo(page, ipVos));
    }

    /**
     * 新增IP地址
     *
     * @param params
     * @return
     */
    @Override
    public Result addIp(EndParams params) {
        int j = endMapper.checkIp(params.getIp());
        if (j == 0){
            int i = endMapper.addIp(params);
            if (i == 1) {
                return Result.setSuccess(HttpStatus.SUCCESS, "添加IP地址成功！");
            } else {
                return Result.setFail(ReturnCodes.ADD_IP_FAIL, ReturnMessage.ADD_IP_FAIL);
            }
        }else{
            return Result.setFail("IP地址已存在！");
        }
    }

    /**
     * 删除IP地址
     *
     * @param id
     * @return
     */
    @Override
    public Result deleteIp(Integer id) {
        int i = endMapper.deleteIp(id);
        if (i == 1) {
            return Result.setSuccess(HttpStatus.SUCCESS, "删除IP地址成功！");
        } else {
            return Result.setFail(ReturnCodes.DELETE_IP_FAIL, ReturnMessage.DELETE_IP_FAIL);
        }
    }

    /**
     * 修改IP地址
     *
     * @param params
     * @return
     */
    @Override
    public Result updateIp(EndParams params) {
        IPVo ipVo = endMapper.queryIpById(params.getIpId());
        if (ipVo.getIp().equals(params.getIp())){
            int i = endMapper.updateIp(params);
            if (i == 1){
                return Result.setSuccess(HttpStatus.SUCCESS, "修改IP地址成功！");
            }else {
                return Result.setFail(ReturnCodes.UPDATE_IP_FAIL, ReturnMessage.UPDATE_IP_FAIL);
            }
        }else {
            int j = endMapper.checkIp(params.getIp());
            if (j == 0){
                int i = endMapper.updateIp(params);
                if (i == 1) {
                    return Result.setSuccess(HttpStatus.SUCCESS, "修改IP地址成功！");
                } else {
                    return Result.setFail(ReturnCodes.UPDATE_IP_FAIL, ReturnMessage.UPDATE_IP_FAIL);
                }
            }else{
                return Result.setFail("IP地址已存在！");
            }
        }
    }


}
