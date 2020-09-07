package com.bankmanagement.dao;

import java.util.List;

import org.apache.log4j.Logger;
import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Criterion;
import org.hibernate.criterion.LogicalExpression;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.bankmanagement.entity.TransactionDetailsEntity;

@Repository("viewTransactionDAO")
public class ViewTransactionDAO {

	@Autowired
	private SessionFactory sessionFactory;
	private static Logger logger = Logger.getLogger(ViewTransactionDAO.class);

	public List<TransactionDetailsEntity> retreiveTransactionDetails(Long accountNumber, Long transactionId) {
	logger.info("START");
	logger.info("___________________________________________________________________________________________________________________Account Number: " + accountNumber);
	logger.info("___________________________________________________________________________________________________________________Transaction Id: " + transactionId);
	
	Criteria criteria = sessionFactory.openSession().createCriteria(TransactionDetailsEntity.class);
	
	Criterion condition1 = Restrictions.eq("transactionId", transactionId);
	Criterion condition2 = Restrictions.eq("accountNumber", accountNumber);
	
	LogicalExpression combine_condition = Restrictions.and(condition1, condition2);
	
	criteria.add(combine_condition);
	
	List<TransactionDetailsEntity> transactionList = criteria.list();
	
	logger.info("END");
	
	logger.info("________________________________________________________Size: " + transactionList.size());
	logger.info("________________________________________________________Account Number: " + transactionList.get(0).getAccountNumber());
	logger.info("________________________________________________________Transaction ID: " + transactionList.get(0).getTransactionId());
	logger.info("________________________________________________________Transaction ID: " + transactionList.get(0).getTransactionAmount());
	
	return transactionList;
	}
}