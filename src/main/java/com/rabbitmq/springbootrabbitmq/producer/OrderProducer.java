package com.rabbitmq.springbootrabbitmq.producer;

import com.rabbitmq.springbootrabbitmq.dto.Order;
import com.rabbitmq.springbootrabbitmq.dto.OrderStatus;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RestController
@RequestMapping("/order")
public class OrderProducer {

    @Value("${sr.rabbit.routing.name}")
    private String routingName;

    @Value("${sr.rabbit.exchange.name}")
    private String exchangeName;

    @Autowired
    private RabbitTemplate template;

    @PostMapping("/{restaurantName}")
    public String orderFood(@RequestBody Order order, @PathVariable String restaurantName){
        order.setOrderId(UUID.randomUUID().toString());
        OrderStatus orderStatus = new OrderStatus(order,"PROCESS","order placed successfully in " + restaurantName);
        sendToQueue(orderStatus);
        return "Success !!";
    }

    public void sendToQueue(OrderStatus orderStatus){
        System.out.println("Order Sent ID : " + orderStatus.getOrder().getOrderId());
        template.convertAndSend(exchangeName, routingName, orderStatus);
    }
}
