<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script src="/resources/css/"></script>
<script src="/새 폴더/lang/summernote-ko-KR.min.js"></script>
<link rel="stylesheet" href="/새 폴더/summernote-lite.css">

<style>

	main{
		display: grid;
		grid-template-columns: 231px 459px;
	}

	.content-area{
		display: grid;
		grid-template-rows: 100px 300px 420px 100px;
		grid-template-columns: 1fr 1fr 4fr 1fr;
		border: 1px solid gray;
		margin: 10px;
		border-radius: 20px;
		width: 1251px;
		box-sizing: border-box;		
	}

	.content-area h1{
		font-size: 30px;
		display: flex;
		align-items: center;
		grid-column: span 4;
	}
	.input-area *{
		display: block;
		margin: 19px;
	}
	.input-area{
		grid-column: span 2;
	}
	.container{
		grid-column: span 2;
	}

	.text-area pre{ 
		margin: 22px;

	}

	input[type=submit]{
		grid-column: span 2;
		grid-column-start: 3;
		grid-column-end: 5;
	}

	.input-area > select{
		display: inline;
		margin: 0px;
		margin-left: 20px;
	}

	.input-area > select:nth-of-type(2){
		margin-left:10px;
	}

</style>



</head>
<body>
	<div class = "wrap">
		<%@ include file="/WEB-INF/views/common/header/header_seller.jsp" %>
		<main>
			<%@ include file="/WEB-INF/views/common/aside/aside_seller.jsp" %>
			<form class = "content-area">
				<h1><span>상품등록</span></h1>
				<div>1</div>
				<div class="text-area">
					<pre>판매글 제목</pre>
					<pre>상품명</pre>
					<pre>재고</pre>
					<pre>원산지</pre>
					<pre>상품 카테고리</pre>
					<label for="option">물품 옵션 설정
						<input type="checkbox" name="option" id="option">
					</label>
				</div>
					<div class="input-area">
						<input type="text">
						<input type="text">
						<input type="text">
						<input type="text">
						<select name="">
							<option value="아무거나">아무거나</option>
						</select>
						<select name="">
							<option value="아무거나">아무거나</option>
						</select>
						<input type="text">
					
					</div>
					<div>2</div>
					<div class="container">
						<textarea id="summernote" name="editordata"></textarea>
					</div>
					<script>
						$(document).ready(function() {
							//여기 아래 부분
							$('#summernote').summernote({
								  height: 300,                 // 에디터 높이
								  minHeight: null,             // 최소 높이
								  maxHeight: null,             // 최대 높이
								  focus: true,                  // 에디터 로딩후 포커스를 맞출지 여부
								  lang: "ko-KR",					// 한글 설정
								  placeholder: '최대 2048자까지 쓸 수 있습니다'	//placeholder 설정
								  
							});
						});
						</script>

					<div>3</div>
					<input type="submit" value="제출">
				</form>
		</main>
	</div>
</body>
</html>