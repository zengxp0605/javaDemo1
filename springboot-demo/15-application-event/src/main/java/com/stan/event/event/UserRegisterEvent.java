package com.stan.event.event;

import com.stan.event.model.User;
import lombok.Getter;
import org.springframework.context.ApplicationEvent;

/**
 * @Author：stanzeng
 * @Description：
 * @Date ：Created in 2020/4/9 2:52 下午
 * @Modified By：
 */
@Getter
public class UserRegisterEvent extends ApplicationEvent {

    private User user;

    public UserRegisterEvent(Object source, User user) {
        super(source);
        this.user = user;
    }
}
