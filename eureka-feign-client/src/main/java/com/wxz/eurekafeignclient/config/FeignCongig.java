package com.wxz.eurekafeignclient.config;

import feign.Retryer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author Wangxingze
 * @date 2019-08-22 20:52
 */
@Configuration
public class FeignCongig {

    /**
     * 注入该Bean后远程调用失败会进行重试
     * @return
     */
    @Bean
    public Retryer feignRetryer(){
        return new Retryer.Default(100,1000,5);
    }

}
