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
		<form action="<c:url value="/seller/EditStore" />" method="POST">
			<div class="card">
				<div class="card-header">
					<h2>Edit Store</h2>
				</div>
				<lable>Store Id:</lable>
				<input type="text" readonly="readonly" id="storeId"
					value="${store.storeId}" name="storeId"
					placeholder="Store Id" class="form-control"
					aria-describedly="storeId"></input>
				<lable>User Id</lable>
				<input type="text" readonly="readonly" id="userId" name="userId" value="${store.userStore.userId}"
					placeholder="User ID" class="form-control"
					aria-describedly="userStore"></input>
				<lable >Store name:</lable>
				<input type="text" id="name" name="name" value="${store.name}"
					placeholder="Store name" class="form-control"
					aria-describedly="name"></input>
				<lable >Store address:</lable>
				<input type="text" name="address"
					value="${store.address}" placeholder="Store Address"
					class="form-control" aria-describedly="address"></input>
				<lable >Phone:</lable>
				<input type="text" name="phone"
					value="${store.phone}" placeholder="Phone"
					class="form-control" aria-describedly="phone"></input>

			</div>
			<div class="card-footer text-muted">
					 <a href="<c:url value="/seller/3" />"
					class="btn btn-success"><i class="fas fa-new"></i>List
					Product</a>
				<button class="btn btn-primary" type="submit">
					<i class="fas fa-save"></i>SAVE
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