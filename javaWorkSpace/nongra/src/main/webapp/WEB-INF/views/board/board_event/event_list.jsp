<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" href="/nongra/resources/css/board/event/event_list.css">
</head>
<body>
	<div class="wrap_event">
		<%@ include file="/WEB-INF/views/common/header/header_sobi.jsp" %>
		<main>
			<aside>
				<%@ include file="/WEB-INF/views/board/board_event/sidebar_event.jsp" %>
			</aside>
			<div class="btw_side_content">
			</div>
			<div class="content_event">
				<div class="title_event_board">이벤트</div>
				<ul>
					<li>
						<div class="card_event">
							<div class="img_event">
								<img src="/nongra/resources/img/board/event01.png" alt="이벤트01">
							</div>
							<div class="text_event">
								<h3>김장하는날 (11/01 ~ 11/30)</h3>
								<!-- 디비에서 날짜 나눠서 가져오게 설정? -->
							</div>
						</div>
						<div class="card_event">
							<div class="img_event">
								<img src="/nongra/resources/img/board/event01.png" alt="이벤트01">
							</div>
							<div class="text_event">
								<h3>김장하는날 (11/01 ~ 11/30)</h3>
							</div>
						</div>
						<div class="card_event">
							<div class="img_event">
								<img src="/nongra/resources/img/board/event01.png" alt="이벤트01">
							</div>
							<div class="text_event">
								<h3>김장하는날 (11/01 ~ 11/30)</h3>
							</div>
						</div>
						<div class="card_event">
							<div class="img_event">
								<img src="/nongra/resources/img/board/event01.png" alt="이벤트01">
							</div>
							<div class="text_event">
								<h3>김장하는날 (11/01 ~ 11/30)</h3>
							</div>
						</div>
					</ul>
			</div>
		</main>
		<footer>footer</footer>
	</div>
</body>
</html>