<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" href="/nongra/resources/css/sales/salesList.css">
<style type="text/css">


</style>
</head>
<body>
	<%@ include file="/WEB-INF/views/common/header/header_sobi.jsp" %>
	<main>
		<aside>
			<div>1</div>
		</aside>
		<div class="main-section">
			<div class="main-top-area">
				<div><span>총 524건</span></div>
				<div>
					<a href="">추천순 |</a>
					<a href="">신상품순 |</a>
					<a href="">판매량순 |</a>
					<a href="">낮은 가격순 |</a>
					<a href="">높은 가격순</a>
				</div>
			</div>
			<div class="main-area">
				<c:forEach items="${ salesVoList }" var="salesVo">
					<div class="item-area">
						<img src="/nongra${ salesVo.fileName }" alt="썸네일사진" onclick="showDetails(${salesVo.salesNo})">
						<button>담기</button>
						<div>${ salesVo.title }</div>
						<div>${ salesVo.price }원</div>
					</div>
				</c:forEach>
				
			</div>
		</div>
	</main>
	    <script>
        function showDetails(salesNo) {
            window.location.href = '/nongra/sales/details?salesNo=' + salesNo;
        }
    </script>
	
</body>
</html>