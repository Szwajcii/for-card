package com.forcard.core.security.validation;

import com.forcard.api.rest.request.SignupRequest;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class PasswordMatchesValidator implements ConstraintValidator<PasswordMatcher, Object> {

    @Override
    public void initialize(PasswordMatcher constraintAnnotation) {
        // init
    }

    @Override
    public boolean isValid(Object obj, ConstraintValidatorContext constraintValidatorContext) {
        if (obj instanceof SignupRequest) {
            SignupRequest signupRequest = (SignupRequest) obj;
            return signupRequest.getPassword().equals(signupRequest.getRePassword());
        }
        return false;
    }
}
