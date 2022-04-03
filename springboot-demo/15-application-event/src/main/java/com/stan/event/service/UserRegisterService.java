package com.stan.event.service;

import com.stan.event.event.AsyncDemoEvent;
import com.stan.event.event.UserRegisterEvent;
import com.stan.event.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Service;

/**
 * @Author：stanzeng
 * @Description：
 * @Date ：Created in 2020/4/9 2:57 下午
 * @Modified By：
 */
@Service
public class UserRegisterService {

    @Autowired
    private ApplicationContext applicationContext;

    public void register(User user) {
        System.out.println("UserRegisterService,用户注册：" + user.getName() + " ," + user.getEmail());

        applicationContext.publishEvent(new UserRegisterEvent(this, user));

        // 异步消息测试
        applicationContext.publishEvent(new AsyncDemoEvent(this, user));
        System.out.println(">>>> Ok");
    }
}
