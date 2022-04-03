package com.jason.mybatis.service;

import com.jason.mybatis.mapper.UserMapper;
import com.jason.mybatis.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

@Service
public class UserService {

    @Autowired
    private UserMapper userMapper;

    public List<User> getUsers() {
        List<User> users = userMapper.getAll();
        return users;
    }

    public User getUser(Long id) {
        User user = userMapper.getOne(id);
        return user;
    }

    public String save(User user) {
        long effRows = userMapper.insert(user);
        return "Last uid: " + user.getId();
    }

    public void update(User user) {
        userMapper.update(user);
    }

    public void delete(@PathVariable("id") Long id) {
        userMapper.delete(id);
    }
}
