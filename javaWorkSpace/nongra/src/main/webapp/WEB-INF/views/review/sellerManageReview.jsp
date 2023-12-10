<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
	<link rel="stylesheet" href="/nongra/resources/css/common/cssReset.css">
	
	
		<style>
		body{
		
			
		}
		#wrap{
			width : 100%;
		}
		#main-area{
		display: grid;
		grid-template-columns: 230px 8fr;
		
		}
		#headerer{
			display: flex;
			align-items: center;
			align-content: center;
		}
		
		
	</style>
	
</head>
<body>
	<div id="wrap">
		<%@ include file="/WEB-INF/views/common/header/header_seller.jsp" %>
	</div>
	<div id = "main-area">
		<%@ include file="/WEB-INF/views/common/aside/aside_seller.jsp" %>
		
		<div id="headerer">
			
		</div>
		
	</div>
</body>
</html>


<script>
    
     // 모달 구매확정 버튼

     //삭제 버튼
     const modalOpenButton = document.querySelectorAll(".delete-btn")
    
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



     // 모달 후기수정 버튼
    const reviewModalOpenButton = document.querySelectorAll(".change-btn")
   
    
   const reviewModalCloseButton = document.querySelector("#review-cancel")
 
   const reivewModalSureButton1 = document.querySelector("#review-regiseter")
  
   const reviewModal = document.querySelector(".modal-review")

   console.log(reviewModal)


   for(let i=0; i<reviewModalOpenButton.length; i++){
       reviewModalOpenButton[i].addEventListener('click', () => {
           
           reviewModal.classList.remove('modal-review-hidden');
   });

   }

   
   reviewModalCloseButton.addEventListener('click', () => {
       reviewModal.classList.add('modal-review-hidden');
   });

   reivewModalSureButton1.addEventListener('click', () => {
       reviewModal.classList.add('modal-review-hidden');
       alert("리뷰가 수정 되었습니다")

   });

    const c1 =document.querySelectorAll(".product-inquery-normal")
    const c2 =document.querySelectorAll(".produt-inquery-answer-tr1 ");
    
    for(let i=0; i<c1.length; ++i){
        c1[i].addEventListener('click',()=>{
        c2[i].classList.toggle("produt-inquery-answer-tr")
           
    } )      
    }

    //판매자 답글보기

    const x =document.querySelectorAll(".reply-span-show")
    const y =document.querySelectorAll(".owner-reply-box2");
    
    
    for(let i=0; i<x.length; ++i){
        x[i].addEventListener('click',()=>{
        y[i].classList.toggle("owner-reply-box3")    
    } )      
    }

   
</script>



