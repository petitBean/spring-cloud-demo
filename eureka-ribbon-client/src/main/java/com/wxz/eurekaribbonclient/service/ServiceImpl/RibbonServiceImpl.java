package com.wxz.eurekaribbonclient.service.ServiceImpl;

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

    @Autowired
    private LoadBalancerClient balancerClient;

    @Override
    public String sayHello(String name){
        //路径中使用的是服务名 ，即服务提供者的 application: name
        return template.getForObject("http://eureka-client/sayHello?name="+name,String.class)+"???";
    }

    @Override
    public String testBalanceClient(){
        ServiceInstance serviceInstance=balancerClient.choose("eureka-client");
        StringBuilder stringBuilder=new StringBuilder();
        stringBuilder.append("Host:");
        stringBuilder.append(serviceInstance.getHost());
        stringBuilder.append(" PORT:");
        stringBuilder.append(serviceInstance.getPort());
        return stringBuilder.toString();
    }

}
