<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="/common/taglib.jsp"%>
<!DOCTYPE html>
<html>
<head>
<!-- Required meta tags -->
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1">

<%@include file="/common/admin/header.jsp"%>


</head>
<body>
	<div class="container-fluid">
		<%@include file="/common/admin/sidebar.jsp"%>
		<div class="col py-3">
			<section class="row">
				<div class="col mt-4">
					<div class="card">
						<div class="card-header">List Products</div>
						<div class="card-body">
							<!-- Hiển thông báo -->
							<c:if test="${message != null}">
								<div class="alert alert-primary" role="alert">
									<i>${message}</i>
								</div>
							</c:if>
						</div>
						<!-- Hết thông báo -->
						<!-- Search -->
						<div class="row mt-2 mb-2">
							<div class="col-md-6">
								<form action="/admin/products/searchpagenated">
									<div class="input-group">
										<input type="text" class="form-control ml-2" name="name"
											id="name" placeholder="Nhập từ khóa để tìm" />
										<button class="btn btn-outline-primary ml-2">Search</button>

									</div>
								</form>
							</div>
						</div>
						<c:if test="${!productPage.hasContent()}">
							<div class="row">
								<div class="col">
									<div class="alert alert-danger">Không tìm thấy product</div>
								</div>
							</div>
						</c:if>
						<!-- List -->
						<c:if test="${productPage.hasContent()}">
							<table class="table table-striped table-responsive">
								<thead class="thead-inverse">
									<tr>
										<th>Product ID</th>

										<th>Product Name</th>
										<th>Image</th>

										<th>Quantity</th>
										<th>Price</th>
										
										<th>Action</th>
									</tr>
								</thead>
								<tbody>
									<c:forEach items="${productPage.content}" var="product">
										<tr>
											<td scope="row">${product.productId}</td>
											<td>${product.name}</td>
											<td><c:if test="{product.images != null}">
													<img src="/admin/products/images/${product.urlImage}"
														width="70" class="img-fluid" alt="">
												</c:if> <c:if test="{product.images == null}">
													<img src="/images/noimage.jpg" width="70" class="img-fluid"
														alt="">
												</c:if></td>
											<td>${product.quantity}</td>
											<td>${product.price}</td>
											
											<td>
												<a data-id="${product.productId}"
												data-name="${product.name}"
												onclick="showconfirmation(this.getAttribute('data-id'), this.getAttribute('data-name'))"
												class="btn btn-outline-danger"><i class="fa fa-trash"></i></a>
											</td>
										</tr>
									</c:forEach>
								</tbody>
							</table>
						</c:if>
						<script type="text/javascript">
							function showconfirmation(id, name) {
								$('#name').text(name);
								$('#yesOption').attr('href',
										'/admin/products/delete/' + id);
								$('#confirmationId').modal('show');
							}
						</script>

						<!-- Modal -->
						<div class="modal fade" id="confirmationId" tabindex="-1"
							aria-labelledby="confirmationLabel" aria-hidden="true">
							<div class="modal-dialog" role="document">
								<div class="modal-content">
									<div class="modal-header">
										<h5 class="modal-title" id="confirmationLabel">Comfirmation</h5>

									</div>
									<div class="modal-body">
										Bạn có muốn xóa<span id="name"></span>?
									</div>
									<div class="modal-footer">
										<a id="yesOption" class="btn btn-primary">Yes</a>

									</div>
								</div>
							</div>
						</div>

						<!-- hết Modal -->
						<div class="row">
							<div class="col-5">
								<form action="">
									<div class="mb-3 input-group float-left">
										<label for="size" class="mr-2">Page size:</label> <select
											name="size" id="size" class="form-select ml-2"
											onchange="this.form.submit()">
											<option ${productPage.size == 3 ? 'selected' : ''} value="3">3</option>
											<option ${productPage.size == 5 ? 'selected' : ''} value="5">5</option>
											<option ${productPage.size == 10 ? 'selected' : ''}
												value="10">10</option>
											<option ${productPage.size == 15 ? 'selected' : ''}
												value="15">15</option>
											<option ${productPage.size == 20 ? 'selected' : ''}
												value="20">20</option>
										</select>
									</div>
								</form>
							</div>
							<div class="col-7">
								<!-- Phân trang -->
								<c:if test="${productPage.totalPages >0 }">
									<nav aria-label="Page navigation">
										<ul class="pagination">
											<li
												class="${1==productPage.number + 1 ? 'page-item active':'page-item' }">
												<a class="page-link"
												href="<c:url value='searchpagenated?name=${name}&size=${productPage.size}&page=${1}'/>"
												tabindex="-1" aria-disabled="true">First</a>
											</li>
											<c:forEach items="${pageNumbers}" var="pageNumber">
												<c:if test="${productPage.totalPages > 1}">
													<li
														class="${pageNumber == productPage.number + 1 ? 'page-item active' : 'page-item'}">
														<a class="page-link"
														href="<c:url value ='searchpagenated?name=${name}&size=${productPage.size}&page=${pageNumber}'/>">${pageNumber}</a>
													</li>
												</c:if>
											</c:forEach>
											<li
												class="${productPage.totalPages == productPage.number + 1 ? 'page-item active' : 'page-item'}">
												<a
												href="<c:url value='searchpagenated?name=${name}&size=${productPage.size}&page=${productPage.totalPages}'/>"
												class="page-link">Last</a>
										</ul>
									</nav>
								</c:if>
								<!-- Hết Phân trang -->
							</div>
						</div>




					</div>
				</div>
			</section>
		</div>
	</div>
	</div>

	<%@ include file="/common/admin/footer.jsp"%>

</body>
</html>