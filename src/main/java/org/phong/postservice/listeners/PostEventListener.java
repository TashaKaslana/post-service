package org.phong.postservice.listeners;

import org.phong.postservice.events.consumers.UserDeletedEvent;
import org.phong.postservice.services.PostService;
import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

@RabbitListener(queues = "post_queue")
@Component
public class PostEventListener {
    private final PostService postService;

    public PostEventListener(PostService postService) {
        this.postService = postService;
    }

    @RabbitHandler
    public void handleDeletePostsOfUser(UserDeletedEvent event) {
        postService.deletePostsByAuthorId(event.id());
    }
}
