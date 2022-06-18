package com.strbanik.PostManager.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class ApplicationExceptionHandler {
    @ExceptionHandler(GenericException.class)
    public ResponseEntity<Error> handleException(GenericException e) {
        Error error = new Error(HttpStatus.BAD_REQUEST, e.getLocalizedMessage());
        return new ResponseEntity<>(error, error.getHttpStatus());
    }
}
