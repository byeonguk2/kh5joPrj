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
</head>
<body>
	
	<div><%=noteVo.getToId() %></div>
	<div><%=noteVo.getTitle() %></div>
	<div><%=noteVo.getContent() %></div>
	<div><%=noteVo.getSendDate() %></div>
	<%if(noteVo.getCheckDate().equals("N")){ %>
		<div>쪽지확인안함</div>
	<%}else{ %>
		<div>쪽지확인했음</div>
	<%}%>
</body>
</html>