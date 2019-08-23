package com.test2.demo2.controller;

import com.test2.demo2.pojo.User;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;

//@Controller
@RestController
@RequestMapping(value = "/user")
public class UserController {


    // 訪問地址: http://localhost:8080/user/getUser
    @RequestMapping("/getUser")
//    @ResponseBody
    public Object getUser(){
        User u = new User();
        u.setAge(29);
        u.setName("Wang Wu");
        u.setPassword("123456");
        u.setBirthday(new Date());
        u.setDesc(null);
        return u;
    }
}

