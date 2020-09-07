package com.bankmanagement.service;

import javax.transaction.Transactional;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bankmanagement.dao.UserDetailsDAO;
import com.bankmanagement.entity.UserDetailsEntity;

@Service
public class UserDetailsService {

	@Autowired
	private UserDetailsDAO userDetailsDAO;

	private static Logger logger = Logger.getLogger(UserDetailsService.class);

	@Transactional
	public UserDetailsEntity getUserDetailsByAccountNumber(Long accountNumber) {
		logger.info("START");
		logger.info("END");
		return userDetailsDAO.getUserDetailsByAccountNumber(accountNumber);
	}

}
