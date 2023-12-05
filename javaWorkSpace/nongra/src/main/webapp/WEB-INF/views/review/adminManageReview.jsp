<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html lang="en">
    <head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>리뷰 관리(관리자)</title>
    <link rel="stylesheet" href="/nongra/resources/css/common/cssReset.css">
    <link rel="stylesheet" href="/nongra/resources/css/review/adminManageReview.css">
  

   </head>

<body>
 	<%@	include file="/WEB-INF/views/common/aside/aside_admin.jsp" %>
    <section class="review-section"> 
       <div class="my-review"> 
        <h2>리뷰 관리</h2>
      </div> 

      <!--체크박스로 ajax 처리-->
      
    <div class="seller-review-div-checkbox">
        <span>답변 미작성 목록 <input type="checkbox"></span>   
    </div>
    

    <!--리뷰 -->
    <div class="review" >
        <div class="review-user-nick">
            <figure class="user-photo" style="background-image: url(/images/nongra.png) ;"></figure> <span>닉네임</span>
        </div>

        <div class="review-content-box">
            <div class="review-item-name">상품명</div>
            <p class="review-content">
                안녕하세요 리뷰내용입니다 여기는 리뷰내용이 들어갈거에요
                안녕하세요 리뷰내용입니다 여기는 리뷰내용이 들어갈거에요
                안녕하세요 리뷰내용입니다 여기는 리뷰내용이 들어갈거에요
                안녕하세요 리뷰내용입니다 여기는 리뷰내용이 들어갈거에요
                안녕하세요 리뷰내용입니다 여기는 리뷰내용이 들어갈거에요
                안녕하세요 리뷰내용입니다 여기는 리뷰내용이 들어갈거에요
                안녕하세요 리뷰내용입니다 여기는 리뷰내용이 들어갈거에요
                안녕하세요 리뷰내용입니다 여기는 리뷰내용이 들어갈거에요
                안녕하세요 리뷰내용입니다 여기는 리뷰내용이 들어갈거에요
            </p>
            <div class="reivew-picture-box"><img src="/images/review/nongra.png" alt="리뷰사진" class="review0"></div>
            <footer class="review-date-box">
                <span class="review-date">2023.07.10</span>
                <button class="review-recommend-btn">
                    <span class="review-b"></span>
                    <span class="review-like">도움돼요 99</span>
                </button>
            </footer>
            <div class="owner-replay-box">
                <span class="reply-span1">답글보기</span><button class="reply-delete-btn">삭제</button> 
            </div> 
        </div>
    </div>

    <div class="owner-reply-box2 owner-reply-box3" > 

        <div class="owner-reply-box2-title">
            <span>[멋쟁이 토마토 마켓]</span>
        </div>

        <div class="owner-reply-box2-content">
            <p class="review-content">
                안녕하세요 리뷰내용입니다 여기는 리뷰내용이 들어갈거에요
                안녕하세요 리뷰내용입니다 여기는 리뷰내용이 들어갈거에요
                안녕하세요 리뷰내용입니다 여기는 리뷰내용이 들어갈거에요
                안녕하세요 리뷰내용입니다 여기는 리뷰내용이 들어갈거에요
                안녕하세요 리뷰내용입니다 여기는 리뷰내용이 들어갈거에요
                안녕하세요 리뷰내용입니다 여기는 리뷰내용이 들어갈거에요
                안녕하세요 리뷰내용입니다 여기는 리뷰내용이 들어갈거에요
                안녕하세요 리뷰내용입니다 여기는 리뷰내용이 들어갈거에요
                안녕하세요 리뷰내용입니다 여기는 리뷰내용이 들어갈거에요
            </p>

            <div class="owner-reply-box2-date-btn">
                <span>2023.07.01</span> 
               
            </div> 
        </div>       
    </div>


    

    
    
</div>
        
<div class="inquery-paging-area">
    <div class="inquery-pageing-btn-area" >
        <button ></button>
        <button></button>
    </div>
</div>

<div class="review-search-box">
    
<form action="">
    <select name="serachtype">
        <option value="user">작성자</option>
        <option value="content">내용</option>
    </select>
    <input type="text" name="?"> <input type="submit" value="검색">
</form>
</div>
    </section>

    <div class="modal-sure modal-sure-hiddnen">
        <div class="dialog-sure">
            <div class="dialog-sure-btn"><button id="modal-close">X</button></div>
            <span >-삭제 시 리뷰 복구는 불가능 합니다 </span>
            <span>정말 삭제 하시겠습니까?</span>
    
            <div class="modal-sure-btn-box">
                <button class="btn-sure">삭제</button><label class="btn-quit" for="modal-close">취소</label>
            </div>
        </div>
    </div>
    
    

</body>
</html>

<script>

     //판매자 답글보기

     const x =document.querySelectorAll(".reply-span1")
    const y =document.querySelectorAll(".owner-reply-box2");
    
    
    for(let i=0; i<x.length; ++i){
        x[i].addEventListener('click',()=>{
        y[i].classList.toggle("owner-reply-box3")    
    } )      
    }


     // 모달 구매확정 버튼

     //삭제 버튼
     const modalOpenButton = document.querySelectorAll(".reply-delete-btn")
    
     const modalCloseButton = document.querySelector("#modal-close")
    
     const modalSureButton = document.querySelector(".btn-sure")
    
     const modal = document.querySelector(".modal-sure")


    for(let i=0; i<modalOpenButton.length; i++){
        modalOpenButton[i].addEventListener('click', () => {
    modal.classList.remove('modal-sure-hiddnen');
    });

    }

    
    modalCloseButton.addEventListener('click', () => {
    modal.classList.add('modal-sure-hiddnen');
    });

    modalSureButton.addEventListener('click', () => {
    modal.classList.add('modal-sure-hiddnen');
        alert("리뷰 삭제가 완료되었습니다")

    });

</script>


