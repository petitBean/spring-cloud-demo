package com.wxz.springclouddemo2;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

/**
 * 服务启动类，应该和其他的类的上一级包处于同级目录
 */
@SpringBootApplication
@EnableEurekaServer  //开启EurekaServer功能
public class SpringcloudDemo2Application {

    public static void main(String[] args) {
        SpringApplication.run(SpringcloudDemo2Application.class, args);
    }

}
