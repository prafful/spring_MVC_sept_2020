package com.bankmanagement.service;

import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bankmanagement.dao.ViewHomeLoanDAO;
import com.bankmanagement.entity.HomeLoanDetailsEntity;

@Service
public class ViewHomeLoanService {

	@Autowired
	private ViewHomeLoanDAO viewHomeLoanDAO;
	private static Logger logger = Logger.getLogger(ViewHomeLoanService.class);

	public List<HomeLoanDetailsEntity> retreiveHomeLoanDetails(String homeLoanId, Long loanAccountNumber) {
		logger.info("START");
		logger.info("END");
		return viewHomeLoanDAO.retreiveHomeLoanDetails(homeLoanId, loanAccountNumber);
	}
}
