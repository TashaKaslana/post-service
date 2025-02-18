package org.phong.postservice.events.producers;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.databind.JsonNode;
import jakarta.validation.constraints.NotNull;
import org.phong.postservice.events.share.PublishableEvent;

import java.io.Serializable;
import java.util.UUID;

/**
 * DTO for {@link org.phong.postservice.infrastructure.persistence.models.PostEntity}
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public record PostDeletedEvent(@NotNull UUID id, @NotNull UUID authorId, JsonNode metadata) implements Serializable, PublishableEvent {
}