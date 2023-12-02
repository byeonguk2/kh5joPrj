// 체크시 이미지 변경
function checkAll(){
    if(document.getElementById("all").checked==true){  //id 를 사용하여 하나의 객체만을 호출
          for(var i=0;i<3;i++) document.getElementsByName("checkBox")[i].checked=true;   //name 을 사용하여 배열 형태로 담아 호출
       }
       if(document.getElementById("all").checked==false){
          for(var i=0;i<3;i++) document.getElementsByName("checkBox")[i].checked=false;  
       }
 }
const idInput = document.querySelectorAll(".css-gaqliy");
const idCheck = document.querySelectorAll(".css-16yppgg");

// 입력시 중복체크 버튼 활성화
idInput[0].addEventListener("keyup",()=>{
 const x = idInput[0].value.length;
 if(x !== 0){
     idCheck[0].disabled = false;
     return;
 }
 idCheck[0].disabled = true;
})
// idInput[1].addEventListener("keyup",()=>{
//     console.log(idInput[1].value.length);
//     const x = idInput[1].value.length;
//     if(x !== 0){
// 		idCheck[1].disabled = false;
// 		return;
// 	}
// 	idCheck[1].disabled = true;
// })
// idInput[4].addEventListener("keyup",()=>{
//     console.log(idInput[4].value.length);
//     const x = idInput[4].value.length;
//     if(x !== 0){
// 		idCheck[2].disabled = false;
// 		return;
// 	}
// 	idCheck[2].disabled = true;
// })

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
     alert("아이디에 특수문자를 사용할 수 없습니다.");
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
     form.password.focus();
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

function sample6_execDaumPostcode() {
	new daum.Postcode({
		oncomplete: function(data) {
			// 팝업에서 검색결과 항목을 클릭했을때 실행할 코드를 작성하는 부분.

			// 각 주소의 노출 규칙에 따라 주소를 조합한다.
			// 내려오는 변수가 값이 없는 경우엔 공백('')값을 가지므로, 이를 참고하여 분기 한다.
			var addr = ''; // 주소 변수

			//사용자가 선택한 주소 타입에 따라 해당 주소 값을 가져온다.
			if (data.userSelectedType === 'R') { // 사용자가 도로명 주소를 선택했을 경우
				addr = data.roadAddress;
			} else { // 사용자가 지번 주소를 선택했을 경우(J)
				addr = data.jibunAddress;
			}
			// 우편번호와 주소 정보를 해당 필드에 넣는다.
			document.querySelector('#addr_num').value = data.zonecode;
			document.querySelector('#load_num').value = addr;
			// 커서를 상세주소 필드로 이동한다.
			document.querySelector('#detail_address').focus();
		}
	}).open();
}