<%@page contentType="text/html" pageEncoding="UTF-8"%>
<html>
<style><%@include file = "../css/header.css"%></style>
<!--begin of menu-->

<nav class="navbar navbar-expand-md navbar-dark bg-dark p-relative">
	<div class="container">
		<div class="collapse navbar-collapse" id="navbarsExampleDefault">

			<ul class="collapse navbar-collapse navbar-nav">
				<li><a href="/home" class="nav-link">Home</a></li>
			</ul>
			<ul class="collapse navbar-collapse navbar-nav">
				<li><a href="/seller/1" class="nav-link">Seller</a></li>
			</ul>
			<form action = "search" class="form-inline p-absolute">
				<input class="form-control mr-sm-2 m-width pd-input" name = "search" type="search"
					placeholder="Search" aria-label="Search">
				<button class="btn btn-primary my-2 my-sm-0 pd-input" type="submit">
					<i class="fa fa-search"></i>
				</button>
			</form>
			<ul class="nav navbar-nav navbar-right">
				<li><a class="nav-link" href="/logout">Logout</a></li>
			</ul>
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
