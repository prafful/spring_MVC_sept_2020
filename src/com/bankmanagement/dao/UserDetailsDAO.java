package com.bankmanagement.dao;

import org.apache.log4j.Logger;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.bankmanagement.entity.UserDetailsEntity;

@Repository
public class UserDetailsDAO {

	@Autowired
	private SessionFactory sessionFactory;
	private static Logger logger = Logger.getLogger(UserDetailsDAO.class);

	public UserDetailsEntity getUserDetailsByAccountNumber(Long accountNumber) {
		logger.info("START");
		logger.info("END");
		return (UserDetailsEntity) sessionFactory.getCurrentSession().get(UserDetailsEntity.class, accountNumber);
	}
}