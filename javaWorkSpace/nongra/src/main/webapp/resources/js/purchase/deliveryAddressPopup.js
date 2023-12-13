//배송지 선택 버튼
const button = document.querySelectorAll('.button');
const img = document.querySelectorAll('.img');

for(let i = 0; i < img.length; i++){
    button[i].addEventListener('click', (event)=>{
        event.currentTarget.classList.toggle('button-checked');
        event.currentTarget.children[0].classList.toggle('img-checked');
        
        const addressNo = event.currentTarget.parentNode.parentNode.children[1].children[0].children[0].innerText;
        const addr = event.currentTarget.parentNode.parentNode.children[1].children[0].children[2].innerText;
        const addrName = event.currentTarget.parentNode.parentNode.children[1].children[0].children[3].children[0].innerText;
        const phone = event.currentTarget.parentNode.parentNode.children[1].children[0].children[3].children[1].innerText;
        
        let parentAddressNo = window.opener.document.querySelector('#addrNo').value;
        // let parentAddr = window.opener.document.querySelector('#addr').innerText;
        // let parentAddrName = window.opener.document.querySelector('#addrName').innerText;
        // let parentPhone = window.opener.document.querySelector('#addrPhone').innerText;
        
        addressNo = parentAddressNo;
        // addr = parentAddr;
        // addrName = parentAddrName;
        // phone = parentPhone;
        
        window.close();

        
    })
}

//수정버튼
const editBtn = document.querySelectorAll('.edit-button');
for(let i = 0; i < editBtn.length; i++){
    editBtn[i].addEventListener('click',(event)=>{
        const addressNo = event.currentTarget.parentNode.parentNode.children[1].children[0].children[0].innerText;

        opener.location.href='/nongra/address/shipping-address/update?addressNo='+addressNo
        window.close();

    })
}

const addAddress = document.querySelector('#addAddress');
addAddress.addEventListener('click', ()=>{
    opener.location.href='/nongra/address/shipping-address';
    window.close();
})