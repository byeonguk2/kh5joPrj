/*한줄씩 요소 선택*/
const trArr = document.querySelectorAll("table > tbody > tr");

/* 삭제 버튼 */
const removeBtn = document.querySelectorAll(".removeBtn");
console.log(removeBtn);
for(let i = 0; i < removeBtn.length; ++i){
	removeBtn[i].addEventListener('click',function(event){
		const cartBreakDownNo = event.currentTarget.parentNode.parentNode.parentNode.children[2].children[0].children[2].innerText;
		//서버한테 요청을 보내기
		fetch("http://127.0.0.1:8888/nongra/cart/AJAX/remove?cartBreakDownNo=" + cartBreakDownNo)
		.then( (resp) => { return resp.json() } )
		.then( (x) => { 
			const cartBreakDownNo = x.cartBreakDownNo;
			console.log(i);
			window.location.reload();
		} );
		
		
		
	});//삭제버튼이벤트
}



/* 수량 증가,감소 버튼 */
const plusBtnArr = document.querySelectorAll(".upBtn");
console.log(plusBtnArr);
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
		fetch("http://127.0.0.1:8888/nongra/cart/AJAX/update?cartBreakDownNo=" + cartBreakDownNo + "&cartBreakDownEa=" + cartBreakDownEA)
		.then( (resp) => { return resp.json() } )
		.then( (x) => { 
			console.log(x);
		} );
		f02();
		f03();
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
		fetch("http://127.0.0.1:8888/nongra/cart/AJAX/update?cartBreakDownNo=" + cartBreakDownNo + "&cartBreakDownEa=" + cartBreakDownEA)
		.then( (resp) => { return resp.json() } )
		.then( (x) => { 
			console.log(x);
		} );
		f02();
		f03();
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
const oneTotalprice = document.querySelectorAll(".oneTotalprice");
function f02() {
	const onePrice = document.querySelectorAll(".onePrice");
	const price = document.querySelectorAll(".price");
	const optionPrice = document.querySelectorAll(".optionPrice")
	for(let i = 0; i < onePrice.length; i++){
		price[i].innerText = (onePrice[i].innerText)*(upDownNo[i].innerText);
		oneTotalprice[i].innerText = (parseInt(onePrice[i].innerText)+parseInt(optionPrice[i].innerText))*(upDownNo[i].innerText);
	}
};
f02();


/* 전체금액 + 주문하기 버튼 */
const totalPrice = document.querySelector("#totalPrice");
function f03() {
	totalPrice.innerText = 0;
	for(let i = 0; i < upDownNo.length; i++){
		totalPrice.innerText = parseInt(totalPrice.innerText) + parseInt(oneTotalprice[i].innerText);
	}
}
f03();