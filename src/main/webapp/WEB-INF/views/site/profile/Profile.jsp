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
	<jsp:include page = "../home/Header.jsp"></jsp:include>
	<section style="background-color: #eee;">
		<div class="container">
			<div class="row">
				<div class="col">
					<nav aria-label="breadcrumb" class="bg-light mb-3">
						<ol class="breadcrumb mb-0">
							<li class="breadcrumb-item"><a href="home">Home</a></li>
							<li class="breadcrumb-item"><a href="#">User</a></li>
							<li class="breadcrumb-item active" aria-current="page">User
								Profile</li>
						</ol>
					</nav>
				</div>
			</div>

			<div class="row">
				<div class="col-lg-4">
					<div class="card mb-4">
						<div class="card-body text-center">
							<img
								src="https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcRt0XikLERJ8A3kTEC6_j9lMiLFu7-27j_AyA&usqp=CAU"
								alt="avatar" class="rounded-circle img-fluid"
								style="width: 120px;">
							<h5 class="my-3">${user.userName }</h5>

							<a href="edit">
								<button class="btn btn-primary btn-block mb-4 " type="submit">
									<i class="fa fa-edit"></i> Edit Profile
								</button>
							</a>
							<c:if test="${sessionScope.user.role == 1 }">
								<a href="register">
									<button class="btn btn-primary btn-block" type="submit">
										<i class="fas fa-store-alt"></i> Store Registration
									</button>
								</a>
							</c:if>
							<c:if test="${sessionScope.user.role == 2 }">
								<a href="seller/${sessionScope.store.storeId}">
									<button class="btn btn-primary btn-block" type="submit">
										<i class="fas fa-store-alt"></i> My Store
									</button>
								</a>
							</c:if>

						</div>
					</div>

				</div>
				<div class="col-lg-8">
					<div class="card mb-4">
						<div class="card-body">
							<div class="row">
								<div class="col-sm-3">
									<p class="mb-0">Full Name</p>
								</div>
								<div class="col-sm-9">
									<p class="text-muted mb-0">${user.fullName}</p>
								</div>
							</div>
							<hr>
							<div class="row">
								<div class="col-sm-3">
									<p class="mb-0">Email</p>
								</div>
								<div class="col-sm-9">
									<p class="text-muted mb-0">${user.email}</p>
								</div>
							</div>
							<hr>
							<div class="row">
								<div class="col-sm-3">
									<p class="mb-0">Phone</p>
								</div>
								<div class="col-sm-9">
									<p class="text-muted mb-0">${user.phone}</p>
								</div>
							</div>
							<hr>
							<div class="row">
								<div class="col-sm-3">
									<p class="mb-0">Address</p>
								</div>
								<div class="col-sm-9">
									<p class="text-muted mb-0">${user.addresses}</p>
								</div>
							</div>
						</div>
					</div>	
				</div>
			</div>
		</div>
	</section>
	<jsp:include page = "../home/Footer.jsp"></jsp:include>
</body>
</html>