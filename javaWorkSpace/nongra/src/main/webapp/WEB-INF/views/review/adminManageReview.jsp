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
	<link rel="stylesheet" href="/nongra/resources/css/review/adminManageReview.css">
	
<style type="text/css">
	#main-area{
		display: grid;
		grid-template-columns: 230px 8fr;
		padding-top: 145px;
	}
	.headerer{
		display: flex;
        justify-content: center;
        align-items: center;		
	}
	
</style>
</head>
<body>
	<div id="wrap">
		<%@ include file="/WEB-INF/views/common/header/header_admin.jsp" %>
		<div id = "main-area">
			<%@ include file="/WEB-INF/views/common/aside/aside_admin.jsp" %>
			
			<div class="headerer">
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
                         "${vo.content}"
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
                        
                         <button class="review-recommend-btn">
                             <span class="review-b"></span>
                             <span class="review-like">도움돼요 ${vo.likeCnt}</span>
                         </button>
                     </footer>
                     <div class="owner-replay-box">
                         <span class="reply-span1">답글보기</span><button class="reply-delete-btn">삭제</button> 
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
                         <span>${vo.replyDate}</span> 
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
         
         <div class="review-search-box">
             
         <form action="/nongra/admin/reviewmanage/search" method="get">
             <select name="searchType">
            	<option value="CONTENT">내용</option>
            	<option value="REVIEW_NO">리뷰번호</option>
            	<option value="NICK">작성자</option>
             </select>
             <input type="text" name="searchValue" placeholder= "검색할 내용을 입력하세요" > <input type="submit" value="검색">
         </form>
         </div>
             </section>
             </div>
				
		</div>
	</div>
</body>

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
	
  
    
    
    
   
   //병욱 펑션
	const c = document.querySelector(".aside-item > label");
	const menu = document.querySelector(" aside > :nth-child(2) ");
	
	const menu1 = document.querySelector(" aside > :nth-child(2) > a ");
	const menu2 = document.querySelector(" aside > :nth-child(3) > a ");
	c.innerHTML = "원 하 는 값";


	menu2.innerHTML = "원하는값";
    menu1.innerHTML = "원하는값";
		
	
	
   
	var deleteYnValue = "<%=deleteYn %>";
    
    if(deleteYnValue == '실패'){
    	alert('리뷰 삭제' +deleteYnValue);
    }	
    

    
 	

	/*페이징 처리  */

     function pageNext(){
		
		location.href = '/nongra/admin/manageReview?pno=' + <%=pvo.getCurrentPage()+1%>
      
    }

    function pagePrevious(){
    	location.href = '/nongra/admin/manageReview?pno=' + <%=pvo.getCurrentPage()-1%>
    	     
       }
    
	
	 
	 




   
    </script>
    
    
    