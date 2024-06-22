package com.rating_backend.rating.exception;

import org.springframework.http.ResponseEntity;

public class ResponseNotFoundException extends RuntimeException{

    public ResponseNotFoundException() {
        super("Resource not found");
    }

    public ResponseNotFoundException(String message) {
        super(message);
    }
}
