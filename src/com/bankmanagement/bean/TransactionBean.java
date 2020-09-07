package com.bankmanagement.bean;

import javax.validation.Valid;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

import org.apache.log4j.Logger;
import org.hibernate.validator.constraints.NotEmpty;
import org.springframework.stereotype.Component;

import com.bankmanagement.entity.TransactionDetailsEntity;
import com.bankmanagement.entity.UserDetailsEntity;

@Component
public class TransactionBean {

	private static Logger logger = Logger.getLogger(TransactionBean.class);

	private Long transactionId;
	@Valid
	private UserDetailsEntity user;
	@NotEmpty(message = "Transaction description should not be empty")
	private String transactionDescription;
	@NotEmpty(message = "Transaction type should not be null")
	private String transactionType;
	@NotNull(message = "Transaction amount should not be null")
	@Min(value = 0, message = "Value should not be less then 0")
	private Long transactionAmount;
	
	@NotNull(message = "Account Number cannot be null")
	private long accountNumber;
	
	

	public long getAccountNumber() {
		return accountNumber;
	}

	public void setAccountNumber(long accountNumber) {
		this.accountNumber = accountNumber;
	}

	public TransactionBean() {
		super();
	}

	public TransactionBean(Long transactionId, UserDetailsEntity user, String transactionDescription,
			String transactionType, Long transactionAmount, Long accountNumber) {
		super();
		this.transactionId = transactionId;
		this.user = user;
		this.transactionDescription = transactionDescription;
		this.transactionType = transactionType;
		this.transactionAmount = transactionAmount;
		this.accountNumber = accountNumber;
	}

	public Long getTransactionId() {
		return transactionId;
	}

	public void setTransactionId(Long transactionId) {
		this.transactionId = transactionId;
	}

	public UserDetailsEntity getUser() {
		return user;
	}

	public void setUser(UserDetailsEntity user) {
		this.user = user;
	}

	public String getTransactionDescription() {
		return transactionDescription;
	}

	public void setTransactionDescription(String transactionDescription) {
		this.transactionDescription = transactionDescription;
	}

	public String getTransactionType() {
		return transactionType;
	}

	public void setTransactionType(String transactionType) {
		this.transactionType = transactionType;
	}

	public Long getTransactionAmount() {
		return transactionAmount;
	}

	public void setTransactionAmount(Long transactionAmount) {
		this.transactionAmount = transactionAmount;
	}

	public TransactionDetailsEntity convertToTransactionDetailsEntity() {
		logger.info("START");

		TransactionDetailsEntity transactionDetails = new TransactionDetailsEntity();
		transactionDetails.setTransactionId(this.getTransactionId());
		transactionDetails.setUser(this.getUser());
		transactionDetails.setTransactionDescription(this.getTransactionDescription());
		transactionDetails.setTransactionType(this.getTransactionType());
		transactionDetails.setTransactionAmount(this.getTransactionAmount());
		transactionDetails.setAccountNumber(this.getAccountNumber());
		logger.info("END");
		return transactionDetails;
	}

}
