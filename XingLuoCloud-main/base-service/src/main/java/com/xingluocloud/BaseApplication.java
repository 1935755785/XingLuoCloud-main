package com.xingluocloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * @Description: 基础服务模块启动类
 * @Author: SJF
 * @Date: 2023/7/17
 **/
@SpringBootApplication
//@EnableDiscoveryClient
public class BaseApplication {
    public static void main(String[] args) {
        SpringApplication.run(BaseApplication.class);
    }

}
