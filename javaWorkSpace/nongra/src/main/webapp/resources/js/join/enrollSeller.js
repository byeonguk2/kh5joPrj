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
			document.getElementById('sample6_postcode').value = data.zonecode;
			document.getElementById("sample6_address").value = addr;
			// 커서를 상세주소 필드로 이동한다.
			document.getElementById("sample6_detailAddress").focus();
		}
	}).open();
}

const an = document.querySelector('.left-target');
console.log(an);
an.addEventListener('keydown',()=>{
	an.classList.remove('left');
});
an.addEventListener('blur',()=>{
	an.classList.add('left');
	console.log(an);
});
const form = document.joinForm;

function checkNoaml(event){
	if(event.target.checked == true){
		form.corporation_name.value = "";
		form.corporation_name.readOnly = true;
		document.getElementById("passMsg_re").innerHTML = "일반사업자는 작성하지 마세요.";
	}
}
function checkNoaml2(event){
	if(event.target.checked == true){
		form.corporation_name.readOnly = false;
		document.getElementById("passMsg_re").innerHTML = "법인사업자 번호를 입력해주세요.";
	}
}
function enrollCheck(){
	if(form.business_no.value.length !== 10){
		alert("사업자 번호는 10자리 입니다.")
		return false;
	}
	if(!form.business_name.value){
		alert("사업장명을 입력해주세요.")
		return false;
	}
	if(!form.business_phone.value){
		alert("사업장 전화번호를 입력해주세요.")
		return false;
	}
	if(!form.corporation_name.value){
		if(form.chk_info.value === '법인사업자'){
			alert("법인명을 입력해주세요.")
			return false;
		}
	}
	if(!form.uptae.value){
			alert("업태를 입력해주세요.")
			return false;
	}
	if(!form.upjong.value){
		alert("업종을 입력해주세요.")
		return false;
	}	
	if(!form.sample6_postcode.value&&!form.sample6_address.value){
		alert("주소를 검색하세요.")
		return false;
	}	
	if(!form.sample6_detailAddress.value){
		alert("상세주소를 입력하세요.")
		return false;
	}	
	if(!form.sell_no.value){
		alert("통신 판매업 신고번호를 입력하세요.")
		return false;
	}
	if(form.bank.value === "none"){
		alert("은행을 선택하세요.")
		return false;
	}
	if(!form.depositor.value){
		alert("입금자명을 입력하세요.")
		return false;
	}
	if(!form.account.value){
		alert("입금계좌를 입력하세요.")
		return false;
	}
}