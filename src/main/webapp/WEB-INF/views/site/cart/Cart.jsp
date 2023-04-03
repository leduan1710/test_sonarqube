<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Cart</title>
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css">
<link rel="stylesheet"
	href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.2.1/css/all.min.css" />
</head>

<body>
	<jsp:include page="../home/Header.jsp"></jsp:include>
	<div class="shopping-cart">
		<div class="px-4 px-lg-0">

			<div class="pb-5">
				<div class="container">
					<div class="row">
						<div class="col-lg-12 p-5 bg-white rounded shadow-sm mb-5">

							<!-- Shopping cart table -->
							<div class="table-responsive">
								<table class="table">
									<thead>
										<tr>
											<th scope="col" class="border-0 bg-light">
												<div class="p-2 px-3 text-uppercase">Sản Phẩm</div>
											</th>
											<th scope="col" class="border-0 bg-light">
												<div class="py-2 text-uppercase">Đơn Giá</div>
											</th>
											<th scope="col" class="border-0 bg-light">
												<div class="py-2 text-uppercase">Số Lượng</div>
											</th>
											<th scope="col" class="border-0 bg-light">
												<div class="py-2 text-uppercase">Xóa</div>
											</th>
										</tr>
									</thead>
									<tbody>
										<c:forEach items = "${cartItem}" var="object">
											<tr>
												<th scope="row">
													<div class="p-2">
														<img
															src="${object.product.urlImage}"
															alt="" width="70" class="img-fluid rounded shadow-sm">
														<div class="ml-3 d-inline-block align-middle">
															<h5 class="mb-0">
																<a href="#" class="text-dark d-inline-block"> ${object.product.name}</a>
															</h5>
															<span class="text-muted font-weight-normal font-italic"></span>
														</div>
													</div>
												</th>
												<td class="align-middle"><strong>${object.product.price }</strong></td>
												<td class="align-middle"><a href="#">
														<button class="btnSub">-</button>
												</a> <strong>${object.count }</strong> <a href="#"><button
															class="btnAdd">+</button></a></td>
												<td class="align-middle"><a href="delete?ciid=${object.cartItemId }" class="text-dark">
														<button type="button" class="btn btn-danger">Delete</button>
												</a></td>
											</tr>
										</c:forEach>
									</tbody>
								</table>
							</div>
							<!-- End -->
						</div>
					</div>

						<div class="col-lg-6">
							<div class="p-4">
								<ul class="list-unstyled mb-4">
									<li class="d-flex justify-content-between py-3 border-bottom"><strong
										class="text-muted">Total</strong>
										<h5 class="font-weight-bold">${total }$</h5></li>
								</ul>
								<a href="buy" class="btn btn-dark rounded-pill py-2 btn-block">Buy</a>
							</div>
						</div>
					</div>

				</div>
			</div>
		</div>
	<script src="https://code.jquery.com/jquery-3.2.1.slim.min.js"></script>
	<script
		src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.12.9/umd/popper.min.js"></script>
	<script
		src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js"></script>
</body>

</html>
</html>
