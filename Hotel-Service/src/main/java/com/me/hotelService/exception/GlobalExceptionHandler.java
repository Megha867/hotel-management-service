package com.me.hotelService.exception;

import jakarta.validation.ConstraintViolationException;
import jakarta.ws.rs.BadRequestException;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.HashMap;
import java.util.Map;

@RestControllerAdvice
public class GlobalExceptionHandler extends RuntimeException {

    @ExceptionHandler(MethodArgumentNotValidException.class)
    Map<String, String> handleInvalidMethodArgumentException(MethodArgumentNotValidException exception) {

        Map<String, String> errors = new HashMap<>();

        exception.getBindingResult().getFieldErrors().forEach(error ->
                errors.put(error.getField(), error.getDefaultMessage()));

        return errors;
    }

    @ExceptionHandler(ConstraintViolationException.class)
    Map<String, String> handleValidationExceptions(ConstraintViolationException exception) {

        Map<String, String> errors = new HashMap<>();

        exception.getConstraintViolations().forEach(error->
                errors.put(error.getPropertyPath().toString(), error.getMessage()));

        return  errors;
    }
}
