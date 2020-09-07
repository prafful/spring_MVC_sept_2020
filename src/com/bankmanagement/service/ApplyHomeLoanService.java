package com.bankmanagement.service;

import javax.transaction.Transactional;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bankmanagement.bean.HomeLoanBean;
import com.bankmanagement.dao.ApplyHomeLoanDAO;

@Service("applyHomeLoanService")
public class ApplyHomeLoanService {

	@Autowired
	private ApplyHomeLoanDAO applyHomeLoanDAO;

	private static Logger logger = Logger.getLogger(ApplyHomeLoanService.class);

	@Transactional
	public Long insertHomeLoanDetails(HomeLoanBean homeLoanVO) {
		logger.info("START");
		logger.info("END");
		return applyHomeLoanDAO.insertHomeLoanDetails(homeLoanVO);
	}
}
