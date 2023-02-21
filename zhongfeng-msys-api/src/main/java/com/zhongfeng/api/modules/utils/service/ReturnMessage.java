package com.zhongfeng.api.modules.utils.service;

/**
 * 返回信息
 *
 * @author blueCat
 * @since 2022/1/12
 */
public interface ReturnMessage {
    /**
     * 用户名不存在
     */
    String USER_NOT_EXIT = "该用户名不存在！";

    /**
     * 用户名已存在
     */
    String USER_EXIT_ALREADY = "用户名已存在！";

    /**
     * 密码错误
     */
    String PASSWORD_WRONG = "密码错误，请重新输入!";

    /**
     * 添加账单失败
     */
    String ADD_BILL_FAIL = "账单添加失败，请重新添加！";

    /**
     * 账单类型已存在
     */
    String BILL_TYPE_EXIST = "账单类型已存在";

    /**
     * 账单内容已存在
     */
    String BILL_CONTENT_EXIST = "账单内容已存在";

    /**
     * 账单删除失败
     */
    String BILL_DELETE_FAIL = "账单删除失败";

    /**
     * 账单修改失败
     */
    String BILL_UPDATE_FAIL = "账单修改失败";

    /**
     * 添加计划失败
     */
    String ADD_SCHEDULE_FAIL = "添加计划失败";

    /**
     * 删除计划失败
     */
    String SCHEDULE_DELETE_FAIL = "删除计划失败";

    /**
     * 修改完成状态失败
     */
    String FINISH_STATUS_FAIL = "修改完成状态失败";

    /**
     * 修改计划失败
     */
    String SCHEDULE_UPDATE_FAIL = "修改计划失败";

    /**
     * 新增账户信息失败
     */
    String ADD_ACCOUNT_INFORMATION_FAIL = "新增账户信息失败";

    /**
     * 修改账户信息失败
     */
    String UPDATE_ACCOUNT_INFORMATION_FAIL = "修改账户信息失败";

    /**
     * 删除账户信息失败
     */
    String DELETE_ACCOUNT_INFORMATION_FAIL = "删除账户信息失败";

    /**
     * 添加计划类型失败
     */
    String ADD_SCHEDULE_TYPE_FAIL = "添加计划类型失败";

    String ADD_END_FAIL = "添加下游失败";

    String DELETE_END_FAIL = "删除下游失败";

    String UPDATE_END_FAIL = "更新下游失败";

    String ADD_FRONT_FAIL = "添加上游失败";

    String DELETE_FRONT_FAIL = "删除上游失败";

    String UPDATE_FRONT_FAIL = "更新上游失败";
    String UPDATE_OWN_FAIL = "更新自有线路失败";
    String ADD_OWN_FAIL = "添加自有线路失败";
    String DELETE_OWNCIRCUIT_FAIL = "删除自有线路失败";

    String ADD_CUSTOMER_FAIL = "添加客户失败";

    String DELETE_CUSTOMER_FAIL = "删除客户失败";

    String UPDATE_CUSTOMER_FAIL = "更新客户失败";

    String ADD_CIRCUIT_PROPERTY_FAIL = "添加线路属性失败";

    String PROPERTY_EXIST = "线路属性已存在";

    String USERNAME_EXIST = "用户名已存在";

    String ADD_USER_FAIL = "添加用户失败";

    String UPDATE_USER_FAIL = "修改用户失败";

    String DELETE_USER_FAIL = "删除用户失败";

    String ADD_IP_FAIL = "添加IP地址失败";

    String DELETE_IP_FAIL = "删除IP地址失败";

    String UPDATE_IP_FAIL = "修改IP地址失败";
}
