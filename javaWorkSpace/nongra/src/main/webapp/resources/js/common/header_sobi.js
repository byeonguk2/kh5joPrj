const header = document.querySelector('header');
const headerheight = header.clientHeight;
document.addEventListener('scroll', onScroll);

function onScroll(){
    const scrollpsition = pageYOffset;
    const nav = document.querySelector('nav');
    if(headerheight<=scrollpsition){
        nav.classList.add('nav-down')
    }else{
        nav.classList.remove('nav-down');
    }
}
