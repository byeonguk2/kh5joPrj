<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style>
        main > form{
            display: grid;
            grid-template-columns: 6fr 4fr;
            grid-template-rows: 1fr 5fr 1fr;
            align-items: center;
            height: 800px;
            width: 800px;
        }
        main *{
            text-decoration: none;
        }
        .main-top-area{
            display: flex;
            justify-content: space-around;
            grid-column: span 2;
            column-gap: 280px;
            font-size: 20px;
        }
        .main-center-right-area{
            display: grid;
            grid-template-rows: 4fr 6fr;
            height: 100%;
        }
        .main-center-left-area{
            border-right: 1px solid gray;
            height: 100%;
            display: flex;
            justify-content: center;
        }
        .main-center-left-area > div {
            width: 70%;
        }
        .main-center-left-area > div div{
            margin-bottom: 10px;
        }
        main > div:nth-child(3){
            display: grid;
            grid-template-rows: 4fr 6fr;
        }
        .main-center-right-area > div:nth-child(2),
        .main-center-right-area > div:nth-child(1){
            padding: 15px;
        }

        .main-center-right-area > div:nth-child(1) >div:nth-child(1),
        .main-center-right-area > div:nth-child(2) >div:nth-child(1){
            color: gray;
            margin-bottom: 15px;
        }
        .main-center-right-area > div:nth-child(1) >input,
        .main-center-right-area > div:nth-child(2) >input{
            border: none;
            border-bottom: 1px solid gray;
            width: 180px;
        }

        .main-bottom-area{
            display: flex;
            justify-content: end;
        }
    </style>
</head>
<body>
	<main>
		<form action="">
	        <div class="main-top-area">
	            <div>상품옵션</div>
	            <button type="submit">등록</button>
	        </div>
	        <div class="main-center-left-area">
	            <div>
	                <div>옵션을 추가해주세요</div>
	            </div>
	        </div>
	        <div class="main-center-right-area">
	            <div>
	                <div>옵션이름</div>
	                <input type="text" name="optionName" placeholder="욥션을 입력해주세요">
	            </div>
	            <div>
	                <div>가격</div>
	                <input type="text" name="optionPrice" placeholder="가격을 입력해주세요">
	            </div>
	        </div>
	        <div class="main-bottom-area">
	            <button>삭제</button>
	        </div>
        </form>
    </main>
	
</body>
</html>