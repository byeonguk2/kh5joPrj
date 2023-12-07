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
    
  		main{
			display: grid;
			grid-template-columns: 231px 8fr;
			justify-content: center;
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
	<div class = "wrap">
		<%@ include file="/WEB-INF/views/common/header/header_seller.jsp" %>
		<main>
			<%@ include file="/WEB-INF/views/common/aside/aside_seller.jsp" %>
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
			            <div><%=noteVo.getTitle() %></div>
						<div><%=noteVo.getContent() %></div>
			        </div>
		        	<div></div>
		        	<div>
					<%if(noteVo.getCheckDate().equals("N")){ %>
						<span>ok</span>
					<%}else{ %>
						<span>no</span>
					<%}%>
			            <button>X삭제</button>
			            <button>답장</button>
			            <span><a href="/nongra/">목록</a></span>
		        	</div>
			    </div>
		    </div>
		</main>
	</div>
</body>
</html>