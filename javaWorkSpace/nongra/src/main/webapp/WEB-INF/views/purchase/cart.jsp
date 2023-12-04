<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" href="/nongra/resources/css/purchase/cart.css">
</head>
<body>
	<div id="cover">
		<%@	include file="/WEB-INF/views/common/header/header_sobi.jsp" %>
		<main>
			
            <div id="selectAll-area">
                <input type="checkbox" id="selectAll">
                <label for="selectAll"><span>전체선택</span></label>
                <span>|</span>
                <button id="selectAll-btn">선택 삭제</button>
            </div>
            <div class="seller-area">
                <span>판매자</span>
                <button class="seller-btn">▼</button>
            </div>
            <div class="product-area">
                <input type="checkbox" id="product">
                <div class="product-image-area"><img src="https://product-image.kurly.com/cdn-cgi/image/fit=crop,width=360,height=468,quality=85/product/image/cb45c971-b61a-48f2-a521-01d88b793f7e.jpg" alt=""></div>
                <div class="product-name-area"><a href="해당상품판매페이지로이동">[블랙위크] 인기 국탕찌개 9종 골라담기 (택2)</a></div>
                <div class="product-cnt-area">
                    <button class="product-cnt-down">-</button>
                    <div class="product-cnt">0</div>
                    <button class="product-cnt-up">+</button>
                </div>
                <div class="product-price">9,800원</div>
                <button class="cancel-btn">X</button>
            </div>
            <div class="product-area">
                <input type="checkbox" id="product">
                <div class="product-image-area"><img src="https://product-image.kurly.com/cdn-cgi/image/fit=crop,width=360,height=468,quality=85/product/image/cb45c971-b61a-48f2-a521-01d88b793f7e.jpg" alt=""></div>
                <div class="product-name-area"><a href="해당상품판매페이지로이동">[블랙위크] 인기 국탕찌개 9종 골라담기 (택2)</a></div>
                <div class="product-cnt-area">
                    <button class="product-cnt-down">-</button>
                    <div class="product-cnt">0</div>
                    <button class="product-cnt-up">+</button>
                </div>
                <div class="product-price">9,800원</div>
                <button class="cancel-btn">X</button>
            </div>
            
            
            <div class="seller-area">
                <span>판매자</span>
                <button class="seller-btn">▼</button>
            </div>
            <div class="product-area">
                <input type="checkbox" id="product">
                <div class="product-image-area"><img src="https://product-image.kurly.com/cdn-cgi/image/fit=crop,width=360,height=468,quality=85/product/image/cb45c971-b61a-48f2-a521-01d88b793f7e.jpg" alt=""></div>
                <div class="product-name-area"><a href="해당상품판매페이지로이동">[블랙위크] 인기 국탕찌개 9종 골라담기 (택2)</a></div>
                <div class="product-cnt-area">
                    <button class="product-cnt-down">-</button>
                    <div class="product-cnt">0</div>
                    <button class="product-cnt-up">+</button>
                </div>
                <div class="product-price">9,800원</div>
                <button class="cancel-btn">X</button>
            </div>
            <a class="order-area" href="/nongra/order/checkout">
                <button class="order-btn">주문하기</button>
            </a>
		</main>
		
	</div>
</body>
</html>

<script type="text/javascript"><%@include file="/resources/js/purchase/cart.js"%></script>