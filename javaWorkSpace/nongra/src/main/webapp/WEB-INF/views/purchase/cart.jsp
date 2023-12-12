<%@page import="com.kh.app.purchase.vo.PurchaseCartVo"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%
    	List<PurchaseCartVo> PurchaseCartVoList = (List<PurchaseCartVo>) request.getAttribute("purchaseVoList");
    
    %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>농라</title>
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
            
            <table>
                <tbody>
                <%for(PurchaseCartVo vo : PurchaseCartVoList) {%>
                    <tr>
                        <td>
                            <div class="checkboxArea">
                                <input type="checkbox" class="checkBtn">
                            </div>
                        </td>
                        <td>
                            <div>
                                <img class="goodsPicture" src="/nongra<%=vo.getGoodsPicture() %>" alt="상품이미지">
                            </div>
                        </td>
                        <td>
                        	<div class="goodsTitleArea">
	                            <div class="seller"><%=vo.getSeller() %></div>
	                            <div class="goodsName"><%=vo.getGoodsName() %></div>
	                            <span class="cartBreakdown"><%=vo.getOrderNumber() %></span>
                        	</div>
                        </td>
                        <td>
                            <div class="upDownBtnArea">
                                <button class="downBtn"><img src="/nongra/resources/img/purchase/icon-minus.png" alt="-"></button>
                                <span class="upDownNo"><%=vo.getGoodsEA() %></span>
                                <button class="upBtn"><img src="/nongra/resources/img/purchase/icon-plus.png" alt="+"></button>
                            </div>
                        </td>
                        <td>
                        	<div class="optionArea">
                        		<div class="option"><c:if test="${!vo.optionName}"><%=vo.getOptionName() %></c:if></div>
                                <span class="optionPrice"><c:if test="${!vo.optionName}"><%=vo.getOptionPrice() %></c:if></span><span>원</span>
                        	</div>
                        </td>
                        <td>
                            <div class="priceArea">
                                <div class="onePrice"><%=vo.getGoodsPrice() %></div>
                                <div class="price">한개당가격*갯수</div>
                                <div class="oneTotalprice"><c:if test="${!vo.optionName}">(옵션+상품가격)*갯수</c:if></div>
                            </div>
                        </td>
                        <td>
                            <div class="removeBtnArea">
                                <button class="removeBtn"><img class="disabled" src="/nongra/resources/img/purchase/icon-cross.png" alt="X">
                                </button>
                            </div>
                        </td>
                    </tr>
                    <% } %>
                </tbody>
            </table>

            
            
            <a class="orderBtnArea" href="/nongra/order/checkout">
                <button class="orderBtn">
                    <span id="totalPrice">00</span><span>원</span>
                    주문하기
                </button>
            </a>
		</main>
		
	</div>
</body>
</html>
<script type="text/javascript"><%@include file="/resources/js/purchase/cart.js"%></script>