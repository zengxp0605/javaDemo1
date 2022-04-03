package com.jason.mybatismulti.controller;

import com.jason.mybatismulti.entity.User;
import com.jason.mybatismulti.mapper.test1.User1Mapper;
import com.jason.mybatismulti.mapper.test2.User2Mapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class UserController {

    @Autowired
    private User1Mapper user1Mapper;

    @Autowired
    private User2Mapper user2Mapper;

    @RequestMapping("/u1/getUsers")
    public List<User> getUsers() {
        List<User> users=user1Mapper.getAll();
        return users;
    }

    @RequestMapping("/u1/getUser")
    public User getUser(Long id) {
        User user=user1Mapper.getOne(id);
        return user;
    }

    @RequestMapping("/u1/add")
    public void save(User user) {
        user1Mapper.insert(user);
    }

    @RequestMapping(value="/u1/update")
    public void update(User user) {
        user1Mapper.update(user);
    }

    @RequestMapping(value="/u1/delete/{id}")
    public void delete(@PathVariable("id") Long id) {
        user1Mapper.delete(id);
    }


    /**  数据源2 的测试,     */
    @RequestMapping("/u2/getUsers")
    public List<User> getUsers2() {
        List<User> users=user2Mapper.getAll();
        return users;
    }

    @RequestMapping("/u2/getUser")
    public User getUser2(Long id) {
        User user=user2Mapper.getOne(id);
        return user;
    }

    @RequestMapping("/u2/add")
    public void save2(User user) {
        user2Mapper.insert(user);
    }

    @RequestMapping(value="/u2/update")
    public void update2(User user) {
        user2Mapper.update(user);
    }

    @RequestMapping(value="/u2/delete/{id}")
    public void delete2(@PathVariable("id") Long id) {
        user2Mapper.delete(id);
    }

}