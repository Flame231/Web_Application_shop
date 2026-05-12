package org.example.service.exceptions;

public class DifferentPasswordsUpdate extends RuntimeException {
    public DifferentPasswordsUpdate(String message) {
        super(message);
    }
}
