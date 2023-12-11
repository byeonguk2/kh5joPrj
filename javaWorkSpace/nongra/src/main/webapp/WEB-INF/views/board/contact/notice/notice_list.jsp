<%@page import="java.sql.Timestamp"%>
<%@page import="java.text.SimpleDateFormat"%>
<%@page import="com.kh.app.page.vo.PageVoTest"%>
<%@page import="com.kh.app.board.contact.vo.NoticeVo"%>
<%@page import="java.util.List"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
	<% 
	List<NoticeVo> noticeVoList = (List<NoticeVo>) request.getAttribute("noticeVoList");
	PageVoTest pvo = (PageVoTest) request.getAttribute("pvo");
	
	SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy.MM.dd");
	
	%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>공지사항 - 농라</title>
<link rel="stylesheet" href="/nongra/resources/css/board/contact/notice/notice_list.css">
<script defer src="/nongra/resources/js/board/board.js"></script>
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
            	<% for(NoticeVo vo : noticeVoList){ %>
	                <li class="post_list">
                        <div class="post change_cursor" >
                            <% if(vo.getTopDisplay().equals("Y")){ %>
                            <div class="post_title_emphasized"> 
                            <% } else { %>
                            <div class="post_title_normal"> 
                            <% } %> 
                                <%=vo.getTitle() %> </div>
                            <div class="post_date"><%=vo.getEnrollDate() %>
                            </div>
                            <span class="open_arrow">
                                <svg class="svg1" width="24" height="24" focusable="false" viewBox="0 0 16 16" aria-hidden="true" role="presentation" style="fill: rgb(136, 136, 136);"><path fill="#888888" fill-rule="nonzero" d="M11.057 8L5.53 13.529c-.26.26-.26.682 0 .942.26.26.682.26.942 0l6-6c.26-.26.26-.682 0-.942l-6-6c-.26-.26-.682-.26-.942 0-.26.26-.26.682 0 .942L11.057 8z"></path></svg>
                            </span>
                        </div>
                        <div class="post_detail"><p><%=vo.getContent() %></p></div>
                    </li>
                <% } %>
            </ul>
            <div class="add_list" onclick="askMoreList()">더보기
                <svg class="svg2" width="14" height="14" focusable="false" viewBox="0 0 16 16" aria-hidden="true" role="presentation" style="fill: #754327;"><path fill="#754327" fill-rule="nonzero" d="M11.057 8L5.53 13.529c-.26.26-.26.682 0 .942.26.26.682.26.942 0l6-6c.26-.26.26-.682 0-.942l-6-6c-.26-.26-.682-.26-.942 0-.26.26-.26.682 0 .942L11.057 8z"></path></svg><path fill="#0051f5" fill-rule="nonzero" d="M11.057 8L5.53 13.529c-.26.26-.26.682 0 .942.26.26.682.26.942 0l6-6c.26-.26.26-.682 0-.942l-6-6c-.26-.26-.682-.26-.942 0-.26.26-.26.682 0 .942L11.057 8z"></path>
            </div>
        </div>

    </main>
    <footer>

    </footer>
    
</div>
</body>
</html>