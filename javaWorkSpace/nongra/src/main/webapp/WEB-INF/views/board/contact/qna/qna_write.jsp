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
                                                    <span class="sel_arrow">
                                                        <svg class="svg1" width="20" height="20" focusable="false" viewBox="0 0 16 16" aria-hidden="true" role="presentation" style="fill: rgb(136, 136, 136);"><path fill="#888888" fill-rule="nonzero" d="M11.057 8L5.53 13.529c-.26.26-.26.682 0 .942.26.26.682.26.942 0l6-6c.26-.26.26-.682 0-.942l-6-6c-.26-.26-.682-.26-.942 0-.26.26-.26.682 0 .942L11.057 8z"></path></svg>
                                                    </span>  
                                                </a>
                                                <div class="qna_drop_scroll">
                                                    <ul class="qna_drop_list">
                                                        <li class="selected" data-index="0">
                                                            <a href=""><span class="qna_txt">선택하세요</span></a>
                                                        </li>
                                                        <li data-index="1">
                                                            <a href=""><span class="qna_txt">상품</span></a>
                                                        </li>
                                                        <li data-index="2">
                                                            <a href=""><span class="qna_txt">배송</span></a>
                                                        </li>
                                                        <li data-index="3">
                                                            <a href=""><span class="qna_txt">주문/결제</span></a>
                                                        </li>
                                                        <li data-index="4">
                                                            <a href=""><span class="qna_txt">회원</span></a>
                                                        </li>
                                                        <li data-index="5">
                                                            <a href=""><span class="qna_txt">농라페이</span></a>
                                                        </li>
                                                        <li data-index="6">
                                                            <a href=""><span class="qna_txt">기타</span></a>
                                                        </li>
                                                    </ul>
                                                </div>
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
                                                <a href="" class="qna_drop_select">
                                                    <span class="qna_txt">선택하세요</span>
                                                    <span class="sel_arrow">
                                                        <svg class="svg1" width="20" height="20" focusable="false" viewBox="0 0 16 16" aria-hidden="true" role="presentation" style="fill: rgb(136, 136, 136);"><path fill="#888888" fill-rule="nonzero" d="M11.057 8L5.53 13.529c-.26.26-.26.682 0 .942.26.26.682.26.942 0l6-6c.26-.26.26-.682 0-.942l-6-6c-.26-.26-.682-.26-.942 0-.26.26-.26.682 0 .942L11.057 8z"></path></svg>
                                                    </span>  
                                                </a>
                                                <div class="qna_drop_scroll">
                                                    <ul class="qna_drop_list">
                                                        <li class="selected" data-index="0">
                                                            <a href=""><span class="qna_txt">선택하세요</span></a>
                                                        </li>
                                                        <li data-index="1">
                                                            <a href=""><span class="qna_txt">상품</span></a>
                                                        </li>
                                                        <li data-index="2">
                                                            <a href=""><span class="qna_txt">배송</span></a>
                                                        </li>
                                                        <li data-index="3">
                                                            <a href=""><span class="qna_txt">주문/결제</span></a>
                                                        </li>
                                                        <li data-index="4">
                                                            <a href=""><span class="qna_txt">회원</span></a>
                                                        </li>
                                                        <li data-index="5">
                                                            <a href=""><span class="qna_txt">농라페이</span></a>
                                                        </li>
                                                        <li data-index="6">
                                                            <a href=""><span class="qna_txt">기타</span></a>
                                                        </li>
                                                    </ul>
                                                </div>
                                            </div>
                                        </div>
    
                                    </div>
                                </td>
                            </tr>
    
                            <tr>
                                <th class="row_qna">상품</th>
                                <td>
                                    <div class="qna_drop_group">
                                        <div class="qna_btn_wrap">
                                            <!-- modal -->
                                            <!-- 구현하면서 더 손볼 곳 -->
                                            <button id="btnOrdItemList" name="ordItem" type="button" data-layer-target="#ccs_sel_prod1" onclick="ordListForMyssgCs(); return false;" class="btn_open ccs_btn_line">
                                                <span>주문상품 선택</span></button>                                       
                                        </div>
                                    </div>
                                </td>
                            </tr>
    
                            <tr>
                                <th class="row_qna">
                                    <label for="qna_title">제목</label>
                                    <span style="color: #ff3e3e;">*</span>
                                </th>
                                <td>
                                    <div class="inp_txt_wrap">
                                        <input type="text" name="qna_title" id="qna_title" maxlength="30" value placeholder="제목을 입력해주세요.(30자 이내)">
                                    </div>
                                </td>
                            </tr>
    
                            <tr>
                                <th class="row_qna">
                                    <label for="qna_content">내용</label>
                                    <span style="color: #ff3e3e;">*</span>
                                </th>
                                <td>
                                    <div class="buyselect">
                                        <textarea name="qna_content" id="qna_content" cols="120" rows="10" placeholder=
    "현재 협력사 및 택배사 업무종료로 인해 일부 문의는 업무개시 이후에 답변 예정입니다.
    접수량에 따라 답변이 지연될 수 있으며, 신속히 답변될 수 있도록 최선을 다하겠습니다. 
    
    취소,교환, 반품 신청은 주문배송 조회에서 직접 신청 가능하며 신청부터 환불까지 원스탑 처리가 가능합니다.
    주문에 대한 문의일 경우 상품을 선택하여 주시면 보다 빠른 상담이 가능합니다"></textarea>
                                    </div>
                                </td>
                            </tr>
    
                            <tr id="atchFile_qna">
                                <th class="row_qna">사진</th>
                                <td>
                                    <ul id="qna_atchFileList" class="qna_attach_lst">
                                        <li class="qna_atchBox">
                                            <button type="button" class="qna_btn_upload" onclick="findFile(); return false;">
                                                <span class="qna_atch_icon"></span>
                                            </button>
                                        </li>
                                        <li class="qna_atchBox">
                                            <button type="button" class="qna_btn_upload" onclick="findFile(); return false;">
                                                <span class="qna_atch_icon"></span>
                                            </button>
                                        </li>
                                        <li class="qna_atchBox">
                                            <button type="button" class="qna_btn_upload" onclick="findFile(); return false;">
                                                <span class="qna_atch_icon"></span>
                                            </button>
                                        </li>
                                    </ul>
                                    <p class="qna_atch_txt">
                                        10MB 미만의 JPG, GIF, PNG 파일만 등록 가능합니다.<br>상품과 무관한 내용이거나 음란 및 불법적인 내용은 통보없이 삭제될 수 있습니다.
                                    </p>
                                </td>
                            </tr>
    
                        </tbody>
                    </table>
                </div>

                <div class="qna_submit_btn_area">
                    <ul class="sbmt_box">
                        <li>
                            <button type="button" id="cancelBtn" class="qna_btn"><span>취소</span></button>
                        </li>
                        <li>
                            <button type="button" id="enrollBtn" class="qna_btn qna_sbmt"><span>등록</span></button>
                        </li>
                    </ul>
                </div>
                
            </form>
            

                


        </div>
    </main>


</body>
</html>