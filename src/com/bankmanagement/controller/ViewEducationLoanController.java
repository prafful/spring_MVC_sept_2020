package com.bankmanagement.controller;

import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.bankmanagement.entity.EducationLoanDetailsEntity;
import com.bankmanagement.service.ViewEducationLoanService;

@RestController
public class ViewEducationLoanController {

	private static Logger logger = Logger.getLogger(ViewEducationLoanController.class);
	@Autowired
	private ViewEducationLoanService viewEducationLoanService;

	@RequestMapping(value = "/viewEducationLoanDetail", method = RequestMethod.POST)
	List<EducationLoanDetailsEntity> searchEducationLoanDetails(
			@RequestParam(value = "identificationCardNumber", required = false) String identificationCardNumber,
			@RequestParam(value = "loanAccountNumber", required = false) Long loanAccountNumber) {
		logger.info("START");
		logger.info("END");
		return viewEducationLoanService.retrieveEducationLoanDetails(identificationCardNumber, loanAccountNumber);
	}

	@RequestMapping("/viewEducationLoan")
	public ModelAndView getIndex() {
		logger.info("START");
		ModelAndView modelAndView = new ModelAndView("ViewEducationLoan");
		logger.info("END");
		return modelAndView;
	}
}