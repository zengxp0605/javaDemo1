package com.jason.dubboclient.controller;

import com.alibaba.dubbo.config.annotation.Reference;
import com.jason.dubbobaseinterface.service.HelloService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {

    @Reference(version = "1.0.0")
    HelloService helloService;

    // http://localhost:8080/hello/myName
    @GetMapping("/hello/{name}")
    public String sayHello(@PathVariable String name){
        return helloService.sayHello(name);
    }

    // http://localhost:8080/goodbye/myName
    @GetMapping("/goodbye/{name}")
    public String sayGoodbye(@PathVariable String name){
        return helloService.sayGoodbye(name);
    }

}
