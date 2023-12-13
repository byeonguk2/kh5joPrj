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
	<link rel="stylesheet" href="/nongra/resources/css/review/sellerManageReview.css">
	
	
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
		<%@ include file="/WEB-INF/views/common/header/header_seller.jsp" %>
	</div>
	<div id = "main-area">
		<%@ include file="/WEB-INF/views/common/aside/aside_seller.jsp" %>
		
		<div id="headerer">
		<section class="review-section"> 
                <div class="my-review"> 
                 <h2>리뷰 관리</h2>
               </div> 
         
               <!--체크박스로 ajax 처리-->
               
             <div class="seller-review-div-checkbox">
                  <span>답변 미작성 목록 <input type="checkbox"></span>   
             </div>
             
           
             <!--리뷰 -->
            <c:forEach items="${ReviewVoList}" var="vo">
        		<div class ="reviewNO" style="display : none">${vo.reviewNo}</div>
             <div class="review" >
                 <div class="review-user-nick">
                     <figure class="user-photo" style="background-image: url("${vo.profile}")></figure> <span>${vo.nick}</span>
                 </div>
         
                 <div class="review-content-box">
                     <div class="review-item-name">${vo.itemTitle}</div>
                     <p class="review-content">
                         ${vo.content}
                     </p>
                     
                     <div class="reivew-picture-box">
                     <c:forEach items="${vo.fileSrc}" var="str">
                     <img src="${str}" alt="리뷰사진" class="review0">
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
                        sadasdasd
                    asdasdasd
                        asd
                         <button class="review-recommend-btn">
                             <span class="review-b"></span>
                             <span class="review-like">도움돼요 ${vo.likeCnt}</span>
                         </button>
                     </footer>
                     <div class="owner-replay-box">
                         <span class="reply-span1">답글보기</span>
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
                    		 
                 	<div class="owner-reply-box2-date-btn">
                         <span>${vo.replyDate}</span>
                         
                     </div> 
                    		 
					    </c:when>
					    <c:when test="${empty vo.replyContent}">
					        	<p class="review-content" >
                     	 		답변 대기 중
                    		 	</p>
                    	<div class="owner-reply-box2-date-btn">
                         <span>${vo.replyDate}</span>
                         
                          <div>
                          <button class="register-btn">답변 등록</button>
                          </div>
                     	</div> 		 	
                    		 	
					    </c:when>
					    <c:otherwise>
					        	<p class="review-content">
                     	 		${vo.replyContent} 
                    		 	</p>
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
                    		 	
                         
                         		<div>
                         		 <button class="change-btn" >수정</button><span>|</span><button class="delete-btn">삭제</button>
                          		</div>
                    		</div>
					    </c:otherwise>
					</c:choose>
                     
         
                  
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
	</div>
</body>


<!-- 답변 등록 모달창 -->

<div class="review-answer-modal review-answer-modal-hidden">
    <div class="review-answer-dialog">
        <div class="review-answer-dialog-div1">
            <h1>답변작성</h1> <label for="review-answer-modal-btn-cancel2">X</label>
        </div>
     <form class="review-answer-dialog-form" action="">
        <textarea placeholder=" 고객님께 답글을 남겨주세요" name="" id="" cols="30" rows="10"></textarea>
        <div>
        <button id="review-answer-modal-btn-cancel2" type="button">취소</button>
        <button class="review-answer-modal-btn-register" >등록</button>
        </div>
    </form>
    </div>
</div>

<!-- 답변 수정 모달창 -->

<div class="review-answer-modal-1 review-answer-modal-hidden-1">
		<div class="review-answer-dialog-1">
			<div class="review-answer-dialog-div1-1">
                <h1>답변수정</h1> <label for="review-answer-modal-btn-cancel-1">X</label>
            </div>
         <form class="review-answer-dialog-form-1" action="review-answer-modal-btn-cancel-1">
            <textarea placeholder=" 고객님께 답글을 남겨주세요" name="" id="" cols="30" rows="10"></textarea>
            <div>
            <button id="review-answer-modal-btn-cancel-1" type="button">취소</button>
            <button class="review-answer-modal-btn-register-1" type="button">수정</button>
            </div>
        </form>
		</div>
	</div>

    <!-- 답변 삭제 모달창 -->
        <!-- 모달 삭제 창 -->
