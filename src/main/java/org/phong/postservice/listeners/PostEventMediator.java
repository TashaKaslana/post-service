//package org.phong.postservice.listeners;
//
//import org.phong.postservice.events.producers.PostDeletedEvent;
//import org.phong.postservice.events.producers.PostListDeletedEvent;
//import org.phong.postservice.infrastructure.rabbitmq.RabbitMQPublisher;
//import org.springframework.scheduling.annotation.Async;
//import org.springframework.stereotype.Component;
//import org.springframework.transaction.event.TransactionalEventListener;
//
//@Component
//public class PostEventMediator {
//    private final RabbitMQPublisher rabbitMQPublisher;
//
//    public PostEventMediator(RabbitMQPublisher rabbitMQPublisher) {
//        this.rabbitMQPublisher = rabbitMQPublisher;
//    }
//
//    @Async
//    @TransactionalEventListener
//    public void handlePostDeletedEvent(PostDeletedEvent event) {
//        rabbitMQPublisher.sendMessage("interaction.deleted", event);
//    }
//
//    @Async
//    @TransactionalEventListener
//    public void handlePostListDeleteEvent(PostListDeletedEvent event) {
//        rabbitMQPublisher.sendMessage("interaction.updated", event);
//    }
//}
