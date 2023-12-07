<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>	
<link rel="stylesheet" href="/nongra/resources/css/admin/board/manage_style.css">
<link rel="stylesheet" href="/nongra/resources/css/board/contact/qna/qna_own_write.css">
</head>
<body>
	<div id="wrap_board">
		<%@ include file="/WEB-INF/views/common/header/header_admin.jsp" %>
		<div id = "main-area">
			<%@ include file="/WEB-INF/views/common/aside/aside_admin.jsp" %>
			<form action="" method="post">
				<div class="admin_menu_name">
                    <h2>공지사항 작성</h2>
                </div>
                <div class="admin_content_area">
                    <table class="qna_table">
                        <tbody>
                            <tr>
                                <th class="row_qna">선택</th>
                                <td class="write_select_box_wrap">
                                    <div class="write_select_box">
                                        <div>
                                            <input type="checkbox" name="top_display"> 공지상단노출
                                        </div>
                                        <div>
                                            읽기권한  
                                            <select name="read_permission">
                                                <option value="seller">판매자</option>
                                                <option value="sobi">소비자</option>
                                            </select>
                                        </div>
                                        <div>
                                            공개상태
                                            <select name="open_YN">
                                                <option value="open">공개</option>
                                                <option value="non-open">비공개</option>
                                            </select>
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
                                        <textarea name="qna_content" id="qna_content" cols="120" rows="10" placeholder="내용을 입력해주세요"></textarea>
                                    </div>
                                </td>
                            </tr>
    
                            <tr id="atchFile_noti">
                                <th class="row_qna">파일</th>
                                <td>
                                    <input type="file" name="noti_file_upload">
                                </td>
                            </tr>
    
                        </tbody>
                    </table>
                </div>
                <div class="qna_submit_btn_area">
                    <button type="submit">등록</button>
                </div>
						
			</from>
		</div>
		<script></script>
	</div>
	<script>
		function createAsideLetter(){
		const x = document.querySelector(".aside-item > label");
		const menu1 = document.querySelector(" aside > :nth-child(2) > a ");
		const menu2 = document.querySelector(" aside > :nth-child(3) > a ");
		const menu3 = document.querySelector(" aside > :nth-child(4) > a ");
		x.innerHTML = "게시판 관리";
		menu1.innerHTML = "공지사항 관리";
		menu1.href = "/nongra/admin/notice/manage";
		menu2.innerHTML = "FAQ 관리";
        menu2.href = "/nongra/admin/faq/manage";
		menu3.innerHTML = "1:1문의(판매자) 관리";
		menu3.href = "/nongra/admin/member/request";

      
		const menu4 = document.querySelector(" aside > :nth-child(5) > a ");
		const menu5 = document.querySelector(" aside > :nth-child(6) > a ");
		const menu6 = document.querySelector(" aside > :nth-child(7) > a ");
		
		menu4.innerHTML = "1:1문의(소비자 관리)";
		menu4.href = "/nongra/admin/notice/manage";
		menu5.innerHTML = "이벤트 관리";
        menu5.href = "/nongra/admin/faq/manage";
		menu6.innerHTML = "구매팁 관리";
		menu6.href = "/nongra/admin/member/request";
		}
		createAsideLetter()
		
		
	</script>
</body>
</html>