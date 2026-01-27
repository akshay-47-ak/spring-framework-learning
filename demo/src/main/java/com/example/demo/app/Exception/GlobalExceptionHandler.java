package com.example.demo.app.Exception;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.HttpRequestMethodNotSupportedException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Map;

@RestControllerAdvice
public class GlobalExceptionHandler {


    Logger logger = LoggerFactory.getLogger(GlobalExceptionHandler.class);

    @ExceptionHandler({UserNotFoundException.class,IllegalArgumentException.class,NullPointerException.class})
    public ResponseEntity<Map<String,Object>> IllegalArgumentException(
            Exception exception
    ){
        logger.error("Error find when finding user",exception);
        Map<String,Object> errorResponse  = new HashMap<>();

        errorResponse.put("timeStamp", LocalDateTime.now());
        errorResponse.put("status", HttpStatus.BAD_REQUEST);
        errorResponse.put("error","Bad Request");
        errorResponse.put("message",exception.getMessage());
        return new ResponseEntity<>(errorResponse, HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(HttpRequestMethodNotSupportedException.class)
    public ResponseEntity<Map<String,Object>> handleMethodSupport(
            Exception exception
    ){
        Map<String,Object> errorResponse = new HashMap<>();

        errorResponse.put("timeStamp", LocalDateTime.now());
        errorResponse.put("status", HttpStatus.BAD_REQUEST);
        errorResponse.put("error","The Method Not Allowed At This End Point");
        errorResponse.put("message",exception.getMessage());

        return new ResponseEntity<>(errorResponse,HttpStatus.BAD_REQUEST);
    }




}
