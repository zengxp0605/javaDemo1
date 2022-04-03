package com.stan.quartzdemo.config;

import com.stan.quartzdemo.MyDemoJob;
import org.quartz.*;
import org.quartz.impl.StdSchedulerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.annotation.PostConstruct;

/**
 * @Author: zengxp
 * @Date: 2021/11/21 17:35
 * @Desc:
 */
@Configuration
public class QuartzConfig {

    @Autowired
    private Scheduler scheduler;

    @PostConstruct
    public void initJob() {
        try {
            scheduler.start();
        } catch (SchedulerException e) {
            e.printStackTrace();
        }
    }

    @Bean
    public JobDetail scheduleJobDetail() {
        System.out.println("**************************************** scheduler job begin");
        JobDetail jobDetail = JobBuilder.newJob(MyDemoJob.class)
                .withIdentity("schedulerJob")
                .storeDurably()
                .build();
        System.out.println("**************************************** scheduler job end");
        return jobDetail;
    }

    @Bean
    public Trigger scheduleJobDetailTrigger() {
        Trigger trigger = TriggerBuilder
                .newTrigger()
                .forJob(scheduleJobDetail())
                .withIdentity("schedulerJob")
                .startNow()//立即生效
                .withSchedule(SimpleScheduleBuilder.simpleSchedule()
                        .withIntervalInSeconds(1)//每隔1s执行一次
                        .repeatForever()).build();//一直执行
        System.out.println("schedulerJob trigger end");
        return trigger;
    }

    @Bean
    public Scheduler scheduler() throws SchedulerException {
        // 1、创建调度器Scheduler
        SchedulerFactory schedulerFactory = new StdSchedulerFactory();
        Scheduler scheduler = schedulerFactory.getScheduler();
        scheduler.scheduleJob(scheduleJobDetail(), scheduleJobDetailTrigger());
        return scheduler;
    }
}
