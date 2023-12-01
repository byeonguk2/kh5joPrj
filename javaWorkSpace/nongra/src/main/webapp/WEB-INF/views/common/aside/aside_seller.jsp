<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" href="/nongra/resources/css/aside/aside_seller.css">
<script defer src="/nongra/resources/js/common/aside/aside_seller.js" type="text/javascript"></script>
</head>
<body>
	<aside>
        <div class="aside-item sitem1">
            <div class="side-icon side-user" id="icon-user" style="border-top: none;"></div>
            <label>판매자 정보</label>
            <div class="down_icon"></div>
        </div>      
        <div class="menu"><a href="">내 정보조회</a></div>
        <div class="menu"><a href="">회원탈퇴</a></div>
        <div class="aside-item sitem2">
            <div class="side-icon" id="icon-chart"></div>
            <label>통계조회</label>
            <div class="down_icon"></div>
        </div>    
        <div class="aside-item sitem3">
            <div class="side-icon" id="icon-gift"></div>
            <label>상품관리</label>
            <div class="down_icon"></div>
        </div>    
        <div class="menu"><a href="">상품관리</a></div>
        <div class="menu"><a href="/nongra/seller/register">상품등록</a></div>
        <div class="aside-item sitem4">
            <div class="side-icon" id="icon-check"></div>
            <label>상품문의관리</label>
            <div class="down_icon" onclick="fun01"></div>
        </div>    
        <div class="aside-item sitem5">
            <div class="side-icon" id="icon-smile"></div>
            <label>리뷰 관리</label>
            <div class="down_icon"></div>
        </div>   
        <div class="aside-item sitem6">
            <div class="side-icon" id="icon-lotate"></div>
            <label>주문 조회</label>
            <div class="down_icon"></div>
        </div>    
        <div class="aside-item sitem7">
            <div class="side-icon" id="icon-file"></div>
            <label>환불조회</label>
            <div class="down_icon"></div>
        </div>    
        <div class="aside-item sitem8">
            <div class="side-icon" id="icon-truck"></div>
            <label>배송관리</label>
            <div class="down_icon"></div>
        </div>    
        <div class="aside-item sitem9">
            <div class="side-icon" id="icon-mail"></div>
            <label>쪽지목록</label>
            <div class="down_icon"></div>
        </div>   
        <div class="menu"><a href="/nongra/seller/note/send">보낸쪽지</a></div>
        <div class="menu"><a href="/nongra/seller/note/recive">받은쪽지</a></div>
        <div class="aside-item sitem10">
            <div class="side-icon" id="icon-book"></div>
            <label>공지사항</label>
            <div class="down_icon"></div>
        </div>    
        <div class="aside-item sitem11">
            <div class="side-icon" id="icon-phone"></div>
            <label>고객센터</label>
            <div class="side-icon2"></div>
        </div>     
        <div class="aside-item aside-last-item">
            <div>
                <div><strong>고객센터 문의</strong></div>
                <div><strong>1566-1234</strong></div>
            </div>
        </div>
    </aside>
</body>
</html>