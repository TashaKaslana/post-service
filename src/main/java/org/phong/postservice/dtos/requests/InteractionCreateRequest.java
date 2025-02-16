package org.phong.postservice.dtos.requests;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.validation.constraints.NotNull;
import org.phong.postservice.enums.InteractionTypeEnum;

import java.io.Serializable;
import java.util.UUID;

/**
 * DTO for {@link org.phong.postservice.infrastructure.persistence.models.InteractionEntity}
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public record InteractionCreateRequest(@NotNull UUID userId,
                                       @NotNull InteractionTypeEnum interactionType) implements Serializable {
}