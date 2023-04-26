package com.rabbitmq.springbootrabbitmq.consumer;

import com.rabbitmq.springbootrabbitmq.dto.OrderStatus;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Service;

@Service
public class OrderConsumer {

   @RabbitListener(queues = "${sr.rabbit.queue.name")


    public void consumeMessageFromQueue(OrderStatus orderStatus){
        System.out.println("Message received from queue " + orderStatus);
    }
}
