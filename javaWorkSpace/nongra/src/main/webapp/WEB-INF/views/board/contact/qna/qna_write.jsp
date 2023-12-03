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
<link rel="stylesheet" href="/nongra/resources/css/board/contact/qna/qna_own_write.css">
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
            <div class="board_name">1:1문의</div>
                
            <div class="tab_area">
                <button type="button" class="btn_faq_tab">문의내역확인</button>
                <button type="button" class="on btn_faq_tab">문의하기</button>
            </div>
            <div class="notification_qna">
                <div>
                    <img src="/nongra/resources/img/common/icon/caution.png" alt="주의" width="20px">
                </div>
                <div>답변은 실시간 답변이 아니므로 문의량이 많을 시 답변이 지연될 수 있습니다. 답변은 평일 09:00~18:00에 등록되며, 
                    가능한 빨리 답변드릴 수 있도록 노력하겠습니다.</div>
            </div>
            <form action="">
                <div class="qna_form">
                    <div class="noti_form_qna">
                        <p class="noti_txt">
                            <span style="color: #ff3e3e;">*</span>필수 항목입니다.
                        </p>
                    </div>
                </div>
                <table class="qna_table">
                    <tbody>
                        <tr>
                            <th class="row_qna">유형</th>
                            <td>
                                <div class="qna_drop_group">
                                    <div class="qna_drop_wrap">
                                        <select name="qna_category1" id="qna_dropdown">
                                            <option value>선택하세요</option>
                                            <option value="qna_cate1_01">상품</option>
                                            <option value="qna_cate1_02">배송</option>
                                            <option value="qna_cate1_03">주문/결제</option>
                                            <option value="qna_cate1_04">회원</option>
                                            <option value="qna_cate1_05">농라페이</option>
                                            <option value="qna_cate1_06">기타</option>
                                        </select>
                                        <div class="qna_drop_opt">
                                            <a href="" class="qna_drop_select">
                                                <span class="qna_txt">선택하세요</span>
                                                <span class="sel_arrow">&nbsp;</span>
                                                
                                            </a>
                                            <div class="qna_drop_scroll"></div>
                                        </div>
                                    </div>

                                    <div class="qna_drop_wrap">
                                        <select name="qna_category1" id="qna_dropdown">
                                            <option value>선택하세요</option>
                                            <option value="qna_cate1_01">상품</option>
                                            <option value="qna_cate1_02">배송</option>
                                            <option value="qna_cate1_03">주문/결제</option>
                                            <option value="qna_cate1_04">회원</option>
                                            <option value="qna_cate1_05">농라페이</option>
                                            <option value="qna_cate1_06">기타</option>
                                        </select>
                                        <div class="qna_drop_opt">
                                            <a href=""></a>
                                            <div class="qna_drop_scroll"></div>
                                        </div>
                                    </div>
                                </div>
                            </td>
                        </tr>
                    </tbody>
                </table>
            </form>
            

                


        </div>
    </main>


</body>
</html>