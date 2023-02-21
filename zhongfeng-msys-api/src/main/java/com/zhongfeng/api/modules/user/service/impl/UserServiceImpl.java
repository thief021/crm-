package com.zhongfeng.api.modules.user.service.impl;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.zhongfeng.api.modules.customer.vo.CustomerVo;
import com.zhongfeng.api.modules.user.mapper.UserMapper;
import com.zhongfeng.api.modules.user.service.UserService;
import com.zhongfeng.api.modules.user.vo.UserVo;
import com.zhongfeng.api.modules.user.vo.params.UserParams;
import com.zhongfeng.api.modules.utils.password.Md5;
import com.zhongfeng.api.modules.utils.pojo.PageDataInfo;
import com.zhongfeng.api.modules.utils.pojo.Result;
import com.zhongfeng.api.modules.utils.service.HttpStatus;
import com.zhongfeng.api.modules.utils.service.ReturnCodes;
import com.zhongfeng.api.modules.utils.service.ReturnMessage;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.DigestUtils;

import javax.annotation.Resource;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;

/**
 * @author blueCat
 * @date 2023/2/3 15:52
 * @motto life is a gift
 */
@Service
@Slf4j
public class UserServiceImpl implements UserService {

    @Autowired
    @Resource
    private UserMapper userMapper;

    /**
     * 用户登录
     *
     * @param params
     * @param resp
     * @return
     */

    @Override
    public Result loginAccount(HttpServletRequest request, UserParams params, HttpServletResponse resp) {
        //查询用户名是否存在
        int i = userMapper.queryUserByUsername(params.getUsername());
        if (i == 0) {
            return Result.setFail(ReturnCodes.USER_NOT_EXIT, ReturnMessage.USER_NOT_EXIT);
        }
        //检查账号密码
        String password = userMapper.checkAccount(params.getUsername(), params.getPassword());
        log.info(DigestUtils.md5DigestAsHex(params.getPassword().getBytes()));
        log.info(DigestUtils.md5DigestAsHex(password.getBytes()));
        if( !DigestUtils.md5DigestAsHex(params.getPassword().getBytes()).equals(password)){
            return Result.setFail(ReturnCodes.PASSWORD_WRONG, ReturnMessage.PASSWORD_WRONG);
        }
        //查询真实姓名
        UserVo userVo = userMapper.queryUser(params.getUsername());
        if (userVo.getRealName() == null) {
            userVo.setRealName("NONAME");
        }
        //得到session
        request.getSession().setAttribute("userId", userVo.getId());
        request.getSession().setAttribute("userType",userVo.getType());
        Cookie realNameCookie = new Cookie("realName", userVo.getRealName());
        log.info(userVo.getType() + "");
        Cookie userTypeCookie = new Cookie("userType", userVo.getType() + "");
        //解决跨域问题,设置cookie存放地址
        realNameCookie.setPath("/");
        userTypeCookie.setPath("/");
        //设置cookie的有效时间
        realNameCookie.setMaxAge(10*60);
        userTypeCookie.setMaxAge(10*60);
        //添加cookie
        resp.addCookie(realNameCookie);
        resp.addCookie(userTypeCookie);
        return Result.setSuccess(HttpStatus.SUCCESS, "登陆成功！");
    }

    /**
     * 查询用户信息
     * @param request
     * @param params
     * @return
     */
    @Override
    public Result queryUserById(HttpServletRequest request, UserParams params) {
        Integer userId =(Integer) request.getSession().getAttribute("userId");
        UserVo userVo = userMapper.queryUserById(userId);
        return  Result.setSuccess(userVo);

    }

    @Override
    public Result logout(HttpServletRequest request) {
        //清楚session
        request.getSession().removeAttribute("userId");
        request.getSession().removeAttribute("userType");
        if (request.getSession().getAttribute("userId")!=null&&request.getSession().getAttribute("userType")!=null){
            return Result.setFail(HttpStatus.FAIL,"退出失败");

        }
        return Result.setSuccess(HttpStatus.SUCCESS,"退出成功");
    }

    /**
     * 查询全部用户
     *
     * @param params
     * @param request
     * @return
     */
    @Override
    public Result queryAllUser(UserParams params, HttpServletRequest request) {
        Page<UserVo> page = new Page<>(params.getPageNum(), params.getPageSize());
        params.setUserId((Integer) request.getSession().getAttribute("userId"));
        params.setUserType((Integer) request.getSession().getAttribute("userType"));
        List<UserVo> userVos = userMapper.queryAllUser(page, params);
        return Result.setSuccess(HttpStatus.SUCCESS, "", new PageDataInfo(page, userVos));
    }

    /**
     * 添加用户
     *
     * @param params
     * @return
     */
    @Override
    public Result addUser(UserParams params) {
        //添加之前检查用户账号是否存在
        int num = userMapper.checkUsername(params.getUsername());
        if (num == 0){
            params.setPassword(Md5.encrypt(params.getPassword()));
            int i = userMapper.addUser(params);
            if (i == 1) {
                return Result.setSuccess(HttpStatus.SUCCESS, "添加用户成功！");
            } else {
                return Result.setFail(ReturnCodes.ADD_USER_FAIL, ReturnMessage.ADD_USER_FAIL);
            }
        }else {
            return Result.setFail(ReturnCodes.USERNAME_EXIST, ReturnMessage.USERNAME_EXIST);
        }
    }

    /**
     * 修改用户
     *
     * @param params
     * @return
     */
    @Override
    public Result updateUser(UserParams params) {
        params.setPassword(Md5.encrypt(params.getPassword()));
        //检查用户名是否被修改
        UserVo userVo = userMapper.queryUserById(params.getId());
        if (!userVo.getUsername().equalsIgnoreCase(params.getUsername())){
            //修改之前检查用户账号是否存在
            int num = userMapper.checkUsername(params.getUsername());
            if (num == 0){
                int i = userMapper.updateUser(params);
                if (i == 1) {
                    return Result.setSuccess(HttpStatus.SUCCESS, "添加用户成功！");
                } else {
                    return Result.setFail(ReturnCodes.UPDATE_USER_FAIL, ReturnMessage.UPDATE_USER_FAIL);
                }
            }else {
                return Result.setFail(ReturnCodes.USERNAME_EXIST, ReturnMessage.USERNAME_EXIST);
            }
        }else {
            int i = userMapper.updateUser(params);
            if (i == 1) {
                return Result.setSuccess(HttpStatus.SUCCESS, "添加用户成功！");
            } else {
                return Result.setFail(ReturnCodes.UPDATE_USER_FAIL, ReturnMessage.UPDATE_USER_FAIL);
            }
        }
    }

    /**
     * 删除用户
     *
     * @param params
     * @return
     */
    @Override
    public Result deleteUser(UserParams params) {
        int i = userMapper.deleteUser(params.getId());
        if (i == 1) {
            return Result.setSuccess(HttpStatus.SUCCESS, "删除用户成功！");
        } else {
            return Result.setFail(ReturnCodes.DELETE_USER_FAIL, ReturnMessage.DELETE_USER_FAIL);
        }
    }
}
