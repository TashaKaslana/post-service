package org.phong.postservice.processor;

import com.fasterxml.jackson.databind.JsonNode;
import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;
import org.phong.postservice.annotations.ValidPostMetadata;
import org.phong.postservice.dtos.share.BlogMetadata;
import org.phong.postservice.dtos.share.TwitterMetadata;
import org.phong.postservice.dtos.share.VideoMetadata;
import org.phong.postservice.enums.PostTypeEnum;
import org.phong.postservice.utils.MetadataConverter;

import java.lang.reflect.Field;

public class PostMetadataValidator implements ConstraintValidator<ValidPostMetadata, JsonNode> {
    private String referencedFieldName;

    @Override
    public void initialize(ValidPostMetadata constraintAnnotation) {
        this.referencedFieldName = constraintAnnotation.value();
    }

    @Override
    public boolean isValid(JsonNode jsonNode, ConstraintValidatorContext context) {
        Object targetObject = context.unwrap(Object.class);

        Field referencedField;
        try {
            referencedField = targetObject.getClass().getDeclaredField(referencedFieldName);
        } catch (NoSuchFieldException e) {
            throw new RuntimeException(e);
        }

        referencedField.setAccessible(true);


        try {
            PostTypeEnum referencedValue = (PostTypeEnum) referencedField.get(targetObject);

            return isMatchFormat(referencedValue, jsonNode);
        } catch (IllegalAccessException e) {
            throw new RuntimeException(e);
        }
    }

    private boolean isMatchFormat(PostTypeEnum type, JsonNode value) {
        return switch (type) {
            case PostTypeEnum.VIDEO -> MetadataConverter.isMatchWithMetadata(value, VideoMetadata.class);
            case PostTypeEnum.BLOG -> MetadataConverter.isMatchWithMetadata(value, BlogMetadata.class);
            case TWITTER -> MetadataConverter.isMatchWithMetadata(value, TwitterMetadata.class);

            default -> false;
        };
    }
}
