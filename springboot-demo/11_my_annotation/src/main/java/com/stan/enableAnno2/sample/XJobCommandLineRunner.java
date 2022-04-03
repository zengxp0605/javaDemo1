package com.stan.enableAnno2.sample;


import org.springframework.beans.BeansException;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;

import java.util.Map;

public class XJobCommandLineRunner implements CommandLineRunner, ApplicationContextAware {

    private ApplicationContext applicationContext;

    @Override
    public void run(String... args) throws Exception {
        System.out.println("Runner....");
        Map<String, XJobListener> xJobListenerMap = applicationContext.getBeansOfType(XJobListener.class);
        xJobListenerMap.forEach((key, xJobListener) -> {
            System.out.println("XJobListener注册成功，name=" + xJobListener.getName());
        });
    }

    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        this.applicationContext = applicationContext;
    }
}
