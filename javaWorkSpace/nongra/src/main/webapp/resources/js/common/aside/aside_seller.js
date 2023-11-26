const aside = document.querySelector("aside");
        const hamburger = document.querySelector(".hamburger");
        // document.createElement(".delete");
        console.log(aside);
        console.log(hamburger);
        hamburger.addEventListener("click",() => {
            aside.classList.toggle("delete")
            console.log(aside);
        });
       
        const side = document.querySelector(".sitem1 > .side-icon2");   
        side.addEventListener("click",()=>{
            const menu = document.querySelectorAll(".menu"); 
            side.classList.toggle("rotate");
            for(let i = 0; i < 2; i++){
                menu[i].classList.toggle("plus-menu");
            }
        });
        const side2 = document.querySelector(".sitem2 > .side-icon2");   
        side2.addEventListener("click",()=>{
            const menu = document.querySelectorAll(".menu"); 
            side2.classList.toggle("rotate");
        });
        const side3 = document.querySelector(".sitem3 > .side-icon2");  
        console.log(side2); 
        side3.addEventListener("click",()=>{
            const menu = document.querySelectorAll(".menu");
            side3.classList.toggle("rotate");
            for(let i = 2; i < 4; i++){
                menu[i].classList.toggle("plus-menu");
            }
        });
        const side4 = document.querySelector(".sitem4 > .side-icon2");   
        side4.addEventListener("click",()=>{
            const menu = document.querySelectorAll(".menu"); 
            side4.classList.toggle("rotate");
        });
        const side5 = document.querySelector(".sitem5 > .side-icon2");   
        side5.addEventListener("click",()=>{
            const menu = document.querySelectorAll(".menu"); 
            side5.classList.toggle("rotate");
        });
        const side6 = document.querySelector(".sitem6 > .side-icon2");   
        side6.addEventListener("click",()=>{
            const menu = document.querySelectorAll(".menu"); 
            side6.classList.toggle("rotate");
        });
        const side7 = document.querySelector(".sitem7 > .side-icon2");   
        side7.addEventListener("click",()=>{
            const menu = document.querySelectorAll(".menu"); 
            side7.classList.toggle("rotate");
        });
        const side8 = document.querySelector(".sitem8 > .side-icon2");   
        side8.addEventListener("click",()=>{
            const menu = document.querySelectorAll(".menu"); 
            side8.classList.toggle("rotate");
        });
        const side9 = document.querySelector(".sitem9 > .side-icon2");  
        console.log(side3); 
        side9.addEventListener("click",()=>{
            const menu = document.querySelectorAll(".menu");
            side9.classList.toggle("rotate");
            for(let i = 4; i < 6; i++){
                menu[i].classList.toggle("plus-menu");
            }
        });
        const side10 = document.querySelector(".sitem10 > .side-icon2");   
        side10.addEventListener("click",()=>{
            const menu = document.querySelectorAll(".menu"); 
            side10.classList.toggle("rotate");
        });
        const side11 = document.querySelector(".sitem11 > .side-icon2");   
        side11.addEventListener("click",()=>{
            const menu = document.querySelectorAll(".menu"); 
            side11.classList.toggle("rotate");
        });