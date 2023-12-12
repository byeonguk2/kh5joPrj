// 더보기 버튼 클릭 시 호출될 함수
function takeFaqCateNo() {
    // 현재 활성화된 FAQ 탭의 인덱스를 가져오기
    const activeTab = document.querySelector('.btn_faq_tab.on');
    const cateNo = Array.from(document.querySelectorAll('.btn_faq_tab')).indexOf(activeTab) + 1;

    // 더보기 버튼 클릭 시 함수 호출
    askFaqMoreList(cateNo);
}


//더보기 버튼

function askFaqMoreList(cateNo){
    let currentPage = 1;

    fetch("/nongra/contact/faq/ask?cateNo=" + cateNo + "&pno=" + currentPage)
    .then((resp) => {return resp.json(); })
    .then((data) => {
        setFaqMoreList(data);
        currentPage++;
     })
}
function setFaqMoreList(data) {
    const addedVoList = data;
    console.log(addedVoList);



    for (let i = 0; i < addedVoList.length; i++) {
        const postListTag = document.createElement("li");
        postListTag.className = "post_list";
//
        const change_cursorTag = document.createElement("div");
        change_cursorTag.className = "post faq_change_cursor";

        const postDetailTag = document.createElement("div");
        postDetailTag.className = "post_detail";
        postDetailTag.innerHTML = addedVoList[i].content;
//
        const qMarkTag = document.createElement("span");
        qMarkTag.className = "post_q";
        qMarkTag.innerHTML = "Q";

        const postTitleTag = document.createElement("span");
        postTitleTag.className = "post_title_faq";
        postTitleTag.innerHTML = addedVoList[i].title;

        const openArrowTag = document.createElement("span");
        openArrowTag.className = "open_arrow";
//
        const svgTag = document.createElement("svg");
        svgTag.className = "svg1";
        svgTag.setAttribute("width", "24px");
        svgTag.setAttribute("height", "24px");

        const pathTag = document.createElement("path");
        pathTag.setAttribute("d", "M11.057 8L5.53 13.529c-.26.26-.26.682 0 .942.26.26.682.26.942 0l6-6c.26-.26.26-.682 0-.942l-6-6c-.26-.26-.682-.26-.942 0-.26.26-.26.682 0 .942L11.057 8z");
        pathTag.style.fill = "#888888";
        pathTag.style.fillRule = "nonzero";
//
        postListTag.appendChild(change_cursorTag);
        postListTag.appendChild(postDetailTag);

        change_cursorTag.appendChild(qMarkTag);
        change_cursorTag.appendChild(postTitleTag);
        change_cursorTag.appendChild(openArrowTag);

        openArrowTag.appendChild(svgTag);
        svgTag.appendChild(pathTag);

        document.querySelector(".board_list").appendChild(postListTag);
    }
    toggleDetail();

    
}



