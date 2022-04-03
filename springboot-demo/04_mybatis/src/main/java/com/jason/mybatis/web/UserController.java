package com.jason.mybatis.web;

import com.jason.mybatis.model.User;
import com.jason.mybatis.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class UserController {

    @Autowired
    private UserService userService;

    @RequestMapping("/")
    public List<User> home() {
        return this.getUsers();
    }

    @RequestMapping("/getUsers")
    public List<User> getUsers() {
        return userService.getUsers();
    }

    @RequestMapping("/getUser")
    public User getUser(@RequestParam(name = "id") Long id) {
        return userService.getUser(id);
    }

    @RequestMapping("/add")
    public String save(User user) {
        return userService.save(user);
    }

    @RequestMapping(value = "/delete/{id}")
    public String delete(@PathVariable("id") Long id) {
        userService.delete(id);
        return "删除用户id: " + id;
    }
}
