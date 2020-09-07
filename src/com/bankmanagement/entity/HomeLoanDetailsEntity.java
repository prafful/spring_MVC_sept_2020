package com.bankmanagement.entity;

import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.TableGenerator;

@Entity
@Table(name = "HOME_LOAN_DETAILS")
public class HomeLoanDetailsEntity {

	@Column(name = "HOME_LOAN_ID")
	private String homeLoanId;
	
	@Id
	@TableGenerator(name = "AUTO_GEN1", table = "sequence_home", pkColumnName = "pk_id", valueColumnName = "sequence_id", pkColumnValue = "sequencehome", allocationSize = 1)
	@GeneratedValue(strategy = GenerationType.TABLE, generator = "AUTO_GEN1")
	@Column(name = "HOME_LOAN_ACCOUNT_NUMBER")
	private Long loanAccountNumber;
	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "ACCOUNT_NUMBER", insertable = false, updatable = false)
	private UserDetailsEntity user;
	@Column(name = "LOAN_AMOUNT")
	private Long loanAmount;
	@Column(name = "LOAN_APPLY_DATE")
	private Date loanApplyDate;
	@Column(name = "LOAN_DURATION")
	private Integer loanDuration;
	@Column(name = "ANNUAL_INCOME")
	private Long annualIncome;
	@Column(name = "COMPANY_NAME")
	private String companyName;
	@Column(name = "DESIGNATION")
	private String designation;
	@Column(name = "TOTAL_EXP")
	private Integer totalExperience;
	@Column(name = "EXP_CURRENT_COMPANY")
	private Integer currentExperience;
	
	
	@Column(name = "ACCOUNT_NUMBER")
	private Long accountNumber;
	
	public Long getAccountNumber() {
		return accountNumber;
	}

	public void setAccountNumber(Long accountNumber) {
		this.accountNumber = accountNumber;
	}




	public HomeLoanDetailsEntity() {
		super();
	}

	public HomeLoanDetailsEntity(String homeLoanId, UserDetailsEntity user, Long loanAmount, Date loanApplyDate,
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
}