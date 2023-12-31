// 체크시 이미지 변경
function checkAll(){
	   if(document.getElementById("all").checked==true){  //id 를 사용하여 하나의 객체만을 호출
	         for(var i=0;i<3;i++) document.getElementsByName("checkBox")[i].checked=true;   //name 을 사용하여 배열 형태로 담아 호출
	      }
	      if(document.getElementById("all").checked==false){
	         for(var i=0;i<3;i++) document.getElementsByName("checkBox")[i].checked=false;  
	      }
	}
const input = document.querySelectorAll(".css-gaqliy");
const idCheck = document.querySelectorAll(".css-16yppgg");

const input2 = document.querySelectorAll(".input-nick");
const nickCheck = document.querySelectorAll(".checkNick");

const input3 = document.querySelectorAll(".input-email");
const emailCheck = document.querySelectorAll(".checkEmail");

// 입력시 중복체크 버튼 활성화
input[0].addEventListener("keyup",()=>{
   const x = input[0].value.length;
   console.log(x);
   if(x !== 0){
		idCheck[0].disabled = false;
		return;
	}
	idCheck[0].disabled = true;
})

// 입력시 중복체크 버튼 활성화
input2[0].addEventListener("keyup",()=>{
	console.log("나옴")
   const x = input2[0].value.length;
   console.log(x);
   if(x !== 0){
		nickCheck[0].disabled = false;
		return;
	}
	nickCheck[0].disabled = true;
})


// 입력시 중복체크 버튼 활성화
input3[0].addEventListener("keyup",()=>{
	console.log("나옴")
   const x = input3[0].value.length;
   console.log(x);
   if(x !== 0){
		emailCheck[0].disabled = false;
		return;
	}
	emailCheck[0].disabled = true;
})

// 회원가입 유효성 검사

const form = document.joinForm;

