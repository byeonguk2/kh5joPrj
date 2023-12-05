<%@page import="com.kh.app.page.vo.PageVo"%>
<%@page import="com.kh.app.seller.vo.SellerNoteVo"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%
    	List<SellerNoteVo>sendNoteList = (List<SellerNoteVo>)request.getAttribute("sendNoteList");
    	PageVo pvo = (PageVo)request.getAttribute("pvo");
    %>
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
		grid-template-rows: 1fr 9fr;
		border: 1px solid gray;
		margin-left: 10px;
		margin-top: 10px;
		border-radius: 20px;
		width: 99%;
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
		display: flex;
		flex-direction: column;
	}
	.table tr {
		display: grid;
		grid-template-columns: 50px 3fr 3fr 1fr 1fr;
		text-align: center;
		border-bottom: 1px solid gray;
		margin-bottom: 10px;
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
	.send-bottom-area > div {
		width: 80%;
		display: flex;
		justify-content: center;
	}

	.send-bottom-area > button:nth-child(2){
		width: 80px;
		height: 40px;
		font-weight: bolder;
		border-radius: 6px;
	}
	
	.send-bottom-area > button:nth-child(3){
		width: 60px;
		height: 40px;
		background-color: dimgray;
		border-radius: 6px;
		font-weight: bolder;
	}
	.page-area *{
		margin-left : 10px;
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
								<tr>
									<td><input onclick="checkAll();" name="checkbox" type="checkbox" ></td>
									<th><span>제목</span></th>
									<th><span>내용</span></th>
									<th><span>받는사람</span></th>
									<th><span>보낸일시</span></th>
								</tr>
							</thead>
							<tbody>
								<% for (SellerNoteVo sellerNote : sendNoteList) { %>
								    <tr>
								        <td><input name="checkbox" type="checkbox"></td>
								        <td><span><%= sellerNote.getTitle().length() > 20 ? sellerNote.getTitle().substring(0, 20) + "..." : sellerNote.getTitle() %></span></td>
								        <td><span><%= sellerNote.getContent().length() > 20 ? sellerNote.getContent().substring(0, 20) + "..." : sellerNote.getContent() %></span></td>
								        <td><span><%= sellerNote.getToId().length() > 20 ? sellerNote.getToId().substring(0, 20) + "..." : sellerNote.getToId() %></span></td>
								        <td><span><%= sellerNote.getSendDate() %></span></td>
								    </tr>
								<% } %>
							</tbody>
						</table>
						<div class="send-bottom-area">
							<div class="page-area">
								
								<% if(pvo.getStartPage() != 1){ %>
									<a href="/nongra//seller/note/send?pno=<%= pvo.getStartPage() - 1%>">이전</a>
								<%} %>
								
								<% for(int i = pvo.getStartPage(); i< pvo.getEndPage(); i++){%>
									
									<%if(i == pvo.getCurrentPage()){ %>
										<span><%= i %></span>	
									<%}else{ %>
										<a href="/nongra/seller/note/send?pno=<%= i %>"><%= i %></a>
									<%} %>
									
								<%} %>
								
								<% if(pvo.getEndPage() != pvo.getMaxPage()){ %>
									<a href="/nongra/seller/note/send?pno=<%= pvo.getEndPage() + 1%>">다음</a>
								<%} %>
							</div>
							<button onclick="openPopup();">작성하기</button>
							<button>삭제</button>
						</div>
					</div>
				</div>
			</div>
		</main>
	</div>

<script>
    let newWindow; // 전역 변수로 창을 선언

    function checkAll() {
        const checkAll = document.querySelectorAll("input[name=checkbox]");
        if (checkAll[0].checked === true) {
            for (let i = 0; i < checkAll.length; ++i) {
                checkAll[i].checked = true;
            }
        } else {
            for (let i = 0; i < checkAll.length; ++i) {
                checkAll[i].checked = false;
            }
        }
    }

    function openPopup() {
        let options = "toolbar=no,scrollbars=no,resizable=yes,status=no,menubar=no,width=800,height=800,top=0,left=0";

        if (newWindow && !newWindow.closed) {
            newWindow.close();
        }

        newWindow = window.open("/nongra/seller/note/write", "쪽지작성", options);

        newWindow.addEventListener('beforeunload', function () {
            newWindow = null; // 창이 닫혔으므로 참조 제거
        });
    }


	

	
</script>
</body>
</html>