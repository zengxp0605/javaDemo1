package com.stan.demo;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class TestController {

    @RequestMapping(value = "/test")
    public String printHello(ModelMap model) {
        System.out.println("from test");
        model.addAttribute("message", " Message from test");

        return "hello";
    }
}

