<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html lang="en">
    <head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>���� ����(������)</title>
    <link rel="stylesheet" href="/nongra/resources/css/common/cssReset.css">
    <link rel="stylesheet" href="/nongra/resources/css/review/adminManageReview.css">
  

   </head>

<body>
 	<%@	include file="/WEB-INF/views/common/aside/aside_admin.jsp" %>
    <section class="review-section"> 
       <div class="my-review"> 
        <h2>���� ����</h2>
      </div> 

      <!--üũ�ڽ��� ajax ó��-->
      
    <div class="seller-review-div-checkbox">
        <span>�亯 ���ۼ� ��� <input type="checkbox"></span>   
    </div>
    

    <!--���� -->
    <div class="review" >
        <div class="review-user-nick">
            <figure class="user-photo" style="background-image: url(/images/nongra.png) ;"></figure> <span>�г���</span>
        </div>

        <div class="review-content-box">
            <div class="review-item-name">��ǰ��</div>
            <p class="review-content">
                �ȳ��ϼ��� ���䳻���Դϴ� ����� ���䳻���� ���ſ���
                �ȳ��ϼ��� ���䳻���Դϴ� ����� ���䳻���� ���ſ���
                �ȳ��ϼ��� ���䳻���Դϴ� ����� ���䳻���� ���ſ���
                �ȳ��ϼ��� ���䳻���Դϴ� ����� ���䳻���� ���ſ���
                �ȳ��ϼ��� ���䳻���Դϴ� ����� ���䳻���� ���ſ���
                �ȳ��ϼ��� ���䳻���Դϴ� ����� ���䳻���� ���ſ���
                �ȳ��ϼ��� ���䳻���Դϴ� ����� ���䳻���� ���ſ���
                �ȳ��ϼ��� ���䳻���Դϴ� ����� ���䳻���� ���ſ���
                �ȳ��ϼ��� ���䳻���Դϴ� ����� ���䳻���� ���ſ���
            </p>
            <div class="reivew-picture-box"><img src="/images/review/nongra.png" alt="�������" class="review0"></div>
            <footer class="review-date-box">
                <span class="review-date">2023.07.10</span>
                <button class="review-recommend-btn">
                    <span class="review-b"></span>
                    <span class="review-like">����ſ� 99</span>
                </button>
            </footer>
            <div class="owner-replay-box">
                <span class="reply-span1">��ۺ���</span><button class="reply-delete-btn">����</button> 
            </div> 
        </div>
    </div>

    <div class="owner-reply-box2 owner-reply-box3" > 

        <div class="owner-reply-box2-title">
            <span>[������ �丶�� ����]</span>
        </div>

        <div class="owner-reply-box2-content">
            <p class="review-content">
                �ȳ��ϼ��� ���䳻���Դϴ� ����� ���䳻���� ���ſ���
                �ȳ��ϼ��� ���䳻���Դϴ� ����� ���䳻���� ���ſ���
                �ȳ��ϼ��� ���䳻���Դϴ� ����� ���䳻���� ���ſ���
                �ȳ��ϼ��� ���䳻���Դϴ� ����� ���䳻���� ���ſ���
                �ȳ��ϼ��� ���䳻���Դϴ� ����� ���䳻���� ���ſ���
                �ȳ��ϼ��� ���䳻���Դϴ� ����� ���䳻���� ���ſ���
                �ȳ��ϼ��� ���䳻���Դϴ� ����� ���䳻���� ���ſ���
                �ȳ��ϼ��� ���䳻���Դϴ� ����� ���䳻���� ���ſ���
                �ȳ��ϼ��� ���䳻���Դϴ� ����� ���䳻���� ���ſ���
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
        <option value="user">�ۼ���</option>
        <option value="content">����</option>
    </select>
    <input type="text" name="?"> <input type="submit" value="�˻�">
</form>
</div>
    </section>

    <div class="modal-sure modal-sure-hiddnen">
        <div class="dialog-sure">
            <div class="dialog-sure-btn"><button id="modal-close">X</button></div>
            <span >-���� �� ���� ������ �Ұ��� �մϴ� </span>
            <span>���� ���� �Ͻðڽ��ϱ�?</span>
    
            <div class="modal-sure-btn-box">
                <button class="btn-sure">����</button><label class="btn-quit" for="modal-close">���</label>
            </div>
        </div>
    </div>
    
    

</body>
</html>

<script>

     //�Ǹ��� ��ۺ���

     const x =document.querySelectorAll(".reply-span1")
    const y =document.querySelectorAll(".owner-reply-box2");
    
    
    for(let i=0; i<x.length; ++i){
        x[i].addEventListener('click',()=>{
        y[i].classList.toggle("owner-reply-box3")    
    } )      
    }


     // ��� ����Ȯ�� ��ư

     //���� ��ư
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
        alert("���� ������ �Ϸ�Ǿ����ϴ�")

    });

</script>


