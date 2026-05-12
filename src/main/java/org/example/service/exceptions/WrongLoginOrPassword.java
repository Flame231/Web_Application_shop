package org.example.service.exceptions;

public class WrongLoginOrPassword extends RuntimeException {
    public WrongLoginOrPassword(String message) {
        super(message);
    }
}
