package com.personalproject.exceptions;

public class InvestorNotFound extends RuntimeException {
    public InvestorNotFound(String message) {
        super(message);
    }
}
