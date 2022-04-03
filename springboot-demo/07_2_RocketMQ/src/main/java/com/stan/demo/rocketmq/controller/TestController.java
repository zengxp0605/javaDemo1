package com.stan.demo.rocketmq.controller;

import com.stan.demo.rocketmq.producer.SpringProducer;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * @author zengxp
 * @date 2022/2/24 17:49
 */
@RestController
@RequestMapping("/mq")
public class TestController {

    @Resource
    private SpringProducer springProducer;

    @GetMapping("/sendMessage")
    public String sendMessage(@RequestParam("message") String message) {
        System.out.println("message: " + message);
        try {
            springProducer.sendMessage("TestTopic_1", "TestTopic_1-msg");

            return springProducer.sendMessage("TestTopic_2", message);
        } catch (Exception e) {
            e.printStackTrace();
            return e.getMessage();
        }
    }
}

