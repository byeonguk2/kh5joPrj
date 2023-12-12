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
	<link rel="stylesheet" href="/nongra/resources/css/review/memberManageReview.css">
	
	
	
	<style>
		body{
		
			
		}
		#wrap{
			width : 100%;
		}
		#main-area{
		display: grid;
		grid-template-columns: 230px 8fr;
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
		 <%@ include file="/WEB-INF/views/common/header/header_sobi_memberModify.jsp" %> 
	</div>
	  <div id = "main-area">
		
		 <%@ include file="/WEB-INF/views/common/aside/aside_sobi_main.jsp" %> 
			<div id="headerer">
			 <section class="review-section"> 
                <div class="my-review"> 
                 <h2>리뷰 관리</h2>
               </div> 
         
               <!--체크박스로 ajax 처리-->
               
             <div class="seller-review-div-checkbox">
                <!--  <span>답변 미작성 목록 <input type="checkbox"></span>  -->  
             </div>
             
           
             <!--리뷰 -->
            <c:forEach items="${ReviewVoList}" var="vo">
        		<div class ="reviewNO" style="display : none">${vo.reviewNo}</div>
             <div class="review" >
                 <div class="review-user-nick">
                     <figure class="user-photo" style="background-image: url("${vo.profile}")></figure> <span>"${vo.nick}"</span>
                 </div>
         
                 <div class="review-content-box">
                     <div class="review-item-name">"${vo.itemTitle}"</div>
                     <p class="review-content">
                         ${vo.content}
                     </p>
                     
                     <div class="reivew-picture-box">
                     <c:forEach items="${vo.reviewFileVolist}" var="vo1">
                     <c:if test="${not empty vo1.reviewFielSrc}">
                     <img src="${vo1.reviewFielSrc}" alt="리뷰사진" class="review0">
                     <div class="div-reviewFileNo" style= "display : none"> "${vo1.reviewFileNo}" </div>
                     </c:if>
                     </c:forEach>
                     </div>
                     
                     <footer class="review-date-box">
                        <c:choose>
						   <c:when test="${empty vo.updateDate }">
						      <span class="review-date">${vo.writeDate}</span>
						   </c:when>
						
						   <c:otherwise>
						       <span class="review-date">${vo.updateDate}</span>
						   </c:otherwise>
						</c:choose>
                        
                         <button class="review-recommend-btn">
                             <span class="review-b"></span>
                             <span class="review-like">도움돼요 ${vo.likeCnt}</span>
                         </button>
                     </footer>
                     <div class="owner-replay-box">
                         <span class="reply-span1">답글보기</span>
                         <div>
                         <button class="change-btn">수정</button>
                         <button class="reply-delete-btn">삭제</button>
                         </div> 
                     </div> 
                 </div>
             </div>
         
             <div class="owner-reply-box2 owner-reply-box3" > 
         
                 <div class="owner-reply-box2-title">
                     <span>[${vo.corporationName}]</span>
                 </div>
         
                 <div class="owner-reply-box2-content">
                 	 
                   
                   
                    <c:choose>
					    <c:when test="${vo.replyDelYn eq 'Y'}">
					         <p class="review-content">
                     	 		삭제 된 답변 입니다. 
                    		 </p>
					    </c:when>
					    <c:when test="${empty vo.replyContent}">
					        	<p class="review-content" >
                     	 		답변 대기 중
                    		 	</p>
					    </c:when>
					    <c:otherwise>
					        	<p class="review-content">
                     	 		${vo.replyContent} 
                    		 	</p>
					    </c:otherwise>
					</c:choose>
                     
         
                     <div class="owner-reply-box2-date-btn">
                       
                       
                          <c:choose>
					    <c:when test="${vo.replyDelYn eq 'Y'}">
					       
                     	 		<span></span> 
                    		
					    </c:when>
					    <c:when test="${empty vo.replyContent}">
					        	<span></span> 
					    </c:when>
					    <c:otherwise>
                     	 		<span>${vo.replyDate}</span>        		 
					    </c:otherwise>
                       </c:choose>
                       
                     </div> 
                 </div>       
             </div>
        </c:forEach>
         
             
         
             
             
         
                 
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
         
         
             </section>
			
			</div>
	</div>
	
	
	  <!-- 모달 삭제 창 -->
