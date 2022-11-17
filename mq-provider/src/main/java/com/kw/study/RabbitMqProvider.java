package com.kw.study;

import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;
import com.rabbitmq.client.ConnectionFactory;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.concurrent.TimeoutException;

/**
 * @program: SalaryProject
 * @description: mq生产者
 * @author: kangwei
 * @create: 2022-10-10 22:14
 **/
public class RabbitMqProvider {
    public static void main(String[] args) throws IOException, TimeoutException {

        //创建连接工厂
        ConnectionFactory connectionFactory = new ConnectionFactory();
        //设置参数
        connectionFactory.setHost("192.168.200.100");
        connectionFactory.setPort(5672);
        connectionFactory.setUsername("rabbit");
        connectionFactory.setPassword("123456");
        connectionFactory.setVirtualHost("/");

        //创建连接
        Connection connection = connectionFactory.newConnection();
        //创建渠道
        Channel channel = connection.createChannel();
        channel.queueDeclare("20221010", true, false, false, null);
        channel.basicPublish("", "20221010", null, new String("你好").getBytes(StandardCharsets.UTF_8));
        //关闭资源
        channel.close();
        connection.close();
    }
}
