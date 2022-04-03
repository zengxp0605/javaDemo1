package com.test2.demo2.controller;

import com.test2.demo2.pojo.User;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Date;

@Controller
public class HiController {
    @RequestMapping("/hi")
    public String hi(){
        return "index";
    }

    @RequestMapping("/getUser1")
    @ResponseBody
    public Object getUser1(){
        User u = new User();
        u.setAge(19);
        u.setName("Li Ming");
        u.setPassword("123456");
        u.setBirthday(new Date());
        u.setDesc(null);
        return u;
    }
}
