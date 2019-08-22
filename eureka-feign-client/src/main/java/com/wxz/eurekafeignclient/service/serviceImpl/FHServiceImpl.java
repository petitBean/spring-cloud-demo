package com.wxz.eurekafeignclient.service.serviceImpl;

import com.wxz.eurekafeignclient.service.FService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author Wangxingze
 * @date 2019-08-22 21:07
 */
@Service
public class FHServiceImpl implements com.wxz.eurekafeignclient.service.FHService {

    @Autowired
    private FService fService;

    @Override
    public String sayHello(String name) {
        return fService.sayHello(name);
    }
}
