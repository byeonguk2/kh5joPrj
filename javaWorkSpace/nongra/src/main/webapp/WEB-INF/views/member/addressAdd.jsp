<%@page import="com.kh.app.purchase.vo.PurchaseAddressVo"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>농라</title>
<link rel="stylesheet" href="/nongra/resources/css/member/mypageAddressAdd.css">
</head>
<body>
	<div id="cover">
		<%@	include file="/WEB-INF/views/common/header/header_sobi.jsp" %>
		<div id="main">
			<%@	include file="/WEB-INF/views/common/aside/aside_sobi_main.jsp" %>
			<main>
				<form action="" method="post">

					<table>
						<tbody>
							<tr>
								<td>우편번호</td>
								<td><input type="text" id="sample2_postcode"> <input type="button" onclick="sample2_execDaumPostcode()" value="우편번호 찾기" id="findBtn"></td>
							</tr>
							<tr>
								<td>주소</td>
								<td><input type="text" id="sample2_address" name="address1"></td>
							</tr>
							<tr>
								<td>참고항목</td>
								<td><input type="text" id="sample2_extraAddress" name="address2"></td>
							</tr>
							<tr>
								<td>상세주소</td>
								<td><input type="text" id="sample2_detailAddress" name="address3"></td>
							</tr>
							<tr>
								<td>받는 사람</td>
								<td><input type="text" name="name"></td>
							</tr>
							<tr>
								<td>전화번호</td>
								<td><input type="text" name="phone"></td>
							</tr>
							<tr>
								<td></td>
								<td><input type="checkbox" name="defaultAddress" id="defaultAddress"> 기본배송지</td>
							</tr>
							<tr id="coverbuttonArea">
								<th colspan="2" id="buttonArea"><button>새 배송지 추가</button></th>
							</tr>
						</tbody>
					</table>
					<div id="layer" style="display:none;position:fixed;overflow:hidden;z-index:1;-webkit-overflow-scrolling:touch;">
					<img src="//t1.daumcdn.net/postcode/resource/images/close.png" id="btnCloseLayer" style="cursor:pointer;position:absolute;right:-3px;top:-3px;z-index:1" onclick="closeDaumPostcode()" alt="닫기 버튼">
					</div>
				</form>





			</main>
		</div>
		
	</div>
</body>
</html>
<script src="//t1.daumcdn.net/mapjsapi/bundle/postcode/prod/postcode.v2.js"></script>
<script type="text/javascript" src="/nongra/resources/js/member/mypageAddressAdd.js"></script>