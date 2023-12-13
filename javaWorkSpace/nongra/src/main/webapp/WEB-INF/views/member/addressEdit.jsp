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
				<div>
					<form action="/nongra/address/shipping-address/update" method="post">
						<table>
							<input type="text" name="no" class="none" value="<%= addressVo.getNo()%>">
							<tbody>
								<tr>
									<td>배송지</td>
									<td><%=addressVo.getAddress() %></td>
								</tr>
								<tr>
									<td>받는 사람</td>
									<td><input type="text" name="name" value="<%=addressVo.getName()%>"></td>
								</tr>
								<tr>
									<td>전화번호</td>
									<td><input type="text" name="phone" value="<%=addressVo.getPhone()%>"></td>
								</tr>
								<tr>
									<td></td>
									<td><input type="checkbox" name="defaultAddress">기본 배송지</td>
								</tr>
								<tr>
									<th></th>
									<th><button>수정</button></th>
								</tr>
							</tbody>
						</table>

						
						
					</form>
				</div>
			</main>
		</div>
		
	</div>
</body>
</html>