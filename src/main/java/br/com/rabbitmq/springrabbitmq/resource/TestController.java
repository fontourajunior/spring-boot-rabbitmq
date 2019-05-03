package br.com.rabbitmq.springrabbitmq.resource;

import static org.springframework.http.HttpStatus.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import br.com.rabbitmq.springrabbitmq.service.OrderQueueSender;

@RestController
@RequestMapping(path = "messages")
public class TestController {

    private final OrderQueueSender orderQueueSender;

    @Autowired
    public TestController(OrderQueueSender orderQueueSender) {
        this.orderQueueSender = orderQueueSender;
    }

    @GetMapping
    @ResponseStatus(code = OK)
    public void sendMessage() {
        orderQueueSender.send("test ....");
    }

}
