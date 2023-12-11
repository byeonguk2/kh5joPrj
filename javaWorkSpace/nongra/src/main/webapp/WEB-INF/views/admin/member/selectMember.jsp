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
	main {
    display: grid;
    grid-template-columns: 1fr;
}

form {
    display: flex;
    flex-direction: column;
    justify-content: center;
    align-items: center;
    margin-bottom: 50px;
/*     margin-top: 50px; */
}

.select_div{
	display: flex;
}

.search_div {
    display: flex;
    gap: 20px;
}

/* 테이블 생성 */
.table-area {
    display: flex;
    justify-content: center;
}

table {
	margin: auto;
    border: 1px #a39485 solid;
    font-size: .9em;
    box-shadow: 0 2px 5px rgba(0,0,0,.25);
    width: 80%;
    border-collapse: collapse;
    border-radius: 5px;
    overflow: hidden;
}

th {
    text-align: center;
}

thead {
    font-weight: bold;
    color: #fff;
    background: #73685d;
}

td, th {
    padding: 1em .5em;
    vertical-align: middle;
}

td {
    border-bottom: 1px solid rgba(0,0,0,.1);
    background: #fff;
    text-align: center;
}

td > input{
	width: 100%;
	height: 100%;
	border: none;
	text-align: center;
}

a {
    color: #73685d;
}

@media all and (max-width: 768px) {
    table, thead, tbody, th, td, tr {
        display: block;
    }

    th {
        text-align: right;
    }

    table {
        position: relative; 
        padding-bottom: 0;
        border: none;
        box-shadow: 0 0 10px rgba(0,0,0,.2);
    }

    thead {
        float: left;
        white-space: nowrap;
    }

    tbody {
        overflow-x: auto;
        overflow-y: hidden;
        position: relative;
        white-space: nowrap;
    }

    tr {
        display: inline-block;
        vertical-align: top;
    }

    th {
        border-bottom: 1px solid #a39485;
    }

    td {
        border-bottom: 1px solid #e5e5e5;
    }
}
.btn-paging {
    display: flex;
    justify-content: space-between;
}

.ben-btn {
    width: 90px;
}

.paging-btn-area {
    display: grid;
    grid-template-columns: 1fr 2fr 1fr;
}

.paging-btn {
    display: flex;
    height: 80px;
    align-items: center;
    justify-content: center;
    gap: 20px;
    font-size: 30px;
}

.paging-btn > button {
    width: 60px;
    height: 30px;
}

.ben-btn {
    width: 90px;
}

.paging-btn-area {
    display: grid;
    grid-template-columns: 1fr 2fr 1fr;
}

.paging-btn {
    display: flex;
    height: 80px;
    align-items: center;
    justify-content: center;
    gap: 20px;
    font-size: 17px;
}

