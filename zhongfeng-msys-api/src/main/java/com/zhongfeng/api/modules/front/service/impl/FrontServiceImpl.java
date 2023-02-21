package com.zhongfeng.api.modules.front.service.impl;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.zhongfeng.api.modules.front.mapper.FrontMapper;
import com.zhongfeng.api.modules.front.service.FrontService;
import com.zhongfeng.api.modules.front.vo.FrontVo;
import com.zhongfeng.api.modules.front.vo.params.FrontParams;
import com.zhongfeng.api.modules.utils.function.Transfer;
import com.zhongfeng.api.modules.utils.pojo.PageDataInfo;
import com.zhongfeng.api.modules.utils.pojo.Result;
import com.zhongfeng.api.modules.utils.service.HttpStatus;
import com.zhongfeng.api.modules.utils.service.ReturnCodes;
import com.zhongfeng.api.modules.utils.service.ReturnMessage;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.HierarchicalBeanFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

/**
 * @author blueCat
 * @date 2023/2/2 14:02
 * @motto life is a gift
 */
@Service
@Slf4j
public class FrontServiceImpl implements FrontService {
    @Autowired
    private FrontMapper frontMapper;

    /**
     * 查询上游信息
     *
     * @param params
     * @return
     */
    @Override
    public Result queryAllFront(FrontParams params , HttpServletRequest request)  {
        Page<FrontVo> page = new Page<>(params.getPageNum(), params.getPageSize());
        params.setUserId((Integer) request.getSession().getAttribute("userId"));
        params.setUserType((Integer) request.getSession().getAttribute("userType"));
        log.info("查询下游携带的id是"+request.getSession().getAttribute("userId")+"");
        List<FrontVo> frontVos = frontMapper.queryAllFront(page, params);
        String front="团队上游";
        if(params.getFrontType().equals(front)){


        }
        return Result.setSuccess(HttpStatus.SUCCESS, "", new PageDataInfo(page, frontVos));
    }

    /**
     * 新增上游信息
     *
     * @param params
     * @return
     */
    @Override
    public Result addFront(FrontParams params,HttpServletRequest request) {
        params.setUserId((Integer) request.getSession().getAttribute("userId"));
        int i = frontMapper.addFront(params);
        if (i == 1) {
            return Result.setSuccess(HttpStatus.SUCCESS, "添加上游成功！");
        } else {
            return Result.setFail(ReturnCodes.ADD_FRONT_FAIL, ReturnMessage.ADD_FRONT_FAIL);
        }
    }

    /**
     * 删除上游信息
     *
     * @param id
     * @return
     */
    @Override
    public Result deleteFront(Integer id) {
        int i = frontMapper.deleteFront(id);
        if (i == 1) {
            return Result.setSuccess(HttpStatus.SUCCESS, "删除上游成功！");
        } else {
            return Result.setFail(ReturnCodes.DELETE_FRONT_FAIL, ReturnMessage.DELETE_FRONT_FAIL);
        }
    }

    /**
     * 修改上游信息
     *
     * @param params
     * @return
     */
    @Override
    public Result updateFront(FrontParams params) {
        int i = frontMapper.updateFront(params);
        if (i == 1){
            return Result.setSuccess(HttpStatus.SUCCESS, "修改上游成功！");
        }else {
            return Result.setFail(ReturnCodes.UPDATE_FRONT_FAIL, ReturnMessage.UPDATE_FRONT_FAIL);
        }
    }


}
