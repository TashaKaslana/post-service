package org.phong.postservice.dtos.requests;

import com.fasterxml.jackson.databind.JsonNode;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import org.phong.postservice.annotations.ValidPostMetadata;
import org.phong.postservice.enums.PostTypeEnum;
import org.phong.postservice.enums.VisibilityEnum;
import org.phong.postservice.infrastructure.persistence.models.PostEntity;

import java.io.Serializable;
import java.util.UUID;

/**
 * DTO for {@link PostEntity}
 */
public record PostCreateRequest(@NotNull UUID authorId, @NotNull @NotEmpty @NotBlank String title,
                                @NotNull @NotEmpty @NotBlank String description, @NotNull PostTypeEnum postType,
                                VisibilityEnum visibility,
                                @ValidPostMetadata("postType") @NotNull JsonNode metadata) implements Serializable {
}