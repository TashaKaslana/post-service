package org.phong.postservice.dtos.requests;

import com.fasterxml.jackson.databind.JsonNode;
import jakarta.validation.constraints.NotNull;
import org.phong.postservice.annotations.ValidPostMetadata;
import org.phong.postservice.enums.PostTypeEnum;

import java.io.Serializable;

/**
 * DTO for {@link org.phong.postservice.infrastructure.persistence.models.PostEntity}
 */
public record PostMetadataUpdateRequest(@NotNull PostTypeEnum postType,
                                        @ValidPostMetadata("postType") @NotNull JsonNode metadata) implements Serializable {
}