package com.jason.groovytst.controller;

import com.jason.groovytst.entity.Member;
import com.jason.groovytst.mapper.UserMapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping("/groovytst")
@RestController
public class HelloController {

    @Autowired
    private UserMapper userMapper;

    @RequestMapping(value = "/index", method = RequestMethod.GET)
    public String index(){

        return "Hello Groovy.";
    }

    @RequestMapping(value = "/getUser", method = RequestMethod.GET)
    public Member getUser(long id){
        System.out.println("--------id: " + id);
        return userMapper.getOne(id);
    }
}
