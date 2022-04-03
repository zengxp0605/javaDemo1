package com.stan.demo;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.ui.ModelMap;

@Controller
public class HelloController{

    @RequestMapping(value = "/hello")
    public String printHello(ModelMap model) {
        System.out.println("from hello..");
        model.addAttribute("message", "Hello Spring MVC Framework!");

        return "hello";
    }
}

