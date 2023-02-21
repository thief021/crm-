package com.zhongfeng.api.modules.utils.pojo;

import com.zhongfeng.api.modules.utils.service.HttpStatus;
import lombok.Data;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.MDC;

import java.io.Serializable;

/**
 * 返回结果对象
 * @author blueCat
 * @since 2022/1/12
 */

@Slf4j
@Data
public class Result implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 返回码
     */
    private int code = HttpStatus.SUCCESS;

    /**
     * 返回消息
     */
    private String msg = "success";

    /**
     * 请求id
     */
    private String requestId = MDC.get("requestId");

    /**
     * 返回结果集
     */
    private Object result;

    /**
     * 执行成功
     * @param
     * @return Result
     */
    public static Result setSuccess(){
        Result result = new Result();
        return result;
    }

    /**
     * 执行成功
     * @param data 返回结果集
     * @return
     */
    public static Result setSuccess(Object data){
        Result result = new Result();
        result.result = data;
        return result;
    }

    /**
     * 执行成功
     * @param returnCode 返回码
     * @param message 返回消息
     * @param data 返回结果集
     * @return Result
     */
    public static Result setSuccess(int returnCode,String message,Object data){
        Result result = new Result();
        result.code = returnCode;
        result.msg = message;
        result.result = data;
        return result;
    }

    /**
     * 执行成功
     * @param returnCode 返回码
     * @param message 返回消息
     * @return Result
     */
    public static Result setSuccess(int returnCode,String message){
        Result result = new Result();
        result.code = returnCode;
        result.msg = message;
        return result;
    }

    /**
     * 执行失败
     * @param returnCode 返回码
     * @param message 返回消息
     * @return Result
     */
     public static Result setFail(int returnCode,String message){
         Result result = new Result();
         result.code = returnCode;
         result.msg = message;
         return result;
     }

    /**
     * 执行失败
     * @param returnCode 返回码
     * @return Result
     */
    public static Result setFail(int returnCode){
        Result result = new Result();
        if (returnCode == HttpStatus.BAD_REQUEST){
            result.msg = "非法参数，参数列表错误!";
        }else {
            result.msg = "请求失败!";
        }
        result.code = returnCode;
        return result;
    }

    /**
     * 执行失败-通用
     * @param message 返回消息
     * @return Result
     */
    public static Result setFail(String message){
        Result result = new Result();
        result.msg = message;
        result.code = -1;
        return result;
    }

    /**
     * 执行异常
     * @param e 异常
     * @return Result
     */
    public static Result setFail(Throwable e){
        Result result = new Result();
        result.msg = e.getMessage();
        result.code = HttpStatus.ERROR;
        return result;
    }
}
