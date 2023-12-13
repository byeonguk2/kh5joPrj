<%@page import="java.util.Map"%>
<%@page import="com.kh.app.page.vo.PageVo"%>
<%@page import="com.kh.app.seller.vo.SellerVo"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
    <% 
    	List<SellerVo> voList = (List<SellerVo>)request.getAttribute("voList"); 
    	PageVo pvo = (PageVo)request.getAttribute("pvo");
    	Map<String,Object> map = (Map<String,Object>)request.getAttribute("map");
    %>
    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>	
<style type="text/css">

/* 기본 레이아웃 */
#main-area{
	display: grid;
	grid-template-columns: 230px 8fr;
	padding-top: 145px;
}

.select_search_area{
	display: flex;
    flex-direction: column;
    justify-content: center;
    align-items: center;
	margin-bottom: 50px;
}

/* 테이블 생성 */
.table-area{
	display: flex;
	justify-content: center;
}
table {
  border: 1px #a39485 solid;
  font-size: .9em;
  box-shadow: 0 2px 5px rgba(0,0,0,.25);
  width: 80%;
  border-collapse: collapse;
  border-radius: 5px;
  overflow: hidden;
  margin:auto;
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
   	margin: auto;
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
	grid-template-rows: 60px 80px 800px 80px 800px 80px 800px 100px;
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

.modal_area > div{
	border-bottom: 0.5px solid #73685d;
	text-align: center;
}

.modal-img1{
	margin: auto;
	width: 600px;
	height: 600px;
	background-size: cover;
	border: 1px solid black;
}
.modal-img2{
	margin: auto;
	width: 600px;
	height: 600px;
	background-size: cover;
	border: 1px solid black;
}
</style>
</head>
<body>
	<div id="wrap">
		<%@ include file="/WEB-INF/views/common/header/header_admin.jsp" %>
		<div id = "main-area">
			<%@ include file="/WEB-INF/views/common/aside/aside_admin.jsp" %>
			<div class="main">
				<div class="form_above">
					<div class="select_search_area">
						<h2>권한요청 허가/조회</h2>
						<div class="search_div">
							<form action="/nongra/admin/search">
								<select name="option">
									<option name="option" value="nick">닉네임</option>
									<option name="option" value="id">아이디</option>
									<input type="hidden" name="memberType" value="N"/>
									<input type="text" name="searchValue">
									<input type="submit" value="검색하기">
								</select>
							</form>
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
			</div>
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
						<table>
							<thead>
							<tr>
								<th>First Name</th>
								<th colspan="4">Last Name</th>
							</tr>
							</thead>
							<tbody>
							<tr>
								<td>사업자번호</td>
								<td class="mtc1" colspan="4"></td>
							</tr>
							<tr>
								<td>사업형태</td>
								<td class="mtc2" colspan="4"></td>
							</tr>
							<tr>
								<td>사업장명</td>
								<td class="mtc3" colspan="4"></td>
							</tr>
							<tr>
								<td>전화번호</td>
								<td class="mtc4" colspan="4"></td>
							</tr>
							<tr>
								<td>우편번호</td>
								<td class="mtc5" colspan="4"></td>
							</tr>
							<tr>
								<td>사업장 주소</td>
								<td class="mtc6" colspan="4"></td>
							</tr>
							<tr>
								<td>상세주소</td>
								<td class="mtc7" colspan="4"></td>
							</tr>
							<tr>
								<td>법인명</td>
								<td class="mtc8" colspan="4"></td>
							</tr>
							<tr>
								<td>업태</td>
								<td class="mtc9" colspan="4"></td>
							</tr>
							<tr>
								<td>업종</td>
								<td class="mtc10" colspan="4"></td>
							</tr>
							<tr>
								<td>통신판매업번호</td>
								<td class="mtc11" colspan="4"></td>
							</tr>
							<tr>
								<td>은행명</td>
								<td class="mtc12" colspan="4"></td>
							</tr>
							<tr>
								<td>입금자명</td>
								<td class="mtc13" colspan="4"></td>
							</tr>
							<tr>
								<td>계좌번호</td>
								<td class="mtc14" colspan="4"></td>
							</tr>
							</tbody>
						</table>
						<div>
							<h2>통장사본</h2>
						</div>
						<img class="modal-img1" alt="통장사본" src="">
						<div>
							<h2>사업자 등록증</h2>
						</div>
						<img class="modal-img2" alt="사업자등록증" src="">
						<div class="modal-table-area">
							<button type="button" onclick="request_ok()">요청허가</button>
						</div>
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
			const menu4 = document.querySelector(" aside > :nth-child(5) > a ");
			x.innerHTML = "회원관리";
			menu1.innerHTML = "회원 조회/수정";
			menu1.href = "/nongra/admin/findAllMembers";
			menu2.innerHTML = "회원 정지/해제";
	        menu2.href = "/nongra/admin/memberBen";
			menu3.innerHTML = "사업자 허가 여부";
			menu3.href = "/nongra/admin/request";
			menu4.innerHTML = "탈퇴 요청 허가 여부";
			menu4.href = "/nongra/admin/acceptQuit";
		}
		createAsideLetter()

		function getModal(x) {
				const modal = document.querySelector(".modal");
				console.log(x);
				fetch('/nongra/admin/businessFile?no='+x)
				.then((response)=>{
					return response.json();
				}).then((data)=>{
					document.querySelector("input[type=hidden]").value = data.vo.sellerNo;
					document.querySelector(".mtc1").innerHTML = data.vo.businessNo;
					document.querySelector(".mtc2").innerHTML = data.vo.businessForm;
					document.querySelector(".mtc3").innerHTML = data.vo.busineesName;
					document.querySelector(".mtc4").innerHTML = data.vo.busineesPhone;
					document.querySelector(".mtc5").innerHTML = data.vo.busineesZipCode;
					document.querySelector(".mtc6").innerHTML = data.vo.busineesAdr;
					document.querySelector(".mtc7").innerHTML = data.vo.detailedAdr;
					document.querySelector(".mtc8").innerHTML = data.vo.corporationName;
					document.querySelector(".mtc9").innerHTML = data.vo.uptae;
					document.querySelector(".mtc10").innerHTML = data.vo.upjong;
					document.querySelector(".mtc11").innerHTML = data.vo.reportNumber;
					document.querySelector(".mtc12").innerHTML = data.vo.bank;
					document.querySelector(".mtc13").innerHTML = data.vo.depositor;
					document.querySelector(".mtc14").innerHTML = data.vo.account;
					console.log(data.fileList);
					console.log(data.fileList2);
					document.querySelector(".modal-img1").src = data.fileList2;
					document.querySelector(".modal-img2").src = data.fileList;
					console.log(document.querySelector(".modal-img2").src);
					
				});
				
				modal.classList.toggle("modal_up");
			}
			
			function downModal() {
				const modal = document.querySelector(".modal");
				modal.classList.toggle("modal_up");
			}

			function request_ok(){
				const no = document.querySelector("input[type=hidden]").value
				console.log(no);
				fetch("/nongra/admin/requestOk?no="+no)
				.then((response)=>{
					console.log(response);
					return response.json();
				}).then((data)=>{
					console.log(data.result);
					alert(data.result);

				}).catch(()=>{
					alert("권한요청 수락 실패..");
				});
				const modal = document.querySelector(".modal");
				modal.classList.toggle("modal_up");
				window.location.reload() 
			}
	</script>
</body>
</html>