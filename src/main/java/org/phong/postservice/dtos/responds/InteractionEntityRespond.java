package org.phong.postservice.dtos.responds;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.PastOrPresent;
import org.phong.postservice.enums.InteractionTypeEnum;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.UUID;

/**
 * DTO for {@link org.phong.postservice.infrastructure.persistence.models.InteractionEntity}
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public record InteractionEntityRespond(@PastOrPresent LocalDateTime createdAt, @PastOrPresent LocalDateTime updatedAt,
                                       @NotNull UUID userId,
                                       @NotNull InteractionTypeEnum interactionType) implements Serializable {
}