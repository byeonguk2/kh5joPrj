<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" href="/nongra/resources/css/board/event/event_write.css">
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
            
            <!-- 본문 -->
            
			<div class="content_event">
                <div class="title_event_board">이벤트</div>
                <table class="event_table">
                    <tr>
                        <td>시작일시</td>
                        <td>인풋</td>
                        <td>종료일시</td>
                        <td>인풋</td>
                    </tr>
                    <tr>
                        <td>제목</td>
                        <td colspan="3">인풋</td>
                    </tr>
                    <tr>
                        <td>내용</td>
                        <td colspan="3">인풋</td>
                    </tr>
                    <tr>
                        <td>이미지첨부</td>
                        <td colspan="3">인풋</td>
                    </tr>
                </table>
                

                <div>
                    <button>취소</button>
                    <button>등록</button>
                </div>
                 
			</div>
            <!-- 본문 -->



		</main>
		<footer>footer</footer>
	</div>
</body>
</html>