<div class="modal-sure modal-sure-hiddnen">
    <div class="dialog-sure">
        <div class="dialog-sure-btn"><button id="modal-close">X</button></div>
        <span >-삭제 시 리뷰 복구는 불가능 합니다 </span>
        <span>정말 삭제 하시겠습니까?</span>

        <div class="modal-sure-btn-box">
            <button class="btn-sure">삭제</button><label class="btn-quit" for="modal-close">취소</label>
        </div>
    </div>
</div>




<!-- 모달 수정작성 창 -->

<div class="modal-review modal-review-hidden">
    <header class="dialog-review">
        <header class="dialog-review-header">
            <h2>후기 작성</h2> <label for="review-cancel">X</label>
        </header>
        <div class="dialog-review-img-box">
            <img src="" alt="상품사진">  
            <span>[못난이토마토] 못난이토마볶음 500g</span>
        </div>

        <div class="dialog-review-img-exemple">
            <h2>후기는 이렇게 작성해보세요</h2>
            <p class>제품의 <span class="dialog-review-img-exemple-span">맛·향·크기·사용감</span> 등을 설명해주세요
                <strong>좋았던 점, 아쉬웠던 점</strong>도 솔직하게 얘기해주세요</p>
           
        </div>

        <form action="">
            <div class="dialog-review-content-box">
                <div>내용</div>
                
                <textarea id="contents" placeholder="상품 특성에 맞는 후기를 작성해주세요.(20자 이상)" inputmode="text" aria-label="textarea-message" name="contents" class="css-5etceh e1tjt2bn1"></textarea>

            </div>

            <div>
                <div class="dialog-review-content-picture-input-box">
                    <h3>사진 첨부</h3>
                    <div>
                        <input id="my-input" type="file">
                        <button class="dialog-review-content-picture-input-btn" onclick="onClickUpload()"><img src="" alt=""></button></div>
                </div>
            </div>

            <div class="dialog-review-caution">
                <label class="dialog-review-caution-label"></label>
                <ul class="dialog-review-caution-ul">
                    <li class="dialog-review-caution-li">사진은 최대 8장까지, 30MB 이하의 이미지만 업로드가 가능합니다.</li>
                    <li class="dialog-review-caution-li">상품과 무관하거나 반복되는 동일 단어/문장을 사용하여 후기로 볼 수 없는 글, 판매자와 고객의 후기 이용을 방해한다고 판단되는 경우, 배송 박스, 구매 상품을 구분할 수 없는 전체 사진, 화면캡쳐, 음란 및 부적절하거나 불법적인 내용은 통보없이 삭제 될 수 있습니다.</li>
                    <li class="dialog-review-caution-li">전화번호, 이메일, 주소, 계좌번호 등 개인정보가 노출되지 않도록 주의해주세요.</li>
                    <li class="dialog-review-caution-li">사진후기로 등록한 후기의 경우, 최소 1장의 사진을 등록 후 수정이 가능합니다.</li>
                </ul>
            </div>

            <div class="dialog-review-caution-secret">
                <label class="dialog-review-caution-label"></label>
                <input type="checkbox">
                <span>후기 비공개하기</span>
            </div>

            <div class="dialog-review-button-end-box">
                <button type="button" id="review-cancel">취소</button>
                <button id="review-regiseter">수정</button>
            </div>
        </form>  
    </header>
</div>


