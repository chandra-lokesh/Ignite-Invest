package com.personalproject.exceptions;

public class AlreadyExistingException extends RuntimeException {
    public AlreadyExistingException(String message) {
        super(message);
    }
}
