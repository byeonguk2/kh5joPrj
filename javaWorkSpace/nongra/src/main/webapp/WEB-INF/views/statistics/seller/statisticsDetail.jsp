<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" href="/nongra/resources/css/seller/statisticsDatail.css">
</head>
<body>
    <div id="wrap">
        <%@	include file="/WEB-INF/views/common/header/header_seller.jsp" %>
        <main>
            <%@	include file="/WEB-INF/views/common/aside/aside_seller.jsp" %>
            <div class="cover-area">
                <div class="cover">

                    <div class="title"><div>통계(상세조회)</div></div>
                    <div class="button-area">
                        <span><button>전체</button></span>
                        <span><button>상품1</button></span>
                        <span><button>상품2</button></span>
                    </div>
                    <div class="table">
                        <table>
                            <thead>
                                <tr>
                                    <th>일자</th>
                                    <td>주문수</td>
                                    <td>환불요청수</td>
                                    <td>판매수익</td>
                                    <td>후기</td>
                                </tr>
                            </thead>
                            <tbody>
                                <tr>
                                    <th>2023-11-28</th>
                                    <td>12</td>
                                    <td>0</td>
                                    <td>87,873</td>
                                    <td>1</td>
                                </tr>
                                <tr>
                                    <th>2023-11-27</th>
                                    <td>10</td>
                                    <td>5</td>
                                    <td>15,150</td>
                                    <td>3</td>
                                </tr>
                            </tbody>
                        </table>
                    </div>
                </div>
            </div>
        </main>
    </div>
</body>
</html>