function deliveryPopup() {
    window.open("/nongra/address/shipping-address/list","배송지","width=580px, height=400px,left=100,top=50");
}
function modiftPopup() {
    window.open("/nongra/order/checkout/receiver-details","배송지","width=580px, height=400px,left=100,top=50");
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
