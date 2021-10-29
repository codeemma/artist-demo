package com.example.artistservice.exception;

public class CancellationException extends RuntimeException {

    private static final String DEFAULT_MESSAGE = "can only cancel payment on same day";

    public CancellationException() {
        this(DEFAULT_MESSAGE);
    }

    public CancellationException(String message) {
        super(message);
    }
}
