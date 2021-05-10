package com.example.demo.validation;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class CheckPhoneNumberValidator implements ConstraintValidator<CheckPhoneNumber,String> {
    private Pattern pattern;
    private Matcher matcher;
    public static final String REGEX = "^(0)\\d{9,10}$";


    @Override
    public boolean isValid(String value, ConstraintValidatorContext context) {
        return Pattern.compile(REGEX).matcher(value).matches();
    }
}
