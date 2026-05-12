package org.example.service.exceptions;

public class WrongPassword extends RuntimeException {
    public WrongPassword(String message) {
        super(message);
    }
}
