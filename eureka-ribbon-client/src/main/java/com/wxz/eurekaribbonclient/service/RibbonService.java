package com.wxz.eurekaribbonclient.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;


public interface RibbonService {

     String sayHello(String name);

    // String testBalanceClient();

}
