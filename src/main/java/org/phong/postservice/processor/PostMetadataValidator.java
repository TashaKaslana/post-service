package org.phong.postservice.processor;

import com.fasterxml.jackson.databind.JsonNode;
import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;
import org.phong.postservice.annotations.ValidPostMetadata;
import org.phong.postservice.dtos.requests.PostCreateRequest;
import org.phong.postservice.dtos.share.BlogMetadata;
import org.phong.postservice.dtos.share.TwitterMetadata;
import org.phong.postservice.dtos.share.VideoMetadata;
import org.phong.postservice.enums.PostTypeEnum;
import org.phong.postservice.utils.MetadataConverter;

public class PostMetadataValidator implements ConstraintValidator<ValidPostMetadata, PostCreateRequest> {

    @Override
    public boolean isValid(PostCreateRequest request, ConstraintValidatorContext context) {
        if (request == null || request.postType() == null || request.metadata() == null) {
            return false;
        }

        return isMatchFormat(request.postType(), request.metadata());
    }

    private boolean isMatchFormat(PostTypeEnum type, JsonNode value) {
        return switch (type) {
            case VIDEO -> MetadataConverter.isMatchWithMetadata(value, VideoMetadata.class);
            case BLOG -> MetadataConverter.isMatchWithMetadata(value, BlogMetadata.class);
            case TWITTER -> MetadataConverter.isMatchWithMetadata(value, TwitterMetadata.class);
            default -> false;
        };
    }
}
