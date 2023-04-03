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
<%@include file="../css/style.css"%>
</style>
</head>
<body>
	<jsp:include page="Header.jsp"></jsp:include>
	<div class="container-add">
		<form action="<c:url value="/seller/saveOrUpdate" />" method="POST">
			<div class="card">
				<div class="card-header">
					<h2>${products.isEdit ? 'Edit Product' : 'Add New Product'}</h2>
				</div>
				<input type="hidden" value="${products.isEdit}">
				<lable>Product Id:</lable>
				<input type="text" readonly="readonly" id="procductId"
					value="${products.productId}" name="productId"
					placeholder="Product Id" class="form-control"
					aria-describedly="productId"></input>
				<lable>Store Id:</lable>
				<input type="text" readonly="readonly" id="storeId"
					value="${storeId}" name="storeId"
					placeholder="Store Id" class="form-control"
					aria-describedly="storeId"></input>
				<lable>Product Category</lable>
				<div>
				 <select class="form-select form-select-sm""
						 name="category" id="category">
						<option selected>Open this select menu</option>
						<c:forEach items="${categories}" var="category">
							<option value="${category.categoryId }">${category.name }</option>
						</c:forEach>

					</select>
				</div>

				<lable >Product Name:</lable>
				<input type="text" id="name" name="name" value="${products.name}"
					placeholder="Product Name" class="form-control"
					aria-describedly="name"></input>
				<lable >Product Price:</lable>
				<input type="text" id="price" name="price" value="${products.price}"
					placeholder="Product Price" class="form-control"
					aria-describedly="price"></input>
				<lable >Product Quantity:</lable>
				<input type="text" id="quantity" name="quantity"
					value="${products.quantity}" placeholder="Product Quantity"
					class="form-control" aria-describedly="quantity"></input>

			</div>
			<div class="card-footer text-muted">
				<a href="<c:url value="/seller/add/${sessionScope.store.storeId }" />" class="btn btn-secondary"><i
					class="fas fa-new"></i>New</a> <a href="<c:url value="/seller/${sessionScope.store.storeId }" />"
					class="btn btn-success"><i class="fas fa-new"></i>List
					Categories</a>
				<button class="btn btn-primary" type="submit">
					<i class="fas fa-save"></i>
					<c:if test="${products.isEdit}">
						<span>Update</span>
					</c:if>
					<c:if test="${!products.isEdit}">
						<span>Save</span>
					</c:if>
				</button>
			</div>
		</form>
	

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

