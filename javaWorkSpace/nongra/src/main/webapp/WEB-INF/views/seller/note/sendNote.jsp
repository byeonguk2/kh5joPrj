<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style>
	main{
		display: grid;
		grid-template-columns: 231px 8fr;
	}
	
	.content-area{
		display: grid;
		grid-template-rows: 100px 100px 620px 100px;
		grid-template-columns: 2fr 1fr 5fr 1fr;
		border: 1px solid gray;
		margin: 10px;
		border-radius: 20px;
		width: 1251px;
		box-sizing: border-box;		
	}
	.send{
		grid-column: span 4;
		display: grid;
		grid-template-columns: 1fr 2fr 2fr;
	}
	.content-area h1{
		margin-left: 50px;
		font-size: 30px;
		display: flex;
		align-items: center;
		grid-column: span 4;
	}

	.send-check-area{
		display: flex;
		align-items: end;
		justify-content: end;
	}
	.send-search-area{
		display: flex;
		align-items: end;
		justify-content: center;
	}
	
</style>
</head>
<body>
	<div class = "wrap">
		<%@ include file="/WEB-INF/views/common/header/header_seller.jsp" %>
		<main>
			<%@ include file="/WEB-INF/views/common/aside/aside_seller.jsp" %>
			<div class="content-area">
				<h1>보낸쪽지</h1>
				<div class="send">
					<div class="send-check-area">
						<select>
							<option value="">123123</option>
						</select>
						<span>123</span>
					</div>
					<div></div>
					<div class="send-search-area">
						<select>
							<option value="">12312321</option>
						</select>
						<select>
							<option value="">23423432</option>
						</select>
						<div>
							<input type="search" placeholder="검색">
	
						</div>
					</div>
				</div>

			</div>
		</main>
	</div>
</body>
</html>