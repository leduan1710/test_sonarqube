<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="/common/taglib.jsp"%>
<!DOCTYPE html>
<html>
<head>
<!-- Required meta tags -->
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1">

<!-- Bootstrap CSS -->
		<%@include file ="/common/admin/header.jsp" %>
</head>
<body>
<div class="container-fluid">
		<%@include file="/common/admin/sidebar.jsp"%>
		<div class="col py-3">
	<section class="row">
		<div class ="col-6 offset-3 mt-4">
			<form action ="<c:url value ="/admin/categories/saveOrUpdate" />" method ="POST">
				<div class="card">
					<div class="card-header">
						<h2>${category.isEdit ? 'Edit Category' :'Add New Category'}</h2>
					</div>
					<div class="card-body">
						<div class="mb-3">
							<label for="categoryId" class ="form-label">Category ID:</label>
							<input type="hidden" value ="${category.isEdit}">
							<input
								type ="text" readonly="readonly" class="form-control" value="${category.categoryId}" id="categoryId" name="categoryId"
								aria-describedby="categoryId" placeholder="Category Id">
						</div>
						<div class="mb-3">
							<label for="categoryname" class="form-label">Category Name:</label>
							<input
								type="text" class="form-control" value="${category.name}" id="name" name="name"
								aria-describedby="categorycode" placeholder="Category Name">
						</div>
					</div>
				</div>
				<div class ="card-footer text-muted">
					<a href="<c:url value="/admin/categories/add"/>" class ="btn btn-secondary"><i class="fas fa-new">New</i></a>
					<a href="<c:url value="/admin/categories/searchpagenated"/>" class ="btn btn-success"><i class="fas fa-bars"></i>List Categories</a>
					<button class="btn btn-primary" type="submit"><i class="fas fa-save"></i>
					<c:if test ="${category.isEdit}">
					<span>Update</span>
					</c:if>
					<c:if test ="${!category.isEdit}">
					<span>Save</span>
					</c:if>
					</button>
				</div>
			</form>
		</div>
	</section>
	
		</div>
	</div>
	</div>

	<%@ include file="/common/admin/footer.jsp"%>
</body>
</html>