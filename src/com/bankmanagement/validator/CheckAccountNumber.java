package com.bankmanagement.validator;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import javax.validation.Constraint;
import javax.validation.Payload;

@Target({ ElementType.METHOD, ElementType.FIELD, ElementType.ANNOTATION_TYPE })
@Retention(RetentionPolicy.RUNTIME)
@Constraint(validatedBy = CheckAccountNumberValidator.class)
@Documented
public @interface CheckAccountNumber {
	int length();

	String message() default "Account Number should be of 16 digit";

	Class<?>[] groups() default {};

	Class<? extends Payload>[] payload() default {};
}
