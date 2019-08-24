package com.wxz.eurekafeignclient.service;

import com.wxz.eurekafeignclient.service.serviceImpl.FServiceImpl;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@FeignClient(value = "eureka-client",fallback = FServiceImpl.class)  //使用feign 及熔断器 指定药访问的服务名
public interface FService {

    //指定在服务提供者中的路径和参数
    @RequestMapping(method=RequestMethod.GET,value ="/sayHello")
    String sayHello(@RequestParam("name")String name);

}
