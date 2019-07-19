package com.shuoyi.message;

import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

/**
 * Created by zhaosy-c on 2019/7/19.
 */
@Component
@RabbitListener(queues = "api-gccs-notify")
public class Receiver {

    @RabbitHandler
    public void process(String hello){
        System.out.println("Receiver " + hello);
    }
}
