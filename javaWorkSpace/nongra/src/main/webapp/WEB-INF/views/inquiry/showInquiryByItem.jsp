<%@page import="java.util.Map"%>
<%@page import="com.kh.app.page.vo.PageVo"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
    
      <%
    // JSP에서 Java 코드로 DeleteYn 값을 가져옴
    String deleteYn = (String) request.getAttribute("DeleteYn");
    PageVo pvo = (PageVo)request.getAttribute("pvo");
    Map<String, String> searchMap = (Map<String, String>)request.getAttribute("searchMap");
%>
    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>

	<link rel="stylesheet" href="/nongra/resources/css/common/cssReset.css">
	<link rel="stylesheet" href="/nongra/resources/css/inquiry/showInquiryByItem.css">

<style>
		body{
		
			
		}
		#wrap{
			width : 100%;
		}
		#main-area{
		display: grid;
		grid-template-columns: 250px 8fr;
		}
		}
		#headerer{
			display: flex;
			align-items: center;
			justify-content: center;
		}
		
		
	</style>
	
	
</head>
<body>
	<div id="wrap">
		<%@ include file="/WEB-INF/views/common/header/header_sobi.jsp" %>
	</div>
	  <div id = "main-area">
		
		<%@ include file="/WEB-INF/views/common/aside/aside_sobi_main.jsp" %>
			
			
			<c:set var="votitle" value="${produtInquiryVoList[0]}"/>
			
			<div id="headerer">
			
			<body>
  <section class="product-inquery-section" >  
    <div class="product-inquery-header">
        <div class="product-inquery-title-box">
            <h2>상품문의</h2>  <button class="product-inquery-btn">
                <span>문의하기</span>
            </button>
        </div>
        <ol class="product-inquery-annunce-ol">
            <li class="product-inquery-annunce-li">-상품에 대한 문의글 남기는 공간입니다.해당 게시판의 성격과 다른 글은 사전동의 없이 삭제 될 수 있습니다. </li>
            <li class="product-inquery-annunce-li">-배송관련,주문 관련 문의 및 요청사항은 1:1문의에 남겨주세요</li>
        </ol>
    </div>

    <div class="seller-review-div-checkbox">
        <span>답변 대기 <input type="checkbox"></span>   
    </div>


            <div class="product-inquery">
                <table class="product-inquery-table">
                    <thead class="product-inquery-thead">
                        <tr>
                            <th class="itemname">상품명</th>
                            <th class="title">제목</th>
                            <th class="author">작성자</th>
                            <th class="created-date">작성일</th>
                            <th class="status">답변상태</th>
                        </tr>
                    </thead>
                    <c:forEach items="${produtInquiryVoList}" var="vo">
                    <tbody class="product-inquery-tbody ">
                		<tr class="product-inquery-sercret product-inquery-normal ">
                            <td>${vo.itemtitle}</td>
							
							<c:choose>
							   <c:when test="${vo.secretYn eq 'Y'}">
							    <td >
                                    <span class="secreet-text">비밀글입니다.</span>
                                    <div style="display: inline-block; padding-left: 5px;">
                                    <img src="/resources/inquiry/lock.svg">
                                    </div>                                   
                            	</td> 
							   </c:when>
							   <c:otherwise>
							      <td>${vo.content}</td>
							   </c:otherwise>
							</c:choose>                		
                                                      
                            <td class=>${vo.userName}</td>
                            <td class=>${vo.enrollDate}</td>
                            
                            <c:choose>
							    <c:when test="${not empty vo.inquireReply}">
							        <td >답변완료</td>
							    </c:when>
							    <c:otherwise>
							         <td>답변대기</td>
							    </c:otherwise>
							</c:choose>
                            </tr>

                            <tr class="produt-inquery-answer-tr produt-inquery-answer-tr1">
                                <td colspan="5">
                                    <div class="user-inquery-qustion-box">
                                        <div class="user-iquery-qustion">
                                           <span>Q)</span> 
                                           
                                           
                                           <span> 아랫부분에 구멍이 나서 샜어요 어떻게 하나요?</span>
                                        </div>
                                    </div>
    
                                    <div class="user-iquery-qustion-answer">
                                        <span>A)[${vo.businessName }] </span>
                                        
                                        <c:choose>
										    <c:when test="${not empty vo.inquireReply}">
										    	<span>
                                      			${vo.inquireReply}
                                    			</span>	
										    </c:when>
										    <c:otherwise>
										    	<span>
		                                         답변대기
		                                        </span>
										    </c:otherwise>
										</c:choose>                                       
                                    </div>
                                    <div class="user-iquery-qustion-answer-date">
                                        <span>${vo.replyEnrollDate}</span>
                                    </div>
                                    <c:choose>
								    <c:when test="${not empty vo.replyEnrollDate}">
								    <div class="user-iquery-qustion-answer-date">
                                        <span>${vo.replyEnrollDate}</span>
                                    </div>
								    </c:when>
								    <c:otherwise>
								   </c:otherwise>
									</c:choose> 	    
                                   <div class="reivew-picture-box">
				                     <c:forEach items="${vo.list}" var="list1">
				                     <img src=${list1.fileSrc} alt="리뷰사진" class="review0">
				                     </c:forEach>
				                    </div>
                                </td>
                            </tr>
                         </c:forEach>
                    </tbody>
                </table>
            </div>
        
            <div class="inquery-paging-area">
                <div class="inquery-pageing-btn-area" >
                    <% if(pvo.getCurrentPage() == 1) {%>
             		<button ><img src="/nongra/resources/img/review/paging-prev-disabled.svg" ></button>
             	<%}else{   %>
             		<button class=page-btn-next onclick = 'pagePrevious()' ><img src="/nongra/resources/img/review/paging-prev-activated.svg" ></button>                                            
                 <%	} %>
                 	 
                  <% if(pvo.getCurrentPage() == pvo.getMaxPage()) {%>
             		<button ><img src="/nongra/resources/img/review/paging-next-disabled.svg" ></button>
             	<%}else{   %>
             		<button class=page-btn-previous onclick= 'pageNext()'><img src="/nongra/resources/img/review/paging-next-activated.svg" ></button>                                            
                 <%	} %>	
                </div>
            </div>

            <div class="review-search-box">
    
                <form action="">
                    <select name="serachtype">
                        <option value="user">작성자</option>
                        <option value="content">내용</option>
                    </select>
                    <input type="text" name="?"> <input type="submit" value="검색">
                </form>
                </div>
