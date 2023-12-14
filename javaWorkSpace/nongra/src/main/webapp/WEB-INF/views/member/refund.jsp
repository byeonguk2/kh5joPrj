<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>농라</title>
</head>
<body>
    <form action="/nongra/mypage/order/checkout" method="post">
        주문 번호 : <input type="text" name="orderNo">
        <br>
        환불 사유 : <input type="text" name="REFUND_REASON">
        <button id="button">환불</button>
    </form>
</body>
</html>

<script>
    const btn = document.querySelector('#button');
    btn.addEventListener('click',()=>{
        window.close();
        opener.location.href='/nongra/member/orderDetail';;
    })
</script>