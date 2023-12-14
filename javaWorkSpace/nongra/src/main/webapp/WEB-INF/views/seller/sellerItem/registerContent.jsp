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
		grid-template-rows: 100px 720px 100px;
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
		display : grid;
		grid-temple-colums : 1fr 1fr;
		grid-column: span 2;
	}
	.input-area *{
		width: 120px;
		height: 44px;
	}
	
	
	.input-area > button , input[type=file]::file-selector-button{
		width: 120px;
		height: 44px;
		background-color: white;
		border: 1px solid #754327;
    	color: #754327;
		border-radius: 5px;
	}
	.container{
		grid-column: span 2;
	}
	.text-area{
		display : grid;
		grid-temple-colums : 1fr 1fr;
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
			<form 
				id="formTag" 
				class="content-area" 
				action="/nongra/seller/registerContentaaa" 
				method="post" 
				enctype="multipart/form-data"
			>
				<h1><span>상품등록</span></h1>
				<div></div>
				<div class="text-area">
					<div><strong>상품 옵션 설정</strong></div>
					<div><strong>판매글 내용</strong>
						<input type="hidden" id="jsonData" name="jsonData" value="khhhhhhhhhhhh">
					</div>
				</div>
					<div class="input-area">
						<button type="button" name="option" onclick="openPopUp3();">상품옵션</button>
						<input type="file" name="file" accept="image/*" multiple="multiple">
					
					</div>
						


					<div class="submit">
						<input type="submit" value="완료">
					</div>
				</form>
		</main>
	</div>
<script>
	
	function openPopUp3(){
		let options = "toolbar=no,scrollbars=no,resizable=yes,status=no,menubar=no,width=800, height=800, top=0,left=0";
		window.open("/nongra/sales/optionList", "상품옵션" , options);			
	}


	function receiveDataFromChild(data) {
	    try {
	        const jsonData = JSON.parse(data);
	        document.querySelector("#jsonData").value = JSON.stringify(jsonData);
	        console.log(JSON.stringify(jsonData));
	    } catch (error) {
	        console.error("Error parsing JSON:", error);
	    }
	}
	
	
	const formTag = document.querySelector("#formTag");
	formTag.addEventListener("submit" , sendData);
	
	function sendData(event){
		
		event.preventDefault();
		const formData = new FormData(formTag);
		
		fetch("/nongra/seller/registerContent" , {
			method : "POST",
			body : formData
		})
		.then( ( resp )=> resp.text() )
		.then( (data) => {
			
			
			alert("상품 등록 성공");
			
			window.location.href = "/nongra/seller/home";
			console.log(data);
			
			
		} )
		.catch( (err)=> {
			console.log(err);
			alert("실패...");
		} )
		;
	}


</script>
</body>
</html>











