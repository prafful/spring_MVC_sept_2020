package com.bankmanagement.businessrule;

import org.springframework.stereotype.Component;

import com.bankmanagement.bean.HomeLoanBean;

@Component
public class ApplyHomeLoanBusinessRule {

	public boolean canApplyForHomeLoan(HomeLoanBean homeLoanVO) {
		if (homeLoanVO.getAnnualIncome() >= (0.1 * homeLoanVO.getLoanAmount())) {
			return true;
		}
		return false;
	}
}