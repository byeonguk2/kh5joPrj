<%@page import="java.util.List"%>
<%@page import="com.kh.app.board.contact.vo.FaqVo"%>
<%@page import="com.kh.app.page.vo.PageVoTest"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%
    List<FaqVo> faqVoList = (List<FaqVo>) request.getAttribute("faqVoList");
    PageVoTest pvo = (PageVoTest) request.getAttribute("pvo"); 
    %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>자주하는 질문 - 농라</title>
<link rel="stylesheet" href="/nongra/resources/css/board/contact/notice/notice_list.css">
<link rel="stylesheet" href="/nongra/resources/css/board/contact/faq/faq_own_list.css">
<script defer src="/nongra/resources/js/board/board.js"></script>
<script defer src="/nongra/resources/js/board/faq_own.js"></script>
</head>
<body>
    <div id="wrap_board">
    <%@ include file="/WEB-INF/views/common/header/header_sobi.jsp" %>
    <main>
        <div class="section">
            <div class="section_name">고객센터</div>
            <!-- 1. 기능구현시, for문 돌리고, div선택하면 해당 div의 svg1을 270도 돌리면 됨 -->
            <ul class="menu_area">
                <li><a href="/nongra/contact/notice" class="menu_list">공지사항
                    <svg xmlns="http://www.w3.org/2000/svg" width="19" height="19" viewBox="0 0 24 24"><defs><path id="gfk9q0rhta" d="M1.657 1.657L9.657 1.657 9.657 9.657"></path></defs><g fill="none" fill-rule="evenodd"><g><g><g><g transform="translate(-339 -398) translate(0 386) translate(339 12) translate(4.69 6.343)"><use stroke="#666666" stroke-linecap="round" stroke-width="1.8" stroke-linejoin="round" transform="rotate(45 5.657 5.657)" xlink:href="#gfk9q0rhta"></use></g></g></g></g></g></svg>                
                </a></li>

                </a></li>
                <li><a href="/nongra/contact/faq" class="active menu_list">자주하는 질문
                    <svg xmlns="http://www.w3.org/2000/svg" width="19" height="19" viewBox="0 0 24 24"><defs><path id="gfk9q0rhta" d="M1.657 1.657L9.657 1.657 9.657 9.657"></path></defs><g fill="none" fill-rule="evenodd"><g><g><g><g transform="translate(-339 -398) translate(0 386) translate(339 12) translate(4.69 6.343)"><use stroke="#754327" stroke-linecap="round" stroke-width="1.8" stroke-linejoin="round" transform="rotate(45 5.657 5.657)" xlink:href="#gfk9q0rhta"></use></g></g></g></g></g></svg>
                
                <li><a href="/nongra/contact/inquiry" class="menu_list">1:1문의
                    <svg xmlns="http://www.w3.org/2000/svg" width="19" height="19" viewBox="0 0 24 24"><defs><path id="gfk9q0rhta" d="M1.657 1.657L9.657 1.657 9.657 9.657"></path></defs><g fill="none" fill-rule="evenodd"><g><g><g><g transform="translate(-339 -398) translate(0 386) translate(339 12) translate(4.69 6.343)"><use stroke="#666666" stroke-linecap="round" stroke-width="1.8" stroke-linejoin="round" transform="rotate(45 5.657 5.657)" xlink:href="#gfk9q0rhta"></use></g></g></g></g></g></svg>
                </a></li>
            </ul>
            <div class="btn_menu_cs"></div>
            <%@ include file="/WEB-INF/views/common/aside/aside_sobi_contact.jsp" %>
        </div>
        <div class="content_area">
            <div class="board_name">자주하는 질문</div>
            <div class="faq_search_tab">
                <strong class="search_title">자주하는 질문</strong>
                <div class="search_wrap">
                    <div class="search_area">
                        <input type="search" name="search" placeholder="궁금한 내용을 입력해주세요." class="input_search">
                        <button type="button" class="btn_search">검색</button>
                    </div>
                </div>
            </div>
            <div class="tab_area">
                <button type="button" class="on btn_faq_tab" >배송</button>
                <button type="button" class="btn_faq_tab">주문/결제</button>
                <button type="button" class="btn_faq_tab">취소/교환/반품</button>
                <button type="button" class="btn_faq_tab">상품</button>
                <button type="button" class="btn_faq_tab">회원</button>
                <button type="button" class="btn_faq_tab">농라페이</button>
                <button type="button" class="btn_faq_tab">기타</button>
            </div>
            <ul class="board_list">
            	<% for(FaqVo vo : faqVoList){ %>
	                <li class="post_list">
	                    <div class="post faq_change_cursor">
	                        <span class="post_q">Q</span>
	                        <span class="post_title_faq">
	                            <%=vo.getTitle() %>
	                        </span>
	                        <span class="open_arrow">
	                            <svg class="svg1" width="24" height="24" focusable="false" viewBox="0 0 16 16" aria-hidden="true" role="presentation" style="fill: rgb(136, 136, 136);"><path fill="#888888" fill-rule="nonzero" d="M11.057 8L5.53 13.529c-.26.26-.26.682 0 .942.26.26.682.26.942 0l6-6c.26-.26.26-.682 0-.942l-6-6c-.26-.26-.682-.26-.942 0-.26.26-.26.682 0 .942L11.057 8z"></path></svg>
	                        </span>
	                    </div>
	                    <div class="post_detail">
	                        <p>
	                            <%=vo.getContent() %>
	                        </p>
	                    </div>
                	</li>
                <% } %>
            </ul>
            <div class="add_list" onclick="takeFaqCateNo()">더보기
                <svg class="svg2" width="14" height="14" focusable="false" viewBox="0 0 16 16" aria-hidden="true" role="presentation" style="fill: #754327;"><path fill="#754327" fill-rule="nonzero" d="M11.057 8L5.53 13.529c-.26.26-.26.682 0 .942.26.26.682.26.942 0l6-6c.26-.26.26-.682 0-.942l-6-6c-.26-.26-.682-.26-.942 0-.26.26-.26.682 0 .942L11.057 8z"></path></svg><path fill="#0051f5" fill-rule="nonzero" d="M11.057 8L5.53 13.529c-.26.26-.26.682 0 .942.26.26.682.26.942 0l6-6c.26-.26.26-.682 0-.942l-6-6c-.26-.26-.682-.26-.942 0-.26.26-.26.682 0 .942L11.057 8z"></path>
            </div>
        </div>
    </main>

</div>
</body>
</html>