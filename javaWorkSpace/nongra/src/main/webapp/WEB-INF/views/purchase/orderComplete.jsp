<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" href="/nongra/resources/css/purchase/orderComplete.css">
</head>
<body>
	<div id="cover">
		<%@	include file="/WEB-INF/views/common/header/header_sobi.jsp" %>
        <main>
			<div id="order-complete-area">
				<div class="check-icon-area"><div class="check-icon"><img src="/nongra/resources/img/purchase/icon-check.png" alt=""></div></div>
	            <div class="order-text">닉네임님의 주문이 완료되었습니다.</div>
	            <div class="price-area">
	                <span>결제금액</span>
	                <span>15972원</span>
	            </div>
	            <div class="explanation-area">
	                <table>
	                    <tr>
	                        <td>*</td>
	                        <td>엘리베이터 이용이 어려운 경우 6층 이상부터는 공동 현관앞 또는 경비실로 대응 배송 될 수 있습니다.</td>
	                    </tr>
	                    <tr>
	                        <td>*</td>
	                        <td>주문 / 배송 및 기타 문의가 있을 경우, 1:1 문의에 남겨주시면 신속히 해결해드리겠습니다.</td>
	                    </tr>
	                </table>
	            </div>
	            <div class="button-area"><button id="fbutton">주문 상세보기</button></div>
	            <div class="button-area"><button id="tbutton">쇼핑 계속하기</button></div>
				
			</div>

        </main>
	</div>
</body>
</html>