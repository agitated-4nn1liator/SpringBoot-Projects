package com.module2.springBootWebTutorial.springBootWeb.annotations;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

public class PasswordValidator implements ConstraintValidator<PasswordValidation, String> {
    @Override
    public boolean isValid(String pass, ConstraintValidatorContext constraintValidatorContext) {
        if(pass.length() < 10) return false;

        return pass.matches(".*[A-Z].*") && pass.matches(".*[a-z].*") && pass.matches(".*[!@#$%^&*()].*");
    }
}
