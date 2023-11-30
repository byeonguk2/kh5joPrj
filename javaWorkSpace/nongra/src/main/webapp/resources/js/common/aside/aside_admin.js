// document.createElement(".delete");
const aside = document.querySelector("aside");

  window.addEventListener('scroll', function() {
    const scrollPosition = window.pageYOffset;
    console.log(aside.clientHeight);

    if (headerHeight <= scrollPosition) {
      aside.classList.add('fixed');
      
    } else {
      aside.classList.remove('fixed');
    }
  });