  const header = document.querySelector("header");
  const fixed = document.querySelector("#nav-main"); // 대상 요소 지정
  const headerHeight = header.clientHeight;

  window.addEventListener('scroll', function() {
    const scrollPosition = window.pageYOffset;
    if (headerHeight <= scrollPosition) {
      fixed.classList.add('fixed');
    } else {
      fixed.classList.remove('fixed');
    }
  });