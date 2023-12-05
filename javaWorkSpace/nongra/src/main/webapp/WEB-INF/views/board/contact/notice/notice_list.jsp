<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>공지사항 - 농라</title>
<link rel="stylesheet" href="/nongra/resources/css/board/contact/notice/notice_list.css">
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
                    <li><a href="/nongra/contact/notice" class="active menu_list">공지사항
                        <svg xmlns="http://www.w3.org/2000/svg" width="19" height="19" viewBox="0 0 24 24"><defs><path id="gfk9q0rhta" d="M1.657 1.657L9.657 1.657 9.657 9.657"></path></defs><g fill="none" fill-rule="evenodd"><g><g><g><g transform="translate(-339 -398) translate(0 386) translate(339 12) translate(4.69 6.343)"><use stroke="#754327" stroke-linecap="round" stroke-width="1.8" stroke-linejoin="round" transform="rotate(45 5.657 5.657)" xlink:href="#gfk9q0rhta"></use></g></g></g></g></g></svg>
                    </a></li>
                    <li><a href="/nongra/contact/faq" class="menu_list">자주하는 질문
                        <svg xmlns="http://www.w3.org/2000/svg" width="19" height="19" viewBox="0 0 24 24"><defs><path id="gfk9q0rhta" d="M1.657 1.657L9.657 1.657 9.657 9.657"></path></defs><g fill="none" fill-rule="evenodd"><g><g><g><g transform="translate(-339 -398) translate(0 386) translate(339 12) translate(4.69 6.343)"><use stroke="#666666" stroke-linecap="round" stroke-width="1.8" stroke-linejoin="round" transform="rotate(45 5.657 5.657)" xlink:href="#gfk9q0rhta"></use></g></g></g></g></g></svg>                </a></li>
                    <li><a href="/nongra/contact/inquiry" class="menu_list">1:1문의
                        <svg xmlns="http://www.w3.org/2000/svg" width="19" height="19" viewBox="0 0 24 24"><defs><path id="gfk9q0rhta" d="M1.657 1.657L9.657 1.657 9.657 9.657"></path></defs><g fill="none" fill-rule="evenodd"><g><g><g><g transform="translate(-339 -398) translate(0 386) translate(339 12) translate(4.69 6.343)"><use stroke="#666666" stroke-linecap="round" stroke-width="1.8" stroke-linejoin="round" transform="rotate(45 5.657 5.657)" xlink:href="#gfk9q0rhta"></use></g></g></g></g></g></svg>
                    </a></li>
                </ul>
                <div class="btn_menu_cs"></div>
                <%@ include file="/WEB-INF/views/common/aside/aside_sobi_contact.jsp" %>
            </div>
            <div class="content_area">
                <div class="board_name">공지사항</div>
                <ul class="board_list">
                    <li class="post_list">
                        <div class="post change_cursor">
                            <div class="post_title_emphasized">
                                [공지] 농라 사칭사이트 주의 안내          
                            </div>
                            <div class="post_date">
                                2023.07.14
                            </div>
                            <span class="open_arrow">
                                <svg class="svg1" width="24" height="24" focusable="false" viewBox="0 0 16 16" aria-hidden="true" role="presentation" style="fill: rgb(136, 136, 136);"><path fill="#888888" fill-rule="nonzero" d="M11.057 8L5.53 13.529c-.26.26-.26.682 0 .942.26.26.682.26.942 0l6-6c.26-.26.26-.682 0-.942l-6-6c-.26-.26-.682-.26-.942 0-.26.26-.26.682 0 .942L11.057 8z"></path></svg>
                            </span>
                        </div>
                    </li>

                    <li class="post_list">
                        <div class="post change_cursor">
                            <div class="post_title_emphasized">
                                [공지] 농라 사칭사이트 주의 안내          
                            </div>
                            <div class="post_date">
                                2023.07.14
                            </div>
                            <span class="open_arrow">
                                <svg class="svg1" width="24" height="24" focusable="false" viewBox="0 0 16 16" aria-hidden="true" role="presentation" style="fill: rgb(136, 136, 136);"><path fill="#888888" fill-rule="nonzero" d="M11.057 8L5.53 13.529c-.26.26-.26.682 0 .942.26.26.682.26.942 0l6-6c.26-.26.26-.682 0-.942l-6-6c-.26-.26-.682-.26-.942 0-.26.26-.26.682 0 .942L11.057 8z"></path></svg>
                            </span>
                        </div>
                        <div class="post_detail">
                            <p>
                                안녕하세요, 농라입니다.<br>
                                <br>
                                최근 농라를 사칭하는 사이트를 제작하여 이메일, 문자를 발송하거나 농라 임직원을 사칭하여 사기 등 불법행위를 시도하는 사례가 확인되고 있습니다.<br>
                                <br>
                                [농라 사칭 사례]
                                농라의 공식 웹사이트(https://www.nongra.com/)가 아닌 사칭 웹사이트(농라의 상호명, 주소지, 사업자등록번호 등 도용)를 통해 대체불가토큰 (NFT) 무상 지급 등 허위의 이벤트 참여 독려
                                농라 또는 농라 임직원임을 사칭하며 SNS/구인 구직 사이트/문자 등을 통해 일자리를 제안하며 농라를 사칭한 웹사이트에 가입하도록 하고, 이후 활동비 명목으로 선입금을 유도하여 현금을 편취하는 사례
                                이외 농라의 공식 웹사이트(https://www.nongra.com/)는 아니나, 농라의 상호명, 주소지, 사업자등록번호 등을 도용하여 표시한 모조 사이트
                                <br>
                                이와 같은 사례들은 농라과는 전혀 무관한 이벤트 및 사이트로, 사칭으로 인한 피해가 발생하지 않도록 확인되지 않은 사이트로의 연결을 유도하는 등 의심가는 이메일, 문자 등을 수신하신 경우에는 각별한 주의 부탁드립니다.
                                감사합니다.</p>
                        </div>
                    </li>

                    <li class="post_list">
                        <div class="post change_cursor">
                            <div class="post_title_emphasized">
                                [공지] 농라 사칭사이트 주의 안내          
                            </div>
                            <div class="post_date">
                                2023.07.14
                            </div>
                            <span class="open_arrow">
                                <svg class="svg1" width="24" height="24" focusable="false" viewBox="0 0 16 16" aria-hidden="true" role="presentation" style="fill: rgb(136, 136, 136);"><path fill="#888888" fill-rule="nonzero" d="M11.057 8L5.53 13.529c-.26.26-.26.682 0 .942.26.26.682.26.942 0l6-6c.26-.26.26-.682 0-.942l-6-6c-.26-.26-.682-.26-.942 0-.26.26-.26.682 0 .942L11.057 8z"></path></svg>
                            </span>
                        </div>
                    </li>

                    <li class="post_list">
                        <div class="post change_cursor">
                            <div class="post_title_normal">
                                [공지] 농라 사칭사이트 주의 안내          
                            </div>
                            <div class="post_date">
                                2023.07.14
                            </div>
                            <span class="open_arrow">
                                <svg class="svg1" width="24" height="24" focusable="false" viewBox="0 0 16 16" aria-hidden="true" role="presentation" style="fill: rgb(136, 136, 136);"><path fill="#888888" fill-rule="nonzero" d="M11.057 8L5.53 13.529c-.26.26-.26.682 0 .942.26.26.682.26.942 0l6-6c.26-.26.26-.682 0-.942l-6-6c-.26-.26-.682-.26-.942 0-.26.26-.26.682 0 .942L11.057 8z"></path></svg>
                            </span>
                        </div>
                    </li>

                    <li class="post_list">
                        <div class="post change_cursor">
                            <div class="post_title_normal">
                                [공지] 농라 사칭사이트 주의 안내          
                            </div>
                            <div class="post_date">
                                2023.07.14
                            </div>
                            <span class="open_arrow">
                                <svg class="svg1" width="24" height="24" focusable="false" viewBox="0 0 16 16" aria-hidden="true" role="presentation" style="fill: rgb(136, 136, 136);"><path fill="#888888" fill-rule="nonzero" d="M11.057 8L5.53 13.529c-.26.26-.26.682 0 .942.26.26.682.26.942 0l6-6c.26-.26.26-.682 0-.942l-6-6c-.26-.26-.682-.26-.942 0-.26.26-.26.682 0 .942L11.057 8z"></path></svg>
                            </span>
                        </div>
                    </li>

                    <li class="post_list">
                        <div class="post change_cursor">
                            <div class="post_title_normal">
                                [공지] 농라 사칭사이트 주의 안내          
                            </div>
                            <div class="post_date">
                                2023.07.14
                            </div>
                            <span class="open_arrow">
                                <svg class="svg1" width="24" height="24" focusable="false" viewBox="0 0 16 16" aria-hidden="true" role="presentation" style="fill: rgb(136, 136, 136);"><path fill="#888888" fill-rule="nonzero" d="M11.057 8L5.53 13.529c-.26.26-.26.682 0 .942.26.26.682.26.942 0l6-6c.26-.26.26-.682 0-.942l-6-6c-.26-.26-.682-.26-.942 0-.26.26-.26.682 0 .942L11.057 8z"></path></svg>
                            </span>
                        </div>
                    </li>

                    <li class="post_list">
                        <div class="post change_cursor">
                            <div class="post_title_normal">
                                [공지] 농라 사칭사이트 주의 안내          
                            </div>
                            <div class="post_date">
                                2023.07.14
                            </div>
                            <span class="open_arrow">
                                <svg class="svg1" width="24" height="24" focusable="false" viewBox="0 0 16 16" aria-hidden="true" role="presentation" style="fill: rgb(136, 136, 136);"><path fill="#888888" fill-rule="nonzero" d="M11.057 8L5.53 13.529c-.26.26-.26.682 0 .942.26.26.682.26.942 0l6-6c.26-.26.26-.682 0-.942l-6-6c-.26-.26-.682-.26-.942 0-.26.26-.26.682 0 .942L11.057 8z"></path></svg>
                            </span>
                        </div>
                    </li>

                    <li class="post_list">
                        <div class="post change_cursor">
                            <div class="post_title_normal">
                                [공지] 농라 사칭사이트 주의 안내          
                            </div>
                            <div class="post_date">
                                2023.07.14
                            </div>
                            <span class="open_arrow">
                                <svg class="svg1" width="24" height="24" focusable="false" viewBox="0 0 16 16" aria-hidden="true" role="presentation" style="fill: rgb(136, 136, 136);"><path fill="#888888" fill-rule="nonzero" d="M11.057 8L5.53 13.529c-.26.26-.26.682 0 .942.26.26.682.26.942 0l6-6c.26-.26.26-.682 0-.942l-6-6c-.26-.26-.682-.26-.942 0-.26.26-.26.682 0 .942L11.057 8z"></path></svg>
                            </span>
                        </div>
                    </li>

                    <li class="post_list">
                        <div class="post change_cursor">
                            <div class="post_title_normal">
                                [공지] 농라 사칭사이트 주의 안내          
                            </div>
                            <div class="post_date">
                                2023.07.14
                            </div>
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
        <footer>

        </footer>
    </div>
</body>
</html>