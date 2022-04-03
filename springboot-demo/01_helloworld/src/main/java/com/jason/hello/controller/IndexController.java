package com.jason.hello.controller;

import com.alibaba.fastjson.JSONObject;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class IndexController {

    @GetMapping(path = "/")
    public String index(){
        return "index";
    }

    @GetMapping(path = "/getJson")
    @ResponseBody
    public Object getJson(){
        JSONObject jsonObject = JSONObject.parseObject("{\"date\":\"2019-07-24 17:44:19\", \"id\":1, \"string\":\"fastjson test\"}");
        return jsonObject;
    }
}
