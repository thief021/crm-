package com.zhongfeng.api.modules.user.service;

import com.zhongfeng.api.modules.user.vo.params.UserParams;
import com.zhongfeng.api.modules.utils.pojo.Result;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @author blueCat
 * @date 2023/2/3 15:52
 * @motto life is a gift
 */
public interface UserService {

    /**
     * 用户登录
     * @param params
     * @param resp
     * @return
     */
    Result loginAccount(HttpServletRequest request, UserParams params, HttpServletResponse resp);

    Result queryUserById(HttpServletRequest request, UserParams params);

    Result logout(HttpServletRequest request);

    /**
     * 查询全部用户
     * @param params
     * @param request
     * @return
     */
    Result queryAllUser(UserParams params, HttpServletRequest request);

    /**
     * 添加用户
     * @param params
     * @return
     */
    Result addUser(UserParams params);

    /**
     * 修改用户
     * @param params
     * @return
     */
    Result updateUser(UserParams params);

    /**
     * 删除用户
     * @param params
     * @return
     */
    Result deleteUser(UserParams params);
}
