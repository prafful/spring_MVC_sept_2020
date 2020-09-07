package com.bankmanagement.bean;

import java.util.Date;

import javax.validation.Valid;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

import org.apache.log4j.Logger;
import org.hibernate.validator.constraints.NotEmpty;
import org.springframework.stereotype.Component;

import com.bankmanagement.entity.EducationLoanDetailsEntity;
import com.bankmanagement.entity.UserDetailsEntity;
import com.bankmanagement.validator.CheckDate;

@Component
public class EducationLoanBean {

	private static Logger logger = Logger.getLogger(EducationLoanBean.class);

	private String educationLoanId;
	private Long educationLoanAccountNumber;
	@Valid
	private UserDetailsEntity user;
	@Min(value = 0, message = "Value should not be less then 0")
	@NotNull(message = "Loan amount should not be null")
	@Max(value = 2000000, message = "Loan amount should not exceed 20 lakhs")
	private Long educationLoanAmount;
	@CheckDate
	private Date educationLoanApplyDate;
	@NotNull(message = "Loan duration should not be null")
	private Integer educationLoanDuration;
	@NotNull(message = "Father annual income should not be null")
	@Min(value = 0, message = "Value should not be less then 0")
	private Long fatherAnnualIncome;
	@NotNull(message = "Course fee should not be null")
	private Long courseFee;
	@NotEmpty(message = "Course name should not be empty")
	private String courseName;
	@NotEmpty(message = "Father name should not be empty")
	private String fatherName;
	@NotNull(message = "Id card number should not be null")
	private Long idCardNumber;
	
	private Long accountNumber;

	
	public Long getAccountNumber() {
		return accountNumber;
	}

	public void setAccountNumber(Long accountNumber) {
		this.accountNumber = accountNumber;
	}


	public EducationLoanBean() {
	super();
	}

	public EducationLoanBean(String educationLoanId, UserDetailsEntity user, Long educationLoanAmount,
	Date educationLoanApplyDate, Integer educationLoanDuration, Long fatherAnnualIncome, Long courseFee,
	String courseName, String fatherName, Long idCardNumber, Long accountNumber) {
	super();
	this.educationLoanId = educationLoanId;
	this.user = user;
	this.educationLoanAmount = educationLoanAmount;
	this.educationLoanApplyDate = educationLoanApplyDate;
	this.educationLoanDuration = educationLoanDuration;
	this.fatherAnnualIncome = fatherAnnualIncome;
	this.courseFee = courseFee;
	this.courseName = courseName;
	this.fatherName = fatherName;
	this.idCardNumber = idCardNumber;
	this.accountNumber = accountNumber;
	}

	public String getEducationLoanId() {
	return educationLoanId;
	}

	public void setEducationLoanId(String educationLoanId) {
	this.educationLoanId = educationLoanId;
	}

	public Long getEducationLoanAccountNumber() {
	return educationLoanAccountNumber;
	}

	public void setEducationLoanAccountNumber(Long educationLoanAccountNumber) {
	this.educationLoanAccountNumber = educationLoanAccountNumber;
	}

	public UserDetailsEntity getUser() {
	return user;
	}

	public void setUser(UserDetailsEntity user) {
	this.user = user;
	}

	public Long getEducationLoanAmount() {
	return educationLoanAmount;
	}

	public void setEducationLoanAmount(Long educationLoanAmount) {
	this.educationLoanAmount = educationLoanAmount;
	}

	public Date getEducationLoanApplyDate() {
	return educationLoanApplyDate;
	}

	public void setEducationLoanApplyDate(Date educationLoanApplyDate) {
	this.educationLoanApplyDate = educationLoanApplyDate;
	}

	public Integer getEducationLoanDuration() {
	return educationLoanDuration;
	}

	public void setEducationLoanDuration(Integer educationLoanDuration) {
	this.educationLoanDuration = educationLoanDuration;
	}

	public Long getFatherAnnualIncome() {
	return fatherAnnualIncome;
	}

	public void setFatherAnnualIncome(Long fatherAnnualIncome) {
	this.fatherAnnualIncome = fatherAnnualIncome;
	}

	public Long getCourseFee() {
	return courseFee;
	}

	public void setCourseFee(Long courseFee) {
	this.courseFee = courseFee;
	}

	public String getCourseName() {
	return courseName;
	}

	public void setCourseName(String courseName) {
	this.courseName = courseName;
	}

	public String getFatherName() {
	return fatherName;
	}

	public void setFatherName(String fatherName) {
	this.fatherName = fatherName;
	}

	public Long getIdCardNumber() {
	return idCardNumber;
	}

	public void setIdCardNumber(Long idCardNumber) {
	this.idCardNumber = idCardNumber;
	}

	public EducationLoanDetailsEntity convertToEducationLoanDetailsEntity() {
	logger.info("START");

	EducationLoanDetailsEntity educationLoanDetails = new EducationLoanDetailsEntity();

	educationLoanDetails.setCourseFee(this.getCourseFee());
	educationLoanDetails.setCourseName(this.getCourseName());
	educationLoanDetails.setEducationLoanAccountNumber(this.getEducationLoanAccountNumber());
	educationLoanDetails.setEducationLoanAmount(this.getEducationLoanAmount());
	educationLoanDetails.setEducationLoanApplyDate(this.getEducationLoanApplyDate());
	educationLoanDetails.setEducationLoanDuration(this.getEducationLoanDuration());
	educationLoanDetails.setEducationLoanId(this.constructLoanId());
	educationLoanDetails.setFatherAnnualIncome(this.getFatherAnnualIncome());
	educationLoanDetails.setFatherName(this.getFatherName());
	educationLoanDetails.setIdCardNumber(this.getIdCardNumber());
	educationLoanDetails.setUser(this.getUser());
	educationLoanDetails.setAccountNumber(this.getAccountNumber());
	logger.info("END");
	return educationLoanDetails;
	}

	private String constructLoanId() {
	logger.info("START");
	String accountNumber = this.getUser().getAccountNumber().toString();
	logger.info("END");
	return "EL-" + accountNumber.substring(0, 6);
	}
}
