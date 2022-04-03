package com.stan.event.event;

import com.stan.event.model.User;
import lombok.Getter;
import org.springframework.context.ApplicationEvent;

/**
 * @Author：stanzeng
 * @Description：异步化事件
 * @Date ：Created in 2020/9/17 6:15 下午
 * @Modified By：
 */
@Getter
public class AsyncDemoEvent extends ApplicationEvent {
    private User user;

    public AsyncDemoEvent(Object source, User user) {
        super(source);
        this.user = user;
    }
}
