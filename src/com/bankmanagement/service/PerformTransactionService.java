package com.bankmanagement.service;

import javax.transaction.Transactional;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bankmanagement.bean.TransactionBean;
import com.bankmanagement.dao.PerformTransactionDAO;

@Service("performTransactionService")
public class PerformTransactionService {

	@Autowired
	private PerformTransactionDAO performTransactionDAO;

	private static Logger logger = Logger.getLogger(PerformTransactionService.class);

	@Transactional
	public double updateTransactionDetails(TransactionBean transactionVO) {
		logger.info("START");
		logger.info("END");
		return performTransactionDAO.updateTransactionDetails(transactionVO);
	}
}










