package com.zhongfeng;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication()
@MapperScan("com.zhongfeng.api.modules.end.mapper")
@MapperScan("com.zhongfeng.api.modules.front.mapper")
@MapperScan("com.zhongfeng.api.modules.circuit.mapper")
@MapperScan("com.zhongfeng.api.modules.user.mapper")
@MapperScan("com.zhongfeng.api.modules.customer.mapper")
@MapperScan("com.zhongfeng.api.modules.img.mapper")
public class ZhongFengApiApplication {
    public static void main(String[] args) {
        SpringApplication.run(ZhongFengApiApplication.class,args);
    }
}
