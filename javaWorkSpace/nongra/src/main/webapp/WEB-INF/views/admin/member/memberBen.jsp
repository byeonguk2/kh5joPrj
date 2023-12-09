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
	main{
		display: grid;
		grid-template-columns: 1fr;
	}
	thead > tr {
		height: 50px;
	}
	form{
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
		grid-template-columns: 1fr 1fr 2fr 2fr 2fr 3fr 4fr;
		align-items: center;
		border-top: none;
		border-bottom: 1px solid black;
		height: 60px;
	}
	td {
		text-align: center;
		line-height: 40px;
	}
	thead > tr {
		border-top: 1px solid black;
		border-bottom: 1px solid black;
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
    .ben-btn{
        width: 90px;
    }
	.paging-btn{
		font-size: 17px;
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
			<main>
				<form action="/nongra/admin/searchMember">
					<div class="select_search_area">
						<h2>회원정지/해제</h2>
						<div class="select_div">
							<span>• 회원조회</span>
								<input name="searchPageName" type="hidden" value="ben">
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
								<td><%= list.getJoinDate() %></td>
								<td><button type="button" onclick="freeze(<%= list.getMemberNo() %>,'<%=list.getFreezeYn()%>')"><%if(list.getFreezeYn().equals("N")){ %>정지하기<% }else { %>정지해제<%}%></button></td>
							</tr>
							<% } %>
						</tbody>
					</table>
				</div>
				<div class="paging-btn-area">
					<div></div>
					<div class="paging-btn">
						<%if(pvo.getStartPage() != 1){ %>
				          <a href="/nongra/admin/memberBen?pno=<%= pvo.getStartPage()-1 %>">이전</a>
				         <% } %>
						<% for(int i = pvo.getStartPage(); i <= pvo.getEndPage(); i++){ %>
         	
				         	<% if(i == pvo.getCurrentPage()){ %>
				           		<span><%= i %></span>
				            <% }else{ %>
			            	
			             	<a href="/nongra/admin/memberBen?pno=<%= i %>"><%= i %></a>
			             	
			            <% } %>
			            
			            <% } %>
			            
			            <%if(pvo.getEndPage() != pvo.getMaxPage()){ %>
			            <a href="/nongra/admin/memberBen?pno=<%= pvo.getEndPage()+1 %>">다음</a>
			        	<% } %>
					</div>
					<div></div>
				</div>
			</main>
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
		menu3.href = "/nongra/admin/request";
		}
		createAsideLetter()
		
		// 정지 시키는 기능
		function freeze(no,Freeze){
			console.log(Freeze);
			fetch("/nongra/admin/freeze?no="+no+"&yn="+Freeze)
			.then((resp)=>{
				return resp.json();
			}).then((data)=>{
				alert(data.succees);
			}).catch((x)=>{
				alert("실패 ..");
			});
			window.location.reload();
		}
		
	</script>
</body>
</html>