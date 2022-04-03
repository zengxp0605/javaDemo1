package com.jasontask.service;

import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.text.SimpleDateFormat;
import java.util.Date;

@Component
public class TaskService {

    private static final SimpleDateFormat dateFormat = new SimpleDateFormat("HH:mm:ss");

    // 定时器每3秒执行任务
//    @Scheduled(fixedRate = 3000)
    // 通过定时器任务表达式 在线生成表达式<http://cron.qqe2.com/>
    @Scheduled(cron = "5-10 * * * * ?")
    public void reportCurrentTime(){

        System.out.println("当前时间: " + dateFormat.format(new Date()));
    }
}
