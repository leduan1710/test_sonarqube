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
<style>
	<%@include file="../css/style.css"%>
</style>
</head>
<body>
	<jsp:include page="Header.jsp"></jsp:include>
	<div class="container">
		<div class="row">
			<div class="col">
				<nav aria-label="breadcrumb">
					<ol class="breadcrumb">
						<li class="breadcrumb-item"><a href="home">Home</a></li>
						<li class="breadcrumb-item"><a href="#">Category</a></li>
						<li class="breadcrumb-item active" aria-current="#">Sub-category</li>
					</ol>
				</nav>
			</div>
		</div>
	</div>
	<div class="container">
		<div class="row">
			<div class="col-sm-3">
				<div class="card bg-light mb-3">
					<div class="card-header bg-light text-dark text-uppercase">
						<i class="fa fa-list"></i> Categories
					</div>
					<ul class="list-group category_block">
						<c:forEach items="${categories }" var="object">
							<a class="list-group-item text-dark ${tag == object.categoryId ? "list-group-item-success":""}" d-block
								href="category?cid=${object.categoryId}">${object.name }
							</a>
						</c:forEach>
					</ul>
				</div>
			</div>

			<div class="col-sm-9">
				<div class="row">
					<c:forEach items="${products}" var="object">
						<div class="col-12 col-md-6 col-lg-4 mt-2">
							<div class="card">
								<img class="card-img-top h-img"
									src="${object.urlImage}"
									alt="Card image cap">
								<div class="card-body">
									<h4 class="card-title show_txt">
										<a class = "text-dark" href="detail?pid=${object.productId }" title="View Product">${object.name }</a>
									</h4>
									<p class="card-text show_txt"></p>
									<div class="row">
										<div class="col">
											<p class="btn btn-danger btn-block">${object.price }$</p>
										</div>
										<div class="col">
											<a href="add?pid=${object.productId}" class="btn btn-success btn-block">Add to cart</a>
										</div>
									</div>
								</div>
							</div>
						</div>
					</c:forEach>
				</div>
			</div>

		</div>
	</div>

	<jsp:include page="Footer.jsp"></jsp:include>
	<script
		src="//maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js"></script>
	<script
		src="//cdnjs.cloudflare.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
	<script src="https://cdn.jsdelivr.net/npm/jquery@3.6.1/dist/jquery.slim.min.js"></script>
 	<script src="https://cdn.jsdelivr.net/npm/popper.js@1.16.1/dist/umd/popper.min.js"></script>
 	<script src="https://cdn.jsdelivr.net/npm/bootstrap@4.6.2/dist/js/bootstrap.bundle.min.js"></script>
	
</body>
</html>

