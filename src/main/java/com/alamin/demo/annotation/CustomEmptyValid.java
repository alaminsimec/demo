package com.alamin.demo.annotation;

import jakarta.validation.Constraint;
import jakarta.validation.Payload;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target({ElementType.FIELD})
@Retention(RetentionPolicy.RUNTIME)
@Constraint(validatedBy = CustomEmptyValidator.class)
public @interface CustomEmptyValid {
    String message() default "Can not be empty.";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};
}
