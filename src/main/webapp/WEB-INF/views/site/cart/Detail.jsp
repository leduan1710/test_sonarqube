<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Product Detail</title>
		<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.2.1/css/all.min.css" />
        <link href="//maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css" rel="stylesheet" id="bootstrap-css">
        <style>
			<%@include file="../css/detail.css" %>
        </style>
    </head>
    <body>
        <jsp:include page="../home/Header.jsp"></jsp:include>
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
                <div class="col-sm-9">
                    <div class="container">
                        <div class="card">
                            <div class="row">
                                <aside class="col-sm-5 border-right">
                                    <article class="gallery-wrap"> 
                                        <div class="img-big-wrap">
                                            <div> <a href="#"><img src="${detail.urlImage}"></a></div>
                                        </div>
                                        <div class="img-small-wrap">
                                        </div>
                                    </article>
                                </aside>
                                <aside class="col-sm-7">
                                    <article class="card-body p-5">
                                        <h3 class="title mb-3">${detail.name}</h3>

                                        <p class="price-detail-wrap"> 
                                            <span class="price h3 text-warning"> 
                                                <span class="num">${detail.price}$</span>
                                            </span> 
                                        </p>
                                        <hr>
                                        <div class="row">
                                            <div class = "form-group">
                                            	<input type = "number" class = "form-control" value = 1>
                                            </div>

                                        </div>
                                        <hr>
                                        <a href="#" class="btn btn-lg btn-primary text-uppercase"> Buy now </a>
                                        <a href="add?pid=${detail.productId}" class="btn btn-lg btn-outline-primary text-uppercase"> <i class="fas fa-shopping-cart"></i> Add to cart </a>
                                    </article>
                                </aside>
                            </div>
                        </div>


                    </div>
                </div>
            </div>
        </div>
        <jsp:include page="../home/Footer.jsp"></jsp:include>
	<script
		src="//maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js"></script>
	<script
		src="//cdnjs.cloudflare.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
	<script src="https://cdn.jsdelivr.net/npm/jquery@3.6.1/dist/jquery.slim.min.js"></script>
 	<script src="https://cdn.jsdelivr.net/npm/popper.js@1.16.1/dist/umd/popper.min.js"></script>
 	<script src="https://cdn.jsdelivr.net/npm/bootstrap@4.6.2/dist/js/bootstrap.bundle.min.js"></script>
    </body>
</html>
