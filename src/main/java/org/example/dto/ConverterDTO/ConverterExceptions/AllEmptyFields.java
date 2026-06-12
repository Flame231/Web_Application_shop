package org.example.dto.ConverterDTO.ConverterExceptions;

public class AllEmptyFields extends RuntimeException {
    public AllEmptyFields(String message) {
        super(message);
    }
}
