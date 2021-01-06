package com.forcard.core.security.validation;

public class LoggedUserNotFoundException extends RuntimeException {
    public LoggedUserNotFoundException(String message) {
        super(message);
    }

    public LoggedUserNotFoundException() {
    }
}
