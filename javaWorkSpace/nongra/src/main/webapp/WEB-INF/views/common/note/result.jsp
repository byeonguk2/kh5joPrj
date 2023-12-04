<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%
    	String alertMsg = (String)session.getAttribute("alertMsg");
    	session.removeAttribute("alertMsg");
    %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	
   <script>
        alert('<%= alertMsg%>');
        window.close();
    </script>
</body>
</html>