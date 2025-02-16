package org.phong.postservice.controllers;

import jakarta.validation.Valid;
import org.phong.postservice.dtos.requests.InteractionCreateRequest;
import org.phong.postservice.dtos.requests.InteractionUpdateRequest;
import org.phong.postservice.dtos.responds.InteractionEntityRespond;
import org.phong.postservice.services.InteractionService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/api/posts")
public class InteractionController {

    private final InteractionService interactionService;

    public InteractionController(InteractionService interactionService) {
        this.interactionService = interactionService;
    }

    @GetMapping("/{postId}/interactions")
    public ResponseEntity<List<InteractionEntityRespond>> getInteractionsByPostId(@PathVariable UUID postId) {
        return ResponseEntity.ok().body(interactionService.getAllInteractionsByPostId(postId));
    }

    @PostMapping("/{postId}/interactions")
    public ResponseEntity<Void> createInteraction(@PathVariable UUID postId,
                                                  @Valid @RequestBody InteractionCreateRequest request) {
        interactionService.createInteraction(postId, request);
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }

    @DeleteMapping("/{postId}/interactions/user/{userId}")
    public ResponseEntity<Void> deleteInteractionByCompositeKey(
            @PathVariable UUID postId,
            @PathVariable UUID userId) {
        interactionService.deleteInteractionByCompositeKey(postId, userId);
        return ResponseEntity.noContent().build();
    }

    @DeleteMapping("/{postId}/interactions")
    public ResponseEntity<Void> deleteAllInteractionsByPostId(@PathVariable UUID postId) {
        interactionService.deleteInteractionByPostId(postId);
        return ResponseEntity.noContent().build();
    }

    @PutMapping("/{postId}/interactions/{userId}")
    public ResponseEntity<Void> updateInteraction(@PathVariable UUID postId,
                                                  @PathVariable UUID userId,
                                                  @Valid @RequestBody InteractionUpdateRequest request) {
        interactionService.updateInteraction(postId, userId, request);
        return ResponseEntity.noContent().build();
    }
}