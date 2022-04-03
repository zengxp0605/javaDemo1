package com.stan.demo.rocketmq.consumer;

import org.apache.rocketmq.client.consumer.DefaultMQPushConsumer;
import org.apache.rocketmq.common.message.MessageExt;
import org.apache.rocketmq.spring.annotation.RocketMQMessageListener;
import org.apache.rocketmq.spring.annotation.SelectorType;
import org.apache.rocketmq.spring.core.RocketMQListener;
import org.apache.rocketmq.spring.core.RocketMQPushConsumerLifecycleListener;
import org.springframework.stereotype.Component;

/**
 * @author zengxp
 * @date 2022/2/24 17:47
 */
@Component
@RocketMQMessageListener(consumerGroup = "consumer-group-2",
        topic = "TestTopic_2",
        selectorType = SelectorType.TAG,
        selectorExpression = "tag0" // tag
)
public class Consumer2 implements RocketMQListener<MessageExt> {
    @Override
    public void onMessage(MessageExt message) {
        System.out.println("[Consumer2] 接收msg: " + message);
        System.out.println("[Consumer2] 接收msg: " + message.getMsgId());
        System.out.println("[Consumer2] 接收msg: " + message.getTags());
        System.out.println("[Consumer2] 接收msg: " + message.getTopic());
        System.out.println("[Consumer2] 接收msg: " + new String(message.getBody()));

    }

//    @Override
//    public void prepareStart(DefaultMQPushConsumer defaultMQPushConsumer) {
//        defaultMQPushConsumer.setInstanceName("TestTopic_2:tag-0");
//    }
}
