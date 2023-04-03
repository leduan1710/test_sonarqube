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
		<title>Store Registration</title>
	</head>
	<body>
	<div id="logreg-forms">
		<form action="register" method="post" class="form-login">
			<h1 class="h3 mb-3 font-weight-normal" style="text-align: center">Store Registration</h1>
			<input name="name" type="text" id="store-name" class="form-control" required placeholder="Store name" autofocus="" value = "${store.name}"> 
			<p class = "text-danger">${message}</p>
			<input name="email" type="email" id="email" class="form-control" required placeholder="Email" autofocus="" value = "${store.email }">
			<input name="phone" type="text" id="phone" class="form-control" required placeholder="Phone" autofocus="" value = "${store.phone }">
			<input name="address" type="text" id="address" class="form-control" required placeholder="Address" autofocus="" value = "${store.address }">
			<button class="btn btn-primary btn-block" type="submit">
				<i class="fas fa-user-plus"></i> Registration
			</button>
			<a href="profile" id="cancel_signup"><i class="fas fa-angle-left"></i>Back</a>
		</form>
	</div>
	<script
		src="https://cdnjs.cloudflare.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
	<script
		src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js"></script>
</body>
</html>