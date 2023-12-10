<%@page import="com.kh.app.board.event.vo.EventFileVo"%>
<%@page import="java.util.List"%>
<%@page import="com.kh.app.board.event.vo.EventVo"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
	<%
	
	List<EventVo> voList = (List<EventVo>) request.getAttribute("voList");
	String currPage =(String) request.getAttribute("currPage");
	
	List<EventFileVo> fileVoList = voList.get(0).getFileVoList();
	%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" href="/nongra/resources/css/board/event/event_list.css">
<link rel="stylesheet" href="/nongra/resources/css/board/contact/notice/notice_list.css">
<link rel="stylesheet" href="/nongra/resources/css/board/event/event_scheduled_list.css">
<link rel="stylesheet" href="/nongra/resources/css/board/contact/qna/qna_own_write.css">
<link rel="stylesheet" href="/nongra/resources/css/board/event/event_detail.css">

</head>
<body>
	<div class="wrap_event">
		<%@ include file="/WEB-INF/views/common/header/header_sobi.jsp" %>
		<main>
			<div class="section">
				<div class="section_name">이벤트</div>
				<!-- 1. 기능구현시, for문 돌리고, div선택하면 해당 div의 svg1을 270도 돌리면 됨 -->
				<ul class="menu_area">
					<li><a href="" class="menu_list">진행예정 이벤트
						<svg xmlns="http://www.w3.org/2000/svg" width="19" height="19" viewBox="0 0 24 24"><defs><path id="gfk9q0rhta" d="M1.657 1.657L9.657 1.657 9.657 9.657"></path></defs><g fill="none" fill-rule="evenodd"><g><g><g><g transform="translate(-339 -398) translate(0 386) translate(339 12) translate(4.69 6.343)"><use stroke="#666666" stroke-linecap="round" stroke-width="1.8" stroke-linejoin="round" transform="rotate(45 5.657 5.657)" xlink:href="#gfk9q0rhta"></use></g></g></g></g></g></svg>
					</a></li>
		
					<li><a href="" class="active menu_list">진행중인 이벤트
						<svg xmlns="http://www.w3.org/2000/svg" width="19" height="19" viewBox="0 0 24 24"><defs><path id="gfk9q0rhta" d="M1.657 1.657L9.657 1.657 9.657 9.657"></path></defs><g fill="none" fill-rule="evenodd"><g><g><g><g transform="translate(-339 -398) translate(0 386) translate(339 12) translate(4.69 6.343)"><use stroke="#754327" stroke-linecap="round" stroke-width="1.8" stroke-linejoin="round" transform="rotate(45 5.657 5.657)" xlink:href="#gfk9q0rhta"></use></g></g></g></g></g></svg>
					</a></li>
		
					<li><a href="" class="menu_list">종료된 이벤트
						<svg xmlns="http://www.w3.org/2000/svg" width="19" height="19" viewBox="0 0 24 24"><defs><path id="gfk9q0rhta" d="M1.657 1.657L9.657 1.657 9.657 9.657"></path></defs><g fill="none" fill-rule="evenodd"><g><g><g><g transform="translate(-339 -398) translate(0 386) translate(339 12) translate(4.69 6.343)"><use stroke="#666666" stroke-linecap="round" stroke-width="1.8" stroke-linejoin="round" transform="rotate(45 5.657 5.657)" xlink:href="#gfk9q0rhta"></use></g></g></g></g></g></svg>
					</a></li>
				</ul>
				<div class="btn_menu_cs"></div>
				<%@ include file="/WEB-INF/views/common/aside/aside_sobi_contact.jsp" %>
			</div>
			
			<div class="content_area">
				<div class="board_name">이벤트</div>
				<div class="event_detail">
                    <div class="event_title">
                        <p class="e_title"><%=voList.get(0).getTitle() %></p>
                        <p class="e_date">기간 <%=voList.get(0).getStartDate() %> ~ <%=voList.get(0).getEndDate() %></p>
                    </div>

                    <div class="event_content">
                        <p>
                        <% for(EventFileVo fileVo : fileVoList) { %>
                            <img src="/nongra/resources/img/board/event/<%=fileVo.getFileName() %>" alt="<%=fileVo.getFileName() %>">
                            <!-- 반복문 추가할것 mainY안뜨게  -->
                        <% } %>
                        </p>
                    </div>
                </div>

                <div class="event_btn_wrap">
                    <a href="/nongra/event/list" class="btn_to_list"><span>이벤트 목록</span></a>
                </div>

			</div>
		</main>
		<footer>footer</footer>
	</div>
</body>
</html>