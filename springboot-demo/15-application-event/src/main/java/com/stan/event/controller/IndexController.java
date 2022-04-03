package com.stan.event.controller;

import com.stan.event.model.User;
import com.stan.event.service.UserRegisterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.io.File;

@RestController
public class IndexController {

    @Autowired
    private UserRegisterService userRegisterService;

    @RequestMapping("/")
    public Object index(@RequestParam(required = false, defaultValue = "123@qq.com") String email,
                        @RequestParam(required = false, defaultValue = "stan") String username
    ){
        User user = new User().setEmail(email).setName(username);
        userRegisterService.register(user);
        return user;
    }
}
