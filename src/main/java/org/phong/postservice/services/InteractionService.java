package org.phong.postservice.services;

import org.phong.postservice.dtos.requests.InteractionCreateRequest;
import org.phong.postservice.dtos.requests.InteractionUpdateRequest;
import org.phong.postservice.dtos.responds.InteractionEntityRespond;
import org.phong.postservice.enums.BusinessErrorEnum;
import org.phong.postservice.exceptions.InteractionNotFoundException;
import org.phong.postservice.infrastructure.mapstruct.InteractionEntityMapper;
import org.phong.postservice.infrastructure.persistence.models.InteractionEntity;
import org.phong.postservice.infrastructure.persistence.models.PostEntity;
import org.phong.postservice.infrastructure.persistence.repositories.InteractionRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
public class InteractionService {
    private final InteractionRepository interactionRepository;
    private final PostService postService;
    private final InteractionEntityMapper interactionEntityMapper;

    public InteractionService(InteractionRepository interactionRepository,
                              PostService postService,
                              InteractionEntityMapper interactionEntityMapper) {
        this.interactionRepository = interactionRepository;
        this.postService = postService;
        this.interactionEntityMapper = interactionEntityMapper;
    }

    public List<InteractionEntityRespond> getAllInteractionsByPostId(UUID postId) {
        List<InteractionEntity> entities = interactionRepository.findAllByPost_Id(postId);

        return entities.stream().map(interactionEntityMapper::toDto2).collect(Collectors.toList());
    }

    public InteractionEntity findInteractionByCompositeKey(UUID postId, UUID userId) {
        InteractionEntity entity = interactionRepository.findByPost_IdAndUserId(postId, userId);

        if (entity == null) {
            throw new InteractionNotFoundException(BusinessErrorEnum.INTERACTION_NOT_FOUND.getMessage());
        }

        return entity;
    }

    public void createInteraction(UUID postId, InteractionCreateRequest request) {
        PostEntity post = postService.findPostById(postId);

        InteractionEntity interaction = interactionEntityMapper.toEntity(request);
        interaction.setPost(post);

        interactionRepository.save(interaction);
    }

    public void deleteInteractionByPostId(UUID postId) {
        interactionRepository.deleteByPost_Id(postId);
    }

    public void deleteInteractionByCompositeKey(UUID postId, UUID userId) {
        interactionRepository.deleteByPost_IdAndUserId(postId, userId);
    }

    public void updateInteraction(UUID postId, UUID userId, InteractionUpdateRequest request) {
        InteractionEntity interaction = findInteractionByCompositeKey(postId, userId);

        InteractionEntity updatedInteraction = interactionEntityMapper.partialUpdate(request, interaction);

        interactionRepository.save(updatedInteraction);
    }
}
