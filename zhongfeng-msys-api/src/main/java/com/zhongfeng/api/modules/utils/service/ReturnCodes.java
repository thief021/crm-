package com.zhongfeng.api.modules.utils.service;

/**
 * 返回码
 * @author blueCat
 * @since 2022/1/12
 */
public interface ReturnCodes {
    /**
     * 用户不存在
     */
    int USER_NOT_EXIT = 1000;

    /**
     * 用户名已存在
     */
    int USER_EXIT_ALREADY = 1001;

    /**
     * 密码错误
     */
    int PASSWORD_WRONG = 1002;

    /**
     * 添加账单失败
     */
    int ADD_BILL_FAIL = 1003;

    /**
     * 账单类型已存在
     */
    int BILL_TYPE_EXIST = 1004;

    /**
     * 账单内容已存在
     */
    int BILL_CONTENT_EXIST = 1005;

    /**
     * 账单删除失败
     */
    int BILL_DELETE_FAIL = 1006;

    /**
     * 账单修改失败
     */
    int BILL_UPDATE_FAIL = 1007;

    /**
     * 添加计划失败
     */
    int ADD_SCHEDULE_FAIL = 1008;

    /**
     * 删除计划失败
     */
    int SCHEDULE_DELETE_FAIL = 1009;

    /**
     * 修改完成状态失败
     */
    int FINISH_STATUS_FAIL = 1010;

    /**
     * 修改计划失败
     */
    int SCHEDULE_UPDATE_FAIL = 1011;

    /**
     * 新增账户信息失败
     */
    int ADD_ACCOUNT_INFORMATION_FAIL = 1012;

    /**
     * 修改账户信息失败
     */
    int UPDATE_ACCOUNT_INFORMATION_FAIL = 1013;

    /**
     * 删除账号信息失败
     */
    int DELETE_ACCOUNT_INFORMATION_FAIL = 1014;

    /**
     * 添加计划类型失败
     */
    int ADD_SCHEDULE_TYPE_FAIL = 1015;

    /**
     * 添加下游失败
     */
    int ADD_END_FAIL = 1016;

    /**
     * 删除下游失败
     */
    int DELETE_END_FAIL = 1017;

    /**
     * 更新下游失败
     */
    int UPDATE_END_FAIL = 1018;

    /**
     * 添加上游失败
     */
    int ADD_FRONT_FAIL = 1019;

    /**
     * 删除上游失败
     */
    int DELETE_FRONT_FAIL = 1020;

    /**
     * 更新上游失败
     */
    int UPDATE_FRONT_FAIL = 1021;

    /**
     * 修改自由线路失败
     */
    int UPDATE_OWN_FAIL = 1201 ;
    /**
     * 修改自由线路失败
     */
    int ADD_OWN_FAIL = 1202;
    /**
     *
     */
    int DELETE_OWNCIRCUIT_FAIL =1203 ;

    /**
     * 添加下游失败
     */
    int ADD_CUSTOMER_FAIL = 1204;

    /**
     * 删除客户失败
     */
    int DELETE_CUSTOMER_FAIL = 1205;

    /**
     * 更新客户失败
     */
    int UPDATE_CUSTOMER_FAIL = 1206;

    /**
     * 新增线路属性失败
     */
    int ADD_CIRCUIT_PROPERTY_FAIL = 1207;

    /**
     * 线路属性已存在
     */
    int PROPERTY_EXIST = 1208;

    /**
     * 用户名已存在
     */
    int USERNAME_EXIST = 1209;

    /**
     * 添加用户失败
     */
    int ADD_USER_FAIL = 1210;

    /**
     * 修改用户失败
     */
    int UPDATE_USER_FAIL = 1211;

    /**
     * 删除用户失败
     */
    int DELETE_USER_FAIL = 1212;

    /**
     * 添加IP地址失败
     */
    int ADD_IP_FAIL = 1213;

    /**
     * 删除IP地址失败
     */
    int DELETE_IP_FAIL = 1214;

    /**
     * 修改IP地址失败
     */
    int UPDATE_IP_FAIL = 1215;
}
