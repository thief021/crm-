package com.zhongfeng.api.modules.end.service;

import com.zhongfeng.api.modules.end.vo.EndVo;
import com.zhongfeng.api.modules.end.vo.params.EndParams;
import com.zhongfeng.api.modules.utils.pojo.Result;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

/**
 * @author blueCat
 * @date 2023/2/2 14:01
 * @motto life is a gift
 */
public interface EndService {
    /**
     * 查询全部下游信息
     * @param params
     * @return
     */
    Result queryAllEnd(EndParams params, HttpServletRequest request);

    /**
     * 新增下游信息
     * @param params
     * @return
     */
    Result addEnd(EndParams params ,HttpServletRequest request);

    /**
     * 删除下游信息
     * @param id
     * @return
     */
    Result deleteEnd(Integer id);

    /**
     * 修改下游信息
     * @param params
     * @return
     */
    Result updateEnd(EndParams params);

    /**
     * 查询全部IP
     * @param params
     * @return
     */
    Result queryAllIp(EndParams params);

    /**
     * 新增IP地址
     * @param params
     * @return
     */
    Result addIp(EndParams params);

    /**
     * 删除IP地址
     * @param ipId
     * @return
     */
    Result deleteIp(Integer ipId);

    /**
     * 修改IP地址
     * @param params
     * @return
     */
    Result updateIp(EndParams params);
}
