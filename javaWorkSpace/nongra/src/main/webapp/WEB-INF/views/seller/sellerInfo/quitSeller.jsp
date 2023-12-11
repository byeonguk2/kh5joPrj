<%@page import="java.util.Map"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
	<% 
		Map<String,Object>  map = (Map<String,Object>)request.getAttribute("map");
	%>
	
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<!-- <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/css/bootstrap.min.css" rel="stylesheet"> -->
<style type="text/css">

/* 전체 영역 */
.wrap{
	height: 100vh;
}

/* 메인 영역 */
main{
		display: flex;
	    background-color: #edf0f5;
}

/* 내용을 감싸는 영역 */
.content-area{
	background-color: rgba(0,0,0,0);
	display: grid;
	grid-template-rows: 60px 570px 500px 100px;
	width: 100%;
	padding-top: 20px;
}

/* 내용 상단 영역 */
.content-top-area{
	background-color: white;
	margin-left: 40px;
	border: 1px solid #e3e7ee;
	margin-right: 40px;
}

/* 내용 상단 판매자 정보 글씨 */
.content-top-area > h2 {
	padding-left: 40px;
    line-height: 52px;
    font-size: 20px;
    text-align: left;
}

/* 내용 상단 버튼영역 */
.content-top-a-area{
	padding-left: 40px;
	display: flex;
	align-items: center;
	height: 100%;
	gap: 15px;
	font-size: 16px;
}
.content-top-a-area > :nth-child(1){
	color: #754327;
}
/* 본 내용 영역 */
.content{
	margin: 40px 40px 40px 40px;
	border: 1px solid #e3e7ee;
	background-color: #ffffff;
	display: grid;
	grid-template-rows: 80px 1fr;
}

.content > div {
	border-bottom: 0.8px solid #e3e7ee;
	padding: 0px 40px 0px 40px;
	/* display: flex;
	justify-content: left;
	align-items: center; */
}

#title{
	font-size: 20px; 
	color: #754327;
	line-height: 80px;
}

#quit-guide{
	background-color: #f8f9fd;
	padding-top: 20px;
}

#quit-guide > ul > li{
	font-size: 14px;
	color: #767a83;;
}

#quit-guide > h4 {
	font-size: 16px;
    font-weight: 600;
    color: #4d5159;
}

.table-area{
	display: grid;
	grid-template-rows: 80px 1fr;
	margin: 0px 40px 40px 40px;
}

.requirement{
	padding: 0px 40px 0px 40px;
	background-color: white;
}

.requirement > label{
	font-size: 20px;
    color: #754327;
    line-height: 80px;
}

#ul{
	margin: 10px 0px 10px 0px;
}

table{
	border: 1px solid #dbdde2;
}

th{
	background-color: #f8f9fd;
	text-align: left;
	height: 40.5px;
	color: #767a83;
	font-size: 13px;
	padding: 8px;
}

td{
	background-color: white;
	color: #767a83;;
	font-size: 13px;
	padding: 8px;
}
p{
	padding: 3px;
}

.quit-btn{
	display: flex;
	justify-content: center;
	align-items: center;
}

.quit-btn > button {
	height: 40px;
	width: 150px;
	border-radius: 5px;
	border: 1px solid #754327;
	background-color: #754327;
	color: white;
}
.red {
	color: red;
}

