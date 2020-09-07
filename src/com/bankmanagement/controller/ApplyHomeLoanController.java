package com.bankmanagement.controller;

import java.util.List;

import javax.validation.Valid;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.bankmanagement.bean.HomeLoanBean;
import com.bankmanagement.businessrule.ApplyHomeLoanBusinessRule;
import com.bankmanagement.entity.UserDetailsEntity;
import com.bankmanagement.exception.BankManagementException;
import com.bankmanagement.service.ApplyHomeLoanService;
import com.bankmanagement.service.UserDetailsService;

@Controller
public class ApplyHomeLoanController {

	@Autowired
	private ApplyHomeLoanService applyHomeLoanService;
	@Autowired
	private UserDetailsService userDetailsService;
	@Autowired
	private ApplyHomeLoanBusinessRule applyHomeLoanBO;

	private static Logger logger = Logger.getLogger(ApplyHomeLoanController.class);

	@RequestMapping(value = "/doHomeLoan", method = RequestMethod.POST)
	public ModelAndView initiateHomeLoan(@Valid @ModelAttribute HomeLoanBean homeLoanBean, BindingResult result)
			throws BankManagementException {

		logger.info("START");

		ModelAndView model = new ModelAndView("ApplyHomeLoan");
		
		logger.info(homeLoanBean.getAnnualIncome());

		if (result.hasErrors()) {
			logger.info("Error: " + result.getErrorCount() + " " + result.getTarget().toString());
			List<FieldError> errors = result.getFieldErrors();
			for (FieldError error : errors) {
				System.out.println(error.getObjectName() + " - " + error.getCode());
			}
			logger.info("END");
			return model;
		} else {
			UserDetailsEntity user = userDetailsService
					.getUserDetailsByAccountNumber(homeLoanBean.getUser().getAccountNumber());
			logger.info("Input ac number____________________________" + user.getAccountHolderName());
			homeLoanBean.setUser(user);
			if (user != null && applyHomeLoanBO.canApplyForHomeLoan(homeLoanBean)) {
				Long accountNumber = applyHomeLoanService.insertHomeLoanDetails(homeLoanBean);
				logger.info("Account Number: " + accountNumber);
				model.addObject("accountNumber", accountNumber);

			} else if (user == null) {
				throw new BankManagementException("User does not exist");
			} else if (!applyHomeLoanBO.canApplyForHomeLoan(homeLoanBean)) {
				model.addObject("errorMessage", "Father income should be more than 10% of loan amount");
				logger.info("END");
				return model;
			}
		}
		logger.info("END");
		return model;
	}

	@RequestMapping("/applyHomeLoan")
	public ModelAndView getIndex() {
		logger.info("START");
		ModelAndView modelAndView = new ModelAndView("ApplyHomeLoan");
		modelAndView.addObject("homeLoanBean", new HomeLoanBean());
		logger.info("END");
		return modelAndView;
	}
}