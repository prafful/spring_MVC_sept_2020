package com.bankmanagement.businessrule;

import org.springframework.stereotype.Component;

import com.bankmanagement.bean.TransactionBean;

@Component
public class PerformTransactionBusinessRule {

	public boolean canDebit(TransactionBean transactionBean) {
		Long balance = transactionBean.getUser().getAccountBalance();
		if (transactionBean.getTransactionType().equalsIgnoreCase("debit")) {
			if (balance < transactionBean.getTransactionAmount()) {
				return false;
			} else if (transactionBean.getTransactionType() != "saving"
					&& (balance - transactionBean.getTransactionAmount()) < 5000) {
				return false;
			}
		}
		return true;
	}

}