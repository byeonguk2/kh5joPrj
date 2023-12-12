function deliveryPopup() {
    window.open("/nongra/address/shipping-address/list","배송지","width=580px, height=400px,left=100,top=50");
}


const simpleDetailBtn = document.querySelector(".simpleDetailBtn");
const simple = document.querySelector(".simpleVerArea");
const detail = document.querySelector(".detailVerArea");
simpleDetailBtn.addEventListener("click", ()=>{
    simpleDetailBtn.classList.toggle("click");
    if(simpleDetailBtn.classList.contains('click')){
        simple.classList.add('simpleDetailChange');
        detail.classList.remove('simpleDetailChange');
    }else{
        simple.classList.remove('simpleDetailChange');
        detail.classList.add('simpleDetailChange');
    };
});


function onePrice () {
    const ea = document.querySelectorAll(".product-cnt-area");
    const price = document.querySelectorAll(".product-one-price");
    const timesprice = document.querySelectorAll(".product-times-price");
    for(i = 0; i < ea.length; i++){
        timesprice[i].innerText = ea[i].innerText * price[i].innerText;
    }
}
onePrice();

function totalPrice() {
    const timesprice = document.querySelectorAll(".product-times-price");
    const payBtn = document.querySelector('#pay-btn-price');
    const payTable = document.querySelector('.pay-table-price');
    for(i = 0; i < timesprice.length; i++){
        payBtn.innerText = parseInt(payBtn.innerText) + parseInt(timesprice[i].innerText);
        payTable.innerText = parseInt(payTable.innerText) + parseInt(timesprice[i].innerText);
    }
    
}
totalPrice();


/*모달창*/
//켜기
const modal = document.getElementById("modal")
const btnModal = document.getElementById("btn-modal")
btnModal.addEventListener("click", e => {
    modal.style.display = "flex"
})
//x눌러서끄기
const closeBtn = modal.querySelector(".close-area")
closeBtn.addEventListener("click", e => {
    modal.style.display = "none"
})
//바깥 영역 눌러서 끄기
modal.addEventListener("click", e => {
    const evTarget = e.target
    if(evTarget.classList.contains("modal-overlay")) {
        modal.style.display = "none"
    }
})
//esc눌러서 끄기
window.addEventListener("keyup", e => {
    if(modal.style.display === "flex" && e.key === "Escape") {
        modal.style.display = "none"
    }
})

//켜기
const modal2 = document.getElementById("modal2")
const btnModal2 = document.getElementById("btn-modal2")
btnModal2.addEventListener("click", e => {
    modal2.style.display = "flex"
})
//x눌러서끄기
const closeBtn2 = modal2.querySelector(".close-area2")
closeBtn2.addEventListener("click", e => {
    modal2.style.display = "none"
})
//바깥 영역 눌러서 끄기
modal2.addEventListener("click", e => {
    const evTarget = e.target
    if(evTarget.classList.contains("modal-overlay")) {
        modal2.style.display = "none"
    }
})
//esc눌러서 끄기
window.addEventListener("keyup", e => {
    if(modal2.style.display === "flex" && e.key === "Escape") {
        modal2.style.display = "none"
    }
})






