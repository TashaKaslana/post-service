package org.phong.postservice.annotations;

import jakarta.validation.Constraint;
import jakarta.validation.Payload;
import org.phong.postservice.processor.PostMetadataValidator;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Constraint(validatedBy = PostMetadataValidator.class)
@Target({ElementType.TYPE})
@Retention(RetentionPolicy.RUNTIME)
public @interface ValidPostMetadata {
    String message() default "Invalid metadata";
    Class<?>[] groups() default {};
    Class<? extends Payload>[] payload() default {};
}
