package com.wxz.eurekaribbonclient.config;

import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

/**
 * @author Wangxingze
 * @date 2019-08-21 22:11
 */
@Configuration
public class RibbonConfig {

    @Bean
    @LoadBalanced  //Ribbon负载均衡
    RestTemplate restTemplate(){
        return new RestTemplate();
    }
}