function join(){
	let hangleCheck = /[ㄱ-ㅎ|ㅏ-ㅣ|가-힣]/
	// //value를 조건식 안에서 사용하면
	// //값이 있을 때 true, 값이 없을 때 false
	// //비밀번호 안에 아이디가 있을 때
	// //비밀번호에 공백을 포함할 수 없다.
	// //비밀번호와 비밀번호 확인 값이 같은지 확인
	var regExp = /^[a-z0-9]{4,12}$/;

	if(!regExp.test(form.id.value)){
		alert("아이디에 형식이 맞지 않습니다");
		form.id.focus();
		return false;
	}
	
	if(!form.id.value){
		alert("아이디를 입력해주세요.");
		form.id.focus();
		return false;
	}
	
	//아이디에 한글이 있으면 안된다.
	if(hangleCheck.test(form.id.value)){
		alert("아이디에 한글을 사용할 수 없습니다.");
		form.password.focus();
		return false;
	}
	
	if(form.id.value.length < 4 || form.id.value.length > 16){
		alert("아이디는 4자 이상, 16자 이하로 입력해주세요.")
		form.id.focus();
		return false;
	}
	if(!form.nick.value){
		alert("닉네임을 입력해주세요.");
		form.nick.focus();
		return false;
	}
	if(!form.password.value){
		alert("비밀번호를 입력해주세요.");
		form.password.focus();
		return false;
	}
	
	//8자리 이상, 대문자, 소문자, 숫자, 특수문자 모두 포함되어 있는 지 검사
	let reg = /^(?=.*?[A-Z])(?=.*?[a-z])(?=.*?[0-9])(?=.*?[#?!@$%^&*-]).{8,}$/;
	
	if(!reg.test(form.password.value)){
		alert("비밀번호는 8자리 이상이어야 하며, 대문자/소문자/숫자/특수문자 모두 포함해야 합니다.");
		form.password.focus();
		return false;
	}
	
	//같은 문자를 4번 사용할 수 없다.
	if(/(\w)\1\1\1/.test(form.password.value)){
		alert("같은 문자를 4번 이상 사용하실 수 없습니다.");
		form.password.focus();
		return false;
	}
	
	if(form.password.value.search(form.id.value) != -1){
		alert("비밀번호에 아이디를 포함할 수 없습니다.");
		form.password.focus();
		return false;
	}
	
	//비밀번호에 한글이 있으면 안된다.
	if(hangleCheck.test(form.password.value)){
		alert("비밀번호에 한글을 사용할 수 없습니다.");
		form.password.focus();
		return false;
	}
	
	if(form.password.value.search(/\s/) != -1){
		alert("비밀번호에 공백 없이 입력해주세요.");
		form.password.focus();
		return false;
	}
    //\s 는 스페이스바임.
	
   if(form.password.value != form.password_re.value){
		alert("비밀번호를 확인해주세요.");
		form.password_re.focus();
		return false;
	}

	if(!form.name.value){
		alert("이름을 입력해주세요.");
		form.name.focus();
		return false;
	}
	if(!form.email.value){
		alert("이메일을 입력해주세요.");
		form.email.focus();
		return false;
	}
	if(form.phone.value.length !== 11){
		alert("전화번호 11자리를 입력해 주세요.");
		form.phone.focus();
		return false;
	}
	if(!form.id.readOnly){
		alert("아이디 중복 검사를 진행해주세요.");
		return false;
	}
	if(!form.nick.readOnly){
		alert("닉네임 중복 검사를 진행해주세요.");
		return false;
	}
	
	if(!form.email.readOnly){
		alert("이메일 중복 검사를 진행해주세요.");
		return false;
	}
	
	const allCkbox= document.querySelectorAll("input[name=checkBox]");
	for(var i=0; i<=allCkbox.length; i++){
	if(allCkbox[i].checked == false){
		alert("약간동의에 체크를 해주세요.");
   	return false;
       // break;
   }
}
	
	form.submit();
}

document.querySelector('input[name=id]').addEventListener("click", function(){
	form.id.readOnly = false;
})
document.querySelector('input[name=nick]').addEventListener("click", function(){
	form.nick.readOnly = false;
})
document.querySelector('input[name=email]').addEventListener("click", function(){
	form.email.readOnly = false;
})
// 닉네임 체크
function checkNick(){
	var xhr = new XMLHttpRequest();
	const from = document.querySelector("#form");
	
	if(from.nick.value.length < 1){
		document.querySelector("#nickGuide").innerHTML = '닉네임이 짧습니다.';
		return false;
	}
	
	xhr.open("GET", "/nongra/seller/nickCheck?nick="+document.querySelector("input[name=nick]").value, true);
	// 요청을 보내줌
	xhr.send();
	
	console.log(from.nick.value);
	//요청에 대한 응답이오면 실행되는 함수
	xhr.onreadystatechange = function(){
		if(xhr.readyState == XMLHttpRequest.DONE && xhr.status == 200){
			xhr.responseText.trim()
			console.log(xhr.responseText);

			document.getElementById("nickGuide").innerHTML = xhr.responseText.trim();

			if(xhr.responseText === "사용가능한 닉네임 입니다."){
				form.nick.readOnly = true;
				form.checkbtn2.disabled = true;
			}else {
				form.nick.value = "";
			}

		}
	}
}

function checkId(){
	var xhr = new XMLHttpRequest();
	let hangleCheck = /[ㄱ-ㅎ|ㅏ-ㅣ|가-힣]/
	if(hangleCheck.test(document.getElementById("id").value)){
		document.getElementById("result").innerHTML = "아이디에 한글을 사용할 수 없습니다."
		return false;
	}

	xhr.open("GET", "/nongra/seller/idCheck?id=" + document.getElementById("id").value, true);
	// 요청을 보내줌
	xhr.send();
	
	
	//요청에 대한 응답이오면 실행되는 함수
	xhr.onreadystatechange = function(){
		if(xhr.readyState == XMLHttpRequest.DONE && xhr.status == 200){
			xhr.responseText.trim()
			
			console.log(xhr.responseText);
			document.getElementById("result").innerHTML = xhr.responseText.trim();
			if(xhr.responseText === "사용가능한 아이디 입니다." ){
				form.id.readOnly = true;
				form.checkbtn.disabled = true;
			}else {
				form.id.value = "";
			}
		}
	}
}

function checkemail(){
	
	const email = document.querySelector("input[name=email]");
	console.log(email.value);
	
	fetch("/nongra/seller/emailCheck?email="+email.value)
	.then((resp)=>{
		return resp.text();
	})
	.then((data)=>{
		document.querySelector("#emailGuide").innerHTML = data;
		if(data === "사용가능한 이메일 입니다."){
			form.email.readOnly = true;
			form.checkbtn3.disabled = true;
		}else{
			form.email.value = "";
		}
	})

}


//안내
function checkMsg(){
	let hangleCheck = /[ㄱ-ㅎ|ㅏ-ㅣ|가-힣]/
	//아이디에 한글이 있으면 안된다.
	if(hangleCheck.test(form.id.value)){
		document.getElementById("idMsg").innerHTML = "아이디에 한글을 사용할 수 없습니다.";
		return false;
	}
}

function checkMsg2(){
	let hangleCheck = /[ㄱ-ㅎ|ㅏ-ㅣ|가-힣]/
	let reg = /^(?=.*?[A-Z])(?=.*?[a-z])(?=.*?[0-9])(?=.*?[#?!@$%^&*-]).{8,}$/;
	if(/(\w)\1\1\1/.test(form.password.value)){
		document.getElementById("passMsg").innerHTML =	"같은 문자를 4번 이상 사용하실 수 없습니다.";
		return false;
	}
	if(form.password.value.search(form.id.value) != -1 && form.id.value.length !== 0){
		document.getElementById("passMsg").innerHTML = "비밀번호에 아이디를 포함할 수 없습니다.";
		return false;
	}
}
function checkMsg3(){
	if(form.password.value === form.password_re.value && form.password.value.length > 7){
		document.getElementById("passMsg_re").innerHTML = "비밀번호를 일치합니다.";
		return false;
	}else{
		document.getElementById("passMsg_re").innerHTML = "";
		return false;
	}
}
function checkMsg4(){
	console.log(form.phone.value.length);
	if(form.phone.value.length === 3){
		if(form.phone.value !== '010'){
			document.getElementById("phoneMsg").innerHTML = "010 형식으로 입력해주세요.";
			form.phone.value = "";
			return false;
		}
	}
	if(form.phone.value.length > 11){
		form.phone.value = "";
		return false;
	}
	if(form.phone.value.length === 11){
		document.getElementById("phoneMsg").innerHTML = "전화번호 길이가 일치합니다.";
		return false;
	}else {
		document.getElementById("phoneMsg").innerHTML = "전화번호 11자리를 입력해 주세요.";
		return false;
	}
}

