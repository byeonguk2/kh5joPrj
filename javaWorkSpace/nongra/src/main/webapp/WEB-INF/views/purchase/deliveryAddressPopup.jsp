<%@page import="com.kh.app.purchase.vo.PurchaseAddressVo"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri ="http://java.sun.com/jsp/jstl/core"%>
<% List<PurchaseAddressVo> voList = (List<PurchaseAddressVo>) request.getAttribute("voList"); %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" href="/nongra/resources/css/purchase/deliveryAddressPopup.css">
</head>
<body>
    <div id="wrap">
        <main>
            <div class="title-area">
                <div><strong>배송지</strong></div>
                <div>배송지에 따라 상품정보 및 배송유형이 달라질 수 있습니다.</div>
            </div>
            <table>
                <thead>
                    <tr>
                        <th>선택</th>
                        <th>배송 정보</th>
                        <th>수정</th>
                    </tr>
                </thead>
                <tbody>
                <%for(PurchaseAddressVo vo : voList) {%>
                    <tr>
                        <th><button class="button"><img src="/nongra/resources/img/purchase/icon-check.png" alt="대충 체크표시ㅋ" class="img"></button></th>
                        <td>
                            <div>
                            	<span class="address-no"><%=vo.getNo() %></span>
                            	<span><%if(vo.getDefaultAddress().equals("Y")){ %><div class="default">기본배송지</div><%} %></span>
								<div class="addr"><%=vo.getAddress() %></div>
								<div><span class="name"><%=vo.getName() %></span> | <span><%=vo.getPhone() %></span></div>
                            </div>
                        </td>
                        <th><button class="edit-button"><img src="https://res.kurly.com/kurly/ico/2021/edit_24_24_ccc.svg" alt=""></button></th>
                    </tr>
                <%} %>
                </tbody>
            </table>
            
        </main>
    </div>

</body>
<footer>
    <button id="addAddress">
        + 새 배송지 추가
    </button>
</footer>
</html>
<script type="text/javascript"><%@include file="/resources/js/purchase/deliveryAddressPopup.js"%></script>