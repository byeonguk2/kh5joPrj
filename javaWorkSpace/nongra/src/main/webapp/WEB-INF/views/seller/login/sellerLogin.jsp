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
            <h1>파트너 로그인</h1>
            <div>
                <form action="/nongra/seller/login" method="post">
                    <input autocomplete="off" type="text" placeholder="아이디를 입력해주세요" name="id" maxlength="16" class="css-18jns9z" value="">
                    <input autocomplete="off" type="password" placeholder="비밀번호를 입력해주세요" name="pwd" maxlength="16" class="css-q5u0mo" value="">
                    <button type="submit">로그인</button>
                </form>
                <div>
                    <a class="" href="/nongra/email/findId">아이디 찾기</a>
                    <span>|</span>
                    <a class="" href="/nongra/email/findPwd">비밀번호 찾기</a>
                    <span>|</span>
                    <a class="" href="/nongra/seller/join">파트너 가입</a>
                </div>
            </div>
            <p>파트너 계정의 보안을 위해 24시간을 기준으로 2단계 인증을 적용합니다.<br>인증로그인 후 24시간(동일IP) 이내는 2단계 인증없이 로그인 가능합니다.</p>
        </div>
    </div>
</body>
</html>
<script type="text/javascript">
	<% if(alertMsg != null){ %>
		alert("<%= alertMsg %>");
	<%} %>
	
</script>