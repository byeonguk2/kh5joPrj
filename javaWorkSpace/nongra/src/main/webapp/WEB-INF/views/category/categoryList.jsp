<%@page import="java.util.List"%>
<%@page import="com.kh.app.category.vo.CategoryVo"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
    <%
    	List<CategoryVo> categoryList = (List<CategoryVo>) request.getAttribute("categoryList");
    
    %>
    
    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	
	<h1>카테고리</h1>
	<% for(CategoryVo voList : categoryList){ %>	
	<div>
		<%=voList.getCategory()%>
	</div>
	<% } %>
	
</body>
</html>