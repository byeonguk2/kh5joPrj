<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" href="/nongra/resources/css/admin/board/event/event_write.css">
</head>
<body>
	<div class="wrap_event">
		<%@ include file="/WEB-INF/views/common/header/header_sobi.jsp" %>
		<main>
			<aside>
				
			</aside>
			<div class="btw_side_content">
			</div>
            
            <!-- 본문 -->
            
			<div class="event_write">
                <div class="title_event_board">이벤트</div>
                <form action="">
                    <table class="event_table">
                        <tr>
                            <th>시작일시</th>
                            <td>
                                <input type="date" name="start_date">
                            </td>
                            <th>종료일시</th>
                            <td>
                                <input type="date" name="end_date">
                            </td>
                        </tr>
                        <tr>
                            <th>제목</th>
                            <td colspan="3">
                                <input type="text" name="title" placeholder="제목을 입력해주세요">
                            </td>
                        </tr>
                        <tr>
                            <th>내용</th>
                            <td colspan="3">
                                <textarea name="content"  placeholder="내용을 입력해주세요"></textarea>
    
                            </td>
                        </tr>
                        <tr>
                            <th>사진</th>
                            <td colspan="3">
                                <ul class="ul_attach_list">
                                    <li class="attach_list">
                                        <button type="button" class="btn_Img_upload">
                                            <span class="ico">
                                                <img src="/nongra/resources/img/common/icon/btn_Img_upload.png" alt="사진추가">
                                            </span>
                                        </button>
                                    </li>
                                    <li class="attach_list">
                                        <button type="button" class="btn_Img_upload">
                                            <span class="ico">
                                                <img src="/nongra/resources/img/common/icon/btn_Img_upload.png" alt="사진추가">
                                            </span>
                                        </button>
                                    </li>
                                    <li class="attach_list">
                                        <button type="button" class="btn_Img_upload">
                                            <span class="ico">
                                                <img src="/nongra/resources/img/common/icon/btn_Img_upload.png" alt="사진추가">
                                            </span>
                                        </button>
                                    </li>
                                </ul>
                                <p class="attach_txt">
                                    10MB 미만의 JPG, GIF, PNG 파일만 등록 가능합니다. 
                                    상품과 무관한 내용이거나 음란 및 불법적인 내용은 통보없이 삭제될 수 있습니다.
                                </p>
                            </td>
                        </tr>
                    </table>

                </form>
                

                <div class="btn_area">
                    <ul>
                        <li>
                            <button type="button" class="btn btn1" ><span>취소</span></button>
                        </li>
                        <li>
                            <button type="button" class="btn btn2"><span>등록</span></button>
                        </li>
                    </ul>
                    
                    
                </div>
                 
			</div>
            <!-- 본문 -->



		</main>
		<footer>footer</footer>
	</div>
</body>
</html>