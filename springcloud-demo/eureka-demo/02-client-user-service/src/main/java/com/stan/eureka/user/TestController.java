package com.stan.eureka.user;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TestController {

    @Value("${server.port}")
    private Integer port;

    @RequestMapping("/")
    public String test(){
        return "Resp from port: " + port;
    }
}
