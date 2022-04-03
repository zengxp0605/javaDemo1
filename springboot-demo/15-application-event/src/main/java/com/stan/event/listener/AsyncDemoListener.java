package com.stan.event.listener;

import com.stan.event.event.AsyncDemoEvent;
import org.springframework.context.ApplicationEvent;
import org.springframework.context.ApplicationListener;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Component;

import java.util.concurrent.TimeUnit;

/**
 * @Author：stanzeng
 * @Description：
 * @Date ：Created in 2020/9/17 6:18 下午
 * @Modified By：
 */

@Async
@Component
public class AsyncDemoListener implements ApplicationListener<AsyncDemoEvent> {
    @Override
    public void onApplicationEvent(AsyncDemoEvent asyncDemoEvent) {
        try {
            System.out.println("AsyncDemoListener >>>OK1 -->" + asyncDemoEvent.getUser());
            TimeUnit.SECONDS.sleep(5);
            System.out.println("AsyncDemoListener >>>OK2 -->" + asyncDemoEvent.getUser());
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
