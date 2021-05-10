package com.example.demo.validation;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.Retention;
import java.lang.annotation.Target;

import static java.lang.annotation.ElementType.FIELD;
import static java.lang.annotation.ElementType.METHOD;
import static java.lang.annotation.RetentionPolicy.RUNTIME;

@Constraint(validatedBy = CheckPhoneNumberValidator.class)
@Retention(RUNTIME)
@Target({FIELD, METHOD})
public @interface CheckPhoneNumber {

    String message() default "Bắt đầu bằng số 0\n" +
            "Có độ dài từ 10 -11 ký tự\n" +
            "Chỉ bao gồm số";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};
}

