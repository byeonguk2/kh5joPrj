<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet"
	href="/nongra/resources/css/common/memberOrSeller.css">
</head>
<body>
	<div id="join_wrap">
        <div id="join_container">
            
            <div class="join_header">
            <div id="h1">회원가입</div>
            <div id="a">1.가입</div>
            <div id="b">2.약관동의</div>
            <div id="c">3.정보입력</div>
            <div id="d">4.가입완료</div>
            </div>
            
            <div id="main">
                <div class="buyer"><h2>개인 구매회원</h2></div>
                <div id=content_box>
                    <div id="content" >
                        <div id="welcome">
                            <span id="c1">농라에 오신 것을 환영합니다.</span>
                            <br>
                            <span id="c2">지금 회원 가입하신 후 농라의 다양한 서비스를 만나보세요.</span>
                        </div>
                        <div id="j1">
                            <button type="button" id="join1"  style='cursor:pointer;' onclick="location.href='/nongra/seller/join'">가입하기</button> 
                        </div>
                        <div id="img1"> </div>

                        
                    </div>
                </div>
            </div>
            <div id="box">
                <p class="seller1">
                    <strong class="seller2">농라</strong>
                    "와 함께"
                    <br>
                    "나만의 비즈니스를 시작하세요!"
                </p>
                <button type="button" class="seller_bt" style='cursor:pointer;'onclick="location.href='/nongra/seller/join'">판매회원 가입하기 </button>
            </div>
        </div> 
    </div>
    
</body>
</html>