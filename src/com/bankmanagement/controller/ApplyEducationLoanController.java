package com.bankmanagement.controller;

import javax.validation.Valid;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.bankmanagement.bean.EducationLoanBean;
import com.bankmanagement.entity.UserDetailsEntity;
import com.bankmanagement.exception.BankManagementException;
import com.bankmanagement.service.ApplyEducationLoanService;
import com.bankmanagement.service.UserDetailsService;

@Controller
public class ApplyEducationLoanController {

	private static Logger logger = Logger.getLogger(ApplyEducationLoanController.class);

	@Autowired
	private ApplyEducationLoanService applyEducationLoanService;

	@Autowired
	private UserDetailsService userDetailsService;

	@RequestMapping(value = "/doEducationLoan", method = RequestMethod.POST)
	public ModelAndView initiateEducationLoanDetails(@Valid @ModelAttribute EducationLoanBean educationLoanBean,
			BindingResult result) throws BankManagementException {
		logger.info("START");

		ModelAndView model = new ModelAndView("ApplyEducationLoan");
		if (result.hasErrors()) {
			logger.info("END");
			return model;

		} else {
			UserDetailsEntity user = userDetailsService.getUserDetailsByAccountNumber(educationLoanBean.getUser().getAccountNumber());
			educationLoanBean.setAccountNumber(educationLoanBean.getUser().getAccountNumber());
			educationLoanBean.setUser(user);
			if (user != null) {
				Long accountNumber = applyEducationLoanService.insertEducationLoanDetails(educationLoanBean);
				model.addObject("accountNumber", accountNumber);
			} else if (user == null) {
				throw new BankManagementException("User does not exist");
			}
		}
		logger.info("END");
		return model;
	}

	@RequestMapping("/applyEducationLoan")
	public ModelAndView getIndex() {
		logger.info("START");
		ModelAndView modelAndView = new ModelAndView("ApplyEducationLoan");
		modelAndView.addObject("educationLoanBean", new EducationLoanBean());
		logger.info("END");
		return modelAndView;
	}
}
