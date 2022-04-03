package com.stan.quartzdemo;

import org.quartz.Job;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;
import org.springframework.stereotype.Component;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Random;

/**
 * @Author: zengxp
 * @Date: 2021/11/21 17:22
 * @Desc:
 */
@Component
public class MyDemoJob implements Job {
    @Override
    public void execute(JobExecutionContext jobExecutionContext) throws JobExecutionException {
        String printTime = new SimpleDateFormat("yy-MM-dd HH-mm-ss").format(new Date());
        System.out.println("------------>Job start at:" + printTime + ", prints: Hello Job-" + new Random().nextInt(100));
    }
}
