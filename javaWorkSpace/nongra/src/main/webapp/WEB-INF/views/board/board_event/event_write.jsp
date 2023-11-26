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
			<div class="content_event">
				<div class="title_event_board">이벤트</div>
                <div id="title_event_detail">새콤 달짝 맛있는 토마토 효능과 보관법 알아보기</div>
                <div id="content_event_detail">
                    <img src="/nongra/resources/img/board/tomato01.png" alt="토마토">
                    <div>
                        <pre>
                        우선 토마토 한개에 우리의 하루 섭취 권장량의 절반가량이 들어있을 정도로
                        풍부한 비타민 C가 함유되어 있어요!
                        
                        ​그외에도 구연산, 아미노산, 칼슘, 철 , 식이섬유 등 셀수 없는 영양성분이~
                        하지만 무엇보다도 토마토의 효능 중 가장 손꼽히는 것은 ​항암효과!
                        
                        토마토의 붉은색을 내게 하는 라이코펜은 강력한 항산화 물질 중 하나로
                        ​암 발생 주성분인 활성산소를 제거하고 세포 노화와 산화를 방지해준다고 합니다.
                        전립선암이나 위암 유방암 등을 예방하는 효과가 있다고 많이 알려져 있어요~​
                        </pre>
                            
                        
                        </div>
                </div>
                 
			</div>
		</main>
		<footer>footer</footer>
	</div>
</body>
</html>