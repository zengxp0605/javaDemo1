package com.jason.mq;

import com.jason.mq.entity.User;
import com.jason.mq.object.ObjectSender;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Date;

@RunWith(SpringRunner.class)
@SpringBootTest
public class MqObjectTest {

    @Autowired
    private ObjectSender sender;

    @Test
    public void sendObject() throws Exception{
        User user = new User();
        user.setName("zouzou");
        user.setPass("123456");
        sender.send(user);
    }

    @Test
    public void sendManyObject() throws Exception{
        for (int i = 0; i < 10; i++) {
//            System.out.println("---------test user: " + i);
            User user = new User();
            user.setName("zou_" + i);
            user.setPass( new Date() + "");
            sender.send(user);
        }
    }
}
