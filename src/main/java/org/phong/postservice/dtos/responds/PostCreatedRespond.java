package org.phong.postservice.dtos.responds;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.validation.constraints.NotNull;

import java.io.Serializable;
import java.util.UUID;

/**
 * DTO for {@link org.phong.postservice.infrastructure.persistence.models.PostEntity}
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public record PostCreatedRespond(@NotNull UUID id) implements Serializable {
}