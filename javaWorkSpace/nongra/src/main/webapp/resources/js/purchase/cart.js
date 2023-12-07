/*수량버튼*/
/*const down = document.querySelector('.downBtn');
down.addEventListener('click',()=>{
    let number = document.querySelector('.upDownNo').innerText;
    if(number == 0){
        document.querySelector('.upDownNo').innerText = number;
    }else{
        document.querySelector('.upDownNo').innerText = number - 1;
    }

})*/
const up = document.querySelector('.upBtn');
up.addEventListener('click',()=>{
    let number = document.querySelector('.upDownNo').innerText;
    document.querySelector('.upDownNo').innerText = parseInt(number) + 1;
})

/*한줄씩 요소 선택*/
const trArr = document.querySelectorAll("table > tbody > tr");

/* 삭제 버튼 */
for(let i = 0; i < trArr.length; ++i){
	trArr[i].children[6].addEventListener('click', removeBtnClick);
}
function removeBtnClick(btn){
	console.log("언젠가는 누르면 상품 삭제시킬 버튼")	
}






/* 감소 */
for(let i = 0; i < trArr.length; ++i){
	/*-버튼 요소*/
	console.log('for1');
	console.log(i);
	console.log('for2');
	trArr[i].children[3].children[0].children[0].addEventListener('click',down(i))

}
function down(i){
	
	console.log('down1');
	console.log(i);
	console.log('down2');
	let number = trArr[i].children[3].children[0].children[1].innerText;
	console.log(number);
	console.log('down3');
	if(number == 0){
		trArr[i].children[3].children[0].children[1].innerText = number;
	}else{
		trArr[i].children[3].children[0].children[1].innerText = number - 1;
	}	
}

for(let i = 0; i < trArr.length; ++i){
	/*+버튼 요소*/
	trArr[0].children[3].children[0].children[2]
}



/*

내역번호
console.log(trArr[0].children[2].children[0].children[2].innerText);

수량버튼
console.log(trArr[0].children[3].children[0].children[0].innerHTML);
console.log(trArr[0].children[3].children[0].children[1].innerHTML);
console.log(trArr[0].children[3].children[0].children[2].innerHTML);*/