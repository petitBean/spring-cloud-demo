package com.wxz.eurekafeignclient.controller;

import com.wxz.eurekafeignclient.service.serviceImpl.FHServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author Wangxingze
 * @date 2019-08-22 21:11
 */
@RestController
@RequestMapping(value = "/f")
public class FController {

    @Autowired
    private FHServiceImpl fhService;

    @GetMapping(value = "/sayHello")
    public String sayHello(@RequestParam("name") String name){
        return fhService.sayHello(name);
    }
}
