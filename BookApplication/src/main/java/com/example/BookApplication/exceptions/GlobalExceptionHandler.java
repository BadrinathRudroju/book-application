package com.example.BookApplication.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Map;

@ControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(BookNotFoundException.class)
    public ResponseEntity<Map<String , Object>>
          BookNotFoundException(BookNotFoundException ex, WebRequest request){
        Map<String, Object> map = new HashMap<>();

        map.put("message", ex.getMessage());
        map.put("timestamp", LocalDateTime.now());
        map.put("path", request.getDescription(false)
                .replace("uri" , ""));
        return new ResponseEntity<>(map, HttpStatus.NOT_FOUND);
    }
}
