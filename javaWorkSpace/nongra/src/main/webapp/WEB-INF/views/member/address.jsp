<%@page import="com.kh.app.purchase.vo.PurchaseAddressVo"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <% List<PurchaseAddressVo> voList = (List<PurchaseAddressVo>) request.getAttribute("voList"); %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>농라</title>
<link rel="stylesheet" href="/nongra/resources/css/member/mypageAddress.css">
</head>
<body>
	<div id="cover">
		<%@	include file="/WEB-INF/views/common/header/header_sobi.jsp" %>
		<div id="main">
			<%@	include file="/WEB-INF/views/common/aside/aside_sobi_main.jsp" %>
			<main>
				<div id="title">
					<h2>배송지 관리</h2>
					<form action="/nongra/address/shipping-address" method="get">
						<button id="addAddress">+ 새 배송지 추가</button>
					</form>
				</div>
				<table>
					<thead>
						<tr>
							<th>주소</th>
							<th>받으실 분</th>
							<th>연락처</th>
							<th>수정</th>
						</tr>
					</thead>
					<tbody>
					<%for(PurchaseAddressVo vo : voList) {%>
						<tr>
							<td>
								<%if(vo.getDefaultAddress().equals("Y")){ %><div class="default">기본배송지</div><%} %>
								<div><%=vo.getAddress() %></div>
							</td>
							<td><div><%=vo.getName() %></div><span class="address-no"><%=vo.getNo() %></span></td>
							<td><div><%=vo.getPhone() %></div></td>
							<th><button class="edit-button"><img src="https://res.kurly.com/kurly/ico/2021/edit_24_24_ccc.svg" alt=""></button></th>
						</tr>
					<%} %>
					</tbody>
				</table>
			</main>
		</div>
		
	</div>
</body>
</html>
<script type="text/javascript" src="/nongra/resources/js/member/mypageAddress.js"></script>