package com.jason.mybatisxml;

import com.jason.mybatisxml.mapper.UserFamilyMapper;
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
public class UserFamilyTests {

    @Autowired
    private UserFamilyMapper userFamilyMapper;

    @Test
    @Ignore
    public void testInsert() throws Exception {
        userFamilyMapper.insert(new UserFamily(1L ,222L, "sister"));
        userFamilyMapper.insert(new UserFamily(1L, 333L, "brother"));
        userFamilyMapper.insert(new UserFamily(1L, 444L,"father"));

        Assert.assertEquals(3, userFamilyMapper.getAll().size());
    }

    @Test
    public void testQueryAll() throws Exception {
        List<UserFamily> userFamilies = userFamilyMapper.getAll();
        Assert.assertEquals(3, userFamilies.size());
    }
}
