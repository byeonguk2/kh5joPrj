<%@page import="java.util.Map"%>
<%@page import="com.kh.app.page.vo.PageVo"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%
// JSP에서 Java 코드로 DeleteYn 값을 가져옴
String deleteYn = (String) request.getAttribute("DeleteYn");
PageVo pvo = (PageVo) request.getAttribute("pvo");
Map<String, String> searchMap = (Map<String, String>) request.getAttribute("searchMap");
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
		body{
		
			
		}
		#wrap{
			width : 100%;
		}
		#main-area{
		display: grid;
		grid-template-columns: 230px 8fr;
		padding-top: ;
		}
		#headerer{
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
					<div id="pay">페이금액 <%=loginMember.getPoint()%>원</div>
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
								<c:forEach items="${ReviewVoList}" var="vo" begin="0"
									end="3">

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
					<div id="img_box">
						<img src="https://dummyimage.com/100x100/000/fff.png&text=sample"
							alt="썸네일사진원본파일명">
					</div>
					<div id="img_box">
						<img src="https://dummyimage.com/100x100/000/fff.png&text=sample"
							alt="썸네일사진원본파일명">
					</div>
					<div id="img_box">
						<img src="https://dummyimage.com/100x100/000/fff.png&text=sample"
							alt="썸네일사진원본파일명">
					</div>
					<div id="img_box">
						<img src="https://dummyimage.com/100x100/000/fff.png&text=sample"
							alt="썸네일사진원본파일명">
					</div>
					<div id="img_box">
						<img src="https://dummyimage.com/100x100/000/fff.png&text=sample"
							alt="썸네일사진원본파일명">
					</div>
					<div id="img_box">
						<img src="https://dummyimage.com/100x100/000/fff.png&text=sample"
							alt="썸네일사진원본파일명">
					</div>

				</div>
			</div>
			
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
    
    
    
    
	<% if(searchMap !=null){  %>
	
	
	 function pageNext(){
		 location.href = '/nongra/admin/manageReview/search?pno=' + <%=pvo.getCurrentPage()+1%> + '&searchType=' + '<%= searchMap.get("searchType") %>' + '&searchValue=' + '<%=searchMap.get("searchValue")%>';
	 };
 	 function pagePrevious(){
 		 location.href = '/nongra/admin/manageReview/search?pno=' + <%=pvo.getCurrentPage()-1%> + '&searchType=' + '<%= searchMap.get("searchType") %>' + '&searchValue=' + '<%=searchMap.get("searchValue")%>';  
 	 };
				 
	 <%} else{%>
	
	 function pageNext(){
		 
	 
		 	location.href = '/nongra/member/orderDetail?pno=' + <%=pvo.getCurrentPage()+1%>
	       
	    }

	    function pagePrevious(){
	    	location.href = '/nongra/member/orderDetail?pno=' + <%=pvo.getCurrentPage()-1%>
	    	     
	       }

	 <%}%>
	 
	 


</script>