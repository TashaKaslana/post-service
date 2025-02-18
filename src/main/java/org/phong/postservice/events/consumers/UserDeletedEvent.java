package org.phong.postservice.events.consumers;

import java.io.Serializable;
import java.util.UUID;

public record UserDeletedEvent(UUID id) implements Serializable {
}
