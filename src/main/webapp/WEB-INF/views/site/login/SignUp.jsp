<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!------ Include the above in your HEAD tag ---------->

<!DOCTYPE html>
<html lang="en">
	<head>
		<meta charset="UTF-8">
		<meta name="viewport" content="width=device-width, initial-scale=1.0">
		<meta http-equiv="X-UA-Compatible" content="ie=edge">
		<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css">
		<link rel="stylesheet" href="https://use.fontawesome.com/releases/v5.3.1/css/all.css">
		<style> 
			<%@include file = "../css/login.css"%>
		</style>
		<title>SignUp Form</title>
	</head>
	<body>
	<div id="logreg-forms">
		<form action="signup" method="post" class="form-login">
			<h1 class="h3 mb-3 font-weight-normal" style="text-align: center">Sign up</h1>
			<input name="user" type="text" id="user-name" class="form-control" placeholder="User name" required autofocus=""> 
			<input name="pass" type="password" id="user-pass" class="form-control" placeholder="Password" required autofocus="">
			<input name="repass" type="password" id="user-repeatpass" class="form-control" placeholder="Repeat Password" required autofocus="">
			<input name="fullname" type="text" id="fullname" class="form-control" placeholder="Full Name" required autofocus="">
			<p class = "text-danger">${message}</p>
			<button class="btn btn-primary btn-block" type="submit">
				<i class="fas fa-user-plus"></i> Sign Up
			</button>
			<a href="login" id="cancel_signup"><i class="fas fa-angle-left"></i>Back</a>
		</form>
	</div>
	<script
		src="https://cdnjs.cloudflare.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
	<script
		src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js"></script>
</body>
</html>