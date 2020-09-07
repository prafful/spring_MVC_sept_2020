<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>

<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Perform Transaction</title>

<!-- Latest compiled and minified CSS -->
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">

<!-- jQuery library -->
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>

<!-- Latest compiled JavaScript -->
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
</head>
<body>
	<h3 align="center">
		<spring:message code="label.performtransactionmessage" />
		<a href="<spring:message code="label.home" />"
			style="float: left; padding-right: 10px" class="ui-btn ui-btn-inline"><spring:message
				code="label.homepage" /></a>
	</h3>
	<form:form commandName="transactionBean" action="doTransaction"
		method="post" class="form-group">
		<table align="center">
			<tr>
				<td><spring:message code="label.accountNumber" /></td>
				<td><form:input path="user.accountNumber" /></td>
				<td><form:errors path="user.accountNumber" cssClass="error"></form:errors></td>
			</tr>
			<tr>
				<td><spring:message code="label.transitionDescription" /></td>
				<td><form:input path="transactionDescription" /></td>
				<td><form:errors path="transactionDescription" cssClass="error"></form:errors></td>
			</tr>
			<tr>
				<td><spring:message code="label.transactionType" /></td>
				<td><form:select path="transactionType">
						<form:option value="" label="---select---" />
						<form:option value="debit" label="Withdraw" />
						<form:option value="credit" label="Deposit" />
						<td><form:errors path="transactionType" cssClass="error"></form:errors></td>
					</form:select></td>
			</tr>
			<tr>
				<td><spring:message code="label.transactionAmount" /></td>
				<td><form:input path="transactionAmount" /></td>
				<td><form:errors path="transactionAmount" cssClass="error"></form:errors></td>
			</tr>
			<tr>
				<td colspan="2"><input type="submit"
					value=<spring:message code="label.submit" /> /></td>
			</tr>
		</table>
		<div align="center">
			<c:if test="${not empty balance}">
				<spring:message code="label.transactionSuccessMessage" /> ${balance}
 	</c:if>
			<c:if test="${not empty errorMessage}">
 	${errorMessage}
 	</c:if>
		</div>
	</form:form>
</body>
</html>