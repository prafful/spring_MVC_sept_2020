package com.bankmanagement.service;

import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bankmanagement.dao.ViewTransactionDAO;
import com.bankmanagement.entity.TransactionDetailsEntity;

@Service("viewTransactionService")
public class ViewTransactionService {

	@Autowired
	private ViewTransactionDAO viewTransactionDAO;
	private static Logger logger = Logger.getLogger(ViewTransactionService.class);

	public List<TransactionDetailsEntity> retreiveTransactionDetails(Long accountNumber, Long transactionId) {
		logger.info("START");
		logger.info("END");
		logger.info(
				"___________________________________________________________________________________________________________________Account Number: "
						+ accountNumber);
		logger.info(
				"___________________________________________________________________________________________________________________Transaction Id: "
						+ transactionId);
		return viewTransactionDAO.retreiveTransactionDetails(accountNumber, transactionId);
	}
}