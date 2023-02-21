package com.zhongfeng.api.modules.customer.vo;

import lombok.Data;

import java.util.List;

/**
 * @author blueCat
 * @date 2023/2/8 10:24
 * @motto life is a gift
 */
@Data
public class CustomerVo {

    /**
     * 客户id
     */
    private Integer id;

    /**
     * 用户id
     */
    private Integer userId;

    /**
     * 用户名
     */
    private String username;

    /**
     * 公司名
     */
    private String company;

    /**
     * 微信名
     */
    private String wechatName;

    /**
     * 微信账号
     */
    private String wechatAccount;

    /**
     * 手机号
     */
    private String phoneNumber;

    /**
     * 更新时间
     */
    private String updateTime;

    /**
     * ipId
     */
    private String ipId;

    /**
     * ip
     */
    private String ip;

    /**
     * ipId集合
     */
    private List<Integer> ipIdList;
    /**
     * 图片名字
     */
    private String license;
    /**
     * 图片的id
     */
    private Integer licenseId;
}
