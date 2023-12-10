<%@page import="java.util.List"%>
<%@page import="com.kh.app.category.vo.CategoryVo"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
    
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
	<c:forEach items="${categoryList}" var="category">
	    <button onclick="selectCategory(${category.categoryNo}, '${category.category}', 'category1')">
	        ${category.category}
	    </button>
	</c:forEach>
	
	<script>
	    function selectCategory(categoryNo, categoryName, type) {
	        const selectedCategory = { categoryNo, category: categoryName };
	        window.opener.postMessage({ category: selectedCategory, type }, '*');
	        window.close();
	    }
	</script>
	
</body>
</html>