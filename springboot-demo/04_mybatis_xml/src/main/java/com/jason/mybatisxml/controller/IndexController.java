package com.jason.mybatisxml.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class IndexController {

    @RequestMapping("/index")
    public String index(){
        // 没有配置使用模板, 指向的是 static/index.html
        return "/index.html";
    }
}
