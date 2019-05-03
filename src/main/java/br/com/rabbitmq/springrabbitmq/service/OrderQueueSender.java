package br.com.rabbitmq.springrabbitmq.service;

import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.rabbitmq.springrabbitmq.config.RabbitConfig;

@Service
public class OrderQueueSender {

    private final RabbitTemplate rabbitTemplate;

    @Autowired
    public OrderQueueSender(RabbitTemplate rabbitTemplate) {
        this.rabbitTemplate = rabbitTemplate;
    }

    public void send(String order) {
        this.rabbitTemplate.convertAndSend(RabbitConfig.QUEUE_ORDERS, order);
    }
}
