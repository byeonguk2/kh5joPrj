<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>	
<link rel="stylesheet" href="/nongra/resources/css/admin/board/manage_style.css">
</head>
<body>
	<div id="wrap">
		<%@ include file="/WEB-INF/views/common/header/header_admin.jsp" %>
		<div id = "main-area">
			<%@ include file="/WEB-INF/views/common/aside/aside_admin.jsp" %>
			<form action="" method="post">
				<div class="form_above">
					<div class="select_search_area">
						<h2>공지사항 관리</h2>
						<div class="select_div">
							<span>• 읽기권한</span>
								<div><input name="a" type="radio" value="판매자" checked="true">판매자</div>
								<div><input name="a" type="radio" value="판매자">소비자</div>
						</div>
						<div class="search_div">
							<span>• 글 검색 </span>
								<input type="text">
								<button>검색</button>
						</div>
					</div>
					<div class="btn_area">
                            <div></div>
                            <div></div>
                            <div></div>
                            <div></div>
                            <div></div>
                            <div>
                                <a href="/nongra/admin/notice/write" class="a_write_btn">글 작성</a>
                            </div>
                    </div>
				</div>
				<div class="table-area-noti">
					<table>
						<thead>
							<tr>
								<th>상단<br>노출</th>
								<th>번호</th>
								<th>읽기<br>권한</th>
								<th>제목</th>
								<th>작성자</th>
								<th>상태</th>
								<th>생성일자</th>
								<th>수정일자</th>
                                <th>수정</th>
							</tr>
						</thead>
						<tbody>
							<tr>
								<th>V</th>
								<td>10</td>
								<td>판매자</td>
								<td>공지사항공지사항공지사항공지사항</td>
								<td>관리자01</td>
								<td>공개</td>
								<td>2023/11/23 17:01:11</td>
                                <td>2023/11/23 17:05:11</td>
								<td><button type="button" class="noti-btn" onclick="open.window()">수정</button></td>
							</tr>
							<tr>
								<th>V</th>
								<td>10</td>
								<td>판매자</td>
								<td>공지사항공지사항공지사항공지사항</td>
								<td>관리자01</td>
								<td>공개</td>
								<td>2023/11/23 17:01:11</td>
                                <td>2023/11/23 17:05:11</td>
								<td><button type="button" class="noti-btn" onclick="open.window()">수정</button></td>
							</tr>
							<tr>
								<th>V</th>
								<td>10</td>
								<td>판매자</td>
								<td>공지사항공지사항공지사항공지사항</td>
								<td>관리자01</td>
								<td>공개</td>
								<td>2023/11/23 17:01:11</td>
                                <td>2023/11/23 17:05:11</td>
								<td><button type="button" class="noti-btn" onclick="open.window()">수정</button></td>
							</tr>
							<tr>
								<th>V</th>
								<td>10</td>
								<td>판매자</td>
								<td>공지사항공지사항공지사항공지사항</td>
								<td>관리자01</td>
								<td>공개</td>
								<td>2023/11/23 17:01:11</td>
                                <td>2023/11/23 17:05:11</td>
								<td><button type="button" class="noti-btn" onclick="open.window()">수정</button></td>
							</tr>
							<tr>
								<th>V</th>
								<td>10</td>
								<td>판매자</td>
								<td>공지사항공지사항공지사항공지사항</td>
								<td>관리자01</td>
								<td>공개</td>
								<td>2023/11/23 17:01:11</td>
                                <td>2023/11/23 17:05:11</td>
								<td><button type="button" class="noti-btn" onclick="open.window()">수정</button></td>
							</tr>
							<tr>
								<th>V</th>
								<td>10</td>
								<td>판매자</td>
								<td>공지사항공지사항공지사항공지사항</td>
								<td>관리자01</td>
								<td>공개</td>
								<td>2023/11/23 17:01:11</td>
                                <td>2023/11/23 17:05:11</td>
								<td><button type="button" class="noti-btn" onclick="open.window()">수정</button></td>
							</tr>
							<tr>
								<th>V</th>
								<td>10</td>
								<td>판매자</td>
								<td>공지사항공지사항공지사항공지사항</td>
								<td>관리자01</td>
								<td>비공개</td>
								<td>2023/11/23 17:01:11</td>
                                <td>2023/11/23 17:05:11</td>
								<td><button type="button" class="noti-btn" onclick="open.window()">수정</button></td>
							</tr>
							<tr>
								<th>V</th>
								<td>10</td>
								<td>판매자</td>
								<td>공지사항공지사항공지사항공지사항</td>
								<td>관리자01</td>
								<td>공개</td>
								<td>2023/11/23 17:01:11</td>
                                <td>2023/11/23 17:05:11</td>
								<td><button type="button" class="noti-btn" onclick="open.window()">수정</button></td>
							</tr>
							<tr>
								<th>V</th>
								<td>10</td>
								<td>소비자</td>
								<td>공지사항공지사항공지사항공지사항</td>
								<td>관리자01</td>
								<td>공개</td>
								<td>2023/11/23 17:01:11</td>
                                <td>2023/11/23 17:05:11</td>
								<td><button type="button" class="noti-btn" onclick="open.window()">수정</button></td>
							</tr>
							<tr>
								<th>V</th>
								<td>10</td>
								<td>소비자</td>
								<td>공지사항공지사항공지사항공지사항</td>
								<td>관리자01</td>
								<td>공개</td>
								<td>2023/11/23 17:01:11</td>
                                <td>2023/11/23 17:05:11</td>
								<td><button type="button" class="noti-btn" onclick="open.window()">수정</button></td>
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
		x.innerHTML = "게시판 관리";
		menu1.innerHTML = "공지사항 관리";
		menu1.href = "/nongra/admin/notice/manage";
		menu2.innerHTML = "FAQ 관리";
        menu2.href = "/nongra/admin/faq/manage";
		menu3.innerHTML = "1:1문의(판매자) 관리";
		menu3.href = "/nongra/admin/member/request";

      
		const menu4 = document.querySelector(" aside > :nth-child(5) > a ");
		const menu5 = document.querySelector(" aside > :nth-child(6) > a ");
		const menu6 = document.querySelector(" aside > :nth-child(7) > a ");
		
		menu4.innerHTML = "1:1문의(소비자 관리)";
		menu4.href = "/nongra/admin/notice/manage";
		menu5.innerHTML = "이벤트 관리";
        menu5.href = "/nongra/admin/faq/manage";
		menu6.innerHTML = "구매팁 관리";
		menu6.href = "/nongra/admin/member/request";
		}
		createAsideLetter()
		
		
	</script>
</body>
</html>