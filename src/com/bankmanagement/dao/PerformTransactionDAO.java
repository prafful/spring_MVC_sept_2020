package com.bankmanagement.dao;

import org.apache.log4j.Logger;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.bankmanagement.bean.TransactionBean;
import com.bankmanagement.entity.TransactionDetailsEntity;

@Repository("performTransactionDAO")
public class PerformTransactionDAO {

	@Autowired
	private SessionFactory sessionFactory;

	private static Logger logger = Logger.getLogger(PerformTransactionDAO.class);

	public double updateTransactionDetails(TransactionBean transactionBean) {
		logger.info("START");
		
		transactionBean.setAccountNumber(transactionBean.getUser().getAccountNumber());
		
		TransactionDetailsEntity transactionDetails = transactionBean.convertToTransactionDetailsEntity();

		if (transactionDetails.getTransactionType().equalsIgnoreCase("debit")) {
			transactionDetails.getUser().setAccountBalance(
					transactionDetails.getUser().getAccountBalance() - transactionDetails.getTransactionAmount());
		} else {
			transactionDetails.getUser().setAccountBalance(
					transactionDetails.getUser().getAccountBalance() + transactionDetails.getTransactionAmount());
		}

		sessionFactory.getCurrentSession().save(transactionDetails);

		logger.info("END");
		return transactionDetails.getUser().getAccountBalance();
	}
}