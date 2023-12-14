
<%@page import="java.util.List"%>
<%@page import="com.kh.app.orderdetails.vo.OrderDetailVo"%>
<%@page import="java.util.Map"%>
<%@page import="com.kh.app.page.vo.PageVo"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%
// JSP에서 Java 코드로 DeleteYn 값을 가져옴
String deleteYn = (String) request.getAttribute("DeleteYn");
PageVo pvo = (PageVo) request.getAttribute("pvo");
Map<String, String> searchMap = (Map<String, String>) request.getAttribute("searchMap");
List<OrderDetailVo> ReviewVoList = (List<OrderDetailVo>) request.getAttribute("ReviewVoList");
%>


<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet"
	href="/nongra/resources/css/member/member_mypage.css">
<link rel="stylesheet" href="/nongra/resources/css/common/cssReset.css">
<link rel="stylesheet"
	href="/nongra/resources/css/orderDetail/userOrderDetail.css">

<style>
body {
	
}

#wrap {
	width: 100%;
}

#main-area {
	display: grid;
	grid-template-columns: 230px 8fr;
	padding-top:;
}

#headerer {
	display: flex;
	align-items: center;
	justify-content: center;
}
</style>
</head>
<body>

	<div id="wrap1">
		<%@ include file="/WEB-INF/views/common/header/header_sobi.jsp"%>
		<main>
			<%@ include file="/WEB-INF/views/common/aside/aside_sobi_main.jsp"%>

			<div id=whole>
				<div id="box">
					<div id="welcome"><%=loginMember.getMemberNick()%>님 환영합니다
					</div>
					<div id="pay">
						페이금액
						<%=loginMember.getPoint()%>원
					</div>
				</div>
				<div id=h3>
					<a href="/nongra/member/orderDetail">최근 주문 내역</a>
				</div>

				<div id="box2">


					<div>
						<table>
							<colgroup>
								<col style="width: 400px">
								<col style="width: 150px">
								<col style="width: 150px">
								<col style="width: 200px">
								<col style="width: 200px">
							</colgroup>
							<thead class="thead-order">
								<tr>
									<th scope="col">상품정보</th>
									<th scope="col">주문일자</th>
									<th scope="col">주문번호</th>
									<th scope="col">주문금액(수량)</th>
									<th scope="col">주문 상태</th>
								</tr>
							</thead>
							<tbody class="tbody-order">
								<c:forEach items="${ReviewVoList}" var="vo" begin="0" end="3">

									<tr class="oredr-tr">
										<td>
											<div class="tbody-order-box">
												<a href=""><img src="/nongra${vo.thumbnail}" alt="상품사진"></a>

												<ul>
													<li class="order-store-name"><a href="">${vo.businessName}</a></li>
													<li class="order-item-name"><a href="">${vo.itemtitle }</a>
													</li>
												</ul>
											</div>
										</td>

										<td class="order-date-td">${vo.orderEnrollDate}</td>
										<td class="order-number-td"><a href="">${vo.orderNo}</a>
										</td>
										<td class="order-price-td"><span>${vo.totalPrice}원</span>
											<br> <span>${vo.ea}개</span></td>
										<td class="order-btn-td"><c:choose>
												<c:when test="${vo.refundYn eq 'Y'}">
													<button class="order-buy-sure-after">환불완료</button>
												</c:when>
												<c:otherwise>


													<c:choose>
														<c:when test="${vo.deliveryYn eq 'N'}">
															<button class="order-buy-sure-before">
																구매확정
																<div class="payNo" style="display: none">${vo.payNo}</div>
															</button>
															<button class="order-review-after">
																구매확정대기
																<div class="reviewNo" style="display: none">${vo.reviewNo}</div>
															</button>
														</c:when>
														<c:otherwise>
															<button class="order-buy-sure-after">구매 확정 완료</button>

															<c:choose>
																<c:when test="${empty vo.reviewNo}">
																	<button class="order-review-before">
																		후기작성
																		<div class="cbNO" style="display: none">${vo.cbNo}</div>
																		<div class="thumbnail" style="display: none">/nongra${vo.thumbnail}</div>
																		<div class="itemtitle" style="display: none">[${vo.businessName}]${vo.itemtitle}</div>
																	</button>
																</c:when>
																<c:otherwise>
																	<button class="order-review-after">
																		후기 작성 완료
																		<div class="reviewNo" style="display: none">${vo.reviewNo}</div>
																	</button>
																</c:otherwise>
															</c:choose>

														</c:otherwise>
													</c:choose>
												</c:otherwise>
											</c:choose></td>
									</tr>
								</c:forEach>
							</tbody>
						</table>

					</div>


				</div>
				<div id=h3>
					<h3>최근 구매 상품</h3>

				</div>

				<div id="box3">
					<%for (OrderDetailVo vo : ReviewVoList) {%>
						<%if (vo.getThumbnail().equals("")) {%>
							<div id="img_box">
								<img src="https://dummyimage.com/100x100/000/fff.png&text=sample"alt="썸네일사진원본파일명">
							</div>
						<%}else{%>
							<div id="img_box">
								<a href=""><img src="/nongra<%= vo.getThumbnail() %>" alt="상품사진"></a>
								<% System.out.println(vo.getThumbnail()); %>
							</div>
						<%}%>
					<%}%>
				</div>


			</div>
			<br>
			<br>
			<br>
			<br>
			<br>
			<br>
			<br>
			<br>
	</div>


	<!-- 모달 구매 확정 창 -->
	<div class="modal-sure modal-sure-hiddnen" style="z-index: 3;">
		<div class="dialog-sure">
			<div class="dialog-sure-btn">
				<button id="modal-close">X</button>
			</div>
			<span>-구매 확정 시 교환 환불은 불가능 합니다 </span> <span>정말 구매 확정 하시겠습니까?</span>

			<div class="modal-sure-btn-box">
				<form class="form-sure" action="/nongra/member/orderSure"
					method="post">
					<button class="btn-sure" name="ohNo">확정</button>
				</form>
				<label class="btn-quit" for="modal-close">취소</label>
			</div>
		</div>
	</div>

	<!-- 모달 후기작성 창 -->

	<div class="modal-review modal-review-hidden" style="z-index: 3;">
		<header class="dialog-review">
			<header class="dialog-review-header">
				<h2>후기 작성</h2>
				<label for="review-cancel">X</label>
			</header>
			<div class="dialog-review-img-box">
				<img src="" alt="상품사진" class="imgSrc-modal"> <span
					class="item-title-modal">[못난이토마토] 못난이토마볶음 500g</span>
			</div>

			<div class="dialog-review-img-exemple">
				<h2>후기는 이렇게 작성해보세요</h2>
				<p class>
					제품의 <span class="dialog-review-img-exemple-span">맛·향·크기·사용감</span>
					등을 설명해주세요 <strong>좋았던 점, 아쉬웠던 점</strong>도 솔직하게 얘기해주세요
				</p>


				<form action="/nongra/member/ReviewWrite" method="post"
					enctype="multipart/form-data">
					<div class="dialog-review-content-box">
						<div>내용</div>

						<textarea id="contents"
							placeholder="상품 특성에 맞는 후기를 작성해주세요.(20자 이상)" inputmode="text"
							aria-label="textarea-message" name="content"
							class="css-5etceh e1tjt2bn1"></textarea>

					</div>

					<div>
						<div>
							<div>
								<div class="dialog-review-content-picture-input-box">
									<h3>사진 첨부</h3>
									<div>
										<input id="my-input" type="file" name='f' multiple>
										<!--  <button class="dialog-review-content-picture-input-btn" onclick="onClickUpload()" type="button"><img src="" alt=""></button> -->
									</div>
								</div>
							</div>

							<div class="dialog-review-caution ">
								<label class="dialog-review-caution-label"></label>
								<ul class="dialog-review-caution-ul">
									<li class="dialog-review-caution-li">사진은 최대 8장까지, 30MB 이하의
										이미지만 업로드가 가능합니다.</li>
									<li class="dialog-review-caution-li">상품과 무관하거나 반복되는 동일
										단어/문장을 사용하여 후기로 볼 수 없는 글, 판매자와 고객의 후기 이용을 방해한다고 판단되는 경우, 배송
										박스, 구매 상품을 구분할 수 없는 전체 사진, 화면캡쳐, 음란 및 부적절하거나 불법적인 내용은 통보없이 삭제
										될 수 있습니다.</li>
									<li class="dialog-review-caution-li">전화번호, 이메일, 주소, 계좌번호 등
										개인정보가 노출되지 않도록 주의해주세요.</li>
									<li class="dialog-review-caution-li">사진후기로 등록한 후기의 경우, 최소
										1장의 사진을 등록 후 수정이 가능합니다.</li>
								</ul>
							</div>

							<div class="dialog-review-caution-secret">
								<label class="dialog-review-caution-label"></label>
							</div>

							<div class="dialog-review-button-end-box">
								<button id="review-cancel" type="button">취소</button>
								<button id="review-regiseter" name="cbNo" value="">등록</button>
							</div>
				</form>
				</main>


			</div>
	</div>
