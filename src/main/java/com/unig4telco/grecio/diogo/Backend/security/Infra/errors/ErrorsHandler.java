package com.unig4telco.grecio.diogo.Backend.security.Infra.errors;

import jakarta.persistence.EntityNotFoundException;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class ErrorsHandler {
    @ExceptionHandler(EntityNotFoundException.class)
    public ResponseEntity<?> Error404 () {
        return ResponseEntity.notFound().build();
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<?> Error400 (MethodArgumentNotValidException ex) {
        var errors_ = ex.getFieldErrors();
        return ResponseEntity.badRequest().body(errors_.stream().map(ErrorsDetail::new).toList());
    }

    public record ErrorsDetail(String field, String message){
        public ErrorsDetail(FieldError fieldError) {
            this(fieldError.getField(), fieldError.getDefaultMessage());
        }
    }

}
