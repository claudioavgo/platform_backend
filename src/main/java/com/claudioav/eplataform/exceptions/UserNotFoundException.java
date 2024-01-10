package com.claudioav.eplataform.exceptions;

public class UserNotFoundException extends RuntimeException {
    public UserNotFoundException() {
        super("User not registered.");
    }

    public UserNotFoundException(String message) {
        super(message);
    }
}
