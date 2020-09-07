package com.bankmanagement.controller;

import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.bankmanagement.entity.HomeLoanDetailsEntity;
import com.bankmanagement.service.ViewHomeLoanService;

@RestController
public class ViewHomeLoanController {

	private static Logger logger = Logger.getLogger(ViewHomeLoanController.class);
	@Autowired
	private ViewHomeLoanService viewHomeLoanService;

	@RequestMapping(value = "/viewHomeLoanDetail", method = RequestMethod.POST)
	List<HomeLoanDetailsEntity> searchHomeLoanDetails(
			@RequestParam(value = "homeLoanId", required = false) String homeLoanId,
			@RequestParam(value = "loanAccountNumber", required = false) Long loanAccountNumber) {
		logger.info("START");
		logger.info("END");
		return viewHomeLoanService.retreiveHomeLoanDetails(homeLoanId, loanAccountNumber);
	}

	@RequestMapping("/viewHomeLoan")
	public ModelAndView getIndex() {
		logger.info("START");
		ModelAndView modelAndView = new ModelAndView("ViewHomeLoan");
		logger.info("END");
		return modelAndView;
	}
}