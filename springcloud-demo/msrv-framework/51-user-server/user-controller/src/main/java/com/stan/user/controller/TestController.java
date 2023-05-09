package com.stan.user.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TestController {

    @Value("${server.port}")
    private Integer port;

    @Value("${config.test.name:}")
    private String testName;

    @RequestMapping("/")
    public String test(){
        return "Response from port: " + port;
    }

    @RequestMapping("/getConfig")
    public Object config(){

        return "test-" + testName;
    }
}
