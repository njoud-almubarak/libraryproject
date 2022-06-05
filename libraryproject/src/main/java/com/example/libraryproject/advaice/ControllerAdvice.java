package com.example.libraryproject.advaice;

import com.example.libraryproject.DTO.API;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;

public class ControllerAdvice {

    @ExceptionHandler(value = Exception.class)
    public ResponseEntity<API> handleException(Exception exception){
        System.out.println(exception.getMessage());
        return ResponseEntity.status(500).body(new API("SERVER ERROR !",500));
    }

}
