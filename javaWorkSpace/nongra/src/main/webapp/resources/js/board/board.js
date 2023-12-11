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
const eventListItems = document.querySelectorAll(".event_li > a");

        eventListItems.forEach(function(item){
            item.addEventListener('click', function(){
                const eventNo = this.querySelector(".hidden_post_no").textContent;
                location.href = '/nongra/event/detail?no=' + eventNo + '&currPage=<%=pvo.getCurrentPage() %>';
            });
        });

function askMoreList(requestedPageCnt = 1){
    fetch("/nongra/contact/notice/ask?no=" + requestedPageCnt)
    .then((resp) => {return resp.json(); })
    .then((data) => {setMoreList(data); })
}
function setMoreList(data){

    const addedVoList = data;
    console.log(addedVoList);
    for(let i = 0; i <addedVoList.length; i++){
        const postListTag = document.createElement("li");
        postListTag.className = "post_list";

        const change_cursorTag = document.createElement("div");
        change_cursorTag.className = "post change_cursor";

        const postTitleTag = document.createElement("div");
        postTitleTag.className = "post_title_normal";
        postTitleTag.innerHTML = addedVoList[i].title;
        
        const postDateTag = document.createElement("div");
        postDateTag.className = "post_date";
        postDateTag.innerHTML = addedVoList[i].getEnrollDate;

        const postDetailTag = document.createElement("div");
        postDetailTag.className = "post_detail";
        postDetailTag.innerHTML = addedVoList[i].getContent;

        const openArrowTag = document.createElement("span");
        openArrowTag.className = "open_arrow";

        const svgTag = document.createElement("svg");
        svgTag.className = "svg1";

        postListTag.appendChild(change_cursorTag);

        change_cursorTag.appendChild(postTitleTag);
        change_cursorTag.appendChild(postDateTag);
        change_cursorTag.appendChild(postDetailTag);
        change_cursorTag.appendChild(openArrowTag);

        openArrowTag.appendChild(svgTag);

        document.querySelector(".board_list").appendChild(postListTag);
    }
}