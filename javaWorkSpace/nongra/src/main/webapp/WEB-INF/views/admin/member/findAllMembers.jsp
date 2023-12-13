<%@page import="com.kh.app.admin.vo.MemberDTO"%>
<%@page import="com.kh.app.page.vo.PageVo"%>
<%@page import="java.util.Map"%>
<%@page import="com.kh.app.seller.vo.SellerVo"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<% 

	// 회원 list 받아오기
	List<MemberDTO> memberVoList = (List<MemberDTO>)request.getAttribute("memberVoList"); 
	PageVo pvo = (PageVo)request.getAttribute("pvo");
	
%>
    
<!DOCTYPE html>
<html>

<head>
<meta charset="UTF-8">
<title>Insert title here</title>	
<link rel="stylesheet" href="/nongra/resources/css/admin/member/findAllMmbers.css">
</head>

<body>

<!-- 회원 조회 -->
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
						<% for(MemberDTO list : memberVoList){ %>
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
			          <a href="/nongra/admin/findAllMembers?pno=<%= pvo.getStartPage()-1 %>">이전</a>
			         <% } %>
					<% for(int i = pvo.getStartPage(); i <= pvo.getEndPage(); i++){ %>
        	
			         	<% if(i == pvo.getCurrentPage()){ %>
			           		<span><%= i %></span>
			            <% }else{ %>
		            	
		             	<a href="/nongra/admin/findAllMembers?pno=<%= i %>"><%= i %></a>
		             	
		            <% } %>
		            
		            <% } %>
		            
		            <%if(pvo.getEndPage() != pvo.getMaxPage()){ %>
		            <a href="/nongra/admin/findAllMembers?pno=<%= pvo.getEndPage()+1 %>">다음</a>
		        	<% } %>
				</div>
				<div></div>
			</div>
		</main>
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
								<input name="detailAddress" class="mtc7"/>
							</td>
						</tr>
						<tr>
							<td>법인명</td>
							<td colspan="4">
								<input name="corporationName" class="mtc8"/>
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
	
	<!-- 소비자 모달창 -->
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

<script src="/nongra/resources/js/admin/member/findAllMembers.js"></script>

</body>

</html>