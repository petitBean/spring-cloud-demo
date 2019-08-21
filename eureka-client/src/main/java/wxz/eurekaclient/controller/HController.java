package wxz.eurekaclient.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author Wangxingze
 * @date 2019-08-21 14:37
 */
@RestController
public class HController {

    @Value("${server.port}")
    private String port;

    @GetMapping(value = "/sayHello")
    public String sayHello(@RequestParam("name") String name){
        return "hello1"+name+port;
    }
}