</section>
			
			
			</div>
	</div>
	
	


</body>

<!-- 모달 상품 문의창  -->
<div class="modal-review modal-review-hidden">
    <div class="dialog-review">
        <div class="dialog-review-header">
            <h2>상품 문의</h2> <label for="review-cancel">X</label>
        </div>
        <div class="dialog-review-img-box">
            
            <span>${votitle.itemtitle}</span>
        </div>

        

        <form action="/nongra/member/InquiryWrite"  method="post" enctype="multipart/form-data" >
            <div class="dialog-review-content-box">
                <div>내용</div>
                
                <textarea id="contents" placeholder="상품 특성에 맞는 문의를 작성해주세요.(20자 이상)" inputmode="text" aria-label="textarea-message" name="content" class="css-5etceh e1tjt2bn1"></textarea>

            </div>

            <div>
    			<div>        
	            <div>
                <div class="dialog-review-content-picture-input-box">
                    <h3>사진 첨부</h3>
                    <div>
                        <input id="my-input" type="file" name='f'  multiple   >
                       <!--  <button class="dialog-review-content-picture-input-btn" onclick="onClickUpload()" type="button"><img src="" alt=""></button> -->
                    </div>
                </div>
            </div>

            <div class="dialog-review-caution ">
                <label class="dialog-review-caution-label"></label>
                <ul class="dialog-review-caution-ul">
                    <li class="dialog-review-caution-li">사진은 최대 8장까지, 30MB 이하의 이미지만 업로드가 가능합니다.</li>
                    <li class="dialog-review-caution-li">상품과 무관하거나 반복되는 동일 단어/문장을 사용하여 후기로 볼 수 없는 글, 판매자와 고객의 후기 이용을 방해한다고 판단되는 경우, 배송 박스, 구매 상품을 구분할 수 없는 전체 사진, 화면캡쳐, 음란 및 부적절하거나 불법적인 내용은 통보없이 삭제 될 수 있습니다.</li>
                    <li class="dialog-review-caution-li">전화번호, 이메일, 주소, 계좌번호 등 개인정보가 노출되지 않도록 주의해주세요.</li>
                </ul>
            </div>
            <div class="dialog-review-caution-secret">
                <label class="dialog-review-caution-label"></label>
                <input type="checkbox" name="secretYn" value='Y'>
                <span>문의 비밀글</span>
            </div>

            <div class="dialog-review-button-end-box">
                <button id="review-cancel" type="button" >취소</button>
                <button id="review-regiseter" name="salesNo" value="${votitle.salesNo}">등록</button>
            </div>
        </form> 
    </div>


