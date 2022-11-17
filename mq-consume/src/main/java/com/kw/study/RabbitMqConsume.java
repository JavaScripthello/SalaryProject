package com.kw.study;

import com.rabbitmq.client.*;

import java.io.IOException;
import java.util.concurrent.TimeoutException;

/**
 * @program: SalaryProject
 * @description: 消费者
 * @author: kangwei
 * @create: 2022-10-10 22:29
 **/
public class RabbitMqConsume {

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
        channel.
                queueDeclare("20221010", true, false, false, null);
        Consumer consumer = new DefaultConsumer(channel) {
            @Override
            public void handleDelivery(String consumerTag, Envelope envelope, AMQP.BasicProperties properties, byte[] body) throws IOException {
                super.handleDelivery(consumerTag, envelope, properties, body);
                System.out.println(consumerTag);
                System.out.println(envelope.getExchange());
                System.out.println(envelope.getRoutingKey());
                System.out.println(new String(body));
            }
        };
        channel.basicConsume("20221010", true, consumer);
    }
}
