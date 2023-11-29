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
		grid-template-columns: 1.4fr 8fr;
	}
	
	.content-area{
		display: grid;
		grid-template-rows: 1fr 9fr;
		border: 1px solid gray;
		margin-left: 10px;
		margin-top: 10px;
		border-radius: 20px;
		width: 100%;
		box-sizing: border-box;
	}
	.send{
		grid-column: span 4;
		display: flex;
		justify-content: center;
	}
	.send-area{
		display: grid;
		grid-template-columns: 1fr 1fr 1fr;
		grid-template-rows: 2fr 7fr 1fr;
		width: 80%;
	}
	.send-top-area{
		display: flex;
		grid-column: span 3;
		border-bottom: 1px solid black;
		justify-content: space-between;
		padding-bottom: 5px;
		margin-bottom: 40px;
	}

	.h1-area{
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
		grid-column: span 2;
		align-items: end;
		justify-content: end;
		
	}
	.table{
		grid-column: span 3;
	}
	.table thead{
		border-bottom: 1px solid black;
		height: 20px;
	}

	.table thead tr td:nth-child(1){
		width: 50px;
	}

	.table thead tr th:nth-child(4),
	.table thead tr th:nth-child(5) {
  		width: 150px;
	}
	.send-bottom-area{
		grid-column: span 3;
		display: flex;
		justify-content: end;
		align-items: center;
	}

	.send-bottom-area > button {
		margin-left: 20px;
	}

	.send-bottom-area button:nth-child(1){
		width: 80px;
		height: 40px;
		font-weight: bolder;
		border-radius: 6px;
	}
	
	.send-bottom-area button:nth-child(2){
		width: 60px;
		height: 40px;
		background-color: dimgray;
		border-radius: 6px;
		font-weight: bolder;
	}

	
</style>
</head>
<body>
	<div class = "wrap">
		<%@ include file="/WEB-INF/views/common/header/header_seller.jsp" %>
		<main>
			<%@ include file="/WEB-INF/views/common/aside/aside_seller.jsp" %>
			<div class="content-area">
				<div class="h1-area">
					<h1>보낸쪽지</h1>
				</div>
				<div class="send">
					<div class="send-area">
						<div class="send-top-area">
							<div class="send-check-area">
								<select>
									<option value="">10</option>
								</select>
								<span>123</span>
							</div>
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
						<table class="table">
							<thead>
								<td><input onclick="checkAll();" name="checkbox" type="checkbox" ></td>
								<th><span>제목</span></th>
								<th><span>내용</span></th>
								<th><span>보낸사람</span></th>
								<th><span>보낸일시</span></th>
							</thead>
							<tbody>
								<td><input name="checkbox" type="checkbox"></td>
								<td><span>1</span></td>
								<td><span>2</span></td>
								<td><span>3</span></td>
								<td><span>4</span></td>
							</tbody>
						</table>
						<div class="send-bottom-area">
							<button>작성하기</button>
							<button>삭제</button>
						</div>
					</div>
				</div>
			</div>
		</main>
	</div>

	<script>
		function checkAll(){
			const checkAll = document.querySelectorAll("input[name=checkbox]");
			if(checkAll[0].checked === true){
				for(let i = 0; i<checkAll.length; ++i){
					checkAll[i].checked = true;
				}
			}else{
				for(let i = 0; i<checkAll.length; ++i){
					checkAll[i].checked = false;
				}
			}

		}
	</script>
</body>
</html>