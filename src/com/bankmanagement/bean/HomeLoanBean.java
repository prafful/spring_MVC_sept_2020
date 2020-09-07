package com.bankmanagement.bean;

import java.util.Date;

import javax.validation.Valid;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

import org.apache.log4j.Logger;
import org.hibernate.validator.constraints.NotEmpty;
import org.springframework.stereotype.Component;

import com.bankmanagement.entity.HomeLoanDetailsEntity;
import com.bankmanagement.entity.UserDetailsEntity;
import com.bankmanagement.validator.CheckDate;

@Component
public class HomeLoanBean {

	private static Logger logger = Logger.getLogger(HomeLoanBean.class);

	private String homeLoanId;
	private Long loanAccountNumber;
	@Valid
	private UserDetailsEntity user;
	@Min(value = 0, message = "Value should not be less then 0")
	@NotNull(message = "Loan amount should not be null")
	private Long loanAmount;
	@CheckDate
	private Date loanApplyDate;
	@NotNull(message = "Loan duration should not be null")
	private Integer loanDuration;
	@NotNull(message = "Annual Income shuld not be null")
	@Min(value = 0, message = "Value should not be less then 0")
	private Long annualIncome;
	@NotEmpty(message = "Company name should not be empty")
	private String companyName;
	@NotEmpty(message = "Designation should not be empty")
	private String designation;
	@NotNull(message = "Total Experience should not be null")
	private Integer totalExperience;
	@NotNull(message = "Current Experience should not be null")
	private Integer currentExperience;

	
	private Long accountNumber;

	
	public Long getAccountNumber() {
		return accountNumber;
	}

	public void setAccountNumber(Long accountNumber) {
		this.accountNumber = accountNumber;
	}

	public HomeLoanBean() {
		super();
	}

	public HomeLoanBean(String homeLoanId, UserDetailsEntity user, Long loanAmount, Date loanApplyDate,
			Integer loanDuration, Long annualIncome, String companyName, String designation, Integer totalExperience,
			Integer currentExperience, Long accountNumber) {
		super();
		this.homeLoanId = homeLoanId;
		this.user = user;
		this.loanAmount = loanAmount;
		this.loanApplyDate = loanApplyDate;
		this.loanDuration = loanDuration;
		this.annualIncome = annualIncome;
		this.companyName = companyName;
		this.designation = designation;
		this.totalExperience = totalExperience;
		this.currentExperience = currentExperience;
		this.accountNumber = accountNumber;
	}

	public String getHomeLoanId() {
		return homeLoanId;
	}

	public void setHomeLoanId(String homeLoanId) {
		this.homeLoanId = homeLoanId;
	}

	public Long getLoanAccountNumber() {
		return loanAccountNumber;
	}

	public void setLoanAccountNumber(Long loanAccountNumber) {
		this.loanAccountNumber = loanAccountNumber;
	}

	public UserDetailsEntity getUser() {
		return user;
	}

	public void setUser(UserDetailsEntity user) {
		this.user = user;
	}

	public Long getLoanAmount() {
		return loanAmount;
	}

	public void setLoanAmount(Long loanAmount) {
		this.loanAmount = loanAmount;
	}

	public Date getLoanApplyDate() {
		return loanApplyDate;
	}

	public void setLoanApplyDate(Date loanApplyDate) {
		this.loanApplyDate = loanApplyDate;
	}

	public Integer getLoanDuration() {
		return loanDuration;
	}

	public void setLoanDuration(Integer loanDuration) {
		this.loanDuration = loanDuration;
	}

	public Long getAnnualIncome() {
		return annualIncome;
	}

	public void setAnnualIncome(Long annualIncome) {
		this.annualIncome = annualIncome;
	}

	public String getCompanyName() {
		return companyName;
	}

	public void setCompanyName(String companyName) {
		this.companyName = companyName;
	}

	public String getDesignation() {
		return designation;
	}

	public void setDesignation(String designation) {
		this.designation = designation;
	}

	public Integer getTotalExperience() {
		return totalExperience;
	}

	public void setTotalExperience(Integer totalExperience) {
		this.totalExperience = totalExperience;
	}

	public Integer getCurrentExperience() {
		return currentExperience;
	}

	public void setCurrentExperience(Integer currentExperience) {
		this.currentExperience = currentExperience;
	}

	public HomeLoanDetailsEntity convertToHomeLoanDetailsEntity() {
		logger.info("START");

		HomeLoanDetailsEntity homeLoanDetails = new HomeLoanDetailsEntity();
		homeLoanDetails.setAnnualIncome(this.getAnnualIncome());
		homeLoanDetails.setCompanyName(this.getCompanyName());
		homeLoanDetails.setCurrentExperience(this.getCurrentExperience());
		homeLoanDetails.setDesignation(this.getDesignation());
		homeLoanDetails.setAccountNumber(this.getAccountNumber());
		homeLoanDetails.setLoanAmount(this.getLoanAmount());
		homeLoanDetails.setLoanApplyDate(this.getLoanApplyDate());
		homeLoanDetails.setLoanDuration(this.getLoanDuration());
		homeLoanDetails.setTotalExperience(this.getTotalExperience());
		homeLoanDetails.setUser(this.getUser());
		logger.info("END");
		return homeLoanDetails;
	}

	
}