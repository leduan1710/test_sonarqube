<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<div class="row flex-nowrap">
	<div class="col-auto col-md-3 col-xl-2 px-sm-2 px-0 bg-dark">
		<div
			class="d-flex flex-column align-items-center align-items-sm-start px-3 pt-2 text-white min-vh-100">
			<a href="/"
				class="d-flex align-items-center pb-3 mb-md-0 me-md-auto text-white text-decoration-none">
				<span class="fs-5 d-none d-sm-inline">Menu</span>
			</a>
			<ul
				class="nav nav-pills flex-column mb-sm-auto mb-0 align-items-center align-items-sm-start"
				id="menu">
				<li class="nav-item"><a href="<c:url value="/home"/>"
					class="nav-link align-middle px-0"> <i class="fs-4 bi-house"></i>
						<span class="ms-1 d-none d-sm-inline">Home</span>
				</a></li>
				<li><a
					href="<c:url value="/admin/products/searchpagenated"/>"
					class="nav-link px-0 align-middle"> <i class="fs-4 bi-people"></i>
						<span class="ms-1 d-none d-sm-inline">Products</span>
				</a></li>
				<li><a
					href="<c:url value="/admin/categories/searchpagenated"/>"
					class="nav-link px-0 align-middle"> <i class="fs-4 bi-people"></i>
						<span class="ms-1 d-none d-sm-inline">Categories</span>
				</a></li>
				<li><a href="<c:url value="/admin/users/searchpagenated"/>"
					class="nav-link px-0 align-middle"> <i class="fs-4 bi-people"></i>
						<span class="ms-1 d-none d-sm-inline">Users</span>
				</a></li>
			</ul>
			<hr>
			<!--  <div class="dropdown pb-4">
						<a href="#"
							class="d-flex align-items-center text-white text-decoration-none dropdown-toggle"
							id="dropdownUser1" data-bs-toggle="dropdown"
							aria-expanded="false"> <img src="https://github.com/mdo.png"
							alt="hugenerd" width="30" height="30" class="rounded-circle">
							<span class="d-none d-sm-inline mx-1">loser</span>
						</a>
						<ul class="dropdown-menu dropdown-menu-dark text-small shadow">
							<li><a class="dropdown-item" href="#">Profile</a></li>
							<li>
								<hr class="dropdown-divider">
							</li>
							<li><a class="dropdown-item" href="#">Sign out</a></li>
						</ul>
					</div>
					-->
		</div>
	</div>