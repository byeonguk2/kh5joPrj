<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>1:1문의 - 농라</title>
<link rel="stylesheet" href="/nongra/resources/css/board/contact/notice/notice_list.css">
<link rel="stylesheet" href="/nongra/resources/css/board/contact/faq/faq_own_list.css">
<link rel="stylesheet" href="/nongra/resources/css/board/contact/qna/qna_own_list.css">
</head>
<body>
    <%@ include file="/WEB-INF/views/common/header/header_sobi.jsp" %>
    <main>
        <div class="section">
            <div class="section_name">고객센터</div>
            <!-- 1. 기능구현시, for문 돌리고, div선택하면 해당 div의 svg1을 270도 돌리면 됨 -->
            <!-- 2. 처음에 목록 15개 보여주고 더보기 클릭하면 10개씩 추가조회 기능추가 -->
            <ul class="menu_area">
                <li><a href="" class="menu_list">공지사항
                    <svg xmlns="http://www.w3.org/2000/svg" width="19" height="19" viewBox="0 0 24 24"><defs><path id="gfk9q0rhta" d="M1.657 1.657L9.657 1.657 9.657 9.657"></path></defs><g fill="none" fill-rule="evenodd"><g><g><g><g transform="translate(-339 -398) translate(0 386) translate(339 12) translate(4.69 6.343)"><use stroke="#666666" stroke-linecap="round" stroke-width="1.8" stroke-linejoin="round" transform="rotate(45 5.657 5.657)" xlink:href="#gfk9q0rhta"></use></g></g></g></g></g></svg>                
                </a></li>

                <li><a href="" class="menu_list">자주하는 질문
                    <svg xmlns="http://www.w3.org/2000/svg" width="19" height="19" viewBox="0 0 24 24"><defs><path id="gfk9q0rhta" d="M1.657 1.657L9.657 1.657 9.657 9.657"></path></defs><g fill="none" fill-rule="evenodd"><g><g><g><g transform="translate(-339 -398) translate(0 386) translate(339 12) translate(4.69 6.343)"><use stroke="#666666" stroke-linecap="round" stroke-width="1.8" stroke-linejoin="round" transform="rotate(45 5.657 5.657)" xlink:href="#gfk9q0rhta"></use></g></g></g></g></g></svg>
                </a></li>

                <li><a href="" class="active menu_list">1:1문의
                    <svg xmlns="http://www.w3.org/2000/svg" width="19" height="19" viewBox="0 0 24 24"><defs><path id="gfk9q0rhta" d="M1.657 1.657L9.657 1.657 9.657 9.657"></path></defs><g fill="none" fill-rule="evenodd"><g><g><g><g transform="translate(-339 -398) translate(0 386) translate(339 12) translate(4.69 6.343)"><use stroke="#754327" stroke-linecap="round" stroke-width="1.8" stroke-linejoin="round" transform="rotate(45 5.657 5.657)" xlink:href="#gfk9q0rhta"></use></g></g></g></g></g></svg>
                </a></li>
            </ul>
            <div class="btn_menu_cs"></div>
            <%@ include file="/WEB-INF/views/common/aside/aside_sobi_contact.jsp" %>
        </div>
        <div class="content_area">
            <div class="board_name">자주하는 질문</div>
            
            <div class="tab_area">
                <button type="button" class="on btn_faq_tab">문의내역확인</button>
                <button type="button" class="btn_faq_tab">문의하기</button>
            </div>

            <div class="count_result">
                전체 3건
            </div>

            <ul class="board_list">
                <li class="post_list">
                    <div class="post faq_change_cursor">
                        <span class="post_q">Q</span>
                        <span class="post_title_faq">
                            [배송일정] 배송 날짜와 시간을 지정할 수 있나요?
                        </span>
                        <span class="open_arrow">
                            <svg class="svg1" width="24" height="24" focusable="false" viewBox="0 0 16 16" aria-hidden="true" role="presentation" style="fill: rgb(136, 136, 136);"><path fill="#888888" fill-rule="nonzero" d="M11.057 8L5.53 13.529c-.26.26-.26.682 0 .942.26.26.682.26.942 0l6-6c.26-.26.26-.682 0-.942l-6-6c-.26-.26-.682-.26-.942 0-.26.26-.26.682 0 .942L11.057 8z"></path></svg>
                        </span>
                    </div>
                </li>

                <li class="post_list">
                    <div class="post faq_change_cursor">
                        <span class="post_q">Q</span>
                        <span class="post_title_faq">
                            [배송일정] 배송조회를 했는데 배송정보가 없다고 나와요.
                        </span>
                        <span class="open_arrow">
                            <svg class="svg1" width="24" height="24" focusable="false" viewBox="0 0 16 16" aria-hidden="true" role="presentation" style="fill: rgb(136, 136, 136);"><path fill="#888888" fill-rule="nonzero" d="M11.057 8L5.53 13.529c-.26.26-.26.682 0 .942.26.26.682.26.942 0l6-6c.26-.26.26-.682 0-.942l-6-6c-.26-.26-.682-.26-.942 0-.26.26-.26.682 0 .942L11.057 8z"></path></svg>
                        </span>
                    </div>
                    <div class="post_detail">
                        <p>
                            운송장 번호는 등록되어 있으나, 배송 정보가 없다고 안내되는 경우
                            주문 당일 상품을 발송하여 시스템에 운송장 번호가 아직 등록되지 않은 상황으로, 다음 날부터 배송조회가 가능합니다.
                            운송장 번호가 등록되지 않았으며, 배송 조회가 되지 않는 경우
                            일반 택배사 이외에 고속버스 배송 등 판매자가 개별 배송할 수 있습니다. 이와 같은 경우 배송조회가 불가능하므로 정확한 배송일정 및 현황은 아래의 경로를 따라 판매자에게 문의하시기 바랍니다.<br>
                            판매자에 문의하기: 마이페이지 → 주문목록 → 상품선택 → [‘판매자명’에 문의하기]
                        </p>
                    </div>
                </li>

                <li class="post_list">
                    <div class="post faq_change_cursor">
                        <span class="post_q">Q</span>
                        <span class="post_title_faq">
                            [배송일정] 배송 날짜와 시간을 지정할 수 있나요?
                        </span>
                        <span class="open_arrow">
                            <svg class="svg1" width="24" height="24" focusable="false" viewBox="0 0 16 16" aria-hidden="true" role="presentation" style="fill: rgb(136, 136, 136);"><path fill="#888888" fill-rule="nonzero" d="M11.057 8L5.53 13.529c-.26.26-.26.682 0 .942.26.26.682.26.942 0l6-6c.26-.26.26-.682 0-.942l-6-6c-.26-.26-.682-.26-.942 0-.26.26-.26.682 0 .942L11.057 8z"></path></svg>
                        </span>
                    </div>
                </li>

                <li class="post_list">
                    <div class="post faq_change_cursor">
                        <span class="post_q">Q</span>
                        <span class="post_title_faq">
                            [배송일정] 배송 날짜와 시간을 지정할 수 있나요?
                        </span>
                        <span class="open_arrow">
                            <svg class="svg1" width="24" height="24" focusable="false" viewBox="0 0 16 16" aria-hidden="true" role="presentation" style="fill: rgb(136, 136, 136);"><path fill="#888888" fill-rule="nonzero" d="M11.057 8L5.53 13.529c-.26.26-.26.682 0 .942.26.26.682.26.942 0l6-6c.26-.26.26-.682 0-.942l-6-6c-.26-.26-.682-.26-.942 0-.26.26-.26.682 0 .942L11.057 8z"></path></svg>
                        </span>
                    </div>
                </li>

                
                <li class="post_list">
                    <div class="post faq_change_cursor">
                        <span class="post_q">Q</span>
                        <span class="post_title_faq">
                            [배송일정] 배송 날짜와 시간을 지정할 수 있나요?
                        </span>
                        <span class="open_arrow">
                            <svg class="svg1" width="24" height="24" focusable="false" viewBox="0 0 16 16" aria-hidden="true" role="presentation" style="fill: rgb(136, 136, 136);"><path fill="#888888" fill-rule="nonzero" d="M11.057 8L5.53 13.529c-.26.26-.26.682 0 .942.26.26.682.26.942 0l6-6c.26-.26.26-.682 0-.942l-6-6c-.26-.26-.682-.26-.942 0-.26.26-.26.682 0 .942L11.057 8z"></path></svg>
                        </span>
                    </div>
                </li>

                
                <li class="post_list">
                    <div class="post faq_change_cursor">
                        <span class="post_q">Q</span>
                        <span class="post_title_faq">
                            [배송일정] 배송 날짜와 시간을 지정할 수 있나요?
                        </span>
                        <span class="open_arrow">
                            <svg class="svg1" width="24" height="24" focusable="false" viewBox="0 0 16 16" aria-hidden="true" role="presentation" style="fill: rgb(136, 136, 136);"><path fill="#888888" fill-rule="nonzero" d="M11.057 8L5.53 13.529c-.26.26-.26.682 0 .942.26.26.682.26.942 0l6-6c.26-.26.26-.682 0-.942l-6-6c-.26-.26-.682-.26-.942 0-.26.26-.26.682 0 .942L11.057 8z"></path></svg>
                        </span>
                    </div>
                </li>

                
                <li class="post_list">
                    <div class="post faq_change_cursor">
                        <span class="post_q">Q</span>
                        <span class="post_title_faq">
                            [배송일정] 배송 날짜와 시간을 지정할 수 있나요?
                        </span>
                        <span class="open_arrow">
                            <svg class="svg1" width="24" height="24" focusable="false" viewBox="0 0 16 16" aria-hidden="true" role="presentation" style="fill: rgb(136, 136, 136);"><path fill="#888888" fill-rule="nonzero" d="M11.057 8L5.53 13.529c-.26.26-.26.682 0 .942.26.26.682.26.942 0l6-6c.26-.26.26-.682 0-.942l-6-6c-.26-.26-.682-.26-.942 0-.26.26-.26.682 0 .942L11.057 8z"></path></svg>
                        </span>
                    </div>
                </li>

                
                <li class="post_list">
                    <div class="post faq_change_cursor">
                        <span class="post_q">Q</span>
                        <span class="post_title_faq">
                            [배송일정] 배송 날짜와 시간을 지정할 수 있나요?
                        </span>
                        <span class="open_arrow">
                            <svg class="svg1" width="24" height="24" focusable="false" viewBox="0 0 16 16" aria-hidden="true" role="presentation" style="fill: rgb(136, 136, 136);"><path fill="#888888" fill-rule="nonzero" d="M11.057 8L5.53 13.529c-.26.26-.26.682 0 .942.26.26.682.26.942 0l6-6c.26-.26.26-.682 0-.942l-6-6c-.26-.26-.682-.26-.942 0-.26.26-.26.682 0 .942L11.057 8z"></path></svg>
                        </span>
                    </div>
                </li>

                
                <li class="post_list">
                    <div class="post faq_change_cursor">
                        <span class="post_q">Q</span>
                        <span class="post_title_faq">
                            [배송일정] 배송 날짜와 시간을 지정할 수 있나요?
                        </span>
                        <span class="open_arrow">
                            <svg class="svg1" width="24" height="24" focusable="false" viewBox="0 0 16 16" aria-hidden="true" role="presentation" style="fill: rgb(136, 136, 136);"><path fill="#888888" fill-rule="nonzero" d="M11.057 8L5.53 13.529c-.26.26-.26.682 0 .942.26.26.682.26.942 0l6-6c.26-.26.26-.682 0-.942l-6-6c-.26-.26-.682-.26-.942 0-.26.26-.26.682 0 .942L11.057 8z"></path></svg>
                        </span>
                    </div>
                </li>

                
                <li class="post_list">
                    <div class="post faq_change_cursor">
                        <span class="post_q">Q</span>
                        <span class="post_title_faq">
                            [배송일정] 배송 날짜와 시간을 지정할 수 있나요?
                        </span>
                        <span class="open_arrow">
                            <svg class="svg1" width="24" height="24" focusable="false" viewBox="0 0 16 16" aria-hidden="true" role="presentation" style="fill: rgb(136, 136, 136);"><path fill="#888888" fill-rule="nonzero" d="M11.057 8L5.53 13.529c-.26.26-.26.682 0 .942.26.26.682.26.942 0l6-6c.26-.26.26-.682 0-.942l-6-6c-.26-.26-.682-.26-.942 0-.26.26-.26.682 0 .942L11.057 8z"></path></svg>
                        </span>
                    </div>
                </li>

                

                <div class="add_list">더보기
                    <svg class="svg2" width="14" height="14" focusable="false" viewBox="0 0 16 16" aria-hidden="true" role="presentation" style="fill: #754327;"><path fill="#754327" fill-rule="nonzero" d="M11.057 8L5.53 13.529c-.26.26-.26.682 0 .942.26.26.682.26.942 0l6-6c.26-.26.26-.682 0-.942l-6-6c-.26-.26-.682-.26-.942 0-.26.26-.26.682 0 .942L11.057 8z"></path></svg><path fill="#0051f5" fill-rule="nonzero" d="M11.057 8L5.53 13.529c-.26.26-.26.682 0 .942.26.26.682.26.942 0l6-6c.26-.26.26-.682 0-.942l-6-6c-.26-.26-.682-.26-.942 0-.26.26-.26.682 0 .942L11.057 8z"></path>
                </div>


            </ul>
        </div>
    </main>


</body>
</html>