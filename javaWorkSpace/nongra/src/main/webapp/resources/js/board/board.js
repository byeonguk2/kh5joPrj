//공지사항, FAQ 아코디언 
toggleDetail();
function toggleDetail(){
    const postListItems = document.querySelectorAll('.post_list');

        postListItems.forEach(function (item) {
            item.addEventListener('click', function () {
                const postDetail = this.querySelector('.post_detail, .qna_detail');

                // 다른 게시글이 열려 있다면 닫기
                postListItems.forEach(function (otherItem) {
                    const otherDetail = otherItem.querySelector('.post_detail, .qna_detail');
                    if (otherItem !== item && otherDetail.style.display !== 'none') {
                        otherDetail.style.display = 'none';
                    }
                });

                // 클릭한 게시글의 내용을 토글
                if (postDetail.style.display === 'none') {
                    postDetail.style.display = 'block';
                } else {
                    postDetail.style.display = 'none';
                }
            });
        });
    }



const eventListItems = document.querySelectorAll(".event_li > a");

        eventListItems.forEach(function(item){
            item.addEventListener('click', function(){
                const eventNo = this.querySelector(".hidden_post_no").textContent;
                location.href = '/nongra/event/detail?no=' + eventNo + '&currPage=<%=pvo.getCurrentPage() %>';
            });
        });
let currentPage;

//더보기 버튼
function askMoreList(){
    if(!currentPage){
        currentPage = 1;
    }
    fetch("/nongra/contact/notice/ask?pno=" + currentPage)
    .then((resp) => {return resp.json(); })
    .then((data) => {
        setMoreList(data);
        currentPage++;
     })
}
function setMoreList(data) {
    const addedVoList = data;
    console.log(addedVoList);

    for (let i = 0; i < addedVoList.length; i++) {
        const postListTag = document.createElement("li");
        postListTag.className = "post_list";

        const change_cursorTag = document.createElement("div");
        change_cursorTag.className = "post change_cursor";

        const postTitleTag = document.createElement("div");
        postTitleTag.className = "post_title_normal";
        postTitleTag.innerHTML = addedVoList[i].title;

        const postDateTag = document.createElement("div");
        postDateTag.className = "post_date";
        postDateTag.innerHTML = addedVoList[i].enrollDate;

        const postDetailTag = document.createElement("div");
        postDetailTag.className = "post_detail";
        postDetailTag.innerHTML = addedVoList[i].content;

        const openArrowTag = document.createElement("span");
        openArrowTag.className = "open_arrow";

        const svgTag = document.createElement("svg");
        svgTag.className = "svg1";
        svgTag.setAttribute("width", "24px");
        svgTag.setAttribute("height", "24px");
        
        

        const pathTag = document.createElement("path");
        pathTag.setAttribute("d", "M11.057 8L5.53 13.529c-.26.26-.26.682 0 .942.26.26.682.26.942 0l6-6c.26-.26.26-.682 0-.942l-6-6c-.26-.26-.682-.26-.942 0-.26.26-.26.682 0 .942L11.057 8z");
        pathTag.style.fill = "#888888";
        pathTag.style.fillRule = "nonzero";

        postListTag.appendChild(change_cursorTag);
        postListTag.appendChild(postDetailTag);

        change_cursorTag.appendChild(postTitleTag);
        change_cursorTag.appendChild(postDateTag);
        change_cursorTag.appendChild(openArrowTag);

        openArrowTag.appendChild(svgTag);
        svgTag.appendChild(pathTag);


        document.querySelector(".board_list").appendChild(postListTag);
    }

    // 이벤트 리스너 다시 등록
    const postListItems = document.querySelectorAll('.post_list');

    postListItems.forEach(function (item) {
        item.addEventListener('click', function () {
            const postDetail = this.querySelector('.post_detail, .qna_detail');

            // 다른 게시글이 열려 있다면 닫기
            postListItems.forEach(function (otherItem) {
                const otherDetail = otherItem.querySelector('.post_detail, .qna_detail');
                if (otherItem !== item && otherDetail.style.display !== 'none') {
                    otherDetail.style.display = 'none';
                }
            });

            // 클릭한 게시글의 내용을 토글
            if (postDetail.style.display === 'none') {
                postDetail.style.display = 'block';
            } else {
                postDetail.style.display = 'none';
            }
        });
    });
}

//FAQ 버튼탭
// 페이지 로드 시 실행할 초기화 함수
document.addEventListener('DOMContentLoaded', function () {
    // 탭 버튼들을 선택
    const tabButtons = document.querySelectorAll('.btn_faq_tab');

    // 각 탭 버튼에 클릭 이벤트 리스너 추가
    tabButtons.forEach(function (button, index) {
        button.addEventListener('click', function () {
            // 현재 활성화된 탭 버튼이 있는지 확인
            const activeButton = document.querySelector('.btn_faq_tab.on');

            // 현재 활성화된 탭 버튼이 있다면 on 클래스 제거
            if (activeButton) {
                activeButton.classList.remove('on');
            }

            // 현재 클릭한 탭 버튼에 on 클래스 추가
            button.classList.add('on');

            // categoryNo 설정 (index + 1로 설정, 1부터 시작하므로)
            const cateNo = index + 1;

            // 여기에서 categoryNo를 사용하여 다른 작업 수행
            console.log('Selected cateNo:', cateNo);
            askListbyCateNo(cateNo);
        });
    });
});

//카테고리별 목록조회 
function askListbyCateNo(cateNo){
    const pno = 1;
    fetch("/nongra/contact/faq/ask?cateNo=" + cateNo + "&pno=" + pno)
    .then((resp) => {return resp.json(); })
    .then((data) => {
        setListbyCateNo(data);
        })
}
function setListbyCateNo(data) {
    const addedVoList = data;
    console.log(addedVoList);
    

    const boardList = document.querySelector(".board_list");
    boardList.innerHTML = "";

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



