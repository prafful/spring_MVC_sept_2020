package com.bankmanagement.exception;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.ModelAndView;

@ControllerAdvice
public class GlobalExceptionHandler {

	@ExceptionHandler(BankManagementException.class)
	public ModelAndView handleBankManagementException(BankManagementException ex) {
		ModelAndView model = new ModelAndView("error");
		model.addObject("exceptionMessage", ex.getMessage());
		return model;
	}

	@ExceptionHandler(Exception.class)
	public ModelAndView handleGlobalException(Exception ex) {
		ModelAndView model = new ModelAndView("error");
		model.addObject("exceptionMessage", ex.getMessage());
		return model;
	}
}