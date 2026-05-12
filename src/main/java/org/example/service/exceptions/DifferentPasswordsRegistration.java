package org.example.service.exceptions;

public class DifferentPasswordsRegistration extends RuntimeException {
    public DifferentPasswordsRegistration(String message) {
        super(message);
    }
}
