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
    <div id="wrap_board">
    <%@ include file="/WEB-INF/views/common/header/header_sobi.jsp" %>
    <main>
        <div class="section">
            <div class="section_name">고객센터</div>
            <!-- 1. 기능구현시, for문 돌리고, div선택하면 해당 div의 svg1을 270도 돌리면 됨 -->
            <!-- 2. 처음에 목록 15개 보여주고 더보기 클릭하면 10개씩 추가조회 기능추가 -->
            <ul class="menu_area">
                <li><a href="/nongra/contact/notice" class="menu_list">공지사항
                    <svg xmlns="http://www.w3.org/2000/svg" width="19" height="19" viewBox="0 0 24 24"><defs><path id="gfk9q0rhta" d="M1.657 1.657L9.657 1.657 9.657 9.657"></path></defs><g fill="none" fill-rule="evenodd"><g><g><g><g transform="translate(-339 -398) translate(0 386) translate(339 12) translate(4.69 6.343)"><use stroke="#666666" stroke-linecap="round" stroke-width="1.8" stroke-linejoin="round" transform="rotate(45 5.657 5.657)" xlink:href="#gfk9q0rhta"></use></g></g></g></g></g></svg>                
                </a></li>

                <li><a href="/nongra/contact/faq" class="menu_list">자주하는 질문
                    <svg xmlns="http://www.w3.org/2000/svg" width="19" height="19" viewBox="0 0 24 24"><defs><path id="gfk9q0rhta" d="M1.657 1.657L9.657 1.657 9.657 9.657"></path></defs><g fill="none" fill-rule="evenodd"><g><g><g><g transform="translate(-339 -398) translate(0 386) translate(339 12) translate(4.69 6.343)"><use stroke="#666666" stroke-linecap="round" stroke-width="1.8" stroke-linejoin="round" transform="rotate(45 5.657 5.657)" xlink:href="#gfk9q0rhta"></use></g></g></g></g></g></svg>
                </a></li>

                <li><a href="/nongra/contact/inquiry" class="active menu_list">1:1문의
                    <svg xmlns="http://www.w3.org/2000/svg" width="19" height="19" viewBox="0 0 24 24"><defs><path id="gfk9q0rhta" d="M1.657 1.657L9.657 1.657 9.657 9.657"></path></defs><g fill="none" fill-rule="evenodd"><g><g><g><g transform="translate(-339 -398) translate(0 386) translate(339 12) translate(4.69 6.343)"><use stroke="#754327" stroke-linecap="round" stroke-width="1.8" stroke-linejoin="round" transform="rotate(45 5.657 5.657)" xlink:href="#gfk9q0rhta"></use></g></g></g></g></g></svg>
                </a></li>
            </ul>
            <div class="btn_menu_cs"></div>
            <%@ include file="/WEB-INF/views/common/aside/aside_sobi_contact.jsp" %>
        </div>
        <div class="content_area">
            <div class="board_name">1:1문의</div>
                
            <div class="tab_area">
                <button type="button" class="on btn_faq_tab" onclick="location.href='/nongra/contact/inquiry'">문의내역확인</button>
                <button type="button" class="btn_faq_tab" onclick="location.href='/nongra/contact/inquiry/write'">문의하기</button>
            </div>

            <div class="count_result">
                <div>
                    전체
                    <!-- 작성된 문의 건수 노출 -->
                    <strong>3 </strong>
                    건
                </div>
            </div>

            <ul class="board_list">
                <li class="post_list">
                    <a href="">
                        <div class="qna_change_cursor">
                            <div class="qna_list_box1">답변예정</div>
                            <div class="qna_list_box2">최소/환불 - 환불</div>
                            <div class="qna_list_box3">
                               꽃게 3kg 주문 취소하고 싶습니다.
                            </div>
                            <div class="qna_list_box4">2023.11.20</div>
                            <div class="qna_list_box5">
                                <svg class="svg_qna" width="19" height="19" focusable="false" viewBox="0 0 16 16" aria-hidden="true" role="presentation" style="fill: rgb(136, 136, 136);"><path fill="#888888" fill-rule="nonzero" d="M11.057 8L5.53 13.529c-.26.26-.26.682 0 .942.26.26.682.26.942 0l6-6c.26-.26.26-.682 0-.942l-6-6c-.26-.26-.682-.26-.942 0-.26.26-.26.682 0 .942L11.057 8z"></path></svg>
                            </div>
                        </div>
                    </a>                        
                </li>

                <li class="post_list">
                    <a href="">
                        <div class="qna_change_cursor">
                            <div class="qna_list_box1">답변완료</div>
                            <div class="qna_list_box2">배송-배송상태 이의제기</div>
                            <div class="qna_list_box3">
                                파손되어 배송되었습니다.
                            </div>
                            <div class="qna_list_box4">2023.08.15</div>
                            <div class="qna_list_box5">
                                <svg class="svg_qna" width="19" height="19" focusable="false" viewBox="0 0 16 16" aria-hidden="true" role="presentation" style="fill: rgb(136, 136, 136);"><path fill="#888888" fill-rule="nonzero" d="M11.057 8L5.53 13.529c-.26.26-.26.682 0 .942.26.26.682.26.942 0l6-6c.26-.26.26-.682 0-.942l-6-6c-.26-.26-.682-.26-.942 0-.26.26-.26.682 0 .942L11.057 8z"></path></svg>
                            </div>
                        </div>
                    </a>
                    <div class="qna_detail">
                        <div class="question_area">
                            <div class="question_box1">문의</div>
                            <div class="question_box2">
                                <div class="">
                                    <img src="/nongra/resources/img/board/qna_product01.png" alt="상품이미지">
                                </div>
                                <div class="">
                                    [멋쟁이 토마토 마켓]  <br>
                                    멋쟁이 토마토 5kg 1박스 <br>
                                    결제금액 24,900원
                                </div>
                                <div class="">
                                    주문번호 : 20230808080831 <br>
                                    (결제일 : 2023.08.08)       
                                </div>
                                <div class="">
                                    안녕하세요. 엊그제 한빛농산에서 판매하는 토마토를 오늘 받았습니다. <br>
                                    배송은 빨리 보내주셨는데 터진 토마토가 너무 많네요.. 사진 첨부 했고, 어떻게 처리 가능한 지 문의드립니다. <br>
                                    감사합니다.<br>
                                    <img src="/nongra/resources/img/board/qna_question01.png" alt="문의이미지">
                                </div>
                            </div>
                        </div>
                        <div class="btw_qna">
                        </div>
                        <div class="answer_area">
                            <div class="answer_box1">답변</div>
                            <div class="answer_box2">
                                상품의 파손, 불량, 오배송 등 상품이 표기/광고내용과 다르거나 계약내용과 다른 경우, <br>
                                상품을 받으신 날부터 3개월 이내, 또는 사실을 알게된 날(알 수 있었던 날)부터 30일 이내에 교환 및 반품 신청이 가능합니다.  <br>
                                주문/배송 조회 통해 직접 접수해주시거나, 접수가 불가한 경우 고객센터로 문의주시면 빠르게 도움드리겠습니다. <br>
                            </div>
                        </div>                          
                    </div>
                </li>

                <li class="post_list">
                    <a href="">
                        <div class="qna_change_cursor">
                            <div class="qna_list_box1">답변완료</div>
                            <div class="qna_list_box2">배송-배송상태 이의제기</div>
                            <div class="qna_list_box3">
                                파손되어 배송되었습니다.
                            </div>
                            <div class="qna_list_box4">2023.11.20</div>
                            <div class="qna_list_box5">
                                <svg class="svg_qna" width="19" height="19" focusable="false" viewBox="0 0 16 16" aria-hidden="true" role="presentation" style="fill: rgb(136, 136, 136);"><path fill="#888888" fill-rule="nonzero" d="M11.057 8L5.53 13.529c-.26.26-.26.682 0 .942.26.26.682.26.942 0l6-6c.26-.26.26-.682 0-.942l-6-6c-.26-.26-.682-.26-.942 0-.26.26-.26.682 0 .942L11.057 8z"></path></svg>
                            </div>
                        </div>
                    </a>                        
                </li>

                


            </ul>
        </div>
    </main>

</div>
</body>
</html>