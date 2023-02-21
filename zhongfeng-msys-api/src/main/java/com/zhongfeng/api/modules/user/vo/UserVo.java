package com.zhongfeng.api.modules.user.vo;

import lombok.Data;

/**
 * @author blueCat
 * @date 2023/2/3 16:06
 * @motto life is a gift
 */
@Data
public class UserVo {

    /**
     * 用户id
     */
    private Integer id;

    /**
     * 真实姓名
     */
    private String realName;

    /**
     * 用户名
     */
    private String username;

    /**
     * 密码
     */
    private String password;

    /**
     * 用户类型：1为普通用户，2为运维，3为技术,4为超级管理员
     */
    private Integer type;

    /**
     * 用户类型
     */
    private String userType;

    /**
     * 电话号
     */
    private String phone;

    /**
     * 微信
     */
    private String wechat;
}
