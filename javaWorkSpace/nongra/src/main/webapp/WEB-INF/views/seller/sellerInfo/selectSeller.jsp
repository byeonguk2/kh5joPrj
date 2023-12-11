<%@page import="com.kh.app.seller.controller.SellerLoginController"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
	
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
	grid-template-rows: 60px  45px 400px  790px;
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
	width: 800px;
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

.fix_profile{
	margin: 40px 40px 40px 40px;
	border: 1px solid #e3e7ee;
	background-color: #ffffff;
	display: grid;
	grid-template-columns: 350px 500px;
    margin-right: 700px;
}
.modify_profile{
	width: 250px;
	height: 250px;
	position: relative;
	border-radius: 50%;
	background-size: cover;
	cursor: pointer;
}
.profile_guide{
	display: grid;
	grid-template-rows: 1fr 1fr 1fr;
}
.my_profile{
	font-size: 24px;
	font-weight: bold;
	color: #754327;
	line-height: 106px;
}
.filebox {
    cursor: pointer;
	display: flex;
    justify-content: center;
    align-items: center;
	
}
.filebox input[type="file"] {
    position: absolute;
    width: 0;
    height: 0;
    padding: 0;
    overflow: hidden;
    border: 0;
}
.upload-btn{
	display: inline-block;
    width: 120px;
    height: 44px;
    margin: 0px 0px 0px 8px;
    background-color: white;
    border: 1px solid #754327;
    color: #754327;
    border-radius: 5px;
    cursor: pointer;
    text-align: center;
    line-height: 46px;
   	font-size: 14px;
   	cursor: pointer;
}
.upload-area{
	display: flex;
	color: #767a83;
	font-size: 14px;
	line-height: 40px;
	gap: 20px;
}
</style>
</head>
<body>
	<div class = "wrap">
		<%@ include file="/WEB-INF/views/common/header/header_seller.jsp"  %>
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

				<form onsubmit="return checkProfile()" action="/nongra/seller/profile" method="post" enctype="multipart/form-data">
				<div class="fix_profile">
						<div class="filebox">
							<label for="file2">
							<div class="fix_profile__box">
								<img src="<%= loginSeller.getProfile() %>" alt="프로필" class="modify_profile">
								<input type="file" name="pofile" id="file2">
							</div>
							</label> 
						</div>
					<div class="profile_guide">
						<div class="my_profile">
							나의 프로필 사진
						</div>
						<div class="upload-area" style="display: flex;">
							<button class="upload-btn">프로필 업로드</button>
							<p>프로필 사진 클릭해 사진을 첨부 후 업로드 해주세요.</p>
						</div>
						<div>
							<a class="upload-btn" href="/nongra/seller/profile">기본 이미지로 변경</a>
						</div>
					</div>
				</div>
			</form>

				<div class="content">
					<div>
						<label id="title">판매자 개인정보</label>
					</div>
					<div>
						<label>아이디</label>
						<input type="text" name="id" value="<%= loginSeller.getId() %>" readonly/>
					</div>
					<div>
						<label>패스워드</label>
						<input type="password" name="password" value="<%= loginSeller.getPassword() %>" readonly/>
					</div>
					<div>
						<label>닉네임</label>
						<input type="text" name="nick" value="<%= loginSeller.getNick() %>" readonly/>
					</div>
					<div>
						<label>이름</label>
						<input type="text" name="name" value="<%= loginSeller.getName() %>" readonly/>
					</div>
					<div>
						<label>전화번호</label>
						<input type="text" name="phone" value="<%= loginSeller.getPhone() %>" readonly/>
					</div>
					<div>
						<label>이메일</label>
						<input type="text" name="email" value="<%= loginSeller.getEmail() %>" readonly/>
					</div>
					<div>
						<label>가입일시</label>
						<input type="text" name="joinDate" value="<%= loginSeller.getJoinDate() %>" readonly/>
					</div>
					<div id="modify-btn">
						<button onclick="location.href='/nongra/seller/modify'">내 정보 수정하기</button>
					</div>
				</div>
			</div>
		</main>
	</div>
	<script>
		function checkProfile(){
			const profile = document.querySelector("input[type=file]");
			if(!profile.value){
				alert("프로필 사진을 등록후 업로드 해주세요.");
				return false;
			}
		}
	</script>
</body>
</html>