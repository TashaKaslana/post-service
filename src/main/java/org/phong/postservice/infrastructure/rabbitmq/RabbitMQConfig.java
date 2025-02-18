package org.phong.postservice.infrastructure.rabbitmq;

import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.Queue;
import org.springframework.amqp.core.TopicExchange;
import org.springframework.amqp.support.converter.Jackson2JsonMessageConverter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class RabbitMQConfig {
    private static final String QUEUE_NAME = "post_queue";
    private static final String EXCHANGE_NAME = "post_exchange";

    @Bean
    public Jackson2JsonMessageConverter jackson2JsonMessageConverter() {
        return new Jackson2JsonMessageConverter();
    }

    @Bean
    public Queue postQueue() {
        return new Queue(QUEUE_NAME, true);
    }

    @Bean
    public Queue interactionQueue() {
        return new Queue("post_interaction_queue", true);
    }

    @Bean
    public TopicExchange postExchange() {
        return new TopicExchange(EXCHANGE_NAME);
    }

    @Bean
    public Binding postBinding(Queue postQueue, TopicExchange postExchange) {
        return BindingBuilder.bind(postQueue).to(postExchange).with("post.#");
    }

    @Bean
    public Binding interactionBinding(Queue interactionQueue, TopicExchange postExchange) {
        return BindingBuilder.bind(interactionQueue).to(postExchange).with("interaction.#");
    }
}