</html>

<script>


//판매자 답변 토글 //
const answer1 =document.querySelectorAll(".product-inquery-normal")
const answer2 =document.querySelectorAll(".produt-inquery-answer-tr1");

for(let i=0; i<answer1.length; ++i){
    answer1[i].addEventListener('click',()=>{
    answer2[i].classList.toggle("produt-inquery-answer-tr")
	for(let j=0; j<x.length; ++j){
		if(i!=j){
			answer2[j].classList.add("produt-inquery-answer-tr")
		}
	}   
} )      
}

const ser =  document.querySelectorAll(".secreet-text")

	for(let i=0; i<ser.length; ++i){
		ser[i].addEventListener('click',()=>{
			alert("비밀글 입니다")
		})
	}

/*페이징 처리  */
<% if(searchMap !=null){  %>


 function pageNext(){
	 location.href = '/nongra/admin/member/manageInquiry?pno=' + <%=pvo.getCurrentPage()+1%> + '&searchType=' + '<%= searchMap.get("searchType") %>' + '&searchValue=' + '<%=searchMap.get("searchValue")%>';
 };
	 function pagePrevious(){
		 location.href = '/nongra/admin/member/manageInquiry?pno=' + <%=pvo.getCurrentPage()-1%> + '&searchType=' + '<%= searchMap.get("searchType") %>' + '&searchValue=' + '<%=searchMap.get("searchValue")%>';  
	 };
			 
 <%} else{%>

 function pageNext(){
	 
 
	 	location.href = '/nongra/member/showInquiryByItem?pno=' + <%=pvo.getCurrentPage()+1%>
       
    }

    function pagePrevious(){
    	location.href = '/nongra/member/showInquiryByItem?pno=' + <%=pvo.getCurrentPage()-1%>
    	     
       }
 <%}%>
 
 // 모달 후기작성 버튼
 const reviewModalOpenButton = document.querySelectorAll(".product-inquery-btn")
  
 const reviewModalCloseButton = document.querySelector("#review-cancel")

 const reivewModalSureButton1 = document.querySelector("#review-regiseter")

 const reviewModal = document.querySelector(".modal-review")

 for(let i=0; i<reviewModalOpenButton.length; i++){
      reviewModalOpenButton[i].addEventListener('click', () => {
          
          reviewModal.classList.remove('modal-review-hidden');
  });

  }

  reviewModalCloseButton.addEventListener('click', () => {
      reviewModal.classList.add('modal-review-hidden');
  });

  reivewModalSureButton1.addEventListener('click', () => {
      reviewModal.classList.add('modal-review-hidden');

  });


</script>