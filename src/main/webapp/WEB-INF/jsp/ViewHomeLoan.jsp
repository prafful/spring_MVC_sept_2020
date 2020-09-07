<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title><spring:message code="label.viewHomeLoanMessage" /></title>
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

	app.controller("homeLoanCtrl", function($scope, $http) {
		$scope.homeLoanController = function() {
			if (!$scope.homeLoanId && !$scope.loanAccountNumber) {
				alert("Fill atleast one field");
				return false;
			} 
			console.log("called");
			console.log($scope.loanAccountNumber);
			console.log($scope.homeLoanId);
			$http({
				method : 'POST',
				url : 'viewHomeLoanDetail',
				params : {
					homeLoanId : $scope.homeLoanId,
					loanAccountNumber : $scope.loanAccountNumber
				}
			}).then(function successCallback(response) {
				alert(response);
				$scope.details = response.data;
				if($scope.details.length == 0) {
					alert("No record found");
				};
			}, function errorCallback(response) {
				// called asynchronously if an error occurs
				// or server returns response with an error status.
			});
		}
	});
</script>

</head>
<body ng-app="bankManagementApp" ng-controller="homeLoanCtrl">
	<h3 align="center">
		<spring:message code="label.viewHomeLoanMessage" /> <a href="<spring:message code="label.home" />"
			style="float: left; padding-right: 10px" class="ui-btn ui-btn-inline"><spring:message code="label.homepage" /></a>
	</h3>
	<form id="myform" ng-submit="homeLoanController()">
		<table align="center">
			<tr>
				<td><spring:message code="label.loanIdNumber" /></td>
				<td><input type="text" name="homeLoanId" ng-model="homeLoanId" /></td>
			</tr>
			<tr>
				<td><spring:message code="label.loanAccountNumber" /></td>
				<td><input type="text" name="loanAccountNumber"
					ng-model="loanAccountNumber" /></td>
			</tr>
			<tr>
				<td colspan="2"><input type="submit" value=<spring:message code="label.getDetails" /> /></td>
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
				<th colspan="6" align="center">Home Loan Details</th>
			</tr>
			<tr>
				<th>Account Holder Name</th>
				<th>Home Loan Account Number</th>
				<th>Home Loan Id</th>
				<th>Loan Amount</th>
				<th>Designation</th>
				<th>Company Name</th>
			</tr>
			<tr ng-repeat="detail in details">
				<td>{{detail.user.accountHolderName}}</td>
				<td>{{detail.loanAccountNumber}}</td>
				<td>{{detail.homeLoanId}}</td>
				<td>{{detail.loanAmount}}</td>
				<td>{{detail.designation}}</td>
				<td>{{detail.companyName}}</td>
			</tr>
		</table>
	</div>
</body>
</html>