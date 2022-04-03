package com.stan.demo.rocketmq.consumer;

import org.apache.rocketmq.client.consumer.DefaultMQPushConsumer;
import org.apache.rocketmq.spring.annotation.RocketMQMessageListener;
import org.apache.rocketmq.spring.core.RocketMQListener;
import org.apache.rocketmq.spring.core.RocketMQPushConsumerLifecycleListener;
import org.springframework.stereotype.Component;

/**
 * @author zengxp
 * @date 2022/2/24 17:47
 */
@Component
@RocketMQMessageListener(consumerGroup = "consumer-group-1",
        topic = "TestTopic_1"
)
public class Consumer1 implements RocketMQListener<String> {
    @Override
    public void onMessage(String msg) {
        System.out.println("[Consumer1] 接收msg: " + msg);

    }

    /**
     * 避免多个相同 topic 的消费者无法启动
     *
     * @param defaultMQPushConsumer
     */
//    @Override
//    public void prepareStart(DefaultMQPushConsumer defaultMQPushConsumer) {
//        defaultMQPushConsumer.setInstanceName("consumer-group-1");
//    }
}
