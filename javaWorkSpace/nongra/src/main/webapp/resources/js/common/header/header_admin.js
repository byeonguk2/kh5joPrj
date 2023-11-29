const fixed = document.querySelector("#nav-main");
window.addEventListener('scroll', function(){
  if(window.scrollY > 150){
	  console.log(window.pageYOffset);
	  fixed.classList.add('fixed');
  }else {
	  fixed.classList.remove("fixed");
  }
 
});