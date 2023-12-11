<%@page import="com.kh.app.page.vo.PageVo"%>
<%@page import="java.util.Map"%>
<%@page import="com.kh.app.seller.vo.SellerVo"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
    List<SellerVo> voList = (List<SellerVo>)request.getAttribute("voList"); 
    PageVo pvo = (PageVo)request.getAttribute("pvo");
    Map<String,Object> map = (Map<String,Object>)request.getAttribute("map");
%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Insert title here</title>
    <style type="text/css">
#main-area {
    display: grid;
    grid-template-columns: 230px 8fr;
    padding-top: 145px;
}

main {
    display: grid;
    grid-template-columns: 1fr;
}

form {
    display: flex;
    flex-direction: column;
    justify-content: center;
    align-items: center;
    margin-bottom: 50px;
/*     margin-top: 50px; */
}

.select_div{
	display: flex;
}

.search_div {
    display: flex;
    gap: 20px;
}

/* 테이블 생성 */
.table-area {
    display: flex;
    justify-content: center;
}

table {
    border: 1px #a39485 solid;
    font-size: .9em;
    box-shadow: 0 2px 5px rgba(0,0,0,.25);
    width: 80%;
    border-collapse: collapse;
    border-radius: 5px;
    overflow: hidden;
}

th {
    text-align: center;
}

thead {
    font-weight: bold;
    color: #fff;
    background: #73685d;
}

td, th {
    padding: 1em .5em;
    vertical-align: middle;
}

td {
    border-bottom: 1px solid rgba(0,0,0,.1);
    background: #fff;
    text-align: center;
}

a {
    color: #73685d;
}

@media all and (max-width: 768px) {
    table, thead, tbody, th, td, tr {
        display: block;
    }

    th {
        text-align: right;
    }

    table {
        position: relative; 
        padding-bottom: 0;
        border: none;
        box-shadow: 0 0 10px rgba(0,0,0,.2);
    }

    thead {
        float: left;
        white-space: nowrap;
    }

    tbody {
        overflow-x: auto;
        overflow-y: hidden;
        position: relative;
        white-space: nowrap;
    }

    tr {
        display: inline-block;
        vertical-align: top;
    }

    th {
        border-bottom: 1px solid #a39485;
    }

    td {
        border-bottom: 1px solid #e5e5e5;
    }
}

.btn-paging {
    display: flex;
    justify-content: space-between;
}

.ben-btn {
    width: 90px;
}

.paging-btn-area {
    display: grid;
    grid-template-columns: 1fr 2fr 1fr;
}

.paging-btn {
    display: flex;
    height: 80px;
    align-items: center;
    justify-content: center;
    gap: 20px;
    font-size: 30px;
}

.paging-btn > button {
    width: 60px;
    height: 30px;
}

.ben-btn {
    width: 90px;
}

.paging-btn-area {
    display: grid;
    grid-template-columns: 1fr 2fr 1fr;
}

.paging-btn {
    display: flex;
    height: 80px;
    align-items: center;
    justify-content: center;
    gap: 20px;
    font-size: 17px;
}

.paging-btn > button {
    width: 60px;
    height: 30px;
}
    </style>
</head>
<body>
    <div id="wrap">
        <%@ include file="/WEB-INF/views/common/header/header_admin.jsp" %>
        <div id="main-area">
            <%@ include file="/WEB-INF/views/common/aside/aside_admin.jsp" %>
            <main>
                <form action="/nongra/admin/searchMember">
                    <h2>회원정지/해제</h2>
                    <div class="search_div">
                        <select name="option">
                            <option name="option" value="MEMBER_NO">번호</option>
                            <option name="option" value="NICK">닉네임</option>
                            <option name="option" value="ID">아이디</option>
                        </select>
                        <div class="select_div">
                            <input name="searchPageName" type="hidden" value="ben">
                            <div><input name="memberType" type="radio" value="Y" checked="true">판매자</div>
                            <div><input name="memberType" type="radio" value="N">소비자</div>
                        </div>
                       <div>
                        <input type="text" name="searchValue">
                        <button>검색</button>
                        </div>
                    </div>
                </form>
                <div class="table-area">
                    <table>
                        <thead>
                            <tr>
                                <th></th>
                                <th>번호</th>
                                <th>아이디</th>
                                <th>닉네임</th>
                                <th>회원종류</th>
                                <th>가입일시</th>
                                <th>정보수정</th>
                            </tr>
                        </thead>
                        <tbody>
                            <% for(SellerVo list : voList){ %>
                            <tr>
                                <th></th>
                                <td><%= list.getMemberNo() %></td>
                                <td><%= list.getId() %></td>
                                <td><%= list.getNick() %></td>
                                <td><%if(list.getSellerYn().equals("Y")){ %>판매자<% }else { %>소비자<%}%></td>
                                <td><%= list.getJoinDate() %></td>
                                <td><button type="button" onclick="freeze(<%= list.getMemberNo() %>,'<%=list.getFreezeYn()%>')"><%if(list.getFreezeYn().equals("N")){ %>정지하기<% }else { %>정지해제<%}%></button></td>
                            </tr>
                            <% } %>
                        </tbody>
                    </table>
                </div>
                <div class="paging-btn-area">
                    <div></div>
                    <div class="paging-btn">
                        <%if(pvo.getStartPage() != 1){ %>
                            <a href="/nongra/admin/memberBen?pno=<%= pvo.getStartPage()-1 %>">이전</a>
                        <% } %>
                        <% for(int i = pvo.getStartPage(); i <= pvo.getEndPage(); i++){ %>
                            <% if(i == pvo.getCurrentPage()){ %>
                                <span><%= i %></span>
                            <% }else{ %>
                                <a href="/nongra/admin/memberBen?pno=<%= i %>"><%= i %></a>
                            <% } %>
                        <% } %>
                        <%if(pvo.getEndPage() != pvo.getMaxPage()){ %>
                            <a href="/nongra/admin/memberBen?pno=<%= pvo.getEndPage()+1 %>">다음</a>
                        <% } %>
                    </div>
                    <div></div>
                </div>
            </main>
        </div>
    </div>
    <script>
        function createAsideLetter() {
            const x = document.querySelector(".aside-item > label");
            const menu1 = document.querySelector(" aside > :nth-child(2) > a ");
            const menu2 = document.querySelector(" aside > :nth-child(3) > a ");
            const menu3 = document.querySelector(" aside > :nth-child(4) > a ");
            const menu4 = document.querySelector(" aside > :nth-child(5) > a ");
            x.innerHTML = "회원관리";
            menu1.innerHTML = "회원 조회/수정";
            menu1.href = "/nongra/admin/select";
            menu2.innerHTML = "회원 정지/해제";
            menu2.href = "/nongra/admin/memberBen";
            menu3.innerHTML = "사업자 허가 여부";
            menu3.href = "/nongra/admin/request";
            menu4.innerHTML = "탈퇴 요청 허가 여부";
			menu4.href = "/nongra/admin/acceptQuit";
        }
        createAsideLetter()

        // 정지 시키는 기능
        function freeze(no, Freeze) {
            console.log(Freeze);
            fetch("/nongra/admin/freeze?no=" + no + "&yn=" + Freeze)
                .then((resp) => {
                    return resp.json();
                }).then((data) => {
                    alert(data.succees);
                }).catch((x) => {
                    alert("실패 ..");
                });
            window.location.reload();
        }
    </script>
</body>
</html>