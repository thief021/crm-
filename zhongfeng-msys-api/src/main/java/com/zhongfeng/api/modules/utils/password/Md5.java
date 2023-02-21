package com.zhongfeng.api.modules.utils.password;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.util.DigestUtils;

import java.nio.charset.StandardCharsets;

/**
 * 密码加密
 */

public  class Md5 {

    /**
     * 密码加密
     * @param password 密码
     * @return
     */
    public static String encrypt(String password){
        //使用md5给密码加密
        String encrypt = DigestUtils.md5DigestAsHex(password.getBytes());
        return encrypt;

    }

}
