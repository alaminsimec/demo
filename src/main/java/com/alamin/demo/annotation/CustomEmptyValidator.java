package com.alamin.demo.annotation;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

public class CustomEmptyValidator implements ConstraintValidator<CustomEmptyValid, String> {
//    @Override
//    public void initialize(CustomEmptyValid constraintAnnotation) {
//    }

    @Override
    public boolean isValid(String s, ConstraintValidatorContext constraintValidatorContext) {
        return s != null && !s.isBlank();
    }
}
