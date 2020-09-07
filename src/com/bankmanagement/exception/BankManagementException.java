package com.bankmanagement.exception;

public class BankManagementException extends Exception {

	private static final long serialVersionUID = -3757279711646882626L;

	public BankManagementException(String message) {
		super(message);
	}

	public BankManagementException(Throwable throwable) {

	}

	public BankManagementException(String message, Throwable throwable) {
		super(message);
	}

}