package org.phong.postservice.infrastructure.persistence.repositories;

import org.phong.postservice.infrastructure.persistence.models.InteractionEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.UUID;

public interface InteractionRepository extends JpaRepository<InteractionEntity, UUID> {
    InteractionEntity findByPost_IdAndUserId(UUID postId, UUID userId);

    void deleteByPost_Id(UUID postId);

    void deleteByPost_IdAndUserId(UUID postId, UUID userId);

    List<InteractionEntity> findAllByPost_Id(UUID postId);
}
