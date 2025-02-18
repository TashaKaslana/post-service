package org.phong.postservice.events.producers;

import org.phong.postservice.events.share.PublishableEvent;

import java.io.Serializable;
import java.util.List;
import java.util.UUID;

public record PostListDeletedEvent(List<UUID> postIdList) implements Serializable, PublishableEvent {
}