</style>
</head>
<body>
	<form action="/nongra/seller/quit" onsubmit="return checkStatusAgain()" method="post">
		<div class = "wrap">
			<%@ include file="/WEB-INF/views/common/header/header_seller.jsp" %>
			<main>
				<%@ include file="/WEB-INF/views/common/aside/aside_seller.jsp" %>
				<div class = "content-area">
					<div class="content-top-area">
						<h2>회원탈퇴</h2>
					</div>
					<div class="content">
						<div>
							<label id="title">탈퇴안내</label>
						</div>
						<div id="quit-guide">
							<h4>탈퇴시 서비스 이용 제한 안내</h4>
							<ul id="ul">
								<li>농라파트너센터 이용이 제한되며 농라 쇼핑에 노출중인 상품의 전시가 중단됩니다.</li>
							</ul>
							<h4>탈퇴 후 재가입</h4>
							<ul id="ul">
								<li>판매자 탈퇴를 하신 경우 동일 판매자 정보(사업자번호, 개인식별정보)로 30일간 다시 가입하실 수 없습니다.</li>
								<li>탈퇴 후, 사용하셨던 파트너명, 파트너URL은 재가입 시 사용할 수 없습니다.</li>
								<li>
									이용정지 상태에서는 '탈퇴신청'이 불가하며, '강제탈퇴 신청'을 통해 탈퇴가 가능합니다.
									<br>
									(단, 상표법 , 고의적 부당행위,부적합 판매자 유사정보 계정, MS윈도우 제품 키 판매로 인한 이용정지의 경우에는 강제탈퇴 불가)
								</li>
								<li>이용정지 중 강제 탈퇴가 진행된 경우, 이용정지 사유에 따라 동일 판매자 정보(사업자번호, 개인식별번호)로 30일 ~1년간 가입할 수 없습니다.</li>
								<li>
									회사는 안정적인 서비스 운영 등을 위해 다음의 경우 재가입을 제한할 수 있습니다.
									<ul>
										<li>- 약관 및 서비스 운영정책 위반으로 직권해지된 이력이 있는 경우</li>
										<li>- 약관 및 서비스 운영정책 위반으로 서비스 이용정지된 상태에서 탈퇴한 이력이 있는 경우</li>
										<li>- 약관 및 판매자운영정책에 중대하게 어긋나는 행동을 한 후 자진하여 탈퇴한 이력이 있는 경우</li>
										<li>- 단, 부정거래 소명 또는 특수 사유로 인해 재가입을 허용할 경우 소정의 절차에 따라 재가입이 허용됩니다.</li>
									</ul>
								</li>
							</ul>
							<h4>탈퇴 조건</h4>
							<ul id="ul">
								<li>농라쇼핑에 광고주 입점이 되어 있는 경우, [쇼핑파트너센터]에서 광고주 퇴점이 완료되어야 농라 파트너 탈퇴 신청이 가능합니다.</li>
								<li>아래 '탈퇴 조건 현황'을 통해, '진행중인 거래 , 클레임 등' 탈퇴를 조건이 모두 충족되어야 탈퇴 신청이 가능합니다.</li>
								<li>(탈퇴 조건이 충족된 경우, 탈퇴 조건 현황은 노출되지 않습니다)</li>
							</ul>
						</div>
					</div>
					<div class="table-area">
						<div class="requirement">
							<label>탈퇴 조건 현황</label>
						</div>
						<table class="table">
							<thead>
								<tr>
									<th>탈퇴조건</th>
									<th>현황</th>
									<th>탈퇴 조건 총족</th>
									<th>탈퇴 조건 총족 방안</th>
								</tr>
							</thead>
							<tbody>
								<tr>
									<th>진행 중 거래</th>
									<td>
										<p class="orderStatusCheck">진행 중 주문 <%= map.get("completedOrderCnt") %>건</p>
									</td>
									<input type="hidden" name="completedOrderCnt" value="<%= map.get("completedOrderCnt") %>">
									<td class="orderStatus"></td>
									<td>
										<p>주문 건 구매확정(거래 종료) 필요</p>
									</td>
								</tr>
								<tr>
									<th>클라임</th>
									<td>
										<p class="refundStatusCheck">환불신청 중 <%= map.get("allRefundCnt") %>건</p>
									</td>
									<input type="hidden" name="allRefundCnt" value="<%= map.get("allRefundCnt") %>">
									<td name="refundStatus" value="<%= map.get("allRefundCnt") %>" class="refundStatus"></td>
									<td>
										<p>반품 주문 건 클레임 종료 필요</p>
									</td>
								</tr>
								<tr>
									<th>판매 중 상품</th>
									<td>
										<p class="productStatusCheck">판매 중인 상품 <%= map.get("allProductCnt") %>개</p>
									</td>
									<input type="hidden" name="allProductCnt" value="<%= map.get("allProductCnt") %>">
									<td name="productStatus" value="<%= map.get("allProductCnt") %>" class="productStatus"></td>
									<td>
										<p>판매 중인 상품 및 판매대기 상품 판매중지 처리 필요</p>
									</td>
								</tr>
								<tr>
									<th>배송 중 상품</th>
									<td>
										<p class="shippingStatusCheck">배송 중 <%= map.get("completedOrderCnt") %>건</p>
									</td>
									<td name="shippingStatus" value="<%= map.get("completedOrderCnt") %>" class="shippingStatus"></td>
									<td>
										<p>배송 중 상품 모두 처리 필요</p>
									</td>
								</tr>
							</tbody>
						</table>
					</div>
					<div class="quit-btn">
						<button>탈퇴신청</button>
					</div>
				</div>
			</main>
		</div>
	</form>
	<script>

		function statusCheck(){

			// 주문상태 체크 태그
			const orderStatusCheck = document.querySelector(".orderStatusCheck");
			const orderStatus = document.querySelector(".orderStatus");
			
			// 주문상태 체크
			if(orderStatusCheck.innerText === '진행 중 주문 0건'){
				orderStatus.innerHTML = "충족";
			}else{
				orderStatus.innerHTML = "불충족";
				orderStatus.classList.add("red");
			}

			// 환불상태 체크 태그
			const  refundStatusCheck = document.querySelector(".refundStatusCheck");
			const refundStatus = document.querySelector(".refundStatus");

			// 환불상태 체크 
			if(refundStatusCheck.innerText === '환불신청 중 0건'){
				refundStatus.innerHTML = "충족";
			}else{
				refundStatus.innerHTML = "불충족";
				refundStatus.classList.add("red");
			}

			// 상품상태 체크 태그
			const  productStatusCheck = document.querySelector(".productStatusCheck");
			const productStatus = document.querySelector(".productStatus");

			// 상품상태 체크 
			if(productStatusCheck.innerText === '판매 중인 상품 0개'){
				productStatus.innerHTML = "충족";
			}else{
				productStatus.innerHTML = "불충족";
				productStatus.classList.add("red");
			}

			// 배송상태 체크 태그
			const shippingStatusCheck = document.querySelector(".shippingStatusCheck");
			const shippingStatus = document.querySelector(".shippingStatus");
			
			// 배송상태 체크
			if(shippingStatusCheck.innerText === '배송 중 0건'){
				shippingStatus.innerHTML = "충족";
			}else{
				shippingStatus.innerHTML = "불충족";
				shippingStatus.classList.add("red");
			}

		}

		statusCheck()

		function checkStatusAgain(){

			const orderStatus = document.querySelector(".orderStatus");
			if(orderStatus.innerText !== '충족'){
				alert("탈퇴조건 현황을 확인 해주세요")
				return false;
			}

			const refundStatus = document.querySelector(".refundStatus");
			if(refundStatus.innerText !== '충족'){
				alert("탈퇴조건 현황을 확인 해주세요")
				return false;
			}

			const productStatus = document.querySelector(".productStatus");
			if(productStatus.innerText !== '충족'){
				alert("탈퇴조건 현황을 확인 해주세요")
				return false;
			}

			const shippingStatus = document.querySelector(".shippingStatus");
			if(shippingStatus.innerText !== '충족'){
				alert("탈퇴조건 현황을 확인 해주세요")
				return false;
			}

		}

	</script>
	
</body>
</html>