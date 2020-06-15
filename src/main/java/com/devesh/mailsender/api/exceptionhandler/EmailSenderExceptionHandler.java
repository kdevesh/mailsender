package com.devesh.mailsender.api.exceptionhandler;

import com.devesh.mailsender.api.exception.CustomException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import javax.mail.SendFailedException;

@ControllerAdvice
public class EmailSenderExceptionHandler extends ResponseEntityExceptionHandler {
    @ExceptionHandler(CustomException.class)
    public ResponseEntity<String> handle(CustomException customException) {
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(customException.getMessage());
    }

    @ExceptionHandler(SendFailedException.class)
    public ResponseEntity<String> handleSendFailedException(SendFailedException sendFailedException) {
        return ResponseEntity.status(HttpStatus.SERVICE_UNAVAILABLE).body("Email could'nt be sent");
    }
}
