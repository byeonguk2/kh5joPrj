<%@page import="com.kh.app.page.vo.PageVo"%>
<%@page import="com.kh.app.seller.vo.SellerVo"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
    <% 
    	List<SellerVo> voList = (List<SellerVo>)request.getAttribute("voList"); 
    	PageVo pvo = (PageVo)request.getAttribute("pvo");
    %>
    
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
		grid-template-columns: 1fr 1fr 2fr  2fr 2fr 3fr 4fr;
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
	
	
	/* 모달창 */
	/* 여기다가 display none 주시면 됩니다 */
	.modal {
		display: none;
		position:fixed;
		left: 0;
		right: 0;
		top: 0;
		bottom: 0;
		background: rgba(0,0,0,0.3);
 		z-index: 2; 
	}
	/* 여기안에서 작업하면되고 */
	.dialog {
		width: 80vw;
		height: 80vh;
		border-radius: 1em;
		background: white;
		overflow:auto;
		margin: auto;
	}
	.modal_up{
		display: flex;
	}
	.modal_area{
		display: grid;
		grid-template-rows: 60px 80px 1000px 500px 500px;
	}.modal_down{
		display: grid;
		grid-template-columns: 1fr 30px;
		padding: 20px 20px 0px 20px;
	}
	.modal_down_btn{
		border: none;
    	background-color: white;
		font-size: 30px;
		cursor: pointer;
	}
	.modal_table{
		display: grid;
		grid-template-rows: 60px 60px 60px 60px 60px 60px;
		width: 800px;
		margin: auto;
		margin-top: 50px
	}
	.modal-table-area{
		display: flex;
	}
	.modal-table-title{
		width: 200px;
		border:1px solid black;
		text-align: center;
		line-height: 60px
	}
	.modal-table-cotent{
		width: 100%;
		border:1px solid black;
		padding-left: 30px;
		line-height: 60px
	}
	.modal-img1{
		margin: auto;
		width: 600px;
		height: 600px;
		background-size: cover;
	}
	.modal-img2{
		margin: auto;
		width: 600px;
		height: 600px;
		background-size: cover;
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
						<h2>요청허가/조회</h2>
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
								<th>가입일시</th>
								<th>요청보기</th>
							</tr>
						</thead>
						<tbody>
						<% for(SellerVo list : voList){ %>
							<tr>
								<th></th>
								<td><%= list.getSellerNo() %></td>
								<td><%= list.getId() %></td>
								<td><%= list.getNick() %></td>
								<td>판매자</td>
								<td><%= list.getJoinDate() %></td>
								<td><button type="button" class="ben-btn" onclick="getModal(<%= list.getSellerNo() %>)">요청확인</button></td>
								<input type="hidden" name="crrVo" value="<%= list %>"/>
							</tr>
							<% } %>
						</tbody>
					</table>
				</div>
				<div class="paging-btn-area">
					<div></div>
					<div class="paging-btn">
						<%if(pvo.getStartPage() != 1){ %>
				          <a href="/nongra/admin/request?pno=<%= pvo.getStartPage()-1 %>">이전</a>
				         <% } %>
						<% for(int i = pvo.getStartPage(); i <= pvo.getEndPage(); i++){ %>
         	
				         	<% if(i == pvo.getCurrentPage()){ %>
				           		<span><%= i %></span>
				            <% }else{ %>
			            	
			             	<a href="/nongra/admin/request?pno=<%= i %>"><%= i %></a>
			             	
			            <% } %>
			            
			            <% } %>
			            
			            <%if(pvo.getEndPage() != pvo.getMaxPage()){ %>
			            <a href="/nongra/admin/request?pno=<%= pvo.getEndPage()+1 %>">다음</a>
			        	<% } %>
					</div>
					<div></div>
				</div>
			</from>
		</div>
		<body>
        <div class="modal">
            <div class="dialog">
                <div class="modal_area">
					<div class="modal_down">
						<div></div>
						<button class="modal_down_btn" type="button" onclick="downModal()">x</button>
					</div>	
					<h1 style="text-align: center;">사업자 정보</h1>
					<div>
						<div class="modal_table">
							<div class="modal-table-area">
								<div class="modal-table-title">사업자 번호</div>
								<div class="modal-table-cotent"><%= 1 %></div>
							</div>
							<div class="modal-table-area">
								<div class="modal-table-title">사업형태</div>
								<div class="modal-table-cotent">012331233</div>
							</div>
							<div class="modal-table-area">
								<div class="modal-table-title">사업장명</div>
								<div class="modal-table-cotent">012331233</div>
							</div>
							<div class="modal-table-area">
								<div class="modal-table-title">사업자 전화번호</div>
								<div class="modal-table-cotent">012331233</div>
							</div>
							<div class="modal-table-area">
								<div class="modal-table-title">우편번호</div>
								<div class="modal-table-cotent"><%= 1 %></div>
							</div>
							<div class="modal-table-area">
								<div class="modal-table-title">사업장 주소</div>
								<div class="modal-table-cotent">012331233</div>
							</div>
							<div class="modal-table-area">
								<div class="modal-table-title">상세주소</div>
								<div class="modal-table-cotent">012331233</div>
							</div>
							<div class="modal-table-area">
								<div class="modal-table-title">법인명</div>
								<div class="modal-table-cotent">012331233</div>
							</div>
							<div class="modal-table-area">
								<div class="modal-table-title">업태</div>
								<div class="modal-table-cotent">012331233</div>
							</div>
							<div class="modal-table-area">
								<div class="modal-table-title">업종</div>
								<div class="modal-table-cotent">012331233</div>
							</div>
							<div class="modal-table-area">
								<div class="modal-table-title">통신판매업신고번호</div>
								<div class="modal-table-cotent">012331233</div>
							</div>
							<div class="modal-table-area">
								<div class="modal-table-title">은행</div>
								<div class="modal-table-cotent">012331233</div>
							</div>
							<div class="modal-table-area">
								<div class="modal-table-title">입금자명</div>
								<div class="modal-table-cotent">012331233</div>
							</div>
							<div class="modal-table-area">
								<div class="modal-table-title">입금계좌</div>
								<div class="modal-table-cotent">012331233</div>
							</div>
						</div>
					</div>
					<img class="modal-img1" alt="" src="/nongra/resources/img/common/logo.png">
					<img class="modal-img2" alt="" src="/nongra/resources/img/common/mark.png">
				</div>
            </div>
        </div>
    </body>
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
			menu3.href = "/nongra/admin/member/request";
		}
		createAsideLetter()

		function getModal(x) {
				const modal = document.querySelector(".modal");
				
				fetch('/nongra/admin/businessFile?'+'no'+x,(response)=>{
					return response;
				}).then(()=>{

				});
				
				modal.classList.toggle("modal_up");
			}
			
			function downModal() {
				const modal = document.querySelector(".modal");
				modal.classList.toggle("modal_up");
			}

	</script>
</body>
</html>