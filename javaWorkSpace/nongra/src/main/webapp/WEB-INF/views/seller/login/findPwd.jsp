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
	width: 292.5px;
}
#CertifiedBtn{
	width: 400px;
	cursor: pointer;
}
.AuthenticationKey-area{
	display:flex;
}
.AuthenticationKey-area > .Timer {
	margin-left: 10px;
	width: 90.5px;
	border: none;
	text-align: center;
	font-size: 20px;
	color: red;
	display: none;
}

#box2{
     height: 200px;
     border: double 3px lightgray;
    text-align: center;
 }
 .modal {  
     display: flex;
     justify-content: center;
     align-items: center;
     position: fixed;
     left: 0;
     right: 0;
     top: 0;
     bottom: 0;
     background: rgba(0,0,0,0.3);
     
 }
 .dialog {
    width: 500px;
    height: 250px;
    padding: 2em;
    border-radius: 1em;
    background: aliceblue;
    grid-template-rows: 1fr;
    display: grid;
}
 .modal-none{
     display: none;
 }
 h3{
     text-align: center;
 }
 h4{
     margin-top: 20px;
 }
 #modal-close{
     width: 50px;
     height: 27px;
     color: #fff;
     background-color: #754327;
 }
 thead{
	width: 100%;
	display: flex;
	justify-content: center;
 }
 tbody{
	display: grid;
	grid-template-rows: 50px 50px 50px;
 }
 tr{
	padding: 0px 50px 0px 50px;
	height: 40px;
 }
 .title{
 	width: 130px;
 }
 td > input {
 	width: 250px;
 	height: 25px;
 }
 .pwdBtn{
 	width: 150px;
 	height: 40px;
 	border: 1px solid #754327;
 	color: white;
 	background-color: #754327;
 	border-radius: 5px;
 }
 .btn-area{
 	display: flex;
 	align-items: center;
 	justify-content: center;
 }
</style>
</head>
<body>
	<div id="root">
        <div class="css-auhedv">
            <h1>비밀번호 찾기</h1>
            <div id="selectId">
                <form action="" method="post">
               		<div id="emailInputTag-area">
               			<input id="emailInputTag" autocomplete="off" type="email" placeholder="이메일을 입력해주세요" name="email" class="css-18jns9z" value="">
               			<button onclick="return checkEmail();" type="button" class="email-btn">인증번호 발급</button>
					</div> 
                    <div class = "AuthenticationKey-area">
                    	<input id="CertifiedInputTag" name="AuthenticationKey" type="text" placeholder="인증번호를 입력해주세요" class="css-q5u0mo"  value="">
 						<input id="Timer" class="Timer" type="text" value="" readonly/>
                    </div>                  
                    <button onclick="checkEmailCode()" type="button" id="CertifiedBtn">인증하기</button>
                </form>
            </div>
        </div>
    </div>

                    <!-- 여기에 display none -->
                    <div class="modal modal-none" style="z-index: 3;">
                        <div class="dialog">
                            <table>
                            	<thead>
                            		<th colspan="2"><h3>비밀번호 변경</h3></th>
                            	</thead>
                            	<tbody>
                            		<tr>
										<td class="title">아이디: </td>
										<td><input name="id" type="text"></td>
									</tr>
									<tr>
										<td class="title">변경할 비밀번호: </td>
										<td><input name="pwd" type="password"></td>
									</tr>
									<tr>
										<td class="title">비밀번호 확인: </td>
										<td><input name="pwd_re" type="password"></td>
									</tr>
                            	</tbody>
                            </table>
                            <div class="btn-area">
                            	 <button class="pwdBtn" style="cursor: pointer;" type="button" onclick="return changePwd()">비밀번호 변경하기</button>
                            </div>
                   		 </div>
                       </div>
                   </div>
