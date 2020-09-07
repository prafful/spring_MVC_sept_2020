package com.bankmanagement.dao;

import org.apache.log4j.Logger;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.bankmanagement.bean.HomeLoanBean;
import com.bankmanagement.entity.HomeLoanDetailsEntity;

@Repository("applyHomeLoanDAO")
public class ApplyHomeLoanDAO {

	@Autowired
	private SessionFactory sessionFactory;
	private static Logger logger = Logger.getLogger(ApplyHomeLoanDAO.class);

	public Long insertHomeLoanDetails(HomeLoanBean homeLoanBean) {
		
		logger.info("START inside home loan DAO");
		
		homeLoanBean.setAccountNumber(homeLoanBean.getUser().getAccountNumber());
		
		HomeLoanDetailsEntity homeLoanDetails = homeLoanBean.convertToHomeLoanDetailsEntity();
		
		logger.info("Bean account number: " + homeLoanBean.getAccountNumber());
		logger.info("User account number: " + homeLoanBean.getUser().getAccountNumber());
		logger.info("Home Loan Entity account number: " + homeLoanDetails.getAccountNumber());
		logger.info("User Entity account number: " + homeLoanDetails.getUser().getAccountNumber());
		
		String accountNumber = homeLoanBean.getUser().getAccountNumber().toString();
		String homeLoanId = "HL-" + accountNumber.substring(accountNumber.length() - 3, accountNumber.length());
	
		homeLoanDetails.setHomeLoanId(homeLoanId);
		
		Session session = sessionFactory.openSession();
		Transaction tx = session.beginTransaction();
		session.save(homeLoanDetails);
		tx.commit();
		session.flush();
		
		System.out.println(homeLoanDetails.getLoanAccountNumber());
		
		//homeLoanDetails = (HomeLoanDetailsEntity) sessionFactory.getCurrentSession().get(HomeLoanDetailsEntity.class,homeLoanDetails.getHomeLoanId());

		logger.info("END");
		logger.info("____________________________________Returning Account Number: " + homeLoanDetails.getLoanAccountNumber());
		return homeLoanDetails.getLoanAccountNumber();
	}
}
