<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet"
	href="/nongra/resources/css/member/member_modify.css">
<script defer src="/nongra/resources/js/member/member_modify.js"></script>
</head>
<body>
	<div id="wrap">
		<%@ include file="/WEB-INF/views/common/header/header_sobi_memberModify.jsp"%>
		<div id="a">
		<%@ include file="/WEB-INF/views/common/aside/aside_sobi_main.jsp"%>
		<form name="form" action="https://www.naver.com/">
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
							<input type="text" name="user_nick" id="user_nick"
								class="txt placeholder" placeholder="닉네임" maxlength="12"
								value=""
								onkeypress="if(event.keyCode== 40 || event.keyCode == 41) event.returnValue = false;"
								onkeydown="chkLength(this, 12, 'nick');" onpaste="return false">
							<button class="btn1" style='cursor: pointer;'
								onclick="return checkNickName();">중복확인</button>
							<button class="btn2" style='cursor: pointer;' id="change_nick">닉네임
								변경</button>
						</div>
						<p class="txt">- 게시물 작성시 보이는 닉네임입니다.(최대 한글 6자 영문 12자)</p>
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
							<input type="password" name="password" class="txt2"
								placeholder="현재 비밀번호" maxlength="15"
								onkeypress="return checkData(this, event, 15, 1, 0);"
								onkeyup="return checkHangleData(this);"> <span
								class="itxts">영문/숫자/특수문자 조합으로 10~15자, 대소문자 구분</span>
						</div>
						<div class="block">
							<input type="password" name="new_password1" class="txt2"
								placeholder="새 비밀번호" maxlength="15"
								onkeypress="return checkData(this, event, 15, 0, 1);"
								onkeyup="return checkHangleData(this);" aria-autocomplete="list">
							<span class="itxts" id="pwd_notice" style="display: none">영문/숫자/특수문자
								조합으로 10~15자, 대소문자 구분</span> <span class="ierrorifx">10~15자로
								입력해주세요.</span>
							<!-- 에러메시지 -->
						</div>
						<div class="block">
							<input type="password" name="new_password2" class="txt2"
								placeholder="새 비밀번호 확인" maxlength="15"
								onkeypress="return checkData(this, event, 15, 0, 1);"
								onkeyup="return checkHangleData(this);"> <span
								class="ierrorifx2">10~15자로 입력해주세요.</span>
							<!-- 에러메시지 -->
						</div>
						<p id="session_msg" class="itxt">비밀번호를 변경하면 현재 기기를 제외한 연결된
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
								name="road_address" id="road_address" value="" readonly="">
						</div>
						<div class="block_last1">
							<input type="text" class="txt_length01" placeholder="상세 주소"
								name="detail_address" id="detail_address" value="">
						</div>
						<!-- <p id="address" class="addr_num" style="">지번주소: 서울특별시 용산구 이촌동 300-11 왕궁아파트 왕궁아파트</p> -->

					</dd>
					<dt class="phone line">
						<span>휴대폰 번호</span>
					</dt>
					<dd class="line">
						<div class="block_last">
							<input type="text" name="mobile" class="phonetxt"
								placeholder="휴대폰 번호" value=""> <span
								class="ierror">ex) 010-0000-0000</span>
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
							<input type="text" name="email1" class="txt length02"
								placeholder="메일주소" value=""> <span class="at">@</span>
							<input type="text" name="email2" class="txt length02"
								placeholder="메일주소" value=""> <select
								onclick="selectMail()" name="select_email" id="select_email">
								<option>메일주소선택</option>
								<option name="mailoption" value="naver.com">naver.com</option>
								<option name="mailoption" value="nate.com">nate.com</option>
								<option name="mailoption" value="gmail.com">gmail.com</option>
								<option name="mailoption" value="hanmail.net">hanmail.net</option>
								<option name="mailoption" value="self">직접입력</option>
							</select> <input type="hidden" name="org_email" value="jay6266@naver.com">
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
		<script
			src="//t1.daumcdn.net/mapjsapi/bundle/postcode/prod/postcode.v2.js"></script>



</body>
</html>