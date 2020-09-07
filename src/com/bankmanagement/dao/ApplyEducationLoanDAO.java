package com.bankmanagement.dao;

import org.apache.log4j.Logger;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.bankmanagement.bean.EducationLoanBean;
import com.bankmanagement.entity.EducationLoanDetailsEntity;

@Repository("applyEducationLoanDAO")
public class ApplyEducationLoanDAO {

	@Autowired
	private SessionFactory sessionFactory;

	private static Logger logger = Logger.getLogger(ApplyEducationLoanDAO.class);

	public Long insertEducationLoanDetails(EducationLoanBean educationLoanBean) {
		logger.info("START");
		EducationLoanDetailsEntity educationLoanDetails = educationLoanBean.convertToEducationLoanDetailsEntity();
		Session session = sessionFactory.openSession();
		Transaction tx = session.beginTransaction();
		session.save(educationLoanDetails);
		tx.commit();
		session.flush();
		// sessionFactory.getCurrentSession().save(educationLoanDetails);
		//educationLoanDetails = (EducationLoanDetailsEntity) sessionFactory.getCurrentSession().get(EducationLoanDetailsEntity.class, educationLoanDetails.getEducationLoanId());
		logger.info("END");
		return educationLoanDetails.getEducationLoanAccountNumber();
	}
}
