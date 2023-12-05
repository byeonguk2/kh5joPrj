<%@page import="com.kh.app.purchase.vo.PurchaseCartVo"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%
    	List<PurchaseCartVo> PurchaseCartVoList = (List<PurchaseCartVo>) request.getAttribute("PurchaseCartVoList");
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
                    <tr>
                        <td>
                            <div class="checkboxArea">
                                <input type="checkbox" class="checkBtn">
                            </div>
                        </td>
                        <td>
                            <div>
                                <img src="" alt="상품이미지">
                            </div>
                        </td>
                        <td>
                        	<div class="goodsTitleArea">
	                            <div class="seller">판매점</div>
	                            <div class="goodsName">상품명</div>
                        	</div>
                        </td>
                        <td>
                            <div class="upDownBtnArea">
                                <span class="DownBtn"><img src="/nongra/resources/img/purchase/icon-minus.png" alt="-"></span>
                                <span class="upDownNo">0</span>
                                <span class="upBtn"><img src="/nongra/resources/img/purchase/icon-plus.png" alt="+"></span>
                            </div>
                        </td>
                        <td>
                            <div class="priceArea">
                                <div class="price">000원</div>
                                <div class="optionPrice">000원</div>
                            </div>
                        </td>
                        <td>
                            <div class="removeBtnArea">
                                <button><img src="/nongra/resources/img/purchase/icon-cross.png" alt="X">
                                </button>
                            </div>
                        </td>
                    </tr>
                </tbody>
            </table>

            
            
            <a class="orderBtnArea" href="/nongra/order/checkout">
                <button class="orderBtn">주문하기</button>
            </a>
		</main>
		
	</div>
</body>
</html>

<script type="text/javascript"><%@include file="/resources/js/purchase/cart.js"%></script>