<%@page import="com.kh.app.point.vo.PointVo"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
	<%
		PointVo pv=(PointVo)request.getAttribute("pv");
	%>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet"href="/nongra/resources/css/member/member_point.css">
</head>
<body>
	<div id="wrap">
	<%@ include file="/WEB-INF/views/common/header/header_sobi_memberModify.jsp"%>
	 <div id="a">
	<%@ include file="/WEB-INF/views/common/aside/aside_sobi_main.jsp"%>
	<form action="/nongra/member/point" method="post">
        <main>
            <div id="point">
		
                <div id="img_coin">
                    <img src="https://cdn-icons-png.flaticon.com/512/7617/7617037.png" alt="n코인">
                </div>
                <div id="img_coin2">
                    <span id="balance"><%=loginMember.getPoint()%></span>
                    <span id="balance2"><%=loginMember.getMemberNick() %>님 의 보유 포인트</span>
                </div>
                <div id="box">
                    <div id="img_coin3">
                        <span id="balance3">충전 포인트</span>
                        <span id="balance4" name="chargePoint"><%=pv.getChargePoint() %></span>
                    </div>
                    <div id="img_coin4">
                        <span id="balance5">사용 포인트</span>
                        <span id="balance6"name="usePoint"><%=-pv.getUsePoint() %></span>

                    </div>
                    
                    <button style='cursor:pointer;' type="button" class="btn" onclick="a01();">충전</button>
                    <!-- 여기에 display none -->
                    <div class="modal modal-none" style="z-index: 3;">
                        <div class="dialog">
                            <h3> 농라페이 충전</h3>
                            <br>
                            <div id="box2">
                            <h4>포인트 충전</h4>
                            <h5>원하시는 상품을 선택하세요</h5>

                            <input type="radio" id="cb01" name="point" value="5000"><label for="cb01">5,000p</label><br>
                            <input type="radio" id="cb02" name="point" value="10000"><label for="cb02">10,000p</label><br>
                            <input type="radio" id="cb03" name="point" value="50000"><label for="cb03">50,000p</label><br>
                            <input type="radio" id="cb04" name="point" value="100000"><label for="cb04">100,000p</label><br>
                            <button style="cursor: pointer;"  id="modal-close" onclick="a02();">충전</button>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
            
            <!-- <h1>월별 사용 현황</h1> -->
        </main>
    </form>
    </div>
	
    </div>
    </div>
    <script>
        //디브선택
        const modal=document.querySelector(".modal");

        //모달창 열기버튼
        const open=document.querySelector(".btn");

        //모달창 닫기버튼
        const close=document.querySelector("#modal-close")
        
        //모달창 열기
        function a01(){
            modal.classList.toggle("modal-none");
        }

        //모달창 닫기
        function a02(){
            modal.classList.toggle("modal-none");
        }
    </script>
</body>
</html>