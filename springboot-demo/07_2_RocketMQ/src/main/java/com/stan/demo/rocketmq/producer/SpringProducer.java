package com.stan.demo.rocketmq.producer;

import org.apache.rocketmq.client.exception.MQBrokerException;
import org.apache.rocketmq.client.exception.MQClientException;
import org.apache.rocketmq.common.message.Message;
import org.apache.rocketmq.remoting.exception.RemotingException;
import org.apache.rocketmq.spring.core.RocketMQTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.nio.charset.StandardCharsets;

/**
 * @author zengxp
 * @date 2022/2/24 17:44
 */
@Component
public class SpringProducer {

    @Autowired
    private RocketMQTemplate rocketMQTemplate;

    /**
     * 消息发送方法
     *
     * @param topic
     * @param msg
     */
    public String sendMessage(String topic, String msg) throws Exception {
        System.out.println("[Producer] topic: " + topic + ",msg: " + msg);
//        Message<String> message = MessageBuilder.withPayload(msg).build();
//        rocketMQTemplate.convertAndSend(topic, message);

        // 多个comsumer 接收有问题
        Message message = new Message(topic, "tag0", msg.getBytes(StandardCharsets.UTF_8));
        // private String messageDelayLevel = "1s 5s 10s 30s 1m 2m 3m 4m 5m 6m 7m 8m 9m 10m 20m 30m 1h 2h";
        message.setDelayTimeLevel(3);
        rocketMQTemplate.getProducer().send(message);
        return "投递消息 => " + message + " => 成功";
//        rocketMQTemplate.convertAndSend(topic + ":tag0", msg);
//        return "投递消息 => " + msg + " => 成功";
    }
}
