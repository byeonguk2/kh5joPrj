<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>	
<style type="text/css">
		#main-area{
		display: grid;
		grid-template-columns: 230px 8fr;
		padding-top: 145px;
	}
	form{
		display: grid;
		grid-template-columns: 1fr;
	}
	thead > tr {
		height: 50px;
	}
	.form_above{
		display: grid;
		grid-template-columns: 1fr 1fr;
	}
	.select_search_area{
		padding: 50px;
	}
	.select_div{
		display: grid;
		width: 350px;
		grid-template-columns: 1fr 1fr 1fr 1fr;
		margin: 10px 0px 10px 0px;
	}
	.search_div{
		display: grid;
		width: 375px;
		grid-template-columns: 1fr 1fr 1.5fr 0.5fr; 
		margin: 10px 0px 10px 0px;
	} 
	select {
		margin-right: 20px;
	}
	.table-area {
		display: flex;
		justify-content: center;
	}
	table{
		width: 90%;
	}
	tr{
		display: grid;
		grid-template-columns: 1fr 1fr 2fr 2fr 2fr 2fr 3fr 4fr;
		align-items: center;
		border-top: none;
		border-bottom: 1px solid black;
		height: 80px;
	}
	td {
		text-align: center;
		line-height: 40px;
	}
	thead > tr {
		border-top: 1px solid black;
		border-bottom: 1px solid black;
	}
	.btn-paging{
		display: flex;
		justify-content: space-between;
	}
    .ben-btn{
        width: 90px;
    }
    .paging-btn-area{
    	display: grid;
    	grid-template-columns: 1fr 2fr 1fr;
    }
    .paging-btn{
    	display: flex;
		height: 80px;
		align-items: center;
		justify-content: center;
		gap: 20px;
    }
	.paging-btn{
		font-size: 30px;
	}
	.paging-btn > button{
		width: 60px;
		height: 30px;
	}
</style>
</head>
<body>
	<div id="wrap">
		<%@ include file="/WEB-INF/views/common/header/header_admin.jsp" %>
		<div id = "main-area">
			<%@ include file="/WEB-INF/views/common/aside/aside_admin.jsp" %>
			<form action="" method="post">
				<div class="form_above">
					<div class="select_search_area">
						<h2>회원조회/수정</h2>
						<div class="select_div">
							<span>• 회원조회</span>
								<div><input name="a" type="radio" value="판매자" checked="true">판매자</div>
								<div><input name="a" type="radio" value="판매자">소비자</div>
						</div>
						<div class="search_div">
							<span>• 회원검색</span>
							<select name="" id="">
								<option name="option" value="name">이름</option>
								<option name="option" value="no">번호</option>
								<option name="option" value="nick">닉네임</option>
								<option name="option" value="id">아이디</option>
								<input type="text">
								<button>검색</button>
							</select>
						</div>
					</div>
					<div></div>
				</div>
				<div class="table-area">
					<table>
						<thead>
							<tr>
								<th></th>
								<th>번호</th>
								<th>아이디</th>
								<th>닉네임</th>
								<th>회원종류</th>
								<th>회원상태</th>
								<th>가입일시</th>
								<th>정보수정</th>
							</tr>
						</thead>
						<tbody>
							<tr>
								<th></th>
								<td>1</td>
								<td>quddnr123</td>
								<td>킹병욱</td>
								<td>파트너</td>
								<td>정상</td>
								<td>2023.11.23</td>
								<td><button type="button">회원정보수정</button></td>
							</tr>
							<tr>
								<th></th>
								<td>2</td>
								<td>king123</td>
								<td>park병욱</td>
								<td>파트너</td>
								<td>정상</td>
								<td>2023.9.23</td>
								<td><button type="button">회원정보수정</button></td>
							</tr>
							<tr>
								<th></th>
								<td>3</td>
								<td>king123</td>
								<td>park병욱</td>
								<td>파트너</td>
								<td>정상</td>
								<td>2023.9.23</td>
								<td><button type="button">회원정보수정</button></td>
							</tr>
							<tr>
								<th></th>
								<td>4</td>
								<td>king123</td>
								<td>park병욱</td>
								<td>파트너</td>
								<td>정상</td>
								<td>2023.9.23</td>
								<td><button type="button">회원정보수정</button></td>
							</tr>
							<tr>
								<th></th>
								<td>5</td>
								<td>king123</td>
								<td>park병욱</td>
								<td>파트너</td>
								<td>정상</td>
								<td>2023.9.23</td>
								<td><button type="button">회원정보수정</button></td>
							</tr>
							<tr>
								<th></th>
								<td>6</td>
								<td>king123</td>
								<td>park병욱</td>
								<td>파트너</td>
								<td>정상</td>
								<td>2023.9.23</td>
								<td><button type="button">회원정보수정</button></td>
							</tr>
							<tr>
								<th></th>
								<td>7</td>
								<td>king123</td>
								<td>park병욱</td>
								<td>파트너</td>
								<td>정상</td>
								<td>2023.9.23</td>
								<td><button type="button">회원정보수정</button></td>
							</tr>
							<tr>
								<th></th>
								<td>8</td>
								<td>king123</td>
								<td>park병욱</td>
								<td>일반회원</td>
								<td>정상</td>
								<td>2023.9.23</td>
								<td><button type="button">회원정보수정</button></td>
							</tr>
							<tr>
								<th></th>
								<td>9</td>
								<td>king123</td>
								<td>park병욱</td>
								<td>일반회원</td>
								<td>정상</td>
								<td>2023.9.23</td>
								<td><button>회원정보수정</button></td>
							</tr>
							<tr>
								<th></th>
								<td>10</td>
								<td>king123</td>
								<td>park병욱</td>
								<td>일반회원</td>
								<td>정상</td>
								<td>2023.9.23</td>
								<td><button type="button">회원정보수정</button></td>
							</tr>
						</tbody>
					</table>
				</div>
				<div class="paging-btn-area">
					<div></div>
					<div class="paging-btn">
						<button>이전</button>
						<a href="">1</a>
						<a href="">2</a>
						<a href="">3</a>
						<a href="">4</a>
						<a href="">5</a>
						<button>다음</button>
					</div>
					<div></div>
				</div>
			</from>
		</div>
		<script></script>
	</div>
	<script>
		function createAsideLetter(){
		const x = document.querySelector(".aside-item > label");
		const menu1 = document.querySelector(" aside > :nth-child(2) > a ");
		const menu2 = document.querySelector(" aside > :nth-child(3) > a ");
		const menu3 = document.querySelector(" aside > :nth-child(4) > a ");
		x.innerHTML = "회원관리";
		menu1.innerHTML = "회원 조회/수정";
		menu1.href = "/nongra/admin/select";
		menu2.innerHTML = "회원 정지/해제";
		menu2.href = "/nongra/admin/memberBen";
		menu3.innerHTML = "사업자 허가 여부";
		menu3.href = "/nongra/admin/reques";
		}
		createAsideLetter()
		
		
	</script>
</body>
</html>