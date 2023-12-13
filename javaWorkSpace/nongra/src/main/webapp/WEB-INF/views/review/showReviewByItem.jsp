<%@page import="java.util.Map"%>
<%@page ="java.util.Map"%>
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
                     <figure class="user-photo" style="background-image: url("${vo.profile}")></figure> <span>${vo.nick}</span>
                 </div>
         
                 <div class="review-content-box">
                     <div class="review-item-name">${vo.itemTitle}</div>
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
                        
                         <button class="review-recommend-btn  ">
                             <span class="review-b"></span>
                         <c:choose>
						   <c:when test="${not empty vo.recommendYn }">
						      <span class="review-like review-like-after ">도움돼요<span class="like-num">${vo.likeCnt}</span> </span>
						   </c:when>
						
						   <c:otherwise>
						        <span class="review-like ">도움돼요<span class="like-num">${vo.likeCnt}</span></span>
						   </c:otherwise>
						</c:choose>
                           
                           
                            
                         </button>
                     </footer>
                     <div class="owner-replay-box">
                         <span class="reply-span1">답글보기</span>
                         <div>
                    
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
		 
	 
		 	location.href = '/nongra/member/showReviewByItem?pno=' + <%=pvo.getCurrentPage()+1%>
	       
	    }

	    function pagePrevious(){
	    	location.href = '/nongra/member/showReviewByItem?pno=' + <%=pvo.getCurrentPage()-1%>
	    	     
	       }
	    
	 // 
	 const reviewNoLike    = document.querySelectorAll(".reviewNO");
	 console.log(reviewNoLike)
	 const reviewLike      =  document.querySelectorAll(".review-like")
	 console.log(reviewLike)
	 const reviewLikeAfter =  document.querySelectorAll(".review-like-after")
	 console.log(reviewLikeAfter)
	 const likeCnt     =document.querySelectorAll(".like-num")
	  console.log(reviewLikeAfter)
	 
	 
	 
	 
	  
	    

	 <%}%>
	
    </script>
    