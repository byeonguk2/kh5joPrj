<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" href="/nongra/resources/css/board/event/sidebar_event.css">
</head>
<body>
	<section>
        <div class="board_name">이벤트</div>
        <div class="menu_list">
            <div class="menu1"><a href="">진행예정 이벤트</a></div>
            <div class="menu2"><a href="">진행중인 이벤트</a></div>
            <div class="menu3"><a href="">종료된 이벤트</a></div>
        </div>
        <div id="blank_under_menu">
            <br>
        </div>
        <div>
            <%@ include file="/WEB-INF/views/common/aside/aside_sobi_contact.jsp"%>
        </div>
    </section>
</body>
</html>