<div class="modal-sure modal-sure-hiddnen">
    <div class="dialog-sure">
        <div class="dialog-sure-btn"><button id="modal-close">X</button></div>
        <span >-삭제 시  복구는 불가능 합니다 </span>
        <span>정말 삭제 하시겠습니까?</span>

        <div class="modal-sure-btn-box">
            <button class="btn-sure">삭제</button><label class="btn-quit" for="modal-close">취소</label>
        </div>
    </div>
</div>



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
    
   


     
    
    // 답변 등록 버튼 //
	
    const modalReviewOpenButton  = document.querySelectorAll(".register-btn")
    var modalReviewCloseButton = document.querySelector("#review-answer-modal-btn-cancel2")
    const modalReviewRegisterButton  = document.querySelector(".review-answer-modal-btn-register")
    const modalReview = document.querySelector(".review-answer-modal")


    //쓰기
    for(let i=0; i<modalReviewOpenButton.length; i++){
        modalReviewOpenButton[i].addEventListener('click', () => {
            modalReview.classList.remove('review-answer-modal-hidden');
           
    });

    }

     
    modalReviewCloseButton.addEventListener('click', () => {
        modalReview.classList.add('review-answer-modal-hidden');
    }); 

    //등록
    modalReviewRegisterButton.addEventListener('click', () => {
        modalReview.classList.add('review-answer-modal-hidden');

    });


     // 답변 수정 버튼 //

    const modalReviewChangeButton  = document.querySelectorAll(".change-btn")
    console.log(modalReviewChangeButton)
   
    const modalReviewChangeCloseButton = document.querySelector("#review-answer-modal-btn-cancel-1")
    const modalReviewChangeRegisterButton  = document.querySelector(".review-answer-modal-btn-register-1")
    const modalChangeReview = document.querySelector(".review-answer-modal-1")


    //쓰기
    for(let i=0; i<modalReviewChangeButton.length; i++){
        modalReviewChangeButton[i].addEventListener('click', () => {
        	
            modalChangeReview.classList.remove('review-answer-modal-hidden-1');
    });

    }

    //닫기
    modalReviewChangeCloseButton.addEventListener('click', () => {
        modalChangeReview.classList.add('review-answer-modal-hidden-1');
    });

    //변경 등록
    modalReviewChangeRegisterButton.addEventListener('click', () => {
        modalChangeReview.classList.add('review-answer-modal-hidden-1');
       

    });



    //삭제 버튼
    const modalOpenButton = document.querySelectorAll(".delete-btn")
    const modalCloseButton = document.querySelector("#modal-close")
    const modalSureButton = document.querySelector(".btn-sure")
    const modal = document.querySelector(".modal-sure")


   for(let i=0; i<modalOpenButton.length; i++){
       modalOpenButton[i].addEventListener('click', () => {
   modal.classList.remove('modal-sure-hiddnen');
   });

   }

   
   modalCloseButton.addEventListener('click', () => {
   modal.classList.add('modal-sure-hiddnen');
   });

   modalSureButton.addEventListener('click', () => {
   modal.classList.add('modal-sure-hiddnen');
      

   });

	
  
    
    
   
		
	
	
   
	var deleteYnValue = "<%=deleteYn %>";
    
    
    



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
		 
	 
		 	location.href = '/nongra/seller/manageReview?pno=' + <%=pvo.getCurrentPage()+1%>
	       
	    }

	    function pagePrevious(){
	    	location.href = '/nongra/seller/manageReview?pno=' + <%=pvo.getCurrentPage()-1%>
	    	     
	       }

	 <%}%>
   
</script>



