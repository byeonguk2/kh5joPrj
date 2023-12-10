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
