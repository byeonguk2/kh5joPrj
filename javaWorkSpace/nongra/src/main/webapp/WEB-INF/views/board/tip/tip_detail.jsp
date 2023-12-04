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
<link rel="stylesheet" href="/nongra/resources/css/board/contact/qna/qna_own_write.css">
<link rel="stylesheet" href="/nongra/resources/css/board/event/event_detail.css">
<link rel="stylesheet" href="/nongra/resources/css/board/tip/tip_detail.css">



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
				<div class="board_name">구매팁</div>
				<div class="event_detail">
                    <div class="tip_title">
                        <p class="t_title"><strong>새콤 달짝 맛있는 토마토 효능과 보관법 알아보기</strong></p>
                    </div>

                    <div class="tip_content">
                        <p>
                            <img src="/nongra/resources/img/board/tomato01.png" alt="토마토" width="200px">
                        </p>
                        <p>
                            우선 토마토 한개에 우리의 하루 섭취 권장량의 절반가량이 들어있을 정도로
                        풍부한 비타민 C가 함유되어 있어요! <br>
                        <br>
                        ​그외에도 구연산, 아미노산, 칼슘, 철 , 식이섬유 등 셀수 없는 영양성분이~<br>
                        하지만 무엇보다도 토마토의 효능 중 가장 손꼽히는 것은 ​항암효과!<br>
                        <br>
                        토마토의 붉은색을 내게 하는 라이코펜은 강력한 항산화 물질 중 하나로<br>
                        ​암 발생 주성분인 활성산소를 제거하고 세포 노화와 산화를 방지해준다고 합니다.<br>
                        전립선암이나 위암 유방암 등을 예방하는 효과가 있다고 많이 알려져 있어요~​<br>
                        </p>
                    </div>
                </div>

                <div class="event_btn_wrap">
                    <a href="" class="btn_to_list"><span>목 록</span></a>
                </div>

			</div>
		</main>
		<footer>footer</footer>
	</div>
</body>
</html>