</body>
</html>
<script type="text/javascript">

	<% if(alertMsg != null){ %>
		alert("<%= alertMsg %>");
	<%} %>
	
	// 이메일 발송
	function checkEmail() {
		// ajax로 email 조회후 발송 
		const emailValue = document.querySelector("input[type=email]");
		console.log(emailValue);
		fetch("/nongra/email/check?email="+emailValue.value)
		.then((resp)=>{return resp.json();})
		.then((data)=>{
			// 알람 메세지
			alert(data[0]);
			// 성공시 버튼 색깔 사라짐
			if(data[0] === "이메일이 발송 되었습니다. 인증번호 유효시간은 10분입니다."){
				const btn = document.querySelector(".email-btn");
				btn.disabled = true;
				btn.classList.add("gray");
				emailValue.readOnly = true;
				TIMER();
			}else{
				return false;
			}
		});
	} 
	
	function checkEmailCode() {
		const btn = document.querySelector(".email-btn");
		const email = document.querySelector("#emailInputTag").value;
		if(btn.disabled !== true){
			alert("이메일 인증번호 발급을 진행하세요.");
			return false 
		}
		const AuthenticationKey = document.querySelector("input[name=AuthenticationKey]").value;
		fetch("/nongra/email/findId", {
		    method: 'POST',
		    headers: {
		      'Content-Type': 'application/x-www-form-urlencoded',
		    },
		    body: 'AuthenticationKey=' + AuthenticationKey,
		  })
		    .then(response => response.json())
		    .then(data => {
		      if (data === "인증이 성공하였습니다.") {
		    	  
		    	 alert(data);
		    	 
				 // 성공시 페이지 이동 
				 console.log("성공했어");
				 const modal=document.querySelector(".modal");
			     modal.classList.toggle("modal-none");
		      } else {
				alert(data);
		      }
		    })
		    .catch(error => {
		      console.error("응 실패했어", error);
		    });
	}
	
	const Timer = document.getElementById('Timer'); // 스코어 기록창-분
	let time = 300000; // 5분을 밀리초로 표현
	let min = 5; // 시작 분
	let sec = 0; // 시작 초

	Timer.value = min + ":" + '00';

	function TIMER() {
	  const timer = document.querySelector(".Timer");
	  timer.style.display='block';
	  PlAYTIME = setInterval(function () {
	    time = time - 1000; // 1초씩 줄어듦
	    min = time / (60 * 1000); // 초를 분으로 나눠준다.

	    if (sec > 0) {
	      // sec=60 에서 1씩 빼서 출력해준다.
	      sec = sec - 1;
	      Timer.value = Math.floor(min) + ':' + (sec < 10 ? '0' + sec : sec); // sec이 10보다 작으면 앞에 0을 추가하여 출력
	    }

	    if (sec === 0) {
	      // 0에서 -1을 하면 -59가 출력된다.
	      // 그래서 0이 되면 바로 sec을 60으로 돌려주고 value에는 0을 출력하도록 해준다.
	      sec = 60;
	      Timer.value = Math.floor(min) + ':' + '00';
	    }

	  }, 1000); // 1초마다
	}

	setTimeout(function () {
	  clearInterval(PlAYTIME);
	}, 300000); // 5분이 되면 타이머를 삭제한다.
	
	function changePwd() {
		
		const id = document.querySelector("input[name=id]").value;
		const pwd = document.querySelector("input[name=pwd]").value;
		const pwd_re = document.querySelector("input[name=pwd_re]").value;
		const memberEmail = document.querySelector("input[name=email]").value;
		
		if(!pwd){
			alert("비밀번호를 입력해주세요.");
			form.password.focus();
			return false;
		}
		if(!pwd_re){
			alert("비밀번호를 입력해주세요.");
			form.password.focus();
			return false;
		}
		if(pwd !== pwd_re){
			alert("비밀번호를 일치하지 않습니다.");
			form.password.focus();
			return false;
		}
		const MemberVo = function (id,memberEmail,pwd,pwd_re){
			this.memberId = id ,
			this.email = memberEmail ,
			this.memberPwd = pwd ,
			this.memberPwd2 = pwd_re 
		}

		const vo = new MemberVo(id,memberEmail,pwd,pwd_re);

		fetch("/nongra/email/updatePwd", {
		    method: 'POST',
		    body: JSON.stringify(vo)
		  })
		  // 중괄호 없으면 바로리턴
		  .then(resp => resp.text())
		  .then( data => {
			alert(data)
			if(data === "비밀번호 변경이 성공했습니다."){
				location.href="/nongra/seller/login";
			}
		  } )
		  .catch(()=>{alert("오류발생!!")})
	}
	
</script>