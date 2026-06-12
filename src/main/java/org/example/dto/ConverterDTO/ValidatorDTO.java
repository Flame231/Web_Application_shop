package org.example.dto.ConverterDTO;

import org.example.dto.ConverterDTO.ConverterExceptions.AllEmptyFields;
import org.example.dto.ConverterDTO.ConverterExceptions.EmptyField;

import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.Validator;
import javax.validation.ValidatorFactory;
import java.util.Iterator;
import java.util.Set;

public class ValidatorDTO {
    private static final ValidatorFactory factory = Validation.buildDefaultValidatorFactory();
    private static final Validator validator = factory.getValidator();

    public static <T> void validate(T dto) {
        if (dto == null) {
            throw new AllEmptyFields("Данные не переданы!");
        }
        Set<ConstraintViolation<T>> violations = validator.validate(dto);

        if (!violations.isEmpty()) {
            StringBuffer fullMessage = new StringBuffer();
            Iterator<ConstraintViolation<T>> iterator = violations.iterator();
            while(iterator.hasNext()){
                String errorMessage = iterator.next().getMessage();
                fullMessage.append(errorMessage).append(", ");
            }
            throw new EmptyField(fullMessage.toString());
        }
    }
}
