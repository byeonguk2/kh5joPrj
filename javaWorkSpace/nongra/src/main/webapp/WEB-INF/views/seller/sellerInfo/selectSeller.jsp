<%@page import="com.kh.app.seller.controller.SellerLoginController"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
	
	<%
		SellerVo sellerLogin = (SellerVo)request.getAttribute("sellerLogin");
	%>
	
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/css/bootstrap.min.css" rel="stylesheet">
<style type="text/css">

/* 전체 영역 */
.wrap{
	height: 100vh;
}

/* 메인 영역 */
main{
		display: flex;
	    background-color: #edf0f5;
}

/* 내용을 감싸는 영역 */
.content-area{
	background-color: rgba(0,0,0,0);
	display: grid;
	grid-template-rows: 60px  45px  790px;
	width: 100%;
	padding-top: 20px;
}

/* 내용 상단 영역 */
.content-top-area{
	background-color: white;
	margin-left: 40px;
	border: 1px solid #e3e7ee;
	margin-right: 40px;
}

/* 내용 상단 판매자 정보 글씨 */
.content-top-area > h2 {
	padding-left: 40px;
    line-height: 52px;
    font-size: 20px;
    text-align: left;
}

/* 내용 상단 버튼영역 */
.content-top-a-area{
	padding-left: 40px;
	display: flex;
	align-items: center;
	height: 100%;
	gap: 15px;
	font-size: 16px;
}
.content-top-a-area > :nth-child(1){
	color: #754327;
}
/* 본 내용 영역 */
.content{
	margin: 40px 40px 40px 40px;
	border: 1px solid #e3e7ee;
	background-color: #ffffff;
	display: grid;
	grid-template-rows: 1.5fr 1fr 1fr 1fr 1fr 1fr 1fr 1fr 1fr;
}

.content > div {
	border-bottom: 0.8px solid #e3e7ee;
	margin: 0px 40px 0px 40px;
	display: flex;
	justify-content: left;
	align-items: center;
}

.content > div > label {
	color: #767a83;
	width: 250px;
	line-height: 76px;
}
.content > div > input {
	border: none;
	padding: 25.25px 0px 25.25px 0px;
}

#modify-btn{
	justify-content: right;
}

#modify-btn > button{
	height: 40px;
	width: 150px;
	border-radius: 5px;
	border: 1px solid #754327;
	background-color: #754327;
	color: white;
}

#title{
	font-size: 20px; 
	color: #754327;
	line-height: 109px;
}
/* outline 테두리 없애기 */
input:focus {outline: none;} 
</style>
</head>
<body>
	<div class = "wrap">
		<%@ include file="/WEB-INF/views/common/header/header_seller.jsp" %>
		<main>
			<%@ include file="/WEB-INF/views/common/aside/aside_seller.jsp" %>
			<div class = "content-area">
				<div class="content-top-area">
					<h2>판매자 정보</h3>
				</div>
				<div class="content-top-area">
					<div class="content-top-a-area">
						<a href="/nongra/seller/select">판매자 개인정보</a>
						<span>|</span>
						<a href="/nongra/seller/businessInfo">사업자 정보</a>
					</div>
				</div>
				<div class="content">
					<div>
						<label id="title">판매자 개인정보</label>
					</div>
					<div>
						<label>아이디</label>
						<input type="text" name="id" value="<% sellerLogin.getId(); %>" readonly/>
					</div>
					<div>
						<label>패스워드</label>
						<input type="password" name="password" value="<% sellerLogin.getPassword(); %>" readonly/>
					</div>
					<div>
						<label>닉네임</label>
						<input type="text" name="nick" value="<% sellerLogin.getNick(); %>" readonly/>
					</div>
					<div>
						<label>이름</label>
						<input type="text" name="name" value="<% sellerLogin.getName(); %>" readonly/>
					</div>
					<div>
						<label>전화번호</label>
						<input type="text" name="phone" value="<% sellerLogin.getPhone(); %>" readonly/>
					</div>
					<div>
						<label>이메일</label>
						<input type="text" name="email" value="<% sellerLogin.getEmail(); %>" readonly/>
					</div>
					<div>
						<label>가입일시</label>
						<input type="text" name="joinDate" value="<% sellerLogin.getJoinDate(); %>" readonly/>
					</div>
					<div id="modify-btn">
						<button onclick="location.href='/nongra/seller/modify'">내 정보 수정하기</button>
					</div>
				</div>
			</div>
		</main>
	</div>
</body>
</html>