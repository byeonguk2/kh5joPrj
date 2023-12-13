<%@page import="java.util.Map"%>
<%@page import="org.apache.jasper.tagplugins.jstl.core.ForEach"%>
<%@page import="java.util.List"%>
<%@page import="com.kh.app.sales.vo.SalesVo"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
pageEncoding="UTF-8"%>

    <% 
    	Map<String , Object> map = (Map<String , Object>)request.getAttribute("map"); 
	    List<SalesVo> salesBestReviewVoList = (List<SalesVo>) map.get("salesBestReviewVoList");
		List<SalesVo> salesBestOrderVoList = (List<SalesVo>)map.get("salesBestOrderVoList");
		List<SalesVo> salesBestReviewLikeVoList = (List<SalesVo>)map.get("salesBestReviewLikeVoList");
    %>
    
    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<!-- Latest compiled and minified CSS -->
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/css/bootstrap.min.css" rel="stylesheet">
<style>

	/* 레이아웃 잡기 */
	.header-area{
		display: grid;
		grid-template-columns: 1fr 1050px 1fr;
	}

	#shadow{
		box-shadow: 0px 3px 4px 0px rgba(0, 0, 0, 0.07);
	}

	/* 슬라이드 */
	#demo{
		margin-bottom: 100px;
	}

	.carousel-item{
		background-size: cover;
	}

	/* 상품소개 */
	.ItemIntroduction-box{
		margin: auto; 
		width: 1050px; 
		height: 600px;
		padding: 40px 0px;
		margin-bottom: 100px;
	}

	.title-area{
		display: flex;
		flex-direction: column;
	}

	.title-top{
		color: rgb(51, 51, 51);
		font-size: 28px;
		line-height: 1.15;
		letter-spacing: -0.26px;
		font-weight: 500;
		text-align: center;
	}

	.title-bottom{
		font-size: 16px;
		font-weight: normal;
		line-height: 1.45;
		letter-spacing: -0.2px;
		text-align: center;
		color: rgb(153, 153, 153);
		margin-top: 2px;
	}

	.item-area{
		display: grid;
		grid-template-columns: 1fr 1fr 1fr 1fr;
	}

	.item > img {
		width: 250px;
		height: 300px;
		background-size: cover;
	}

	.shopingCart-btn{
		display: flex;
		-webkit-box-pack: center;
		justify-content: center;
		-webkit-box-align: center;
		align-items: center;
		width: 250px;
		height: 36px;
		margin-top: 6px;
		padding-bottom: 1px;
		font-size: 16px;
		line-height: 29px;
		border: 1px solid rgb(221, 221, 221);
		border-radius: 4px;
	}

	.cart-icon{
		background-image: url("https://w7.pngwing.com/pngs/833/426/png-transparent-black-shopping-cart-icon-for-free-black-shopping-cart-icon.png");
		width: 22px;
		height: 22px;
		margin: 1px 4px 0px 0px;
		background-size: cover;
	}

	.item-guide{
		font-size: 16px;
		line-height: 23px;
		font-weight: 400;
		margin-bottom: 8px;
		overflow: hidden;
		text-overflow: ellipsis;
		display: -webkit-box;
		-webkit-line-clamp: 2;
		-webkit-box-orient: vertical;
		letter-spacing: normal;
		word-break: break-word;
		overflow-wrap: break-word;
	}

	.price{
		font-size: 16px;
		font-weight: 800;
		line-height: 1.5;
		white-space: nowrap;
	}

	.event-area{
		margin: auto;
		margin-bottom: 100px;
		padding: 30px 50px 30px 50px;
		height: 140px;
		width: 1050px;
		border: 1px solid #754327;
		display: flex;
    	flex-direction: column;
	}
	
	.event-area > span {
		font-size: 32px;
		color: #754327;
	}
	
	.event-area > a {
	    padding-top: 11px;
	    font-size: 16px;
	    color: rgb(153, 153, 153);
	    font-weight: normal;
	    line-height: 1.3;
	    letter-spacing: normal;
	    text-decoration-line: none;
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

		<!-- 상품 보여주기 -->
		<div class="ItemIntroduction-box">
			<div class="title-area">
				<span class="title-top">✨리뷰 작성이 많은순🏅</span>
				<p class="title-bottom">농라 추천 득템 기회❗️</p>
			</div>
			<div class="item-area">
				<% for(SalesVo vo : salesBestReviewVoList){ %>
				<a>
				<div class="item">
					<img src="/nongra<%= vo.getFileName() %>" alt="상품">
					<button class="shopingCart-btn">
						<span class="cart-icon"></span>
						"담기"
					</button>
					<h3 class="item-guide"><%= vo.getTitle() %></h3>
					<span class="price"><%= vo.getPrice() %></span>
				</div>
				</a>
				<% } %>	
			</div>
		</div>
		
		
		<div class="ItemIntroduction-box">
			<div class="title-area">
				<span class="title-top">✨가장 많이 주문한 상품🏅</span>
				<p class="title-bottom">농라 회원들의 베스트 상품들❗️</p>
			</div>
			<div class="item-area">
				<% for(SalesVo vo : salesBestOrderVoList){ %>
				<a>
				<div class="item">
					<img src="/nongra<%= vo.getFileName() %>" alt="상품">
					<button class="shopingCart-btn">
						<span class="cart-icon"></span>
						"담기"
					</button>
					<h3 class="item-guide"><%= vo.getTitle() %></h3>
					<span class="price"><%= vo.getPrice() %></span>
				</div>
				</a>
				<% } %>	
			</div>
		</div>

		<div class="event-area">
			<span>현재 진행중인 이벤트❗</span>
			<a href="/nongra/event/list">현재 진행중인 이벤트를 확인하러 가기</a>
			
		</div>

		<div class="ItemIntroduction-box">
			<div class="title-area">
				<!-- 이 라인은 겨울픽 음식 넣기 -->
				<span class="title-top">✨겨울철 최고의 음식 🍠</span>
				<p class="title-bottom">추운 겨울을 따듯하고 든든하게❗️</p>
			</div>
			<div class="item-area">
				<div class="item">
					<img src="https://product-image.kurly.com/cdn-cgi/image/fit=crop,width=360,height=468,quality=85/product/image/fc3eb710-126d-4c18-b776-ac6809b07a73.jpeg" alt="">
					<button class="shopingCart-btn">
						<!-- 카트 ajax -->
						<span class="cart-icon"></span>
						"담기"
					</button>
					<h3 class="item-guide">[델리치오] 호주산 목초육 안심 스테이크 250g (냉장)</h3>
					<span class="price">20000원</span>
				</div>
				<div class="item">
					<img src="https://product-image.kurly.com/cdn-cgi/image/fit=crop,width=360,height=468,quality=85/product/image/fc3eb710-126d-4c18-b776-ac6809b07a73.jpeg" alt="">
					<button class="shopingCart-btn">
						<span class="cart-icon"></span>
						"담기"
					</button>
					<h3 class="item-guide">[델리치오] 호주산 목초육 안심 스테이크 250g (냉장)</h3>
					<span class="price">20000원</span>
				</div>
				<div class="item">
					<img src="https://product-image.kurly.com/cdn-cgi/image/fit=crop,width=360,height=468,quality=85/product/image/fc3eb710-126d-4c18-b776-ac6809b07a73.jpeg" alt="">
					<button class="shopingCart-btn">
						<span class="cart-icon"></span>
						"담기"
					</button>
					<h3 class="item-guide">[델리치오] 호주산 목초육 안심 스테이크 250g (냉장)</h3>
					<span class="price">20000원</span>
				</div>
				<div class="item">
					<img src="https://product-image.kurly.com/cdn-cgi/image/fit=crop,width=360,height=468,quality=85/product/image/fc3eb710-126d-4c18-b776-ac6809b07a73.jpeg" alt="">
					<button class="shopingCart-btn">
						<span class="cart-icon"></span>
						"담기"
					</button>
					<h3 class="item-guide">[델리치오] 호주산 목초육 안심 스테이크 250g (냉장)</h3>
					<span class="price">20000원</span>
				</div>
			</div>
		</div> 

		<div class="ItemIntroduction-box">
			<div class="title-area">
				<span class="title-top">✨리뷰 좋아요가 많은 상품들🥩</span>
				<p class="title-bottom">농라 회원님들의 평가가 좋은 상품❗️</p>
			</div>
			<div class="item-area">
				<% for(SalesVo vo : salesBestReviewLikeVoList){ %>
				<a>
				<div class="item">
					<img src="/nongra<%= vo.getFileName() %>" alt="상품">
					<button class="shopingCart-btn">
						<span class="cart-icon"></span>
						"담기"
					</button>
					<h3 class="item-guide"><%= vo.getTitle() %></h3>
					<span class="price"><%= vo.getPrice() %></span>
				</div>
				</a>
				<% } %>	
			</div>
		</div>
	</main>
	
	<!-- 풋터 영역 -->
	
		
	</div>
<!-- Latest compiled JavaScript -->
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/js/bootstrap.bundle.min.js"></script>
</body>
</html>