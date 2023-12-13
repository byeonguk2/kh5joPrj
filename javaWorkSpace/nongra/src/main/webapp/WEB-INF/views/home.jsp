<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<!-- Latest compiled and minified CSS -->
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/css/bootstrap.min.css" rel="stylesheet">
<style>
	.header-area{
		display: grid;
		grid-template-columns: 1fr 1050px 1fr;
	}
	#shadow{
		box-shadow: 0px 3px 4px 0px rgba(0, 0, 0, 0.07);
	}
	.carousel-item{
		background-size: cover;
	}
</style>
</head>
<body>
	<div id="wrap">
		<div class="header-area">
			<div id="shadow"></div>
			<%@	include file="/WEB-INF/views/common/header/header_sobi.jsp" %>
			<div id="shadow"></div>
		</div>
	<main>
		<!-- 부트 스트랩 사진 슬라이드 -->
		<!-- Carousel -->
		<div id="demo" class="carousel slide" data-bs-ride="carousel">

			<!-- Indicators/dots -->
			<div class="carousel-indicators">
			<button type="button" data-bs-target="#demo" data-bs-slide-to="0" class="active"></button>
			<button type="button" data-bs-target="#demo" data-bs-slide-to="1"></button>
			<button type="button" data-bs-target="#demo" data-bs-slide-to="2"></button>
			</div>
		
			<!-- The slideshow/carousel -->
			<div class="carousel-inner">
			<div class="carousel-item active">
				<img src="https://product-image.kurly.com/cdn-cgi/image/width=1900,height=370,quality=85/banner/main/pc/img/cc2f7b09-2c3a-4526-892e-3afc0ed79d61.png" alt="Los Angeles" class="d-block w-100">
			</div>
			<div class="carousel-item">
				<img src="https://product-image.kurly.com/cdn-cgi/image/width=1900,height=370,quality=85/banner/main/pc/img/d302a6ae-1ea5-484c-9faa-be1e508f0ac7.jpg" alt="Chicago" class="d-block w-100">
			</div>
			<div class="carousel-item">
				<img src="https://product-image.kurly.com/cdn-cgi/image/width=1900,height=370,quality=85/banner/main/pc/img/eb7244c9-dd99-4153-8ce2-b87586e5b52e.jpg" alt="New York" class="d-block w-100">
			</div>
			</div>
		
			<!-- Left and right controls/icons -->
			<button class="carousel-control-prev" type="button" data-bs-target="#demo" data-bs-slide="prev">
			<span class="carousel-control-prev-icon"></span>
			</button>
			<button class="carousel-control-next" type="button" data-bs-target="#demo" data-bs-slide="next">
			<span class="carousel-control-next-icon"></span>
			</button>
		</div>
	</main>	
	</div>
<!-- Latest compiled JavaScript -->
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/js/bootstrap.bundle.min.js"></script>
</body>
</html>