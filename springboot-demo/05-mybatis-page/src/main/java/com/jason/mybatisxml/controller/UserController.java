package com.jason.mybatisxml.controller;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageInfo;
import com.jason.mybatisxml.mapper.UserMapper;
import com.jason.mybatisxml.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class UserController {

    @Autowired
    private UserMapper userMapper;


    @RequestMapping("/")
    public List<User> home() {
        return this.getUsers();
    }

    @RequestMapping("/getUserPage")
    public PageInfo<User> getUserPage(@RequestParam(name = "pageNo", defaultValue = "1") int pageNo,
                               @RequestParam(name = "pageSize", defaultValue = "10") int pageSize) {

        System.out.println("pageNo: " + pageNo + ",pageSize: " + pageSize);
        Page<User> userPage = userMapper.getUserPage(pageNo, pageSize);

        PageInfo<User> userPageInfo = userPage.toPageInfo();

        return userPageInfo;
    }

    @RequestMapping("/getUsers")
    public List<User> getUsers() {
        List<User> users = userMapper.getAll();
        return users;
    }

    @RequestMapping("/getUser")
    public User getUser(Long id) {
        User user = userMapper.getOne(id);
        return user;
    }

}

