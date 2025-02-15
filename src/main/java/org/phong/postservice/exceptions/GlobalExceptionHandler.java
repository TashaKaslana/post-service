package org.phong.postservice.exceptions;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class GlobalExceptionHandler {
    @ExceptionHandler(Exception.class)
    public ResponseEntity<ErrorMessage> handleGlobalException(Exception ex) {
        ErrorMessage errorMessage = new ErrorMessage(ex.getMessage(), 500);

        System.err.println("An error occurred: " + errorMessage.getMessage());
        ex.printStackTrace();
        return ResponseEntity.status(errorMessage.getStatusCode()).body(errorMessage);
    }

    @ExceptionHandler(PostNotFoundException.class)
    public ResponseEntity<ErrorMessage> handlePostNotFoundException(PostNotFoundException ex) {
        ErrorMessage errorMessage = new ErrorMessage(ex.getMessage(), 404);

        System.err.println("Post not found: " + errorMessage.getMessage());

        return ResponseEntity.status(errorMessage.getStatusCode()).body(errorMessage);
    }
}
