package com.example.microservices.controller;

import com.example.microservices.controller.dto.GeneralError;
import com.example.microservices.dao.exception.UserDaoException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;

@ControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(UserDaoException.class)
    public ResponseEntity<GeneralError> handle(Exception e, WebRequest request) {
        return new ResponseEntity<>(new GeneralError(e.getMessage()), HttpStatus.BAD_REQUEST);
    }
}
