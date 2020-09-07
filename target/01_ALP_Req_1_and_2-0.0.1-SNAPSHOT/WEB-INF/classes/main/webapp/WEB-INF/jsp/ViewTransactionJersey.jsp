<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>

<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>View Transaction</title>
<script
  src="https://code.jquery.com/jquery-3.2.1.min.js"  integrity="sha256-hwg4gsxgFZhOsEEamdOYGBf13FyQuiTwlAQgxVSNgt4="  crossorigin="anonymous">
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

<script type="text/javascript">

$(function(){
    $("#frm_details").on("submit", function(event) {
        
    	event.preventDefault();
	
        var accountNumber = $('input[name=accountNumber]').val() //for getting accountNumber 
        alert(accountNumber)
        var transactionId = $('input[name=transactionId]').val() //for getting transactionId
        alert(transactionId)
      

        $.ajax({
            url: "viewTransactionNew",
            type: "POST",
            data: "accountNumber="+accountNumber+"&transactionId="+transactionId, 
            success: function(response) {
            	 var obj = JSON.parse(response);
            	 alert("Test Success" + obj)
            	 $('.result').html(obj);
            },
   	 	    error: function(){
   	 		 alert("Test Fail");
   	 	    } 	
        });
    });
}) 




</script>

</head>
<body >
	<h3 align="center">
	<spring:message code="label.viewTransactionMessage" /> 
	<a href="home" style="float: right; padding-right: 10px"><spring:message code="label.home" /></a>
	</h3>
	<form id="frm_details" name="frm_details">
	<table align="center">
	<tr>
	<td><spring:message code="label.accountNumber" /></td>
	<td><input  id="acNumber" type="text" name="accountNumber"	 /></td>
	</tr>
	<tr>
	<td><spring:message code="label.transactionId" /></td>
	<td><input  id="tranId" type="text" name="transactionId"	/></td>
	</tr>
	<tr>
	<td colspan="2"><input type="submit"  value=<spring:message code="label.getDetails" /> /></td>
	</tr>
	</table>
	</form>
	<br>
	<br>
	<br>
	<br>
<div id = "result">

<c:forEach items="${transactionView}" var = "item">

	<c:out value="${item.transactionId}"></c:out>
	<c:out value="${item.transactionDescription}"></c:out>
	<c:out value="${item.transactionType}"></c:out>
	<c:out value="${item.transactionAmount}"></c:out>
	<c:out value="${item.accountNumber}"></c:out>




</c:forEach>



</div>

</body>
</html>