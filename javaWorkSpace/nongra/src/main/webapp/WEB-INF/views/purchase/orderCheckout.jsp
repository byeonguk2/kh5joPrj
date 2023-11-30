<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" href="/nongra/resources/css/purchase/orderCheckout.css">
</head>
<body>
	<div id="cover">
		<%@	include file="/WEB-INF/views/common/header/header_sobi.jsp" %>
<main>
            <div class="order-head">주문서</div>
            <div class="order">
                <span class="head-text">주문상품</span>
                <button>▽</button>
            </div>
            <div class="simple-ver">[블랙위크] 인기 국탕찌개 9종 골라담기 (택2)</div>
            <div class="detail-ver">
                <div class="product-image-area"><img src="https://product-image.kurly.com/cdn-cgi/image/fit=crop,width=360,height=468,quality=85/product/image/cb45c971-b61a-48f2-a521-01d88b793f7e.jpg" alt=""></div>
                <div class="product-name-area">[블랙위크] 인기 국탕찌개 9종 골라담기 (택2)</a></div>
                <div class="product-cnt-area">1개</div>
                <div class="product-price">9,800원</div>
            </div>
            <div class="orderer-area">
                <div class="head-text text">주문자 정보</div>
                <table class="orderer-table">
                    <tr>
                        <td>보내는 분</td>
                        <td>kh</td>
                    </tr>
                    <tr>
                        <td>휴대폰</td>
                        <td>010-1234-1234</td>
                    </tr>
                    <tr>
                        <td>이메일</td>
                        <td>kh@gmail.com</td>
                    </tr>
                    <tr>
                        <td></td>
                        <td class="description">이메일을 통해 주문처리 과정을 보내드립니다.</td>
                    </tr>
                    <tr>
                        <td></td>
                        <td class="description">정보 변경은 개인정보 수정 메뉴에서 가능합니다.</td>
                    </tr>
                </table>
            </div>
            <div class="delivery-area">
                <div class="head-text text">배송정보</div>
                <div class="delivery-add">
                    <table>
                        <tr>
                            <td>배송지</td>
                            <td>기본배송지</td>
                        </tr>
                        <tr>
                            <td></td>
                            <td>서울특별시 강남구 테헤란로 130 호산빌딩 6F</td>
                        </tr>
                        <tr>
                            <td></td>
                            <td><button class="delivery-btn" onclick="showPopup();">변경</button></td>
                        </tr>
                    </table>
                </div>
                <div>
                    <table class="delivery-req">
                        <tr>
                            <td>배송 요청사항</td>
                            <td>문앞</td>
                        </tr>
                        <tr>
                            <td></td>
                            <td>kh, 010-1234-1234</td>
                        </tr>
                        <tr>
                            <td></td>
                            <td><button class="delivery-btn">수정</button></td>
                        </tr>
                    </table>
                </div>
            </div>

            <div>
                <div class="head-text text">결제 금액</div>
                <div class="pay-amount">
                    <table class="pay-table">
                        <tr>
                            <td>주문금액</td>
                            <td>15320원</td>
                        </tr>
                        <tr>
                            <td>농라페이</td>
                            <td>24030원</td>
                        </tr>
                        <tr>
                            <td>결제 후 잔액</td>
                            <td>8710원</td>
                        </tr>
                    </table>
                </div>
            </div>

            <div class="personal-data-area">
                <div class="head-text text">개인정보 수집/제공</div>
                <div class="personal-data-agr">
                    <span>개인정보 수집∙이용 및 처리 동의</span>
                    <span>보기(팝업창)</span>
                </div>
                <div class="personal-data-agr">
                    <span>전자지급 결제대행 서비스 이용약관 동의</span>
                    <span>보기(팝업창)</span>
                </div>
                <div class="personal-data-total-agr">위 내용을 확인 하였으며 결제에 동의합니다.</div>
            </div>

            <div class="inquiry">
                <div>※ 배송완료 상태일 경우에만 환불이 가능합니다.</div>
                <div>※ 농라는 통신판매중개자로서 주문, 품질, 교환/환불 등 의무와 책읨을 부담하지 않습니다.</div>
            </div>
            <div class="pay-btn-area">
                <button class="pay-btn">15,320원 결제하기</button>
            </div>

        </main>
	</div>
</body>
</html>
<script type="text/javascript"><%@include file="/resources/js/purchase/orderCheckout.js"%></script>