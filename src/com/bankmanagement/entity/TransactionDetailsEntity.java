package com.bankmanagement.entity;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "TRANSACTION_DETAILS")
public class TransactionDetailsEntity {

	@Id
	@GeneratedValue
	@Column(name = "TRANSACTION_ID")
	private Long transactionId;

	public long getAccountNumber() {
		return accountNumber;
	}

	public void setAccountNumber(long accountNumber) {
		this.accountNumber = accountNumber;
	}

	@Column(name = "ACCOUNT_NUMBER")
	private long accountNumber;

	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "ACCOUNT_NUMBER", insertable = false, updatable = false)
	private UserDetailsEntity user;

	@Column(name = "TRANSACTION_DESCRIPTION")
	private String transactionDescription;

	@Column(name = "TRANSACTION_TYPE")
	private String transactionType;

	@Column(name = "TRANSACTION_AMOUNT")
	private Long transactionAmount;

	public TransactionDetailsEntity() {
		super();
	}

	public TransactionDetailsEntity(Long transactionId, UserDetailsEntity user, String transactionDescription,
			String transactionType, Long transactionAmount) {
		super();
		this.transactionId = transactionId;
		this.user = user;
		this.transactionDescription = transactionDescription;
		this.transactionType = transactionType;
		this.transactionAmount = transactionAmount;
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

}