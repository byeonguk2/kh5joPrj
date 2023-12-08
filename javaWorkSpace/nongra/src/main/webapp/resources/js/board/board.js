const postListItems = document.querySelectorAll('.post_list');

        postListItems.forEach(function (item) {
            item.addEventListener('click', function () {
                const postDetail = this.querySelector('.post_detail');

                // 다른 게시글이 열려 있다면 닫기
                postListItems.forEach(function (otherItem) {
                    const otherDetail = otherItem.querySelector('.post_detail');
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

        // jQuery를 사용하여 AJAX 요청
function loadAdditionalData(nextPageNumber) {
    $.ajax({
        url: '/your-server-endpoint',  // 실제 서버 엔드포인트로 변경
        method: 'GET',
        data: { nextPageNumber: nextPageNumber },
        dataType: 'json',
        success: function (data) {
            // 서버에서 받은 데이터를 현재 목록에 추가
            appendDataToCurrentList(data);

            // 화면 갱신 등 추가 작업 수행
            updateUI();
        },
        error: function (error) {
            console.error('Error loading additional data:', error);
        }
    });
}

// 현재 목록에 데이터를 추가하는 함수
function appendDataToCurrentList(data) {
    // data를 현재 목록에 추가하는 로직 작성
    // 예: data.forEach(item => currentList.push(item));
}

// 화면 갱신 등 추가 작업을 수행하는 함수
function updateUI() {
    // 화면 갱신 등을 수행하는 로직 작성
    // 예: 목록을 화면에 그리는 함수 호출 등
}

// 더보기 버튼 클릭 시 호출되는 함수
function onMoreButtonClick() {
    // 다음 페이지 번호 계산 등 필요한 로직 수행
    var nextPageNumber = calculateNextPageNumber();

    // 추가 데이터 로딩
    loadAdditionalData(nextPageNumber);
}

// 더보기 버튼 클릭 이벤트 핸들러 등록
$('#yourMoreButton').on('click', onMoreButtonClick);
