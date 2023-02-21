package com.zhongfeng.api.modules.utils.service;

/**
 * Http状态码
 * @author blueCat
 * @since 2022/1/12
 */
public interface HttpStatus {
    /**
     * 通用成功标识
     */
    int SUCCESS = 200;

    /**
     * 通用失败标识
     */
    int FAIL = -1;

    /**
     * 参数列表错误（缺少，格式不匹配）
     */
    int BAD_REQUEST = 400;

    /**
     * 未授权
     */
    int UNAUTHORIZED = 401;

    /**
     * 不允许的http方法
     */
    int BAD_METHOD = 405;

    /**
     * 执行异常
     */
    int EXCEPTION = 499;

    /**
     * 系统内部错误
     */
    int ERROR = 500;

    /**
     * 接口为实现
     */
    int NOT_IMPLEMENTED = 501;
}
