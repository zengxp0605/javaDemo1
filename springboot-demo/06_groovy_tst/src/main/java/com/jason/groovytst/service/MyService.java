package com.jason.groovytst.service;

import com.jason.groovytst.entity.Member;
import com.jason.groovytst.mapper.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class MyService {

    @Autowired
    private UserMapper userMapper;

    public int add (int a, int b){
        return a+b;
    }

    public boolean isMan(long id){
        // debug 通过性别判断
       Member member = userMapper.getOne(id);
       if(member == null){
           return false;
       }
       return member.getUserSex() == "MAN" ? true : false;
    }
}
