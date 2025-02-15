package org.phong.postservice.exceptions;

import lombok.Getter;

import java.time.LocalDateTime;

@Getter
public class ErrorMessage {
    private final String message;
    private final int statusCode;
    private final LocalDateTime timestamp;

    public ErrorMessage(String message, int statusCode) {
        this.message = message;
        this.statusCode = statusCode;
        this.timestamp = LocalDateTime.now();
    }
}
