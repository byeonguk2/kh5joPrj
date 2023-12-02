<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" href="/nongra/resources/css/member/member_join.css">
    <script defer src="/nongra/resources/js/member/member_join.js"></script>
</head>
<body>
	<div id="entire-area">
        <div>
            <h1>회원가입</h1>
            <form action="/nongra/seller/join" method="post" name="joinForm" onsubmit="return join()">
                <div class="css-1pfwvb8">
                    <p class="css-1qif6pj">필수입력사항</p>
                    <div class="css-1og0zk9">
                        <p class="css-3y93rl">
                            아이디
                            <span class="css-1o72o4s">*</span>
                        </p>
                        <div class="css-gjavw0">
                       		<input id="id" onkeydown="checkMsg()" name="id" autocomplete="user-name" placeholder="6자 이상의 영문 혹은 영문과 숫자를 조합" class="css-gaqliy" value="">
                            <button type="button" id="checkbtn" onclick="checkId()" class="css-16yppgg" disabled="">중복확인</button>
                        </div>
                    </div>
                    <div class="css-1og0zk92">
                    	<p class="css-3y93rl"></p>
                    	<div class="rowletter-area">
                        	<span id="idMsg">아이디는 4자 이상, 16자 이하로 입력해주세요.</span>
                        	<span id="result">x아이디 중복확인</span>
                    	</div>
                    </div>
                    <div class="css-1og0zk9">
                        <p class="css-3y93rl">
                            닉네임
                            <span class="css-1o72o4s">*</span>
                        </p>
                        <div class="css-gjavw0">
                            <input name="nick"placeholder="닉네임을 입력해주세요" class="css-gaqliy">
                        </div>
                    </div>
                    <div id="nick" class="css-1og0zk92">
                    	<p class="css-3y93rl"></p>
                    	<div class="rowletter-area">
                        	<span>닉네임에 부적절한 용어는 사용할 수 없습니다.</span>
                    	</div>
                    </div>
                    <div class="css-1og0zk9">
                        <p class="css-3y93rl">
                            비밀번호
                            <span class="css-1o72o4s">*</span>
                        </p>
                        <div class="css-gjavw0">
                            <input type="password" onkeyup="checkMsg2()" name="password" placeholder="비밀번호를 입력해 주세요" class="css-gaqliy">
                        </div>
                    </div>
                    <div  class="css-1og0zk92">
                    	<p class="css-3y93rl"></p>
                    	<div class="rowletter-area">
                        	<span id="passMsg">비밀번호는 8자리 이상이어야 하며, 대문자/소문자/숫자/특수문자 모두 포함해야 합니다.</span>
                    	</div>
                    </div>
                    <div class="css-1og0zk9">
                        <p class="css-3y93rl">
                            비밀번호 확인
                            <span class="css-1o72o4s">*</span>
                        </p>
                        <div class="css-gjavw0">
                            <input type="password" onkeyup="checkMsg3()" name="password_re" placeholder="비밀번호를 한 번 더 입력해 주세요" class="css-gaqliy">
                        </div>
                    </div>
                    <div class="css-1og0zk92">
                    	<p class="css-3y93rl"></p>
                    	<div class="rowletter-area">
                        	<span id="passMsg_re"></span>
                    	</div>
                    </div>
                    
                    <div class="css-1og0zk9">
                        <p class="css-3y93rl">
                            이름
                            <span class="css-1o72o4s">*</span>
                        </p>
                        <div class="css-gjavw0">
                            <input name="name" placeholder="성함을 입력해주세요" class="css-gaqliy">
                        </div>
                    </div>
                    <div class="css-1og0zk92">
                    	<p class="css-3y93rl"></p>
                    	<div class="rowletter-area">
                        	<span></span>
                    	</div>
                    </div>
                    <div class="birth">
                        <p class="css-3y93rl">
                            생년월일
                            <span class="css-1o72o4s">*</span>
                        </p>
                        
                        <label id="date" for="date" >날짜를 선택하세요:
                            <input id="date2" type="date"
                                   id="date"
                                   max="2023-11-27"
                                   min="1940-06-05"
                                   value="2023-08-21">
                          </label>
                    </div>
                    <div class="css-1og0zk92">
                    	<p class="css-3y93rl"></p>
                    	<div class="rowletter-area">
                        	<span></span>
                    	</div>
                    </div>
                    <div class="css-1og0zk9">
                        <p class="css-3y93rl">
                            전화번호
                            <span class="css-1o72o4s">*</span>
                        </p>
                        <div class="css-gjavw0">
                            <input type="number" onkeyup="checkMsg4()" name="phone" placeholder="숫자만 입력해 주세요" class="css-gaqliy">
                        </div>
                    </div>
                    <div class="css-1og0zk92">
                    	<p class="css-3y93rl"></p>
                    	<div class="rowletter-area">
                        	<span id="phoneMsg"></span>
                    	</div>
                    </div>
                    <div class="css-1og0zk9">
                        <p class="css-3y93rl">
                            이메일
                            <span class="css-1o72o4s">*</span>
                        </p>
                        <div class="css-gjavw0">
                            <input type="email" name="email" placeholder="이메일을 입력해 주세요" class="css-gaqliy">
                        </div>
                    </div>
                    <div class="css-1og0zk92">
                    	<p class="css-3y93rl"></p>
                    	<div class="rowletter-area">
                        	<span></span>
                    	</div>
                    </div>

                    <div class="css-1og0zk9">
                        <p class="css-3y93rl">
                            주소
                            <span class="css-1o72o4s">*</span>
                        </p>
                        <div class="css-gjavw0">
                            <input  name="postnum" placeholder="우편번호" class="css-gaqliy" id="addr_num">
                            <button type="button" style='cursor:pointer;' class="btn1" onclick="sample6_execDaumPostcode()"  >주소 찾기</button>
                        </div>
                    </div>
                    <div class="css-1og0zk9">
                        <p class="css-3y93rl">
                            
                        </p>
                        <div class="css-gjavw0">
                            <input  name="loadnum" placeholder="도로명주소" class="css-gaqliy" id="load_num">
                        </div>
                    </div>
                    <div class="css-1og0zk9">
                        <p class="css-3y93rl">
                            
                        </p>
                        <div class="css-gjavw0">
                            <input  name="detailaddress" placeholder="상세주소" class="css-gaqliy" id="detail_address">
                        </div>
                    </div>


                    
                <div class="css-1jq3evw">
                    <div class="css-y8jzgf">
                        <p class="css-1l9ha14">
                            이용약관 동의
                            <span class="css-1o72o4s">*</span>
                        </p>
                        <div class="css-1kxq9ne">
                            <label class="css-te3lwu" >
                                <input id="all" type="checkbox" onclick='checkAll()'>
                                <div>
                                    <p class="css-9e3umx">전체 동의합니다</p>
                                    <p class="css-rgntm7">선택항목에 동의하지 않은 경우도 회원가입 및 일반적인 서비스를 이용할 수 있습니다.</p>
                                </div>
                           </label>
                            <label class="css-te3lwu">
                                <input  type="checkbox"  name="checkBox">
                                <div class="css-1sa9fvm">
                                    <p>
                                        판매 이용약관 동의
                                        <span class="css-1ame89c">(필수)</span>
                                    </p>
                                    <button type="button" class="css-1kxzrwz">약관보기 &gt;</button>
                                </div>
                            </label>
                            <label class="css-te3lwu">
                                <input type="checkbox"  name="checkBox">
                                <div class="css-1sa9fvm">
                                    <p>
                                        전자거래금융거래 이용약관 동의
                                        <span class="css-1ame89c">(필수)</span>
                                    </p>
                                    <button type="button" class="css-1kxzrwz">약관보기 &gt;</button>
                                </div>
                            </label>
                            <label class="css-te3lwu">
                                <input type="checkbox"  name="checkBox">
                                <div class="css-1sa9fvm">
                                    <p>
                                        판매자 개인정보 수집 및 이용동의
                                        <span class="css-1ame89c">(필수)</span>
                                    </p>
                                    <button type="button" class="css-1kxzrwz">약관보기 &gt;</button>
                                </div>
                            </label>
                        </div>
                    </div>
                </div>
                <div class="last">
                    <button type="button" class="last-btn l-a" onclick="location.href='/nongra/home'">홈으로</button>
                    <button class="last-btn l-b">가입하기</button>
                </div>
            </form>
        </div>
    </div>
</body>
<script src="//ajax.googleapis.com/ajax/libs/jquery/1/jquery.min.js"></script>
<script src="//t1.daumcdn.net/mapjsapi/bundle/postcode/prod/postcode.v2.js"></script>
</body>
</html>