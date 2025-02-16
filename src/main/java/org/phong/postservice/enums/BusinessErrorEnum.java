package org.phong.postservice.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum BusinessErrorEnum {
    INVALID_POST_ID("Invalid post ID"),
    POST_NOT_FOUND("Post not found"),
    INVALID_USER_ID("Invalid user ID"),
    USER_NOT_FOUND("User not found"),
    INVALID_COMMENT_ID("Invalid comment ID"),
    COMMENT_NOT_FOUND("Comment not found"),
    CONVERT_ERROR("Error converting data"),
    INTERACTION_NOT_FOUND("Interaction not found"),

    ;


    private final String message;
}
