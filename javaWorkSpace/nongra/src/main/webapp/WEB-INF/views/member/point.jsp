<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet"href="/nongra/resources/css/member/member_point.css">
</head>
<body>
	<div id="wrap">
	<%@ include file="/WEB-INF/views/common/header/header_sobi.jsp"%>
	 <div id="a">
	<%@ include file="/WEB-INF/views/common/aside/aside_sobi_main.jsp"%>
	<form action="https://www.naver.com/">
        <main>
            <div id="point">
		
                <div id="img_coin">
                    <img src="https://cdn-icons-png.flaticon.com/512/7617/7617037.png" alt="n코인">
                </div>
                <div id="img_coin2">
                    <span id="balance">35,000P</span>
                    <span id="balance2">ooo님 의 보유 포인트</span>
                </div>
                <div id="box">
                    <div id="img_coin3">
                        <span id="balance3">충전 포인트</span>
                        <span id="balance4">+ 1,0000</span>
                    </div>
                    <div id="img_coin4">
                        <span id="balance5">사용 포인트</span>
                        <span id="balance6">- 5,000</span>

                    </div>
                    
                    <button style='cursor:pointer;' type="submit" class="btn">충전</button>
                </div>
            </div>
            
            <!-- <h1>월별 사용 현황</h1> -->
        </main>
    </form>
    </div>
	
    </div>
    </div>
</body>
</html>