package com.bankmanagement.service;

import javax.transaction.Transactional;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bankmanagement.bean.EducationLoanBean;
import com.bankmanagement.dao.ApplyEducationLoanDAO;

@Service("applyEducationLoanService")
public class ApplyEducationLoanService {

	@Autowired
	private ApplyEducationLoanDAO applyEducationLoanDAO;

	private static Logger logger = Logger.getLogger(ApplyEducationLoanService.class);

	@Transactional
	public Long insertEducationLoanDetails(EducationLoanBean educationLoanVO) {
		logger.info("START");
		logger.info("END");

		return applyEducationLoanDAO.insertEducationLoanDetails(educationLoanVO);
	}
}