</body>
</html>

<script>
    //업로드
     function onClickUpload() {
             let myInput = document.getElementById("my-input");
            myInput.click();
         }

    // 모달 구매확정 버튼
    const modalOpenButton = document.querySelectorAll(".order-buy-sure-before")
    const modalCloseButton = document.querySelector("#modal-close")
    const modalSureButton = document.querySelector(".btn-sure")
    const modal = document.querySelector(".modal-sure") 
    const payNo = document.querySelectorAll(".payNo")
	const sure = document.querySelector(".btn-sure") 
	
	

    
   
    
    
    
    for(let i=0; i<modalOpenButton.length; i++){
        modalOpenButton[i].addEventListener('click', () => {
        	    	
    modal.classList.remove('modal-sure-hiddnen');
    	
    		sure.value = payNo[i].innerHTML;
    	 
    });
   }
  
    
   

    
    modalCloseButton.addEventListener('click', () => {
    modal.classList.add('modal-sure-hiddnen');
    	console.log(sure)
    });

    modalSureButton.addEventListener('click', () => {
    modal.classList.add('modal-sure-hiddnen');
    		

    });
    
    // 여기다 리뷰 
    const cbNO =  document.querySelectorAll(".cbNO")
    
    //썸네일주기
    const thumbnail = document.querySelectorAll(".thumbnail")
    // 아이템이름 주기
    const itemtitle = document.querySelectorAll(".itemtitle")
    
    //리뷰넘
    const reviewNo = document.querySelectorAll(".reviewNo")
   
    
    // 모달창 이미지 소스 아이템이름 
    const imgSrcModal  = document.querySelector(".imgSrc-modal")
    const  itemTitleModal = document.querySelector(".item-title-modal")
  	
    

    // 모달 후기작성 버튼
    const reviewModalOpenButton = document.querySelectorAll(".order-review-before")
   
    const reviewModalCloseButton = document.querySelector("#review-cancel")
  
    const reivewModalSureButton1 = document.querySelector("#review-regiseter")
   
    const reviewModal = document.querySelector(".modal-review")

    const reviewregiseterBtn = document.querySelector(".review-regiseter")


    for(let i=0; i<reviewModalOpenButton.length; i++){
        reviewModalOpenButton[i].addEventListener('click', () => {   
        	imgSrcModal.src=thumbnail[i].innerHTML;
        	itemTitleModal.innerHTML= itemtitle[i].innerHTML;
        	
            reviewModal.classList.remove('modal-review-hidden');     
    });
   }
    reviewModalCloseButton.addEventListener('click', () => {
        reviewModal.classList.add('modal-review-hidden');
    });

    reivewModalSureButton1.addEventListener('click', () => {
        reviewModal.classList.add('modal-review-hidden');
        alert("리뷰 작성이 완료되었습니다")

    });
    
    
    
    
	<%if (searchMap != null) {%>
	
	
	 function pageNext(){
		 location.href = '/nongra/admin/manageReview/search?pno=' + <%=pvo.getCurrentPage() + 1%> + '&searchType=' + '<%=searchMap.get("searchType")%>' + '&searchValue=' + '<%=searchMap.get("searchValue")%>';
	 };
 	 function pagePrevious(){
 		 location.href = '/nongra/admin/manageReview/search?pno=' + <%=pvo.getCurrentPage() - 1%> + '&searchType=' + '<%=searchMap.get("searchType")%>' + '&searchValue=' + '<%=searchMap.get("searchValue")%>';  
 	 };
				 
	 <%} else {%>
	
	 function pageNext(){
		 
	 
		 	location.href = '/nongra/member/orderDetail?pno=' + <%=pvo.getCurrentPage() + 1%>
	       
	    }

	    function pagePrevious(){
	    	location.href = '/nongra/member/orderDetail?pno=' + <%=pvo.getCurrentPage() - 1%>
	    	     
	       }

	 <%}%>
	 
	 


</script>