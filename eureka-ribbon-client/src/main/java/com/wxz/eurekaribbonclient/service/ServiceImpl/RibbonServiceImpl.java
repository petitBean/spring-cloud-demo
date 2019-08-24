package com.wxz.eurekaribbonclient.service.ServiceImpl;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.wxz.eurekaribbonclient.service.RibbonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.loadbalancer.LoadBalancerClient;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

/**
 * @author Wangxingze
 * @date 2019-08-21 23:21
 */
@Service
public class RibbonServiceImpl implements RibbonService {

    @Autowired
    private RestTemplate template;

    //@Autowired
    //可以获取一些服务提供者信息
   // private LoadBalancerClient balancerClient;

    @Override
    @HystrixCommand(fallbackMethod = "fallBack")  //熔断器注释
    public String sayHello(String name){
        //路径中使用的是服务名 ，即服务提供者的 application: name
        return template.getForObject("http://eureka-client/sayHello?name="+name,String.class)+"???";
    }

    public String fallBack(String name){
        return "服务请求失败"+name;
    }

   /* @Override
    public String testBalanceClient(){
        ServiceInstance serviceInstance=balancerClient.choose("eureka-client");
        StringBuilder stringBuilder=new StringBuilder();
        stringBuilder.append("Host:");
        stringBuilder.append(serviceInstance.getHost());
        stringBuilder.append(" PORT:");
        stringBuilder.append(serviceInstance.getPort());
        return stringBuilder.toString();
    }*/




}
