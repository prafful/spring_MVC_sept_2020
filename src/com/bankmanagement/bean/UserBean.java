package com.bankmanagement.bean;

import org.apache.log4j.Logger;

import com.bankmanagement.entity.UserDetailsEntity;

public class UserBean {
	
	//private - so that no other class can hijack your logger
	//static - so there is only one logger instance per class, also avoiding attempts to serialize loggers
	//final - no need to change the logger over the lifetime of the class
	private static Logger logger = Logger.getLogger(UserBean.class);

	private Long accountNumber;
	private Long accountBalance;
	private String accountHolderName;
	private String accountType;

	public void setAccountNumber(Long accountNumber) {
		this.accountNumber = accountNumber;
	}
	public Long getAccountBalance() {
		return accountBalance;
	}
	public void setAccountBalance(Long accountBalance) {
		this.accountBalance = accountBalance;
	}
	public String getAccountHolderName() {
		return accountHolderName;
	}
	public void setAccountHolderName(String accountHolderName) {
		this.accountHolderName = accountHolderName;
	}
	public String getAccountType() {
		return accountType;
	}
	public void setAccountType(String accountType) {
		this.accountType = accountType;
	}
	
	
	public Long getAccountNumber() {
		return accountNumber;
	}
	public UserBean(Long accountNumber, Long accountBalance, String accountHolderName, String accountType) {
		super();
		this.accountNumber = accountNumber;
		this.accountBalance = accountBalance;
		this.accountHolderName = accountHolderName;
		this.accountType = accountType;
	}
	public UserBean() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public UserDetailsEntity convertToUserDetailsEntity() {
		logger.info("START converting UserVO to UserDetails Entity");
		UserDetailsEntity userDetails = new UserDetailsEntity();
		userDetails.setAccountBalance(this.getAccountBalance());
		userDetails.setAccountHolderName(this.getAccountHolderName());
		userDetails.setAccountNumber(this.getAccountNumber());
		userDetails.setAccountType(this.getAccountType());
		logger.info("END converting UserVO to UserDetails Entity");
		return userDetails;
		
	}

}
