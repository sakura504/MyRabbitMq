package com.hq.rabbit.controller;

import org.junit.Test;
import org.springframework.amqp.core.AmqpTemplate;

import javax.annotation.Resource;

/**
 * @author lichaojie
 * @date 2022/1/14 16:01
 * @ClassName RabbitController
 **/
public class RabbitController {

    @Resource
    private AmqpTemplate amqpTemplate;

    @Test
    public void testSend() throws InterruptedException {
        String msg = "hello, Spring boot amqp";
        this.amqpTemplate.convertAndSend("amq.topic","hola", msg);
        // 等待10秒后再结束
        Thread.sleep(10000);
    }

}
