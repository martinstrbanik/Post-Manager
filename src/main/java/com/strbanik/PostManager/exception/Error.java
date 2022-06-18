package com.strbanik.PostManager.exception;

import lombok.Data;
import org.springframework.http.HttpStatus;

@Data
public class Error {
    private final HttpStatus httpStatus;
    private final String message;
}
