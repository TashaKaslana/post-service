package org.phong.postservice.infrastructure.persistence.repositories;

import org.phong.postservice.infrastructure.persistence.models.PostEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.UUID;

public interface PostRepository extends JpaRepository<PostEntity, UUID> {
    List<PostEntity> findAllByAuthorId(UUID authorId);

    void deleteAllByAuthorId(UUID authorId);
}
