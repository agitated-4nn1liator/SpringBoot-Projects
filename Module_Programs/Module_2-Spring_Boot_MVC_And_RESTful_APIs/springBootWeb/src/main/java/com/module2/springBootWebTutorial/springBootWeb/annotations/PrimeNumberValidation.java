package com.module2.springBootWebTutorial.springBootWeb.annotations;

import jakarta.validation.Constraint;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Retention(RetentionPolicy.RUNTIME)
@Target({ElementType.FIELD, ElementType.PARAMETER})
@Constraint(validatedBy = PrimeNumberValidator.class)
public @interface PrimeNumberValidation {
    String message() default "Number must be prime";
    Class<?>[] groups() default {};
    Class<? extends java.lang.annotation.Annotation>[] payload() default {};
}
