<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet"
	href="/nongra/resources/css/member/member_modify.css">
<script defer src="/nongra/resources/js/common/header/header_sobi.js"></script>
<script defer src="/nongra/resources/js/member/member_modify.js"></script>
</head>
<body>
	<div id="wrap">
		<%@ include file="/WEB-INF/views/common/header/header_sobi_memberModify.jsp"%>
		<div id="a">
		<%@ include file="/WEB-INF/views/common/aside/aside_sobi_main.jsp"%>
		<form onsubmit="return passwordCheck()" id="form" action="/nongra/member/modify" method="post">
			<div class="main">
				<h2 class="management">내 정보 관리</h2>
				<div id="box">내 정보 변경</div>
				<p class="info_txt">회원가입 시 입력하신 정보를 확인, 수정할 수 있습니다.</p>
				<h3 class="nickname">닉네임 설정</h3>


				<dl class="box2">
					<dt class="nick">
						<span>닉네임 설정</span>
					</dt>
					<dd>
						<div class="block">
							<input type="text" name="nick" id="user_nick"
								class="txt placeholder" placeholder="닉네임" maxlength="12"
								value="<%= loginMember.getMemberNick() %>"
								onkeypress="if(event.keyCode== 40 || event.keyCode == 41) event.returnValue = false;"
								onkeydown="chkLength(this, 12, 'nick');" onpaste="return false">
							<button type="button" class="btn1" style='cursor: pointer;'onclick="checkNick()">중복확인</button>
							<button class="btn2" style='cursor: pointer;' id="change_nick">닉네임변경</button>
						</div>
						<p id="ssss" class="txt">- 게시물 작성시 보이는 닉네임입니다.(최대 한글 6자 영문 12자)</p>
						<p class="txt">- 닉네임 변경 시, 24시간 후에 재변경이 가능합니다.</p>
					</dd>
				</dl>
				<h3 class="password" id="pwd_title">비밀번호 변경</h3>

				<dl class="box3">
					<dt class="password2">
						<span id="pwd_detail">비밀번호</span>
					</dt>
					<dd>
						<div id="old_pwd" class="block">
							<input type="password" name="oldpassword" class="txt2" value="<%= loginMember.getMemberPwd() %>"
								placeholder="현재 비밀번호" maxlength="15"
								> <span
								class="itxts">영문/숫자/특수문자 조합으로 10~15자, 대소문자 구분</span>
						</div>
						<div class="block">
							<input type="password" name="password" class="txt2"
								placeholder="새 비밀번호" maxlength="15"
								 aria-autocomplete="list">
							<span class="itxts" id="pwd_notice" style="display: none">영문/숫자/특수문자
								조합으로 10~15자, 대소문자 구분</span> <span class="ierrorifx">10~15자로
								입력해주세요.</span>
							<!-- 에러메시지 -->
						</div>
						<div class="block">
							<input type="password" name="password_re" class="txt2" 
								placeholder="새 비밀번호 확인" maxlength="15"
								onkeyup="passwordCheck2()"> <span
								class="ierrorifx2">10~15자로 입력해주세요.</span>
							<!-- 에러메시지 -->
						</div>
						<p id="session_msg" class="itxt ">비밀번호를 변경하면 현재 기기를 제외한 연결된
							기기에서 로그인 계정이 모두 로그아웃 됩니다.</p>
							
					</dd>
				</dl>
				<h3 class="privacy">개인정보 수정</h3>
				<dl class="box4">
					<dt class="address">
						<span>주소</span>
					</dt>
					<dd id="adr">
						<div class="block">
							<input type="text" class="address_num" placeholder="우편번호"
								name="zipno" value="" readonly="">
							<button type="button" style='cursor: pointer;' class="btn1"
								onclick="sample6_execDaumPostcode()">주소 찾기</button>
						</div>
						<!-- <div class="block">
                                        <input type="text" class="txt length01" placeholder="지번 주소" name="address" id="address" value=""/>
                                    </div> -->
						<div class="block">
							<input type="text" class="txt_length01" placeholder="도로명 주소"
								name="road_address" id="road_address" value="<%= loginMember.getAddr() %>" readonly="">
						</div>
						<div class="block_last1">
							<input type="text" class="txt_length01" placeholder="상세 주소"
								name="detail_address" id="detail_address" value="<%= loginMember.getAddr2() %>">
						</div>
						<!-- <p id="address" class="addr_num" style="">지번주소: 서울특별시 용산구 이촌동 300-11 왕궁아파트 왕궁아파트</p> -->

					</dd>
					<dt class="phone line">
						<span>휴대폰 번호</span>
					</dt>
					<dd class="line">
						<div class="block_last">
							<input type="text" name="mobile" class="phonetxt"
								placeholder="휴대폰 번호" value="<%= loginMember.getPhone() %>"> <span
								class="ierror">ex) 01000000000</span>
							<p id="sns_phone_msg" style="display: none">
								인증하신 휴대폰 번호가 변경되신 경우 <a
									href="https://help.afreecatv.com/atv.php?type=exMailQuestion"
									target="_blank">1:1 문의하기</a>를 이용해 주세요.
							</p>
						</div>
					</dd>

					<dt class="email line">
						<span>이메일</span>
					</dt>
					<dd class="line">
						<div class="block_last2">
							<input type="text" name="email" class="txt length02"
								placeholder="메일주소" value="<%= loginMember.getEmail() %>"> 
							
						</div>
					</dd>

					<dt class="capcha line">
						<span>보안문자 입력</span>
					</dt>
					<dd class="line">
						<div class="block_last">
							<span class="number"><img id="img_security"
								src="https://afevent2.afreecatv.com/app/security_char/afreeca_security_char.php"
								alt="캡차이미지"></span> <input type="text" id="security"
								name="security" class="txt length03" placeholder=""> <span
								class="itxts2">프로그램을 이용한 자동변경 방지를 위해 보안문자를<br>받고
								있습니다. 왼쪽에 보이는 문자를 입력하여 주세요.
							</span>
						</div>
					</dd>

				</dl>
				<div class="btn3">
					<button style='cursor: pointer;' type="submit" class="btn_confirm">확인</button>
				</div>
				<!-- <a href="https://www.naver.com/" class="button1">확인</a>     -->

			
			</div>
		</form>
		</div>
		</div>
		<script src="//t1.daumcdn.net/mapjsapi/bundle/postcode/prod/postcode.v2.js"></script>
		<script>
		// 닉네임 체크
		function checkNick() {
			var xhr = new XMLHttpRequest();
			const from = document.querySelector("#form");

			if (from.nick.value.length < 1) {
				document.querySelector("#nick_re").innerHTML = '닉네임이 짧습니다.';
				return false;
			}

			xhr.open("GET", "/nongra/seller/nickCheck?nick=" + document.querySelector("input[name=nick]").value, true);
			// 요청을 보내줌
			xhr.send();

			console.log(from.nick.value);
			//요청에 대한 응답이오면 실행되는 함수
			xhr.onreadystatechange = function() {
				if (xhr.readyState == XMLHttpRequest.DONE && xhr.status == 200) {
					xhr.responseText.trim()
					console.log(xhr.responseText);
					console.log(document.querySelector("#ssss"));
					document.querySelector("#ssss").innerHTML = xhr.responseText;
				}
			}
		}
		
		function passwordCheck() {
			const from = document.querySelector("#form");
			if(from.password.value !== from.password_re.value){
				alert("패스워드 확인이 일치하지 않습니다.");
				return false;
			}
		}
		function passwordCheck2(){
			const form=document.querySelector("#form");
			 if(form.password.value === form.password_re.value){
			     document.getElementById("session_msg").innerHTML = "비밀번호를 일치합니다.";
			     document.getElementById("session_msg").classList.add("red");
			     return false;
			 }else{
			     document.getElementById("session_msg").innerHTML = "비밀번호가 일치하지 않습니다.";
			     document.getElementById("session_msg").classList.add("red");
			     return false;
			 }
		}
		</script>
		
		

</body>
</html>