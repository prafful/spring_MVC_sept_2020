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

import com.bankmanagement.entity.HomeLoanDetailsEntity;
import com.bankmanagement.entity.TransactionDetailsEntity;

@Repository("viewHomeLoanDAO")
public class ViewHomeLoanDAO {

	@Autowired
	private SessionFactory sessionFactory;
	private static Logger logger = Logger.getLogger(ViewHomeLoanDAO.class);

	public List<HomeLoanDetailsEntity> retreiveHomeLoanDetails(String homeLoanId, Long loanAccountNumber) {
		logger.info("START");

		logger.info("___________________________________________________________________Home Loan ID: " + homeLoanId);
		logger.info("___________________________________________________________________Loan Account Number: "+ loanAccountNumber);

		Criteria criteria = sessionFactory.openSession().createCriteria(HomeLoanDetailsEntity.class);

		Criterion condition1 = Restrictions.eq("homeLoanId", homeLoanId);
		Criterion condition2 = Restrictions.eq("loanAccountNumber", loanAccountNumber);

		LogicalExpression combine_condition = Restrictions.or(condition1, condition2);

		criteria.add(combine_condition);

		@SuppressWarnings("unchecked")
		List<HomeLoanDetailsEntity> homeLoanDetailsList = criteria.list();

		logger.info("END");
		return homeLoanDetailsList;
	}

}
