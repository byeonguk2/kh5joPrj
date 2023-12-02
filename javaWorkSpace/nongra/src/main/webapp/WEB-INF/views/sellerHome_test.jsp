<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/css/bootstrap.min.css" rel="stylesheet">
<style type="text/css">
.wrap{
	height: 100vh;
}
main{
	    display: grid;
	    grid-template-columns: 230px 8fr;
	    background-color: rgb(238, 238, 238);
}
.content-area{
	background-color: rgba(0,0,0,0);
	display: grid;
	grid-template-rows: 60px  45px  800px;
}
.content{
	margin: 40px;
	border: 3px solid rgb(222, 220, 220);
	height: 840px;
	background-color: white;
	display: grid;
	grid-template-rows: 80px 50px 2fr 1fr;
}
.h2{
	background-color: white;
	box-shadow: 3px 0px 0px 1px rgba(0, 0, 0, 0.07)
}
</style>
</head>
<body>
	<div class = "wrap">
		<%@ include file="/WEB-INF/views/common/header/header_seller.jsp" %>
		<main>
			<%@ include file="/WEB-INF/views/common/aside/aside_seller.jsp" %>
			<div class = "content-area">
				<div class="h2">
					<h3>판매자 정보</h3>
				</div>
				<div></div>
				<div class="content">
					<div></div>
					<div></div>
					<div></div>
				</div>
			</div>
		</main>
	</div>
</body>
</html>