const editBtn = document.querySelectorAll('.edit-button');
for(let i = 0; i < editBtn.length; i++){
    editBtn[i].addEventListener('click',(event)=>{
        const addressNo = event.currentTarget.parentNode.parentNode.children[1].children[1].innerText;
        console.log(addressNo);
    })
}