<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title><spring:message code="label.viewEducationLoanMessage" /></title>
<!-- Latest compiled and minified CSS -->
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">

<!-- jQuery library -->
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>

<!-- Latest compiled JavaScript -->
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
<script
	src="https://ajax.googleapis.com/ajax/libs/angularjs/1.6.4/angular.min.js"></script>
<script>
	var app = angular.module("bankManagementApp", []);

	app.controller("educationLoanCtrl", function($scope, $http) {
		$scope.educationLoanController = function() {
			if (!$scope.idNumber && !$scope.loanAccountNumber) {
				alert("Fill atleast one field");
				return false;
			}
			console.log("called");
			console.log($scope.loanAccountNumber);
			console.log($scope.idNumber);
			$http({
				method : 'POST',
				url : 'viewEducationLoanDetail',
				params : {
					identificationCardNumber : $scope.identificationCardNumber,
					loanAccountNumber : $scope.loanAccountNumber
				}
			}).then(function successCallback(response) {
				$scope.details = response.data;
				if ($scope.details.length == 0) {
					alert("No record found");
				}
				;
			}, function errorCallback(response) {
				alert("Wrong Input");
			});
		}
	});
</script>
<style>
table.mytable td {
	border: 1px solid black;
}

table.mytable th {
	border: 1px solid black;
}

table.mytable {
	border: 1px solid black;
}

#mytable {
	border-collapse: collapse;
	width: 100%;
}

th {
	height: 50px;
}
</style>
</head>
<body ng-app="bankManagementApp" ng-controller="educationLoanCtrl">
	<h3 align="center">
		<spring:message code="label.viewEducationLoanMessage" />
		<a href="<spring:message code="label.home" />" style="float: left; padding-right: 10px" class="ui-btn ui-btn-inline"><spring:message
				code="label.homepage" /></a>
	</h3>
	<form id="myform" ng-submit="educationLoanController()">
		<table align="center">
			<tr>
				<td><spring:message code="label.loanIdNumber" /></td>
				<td><input type="text" name="idNumber"
					ng-model="identificationCardNumber" /></td>
			</tr>
			<tr>
				<td><spring:message code="label.loanAccountNumber" /></td>
				<td><input type="text" name="loanAccountNumber"
					ng-model="loanAccountNumber" /></td>
			</tr>
			<tr>
				<td colspan="2"><input type="submit"
					value=<spring:message code="label.getDetails" /> /></td>
			</tr>
		</table>
	</form>
	<br>
	<br>
	<br>
	<br>
	<div>
		<table ng-show="details.length" class="mytable" align="center">
			<tr>
				<th colspan="5" align="center">Education Loan Details</th>
			</tr>
			<tr>
				<th>Account Holder Name</th>
				<th>Education Loan Id</th>
				<th>Education Loan Amount</th>
				<th>Course Name</th>
				<th>Father Name</th>
			</tr>
			<tr ng-repeat="detail in details">
				<td>{{detail.user.accountHolderName}}</td>
				<td>{{detail.educationLoanAmount}}</td>
				<td>{{detail.educationLoanId}}</td>
				<td>{{detail.courseName}}</td>
				<td>{{detail.fatherName}}</td>
			</tr>
		</table>
	</div>
</body>
</html>