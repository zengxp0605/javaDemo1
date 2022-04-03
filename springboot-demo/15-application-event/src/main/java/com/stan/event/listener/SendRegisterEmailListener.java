package com.stan.event.listener;

import com.stan.event.event.UserRegisterEvent;
import org.springframework.context.event.EventListener;
import org.springframework.context.event.SmartApplicationListener;
import org.springframework.stereotype.Component;

/**
 * 注册成功发送邮件
 * - 这里使用 @EventListener 来实现
 * - 要实现事件的顺序，可以通过 implements SmartApplicationListener 来实现
 */
@Component
public class SendRegisterEmailListener {

    @EventListener
    public void sendEmail(UserRegisterEvent userRegisterEvent){
        System.out.println("监听到注册事件，发送邮件 ：" + userRegisterEvent.getUser().getEmail());
    }

}
