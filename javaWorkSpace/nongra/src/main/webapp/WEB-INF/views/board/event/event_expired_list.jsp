<%@page import="com.kh.app.page.vo.PageVo"%>
<%@page import="com.kh.app.board.event.vo.EventVo"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" href="/nongra/resources/css/board/event/event_list.css">
<link rel="stylesheet" href="/nongra/resources/css/board/contact/notice/notice_list.css">
<link rel="stylesheet" href="/nongra/resources/css/board/event/event_scheduled_list.css">
	<% 
		List<EventVo> eventVoList = (List<EventVo>) request.getAttribute("eventVoList");
		PageVo pvo = (PageVo) request.getAttribute("pvo");
	%>
</head>
<body>
	<div class="wrap_event">
		<%@ include file="/WEB-INF/views/common/header/header_sobi.jsp" %>
		<main>
			<div class="section">
				<div class="section_name">이벤트</div>
				<!-- 1. 기능구현시, for문 돌리고, div선택하면 해당 div의 svg1을 270도 돌리면 됨 -->
				<!-- 2. 처음에 목록 15개 보여주고 더보기 클릭하면 10개씩 추가조회 기능추가 -->
				<ul class="menu_area">
					<li><a href="/nongra/event/scheduled" class="menu_list">진행예정 이벤트
						<svg xmlns="http://www.w3.org/2000/svg" width="19" height="19" viewBox="0 0 24 24"><defs><path id="gfk9q0rhta" d="M1.657 1.657L9.657 1.657 9.657 9.657"></path></defs><g fill="none" fill-rule="evenodd"><g><g><g><g transform="translate(-339 -398) translate(0 386) translate(339 12) translate(4.69 6.343)"><use stroke="#666666" stroke-linecap="round" stroke-width="1.8" stroke-linejoin="round" transform="rotate(45 5.657 5.657)" xlink:href="#gfk9q0rhta"></use></g></g></g></g></g></svg>
					</a></li>
		
					<li><a href="/nongra/event/list" class="menu_list">진행중인 이벤트
						<svg xmlns="http://www.w3.org/2000/svg" width="19" height="19" viewBox="0 0 24 24"><defs><path id="gfk9q0rhta" d="M1.657 1.657L9.657 1.657 9.657 9.657"></path></defs><g fill="none" fill-rule="evenodd"><g><g><g><g transform="translate(-339 -398) translate(0 386) translate(339 12) translate(4.69 6.343)"><use stroke="#666666" stroke-linecap="round" stroke-width="1.8" stroke-linejoin="round" transform="rotate(45 5.657 5.657)" xlink:href="#gfk9q0rhta"></use></g></g></g></g></g></svg>
					</a></li>
		
					<li><a href="/nongra/event/expired" class="active menu_list">종료된 이벤트
						<svg xmlns="http://www.w3.org/2000/svg" width="19" height="19" viewBox="0 0 24 24"><defs><path id="gfk9q0rhta" d="M1.657 1.657L9.657 1.657 9.657 9.657"></path></defs><g fill="none" fill-rule="evenodd"><g><g><g><g transform="translate(-339 -398) translate(0 386) translate(339 12) translate(4.69 6.343)"><use stroke="#754327" stroke-linecap="round" stroke-width="1.8" stroke-linejoin="round" transform="rotate(45 5.657 5.657)" xlink:href="#gfk9q0rhta"></use></g></g></g></g></g></svg>
					</a></li>
				</ul>
				<div class="btn_menu_cs"></div>
				<%@ include file="/WEB-INF/views/common/aside/aside_sobi_contact.jsp" %>
			</div>
			
			<div class="content_area">
				<div class="board_name">종료된 이벤트</div>
				<ul class="event_ul">
				<% for(EventVo vo : eventVoList){ %>
					<li class="event_li">
						<a class="card_event">
							<div class="img_event_box">
								<img class="img_event" src="/nongra/resources/img/board/event/<%=vo.getFileName() %>.png" alt="<%=vo.getFileName() %>">
							</div>
							<p class="p_event"><%=vo.getTitle() %></p>
							<span class="date_event">
								<%=vo.getStartDate() %> ~ <%=vo.getEndDate() %>
							</span>
						</a>
					</li>
					<% } %>
				</ul>

				<div class="page_wrap_event">
					<div class="page_list_event">
						<div class="page_num_event">
							<% if(pvo.getStartPage() != 1){ %>
							<a href="/nongra/event/expired?pno=<%=pvo.getStartPage()-1 %>"> < </a>
							<% } %>
							<% for(int i = pvo.getStartPage(); i <= pvo.getEndPage(); i++){ %>
									<a href="/nongra/event/expired?pno=<%=i %>" class="page_on"><%=i %></a>
							<% } %>
							<% if(pvo.getEndPage() != pvo.getMaxPage()){ %>
								<a href="/nongra/event/expired?pno=<%=pvo.getEndPage()+1 %>"> > </a>
							<% } %>
						</div>
					</div>
				</div>

			</div>
		</main>
		<footer>footer</footer>
	</div>
</body>
</html>