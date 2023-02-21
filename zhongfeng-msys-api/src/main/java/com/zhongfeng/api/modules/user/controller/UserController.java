package com.zhongfeng.api.modules.user.controller;

import com.zhongfeng.api.modules.user.service.UserService;
import com.zhongfeng.api.modules.user.vo.params.UserParams;
import com.zhongfeng.api.modules.utils.pojo.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @author blueCat
 * @date 2023/2/3 15:38
 * @motto life is a gift
 */
@RestController
@RequestMapping("/api/user")
public class UserController {

    @Autowired
    private UserService userService;

    /**
     * 用户登录
     * @param params(username,password)
     * @return String
     */
    @PostMapping("/login")
    public Result loginAccount(@RequestBody UserParams params, HttpServletResponse resp, HttpServletRequest request){
        return  userService.loginAccount(request,params,resp);
    }

    /**
     * 查询全部用户
     * @param params
     * @param request
     * @return
     */
    @PostMapping("/queryAllUser")
    public Result queryAllUser(@RequestBody UserParams params,HttpServletRequest request){
        return userService.queryAllUser(params,request);
    }

    /**
     * 添加用户
     * @param params
     * @return
     */
    @PostMapping("/addUser")
    public Result addUser(@RequestBody UserParams params){
        return userService.addUser(params);
    }

    /**
     * 修改用户
     * @param params
     * @return
     */
    @PostMapping("/updateUser")
    public Result updateUser(@RequestBody UserParams params){
        return userService.updateUser(params);
    }

    /**
     * 删除用户
     * @param params
     * @return
     */
    @PostMapping("/deleteUser")
    public Result deleteUser(@RequestBody UserParams params){
        return userService.deleteUser(params);
    }

    /**
     * 通过ID查询用户信息
     * @param params
     * @param request
     * @return
     */
    @PostMapping("/queryUser")
    public Result queryUser(@RequestBody UserParams params, HttpServletRequest request){
        return userService.queryUserById(request,params);
    }

    /**
     * 退出
     * @param request
     * @return
     */
    @PostMapping("/logout")
    public Result logout(HttpServletRequest request){
        return userService.logout(request);
    }
}
