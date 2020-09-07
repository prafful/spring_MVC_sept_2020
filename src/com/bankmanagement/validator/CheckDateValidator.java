package com.bankmanagement.validator;

import java.util.Date;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class CheckDateValidator implements ConstraintValidator<CheckDate, Date> {

	@Override
	public void initialize(CheckDate arg0) {

	}

	@Override
	public boolean isValid(Date date, ConstraintValidatorContext arg1) {
		if (date == null || date.before(new Date())) {
			return false;
		}
		return true;
	}

}
