const side3 = document.querySelector(".sitem1 > .side-icon2");  
        console.log(side3); 
        side3.addEventListener("click",()=>{
            const menu = document.querySelectorAll(".menu");
            side3.classList.toggle("rotate");
            for(let i =0; i<menu.length; i++){
                menu[i].classList.toggle("plus-menu");
            }
        });