<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<html>
<style><%@include file = "../css/header.css"%></style>
<!--begin of menu-->

<nav class="navbar navbar-expand-md navbar-dark bg-dark p-relative">
	<div class="container">
		<div class="collapse navbar-collapse" id="navbarsExampleDefault">
		
			<ul class="collapse navbar-collapse navbar-nav">
				<li><a href = "home" class="nav-link">Home</a></li>
				<c:if test="${sessionScope.user.role == 3}">
					<li><a class="p-5" style = "color:rgba(255,255,255,.5)" href="admin/home" class="nav-link">Admin</a></li>
				</c:if>
				<c:if test="${sessionScope.user.role == 2}">
					<li><a class="p-5" style = "color:rgba(255,255,255,.5)" href="seller/${sessionScope.store.storeId}" class="nav-link">Seller</a></li>
				</c:if>
			</ul>

			<form action = "search" class="form-inline p-absolute">
				<input class="form-control mr-sm-2 m-width pd-input" name = "search" type="search"
					placeholder="Search" aria-label="Search">
				<button class="btn btn-primary my-2 my-sm-0 pd-input" type="submit">
					<i class="fa fa-search"></i>
				</button>
			</form>
			<c:if test = "${sessionScope.user == null}">
				<ul class="nav navbar-nav navbar-right">
					<li><a class="nav-link" href="login">SignUp / Login</a></li>
				</ul>
			</c:if>
			<c:if test = "${sessionScope.user != null}">
				<ul class="nav navbar-nav navbar-right">
					<li><a class="nav-link" href="profile">My Account</a></li>
					<li><a class="nav-link" href="logout">Logout</a></li>
				</ul>
			</c:if>
			<a class="btn btn-success btn-sm ml-3" href="cart"> <i
				class="fa fa-shopping-cart"></i> Cart <span
				class="badge badge-light">3</span>
			</a>
		</div>
	</div>
</nav>
<section class="jumbotron text-center">
	<div class="container">
		<h1 class="jumbotron-heading">Ecommerce MarketPlace - Nhóm 16</h1>
	</div>
</section>
</html>
<!--end of menu-->
