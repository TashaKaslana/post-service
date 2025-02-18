package org.phong.postservice.listeners;

import org.phong.postservice.events.producers.PostDeletedEvent;
import org.phong.postservice.events.producers.PostListDeletedEvent;
import org.phong.postservice.services.InteractionService;
import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

@RabbitListener(queues = "post_interaction_queue")
@Component
public class InteractionEventListener {
    private final InteractionService interactionService;

    public InteractionEventListener(InteractionService interactionService) {
        this.interactionService = interactionService;
    }

    @RabbitHandler
    public void handleDeleteInteractionOfPost(PostDeletedEvent event) {
        interactionService.deleteInteractionByPostId(event.id());
    }

    @RabbitHandler
    public void handleDeleteInteractionOfPostList(PostListDeletedEvent event) {
        interactionService.deleteInteractionsByPostIdList(event.postIdList());
    }
}
