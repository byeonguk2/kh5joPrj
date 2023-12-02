const aside = document.querySelector("aside");
        const hamburger = document.querySelector(".hamburger");
        // document.createElement(".delete");
        console.log(aside);
        console.log(hamburger);
        hamburger.addEventListener("click",() => {
            aside.classList.toggle("delete")
            console.log(aside);
        });
       
        const side = document.querySelector(".sitem1 > .down_icon");   
        side.addEventListener("click",()=>{
            const menu = document.querySelectorAll(".menu"); 
            side.classList.toggle("rotate");
            for(let i = 0; i < 2; i++){
                menu[i].classList.toggle("plus-menu");
            }
        });
        const side2 = document.querySelector(".sitem2 > .down_icon");   
        side2.addEventListener("click",()=>{
            const menu = document.querySelectorAll(".menu"); 
            side2.classList.toggle("rotate");
        });
        const side3 = document.querySelector(".sitem3 > .down_icon");  
        console.log(side2); 
        side3.addEventListener("click",()=>{
            const menu = document.querySelectorAll(".menu");
            side3.classList.toggle("rotate");
            for(let i = 2; i < 4; i++){
                menu[i].classList.toggle("plus-menu");
            }
        });
        const side4 = document.querySelector(".sitem4 > .down_icon");   
        side4.addEventListener("click",()=>{
            const menu = document.querySelectorAll(".menu"); 
            side4.classList.toggle("rotate");
        });
        const side5 = document.querySelector(".sitem5 > .down_icon");   
        side5.addEventListener("click",()=>{
            const menu = document.querySelectorAll(".menu"); 
            side5.classList.toggle("rotate");
        });
        const side6 = document.querySelector(".sitem6 > .down_icon");   
        side6.addEventListener("click",()=>{
            const menu = document.querySelectorAll(".menu"); 
            side6.classList.toggle("rotate");
        });
        const side7 = document.querySelector(".sitem7 > .down_icon");   
        side7.addEventListener("click",()=>{
            const menu = document.querySelectorAll(".menu"); 
            side7.classList.toggle("rotate");
        });
        const side8 = document.querySelector(".sitem8 > .down_icon");   
        side8.addEventListener("click",()=>{
            const menu = document.querySelectorAll(".menu"); 
            side8.classList.toggle("rotate");
        });
        const side9 = document.querySelector(".sitem9 > .down_icon");  
        console.log(side3); 
        side9.addEventListener("click",()=>{
            const menu = document.querySelectorAll(".menu");
            side9.classList.toggle("rotate");
            for(let i = 4; i < 6; i++){
                menu[i].classList.toggle("plus-menu");
            }
        });
        const side10 = document.querySelector(".sitem10 > .down_icon");   
        side10.addEventListener("click",()=>{
            const menu = document.querySelectorAll(".menu"); 
            side10.classList.toggle("rotate");
        });
        const side11 = document.querySelector(".sitem11 > .down_icon");   
        side11.addEventListener("click",()=>{
            const menu = document.querySelectorAll(".menu"); 
            side11.classList.toggle("rotate");
        });