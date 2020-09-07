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

import com.bankmanagement.entity.EducationLoanDetailsEntity;
import com.bankmanagement.entity.HomeLoanDetailsEntity;
import com.bankmanagement.entity.TransactionDetailsEntity;

@Repository
public class ViewEducationLoanDAO {

	@Autowired
	private SessionFactory sessionFactory;
	private static Logger logger = Logger.getLogger(ViewEducationLoanDAO.class);

	public List<EducationLoanDetailsEntity> retrieveEducationLoanDetails(String identificationCardNumber, Long loanAccountNumber) {
		logger.info("START");

		logger.info("___________________________________________________________________ID: " + identificationCardNumber);
		logger.info("___________________________________________________________________Loan Account Number: "+ loanAccountNumber);

		Criteria criteria = sessionFactory.openSession().createCriteria(EducationLoanDetailsEntity.class);

		Criterion condition1 = Restrictions.eq("educationLoanId", identificationCardNumber);
		Criterion condition2 = Restrictions.eq("educationLoanAccountNumber", loanAccountNumber);

		LogicalExpression combine_condition = Restrictions.and(condition1, condition2);

		criteria.add(combine_condition);

		@SuppressWarnings("unchecked")
		List<EducationLoanDetailsEntity> educationLoanDetailsList = criteria.list();

		logger.info("END");
		return educationLoanDetailsList;

	}
}