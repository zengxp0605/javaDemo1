package com.jason.mybatisxml;

import com.jason.mybatisxml.mapper.UserFamilyMapper;
import com.jason.mybatisxml.mapper.UserMapper;
import com.jason.mybatisxml.model.User;
import com.jason.mybatisxml.model.UserFamily;
import org.junit.Assert;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
public class UserTests {

    @Autowired
    private UserMapper userMapper;

    @Test
    public void getAll(){
        List<User> users= userMapper.getAll();
        Assert.assertEquals(3, users.size());
    }

    @Test
    public void getAllFamilyByUserId(){
        long id = 1;
        User user= userMapper.getAllFamilyByUserId(id);
        Assert.assertEquals("aa", user.getUserName());
        Assert.assertEquals(3, user.getUserFamilies().size());
    }
}
