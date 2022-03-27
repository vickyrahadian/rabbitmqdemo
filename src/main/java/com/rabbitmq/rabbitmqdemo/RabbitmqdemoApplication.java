package com.rabbitmq.rabbitmqdemo;

import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class RabbitmqdemoApplication implements CommandLineRunner {

    @Autowired
    private RabbitTemplate rabbitTemplate;

    public static void main(String[] args) {
        SpringApplication.run(RabbitmqdemoApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
//        rabbitTemplate.convertAndSend("Hello From Our First Message");
//        rabbitTemplate.convertAndSend("testExchange", "testRouting", "Hello From Code!");

        SimpleMessage simpleMessage = new SimpleMessage("First Message", "Simple Description");
        rabbitTemplate.convertAndSend("MyTopicExchange", "topic", simpleMessage);
    }
}
