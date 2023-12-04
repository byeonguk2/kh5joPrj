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
            <label>판매자 님</label>
            <div class="filebox">
				<a href="">
					<img class="profile" alt="프로필" src="https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcQAlKnRIw235I54BxEXhsHilefGS37qaSgl_dnUlU8-1A&s">
				</a>
			</div>
        </div>
    </header>
    <script type="text/javascript">
		<%if(alertMsg != null && !loginSeller.getPermitYn().equals("N")) {%>
		
			alert("<%= alertMsg %>");
			
		<% }else { %>
			
			<%if(loginSeller.getPermitYn().equals("N")){
				session.removeAttribute("loginSeller");
				session.removeAttribute("alertMsg");
			%>
				alert('사업자 권한요청이 수락되면 로그인 가능합니다.');
				location.href="/nongra/seller/login";
			<% } %>
			
		 <%} %>
	</script>
</body>
</html>