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
<link rel="stylesheet" href="/nongra/resources/css/board/tip/tip_list.css">


</head>
<body>
	<div class="wrap_event">
		<%@ include file="/WEB-INF/views/common/header/header_sobi.jsp" %>
		<main>
			<div class="section">
				<div class="section_name">구매팁</div>
				<!-- 1. 기능구현시, for문 돌리고, div선택하면 해당 div의 svg1을 270도 돌리면 됨 -->
				<!-- 2. 처음에 목록 15개 보여주고 더보기 클릭하면 10개씩 추가조회 기능추가 -->
				<ul class="menu_area">
					<li><a href="" class="active menu_list">신선한 상품 고르는 팁
						<svg xmlns="http://www.w3.org/2000/svg" width="19" height="19" viewBox="0 0 24 24"><defs><path id="gfk9q0rhta" d="M1.657 1.657L9.657 1.657 9.657 9.657"></path></defs><g fill="none" fill-rule="evenodd"><g><g><g><g transform="translate(-339 -398) translate(0 386) translate(339 12) translate(4.69 6.343)"><use stroke="#754327" stroke-linecap="round" stroke-width="1.8" stroke-linejoin="round" transform="rotate(45 5.657 5.657)" xlink:href="#gfk9q0rhta"></use></g></g></g></g></g></svg>
					</a></li>
				</ul>
				<div class="btn_menu_cs"></div>
				<%@ include file="/WEB-INF/views/common/aside/aside_sobi_contact.jsp" %>
			</div>
			
			<div class="content_area">
				<div class="board_name">신선한 상품 고르는 팁</div>
				<ul class="event_ul">
					<li class="event_li">
						<a class="card_event">
							<div class="img_event_box">
								<img class="img_event" src="/nongra/resources/img/board/tip/tip_tomato01.png" alt="토마토01">
							</div>
							<p class="p_event p_tip">새콤 달짝 맛있는 토마토<br>
                                효능과 보관법 알아보기</p>						
						</a>
					</li>

					<li class="event_li">
						<a class="card_event">
							<div class="img_event_box">
								<img class="img_event" src="/nongra/resources/img/board/tip/tip_tomato01.png" alt="토마토01">
							</div>
							<p class="p_event p_tip">새콤 달짝 맛있는 토마토<br>
                                효능과 보관법 알아보기</p>						
						</a>
					</li>

					<li class="event_li">
						<a class="card_event">
							<div class="img_event_box">
								<img class="img_event" src="/nongra/resources/img/board/tip/tip_tomato01.png" alt="토마토01">
							</div>
							<p class="p_event p_tip">새콤 달짝 맛있는 토마토<br>
                                효능과 보관법 알아보기</p>						
						</a>
					</li>

					<li class="event_li">
						<a class="card_event">
							<div class="img_event_box">
								<img class="img_event" src="/nongra/resources/img/board/tip/tip_tomato01.png" alt="토마토01">
							</div>
							<p class="p_event p_tip">새콤 달짝 맛있는 토마토<br>
                                효능과 보관법 알아보기</p>						
						</a>
					</li>

					<li class="event_li">
						<a class="card_event">
							<div class="img_event_box">
								<img class="img_event" src="/nongra/resources/img/board/tip/tip_tomato01.png" alt="토마토01">
							</div>
							<p class="p_event p_tip">새콤 달짝 맛있는 토마토<br>
                                효능과 보관법 알아보기</p>						
						</a>
					</li>

					<li class="event_li">
						<a class="card_event">
							<div class="img_event_box">
								<img class="img_event" src="/nongra/resources/img/board/tip/tip_tomato01.png" alt="토마토01">
							</div>
							<p class="p_event p_tip">새콤 달짝 맛있는 토마토<br>
                                효능과 보관법 알아보기</p>						
						</a>
					</li>
					
				</ul>

				<div class="page_wrap_event">
					<div class="page_list_event">
						<div class="page_num_event">
							<a href="" class="page_on">1</a>
							<a href="">2</a>
							<a href="">3</a>
						</div>
					</div>
				</div>

			</div>
		</main>
		<footer>footer</footer>
	</div>
</body>
</html>