package com.jason.dubboserver.service;

import com.alibaba.dubbo.config.annotation.Service;
import com.jason.dubbobaseinterface.service.HelloService;
import org.springframework.stereotype.Component;

import java.text.SimpleDateFormat;
import java.util.TimeZone;

@Service(version = "1.0.0")
@Component
public class DefaultHelloService implements HelloService {

    @Override
    public String sayHello(String name) {
        String time = TimeZone.getDefault().getDisplayName() + ": " + new SimpleDateFormat("Y年M月d日H时m分s秒").format(System.currentTimeMillis());

        return "[DefaultHelloService.sayHello] -- " + name + "<br/>" + time;
    }

    @Override
    public String sayGoodbye(String name) {
        String time = TimeZone.getDefault().getDisplayName() + ": " + new SimpleDateFormat("Y年M月d日H时m分s秒").format(System.currentTimeMillis());
        return "[DefaultHelloService.sayGoodbye] -- " + name + "<br/>" + time;
    }
}
