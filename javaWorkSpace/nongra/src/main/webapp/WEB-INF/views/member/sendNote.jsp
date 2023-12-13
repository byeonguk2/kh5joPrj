<%@page import="com.kh.app.seller.vo.SellerNoteVo"%>
<%@page import="java.util.List"%>
<%@page import="java.util.Map"%>
<%@page import="com.kh.app.page.vo.PageVo"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
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
<link rel="stylesheet"
	href="/nongra/resources/css/member/member_mypage.css">
<link rel="stylesheet" href="/nongra/resources/css/common/cssReset.css">
<link rel="stylesheet"
	href="/nongra/resources/css/orderDetail/userOrderDetail.css">

<style>
	#wrap{
		width : 100%;
	}
	#main-area{
	display: grid;
	grid-template-columns: 230px 8fr;
	padding-top: ;
	}
	#headerer{
		display: flex;
		align-items: center;
		justify-content: center;
	}
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
        width: 80px;
        height: 40px;
        font-weight: bolder;
        border-radius: 6px;
    }
    
    .send-bottom-area > button:nth-child(4){
        width: 60px;
        height: 40px;
        background-color: dimgray;
    }
	.page-area *{
		margin-left : 10px;
	}

    .currentPage{
    	text-decoration: underline;
    }
		
	</style>
</head>
<body>

	<div id="wrap1">
		<%@ include file="/WEB-INF/views/common/header/header_sobi.jsp"%>
		<main>
			<%@ include file="/WEB-INF/views/common/aside/aside_sobi_main.jsp"%>
			<div class="content-area">
				<div class="h1-area">
					<h1>보낸쪽지</h1>
				</div>
				<div class="send">
					<div class="send-area">
						<div class="send-top-area">
							<div class="send-check-area">
								<span>전체 <%= pvo.getListCount() %></span>
							</div>
							<div class="send-search-area">
								<select name="search">
									<option name="search" value="title">제목</option>
									<option name="search" value="content">내용</option>
								</select>
								<div>
									<input name="searchName" type="search" placeholder="검색">
								</div>
								<button onclick="search();">검색</button>
							</div>
						</div>	
						<table class="table">
							<thead>
								<tr>
									<td></td>
									<th><span>제목</span></th>
									<th><span>내용</span></th>
									<th><span>받는사람</span></th>
									<th><span>보낸일시</span></th>
								</tr>
							</thead>
							<tbody>
								<% for (SellerNoteVo sellerNote : sendNoteList) { %>
								    <tr>
                                        <td><input name="checkbox" type="radio" value="<%=sellerNote.getNoteNo()%>"></td>
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
									<a href="/nongra/member/sendNote?pno=<%= pvo.getStartPage() - 1%>">이전</a>
								<%} %>
								
								<% for(int i = pvo.getStartPage(); i<= pvo.getEndPage(); i++){%>
									
									<%if(i == pvo.getCurrentPage()){ %>
                                        <span class="currentPage"><%= i %></span>
									<%}else{ %>
										<a href="/nongra/member/sendNote?pno=<%= i %>"><%= i %></a>
									<%} %>
									
								<%} %>
								
								<% if(pvo.getEndPage() != pvo.getMaxPage()){ %>
									<a href="/nongra/member/sendNote?pno=<%= pvo.getEndPage() + 1%>">다음</a>
								<%} %>
							</div>
							<button onclick="openPopup();">작성하기</button>
                            <button onclick="viewDetails();">쪽지보기</button>
							<button onclick="deleteNote();">삭제</button>
						</div>
					</div>
				</div>
			</div>
		</main>

	</div>
</body>
</html>
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
	function deleteNote() {
		const radioButtons = document.querySelector("input[name=checkbox]:checked").value;
		console.log(radioButtons);
		
        fetch("/nongra/sendNote/delete?noteNo="+ radioButtons)
            .then((resp) => resp.text())
            .then((data) => {
                console.log(data);
            })
            .catch(() => {
                console.log("에러발생");
            });
        window.location.reload();
    }

    function openPopup() {
        let options = "toolbar=no,scrollbars=no,resizable=yes,status=no,menubar=no,width=800,height=800,top=0,left=0";

        if (newWindow && !newWindow.closed) {
            newWindow.close();
        }

        newWindow = window.open("/nongra/member/note/write", "쪽지작성", options);

        newWindow.addEventListener('beforeunload', function () {
            newWindow = null; // 창이 닫혔으므로 참조 제거
        });
    }

    function viewDetails() {
        const radioButtons = document.querySelectorAll("input[name=checkbox]:checked");

        if (radioButtons.length === 1) {
            const noteNo = radioButtons[0].value;
            // 선택된 쪽지 번호에 기반하여 세부 내용을 보여주는 페이지로 리다이렉트 또는 모달 표시 로직을 구현합니다.
            window.location.href = "/nongra/member/sendNote/detail?noteNo=" + noteNo;
        } else {
            // 아무 라디오 버튼도 선택되지 않았을 경우 알림이나 메시지를 표시합니다.
            alert("세부 내용을 보려면 쪽지를 선택하세요.");
        }
        
    }
	function search(){
		
		const searchName = document.querySelector('input[name=searchName]').value;
		const searchValue = document.querySelector('select[name=search]').value;
		window.location.href = '/nongra/seller/note/send/search?search='+ searchValue + '&searchName='+ searchName;
	}

	
</script>
