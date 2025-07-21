package com.myorganisation.wearly.exception;

public class UserDoesNotExistException extends RuntimeException {
    public UserDoesNotExistException() {
        super("User doesn't exist.");
    }

    public UserDoesNotExistException(String m) {
        super(m);
    }
}
