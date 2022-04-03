package com.jason.mybatismulti.mapper;

import com.jason.mybatismulti.entity.User;
import com.jason.mybatismulti.enums.UserSexEnum;
import com.jason.mybatismulti.mapper.test2.User2Mapper;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class User2MapperTest {

    @Autowired
    private User2Mapper userMapper;

    @Test
    public void testInsert() throws Exception{
        userMapper.insert(new User("aa", "a123456", UserSexEnum.MAN));
        userMapper.insert(new User("bb", "b123456", UserSexEnum.WOMAN));
        userMapper.insert(new User("cc", "b123456", UserSexEnum.WOMAN));

        Assert.assertEquals(3, userMapper.getAll().size());
    }
}
