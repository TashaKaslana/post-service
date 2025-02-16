package org.phong.postservice.dtos.requests;

import org.phong.postservice.enums.VisibilityEnum;

import java.io.Serializable;

/**
 * DTO for {@link org.phong.postservice.infrastructure.persistence.models.PostEntity}
 */
public record PostSurfaceUpdateRequest(String title, String description,
                                       VisibilityEnum visibility) implements Serializable {
}