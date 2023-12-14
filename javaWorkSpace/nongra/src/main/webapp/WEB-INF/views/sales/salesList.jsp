<%@page import="com.kh.app.sales.vo.SalesVo"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%
	int listCount =	(int)request.getAttribute("listCount");
	List<SalesVo> salesVoList  = (List<SalesVo>)request.getAttribute("salesVoList");
%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" href="/nongra/resources/css/sales/salesList.css">
<style type="text/css">
	.item-area > img {
		width: 250px;
		height: 320px;
	}
	.isEmpty{
		width: 100%;
		height: 500px;
		display: flex;
		justify-content: center;
		align-items: center;
	}
	.x{
	 display: flex;
	 align-items: top;
	 height: 100%;
	}
	
</style>
</head>
<body>
	<%@ include file="/WEB-INF/views/common/header/header_sobi.jsp" %>
	<main>
		<aside>
			<div></div>
		</aside>
		<div class="main-section">
			<div class="main-top-area">
				<div><span>전체 <%= listCount %></span></div>
				<div>
				</div>
			</div>
			<% if(!salesVoList.isEmpty()){ %>
				<div class="x">
					<div class="main-area">
					<c:forEach items="${ salesVoList }" var="salesVo">
						<div class="item-area">
							<img src="/nongra${ salesVo.fileName }" alt="썸네일사진" onclick="showDetails(${salesVo.salesNo})">
							<button>담기</button>
							<div>
								<button onclick="reviewByItem('${salesVo.salesNo}');">후기조회</button>
								<button onclick="showInquiryByItem('${salesVo.salesNo}');">문의조회</button>
							</div>
							<div>${ salesVo.title }</div>
							<div>${ salesVo.price }원</div>

						</div>
					</c:forEach>
					</div>
				</div>
				<% }else{ %>
					<div class="isEmpty">
					<span>카테고리와 일치하는 등록된 상품이 없습니다</span>
					</div>
				<% } %>
		</div>
	</main>
    <script>
        categoryOneList();
        function showDetails(salesNo) {
            window.location.href = '/nongra/sales/details?salesNo=' + salesNo;
        }
        
        function categoryOneList(){
            fetch("/nongra/category/oneList")
            .then( (resp) => {return resp.json();})
            .then( (data) => {
                for(let i = 0; i < data.length; ++i){
                	const asideTag = document.querySelector('aside');
                    const ulTag = document.createElement('ul');
                    ulTag.innerHTML = data[i].category;
                    categoryTwoList(data[i].categoryNo , ulTag);
                    asideTag.appendChild(ulTag);
                }
            })
            .catch( (error) => {
                console.error("카테고리 에러발생" , error);
            })
        }

        function categoryTwoList(categoryNo , ulTag){
            fetch("/nongra/category/twoList?no="+ categoryNo)
            .then( ( resp ) => {return resp.json();})
            .then( ( data => {
                for (let i = 0; i < data.length; ++i) {
                    const liTag = document.createElement('li');
                    const aTag = document.createElement('a');
                    aTag.innerHTML = data[i].category;
                    aTag.href = "/nongra/sales/categoryList?categoryNo=" + data[i].categoryNo;
                    ulTag.appendChild(liTag);
                    liTag.appendChild(aTag);
                    }
           	 }))
        }
        
        function reviewByItem(salesNo){
        	window.location.href = "/nongra/member/showReviewByItem?saleNo=" + salesNo;
        }
        
        function showInquiryByItem(salesNo){
        	window.location.href = "/nongra/member/showInquiryByItem?saleNo=" + salesNo;
        }
        
    </script>
	
</body>
</html>

