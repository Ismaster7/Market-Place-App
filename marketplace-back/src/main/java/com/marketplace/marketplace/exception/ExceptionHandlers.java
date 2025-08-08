package com.marketplace.marketplace.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;

import java.util.Date;

@ControllerAdvice
public class ExceptionHandlers {

    @ExceptionHandler(ResourceNotFound.class)
    public ResponseEntity<ExceptionResponse> resourceNotFound(ResourceNotFound exception, WebRequest request){
        ExceptionResponse exceptionResponse = new ExceptionResponse(
                exception.getMessage(), new Date(), request.getDescription(false)
        );
        return new ResponseEntity<>(exceptionResponse, HttpStatus.NOT_FOUND );
    }

    @ExceptionHandler(RequiredObjectIsNull.class)
    public ResponseEntity<ExceptionResponse> requiredObjectIsNull(RequiredObjectIsNull exception, WebRequest request){
        ExceptionResponse exceptionResponse = new ExceptionResponse(
                exception.getMessage(), new Date(), request.getDescription(false)
        );
        return new ResponseEntity<>(exceptionResponse, HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(ProductNotFound.class)
    public ResponseEntity<ExceptionResponse> productNotFoundException(ProductNotFound exception, WebRequest request){
        return new ResponseEntity<>(new ExceptionResponse(
                exception.getMessage(), new Date(), request.getDescription(false)
        ), HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<ExceptionResponse> validationError (MethodArgumentNotValidException exception, WebRequest request){
        return new ResponseEntity<>(new ExceptionResponse(
                exception.getMessage(), new Date(), request.getDescription(false)
        ), HttpStatus.BAD_REQUEST);
    }
}
