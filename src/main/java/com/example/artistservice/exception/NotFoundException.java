package com.example.artistservice.exception;

public class NotFoundException extends RuntimeException {

    public NotFoundException(String statusText) {
        super(statusText);
    }
}
