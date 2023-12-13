<%@page import="com.kh.app.purchase.vo.PurchaseAddressVo"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <% PurchaseAddressVo addressVo = (PurchaseAddressVo) request.getAttribute("addressVo"); %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>농라</title>
<link rel="stylesheet" href="/nongra/resources/css/member/mypageAddressEdit.css">
</head>
<body>
	<div id="cover">
		<%@	include file="/WEB-INF/views/common/header/header_sobi.jsp" %>
		<div id="main">
			<%@	include file="/WEB-INF/views/common/aside/aside_sobi_main.jsp" %>
			<main>
				<form action="/nongra/address/shipping-address/update" method="post">
					<input type="text" name="no" class="none" value="<%= addressVo.getNo()%>">
					<div>배송지 : <%=addressVo.getAddress() %></div>
					받는 사람 : <input type="text" name="name" value="<%=addressVo.getName()%>">
					<br>
					전화번호 : <input type="text" name="phone" value="<%=addressVo.getPhone()%>">
					<br>
					<input type="checkbox" name="defaultAddress">기본 배송지
					<br>
					<button>수정</button>
				</form>
			</main>
		</div>
		
	</div>
</body>
</html>