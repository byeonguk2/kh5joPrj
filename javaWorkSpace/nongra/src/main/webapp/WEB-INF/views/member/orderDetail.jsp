<%@page import="java.util.List"%>
<%@page import="com.kh.app.purchase.vo.PurchaseCartVo"%>
<%@page import="com.kh.app.purchase.vo.PurchaseAddressVo"%>
<%@page import="com.kh.app.purchase.vo.PurchaseOrderCheckoutVo"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%
    PurchaseOrderCheckoutVo orderCheckOutVo = (PurchaseOrderCheckoutVo) request.getAttribute("orderCheckOutVo");
    List<PurchaseCartVo> cartVoList = orderCheckOutVo.getCartVoList();
    PurchaseAddressVo address = orderCheckOutVo.getAddressVo();
    
    %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" href="/nongra/resources/css/member/mypageOrderDetail.css">
</head>
<body>
	<div id="cover">
		<%@	include file="/WEB-INF/views/common/header/header_sobi.jsp" %>
        <main>
                    <div class="order-head">주문서</div>
                    <div class="order">
                        <span class="head-text">주문상품</span>
                        <span><h3>주문번호 : <span id="orderNum" vlaue="<%=cartVoList.get(0).getOrderNumber() %>"><%=cartVoList.get(0).getOrderNumber() %></span></h3></span>
                    </div>
                    <table class="detailVerArea">

                        <tbody>
                        <%for(PurchaseCartVo vo : cartVoList) {%>
                            <tr class="detailVer">
                                <td class="product-image-area"><img id="detail-img" src="/nongra<%=vo.getGoodsPicture() %>" alt="상품이미지"></td>
                                <td class="product-name-area">
                                    <div><%=vo.getSeller() %></div>
                                    <div><%=vo.getGoodsName() %></div>
                                </td>
                                <td class="product-option-area">
                                    <div><%=vo.getOptionName() %></div>
                                    <div>+<%=vo.getOptionPrice() %>원</div>
                                </td>
                                <td class="product-price-area">
                                    <div><%=vo.getGoodsPrice() %>원</div>
                                    <div><%=Integer.parseInt(vo.getGoodsPrice())  + Integer.parseInt(vo.getOptionPrice())%>원</div>
                                </td>
                                <td class="product-ea-area"><%=vo.getGoodsEA() %></td>
                                <td class="product-price"><%=vo.getTotalPrice() %>원</td>
                            </tr>
                        <%} %>
                        </tbody>

                    </table>
                    <h2 class="price">주문금액 : <%=cartVoList.get(0).getCartTotalPrice() %>원</h2>
        
        
        
                    
                    <div class="orderer-area">
                        <div class="head-text text">주문자 정보</div>
                        <table class="orderer-table">
                            <tr>
                                <td>보내는 분</td>
                                <td>${loginMember.name }</td>
                            </tr>
                            <tr>
                                <td>휴대폰</td>
                                <td>${loginMember.phone }</td>
                            </tr>
                            <tr>
                                <td>이메일</td>
                                <td>${loginMember.email }</td>
                            </tr>
                            <tr>
                                <td>결제일시</td>
                                <td><%=cartVoList.get(0).getEnrollDate() %></td>
                            </tr>
                            <tr>

                        </table>
                    </div>
                    <div class="delivery-area">
                        <div class="head-text text">배송정보</div>
                        <div class="delivery-add">
                            <table>
                                <tr>
                                    <td>배송지</td>
                                    <td><%if(address.getDefaultAddress().equals("Y")){ %>
                                        <span id="address">기본배송지</span>
                                        <%} %>
                                        <span id="addr"><%=address.getAddress() %></span>
                                    </td>
                                </tr>
                                <tr>
                                    <td>받는 사람</td>
                                    <td><%=address.getName() %></td>
                                </tr>
                                <tr>
                                    <td>전화번호</td>
                                    <td><%=address.getPhone() %></td>
                                </tr>
                            </table>
                        </div>


                    </div>
					<div class="hi">
                        <input type="text" name="orderNo" value="<%=cartVoList.get(0).getOrderNumber() %>">
                        <button id="reBtn" onclick="openPopup();">환불하기</button>

                    </div>

                    </div>




        </main>
	</div>
</body>
</html>
<script type="text/javascript" src="/nongra/resources/js/member/mypageOrderDetail.js"></script>
<script>
function openPopup() {
    const orderNum = document.querySelector('#orderNum');
    const childWindow = window.open("/nongra/mypage/refund",'_농라','width=400,height=250,top=500,left=500');


    setTimeout( ()=>{
        const childInputTag = childWindow.document.querySelector('input[name=orderNo]');
        childInputTag.value = orderNum.innerText;
    } , 100);

}
</script>

