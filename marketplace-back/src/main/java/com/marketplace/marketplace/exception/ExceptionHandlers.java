package com.marketplace.marketplace.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;

import java.util.Date;

@ControllerAdvice
public class ExceptionHandlers {

    @ExceptionHandler(ResourceNotFound.class)
    public ResponseEntity<ExceptionResponse> resourceNotFound(Exception exception, WebRequest request){
        ExceptionResponse exceptionResponse = new ExceptionResponse(
                exception.getMessage(), new Date(), request.getDescription(false)
        );
        return new ResponseEntity<>(exceptionResponse, HttpStatus.NOT_FOUND );
    }

    @ExceptionHandler(RequiredObjectIsNull.class)
    public ResponseEntity<ExceptionResponse> requiredObjectIsNull(Exception exception, WebRequest request){
        ExceptionResponse exceptionResponse = new ExceptionResponse(
                exception.getMessage(), new Date(), request.getDescription(false)
        );
        return new ResponseEntity<>(exceptionResponse, HttpStatus.BAD_REQUEST);
    }
}
