<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>CTS Bank</title>
 
<!-- Latest compiled and minified CSS -->
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">

<!-- jQuery library -->
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>

<!-- Latest compiled JavaScript -->
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
</head>
<body style="text-align: center;">
	<h1 align="center">Bank Management Application</h1>

	<ul >
		 <div class="list-group">   
		<li class="list-group-item list-group-item-success" >Transaction</li>     
		<li class="list-group-item list-group-item-success"><a href="performTransaction">     
				<h2>Perform Transaction</h2>     
				<p>
					<strong>You can perform transaction in your account with
						CTS bank. Deposit or Withdraw the amount.</strong>
				</p>     
				<p>Use your account number to perform the debit/credit
					transaction.</p>            
		</a></li> 
		</div>    
		<li class="list-group-item list-group-item-success"><a href="viewTransaction">     
				<h2>View Transaction</h2>     
				<p>
					<strong>You can view the transaction you did in yoou
						account with CTS Bank.</strong>
				</p>     
				<p>Input the transaction ID and account number for get the
					details of the repective transaction</p>            
		</a></li> .
		
		<div class="list-group">        
		<li class="list-group-item list-group-item-info">Home Loan</li>     
		<li class="list-group-item list-group-item-info"><a href="applyHomeLoan">     
				<h2>Apply Home Loan</h2>     
				<p>
					<strong>Apply for the home loan. You can do it only once
						for your account.</strong>
				</p>     
				<p>Input your account number and required details to apply for
					home loan. You will get the home loan account number if the
					application is successful.</p>             
		</a></li>     
		<li class="list-group-item list-group-item-info"><a href="viewHomeLoan">     
				<h2>View Home Loan</h2>     
				<p>
					<strong>View the details for your home loan application.</strong>
				</p>     
				<p>Input the home loan account number and home loan ID to view
					the details of your home loan application.</p>              
		</a></li> 
		</div> 
		
		
		 <div class="list-group">   
		<li class="list-group-item list-group-item-danger">Education Loan</li>     
		<li class="list-group-item list-group-item-danger"><a href="applyEducationLoan">     
				<h2>Apply Education Loan</h2>     
				<p>
					<strong>Apply for the education loan.</strong>
				</p>     
				<p>Input your account number and required details to apply for
					education loan. You will get the education loan account number if
					the application is successful.</p>           
		</a></li>  
		
		   
		<li class="list-group-item list-group-item-danger"><a href="viewEducationLoan">     
				<h2>View Education Loan</h2>     
				<p>
					<strong>View the details for your home loan application.</strong>
				</p>     
				<p>Input the education loan account number and education loan ID
					to view the details of your education loan application.</p>         
				    
		</a></li>
		</div>
		
	</ul>



</body>
</html>

