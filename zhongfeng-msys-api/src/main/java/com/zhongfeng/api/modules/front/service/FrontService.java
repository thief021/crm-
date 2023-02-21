package com.zhongfeng.api.modules.front.service;

import com.zhongfeng.api.modules.end.vo.params.EndParams;
import com.zhongfeng.api.modules.front.vo.params.FrontParams;
import com.zhongfeng.api.modules.utils.pojo.Result;

import javax.servlet.http.HttpServletRequest;

/**
 * @author blueCat
 * @date 2023/2/2 14:01
 * @motto life is a gift
 */
public interface FrontService {
    /**
     * 查询全部上游信息
     * @param params
     * @return
     */
    Result queryAllFront(FrontParams params, HttpServletRequest request);

    /**
     * 新增上游信息
     * @param params
     * @return
     */
    Result addFront(FrontParams params,HttpServletRequest request);

    /**
     * 删除上游信息
     * @param id
     * @return
     */
    Result deleteFront(Integer id);

    /**
     * 修改上游信息
     * @param params
     * @return
     */
    Result updateFront(FrontParams params);
}
