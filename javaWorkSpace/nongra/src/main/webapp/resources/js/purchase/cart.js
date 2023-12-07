/*한줄씩 요소 선택*/
const trArr = document.querySelectorAll("table > tbody > tr");

/* 삭제 버튼 */
for(let i = 0; i < trArr.length; ++i){
	trArr[i].children[6].addEventListener('click', removeBtnClick);
}
function removeBtnClick(btn){
	console.log("언젠가는 누르면 상품 삭제시킬 버튼")	
}


/* 감소버튼AJAX */
function ea(event){
	const cartBreakDownNo = event.currentTarget.parentNode.parentNode.parentNode.children[2].children[0].children[2].innerText;
	const cartBreakDownEA = event.currentTarget.parentNode.children[1].innerText;
/*	//서버한테 요청을 보내기
	fetch("http://127.0.0.1:8888/nongra/cart/AJAX?cartBreakDownNo=" + cartBreakDownNo + "&cartBreakDownEa=" + )
	.then( (resp) => { return resp.json() } )
	.then( (x) => { 
		console.log(x);
	} );*/
}


/* 수량 증가,감소 버튼 */
/* 증가 */
const plusBtnArr = document.querySelectorAll(".upBtn");
const minusBtnArr = document.querySelectorAll(".downBtn");
for(let i = 0; i < plusBtnArr.length; ++i){
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
		
		
	});//plusBtnArr이벤트
	
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
	});//minusBtnArr이벤트
}//for문








/*

내역번호
console.log(trArr[0].children[2].children[0].children[2].innerText);

수량버튼
console.log(trArr[0].children[3].children[0].children[0].innerHTML);
console.log(trArr[0].children[3].children[0].children[1].innerHTML);
console.log(trArr[0].children[3].children[0].children[2].innerHTML);*/