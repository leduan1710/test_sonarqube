<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>

<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<title>Nhóm 16</title>
<link
	href="//maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css"
	rel="stylesheet" id="bootstrap-css" />
<link rel="stylesheet"
	href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.2.1/css/all.min.css" />
<!------ Include the above in your HEAD tag ---------->
</head>
<body>
	<jsp:include page="../home/Header.jsp"></jsp:include>
	<div class="container">
		<div class="row">
			<div class="col">
				<nav aria-label="breadcrumb" class="bg-light mb-3">
					<ol class="breadcrumb mb-0">
						<li class="breadcrumb-item"><a href="home">Home</a></li>
						<li class="breadcrumb-item"><a href="profile">User</a></li>
						<li class="breadcrumb-item active" aria-current="page">User
							Profile</li>
					</ol>
				</nav>
			</div>
		</div>
	</div>

	<section style="background-color: #eee;">
		<form action = "edit" method = "post">
			<div class="container">
				<div class="row">
					<div class="col-lg-4">
						<div class="card mb-4">
							<div class="card-body text-center">
								<img
									src="https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcRt0XikLERJ8A3kTEC6_j9lMiLFu7-27j_AyA&usqp=CAU"
									alt="avatar" class="rounded-circle img-fluid"
									style="width: 120px;">
								<h5 class="my-3">${user.userName }</h5>
								<div class="text-center">
									<button type="button" id="submit" name="submit"
										class="btn btn-primary">Change Image</button>
								</div>

							</div>
						</div>
					</div>
					<div class="col-xl-8 col-lg-12 col-md-12 col-sm-12 col-12">
						<div class="card  mb-4">
							<div class="card-body">
								<div class="row">
									<div class="col-xl-12 col-lg-12 col-md-12 col-sm-12 col-12">
										<h6 class="mb-2 text-primary">Personal Details</h6>
									</div>
									<div class="col-xl-6 col-lg-6 col-md-6 col-sm-6 col-12">
										<div class="form-group">
											<label>Full Name</label> <input
												class="form-control" name="fullName"
												placeholder="Enter full name" required autofocus value = "${user.fullName }">
											<p class="text-danger">${message}</p>
										</div>
									</div>
									<div class="col-xl-6 col-lg-6 col-md-6 col-sm-6 col-12">
										<div class="form-group">
											<label>Email</label> <input type="email"
												class="form-control" name="email"
												placeholder="Enter email ID" autofocus value = "${user.email }">
										</div>
									</div>
									<div class="col-xl-6 col-lg-6 col-md-6 col-sm-6 col-12">
										<div class="form-group">
											<label>Phone</label> <input type="text"
												class="form-control" name="phone"
												placeholder="Enter phone number" autofocus value = "${user.phone }">
										</div>
									</div>
									<div class="col-xl-6 col-lg-6 col-md-6 col-sm-6 col-12">
										<div class="form-group">
											<label>Address</label> <input type="text"
												class="form-control" name="address" placeholder="Address"
												autofocus value = "${user.addresses }">
										</div>
									</div>
								</div>
								<div class="row">
									<div class="col-xl-12 col-lg-12 col-md-12 col-sm-12 col-12">
										<div class="text-right">
											<button type="submit" 
												class="btn btn-primary">Update</button>
										</div>
									</div>
								</div>
							</div>
						</div>
					</div>
				</div>
			</div>
		</form>
	</section>
	<jsp:include page="../home/Footer.jsp"></jsp:include>
</body>
</html>