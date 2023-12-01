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
<link rel="stylesheet" href="/nongra/resources/css/login/sellerLogin.css">
</head>
<body>
	<div id="root">
        <div class="css-auhedv">
            <h1>관리자 로그인</h1>
            <div>
                <form action="/nongra/admin/login" method="post">
                    <input autocomplete="off" type="text" placeholder="아이디를 입력해주세요" name="id" maxlength="16" class="css-18jns9z" value="">
                    <input autocomplete="off" type="text" placeholder="비밀번호를 입력해주세요" name="pwd" maxlength="16" class="css-q5u0mo" value="">
                    <button type="submit">로그인</button>
                </form>
            </div>
        </div>
    </div>
</body>
</html>
<script type="text/javascript">
	<% if(alertMsg != null){ %>
		alert("<%= alertMsg %>");
	<%} %>
	
</script>