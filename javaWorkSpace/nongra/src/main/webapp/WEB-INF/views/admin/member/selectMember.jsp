<%@page import="com.kh.app.page.vo.PageVo"%>
<%@page import="java.util.Map"%>
<%@page import="com.kh.app.seller.vo.SellerVo"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <% 
    	List<SellerVo> voList = (List<SellerVo>)request.getAttribute("voList"); 
    	PageVo pvo = (PageVo)request.getAttribute("pvo");
    	Map<String,Object> map = (Map<String,Object>)request.getAttribute("map");
    	
    	// 회원 수정시 에러메세지
    	String alert = (String)session.getAttribute("alert");
    	session.removeAttribute("alert");
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
	form{ß
		display: grid;
		grid-template-columns: 1fr;
	}
	thead > tr {
		height: 50px;
	}
	.form_above{
		display: grid;
		grid-template-columns: 1fr 1fr;
	}ß
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
		grid-template-rows: 60px 80px 1200px 100px;
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
	/*  */
	.modal2 {
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
	.modal_up2{
		display: flex;
	}
	.modal_area2{
		display: grid;
		grid-template-rows: 60px 80px 800px 100px;
	}.modal_down2{
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
	/* 	grid-template-rows: 60px 60px 60px 60px 60px 60px; */
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
			<main>
				<form action="/nongra/admin/searchMember">
					<div class="select_search_area">
						<h2>회원조회/수정</h2>
						<div class="select_div">
							<span>• 회원조회</span>
								<input name="searchPageName" type="hidden" value="select">
								<div><input name="memberType" type="radio" value="Y" checked="true">판매자</div>
								<div><input name="memberType" type="radio" value="N">소비자</div>
						</div>
						<div class="search_div">
							<span>• 회원검색</span>
							<select name="option">
								<option name="option" value="MEMBER_NO">번호</option>
								<option name="option" value="NICK">닉네임</option>
								<option name="option" value="ID">아이디</option>
								<input type="text" name="searchValue">
								<button>검색</button>
							</select>
						</div>
					</div>
					<div></div>
				</form>
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
							<% for(SellerVo list : voList){ %>
							<tr>
								<th></th>
								<td><%= list.getMemberNo() %></td>
								<td><%= list.getId() %></td>
								<td><%= list.getNick() %></td>
								<td><%if(list.getSellerYn().equals("Y")){ %>판매자<% }else { %>소비자<%}%></td>
								<td><%if(list.getFreezeYn().equals("N")){ %>정상<% }else { %>정지<%}%></td>
								<td><%= list.getJoinDate() %></td>
								<td><button type="button" onclick="getModal(<%= list.getMemberNo() %>,'<%= list.getSellerYn() %>')">정보수정</button></td>
							</tr>
							<% } %>
						</tbody>
					</table>
				</div>
				<div class="paging-btn-area">
					<div></div>
					<div class="paging-btn">
						<%if(pvo.getStartPage() != 1){ %>
				          <a href="/nongra/admin/select?pno=<%= pvo.getStartPage()-1 %>">이전</a>
				         <% } %>
						<% for(int i = pvo.getStartPage(); i <= pvo.getEndPage(); i++){ %>
         	
				         	<% if(i == pvo.getCurrentPage()){ %>
				           		<span><%= i %></span>
				            <% }else{ %>
			            	
			             	<a href="/nongra/admin/select?pno=<%= i %>"><%= i %></a>
			             	
			            <% } %>
			            
			            <% } %>
			            
			            <%if(pvo.getEndPage() != pvo.getMaxPage()){ %>
			            <a href="/nongra/admin/selectpno=<%= pvo.getEndPage()+1 %>">다음</a>
			        	<% } %>
					</div>
					<div></div>
				</div>
			</main>
		</div>
	</div>
	</div>
	<form action="/nongra/admin/modify" method="post"> 
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
									<input type="hidden" name="sellerYn" class="sellerYn1" value="">
									<div class="modal-table-title">사업자 번호</div>
									<input name="businessNo" class="modal-table-cotent mtc1" />
								</div>
								<div class="modal-table-area">
									<div class="modal-table-title">사업형태</div>
									<input name="businessForm" class="modal-table-cotent mtc2"/>
								</div>
								<div class="modal-table-area">
									<div class="modal-table-title">사업장명</div>
									<input name="busineesName" class="modal-table-cotent mtc3"/>
								</div>
								<div class="modal-table-area">
									<div class="modal-table-title">사업자 전화번호</div>
									<input name="phone" class="modal-table-cotent mtc4"/>
								</div>
								<div class="modal-table-area">
									<div class="modal-table-title">우편번호</div>
									<input name="busineesZipCode" class="modal-table-cotent mtc5"/>
								</div>
								<div class="modal-table-area">
									<div class="modal-table-title">사업장 주소</div>
									<input name="address" class="modal-table-cotent mtc6"/>
								</div>
								<div class="modal-table-area">
									<div class="modal-table-title">상세주소</div>
									<input name="detailAddress" class="modal-table-cotent mtc7"/>
								</div>
								<div class="modal-table-area">
									<div class="modal-table-title">법인명</div>
									<input name="corporationName" class="modal-table-cotent mtc8"/>
								</div>
								<div class="modal-table-area">
									<div class="modal-table-title">업태</div>
									<input name="uptae" class="modal-table-cotent mtc9"/>
								</div>
								<div class="modal-table-area">
									<div class="modal-table-title">업종</div>
									<input name="upjong" class="modal-table-cotent mtc10"/>
								</div>
								<div class="modal-table-area">
									<div class="modal-table-title">통신판매업신고번호</div>
									<input name="reportNumber" class="modal-table-cotent mtc11"/>
								</div>
								<div class="modal-table-area">
									<div class="modal-table-title">은행</div>
									<input  name="bank"class="modal-table-cotent mtc12"/>
								</div>
								<div class="modal-table-area">
									<div class="modal-table-title">입금자명</div>
									<input name="depositor" class="modal-table-cotent mtc13"/>
								</div>
								<div class="modal-table-area">
									<div class="modal-table-title">입금계좌</div>
									<input name="account" class="modal-table-cotent mtc14"/>
								</div>
								<div class="modal-table-area">
									<input type="hidden" value="">
									<div class="modal-table-title">아이디</div>
									<input name="id" class="modal-table-cotent mtc15" />
								</div>
								<div class="modal-table-area">
									<div class="modal-table-title">패스워드</div>
									<input name="password" class="modal-table-cotent mtc16"/>
								</div>
								<div class="modal-table-area">
									<div class="modal-table-title">닉네임</div>
									<input name="nick" class="modal-table-cotent mtc17"/>
								</div>
								<div class="modal-table-area">
									<div class="modal-table-title">이메일 </div>
									<input name="email" class="modal-table-cotent mtc18"/>
								</div>
							</div>
						</div>
						<div class="modal-table-area">
							<button>요청허가</button>
						</div>
					</div>
				</div>
			</div>
			</form>
			
			<form action="/nongra/admin/modify" method="post">
			<div class="modal2">
				<div class="dialog">
					<div class="modal_area">
						<div class="modal_down">
							<div></div>
							<button class="modal_down_btn" type="button" onclick="downModal2()">x</button>
						</div>	
						<h1 style="text-align: center;">사업자 정보</h1>
						<div>
							<div class="modal_table">
								<div class="modal-table-area">
									<input type="hidden" class="sellerYn2" name="sellerYn" value="">
									<div class="modal-table-title">아이디</div>
									<input name="id" class="modal-table-cotent mtc2-1" />
								</div>
								<div class="modal-table-area">
									<div class="modal-table-title">패스워드</div>
									<input name="password" class="modal-table-cotent mtc2-2"/>
								</div>
								<div class="modal-table-area">
									<div class="modal-table-title">닉네임</div>
									<input name="nick" class="modal-table-cotent mtc2-3"/>
								</div>
								<div class="modal-table-area">
									<div class="modal-table-title">이름 </div>
									<input name="name" class="modal-table-cotent mtc2-4"/>
								</div>
								<div class="modal-table-area">
									<div class="modal-table-title">이메일 </div>
									<input name="email" class="modal-table-cotent mtc2-5"/>
								</div>
								<div class="modal-table-area">
									<div class="modal-table-title">전화번호 </div>
									<input name="phone" class="modal-table-cotent mtc2-6"/>
								</div>
								<div class="modal-table-area">
									<div class="modal-table-title">생년월일 </div>
									<input name="birthDay" class="modal-table-cotent mtc2-7"/>
								</div>
								<div class="modal-table-area">
									<div class="modal-table-title">잔액 </div>
									<input name="point" class="modal-table-cotent mtc2-8"/>
								</div>
								<div class="modal-table-area">
									<div class="modal-table-title">주소 </div>
									<input name="address" class="modal-table-cotent mtc2-9"/>
								</div>
								<div class="modal-table-area">
									<div class="modal-table-title">상세주소 </div>
									<input name="detailAddress" class="modal-table-cotent mtc2-10"/>
								</div>
								</div>
							</div>
						</div>
						<div class="modal-table-area">
							<button>요청허가</button>
						</div>
					</div>
				</div>
				</form>
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
		menu3.href = "/nongra/admin/request";
		}
		createAsideLetter()
		
		function getModal(x,yn) {
			console.log(yn);
				const modal = document.querySelector(".modal");
				const modal2 = document.querySelector(".modal2");
				console.log(x);
				fetch('/nongra/admin/checkAllMembers?no='+x)
				.then((response)=>{
					return response.json();
				}).then((data)=>{
					console.log(data);
					if(yn == 'Y'){
						modal.classList.toggle("modal_up");
						document.querySelector(".mtc1").value = data.businessNo;
						document.querySelector(".mtc2").value = data.businessForm;
						document.querySelector(".mtc3").value = data.busineesName;
						document.querySelector(".mtc4").value = data.busineesPhone;
						document.querySelector(".mtc5").value = data.busineesZipCode;
						document.querySelector(".mtc6").value = data.busineesAdr;
						document.querySelector(".mtc7").value = data.detailedAdr;
						document.querySelector(".mtc8").value = data.corporationName;
						document.querySelector(".mtc9").value = data.uptae;
						document.querySelector(".mtc10").value = data.upjong;
						document.querySelector(".mtc11").value = data.reportNumber;
						document.querySelector(".mtc12").value = data.bank;
						document.querySelector(".mtc13").value = data.depositor;
						document.querySelector(".mtc14").value = data.account;
						document.querySelector(".mtc15").value = data.id;
						document.querySelector(".mtc16").value = data.password;
						document.querySelector(".mtc17").value = data.nick;
						document.querySelector(".mtc18").value = data.email;
						document.querySelector(".sellerYn1").value = yn;
					}else{
						console.log(yn);
						modal2.classList.toggle("modal_up2");
						document.querySelector(".mtc2-1").value = data.id;
						document.querySelector(".mtc2-2").value = data.password;
						document.querySelector(".mtc2-3").value = data.nick;
						document.querySelector(".mtc2-4").value = data.name;
						document.querySelector(".mtc2-5").value = data.email;
						document.querySelector(".mtc2-6").value = data.phone;
						document.querySelector(".mtc2-7").value = data.birthDay;
						document.querySelector(".mtc2-8").value = data.point;
						document.querySelector(".mtc2-9").value = data.memberAddress;
						document.querySelector(".mtc2-10").value = data.memberDetailAddress;
						document.querySelector(".sellerYn2").value = yn;
					}
				});
				
		}
			
			function downModal() {
				const modal = document.querySelector(".modal");
				modal.classList.toggle("modal_up");
			}
			function downModal2() {
				const modal = document.querySelector(".modal2");
				modal.classList.toggle("modal_up2");
			}
			
			<% if(alert != null){ %>
				alert("<%= alert %>");
			<% } %>
			
	</script>
</body>
</html>