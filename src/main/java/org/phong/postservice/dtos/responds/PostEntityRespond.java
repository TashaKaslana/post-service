package org.phong.postservice.dtos.responds;

import com.fasterxml.jackson.databind.JsonNode;
import org.phong.postservice.enums.PostTypeEnum;
import org.phong.postservice.enums.VisibilityEnum;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.UUID;

/**
 * DTO for {@link org.phong.postservice.infrastructure.persistence.models.PostEntity}
 */
public record PostEntityRespond(LocalDateTime createdAt, LocalDateTime updatedAt, UUID id, UUID authorId, String title,
                                String description, PostTypeEnum postType, VisibilityEnum visibility,
                                JsonNode metadata) implements Serializable {
}