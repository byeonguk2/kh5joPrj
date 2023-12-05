<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>베송 요청사항</title>
<link rel="stylesheet" href="/resources/css/purchase/receiverDetails.css">
</head>
<body>
    <main>
        <div class="title-area">
            <div class="title">배송 요청사항</div>
            <div>
                <button onclick="checked()" class="button"><img src="/nongra/resources/img/purchase/icon-check.png" alt="대충 체크표시ㅋ" class="img"></button>
                <span>주문자 정보와 동일</span>
            </div>
        </div>
        <div class="content">
            <div class="recipient">
                <div>받으실 분</div>
                <div>
                    <input type="text">
                </div>
            </div>
            <div class="phone">
                <div>휴대폰</div>
                <div>
                    <input type="text">
                </div>
            </div>
            <div>
                <select name="where" id="where">
                    <option value="boor">문 앞</option>
                    <option value="boor">경비실</option>
                    <option value="boor">기타 장소</option>
                </select>
            </div>
        </div>
        <div class="btn-area">
            <button class="cancel-btn">취소</button>
            <button class="save-btn">저장</button>
        </div>
    </main>
</body>
</html>
<script type="text/javascript"><%@include file="/resources/js/purchase/receiverDetails.js"%></script>