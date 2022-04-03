package com.jason.mq.object;

import com.jason.mq.entity.User;
import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

@Component
@RabbitListener(queues = "object")
public class ObjectReceiver2 {

    @RabbitHandler
    public void process(User user){
        System.out.println("Receiver 2 object: " + user);
    }
}
