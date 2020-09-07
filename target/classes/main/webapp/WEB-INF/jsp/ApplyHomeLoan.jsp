<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>

<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title><spring:message code="label.applyhomeloanmessage" /></title>
<!-- Latest compiled and minified CSS -->
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">

<!-- jQuery library -->
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>

<!-- Latest compiled JavaScript -->
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
</head>
<body>
	<h3 align="center">
		<spring:message code="label.applyhomeloanmessage" />
		<a href="<spring:message code="label.home" />"
			style="float: left; padding-right: 10px" class="ui-btn ui-btn-inline"><spring:message
				code="label.homepage" /></a>
	</h3>
	<form:form commandName="homeLoanBean" action="doHomeLoan" method="post">
		<table align="center">
			<tr>
				<td><spring:message code="label.accountNumber" /></td>
				<td><form:input path="user.accountNumber" /></td>
				<td><form:errors path="user.accountNumber" ></form:errors>
				</td>
			</tr>
			<tr>
				<td><spring:message code="label.loanAmount" /></td>
				<td><form:input path="loanAmount" /></td>
				<td><form:errors path="loanAmount" ></form:errors>
				</td>
			</tr>
			<tr>
				<td><spring:message code="label.loanApplyDate" /></td>
				<td><form:input path="loanApplyDate"  /></td>
				<td><form:errors path="loanApplyDate" ></form:errors>
				</td>
			</tr>
			<tr>
				<td><spring:message code="label.loanDuration" /></td>
				<td><form:select path="loanDuration">
						<form:option value="" label="---select---" />
						<form:option value="5" label="5" />
						<form:option value="10" label="10" />
						<form:option value="15" label="15" />
						<form:option value="20" label="20" />
						<td><form:errors path="loanDuration"></form:errors></td>
					</form:select></td>
			</tr>
			<tr>
				<td><spring:message code="label.annaulIncome" /></td>
				<td><form:input path="annualIncome"  /></td>
				<td><form:errors path="annualIncome" ></form:errors>
				</td>
			</tr>
			<tr>
				<td><spring:message code="label.companyName" /></td>
				<td><form:input path="companyName"  /></td>
				<td><form:errors path="companyName" ></form:errors>
				</td>
			</tr>
			<tr>

				<td><spring:message code="label.designation" /></td>
				<td><form:input path="designation" /></td>
				<td><form:errors path="designation" ></form:errors>
				</td>
			</tr>
			<tr>
				<td><spring:message code="label.totalExperience" /></td>
				<td><form:input path="totalExperience" /></td>
				<td><form:errors path="totalExperience" ></form:errors>
				</td>
			</tr>
			<tr>
				<td><spring:message code="label.currentExperience" /></td>
				<td><form:input path="currentExperience" /></td>
				<td><form:errors path="currentExperience" ></form:errors>
				</td>
			</tr>
			<tr>
				<td colspan="2"><input type="submit"
					value=<spring:message code="label.submit" /> /></td>
			</tr>
		</table>
		<div align="center">
			<c:if test="${not empty accountNumber}">
				<spring:message code="label.homeLoanSuccessMessage" /> ${accountNumber}
 	</c:if>
			<c:if test="${not empty errorMessage}">
 	${errorMessage}
 	</c:if>
		</div>
	</form:form>
</body>
</html>