package org.phong.postservice.infrastructure.rabbitmq;

import org.phong.postservice.events.share.PublishableEvent;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.stereotype.Component;

@Component
public class RabbitMQPublisher {
    private final RabbitTemplate rabbitTemplate;
    private static final String exchange = "post_exchange";

    public RabbitMQPublisher(RabbitTemplate rabbitTemplate) {
        this.rabbitTemplate = rabbitTemplate;
    }

    public <T extends PublishableEvent> void sendMessage(String routingKey, T message) {
        rabbitTemplate.convertAndSend(exchange, routingKey, message);
    }
}
