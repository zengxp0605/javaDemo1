package com.stan.event.listener;

import com.stan.event.event.UserRegisterEvent;
import org.springframework.context.ApplicationListener;
import org.springframework.stereotype.Component;

/**
 * 这里必须要加入到 IOC容器， 加 @Component 或者 @Service
 */
@Component
public class UserRegisterListener implements ApplicationListener<UserRegisterEvent> {
    @Override
    public void onApplicationEvent(UserRegisterEvent userRegisterEvent) {

        System.out.println("监听到用户注册事件：user=" + userRegisterEvent.getUser());

    }
}
