<%@page import="com.kh.app.seller.vo.SellerVo"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
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
	grid-template-rows:1fr  1fr;
	width: 100%;
}

/* 내용 중간 영역 */
.content-top-area{
	margin: 20px 40px 10px 40px;
	border: 1px solid #e3e7ee;
	display: grid;
	grid-template-columns: 5fr 5fr;
	gap: 30px;
}

.content-bottom-area{
	margin: 10px 40px 20px 40px;
	border: 1px solid #e3e7ee;
	display: grid;
	grid-template-columns: 5fr 5fr;
	gap: 30px;
}

.content-parcel{
	background-color: white;
	display: grid;
	grid-template-rows: 0.3fr 1fr 1fr;
}

.title > h3 {
	color: #303236;
    font-weight: 600;
    font-size: 18px;
	line-height: 55px;
	padding-left: 20px;
}

.order-parcel{
	border: 1px solid #e3e7ee;
	padding: 10px 20px 10px 20px;
	display: grid;
	grid-template-rows: 1fr 1fr 1fr 1fr 1fr;
}

.order-parcel > div {
	display: flex;
	justify-content: space-between;
	align-items: center;
}

p{
	color: #8f95a0;
	font-size: 14px;
}

.content-notice{
	background-color: white;
	display: grid;
	grid-template-rows: 55px 1fr;
}


.content-notice > :nth-child(2){
	display: grid;
	grid-template-rows: 1fr 1fr 1fr 1fr 1fr 1fr;
	padding: 0px 20px 0px 20px;
	border-top: 1px solid #e3e7ee;
}

.content-notice >  div > div {
	display: flex;
	justify-content: space-between;
	align-items: center;
}

.content-review{
	background-color: white;
    display: grid;
    grid-template-rows: 0.3fr 1fr 1fr;
}

.review{
	border: 1px solid #e3e7ee;
    padding: 10px 20px 10px 20px;
    display: grid;
    grid-template-rows: 1fr 1fr 1fr 1fr 1fr;
}

.review > div {

	display: flex;
	justify-content: space-between;
	align-items: center;

}

</style>
</head>
<body>
	<div class = "wrap">
		<%@ include file="/WEB-INF/views/common/header/header_seller.jsp" %>
		<main>
			<%@ include file="/WEB-INF/views/common/aside/aside_seller.jsp" %>
			<div class = "content-area">
				<div class="content-top-area">
					<div class="content-parcel">
						<div class="title">
							<h3>주문/배송</h3>
						</div>
						<div class="order-parcel">
							<div><p>오늘 판매금액</p><p>0원</p></div>
							<div><p>총 판매금액</p><p>0건</p></div>
							<div><p>오늘 주문</p><p>0건</p></div>
							<div><p>환불내역</p><p>0건</p></div>
							<div><p>총 판매내역</p><p>0건</p></div>
						</div>
						<div class="order-parcel">
							<div><p>배송전</p><p>0건</p></div>
							<div><p>배송중</p><p>0건</p></div>
							<div><p>배송완료</p><p>0건</p></div>
							<div><p>배송취소</p><p>0건</p></div>
							<div></div>
						</div>
					</div>
					<div class="content-notice">
						<div class="title">
							<h3>공지사항</h3>
						</div>
						<div>
							<div><p>[일반] 판매자에게 전달합니다.</p></div>
							<div><p>[긴급] 판매자 스팸문자 주의</p></div>
							<div><p>[일반] 판매자 문의 관련</p></div>
							<div><p>[일반] 휴무일 공지</p></div>
							<div><p>[일반] 쪽지 이용시 주의사항</p></div>
							<div><p>[필수] 판매자 규칙</p></div>
						</div>
					</div>
				</div>
				<div class="content-bottom-area">
					<div class="content-review">
						<div class="title">
							<h3>리뷰</h3>
						</div>
						<div class="review">
							<div><p>작성된 리뷰</p><p>0건</p></div>
							<div><p>나의 답변</p><p>0건</p></div>
						</div>
						<div class="review">
							<div><p>리뷰 최신순</p></div>
							<div><p>매우 만족스러워요!</p><p>2023.12.11</p></div>
							<div><p>맛없습니다..</p><p>2023.11.29</p></div>
							<div><p>여기 딸기가 제일 달아요.</p><p>2023.11.28</p></div>
							<div></div>
						</div>
					</div>
					<div class="content-notice">
						<div class="title">
							<h3>내가 쓴 문의</h3>
						</div>
						<div>
							<div><p>[소비자 신고] 검토바랍니다.</p></div>
							<div><p>[취소/교환] 음식 섭취 후 환불요청..</p></div>
							<div><p>[상품] 상품이 안올라갑니다.</p></div>
							<div><p>[일반] 판매글이 삭제가 안됌</p></div>
							<div><p>[일반] 회원 틸퇴방법</p></div>
							<div><p>[일반] 쪽지 관련 문의</p></div>
						</div>
					</div>
				</div>
			</div>
		</main>
	</div>
</body>
</html>