/*한줄씩 요소 선택*/
const trArr = document.querySelectorAll("table > tbody > tr");

/* 삭제 버튼 */
for(let i = 0; i < trArr.length; ++i){
	trArr[i].children[6].addEventListener('click', removeBtnClick);
}
function removeBtnClick(btn){
	console.log("언젠가는 누르면 상품 삭제시킬 버튼")	
}


/* 수량 증가,감소 버튼 */
const plusBtnArr = document.querySelectorAll(".upBtn");
const minusBtnArr = document.querySelectorAll(".downBtn");
for(let i = 0; i < plusBtnArr.length; ++i){
	/* 증가 */
	plusBtnArr[i].addEventListener('click', function(event){
		const upDownNo = event.currentTarget.parentNode.children[1];
		upDownNo.innerText = parseInt(upDownNo.innerText) + 1;
		if(upDownNo.innerText == 2){
		event.currentTarget.parentNode.children[0].children[0].classList.remove('disabled');
		}
	
		const cartBreakDownNo = event.currentTarget.parentNode.parentNode.parentNode.children[2].children[0].children[2].innerText;
		const cartBreakDownEA = event.currentTarget.parentNode.children[1].innerText;	
		
		//서버한테 요청을 보내기
		fetch("http://127.0.0.1:8888/nongra/cart/AJAX?cartBreakDownNo=" + cartBreakDownNo + "&cartBreakDownEa=" + cartBreakDownEA)
		.then( (resp) => { return resp.json() } )
		.then( (x) => { 
			console.log(x);
		} );
		f02();
	});//plusBtnArr이벤트
	
	/* 감소 */
	minusBtnArr[i].addEventListener('click', function(event){
		const upDownNo = event.currentTarget.parentNode.children[1];
		if(upDownNo.innerText == 1){
			upDownNo.innerText = upDownNo.innerText; 			
		}else{
			upDownNo.innerText = parseInt(upDownNo.innerText) - 1;
			if(upDownNo.innerText == 1){
			event.currentTarget.children[0].classList.add('disabled');
			}
		}
		
		const cartBreakDownNo = event.currentTarget.parentNode.parentNode.parentNode.children[2].children[0].children[2].innerText;
		const cartBreakDownEA = event.currentTarget.parentNode.children[1].innerText;	
		
		//서버한테 요청을 보내기
		fetch("http://127.0.0.1:8888/nongra/cart/AJAX?cartBreakDownNo=" + cartBreakDownNo + "&cartBreakDownEa=" + cartBreakDownEA)
		.then( (resp) => { return resp.json() } )
		.then( (x) => { 
			console.log(x);
		} );
		f02();
	});//minusBtnArr이벤트
}//for문
/* 처음부터 수량 1일때 -버튼 색 바꿈 */
const upDownNo = document.querySelectorAll(".upDownNo");
function f01(){
	for(let i = 0; i < upDownNo.length; i++){
		if(upDownNo[i].innerText == 1){
			minusBtnArr[i].children[0].classList.add('disabled');
		}
		
	}
};
f01();

/* 가격 */
function f02() {
	const onePrice = document.querySelectorAll(".onePrice");
	const price = document.querySelectorAll(".price");
	const optionPrice = document.querySelectorAll(".optionPrice")
	const oneTotalprice = document.querySelectorAll(".oneTotalprice");
	for(let i = 0; i < onePrice.length; i++){
		console.log(onePrice[i].innerText);
		console.log(oneTotalprice[i].innerText);
		price[i].innerText = (onePrice[i].innerText)*(upDownNo[i].innerText);
		oneTotalprice[i].innerText = (parseInt(onePrice[i].innerText)+parseInt(optionPrice[i].innerText))*(upDownNo[i].innerText);
	}
};
f02();


/* 전체금액 + 주문하기 버튼 */
const totalPrice = document.querySelector("#totalPrice");
const oneTotalprice = document.querySelectorAll(".oneTotalprice");
function f03() {
	for(let i = 0; i < upDownNo.length; i++){
		totalPrice.innerText = parseInt(totalPrice.innerText) + parseInt(oneTotalprice[i].innerText);
	}
}
f03();