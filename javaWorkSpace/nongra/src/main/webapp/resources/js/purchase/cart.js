

    const down = document.querySelector('.product-cnt-down');
    down.addEventListener('click',()=>{
        let number = document.querySelector('.product-cnt').innerText;
        if(number == 0){
            document.querySelector('.product-cnt').innerText = number;
        }else{
            document.querySelector('.product-cnt').innerText = number - 1;
        }

    })
    const up = document.querySelector('.product-cnt-up');
    up.addEventListener('click',()=>{
        let number = document.querySelector('.product-cnt').innerText;
        document.querySelector('.product-cnt').innerText = parseInt(number) + 1;
    })