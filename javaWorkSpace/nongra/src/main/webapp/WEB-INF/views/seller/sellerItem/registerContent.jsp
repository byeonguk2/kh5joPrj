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
		grid-template-rows: 100px 300px 420px 100px;
		grid-template-columns: 1fr 1fr 4fr 1fr;
		border: 1px solid gray;
		margin: 10px;
		border-radius: 20px;
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
		margin-top: 15px;
	}
	.category-area{
		display: flex;
	}
	.category-area *{
		margin : 0px;
	}
	.input-area{
		grid-column: span 2;
	}
	.container{
		grid-column: span 2;
	}

	.text-area div{ 
		margin: 25px;
	}

	.text-area >div:nth-child(5){ 
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
	.submit button{
		width: 120px;
		height: 44px;
		background-color: white;
		border: 1px solid #754327;
    	color: #754327;
		border-radius: 5px;
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
			<form class = "content-area" action="/nongra/seller/registerContent" method="post" enctype="multipart/form-data">
				<h1><span>상품등록</span></h1>
				<div></div>
				<div class="text-area">
					<div>판매글 내용</div>
					<label id="option-text" for="option">물품 옵션 설정
						<input type="checkbox" name="option" id="option">
					</label>
				</div>
					<div class="input-area">
						<button type="button" name="option" onclick="openPopUp3();">상품옵션</button>
						<input type="file" name="parts" accept="image/*" multiple="multiple">썸네일이미지
					
					</div>
					<div></div>
					<div>
						
					</div>


					<div></div>
					<div class="submit">
						<button type="button">이전</button>
						<input type="submit" value="완료">
					</div>
				</form>
		</main>
	</div>
<script>

	document.querySelector('.submit ')
	
	function openPopUp3(){
		let options = "toolbar=no,scrollbars=no,resizable=yes,status=no,menubar=no,width=800, height=800, top=0,left=0";
		window.open("/nongra/sales/optionList", "상품옵션" , options);			
		
	}


	</script>
</body>
</html>
