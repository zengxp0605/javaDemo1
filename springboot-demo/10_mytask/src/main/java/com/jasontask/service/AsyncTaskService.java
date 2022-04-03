package com.jasontask.service;

import org.springframework.scheduling.annotation.Async;
import org.springframework.scheduling.annotation.AsyncResult;
import org.springframework.stereotype.Component;

import java.util.concurrent.Future;

@Component
public class AsyncTaskService {

    // 注解标记为异步执行
    @Async
    public Future<Boolean> doTask1() throws Exception {
        long start = System.currentTimeMillis();
        Thread.sleep(1500);
        long end = System.currentTimeMillis();
        System.out.println("任务1耗时: " + (end - start) + " 毫秒");
        return new AsyncResult<>(true);
    }

    @Async
    public Future<Boolean> doTask2() throws Exception {
        long start = System.currentTimeMillis();
        Thread.sleep(500);
        long end = System.currentTimeMillis();
        System.out.println("任务1耗时: " + (end - start) + " 毫秒");
        return new AsyncResult<>(true);
    }

}
