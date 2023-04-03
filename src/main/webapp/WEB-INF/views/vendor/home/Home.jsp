<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
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
<%@ include file="../css/style.css"%>
</style>
</head>
<body>
	<jsp:include page="Header.jsp"></jsp:include>
	<div class="container-vendor row">
				<c:if test="${message != null}">
					<div class="alert alert-primary" role="alert">
						<i>${message}</i>
					</div>
				</c:if>
		<div class="col-sm-6  store" style=" font-family: Consolas, Helvetica, sans-serif">
		
			<h1>Name: ${store.name}</h1>
			<h2>ADDRESS:${store.address}</h2>
			<h3>PHONE:${store.phone }</h3>
		</div>
		<div class="col-sm-6">
			<form action="/seller/StoreEdit/${store.storeId} " method="get">
				<button class="btn btn-primary">Edit Store</button>			
			</form>
		</div>
		<div class="col-sm-12 table-vendor">
			<table class="table table-striped table-responsive">
				<thead class="thead-inverse">
					<tr>
						<th>Product Id</th>
						<th>Name</th>
						<th>Category</th>
						<th>Store</th>
						<th>Price</th>
						<th>Quantity</th>
						<th>Action</th>
					</tr>
				</thead>
				<tbody>
					<c:forEach items="${products}" var="object">
						<tr>
							<td scope="row">${object.productId}</td>
							<td>${object.name}</td>
							<td>${object.category.name}</td>
							<td>${object.store.name}</td>
							<td>${object.price}</td>
							<td>${object.quantity}</td>
							<td><a href="/detail?pid=${object.productId}"
								class="btn btn-outline-info"><i class="fa fa-info"></i></a> <a
								href="/seller/edit/${object.productId}"
								class="btn btn-outline-warning"><i class="fa fa-edit"></i></a> <a
								href="/seller/delete/${object.productId}"
								class="btn btn-outline-danger"><i class="fa fa-trash"></i></a></td>
						</tr>
					</c:forEach>
				</tbody>
			</table>
			<form action="/seller/add/${store.storeId} " method="get">
				<button class="btn btn-primary">Add</button>
			</form>
			<div class="col-sm-12" style="margin-top: 50px">Thống kê</div>
			<div class="col-sm-12 table-cartItem-vendor">
				<table class="table table-striped table-responsive">
					<thead class="thead-inverse">
						<tr>
							<th>Product</th>
							<th>Count</th>
							<th>Price</th>
						</tr>
					</thead>
					<tbody>
						<c:forEach items="${cartItem}" var="object">
							<tr>
								<td>${object.product.name}</td>
								<td scope="row">${object.count}</td>
								<td>${object.product.price}</td>
						</c:forEach>
					</tbody>
				</table>
				<div class = "col-sm-12">
					<h1 style = "text-align: center;">Total: ${total }</h1>
				</div>
			</div>
		</div>
	</div>

	<jsp:include page="Footer.jsp"></jsp:include>
	<script
		src="//maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js"></script>
	<script
		src="//cdnjs.cloudflare.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
	<script
		src="https://cdn.jsdelivr.net/npm/jquery@3.6.1/dist/jquery.slim.min.js"></script>
	<script
		src="https://cdn.jsdelivr.net/npm/popper.js@1.16.1/dist/umd/popper.min.js"></script>
	<script
		src="https://cdn.jsdelivr.net/npm/bootstrap@4.6.2/dist/js/bootstrap.bundle.min.js"></script>

</body>
</html>

