package com.example.demo.exception;

import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.HashMap;
import java.util.Map;

@RestControllerAdvice
public class GlobalException {

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<?> methodArgumentException(MethodArgumentNotValidException ex){
        Map<String,String >map = new HashMap<>();
        for (ObjectError allError : ex.getAllErrors()) {

            String field = ((FieldError) allError).getField();
            String defaultMessage = allError.getDefaultMessage();
            map.put(field,defaultMessage);
        }


        return ResponseEntity.badRequest().body(map);
    }


    @ExceptionHandler(Exception.class)
    public ResponseEntity<?> handleException(Exception ex){
        Map<String,String >map = new HashMap<>();
        map.put("message", ex.getMessage());
        return ResponseEntity.badRequest().body(map);
    }

    @ExceptionHandler(UserNotFound.class)
    public ResponseEntity<?> usernotFound(UserNotFound ex){
        Map<String,String >map = new HashMap<>();
        map.put("message", ex.getMessage());
        return ResponseEntity.badRequest().body(map);
    }
}
