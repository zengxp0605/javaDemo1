package com.jason.thread.threadpool;

import java.text.SimpleDateFormat;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

public class ScheduledThreadPool {
    public static void main(String[] args) {
        ScheduledExecutorService scheduledExecutorService = Executors.newScheduledThreadPool(3);

        // 延迟3秒执行
        scheduledExecutorService.schedule(new Runnable() {
            @Override
            public void run() {
                System.out.println(Thread.currentThread().getName() + " -- delay 3 seconds: " + System.currentTimeMillis());
            }
        }, 3, TimeUnit.SECONDS);

        // 表示延迟1秒后每3秒执行一次。
        scheduledExecutorService.scheduleAtFixedRate(new Runnable() {
            @Override
            public void run() {
                System.out.println(Thread.currentThread().getName() + " -- delay 1 seconds, and excute every 3 seconds: "
                        + new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(System.currentTimeMillis()));
            }
        }, 1, 3, TimeUnit.SECONDS);
    }
}
