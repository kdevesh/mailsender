package com.devesh.mailsender.api.exception;

public class CustomException extends RuntimeException {
    public CustomException() {
    }

    public CustomException(String message) {
        super(message);
    }

    public CustomException(String message, Throwable cause) {

        super(message, cause);
    }
}
