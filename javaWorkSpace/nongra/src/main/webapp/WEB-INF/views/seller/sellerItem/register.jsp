<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script src="https://code.jquery.com/jquery-3.6.4.min.js"></script> <!-- jQuery 포함 -->
<script src="/nongra/resources/summernote/lang/summernote-ko-KR.js"></script>
<script src="/nongra/resources/summernote/summernote-lite.js"></script>
<link rel="stylesheet" href="/nongra/resources/summernote/summernote-lite.css">

<style>

	main{
		display: grid;
		grid-template-columns: 231px 1271px;
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
		margin-left: 50px;
		font-size: 30px;
		display: flex;
		align-items: center;
		grid-column: span 4;
	}
	.input-area *{
		display: block;
		margin: 20px;
	}
	.input-area{
		grid-column: span 2;
	}
	.container{
		grid-column: span 2;
	}

	.text-area pre{ 
		margin: 25px;
	}

	.text-area >pre:nth-child(5){ 
		margin-bottom: 20px;
	}

	#option-text {
		margin-left: 25px;
	}

	.submit{
		grid-column: span 2;
		grid-column-start: 3;
		grid-column-end: 4;
		display: flex;
		justify-content: end;
	}

	.submit input[type=submit]{
		width: 120px;
		height: 44px;
		background-color: white;
		border: 1px solid #754327;
    	color: #754327;
		border-radius: 5px;
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
				<div></div>
				<div class="text-area">
					<pre>판매글 제목</pre>
					<pre>상품명</pre>
					<pre>재고</pre>
					<pre>원산지</pre>
					<pre>상품 카테고리</pre>
					<label id="option-text" for="option">물품 옵션 설정
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
						<input type="file">
					
					</div>
					<div></div>
					<div class="container">
						<textarea class="summernote" name="editordata"></textarea>   
						
					</div>


					<div></div>
					<div class="submit">
						<input type="submit" value="제출">
					</div>
				</form>
		</main>
	</div>
<script>
	$('.summernote').summernote({
		 height: 300,                 // 에디터 높이
		  minHeight: null,             // 최소 높이
		  maxHeight: null,             // 최대 높이
		  focus: true,                  // 에디터 로딩후 포커스를 맞출지 여부
		  lang: "ko-KR",					// 한글 설정
		  placeholder: '최대3000자까지 쓸 수 있습니다'	,//placeholder 설정
		  toolbar: [
				    // [groupName, [list of button]]
				    ['fontname', ['fontname']],
				    ['fontsize', ['fontsize']],
				    ['color', ['color']],
				    ['style', ['bold', 'italic', 'underline','strikethrough', 'clear']],
				    ['para', ['ul', 'ol', 'paragraph']],
				    ['height', ['height']]
					  ],
				fontNames: ['Arial', 'Arial Black', 'Comic Sans MS', 'Courier New','맑은 고딕','궁서','굴림체','굴림','돋움체','바탕체'],
				fontSizes: ['8','9','10','11','12','14','16','18','20','22','24','28','30','36','50','72']
	          
		});
	</script>
</body>
</html>
