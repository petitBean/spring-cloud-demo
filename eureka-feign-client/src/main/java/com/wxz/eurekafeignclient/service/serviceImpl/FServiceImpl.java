package com.wxz.eurekafeignclient.service.serviceImpl;

import com.wxz.eurekafeignclient.service.FService;
import org.springframework.stereotype.Component;

/**
 * @author Wangxingze
 * @date 2019-08-22 23:47
 */
@Component  //添加该依赖将其注入IOC
public class FServiceImpl implements FService {

    /**
     * 该实现为接口中的快速失败执行方法
     * @param name
     * @return
     */
    @Override
    public String sayHello(String name){
        return "服务快速失败";
    }
}
