<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>배송지 추가</title>
</head>
<body>
	<input type="text" id="sample6_postcode" placeholder="우편번호">
	<input type="button" onclick="sample6_execDaumPostcode()" value="우편번호 찾기"><br>
	<input type="text" id="sample6_address" placeholder="주소"><br>
	<input type="text" id="sample6_detailAddress" placeholder="상세주소">
	<input type="text" id="sample6_extraAddress" placeholder="참고항목">
</body>
</html>

<script src="//t1.daumcdn.net/mapjsapi/bundle/postcode/prod/postcode.v2.js"></script>
<script type="text/javascript"><%@include file="/resources/js/purchase/deliveryAddressResultPopup.js"%></script>