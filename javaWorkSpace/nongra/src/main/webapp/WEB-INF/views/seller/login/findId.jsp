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
<style>
#selectId{
	width: 400px;
	padding: 40px 30px 40px;
	margin-bottom: 30px
}
#emailInputTag-area{
	display: flex;
	gap: 10px;
}
#emailInputTag{
	width: 300px;
}
.email-btn{
	margin-bottom: 15px;
	width: 100px;
	border: 1px solid #754327;
	background: white;
	color: #754327;
	cursor: pointer;
	border-radius: 5px
}

.gray{
	border: 1px solid rgb(153, 153, 153);
	color: rgb(153, 153, 153);
}

#CertifiedInputTag{
	width: 400px;
}
#CertifiedBtn{
	width: 400px;
}
</style>
</head>
<body>
	<div id="root">
        <div class="css-auhedv">
            <h1>아이디 찾기</h1>
            <div id="selectId">
                <form onsubmit="return Certified()" action="/nongra/seller/login" method="post">
               		<div id="emailInputTag-area">
               			<input id="emailInputTag" autocomplete="off" type="email" placeholder="이메일을 입력해주세요" name="id" class="css-18jns9z" value="">
               			<button onclick="checkEmail();" type="button" class="email-btn">인증번호 발급</button>
					</div>
                    <div>
                    	<input id="CertifiedInputTag" type="text" placeholder="인증번호를 입력해주세요" class="css-q5u0mo"  value="">
                    </div>      
					<input type="hidden">              
                    <button id="CertifiedBtn" type="submit">인증하기</button>
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
	<% pageContext.setAttribute("dasd", "dasd"); %>
	function checkEmail() {
		const emailValue = document.querySelector("input[type=email]");
		console.log(emailValue);
		fetch("/nongra/email/check?email="+emailValue.value)
		.then((resp)=>{return resp.json();})
		.then((data)=>{
			alert(data[0]);
			if(data[1] !== ""){
				const btn = document.querySelector(".email-btn");
				btn.disabled = true;
				btn.classList.add("gray");
				emailValue.readOnly = true;
				const hiddenInput = document.querySelector("input[type=hidden]");
				console.log(hiddenInput);
				hiddenInput.value = data[1];
			}else{
				const hiddenInput = document.querySelector("input[type=hidden]");
				hiddenInput.value = data[1];
				console.log(hiddenInput);
			}
		});
	} 
	
	function Certified() {
		const hiddenInput = document.querySelector("input[type=hidden]");
		const CertifiedInput = document.querySelector("#CertifiedInputTag");
		if(!CertifiedInput.value){
			alert("인증번호를 입력하세요.");
			return false;
		}
		if(hiddenInput.value !== CertifiedInput.value){
			const btn = document.querySelector(".email-btn");
			btn.disabled = false;
			btn.classList.remove("gray");
			alert("인증번호가 일치하지 않습니다.");
			return false;
		}
	}
	
</script>