.paging-btn > button {
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
	.modal_area > button{
		width: 100px;
		height: 50px;
		margin: auto;
	}
	.modal_area2{
		display: grid;
		grid-template-rows: 60px 80px 600px 100px;
	}
	.modal_area2 > button{
		width: 100px;
		height: 50px;
		margin: auto;
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
					<h2>회원조회/수정</h2>
					<div class="select_search_area">
						<div class="search_div">
							<select name="option">
								<option name="option" value="MEMBER_NO">번호</option>
								<option name="option" value="NICK">닉네임</option>
								<option name="option" value="ID">아이디</option>
							</select>
							<div class="select_div">
								<input name="searchPageName" type="hidden" value="select">
								<div><input name="memberType" type="radio" value="Y" checked="true">판매자</div>
								<div><input name="memberType" type="radio" value="N">소비자</div>
							</div>
							<input type="text" name="searchValue">
							<button>검색</button>
						</div>
					</div>
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
	<!-- 판매자 정보 수정 -->
	<form action="/nongra/admin/modify" method="post"> 
		<div class="modal">
				<div class="dialog">
					<div class="modal_area">
						<div class="modal_down">
							<div></div>
							<button class="modal_down_btn" type="button" onclick="downModal()">x</button>
						</div>	
						<h1 style="text-align: center;">사업자 정보</h1>
						<table>
							<thead>
							<tr>
								<th>First Name</th>
								<th colspan="4">Last Name</th>
							</tr>
							</thead>
							<tbody>
							<tr>
								<td>사업자 번호</td>
								<td colspan="4">
									<input class="memberNo" type="hidden" name="memberNo" value="">
									<input class="sellerYn1" type="hidden" name="sellerYn" value="">
									<input name="businessNo" class="mtc1"/>
								</td>
							</tr>
							<tr>
								<td>사업형태</td>
								<td colspan="4">
									<input name="businessForm" class="mtc2"/>
								</td>
							</tr>
							<tr>
								<td>사업장명</td>
								<td colspan="4">
									<input name="busineesName" class="mtc3"/>
								</td>
							</tr>
							<tr>
								<td>전화번호</td>
								<td colspan="4">
									<input name="phone" class="mtc4"/>
								</td>
							</tr>
							<tr>
								<td>우편번호</td>
								<td colspan="4">
									<input name="busineesZipCode" class="mtc5"/>
								</td>
							</tr>

							<tr>
								<td>사업장 주소</td>
								<td  colspan="4">
									<input name="address" class="mtc6"/>
								</td>
							</tr>
							<tr>
								<td>상세주소</td>
								<td colspan="4">
									<input name="businessNo" class="mtc7"/>
								</td>
							</tr>
							<tr>
								<td>법인명</td>
								<td colspan="4">
									<input name="detailAddress" class="mtc8"/>
								</td>
							</tr>
							<tr>
								<td>업태</td>
								<td colspan="4">
									<input name="uptae" class="mtc9"/>
								</td>
							</tr>
							<tr>
								<td>업종</td>
								<td  colspan="4">
									<input name="upjong" class="mtc10"/>
								</td>
							</tr>
							<tr>
								<td>통신판매업번호</td>
								<td  colspan="4">
									<input name="reportNumber" class="mtc11"/>
								</td>
							</tr>
							<tr>
								<td>은행명</td>
								<td colspan="4">
									<input name="bank" class="mtc12"/>
								</td>
							</tr>
							<tr>
								<td>입금자명</td>
								<td colspan="4">
									<input name="depositor" class="mtc13"/>
								</td>
							</tr>
							<tr>
								<td>계좌번호</td>
								<td colspan="4">
									<input name="account" class="mtc14"/>
								</td>
							</tr>
							<tr>
								<td>아이디</td>
								<td colspan="4">
									<input name="id" class="mtc15"/>
								</td>
							</tr>
							<tr>
								<td>패스워드</td>
								<td colspan="4">
									<input name="password" class="mtc16"/>
								</td>
							</tr>
							<tr>
								<td>닉네임</td>
								<td colspan="4">
									<input name="nick" class="mtc17"/>
								</td>
							</tr>
							<tr>
								<td>이름</td>
								<td colspan="4">
									<input name="name" class="mtc18"/>
								</td>
							</tr>
							<tr>
								<td>이메일</td>
								<td colspan="4">
									<input name="email" class="mtc19"/>
								</td>
							</tr>
							</tbody>
						</table>
						<button>수정하기</button>
					</div>
				</div>
			</div>
		</form>
	
	<!-- 소비자 정보 수정 -->
	<form action="/nongra/admin/modify" method="post"> 
		<div class="modal2">
				<div class="dialog">
					<div class="modal_area2">
						<div class="modal_down">
							<div></div>
							<button class="modal_down_btn" type="button" onclick="downModal2()">x</button>
						</div>	
						<h1 style="text-align: center;">사업자 정보</h1>
						<table>
							<thead>
							<tr>
								<th>First Name</th>
								<th colspan="4">Last Name</th>
							</tr>
							</thead>
							<tbody>
								<input class="memberNo2" type="hidden" name="memberNo" value="">
								<input class="sellerYn2" type="hidden" name="sellerYn" value="">
								<td>아이디</td>
								<td colspan="4">
									<input name="id" class="mtc2-1"/>
								</td>
							</tr>
							<tr>
								<td>패스워드</td>
								<td colspan="4">
									<input name="password" class="mtc2-2"/>
								</td>
							</tr>
							<tr>
								<td>닉네임</td>
								<td colspan="4">
									<input name="nick" class="mtc2-3"/>
								</td>
							</tr>
							<tr>
								<td>이름</td>
								<td colspan="4">
									<input name="name" class="mtc2-4"/>
								</td>
							</tr>
							<tr>
								<td>이메일</td>
								<td colspan="4">
									<input name="email" class="mtc2-5"/>
								</td>
							</tr>
							<tr>
								<td>전화번호</td>
								<td colspan="4">
									<input name="phone" class="mtc2-6"/>
								</td>
							</tr>
							<tr>
								<td>생년월일</td>
								<td colspan="4">
									<input name="birthDay" class="mtc2-7"/>
								</td>
							</tr>
							<tr>
								<td>포인트</td>
								<td colspan="4">
									<input name="point" class="mtc2-8"/>
								</td>
							</tr>
							<tr>
								<td>주소</td>
								<td colspan="4">
									<input name="address" class="mtc2-9"/>
								</td>
							</tr>
							<tr>
								<td>상세주소</td>
								<td colspan="4">
									<input name="detailAddress" class="mtc2-10"/>
								</td>
							</tr>
							</tbody>
						</table>
						<button>수정하기</button>
					</div>
				</div>
			</div>
		</form>
	
	<script>
		function createAsideLetter(){
		const x = document.querySelector(".aside-item > label");
		const menu1 = document.querySelector(" aside > :nth-child(2) > a ");
		const menu2 = document.querySelector(" aside > :nth-child(3) > a ");
		const menu3 = document.querySelector(" aside > :nth-child(4) > a ");
		const menu4 = document.querySelector(" aside > :nth-child(5) > a ");
		x.innerHTML = "회원관리";
		menu1.innerHTML = "회원 조회/수정";
		menu1.href = "/nongra/admin/select";
		menu2.innerHTML = "회원 정지/해제";
		menu2.href = "/nongra/admin/memberBen";
		menu3.innerHTML = "사업자 허가 여부";
		menu3.href = "/nongra/admin/request";
		menu4.innerHTML = "탈퇴 요청 허가 여부";
		menu4.href = "/nongra/admin/acceptQuit";
		}
		createAsideLetter()
		
		function getModal(x,yn) {
			console.log(yn);
				const modal = document.querySelector(".modal");
				const modal2 = document.querySelector(".modal2");
				console.log(modal2);
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
						document.querySelector(".mtc18").value = data.name;
						document.querySelector(".mtc19").value = data.email;
						document.querySelector(".sellerYn1").value = yn;
						document.querySelector(".memberNo").value = data.memberNo;
						
					}else{
						console.log(yn);
						modal2.classList.toggle("modal_up");
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
						document.querySelector(".memberNo2").value = data.memberNo;
					}
				});
				
		}
			
			function downModal() {
				const modal = document.querySelector(".modal");
				modal.classList.toggle("modal_up");
			}
			function downModal2() {
				const modal2 = document.querySelector(".modal2");
				modal2.classList.toggle("modal_up");
			}
			
			<% if(alert != null){ %>
				alert("<%= alert %>");
			<% } %>
			
	</script>
</body>
</html>