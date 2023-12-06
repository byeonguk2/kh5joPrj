<%@page import="com.kh.app.member.vo.MemberVo"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%
    	MemberVo loginMember= (MemberVo)session.getAttribute("loginMember");
    %>
	<!DOCTYPE html>
	<%		
		MemberVo loginSeller = (MemberVo)session.getAttribute("loginMember");
    	String alertMsg = (String)session.getAttribute("alertMsg"); 
    	session.removeAttribute("alertMsg");
    %>
	<html lang="ko">
	<head>
		<meta charset="UTF-8">
		<meta name="viewport" content="width=device-width, initial-scale=1.0">
		<title>Document</title>
		<link rel="stylesheet" href="/nongra/resources/css/header/header_sobi_memberModify.css">
		<script defer src="/nongra/resources/js/common/header_sobi.js"></script>
	</head>
	<body>
		<div id="wrap1">
            <header>
                <div></div>
                <div></div>
                <div class="top-menu">
                    <a href="/nongra/member/join">회원가입</a>
                </div>
                <div class="top-menu">
                    <a href="/nongra/member/login">로그인</a>
                </div>
                <div class="top-menu">
                    <a href="/nongra/contact/faq">고객센터</a>
                </div>
                <div></div>
                <a class="logo" href="/nongra/home">
                    <img width="120px" height="100px" src="/nongra/resources/img/common/logo.png" alt="로고 이미지">
                </a>
                <div id="serach-area">
                    <div id="serach1">
                        <input id="serach" type="text" placeholder=" 검색어를 입력해주세요">
                        <button id="serach-btn">
                            <img id="img01" width="27px" height="27px" src="https://s3.ap-northeast-2.amazonaws.com/cdn.wecode.co.kr/icon/search.png" alt="돋보기">
                        </button>
                    </div>
                </div>
                <div></div>
                <div id="coin-icon-area">
                    <a href="/nongra/member/point">
                        <img id="icon-coin" width="27px" height="27px" src="/nongra/resources/img/common/header/icon-coin.png" alt="동전">
                    </a>
                </div>
                <div id="cart-icon-area">
                    <a href="/nongra/cart">
                        <img id="icon-cart" width="27px" height="27px" src="/nongra/resources/img/common/header/icon-shopping-cart.png" alt="카트">
                    </a>
                </div>
                <nav  style="z-index: 2;">
                    <a href="">
                        <img id="img02" width="16px" height="18px" src="/nongra/resources/img/common/header/menu-icon.svg" alt="카테고리 아이콘">
                        <div>카테고리</div>
                    </a>
                    <a href="">신상품</a>
                    <a href="">베스트</a>
                    <a href="/nongra/tip/main">구매팁</a>
                    <a href="/nongra/event/main">이벤트</a>
                    <a href="">배송안내</a>
                    
    
                </nav>
    
    
            </header>
            </div>
	</body>
	</html>
	
	<script type="text/javascript">
		<%if(alertMsg != null) {%>
			alert("<%= alertMsg %>");
		<% } %>
	</script>