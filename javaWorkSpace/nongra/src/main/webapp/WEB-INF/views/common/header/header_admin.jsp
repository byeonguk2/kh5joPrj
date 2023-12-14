<%@page import="com.kh.app.admin.vo.AdminVo"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
    <% 
    	// 로그인 성공시 세션값 유지
    	AdminVo loginAdmin = (AdminVo)session.getAttribute("loginAdmin"); 
    		
    	// 세션에 담긴 메세지 세션으로 받기 
	    String alertMsg = (String)session.getAttribute("alertMsg"); 
		session.removeAttribute("alertMsg");
    %>
    
<head>

	<!-- 관리자 페이지 헤더 css -->
	<link rel="stylesheet" href="/nongra/resources/css/header/header_admin.css">
	
</head>

<header>
	
	<!-- 관리자 페이지 헤더 -->
	<div class="header-area">
    	<div class="header-logo">
        	<img src="/nongra/resources/img/common/logo.png" alt="농라로고">
            <strong>관리자 페이지</strong>
        </div>
        <div class="user-img">
			<img alt="유저사진" src="/nongra/resources/img/common/header/admin/user.svg" class="header-userImg">
        </div>
    </div>
    
    <!-- 관리자 페이지 네비바 -->
    <div class="nav-area">
		<nav class="nav-main" id="nav-main">
	        <a href="/nongra/admin/findAllMembers" class="chagePage pix">회원관리</a>
	        <a href="" class="chagePage">상품관리</a>
	        <a href="/nongra/admin/manageReview" class="chagePage">리뷰관리</a>
	        <a href="/nongra/admin/notice/manage " class="chagePage">게시판관리</a>
	        <a href="" class="chagePage">주문관리</a>
	        <a href="" class="chagePage pix">카테고리 관리</a>
		</nav>
    </div>
</header>
    	
<!-- 헤더 js -->
<script type="text/javascript" src="/nongra/resources/js/common/header/header_admin.js"></script>
    	
<script>

	// 메세지 띄우기
	<%if(alertMsg != null) {%>
		alert("<%= alertMsg %>");
	<% } %>
	
</script>