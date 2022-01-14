package com.hq.rabbit.controller;

import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;
import com.rabbitmq.client.ConnectionFactory;

import java.io.IOException;
import java.util.concurrent.TimeoutException;

/**
 * @author lichaojie
 * @date 2022/1/14 9:27
 * @ClassName Producer
 **/
public class Producer {
    public static void main(String[] args) throws IOException, TimeoutException {
        //创建连接工厂
        ConnectionFactory factory = new ConnectionFactory();
        factory.setUsername("testmq");
        factory.setPassword("testmq");
        //设置 RabbitMQ 地址
        factory.setHost("110.42.180.4");
        //建立到代理服务器到连接（TCP连接）
        Connection conn = factory.newConnection();
        //获得信道（信道复用TCP连接）
        Channel channel = conn.createChannel();
        //声明交换器
        String exchangeName = "amq.topic";
        channel.exchangeDeclare(exchangeName, "topic", true);   // "direct"将消息保存到队列的方式

        String routingKey = "hola";
        //发布消息
        byte[] messageBodyBytes = "quit".getBytes();
        channel.basicPublish(exchangeName, routingKey, null, messageBodyBytes);

        channel.close();
        conn.close();
    }
}
