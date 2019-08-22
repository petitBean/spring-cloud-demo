package com.wxz.eurekaribbonclient.controller;

import com.wxz.eurekaribbonclient.service.RibbonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author Wangxingze
 * @date 2019-08-21 22:29
 */
@RestController
public class RibbonController {

    @Autowired
    private RibbonService ribbonService;

    @GetMapping(value = "/ribbonSayHello")
    public String sayHello(@RequestParam(required = false,defaultValue = "default") String name){
    return ribbonService.sayHello(name);
    }

   /* @GetMapping(value = "/testloadBalancerClient")
    public String testloadBalancerClient(){
        return ribbonService.testBalanceClient();
    }*/

}
