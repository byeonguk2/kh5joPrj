<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
	<link rel="stylesheet" href="/nongra/resources/css/common/cssReset.css">
	
	<style>
		body{
		
			
		}
		#wrap{
			width : 100%;
		}
		#main-area{
		display: grid;
		grid-template-columns: 230px 8fr;
		padding-top: 145px;
		}
		#headerer{
			display: flex;
			align-items: center;
			align-content: center;
		}
		
		
	</style>
	
	
</head>
<body>
	<div id="wrap">
		<%@ include file="/WEB-INF/views/common/header/header_sobi_memberModify.jsp" %>
	</div>
	  <div id = "main-area">
		
		<%@ include file="/WEB-INF/views/common/aside/aside_sobi_main.jsp" %>
			<div id="headerer">
			
			
			</div>
	</div>


</body>
</html>