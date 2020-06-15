package com.devesh.mailsender.api.exceptionhandler;

import com.devesh.mailsender.api.exception.NotFoundException;
import com.devesh.mailsender.api.exception.SaveException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import javax.mail.SendFailedException;

@ControllerAdvice
public class EmailSenderExceptionHandler extends ResponseEntityExceptionHandler {
    @ExceptionHandler(NotFoundException.class)
    public ResponseEntity<String> handleNotFoundException(NotFoundException notFoundException) {
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(notFoundException.getMessage());
    }

    @ExceptionHandler(SendFailedException.class)
    public ResponseEntity<String> handleSendFailedException(SendFailedException sendFailedException) {
        return ResponseEntity.status(HttpStatus.SERVICE_UNAVAILABLE).body("Email could'nt be sent");
    }

    @ExceptionHandler(SaveException.class)
    public ResponseEntity<String> handleSaveException(SaveException saveException) {
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(saveException.getMessage());
    }
}
