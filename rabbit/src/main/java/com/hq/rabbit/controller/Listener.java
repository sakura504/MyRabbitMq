package com.hq.rabbit.controller;

import org.springframework.amqp.core.ExchangeTypes;
import org.springframework.amqp.rabbit.annotation.Exchange;
import org.springframework.amqp.rabbit.annotation.Queue;
import org.springframework.amqp.rabbit.annotation.QueueBinding;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

/**
 * @author lichaojie
 * @date 2022/1/14 15:59
 * @ClassName Listener
 **/

@Component
public class Listener {

    @RabbitListener(bindings = @QueueBinding(
            value = @Queue(value = "testQueue", durable = "true"),
            exchange = @Exchange(
                    value = "amq.topic",
                    ignoreDeclarationExceptions = "true",
                    type = ExchangeTypes.TOPIC
            ),
            key = {"#.#"}))
    public void listen(String msg){
        System.out.println("接收到消息：" + msg);
    }
}