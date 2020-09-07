<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title><spring:message code="label.applyeducationloanmessage" /></title>
<!-- Latest compiled and minified CSS -->
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">

<!-- jQuery library -->
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>

<!-- Latest compiled JavaScript -->
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
</head>
<body>
	<h3 align="center">
		<spring:message code="label.applyeducationloanmessage" /> <a href="<spring:message code="label.home" />"
			style="float: left; padding-right: 10px" class="ui-btn ui-btn-inline"><spring:message
				code="label.homepage" /></a>
	</h3>
	<form:form commandName="educationLoanBean" action="doEducationLoan"
		method="post">
		<table align="center">
			<tr>
				<td><spring:message code="label.accountNumber" /></td>
				<td><form:input path="user.accountNumber" cssClass="error" /></td>
				<td><form:errors path="user.accountNumber" cssClass="error"></form:errors>
				</td>
			</tr>
			<tr>
				<td><spring:message code="label.loanAmount" /></td>
				<td><form:input path="educationLoanAmount" cssClass="error" /></td>
				<td><form:errors path="educationLoanAmount" cssClass="error"></form:errors>
				</td>
			</tr>
			<tr>
				<td><spring:message code="label.loanApplyDate" /></td>
				<td><form:input path="educationLoanApplyDate" cssClass="error" /></td>
				<td><form:errors path="educationLoanApplyDate" cssClass="error"></form:errors>
				</td>
			</tr>
			<tr>
				<td><spring:message code="label.loanDuration" /></td>
				<td><form:select path="educationLoanDuration">
						<form:option value="" label="---select---" />
						<form:option value="5" label="5" />
						<form:option value="10" label="10" />
					</form:select></td>
				<td><form:errors path="educationLoanDuration" cssClass="error"></form:errors>
				</td>
			</tr>
			<tr>
				<td><spring:message code="label.courseName" /></td>
				<td><form:input path="courseName" cssClass="error" /></td>
				<td><form:errors path="courseName" cssClass="error"></form:errors>
				</td>
			</tr>
			<tr>
				<td><spring:message code="label.courseFee" /></td>
				<td><form:input path="courseFee" cssClass="error" /></td>
				<td><form:errors path="courseFee" cssClass="error"></form:errors>
				</td>
			</tr>
			<tr>
				<td><spring:message code="label.fatherName" /></td>
				<td><form:input path="fatherName" cssClass="error" /></td>
				<td><form:errors path="fatherName" cssClass="error"></form:errors>
				</td>
			</tr>

			<tr>
				<td><spring:message code="label.idNumber" /></td>
				<td><form:input path="idCardNumber" cssClass="error" /></td>
				<td><form:errors path="idCardNumber" cssClass="error"></form:errors>
				</td>
			</tr>

			<tr>
				<td><spring:message code="label.fatherAnnualIncome" /></td>
				<td><form:input path="fatherAnnualIncome" cssClass="error" /></td>
				<td><form:errors path="fatherAnnualIncome" cssClass="error"></form:errors>
				</td>
			</tr>
			<tr>
				<td colspan="2"><input type="submit"
					value=<spring:message code="label.submit" /> /></td>
			</tr>
		</table>
		<div align="center">
			<c:if test="${not empty accountNumber}">
				<spring:message code="label.educationLoanSuccessMessage" /> ${accountNumber}
 	</c:if>
			<c:if test="${not empty errorMessage}">
 	${errorMessage}
 	</c:if>
		</div>
	</form:form>
</body>