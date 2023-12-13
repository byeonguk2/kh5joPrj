
// 사이드바 글자 생성
function createAsideLetter(){
	
	const x = document.querySelector(".aside-item > label");
	const menu1 = document.querySelector(" aside > :nth-child(2) > a ");
	const menu2 = document.querySelector(" aside > :nth-child(3) > a ");
	const menu3 = document.querySelector(" aside > :nth-child(4) > a ");
	const menu4 = document.querySelector(" aside > :nth-child(5) > a ");
	
	x.innerHTML = "회원관리";
	menu1.innerHTML = "회원 조회/수정";
	menu1.href = "/nongra/admin/findAllMembers";
	menu2.innerHTML = "회원 정지/해제";
	menu2.href = "/nongra/admin/memberBen";
	menu3.innerHTML = "사업자 허가 여부";
	menu3.href = "/nongra/admin/request";
	menu4.innerHTML = "탈퇴 요청 허가 여부";
	menu4.href = "/nongra/admin/acceptQuit";
	
}

createAsideLetter()
		
function getModal(x,yn) {

	const modal = document.querySelector(".modal");
	const modal2 = document.querySelector(".modal2");

	// 한명의 회원 정보 가져오기
	fetch('/nongra/admin/checkAllMembers?no='+x)
	.then((response)=>{ return response.json();})
	.then((data)=>{
		if(yn == 'Y'){
			
			// 모달에 값들 넣기 (판매자)
			modal.classList.toggle("modal_up");
			document.querySelector(".mtc1").value = data.businessNo;
			document.querySelector(".mtc2").value = data.businessForm;
			document.querySelector(".mtc3").value = data.busineesName;
			document.querySelector(".mtc4").value = data.busineesPhone;
			document.querySelector(".mtc5").value = data.busineesZipCode;
			document.querySelector(".mtc6").value = data.busineesAdr;
			document.querySelector(".mtc7").value = data.detailedAdr;
			document.querySelector(".mtc8").value = data.corporationName;
			document.querySelector(".mtc9").value = data.uptae;
			document.querySelector(".mtc10").value = data.upjong;
			document.querySelector(".mtc11").value = data.reportNumber;
			document.querySelector(".mtc12").value = data.bank;
			document.querySelector(".mtc13").value = data.depositor;
			document.querySelector(".mtc14").value = data.account;
			document.querySelector(".mtc15").value = data.id;
			document.querySelector(".mtc16").value = data.password;
			document.querySelector(".mtc17").value = data.nick;
			document.querySelector(".mtc18").value = data.name;
			document.querySelector(".mtc19").value = data.email;
			document.querySelector(".sellerYn1").value = yn;
			document.querySelector(".memberNo").value = data.memberNo;
	
		}else{
		
			// 모달에 값 넣기 (소비자)
			modal2.classList.toggle("modal_up");
			document.querySelector(".mtc2-1").value = data.id;
			document.querySelector(".mtc2-2").value = data.password;
			document.querySelector(".mtc2-3").value = data.nick;
			document.querySelector(".mtc2-4").value = data.name;
			document.querySelector(".mtc2-5").value = data.email;
			document.querySelector(".mtc2-6").value = data.phone;
			document.querySelector(".mtc2-7").value = data.birthDay;
			document.querySelector(".mtc2-8").value = data.point;
			document.querySelector(".mtc2-9").value = data.memberAddress;
			document.querySelector(".mtc2-10").value = data.memberDetailAddress;
			document.querySelector(".sellerYn2").value = yn;
			document.querySelector(".memberNo2").value = data.memberNo;
		
		}
	});
		
}
			
function downModal() {
	
	// 모달창 내리기 (판매자)
	const modal = document.querySelector(".modal");
	modal.classList.toggle("modal_up");
	
}

function downModal2() {
	
	// 모달창 내리기 (소비자)
	const modal2 = document.querySelector(".modal2");
	modal2.classList.toggle("modal_up");
	
}



