package com.bankmanagement.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.bankmanagement.bean.TransactionBean;
import com.bankmanagement.entity.TransactionDetailsEntity;
import com.bankmanagement.service.ViewTransactionService;

@RestController
public class ViewTransactionController {

	private static Logger logger = Logger.getLogger(ViewTransactionController.class);

	@Autowired
	private ViewTransactionService viewTransactionService;

	@RequestMapping(value = "/viewTransaction1", method = RequestMethod.GET)
	public List<TransactionDetailsEntity> searchUserTransaction(
			@ModelAttribute("transactionVO") TransactionBean transactionVO) {
		logger.info("START");
		List<TransactionDetailsEntity> transactionDetailsList = viewTransactionService.retreiveTransactionDetails(
				transactionVO.getUser().getAccountNumber(), transactionVO.getTransactionId());
		logger.info("END");
		return transactionDetailsList;
	}

	@RequestMapping("/viewTransaction")
	public ModelAndView getIndex() {
		logger.info("START");
		ModelAndView modelAndView = new ModelAndView("ViewTransaction");
		logger.info("END");
		return modelAndView;
	}


	@RequestMapping(value = "/viewTransactionDetail", method = RequestMethod.POST)
	public @ResponseBody List<TransactionDetailsEntity> searchUserTransactionAgain(
			@RequestParam(value = "accountNumber", required = false) Long accountNumber,
			@RequestParam(value = "transactionId", required = false) Long transactionId) {
		logger.info(
				"___________________________________________________________________________________________________________________Account Number: "
						+ accountNumber);
		logger.info(
				"___________________________________________________________________________________________________________________Transaction Id: "
						+ transactionId);
		List<TransactionDetailsEntity> transactionDetailsList = viewTransactionService
				.retreiveTransactionDetails(accountNumber, transactionId);
		logger.info("END");

		Map<String, Object> model = new HashMap<String, Object>();
		model.put("transactionView", transactionDetailsList);

		// return new ModelAndView("ViewTransaction", model);
		return transactionDetailsList;
	}

}