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
@Table(name = "EDUCATION_LOAN_DETAILS")
public class EducationLoanDetailsEntity {
	
	@Column(name = "EDUCATION_LOAN_ID")
	private String educationLoanId;
	@Id
	@TableGenerator(name = "AUTO_GEN2", table = "sequence_education", pkColumnName = "pk_id", valueColumnName = "sequence_id", pkColumnValue = "sequenceedu", allocationSize = 1)
	@GeneratedValue(strategy = GenerationType.TABLE, generator = "AUTO_GEN2")
	@Column(name = "EDU_LOAN_ACCOUNT_NUMBER")
	private Long educationLoanAccountNumber;
	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "ACCOUNT_NUMBER", insertable = false, updatable = false)
	private UserDetailsEntity user;
	@Column(name = "EDU_LOAN_AMOUNT")
	private Long educationLoanAmount;
	@Column(name = "EDU_LOAN_APPLY_DATE")
	private Date educationLoanApplyDate;
	@Column(name = "EDU_LOAN_DURATION")
	private Integer educationLoanDuration;
	@Column(name = "FATHER_ANNUAL_INCOME")
	private Long fatherAnnualIncome;
	@Column(name = "COURSE_FEE")
	private Long courseFee;
	@Column(name = "COURSE_NAME")
	private String courseName;
	@Column(name = "FATHER_NAME")
	private String fatherName;
	@Column(name = "ID_CARD_NUMBER")
	private Long idCardNumber;
	
	@Column(name = "ACCOUNT_NUMBER")
	private Long accountNumber;
	
	public Long getAccountNumber() {
		return accountNumber;
	}

	public void setAccountNumber(Long accountNumber) {
		this.accountNumber = accountNumber;
	}

	public EducationLoanDetailsEntity() {
		super();
	}

	public EducationLoanDetailsEntity(String educationLoanId, Long educationLoanAccountNumber, UserDetailsEntity user,
			Long educationLoanAmount, Date educationLoanApplyDate, Integer educationLoanDuration,
			Long fatherAnnualIncome, Long courseFee, String courseName, String fatherName, Long idCardNumber, Long accountNumber) {
		super();
		this.educationLoanId = educationLoanId;
		this.educationLoanAccountNumber = educationLoanAccountNumber;
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
}