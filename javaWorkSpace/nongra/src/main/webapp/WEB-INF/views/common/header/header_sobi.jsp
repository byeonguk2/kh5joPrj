<%@page import="com.kh.app.member.vo.MemberVo"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%
    	MemberVo loginMember= (MemberVo)session.getAttribute("loginMember");
    %>
	<%		
    
    String alertMsg = (String)session.getAttribute("alertMsg"); 
    session.removeAttribute("alertMsg");
    %>
	<!DOCTYPE html>
	<html lang="ko">
	<head>
		<meta charset="UTF-8">
		<meta name="viewport" content="width=device-width, initial-scale=1.0">
		<title>Document</title>
		<link rel="stylesheet" href="/nongra/resources/css/header/header_sobi.css">
		<script defer src="/nongra/resources/js/common/header/header_sobi.js"></script>
		<style type="text/css">
			#category-dropdown {
			    display: none;
			    position: absolute;
			    background-color: #fff; /* 원하는 배경색을 설정합니다 */
			    box-shadow: 0 8px 16px rgba(0, 0, 0, 0.1); /* 스타일링을 위한 그림자 효과를 추가합니다 */
			    z-index: 1;
			    top: 170px;
			    width: 200px;
			}
			#category-dropdown > ul li{
			    display: none;
			    position: relative;
			    background-color: #fff; /* 원하는 배경색을 설정합니다 */
			    box-shadow: 0 8px 16px rgba(0, 0, 0, 0.1); /* 스타일링을 위한 그림자 효과를 추가합니다 */
			}
			
			#category-dropdown ul {
			    color: #333; /* 텍스트 색상을 설정합니다 */
			    padding: 12px;
			    text-decoration: none;
			    box-shadow: 0 8px 16px rgba(0, 0, 0, 0.1);
			    display: block;
			}
			
			#category-dropdown a:hover {
			    background-color: #f2f2f2; /* 호버 시 배경색을 설정합니다 */
			}
		</style>
	</head>
	<body>
		<div id="wrap1">
            <header>
                <div></div>
                <div></div>
                <div class="top-menu">
                    <%if(loginMember==null){%>
                    		 <a href="/nongra/choice/join">회원가입</a>
                    	<%}else{%>
                    		<a href="/nongra/member/mypage">마이페이지</a>
                    	<%}%>
                </div>
                <div class="top-menu">
                   
                    	<%if(loginMember==null){%>
                    		 <a href="/nongra/member/login">로그인</a>
                    	<%}else{%>
                    		<a href="/nongra/member/logout">로그아웃</a>
                    	<%}%>
                   
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
                    <%if(loginMember==null){%>
                    		 <a href="/nongra/member/login">
                    		 	<img id="icon-coin" width="27px" height="27px" src="/nongra/resources/img/common/header/icon-coin.png" alt="동전">
                    		 </a>
                    	<%}else{%>
                    		<a href="/nongra/member/point">
                    		    <img id="icon-coin" width="27px" height="27px" src="/nongra/resources/img/common/header/icon-coin.png" alt="동전">
                    		
                    		</a>
                    	<%}%>
                    </a>
                </div>
                <div id="cart-icon-area">
                    <%if(loginMember==null){%>
                    		<a href="/nongra/member/login">
                        <img id="icon-cart" width="27px" height="27px" src="/nongra/resources/img/common/header/icon-shopping-cart.png" alt="카트">
                    </a>
                    <%}else{%>
                    	<a href="/nongra/cart">
                    	    <img id="icon-cart" width="27px" height="27px" src="/nongra/resources/img/common/header/icon-shopping-cart.png" alt="카트">
                    	</a>
                    <%}%>
                </div>
                <nav  style="z-index: 2;">
                    <a id="menu-icon">
                        <img id="img02" width="16px" height="18px" src="/nongra/resources/img/common/header/menu-icon.svg" alt="카테고리 아이콘">
                        <div>카테고리</div>
                    </a>
                    
                    <a href="">신상품</a>
                    <a href="">베스트</a>
                    <a href="/nongra/tip/main">구매팁</a>
                    <a href="/nongra/event/list">이벤트</a>
                    <a href="">배송안내</a>
                    
    
                </nav>
                <div id="category-dropdown">
                    <ul id="category1-dropdown">카테고리 1
                        <li> 
                            <a href="#">소분류 1-1</a>
                        </li>
                        <li>
                            <a href="#">소분류 1-2</a>
                        </li>
                        <li>
                            <a href="#">소분류 1-3</a>
                        </li>
                    </ul> 
                    <ul id="category2-dropdown">카테고리 2
                        <li>
                            <a href="#">소분류 2-1</a>
                        </li>
                        <li>
                            <a href="#">소분류 2-2</a>
                        </li>
                    </ul> 
                    <ul id="category3-dropdown">카테고리 3
                        <li>
                            <a href="#">소분류 3-1</a>
                        </li>
                        <li>
                            <a href="#">소분류 3-2</a>
                        </li>
                    </ul>
                </div>
                
            </header>
        </div>
	</body>
	</html>
	
	<script type="text/javascript">
		<%if(alertMsg != null) {%>
			alert("<%= alertMsg %>");
		<% } %>
		
        document.addEventListener('DOMContentLoaded', function () {
            var menuIcon = document.querySelector('#menu-icon');
            var categoryDropdown = document.querySelector('#category-dropdown');

            menuIcon.addEventListener('click', function () {
                if (categoryDropdown.style.display === 'block') {
                    categoryDropdown.style.display = 'none';
                } else {
                    categoryDropdown.style.display = 'block';
                }
            });

            document.querySelector('#category1-dropdown').addEventListener('click', function () {
                toggleSubcategories('#category1-dropdown');
            });

            document.querySelector('#category2-dropdown').addEventListener('click', function () {
                toggleSubcategories('#category2-dropdown');
            });

            document.querySelector('#category3-dropdown').addEventListener('click', function () {
                toggleSubcategories('#category3-dropdown');
            });
        });

        function toggleSubcategories(categoryId) {
            var selectedCategory = document.querySelectorAll(categoryId + ' li');

            selectedCategory.forEach(function (item) {
                if (item.style.display === 'none' || item.style.display === '') {
                    item.style.display = 'block';
                } else {
                    item.style.display = 'none';
                }
            });
        }

		
	</script>
