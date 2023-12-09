<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
	<link rel="stylesheet" href="/nongra/resources/css/aside/sidebar_sobi_main.css">
	<script defer src="/nongra/resources/js/common/aside/aside_sobi_main.js"></script>
</head>
<body>
	<aside>
        <div class="aside-item">
            <div class="side-icon side-user" id="icon-user" style="border-top: none;"></div>
            <a href="/nongra/member/modify">회원정보 수정</a>
            <div class="side-icon2"></div>
        </div>    

        <div class="aside-item">
            <div class="side-icon" id="icon-truck"></div>
             <a href="/nongra/mypage/address">배송지 관리</a>
            <div class="side-icon2"></div>
        </div>    

        <div class="aside-item">
            <div class="side-icon" id="icon-smile"></div>
            <a href="/nongra/mypage/address">리뷰 관리</a>
            <div class="side-icon2"></div>
        </div>    

        <div class="aside-item">
            <div class="side-icon" id="icon-check"></div>
            <a href="/nongra/my/order/inquiry">상품문의</a>
            <div  class="side-icon2" onclick="fun01"></div>
        </div>    

        <div class="aside-item sitem1">
            <div class="side-icon" id="icon-mail"></div>
            <label>쪽지 목록</label>
            <div style='cursor: pointer;' class="side-icon2"></div>
        </div>   
        <div class="menu"><a href="/nongra/seller/note/send">보낸쪽지</a></div>
        <div class="menu"><a href="/nongra/seller/note/recive">받은쪽지</a></div>

        <div class="aside-item">
            <div class="side-icon side-user" id="icon-user" style="border-top: none;"></div>
            <a href="/nongra/member/delete" >회원탈퇴</a>
            <div class="side-icon2"></div>
        </div>       

        <div class="aside-item aside-last-item">
            <div>
                <div><strong>고객센터 문의</strong></div>
                <div><strong>1577-4989</strong></div>
            </div>
        </div>
    </aside>
	
</body>
</html>