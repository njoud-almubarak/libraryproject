package com.example.libraryproject.exeption;

public class InvalidId extends RuntimeException {

    public InvalidId(String message) {
        super(message);
    }
}
