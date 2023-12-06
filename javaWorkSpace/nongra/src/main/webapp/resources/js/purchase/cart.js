/*수량버튼*/
const down = document.querySelector('.downBtn');
down.addEventListener('click',()=>{
    let number = document.querySelector('.upDownNo').innerText;
    if(number == 0){
        document.querySelector('.upDownNo').innerText = number;
    }else{
        document.querySelector('.upDownNo').innerText = number - 1;
    }

})
const up = document.querySelector('.upBtn');
up.addEventListener('click',()=>{
    let number = document.querySelector('.upDownNo').innerText;
    document.querySelector('.upDownNo').innerText = parseInt(number) + 1;
})

/*한줄씩 요소 선택*/
const trArr = document.querySelectorAll("table > tbody > tr");
for(let i = 0; i < trArr.length; ++i){
	trArr[i].children[6].addEventListener('click', removeBtnClick);
}
function removeBtnClick(btn){
	
}