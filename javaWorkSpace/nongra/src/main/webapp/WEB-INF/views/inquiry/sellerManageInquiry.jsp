<%@page import="java.util.Map"%>
<%@page import="com.kh.app.page.vo.PageVo"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
 <%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
    
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
	<link rel="stylesheet" href="/nongra/resources/css/inquiry/sellerManageInquiry.css">

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
		#headerer{
			display: flex;
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
			<section class="product-inquery-section" >  
    <div class="product-inquery-header">
        <div class="product-inquery-title-box">
            <h2>상품문의 관리</h2>
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
							      <td>포장지가 찢어져서 왔습니다.</td>
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
                                    <c:choose>
								    <c:when test="${not empty vo.replyEnrollDate}">
								    <div class="user-iquery-qustion-answer-date">
                                        <span>${vo.replyEnrollDate}</span>
                                    </div>
								    </c:when>
								    <c:otherwise>
								   </c:otherwise>
									</c:choose> 	    
                                  <div class ="review-btn-img-box">
                                   <div class="reivew-picture-box">
				                     <c:forEach items="${vo.list}" var="list1">
				                     <img src=${list1.fileSrc} alt="리뷰사진" class="review0">
				                     </c:forEach>
				                  </div>
				                  
				                  <c:choose>
				                  <c:when test="${not empty vo.inquireReply}">				                  
				                  </c:when>
				                  <c:otherwise>
				                    <div>
				                    	<button onclick >답변등록</button>
				                    </div>
				                  </c:otherwise>
				                  </c:choose>
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


/*페이징 처리  */
<% if(searchMap !=null){  %>


function pageNext(){
	 location.href = '/nongra/admin/seller/manageInquiry?pno=' + <%=pvo.getCurrentPage()+1%> + '&searchType=' + '<%= searchMap.get("searchType") %>' + '&searchValue=' + '<%=searchMap.get("searchValue")%>';
};
	 function pagePrevious(){
		 location.href = '/nongra/admin/seller/manageInquiry?pno=' + <%=pvo.getCurrentPage()-1%> + '&searchType=' + '<%= searchMap.get("searchType") %>' + '&searchValue=' + '<%=searchMap.get("searchValue")%>';  
	 };
			 
 <%} else{%>

 function pageNext(){
	 
 
	 	location.href = '/nongra/seller/manageInquiry?pno=' + <%=pvo.getCurrentPage()+1%>
       
    }

    function pagePrevious(){
    	location.href = '/nongra/seller/manageInquiry?pno=' + <%=pvo.getCurrentPage()-1%>
    	     
       }
 <%}%>


</script>