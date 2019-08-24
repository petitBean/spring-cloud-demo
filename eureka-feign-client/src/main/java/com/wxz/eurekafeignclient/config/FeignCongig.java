package com.wxz.eurekafeignclient.config;

import com.netflix.hystrix.contrib.metrics.eventstream.HystrixMetricsStreamServlet;
import feign.Retryer;
import org.springframework.boot.web.servlet.ServletRegistrationBean;
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

    /**
     * 解决/hytrix.stream无法访问的问题
     * @return
     */
    @Bean
    public ServletRegistrationBean getServlet() {
        HystrixMetricsStreamServlet streamServlet = new HystrixMetricsStreamServlet();
        ServletRegistrationBean registrationBean = new ServletRegistrationBean(streamServlet);
        registrationBean.setLoadOnStartup(1);
        registrationBean.addUrlMappings("/hystrix.stream");
        registrationBean.setName("HystrixMetricsStreamServlet");
        return registrationBean;
    }

}
