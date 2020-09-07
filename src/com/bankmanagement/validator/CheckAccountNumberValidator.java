package com.bankmanagement.validator;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class CheckAccountNumberValidator implements ConstraintValidator<CheckAccountNumber, Long> {

	private int length;

	@Override
	public void initialize(CheckAccountNumber checkAccountNumber) {
		length = checkAccountNumber.length();
	}

	@Override
	public boolean isValid(Long accountNumber, ConstraintValidatorContext arg1) {
		try {
			if (accountNumber.toString().length() == length) {
				return true;
			}
		} catch (Exception ex) {
			return false;
		}
		return false;
	}
}