package br.com.rabbitmq.springrabbitmq.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

import br.com.rabbitmq.springrabbitmq.config.RabbitConfig;

@Component
public class OrderConsumer {

    static final Logger logger = LoggerFactory.getLogger(OrderConsumer.class);

    @RabbitListener(queues = RabbitConfig.QUEUE_ORDERS)
    public void receiveMessage(String message) {
        logger.info("Consumer -> " + message);
    }

}
