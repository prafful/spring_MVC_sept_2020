<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>

<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title><spring:message code="label.viewTransactionMessage" /></title>
<!-- Latest compiled and minified CSS -->
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">

<!-- jQuery library -->
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>

<!-- Latest compiled JavaScript -->
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
<script
	src="https://ajax.googleapis.com/ajax/libs/angularjs/1.6.4/angular.min.js">
</script>

<script>
	var app = angular.module("bankManagementApp", []);

	app.controller("transactionCtrl", function($scope, $http) {
		$scope.transactionController = function() {
			if (!$scope.accountNumber && !$scope.transactionId) {
				alert("Fill atleast one field");
				return false;
			}
			$http({
				method : 'POST',
				url : 'viewTransactionDetail',
				params : {
					accountNumber : $scope.accountNumber,
					transactionId : $scope.transactionId
				}
			}).then(function successCallback(response) {
				alert(response);
				$scope.details = response.data;
				if ($scope.details.length == 0) {
					alert("No record found");
				}
				;
			}, function errorCallback(response) {

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
<body ng-app="bankManagementApp" ng-controller="transactionCtrl">
	<h3 align="center">
		<spring:message code="label.viewTransactionMessage" />
		<a href="<spring:message code="label.home" />" style="float: left; padding-right: 10px"><spring:message
				code="label.homepage" /></a>
	</h3>
	<form id="myform" ng-submit="transactionController()" class="form-group">
		<table align="center">
			<tr>
				<td><spring:message code="label.accountNumber" /></td>
				<td><input type="text" name="accountNumber"
					ng-model="accountNumber" /></td>
			</tr>
			<tr>
				<td><spring:message code="label.transactionId" /></td>
				<td><input type="text" name="transactionId"
					ng-model="transactionId" /></td>
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
				<th colspan="7sss" align="center">Transaction Details</th>
			</tr>
			<tr>
				<th>Transaction Id</th>
				<th>Transaction Description</th>
				<th>Transaction Type</th>
				<th>Transaction Amount</th>
				<th>User Name</th>
				<th>Account Balance</th>
				<th>Account Number</th>
			</tr>
			<tr ng-repeat="detail in details">
				<td>{{detail.transactionId}}</td>
				<td>{{detail.transactionDescription}}</td>
				<td>{{detail.transactionType}}</td>
				<td>{{detail.transactionAmount}}</td>
				<td>{{detail.user.accountHolderName}}</td>
				<td>{{detail.user.accountBalance}}</td>
				<td>{{detail.user.accountNumber}}</td>
			</tr>
		</table>
	</div>

</body>
</html>