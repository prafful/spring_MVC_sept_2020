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

import com.bankmanagement.bean.TransactionBean;
import com.bankmanagement.businessrule.PerformTransactionBusinessRule;
import com.bankmanagement.entity.UserDetailsEntity;
import com.bankmanagement.exception.BankManagementException;
import com.bankmanagement.service.PerformTransactionService;
import com.bankmanagement.service.UserDetailsService;

@Controller
public class PerformTransactionController {

	@Autowired
	private PerformTransactionService performTransactionService;
	@Autowired
	private UserDetailsService userDetailsService;
	@Autowired
	private PerformTransactionBusinessRule performTransactionBO;

	private static Logger logger = Logger.getLogger(PerformTransactionController.class);

	@RequestMapping(value = "/doTransaction", method = RequestMethod.POST)
	public ModelAndView initiateTransaction(@Valid @ModelAttribute TransactionBean transactionBean,
			BindingResult result) throws BankManagementException {
		logger.info("START");
		ModelAndView model = new ModelAndView("PerformTransaction");
		
		if (result.hasErrors()) {
			logger.info("END");
			return model;
		} else {
			UserDetailsEntity user = userDetailsService
					.getUserDetailsByAccountNumber(transactionBean.getUser().getAccountNumber());
			transactionBean.setUser(user);
			if (user != null && performTransactionBO.canDebit(transactionBean)) {
				Double balance = performTransactionService.updateTransactionDetails(transactionBean);
				model.addObject("balance", balance);
			} else if (user == null) {
				throw new BankManagementException("User does not exist");
			} else if (!performTransactionBO.canDebit(transactionBean)) {
				model.addObject("errorMessage", "Insufficient Balance");
				logger.info("END");
				return model;
			}
		}
		logger.info("END");
		return model;
	}

	@RequestMapping("/performTransaction")
	public ModelAndView getIndex() {
		logger.info("START");
		ModelAndView modelAndView = new ModelAndView("PerformTransaction");
		modelAndView.addObject("transactionBean", new TransactionBean());
		logger.info("END");
		return modelAndView;
	}

	@RequestMapping("/bank")
	public ModelAndView getHomePage() {
		ModelAndView model = new ModelAndView("home");
		return model;
	}
}