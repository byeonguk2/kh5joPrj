<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<style>
    .wrap{
        display: grid;
        grid-template-columns: 2fr 7fr;
        grid-template-rows: 120px 5fr;
        height: 100%;    
    }
    header{
        display: flex;
        grid-column: span 2;
        align-items: center;
    }
    header h1{
        margin-left: 40px;
    }

    form{
        display: grid;
        grid-column: span 2;
        grid-template-rows: 8fr 30px;
        justify-content: center;
        
    }
    main{
        display: grid;
        grid-template-columns: 2fr 7fr;
    }
    main *{
        display: block;
        margin: 20px;
        margin-top: 0px;
    }
    .main-left{
        margin-right:40px; 
    }
    .main-right{
        margin-left: 0px;
    }
    .main-right > input[name="title"]{
        width: 468px;
    }

    textarea{
        width: 470px;
        height: 550px;
        resize: none;
    }
    footer{
        display: flex;
        grid-column: span 3;
        justify-content: center;
        align-items: flex-start;
        gap: 0px 10px;
    }
    
</style>
<body>
	
	<div class="wrap">
        <header>
            <img width="150px" height="120px" src="\nongra\resources\img\common\logo.png" alt="농라로고">
            <h1>쪽지작성</h1>
        </header>
        <form action="/nongra/seller/note/write" method="post">
            <main>
                <div class=main-left>
                    <span>받는 사람</span>
                    <span>제목</span>
                    <span>내용</span>
                </div>
                <div class="main-right">
                    <input type="text" name="toNick" placeholder="아이디를 입력해주세요">
                    <input type="text" name="title" placeholder="제목을 입력해주세요">
                    <textarea name="content" placeholder="내용을 입력해주세요"></textarea>
                </div>
            </main>
            <footer>
                <input type="submit" value="보내기">
                <button type="button" onclick="window.close();">취소</button>
            </footer>
        </form>
    </div>
</body>
</html>