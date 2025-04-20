package com.example.exception;

import jakarta.persistence.EntityNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@ControllerAdvice
public class ApiExceptionHandler {

    @ExceptionHandler(value = ResourceNotFoundException.class)
    public ResponseEntity<Object> ResourceNotFoundException(ResourceNotFoundException e) {
        RequestException requestException = new RequestException(
                e.getMessage(),
                e,
                HttpStatus.NOT_FOUND
        );
        return new ResponseEntity<>(requestException, HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(value = EntityNotFoundException.class)
    public ResponseEntity<Object> EntityNotFoundException(EntityNotFoundException e) {
        RequestException requestException = new RequestException(
                e.getMessage(),
                e,
                HttpStatus.NOT_FOUND
        );
        return new ResponseEntity<>(requestException, HttpStatus.NOT_FOUND);
    }

}