</body>
</html>


 <script>

  //판매자 답글보기

  const x =document.querySelectorAll(".reply-span1")
    const y =document.querySelectorAll(".owner-reply-box2");
    
    
    for(let i=0; i<x.length; ++i){
        x[i].addEventListener('click',()=>{
        y[i].classList.toggle("owner-reply-box3")
        	for(let j=0; j<x.length; ++j){
        		if(i!=j){
        			y[j].classList.add("owner-reply-box3")
        		}
        	}
    } )      
    }


     // 모달 구매확정 버튼
    
     //리뷰넘버
     const reviewNo =document.querySelectorAll(".reviewNO")

     //삭제 버튼
     const modalOpenButton = document.querySelectorAll(".reply-delete-btn")
    
     const modalCloseButton = document.querySelector("#modal-close")
    
     //확정 버튼
     const modalSureButton = document.querySelector(".btn-sure")
    
     const modal = document.querySelector(".modal-sure")


    for(let i=0; i<modalOpenButton.length; i++){
        modalOpenButton[i].addEventListener('click', () => {
    modal.classList.remove('modal-sure-hiddnen');
    window.x = reviewNo[i].innerHTML;
  
    });

    }
  
    modalCloseButton.addEventListener('click', () => {
    modal.classList.add('modal-sure-hiddnen');
    });

    modalSureButton.addEventListener('click', () => {
    modal.classList.add('modal-sure-hiddnen');
    
    location.href='/nongra/admin/reviewDelete?DeleteNo=' + window.x
    });
	
   
	var deleteYnValue = "<%=deleteYn %>";
    
    if(deleteYnValue === '실패'){
    	alert('리뷰 삭제' +deleteYnValue);
    }else if(deleteYnValue ==='성공'){
    	alert('리뷰 삭제' +deleteYnValue);
    }	
    



	<% if(searchMap !=null){  %>
	
	 function setSearchArea(){
  	//옵션태그 세팅
	 const optionTagArr = document.querySelectorAll(".review-search-box form option");
  		
  	
	 const searchType = "<%= searchMap.get("searchType") %>"; 
	
	 for(let i =0; i< optionTagArr.length; ++i){
		
		 if(optionTagArr[i].value === searchType){
			
			 optionTagArr[i].selected =true;
			 
			 break; 
		 }
	 }
	 var searchValueTag = document.querySelector(".review-search-box form input[name=searchValue]")
	  searchValueTag.value = "<%= searchMap.get("searchValue") %>"
	
	
			}
	  setSearchArea();

	<% } %>
	
 	
    
    

	
	/*페이징 처리  */
	<% if(searchMap !=null){  %>
	
	
	 function pageNext(){
		 location.href = '/nongra/admin/manageReview/search?pno=' + <%=pvo.getCurrentPage()+1%> + '&searchType=' + '<%= searchMap.get("searchType") %>' + '&searchValue=' + '<%=searchMap.get("searchValue")%>';
	 };
 	 function pagePrevious(){
 		 location.href = '/nongra/admin/manageReview/search?pno=' + <%=pvo.getCurrentPage()-1%> + '&searchType=' + '<%= searchMap.get("searchType") %>' + '&searchValue=' + '<%=searchMap.get("searchValue")%>';  
 	 };
				 
	 <%} else{%>
	
	 function pageNext(){
		 
	 
		 	location.href = '/nongra/member/manageReview?pno=' + <%=pvo.getCurrentPage()+1%>
	       
	    }

	    function pagePrevious(){
	    	location.href = '/nongra/member/manageReview?pno=' + <%=pvo.getCurrentPage()-1%>
	    	     
	       }

	 <%}%>
	

	  // 모달 후기수정 버튼
	    const reviewModalOpenButton = document.querySelectorAll(".change-btn")
	   
	    
	   const reviewModalCloseButton = document.querySelector("#review-cancel")
	 
	   const reivewModalSureButton1 = document.querySelector("#review-regiseter")
	  
	   const reviewModal = document.querySelector(".modal-review")

	   console.log(reviewModal)


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

	    const c1 =document.querySelectorAll(".product-inquery-normal")
	    const c2 =document.querySelectorAll(".produt-inquery-answer-tr1 ");
	    
	    for(let i=0; i<c1.length; ++i){
	        c1[i].addEventListener('click',()=>{
	        c2[i].classList.toggle("produt-inquery-answer-tr")
	           
	    } )      
	    }
    
	
	 
	 




   
    </script>