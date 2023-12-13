<%@page import="com.kh.app.seller.vo.SellerNoteVo"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
    <%
    	SellerNoteVo noteVo = (SellerNoteVo)request.getAttribute("noteVo");
    
    
    %>
    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
    <style>
    
	#wrap{
		width : 100%;
	}
	#main-area{
	display: grid;
	grid-template-columns: 230px 8fr;
	padding-top: ;
	}
	#headerer{
		display: flex;
		align-items: center;
		justify-content: center;
	}
	main{
	display: grid;
	grid-template-columns: 231px 8fr;
	}
	
	.content-area{
		display: grid;
		grid-template-rows: 1fr 9fr;
		border: 1px solid gray;
		margin-left: 10px;
		margin-top: 10px;
		border-radius: 20px;
		width: 99%;
		box-sizing: border-box;
	}
    	
    	.content{
    		display : flex;
            width: 100%;
            height: 100%;
            justify-content: center;
            align-items: center;
    	}
    	
        .content-area{
            display: grid;
            grid-template-rows: 0.5fr 4fr 1fr 1fr;
            width: 80%;
            height: 80%;

        }
        .content-top{
            display: grid;
            grid-template-rows: 1fr 1fr;
            border-top: 1px solid gray;
            border-bottom: 1px solid gray;
        }
    </style>
</head>
<body>
	<div id="wrap1">
		<%@ include file="/WEB-INF/views/common/header/header_sobi.jsp"%>
		<main>
			<%@ include file="/WEB-INF/views/common/aside/aside_sobi_main.jsp"%>
			<div class="content">
				<div class="content-area">

			        <div>
			            <div class="content-top">
			                <div>
			                    <span>보낸사람 <%=noteVo.getToId() %></span>
			                </div>
			                <div>
			                    <span><strong>발송시간</strong></span>
			                    <span><%=noteVo.getSendDate() %></span>
			                </div>
			            </div>
			        </div>
			        <div class="content-main">
			        	<span>제목 : </span>
			            <div><%=noteVo.getTitle() %></div>
			            <span>내용 : </span>
						<div><%=noteVo.getContent() %></div>
			        </div>
		        	<div></div>
		        	<div>
					<%if(noteVo.getCheckDate().equals("N")){ %>
						<span>no</span>
					<%}else{ %>
						<span>ok</span>
					<%}%>
			            <span><a href="/nongra/member/sendNote">목록</a></span>
		        	</div>
			    </div>
		    </div>
		</main>
	</div>
</body>
</html>