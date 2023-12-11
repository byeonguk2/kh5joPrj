<%@page import="com.kh.app.seller.vo.SellerVo"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>

	<%		
		SellerVo loginSeller = (SellerVo)session.getAttribute("loginSeller");
    	String alertMsg = (String)session.getAttribute("alertMsg"); 
    	session.removeAttribute("alertMsg");
    %>

<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
<link rel="stylesheet" href="/nongra/resources/css/header/header_seller.css">
</head>
<body>
	<header>
        <div class="header-left-area">
            <div class="hamburger"></div>
            <a href="/nongra/seller/home">
            	<div class="header-logo"></div>
            </a>
        </div>
        
        <div class="header-right-area">
            <label>온라인 문의</label>
            <label>|</label>
            <label>도움말</label>
            <label>|</label>
            <i class="fa fa-bell" style="font-size:24px; color:rgb(52, 65, 252)"></i>
            <label><%= loginSeller.getName() %> 님</label>
            <div class="filebox">
					<img onclick="windowOfChoiceAppears()" class="profile" alt="프로필" src="<%= loginSeller.getProfile() %>">
			</div>
        </div>
    </header>
    <script type="text/javascript">

		<%if(alertMsg != null) {%>
			alert("<%= alertMsg %>");
		<% } %>
	</script>
</body>
</html>