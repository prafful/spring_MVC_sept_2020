package com.bankmanagement.service;

import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bankmanagement.dao.ViewEducationLoanDAO;
import com.bankmanagement.entity.EducationLoanDetailsEntity;

@Service
public class ViewEducationLoanService {

	@Autowired
	private ViewEducationLoanDAO viewEducationLoanDAO;
	private static Logger logger = Logger.getLogger(ViewEducationLoanService.class);

	public List<EducationLoanDetailsEntity> retrieveEducationLoanDetails(String identificationCardNumber,
			Long loanAccountNumber) {
		logger.info("START");
		logger.info("END");
		return viewEducationLoanDAO.retrieveEducationLoanDetails(identificationCardNumber, loanAccountNumber);
	}
}