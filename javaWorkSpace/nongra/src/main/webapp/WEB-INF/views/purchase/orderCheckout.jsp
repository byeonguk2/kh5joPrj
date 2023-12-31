<%@page import="java.util.List"%>
<%@page import="com.kh.app.purchase.vo.PurchaseCartVo"%>
<%@page import="com.kh.app.purchase.vo.PurchaseAddressVo"%>
<%@page import="com.kh.app.purchase.vo.PurchaseOrderCheckoutVo"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%
    PurchaseOrderCheckoutVo PurchaseOrderCheckoutVo = (PurchaseOrderCheckoutVo) request.getAttribute("orderCheckOutVo");
    List<PurchaseCartVo> cartVoList = (List<PurchaseCartVo>)PurchaseOrderCheckoutVo.getCartVoList();
    PurchaseAddressVo address = (PurchaseAddressVo)PurchaseOrderCheckoutVo.getAddressVo();
    int totalPrice = (int)PurchaseOrderCheckoutVo.getTotalPrice();
    %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" href="/nongra/resources/css/purchase/orderCheckout.css">
</head>
<body>
	<div id="cover">
		<%@	include file="/WEB-INF/views/common/header/header_sobi.jsp" %>
        <main>
            <form action="/nongra/order/complete" method="post">
                    <div class="order-head">주문서</div>
                    <div class="order">
                        <span class="head-text">주문상품</span>
                        <button type="button" class="simpleDetailBtn"><img src="/nongra/resources/img/purchase/icon-angle.png" alt="아래방향각"></button>
                    </div>
                    <div class="simpleVerArea">
                        <div class="simpleVer"><h3><%=cartVoList.get(0).getGoodsName() %></h3></div>
                    </div>
                    
                    
                    <table class="detailVerArea simpleDetailChange">
                        <tbody>
                        <%for(PurchaseCartVo vo : cartVoList) {%>
                            <tr class="detailVer">
                                <td class="product-image-area"><img id="detail-img" src="/nongra<%=vo.getGoodsPicture() %>" alt="상품이미지"></td>
                                <td class="product-name-area"><%=vo.getGoodsName() %></td>
                                <td class="product-cnt-area"><%=vo.getGoodsEA() %></td>
                                <td class="product-price"><span class="product-one-price"><%=Integer.parseInt(vo.getGoodsPrice()) + Integer.parseInt(vo.getOptionPrice())%></span><span class="product-times-price">상품 전체 금액</span></td>
                            </tr>
                        <%} %>
                        </tbody>
                    </table>
        
        
        
        
                    
                    <div class="orderer-area">
                        <div class="head-text text">주문자 정보</div>
                        <table class="orderer-table">
                            <tr>
                                <td>보내는 분</td>
                                <td>${loginMember.name }</td>
                            </tr>
                            <tr>
                                <td>휴대폰</td>
                                <td>${loginMember.phone }</td>
                            </tr>
                            <tr>
                                <td>이메일</td>
                                <td>${loginMember.email }</td>
                            </tr>
                            <tr>
                                <td></td>
                                <td class="description">이메일을 통해 주문처리 과정을 보내드립니다.</td>
                            </tr>
                            <tr>
                                <td></td>
                                <td class="description">정보 변경은 개인정보 수정 메뉴에서 가능합니다.</td>
                            </tr>
                        </table>
                    </div>
                    <div class="delivery-area">
                        <div class="head-text text">배송정보</div>
                        <div class="delivery-add">
                            <table>
                                <tr>
                                    <td>배송지</td>
                                    <td><%if(address.getDefaultAddress().equals("Y")){ %>
                                        <span id="address">기본배송지</span>
                                        <%} %>
                                        <span id="addr"><%=address.getAddress() %></span>
                                        <span id="addressNo"><input id="addrNo" type="text" name="addressNo" value="<%=address.getNo() %>"></span>
                                    </td>
                                </tr>
                                <tr>
                                    <td></td>
                                    <td><span id="addrName"><%=address.getName() %></span>, <span id="addrPhone"><%=address.getPhone() %></span></td>
                                </tr>
                                <tr>
                                    <td></td>
                                    <td><button type="button" class="delivery-btn" onclick="deliveryPopup();">변경</button></td>
                                </tr>
                            </table>
                        </div>

                        <div>
                            <table class="delivery-req">
                                <tr>
                                    <td>배송 요청사항</td>
                                    <td><select name="REQUEST">
                                        <option value="배송 전 연락 바랍니다." selected >배송 전 연락 바랍니다.</option>
                                        <option value="부재 시 휴대폰으로 연락 바랍니다.">부재 시 휴대폰으로 연락 바랍니다.</option>
                                        <option value="부재 시 경비실에 맡겨주세요.">부재 시 경비실에 맡겨주세요.</option>
                                        <option value="집 앞에 놓아주세요.">집 앞에 놓아주세요.</option>
                                        <option value="택배함에 넣어주세요.">택배함에 넣어주세요.</option>
                                    </select></td>
                                </tr>
                            </table>
                        </div>
                    </div>

                    <div>
                        <div class="head-text text pay-title">결제 금액</div>
                        <div class="pay-amount">
                            <table class="pay-table">
                                <tr>
                                    <td>주문금액</td>
                                    <td><span class="pay-table-price">0</span>원</td><input type="checkbox" name="price" id="price" value="<%=totalPrice %>" checked>
                                </tr>
                                <tr>
                                    <td>농라페이</td>
                                    <td class="pay-table-nongra-pay">${loginMember.point} <button type="button" class="charge-btn" onclick="location.href='/nongra/member/point'">충전하기</button></td>
                                </tr>
                                <tr>
                                    <td>결제 후 잔액</td>
                                    <td class="notEnough"><span class="pay-table-balance">0</span>원</td>
                                </tr>
                            </table>
                        </div>
                    </div>

                    <div class="personal-data-area">
                        <div class="head-text text">개인정보 수집/제공</div>
                        <div class="personal-data-agr">
                            <span>개인정보 수집∙이용 및 처리 동의</span>
                            <span id="btn-modal">보기</span>

							    <div id="modal" class="modal-overlay">
							        <div class="modal-window">
							            <div class="title">
							                <h3>개인정보 수집·이용 및 처리 동의(필수)</h3>
							            </div>
							            <div class="close-area">X</div>
							            <div class="content">
							                <h4>개인정보 수집·이용 동의</h4>
							                <table class="modal-table">
							                	<thead>
							                		<tr>
							                			<th>수집 목적</th>
							                			<th>수집 항목</th>
							                			<th>보유 기간</th>
							                		</tr>
							                	</thead>
							                	<tbody>
							                      	<tr>
							                			<td>온라인 쇼핑 구매자에 대한 상품 결제 및 배송</td>
							                			<td>결제정보, 수취인명, 휴대폰 번호, 수취인 주소, 구매상품정보</td>
							                			<td>업무 목적 달성 후 파기 (단, 타 법령에 따라 법령에서 규정한 기간 동안 보존)</td>
							                		</tr>
							                	</tbody>
							                </table>
							                <p>서비스 제공을 위해서 필요한 최소한의 개인정보입니다. 동의를 해 주셔야 서비스를 이용하실 수 있으며, 동의하지 않으실 경우 서비스에 제한이 있을 수 있습니다.</p>
							                
							            </div>
							        </div>
							    </div>




                        </div>
                        <div class="personal-data-agr">
                            <span>전자지급 결제대행 서비스 이용약관 동의</span>
                            <span id="btn-modal2">보기</span>
                            
                            
                            
    							    <div id="modal2" class="modal-overlay">
							        <div class="modal-window">
							            <div class="title">
							                <h3>농라페이 전자지급 결제대행 서비스 이용약관</h3>
							            </div>
							            <div class="close-area2">X</div>
							            <div class="content">
							                <h4>개인정보 수집·이용 동의</h4>
							                
                                            <strong class="tit-main">제1조 (목적)</strong>
                                            본 약관은 주식회사 농라페이(이하 “회사”라 합니다)가 제공하는 전자지급 결제대행 서비스를 “이용자”가 이용함에 있어 “회사”와 “이용자” 간 권리, 의무 및 “이용자”의 이용 절차 등에 관한 사항을 규정하는 것을 그 목적으로 합니다.
                                            <br>
                                            <br>
                                            <strong class="tit-main">제2조 (용어의 정의)</strong>
                                            ① 본 약관에서 사용하는 용어의 정의는 다음과 같습니다.
                                            <br>
                                            1. “전자금융거래”라 함은 “회사”가 “전자적 장치”를 통하여 금융상품 및 서비스를 제공(이하 “전자금융업무”라 합니다)하고, “이용자”가 “회사”의 종사자와 직접 대면하거나 의사소통을 하지 아니하고 자동화된 방식으로 이를 이용하는 거래를 말합니다.
                                            <br>
                                            2. “전자금융거래서비스”라 함은 “회사”가 “전자금융업무”로서 제공하는 전자지급 결제대행 서비스를 말합니다.
                                            <br>
                                            3. “전자지급 결제대행 서비스”라 함은 전자적 방법으로 재화의 구입 또는 용역의 이용에 있어서 지급결제정보를 송신하거나 수신하는 것 또는 그 대가의 정산을 대행하거나 매개하는 서비스를 말합니다.
                                            <br>
                                            4. “전자지급수단”이라 함은 신용카드 등 전자금융거래법 제2조 제11호에서 정하는 전자적 방법에 따른 지급수단을 말합니다.
                                            <br>
                                            5. “전자지급거래”라 함은 자금을 주는 자(이하 “지급인”이라 합니다)가 “회사”로 하여금 “전자지급수단”을 이용하여 자금을 받는 자(이하 “수취인”이라 합니다)에게 자금을 이동하게 하는 “전자금융거래”를 말합니다.
                                            <br>
                                            6. “전자적 장치”라 함은 “전자금융거래”정보를 전자적 방법으로 전송하거나 처리하는데 이용되는 장치로서 현금자동지급기, 자동입출금기, 지급용 단말기, 컴퓨터, 전화기 그 밖에 전자적 방법으로 정보를 전송하거나 처리하는 장치를 말합니다.
                                            <br>
                                            7. “접근매체”라 함은 “전자금융거래”에 있어서 “거래지시”를 하거나 “이용자” 및 거래내용의 진실성과 정확성을 확보하기 위하여 사용되는 다음 각 목의 어느 하나에 해당하는 수단 또는 정보를 말합니다.
                                            <br>
                                            가) 전자식 카드 및 이에 준하는 전자적 정보
                                            <br>
                                            나) 전자서명법 제2조 제4호의 전자서명생성정보 및 같은 조 제7호의 인증서
                                            <br>
                                            다) “회사”에 등록된 “이용자”번호
                                            <br>
                                            라) “이용자”의 생체정보
                                            <br>
                                            마) 가목 또는 나목의 수단이나 정보를 사용하는데 필요한 비밀번호
                                            <br>
                                            8. “이용자”라 함은 본 약관에 동의하고 본 약관에 따라 “회사”가 제공하는 “전자금융거래서비스”를 이용하는 자를 말합니다.
                                            <br>
                                            9. “거래지시”라 함은 “이용자”가 본 약관에 따라 “회사”에게 “전자금융거래”의 처리를 지시하는 것을 말합니다.
                                            <br>
                                            10. “오류”라 함은 “이용자”의 고의 또는 과실 없이 “전자금융거래”가 본 약관 또는 “이용자”의 “거래지시”에 따라 이행되지 아니한 경우를 말합니다.
                                            <br>
                                            ② 본 조 및 본 약관의 다른 조항에서 정의한 것을 제외하고는 전자금융거래법 등 관련 법령에서 정한 바에 따릅니다.
                                            
                                            <br>
                                            <br>
                                            <strong class="tit-main">제3조 (약관의 명시 및 변경)</strong>
                                            ① “회사”는 “이용자”가 “전자금융거래서비스”를 이용하기 전에 본 약관을 서비스페이지에 게시하고 “이용자”가 본 약관의 중요한 내용을 확인할 수 있도록 합니다.
                                            <br>
                                            ② “회사”는 “이용자”의 요청이 있는 경우 전자문서의 전송방식(이하 전자우편을 이용한 전송을 포함합니다) 등에 의하여 본 약관의 사본을 “이용자”에게 교부합니다.
                                            <br>
                                            ③ “회사”는 “이용자”가 약관의 내용에 대한 설명을 요청하는 경우 다음 각 호의 어느 하나의 방법으로 “이용자”에게 약관의 중요내용을 설명합니다.
                                            <br>
                                            1. 약관의 중요내용을 “이용자”에게 직접 설명
                                            <br>
                                            2. 약관의 중요내용에 대한 설명을 전자적 장치를 통하여 “이용자”가 알기 쉽게 표시하고 “이용자”로부터 해당 내용을 충분히 인지하였다는 의사표시를 전자적 장치를 통하여 수령
                                            <br>
                                            ④ “회사”가 본 약관을 변경하는 때에는 그 시행일 1개월 전에 변경되는 약관을 “회사” 홈페이지에 게시함으로써 “이용자”에게 공지합니다. 다만 법령의 개정으로 인하여 긴급하게 약관을 변경하는 때에는 변경된 약관을 “회사” 홈페이지에 1개월 이상 게시하고 “이용자”에게 통지합니다.
                                            <br>
                                            ⑤ “회사”는 제4항의 공지나 통지를 할 경우, “이용자”가 약관의 변경에 동의하지 아니한 경우 공지나 통지를 받은 날로부터 30일 이내에 계약을 해지할 수 있으며, 변경내용에 대하여 이의를 제기하지 아니하는 경우에는 변경에 동의한 것으로 본다”라는 취지의 내용을 함께 공지합니다.
                                            <br>
                                            ⑥ “이용자”가 제4항의 공지나 통지된 날로부터 변경되는 약관의 시행일 전의 영업일까지 변경내용에 대하여 이의를 제기하지 아니하는 경우에는 약관의 변경에 동의한 것으로 봅니다.
                                            <br>
                                            <br>
                                            <strong class="tit-main">제4조 (서비스 이용 시간)</strong>
                                            ① “회사”는 “이용자”에게 연중무휴 1일 24시간 “전자금융거래서비스”를 제공함을 원칙으로 합니다. 단, 금융기관 및 기타 결제수단 발행업자 등의 사정에 따라 달리 정할 수 있습니다.
                                            <br>
                                            ② “회사”는 정보통신설비의 보수, 점검 및 기타 기술상의 필요나 금융기관 및 기타 결제수단 발행업자의 사정에 의하여 서비스 중단이 불가피한 경우, “전자금융거래서비스” 중단 3일 전까지 게시 가능한 전자적 수단을 통하여 “전자금융거래서비스” 중단 사실을 게시한 후 “전자금융거래서비스”를 일시 중단할 수 있습니다. 다만, 시스템 장애복구, 긴급한 프로그램 보수, 외부요인 등 불가피한 경우에는 사전 게시 없이 “전자금융거래서비스”를 중단할 수 있습니다.
                                            <br>
                                            <br>
                                            <strong class="tit-main">제5조 (거래내용의 확인)</strong>
                                            ① “회사”는 “이용자”가 “전자금융거래”에 사용하는 “전자적 장치”(“회사”와 “이용자” 사이에 미리 약정한 “전자적 장치”가 있는 경우에는 그 “전자적 장치”를 포함합니다)를 통하여 “이용자”의 거래내용 (“이용자”의 “오류”정정 요구사실 및 처리결과에 관한 사항'을 포함합니다.)을 확인할 수 있도록 하며, “이용자”가 거래내용을 서면(전자문서를 제외합니다. 이하 같습니다)으로 제공할 것을 요청하는 경우에는 그 요청을 받은 날부터 2주 이내에 거래내용에 관한 서면을 교부합니다.
                                            <br>
                                            ② “회사”는 “이용자”가 “전자적 장치”의 운영장애, 그 밖의 사유로 거래내용을 확인하게 할 수 없는 때에는 인터넷 등을 이용하여 즉시 그 사유를 알리고, 그 사유가 종료된 때부터 “이용자”가 거래내용을 확인할 수 있도록 합니다.
                                            <br>
                                            ③ “회사”는 제1항에 따라 “이용자”로부터 거래내용을 서면으로 제공할 것을 요청받은 경우 “전자적 장치”의 운영장애, 그 밖의 사유로 거래내용을 제공할 수 없는 때에는 그 “이용자”에게 즉시 알리며, 이 경우 거래내용에 관한 서면의 교부기간을 산정함에 있어서 “전자적 장치”의 운영장애, 그 밖의 사유로 거래내용을 제공할 수 없는 기간은 산입하지 아니 합니다.
                                            <br>
                                            ④ 제1항의 대상이 되는 거래내용 중 대상기간이 5년인 것은 다음 각 호와 같습니다.
                                            <br>
                                            1. “전자금융거래”의 종류 및 금액, “전자금융거래”의 상대방에 관한 정보
                                            <br>
                                            2. “전자금융거래”의 거래일시, “전자적 장치”의 종류 및 “전자적 장치”를 식별할 수 있는 정보
                                            <br>
                                            3. “전자금융거래”가 계좌를 통하여 이루어지는 경우 거래계좌의 명칭 또는 번호
                                            <br>
                                            4. “전자금융거래” 신청, 조건변경에 관한 내용
                                            <br>
                                            ⑤ 제1항의 대상이 되는 거래내용 중 대상기간이 1년인 것은 다음 각 호와 같습니다.
                                            <br>
                                            1. “이용자”의 “오류” 정정 요구사실 및 처리결과에 관한 사항
                                            <br>
                                            ⑥ “이용자”가 제1항에서 정한 서면교부를 요청하고자 할 경우 다음의 이메일로 요청할 수 있습니다.
                                            <br>
                                            이메일 : nongrapay@nongrapay.co.kr
                                            <br>
                                            <br>
                                            <strong class="tit-main">제6조 ("거래지시"의 철회)</strong>
                                            ① “이용자”가 “회사”의 “전자금융거래서비스”를 이용하여 “전자지급거래”를 한 경우, “이용자”는 그 지급의 효력이 발생하기 전까지 제5조 제6항에 기재된 연락처로 전자문서의 전송 등을 통하여 “거래지시”를 철회할 수 있습니다.
                                            <br>
                                            ② 전항의 지급의 효력이 발생하는 시점이란, “거래지시”된 금액의 정보가 “수취인”의 계좌가 개설되어 있는 금융회사 또는 “회사”의 전자적 장치에 입력이 끝난 때를 의미합니다.
                                            <br>
                                            ③ “이용자”는 제1항의 지급의 효력이 발생한 경우에는 전자상거래 등에서의 소비자보호에 관한 법률 등 관련 법령상 청약의 철회의 방법에 따라 결제대금을 반환 받을 수 있습니다.
                                            <br>
                                            <br>
                                            <strong class="tit-main">제7조 ("오류"의 정정 등)</strong>
                                            ① “이용자”는 “전자금융거래서비스”를 이용함에 있어 “오류”가 있음을 안 때에는 “회사”에 대하여 그 정정을 요구할 수 있습니다.
                                            <br>
                                            ② “회사”는 전항의 규정에 따른 “오류”의 정정요구를 받은 때 또는 스스로 “전자금융거래”에 “오류”가 있음을 안 때에는 이를 즉시 조사하여 처리한 후 정정요구를 받은 날 또는 “오류”가 있음을 안 날부터 2주 이내에 그 원인과 결과를 문서, 전화 또는 전자우편으로 “이용자”에게 알려 드립니다. 다만, “이용자”가 문서로 알려줄 것을 요청하는 경우에는 문서로 알려 드립니다.
											<br>
                                            <br>
                                            <strong class="tit-main">제8조 ("전자금융거래"기록의 생성∙보존 및 파기)</strong>
                                            ① “회사”는 “전자금융거래”의 내용을 추적, 검색하거나 그 내용에 오류가 발생할 경우에 이를 확인하거나 정정할 수 있는 기록(이하 본 조에서 “전자금융거래”기록 이라 합니다)을 생성하여 보존합니다.
                                            <br>
                                            ② 전항의 규정에 따라 “회사”가 보존하여야 하는 기록의 종류 및 보존기간은 다음 각 호와 같습니다.
                                            <br>
                                            1. 다음 각 목의 “전자금융거래” 기록은 5년간 보존합니다.
                                            <br>
                                            가) 본 약관 제5조 제4항 제1호 내지 제4호에 관한 사항
                                            <br>
                                            나) 해당 “전자금융거래”와 관련한 “전자적 장치”의 접속기록
                                            <br>
                                            다) 건당 거래금액이 1만원을 초과하는 “전자금융거래”에 관한 기록
                                            <br>
                                            2. 다음 각 목의 “전자금융거래” 기록은 1년간 보존합니다.
                                            <br>
                                            가) 제5조 제5항 제1호에 관한 사항
                                            <br>
                                            나) 건당 거래금액이 1만원 이하인 “전자금융거래”에 관한 기록
                                            <br>
                                            다) “전자지급수단”의 이용과 관련된 거래승인에 관한 기록
                                            <br>
                                            ③ “회사”는 본 조 제2항에 따라 보존하여야 하는 기간이 경과하고 금융거래 등 상거래관계가 종료된 경우에는 5년 이내에 “전자금융거래”기록(신용정보의 이용 및 보호에 관한 법률에 따른 신용정보는 제외)을 파기합니다. 다만, 다른 법령 등에 따라 보관하여야 하는 경우에는 그러하지 아니합니다.
                                            <br>
                                            <br>
                                            <strong class="tit-main">제9조 ("전자금융거래"정보의 제공금지)</strong>
                                            ① “회사”는 “전자금융거래서비스”를 제공함에 있어서 취득한 “이용자”의 인적사항, “이용자”의 계좌, “접근매체” 및 “전자금융거래”의 내용과 실적에 관한 정보 또는 자료를, 법령에 의하거나 “이용자”의 동의를 얻은 경우를 제외하고는 제3자에게 제공, 누설하거나 업무상 목적 외에 사용하지 아니합니다.
                                            <br>
                                            ② “회사”는 “이용자”가 안전하게 “전자금융거래서비스”를 이용할 수 있도록 “이용자”의 개인정보보호를 위하여 개인정보처리방침을 제정하여 운용합니다. “회사”의 개인정보처리방침은 “회사”의 홈페이지에서 확인할 수 있습니다.
                                            <br>
                                            <br>
                                            <strong class="tit-main">제10조 ("접근매체"의 관리)</strong>
                                            ① “회사”는 “전자금융거래서비스” 제공 시 “접근매체”를 선정하여 “이용자”의 신원, 권한 및 “거래지시”의 내용 등을 확인합니다.
                                            <br>
                                            ② “이용자”는 “접근매체”를 사용함에 있어서 다른 법률에 특별한 규정이 없는 한 다음 각 호의 행위를 하여서는 아니 됩니다. 다만, 전자금융거래법 제18조에 따른 선불전자지급수단이나 전자화폐의 양도 또는 담보제공을 위하여 필요한 경우(제3호의 행위 및 이를 알선하는 행위는 제외한다)에는 그러하지 아니합니다.
                                            <br>
                                            1. “접근매체”를 양도하거나 양수하는 행위
                                            <br>
                                            2. 대가를 수수, 요구 또는 약속하면서 “접근매체”를 대여받거나 대여하는 행위 또는 보관, 전달, 유통하는 행위
                                            <br>
                                            3. 범죄에 이용할 목적으로 또는 범죄에 이용될 것을 알면서 “접근매체”를 대여받거나 대여하는 행위 또는 보관, 전달, 유통하는 행위
                                            <br>
                                            4. “접근매체”를 질권의 목적으로 하는 행위
                                            <br>
                                            5. 제1호부터 제4호까지의 행위를 알선하거나 광고하는 행위
                                            <br>
                                            ③ “이용자”는 자신의 “접근매체”를 제3자에게 누설 또는 노출하거나 방치하여서는 안되며, “접근매체”의 도용이나 위조 또는 변조를 방지하기 위하여 충분한 주의를 기울여야 합니다.
                                            <br>
                                            ④ “회사”는 “이용자”로부터 “접근매체”의 분실이나 도난 등의 통지를 받은 때에는 그 때부터 제3자가 그 접근매체를 사용함으로 인하여 “이용자”에게 발생한 손해를 배상할 책임이 있습니다. 다만, 선불전자지급수단이나 전자화폐의 분실∙도난의 통지 전 저장된 금액에 대한 손해에 대하여는 책임을 지지 아니합니다.
                                            <br>
                                            <br>
                                            <strong class="tit-main">제11조 (회사의 책임)</strong>
                                            ① “회사”는 다음 각 호의 어느 하나에 해당하는 사고로 인하여 “이용자”에게 손해가 발생한 경우에는 그 손해를 배상할 책임을 집니다.
                                            <br>
                                            1. “접근매체”의 위조나 변조로 발생한 사고
                                            <br>
                                            2. 계약체결 또는 “거래지시”의 전자적 전송이나 처리 과정에서 발생한 사고
                                            <br>
                                            3. “전자금융거래”를 위한 “전자적 장치” 또는 정보통신망 이용촉진 및 정보보호 등에 관한 법률 제2조 제1항 제1호에 따른 정보통신망에 침입하여 거짓이나 그 밖의 부정한 방법으로 획득한 “접근매체”의 이용으로 발생한 사고
                                            <br>
                                            ② 제1항의 규정에도 불구하고 “회사”는 다음 각 호의 어느 하나에 해당하는 경우에는 그 책임의 전부 또는 일부를 “이용자”가 부담하게 할 수 있습니다.
                                            <br>
                                            1. “이용자”가 “접근매체”를 제3자에게 대여하거나 그 사용을 위임한 경우 또는 양도나 담보의 목적으로 제공한 경우
                                            <br>
                                            2. 제3자가 권한 없이 “이용자”의 “접근매체”를 이용하여 “전자금융거래”를 할 수 있음을 알았거나 쉽게 알 수 있었음에도 불구하고 “접근매체”를 누설하거나 노출 또는 방치한 경우
                                            <br>
                                            3. “회사”가 제10조 제1항에 따른 확인 외에 보안강화를 위하여 “전자금융거래” 시 요구하는 추가적인 보안조치를 “이용자”가 정당한 사유 없이 거부하여 제1항 제3호에 따른 사고가 발생한 경우
                                            <br>
                                            4. “이용자”가 제3호에 따른 추가적인 보안조치에 사용되는 매체, 수단 또는 정보에 대하여 다음 각 목의 어느 하나에 해당하는 행위를 하여 제1항 제3호에 따른 사고가 발생한 경우
                                            <br>
                                            가) 누설, 노출 또는 방치한 행위
                                            <br>
                                            나) 제3자에게 대여하거나 그 사용을 위임한 행위 또는 양도나 담보의 목적으로 제공한 행위
                                            <br>
                                            5. 법인(중소기업기본법 제2조 제2항에 의한 소기업을 제외합니다)인 “이용자”에게 손해가 발생한 경우로 “회사”가 사고를 방지하기 위하여 보안절차를 수립하고 이를 철저히 준수하는 등 합리적으로 요구되는 충분한 주의의무를 다한 경우
                                            <br>
                                            <br>
                                            <strong class="tit-main">제12조("전자지급거래"계약의 효력)</strong>
                                            ① “회사”는 “이용자”와 체결한 “전자지급거래” 계약에 따라 “이용자”가 “거래지시”한 금액을 전송하여 지급이 이루어지도록 합니다.
                                            <br>
                                            ② “회사”는 제1항의 규정에 따른 자금의 지급이 이루어질 수 없게 된 때에는 수령한 자금을 “이용자”에게 반환하여야 합니다. 이 경우 “이용자”의 과실로 인하여 지급이 이루어지지 아니한 때에는 그 전송을 하기 위하여 지출한 비용을 공제할 수 있습니다.
                                            <br>
                                            <br>
                                            <strong class="tit-main">제13조 (이용금액의 한도)</strong>
                                            “회사”의 정책 및 결제업체(신용카드사, 이동통신사 등)의 기준에 따라 “이용자”의 결제수단 별 월 누적 결제액 및 결제한도가 제한될 수 있습니다.
                                            <br>
                                            <br>
                                            <strong class="tit-main">제14조 (분쟁처리 및 분쟁조정)</strong>
                                            ① “이용자”는 “회사”의 홈페이지에 게시된 분쟁처리 책임자 및 담당자에 대하여 “전자금융거래”에 관련한 의견 및 불만의 제기, 손해배상의 청구 등의 분쟁처리를 요구할 수 있습니다.
                                            <br>
                                            ② “이용자”는 “회사”에 대하여 서면(전자문서를 포함한다) 또는 전자적 장치를 이용하여 “회사”에 분쟁의 처리를 신청할 수 있으며, 이 경우 “회사”는 15일 이내에 이에 대한 조사 또는 처리 결과를 “이용자”에게 안내합니다.
                                            <br>
                                            ③ “이용자”가 “전자금융거래”의 처리에 관하여 이의가 있을 때에는 금융위원회의 설치 등에 관한 법률에 따른 금융감독원의 금융분쟁조정위원회 또는 소비자기본법에 따른 한국소비자원의 소비자분쟁조정위원회에 분쟁조정을 신청할 수 있습니다.
                                            <br>
                                            <br>
                                            <strong class="tit-main">제15조 (회사의 안정성 확보 의무)</strong>
                                            “회사”는 “전자금융거래”가 안전하게 처리될 수 있도록 선량한 관리자로서의 주의를 다하며, “전자금융거래”의 안전성과 신뢰성을 확보할 수 있도록 전자적 전송이나 처리를 위한 인력, 시설, “전자적 장치”, 소요경비 등의 정보기술부문, 전자금융업무 및 전자서명법에 의한 인증서의 사용 등 인증방법에 관하여 금융위원회가 정하는 기준을 준수합니다.
											<br>
                                            <br>
                                            <strong class="tit-main">제16조 (약관 외 준칙)</strong>
                                            ① “회사”와 “이용자” 사이에 개별적으로 합의한 사항이 본 약관에 정한 사항과 다를 때에는 그 합의 사항을 본 약관에 우선하여 적용합니다.
                                            <br>
                                            ② 제1항에서 정한 사항 이외에 본 약관에서 정하지 아니한 사항(용어의 정의를 포함합니다)에 대하여 “회사”와 “이용자” 사이에 다른 합의사항이 없는 때에는 전자금융거래법, 전자상거래 등에서의 소비자 보호에 관한 법률, 여신전문금융업법 등 관련 법령에서 정한 바에 따릅니다.
                                            <br>
                                            <br>
                                            <strong class="tit-main">제17조 (관할)</strong>
                                            “회사”와 “이용자” 간에 발생한 분쟁에 관한 관할은 민사소송법에서 정한 바에 따릅니다.
                                            <br>
                                            <br>	
                                            <strong class="tit-main">부칙</strong>
                                            <strong class="tit-main">제1조 (시행일)</strong>
                                            " 본 약관은 2023년 10월 29일부터 적용합니다."
                                            <br>
                                            <br>
                                            "주식회사 농라페이"
							            </div>
							        </div>
							    </div>                        
                            

                  
                            
                        </div>
                        <div class="personal-data-total-agr">위 내용을 확인 하였으며 결제에 동의합니다.</div>
                    </div>

                    <div class="inquiry">
                        <div>※ 배송완료 상태일 경우에만 환불이 가능합니다.</div>
                        <div>※ 농라는 통신판매중개자로서 주문, 품질, 교환/환불 등 의무와 책읨을 부담하지 않습니다.</div>
                    </div>
					<div id="hoho"></div>
                    <div class="pay-btn-area">
                        <button class="pay-btn" type="submit"><span id=pay-btn-price>0</span>원 결제하기</button>
                    </div>

            </form>
            <div id="footer"></div>
        </main>
	</div>
</body>
</html>
<script type="text/javascript"><%@include file="/resources/js/purchase/orderCheckout.js"%></script>
<script>
//결제 후 잔액
function balancePay() {
    const price  = document.querySelector('.pay-table-price');
    const pay = document.querySelector('.pay-table-nongra-pay');
    const balancePay = document.querySelector('.pay-table-balance');
    const notEnough = document.querySelector('.notEnough');

    balancePay.innerText = parseInt(pay.innerText) - parseInt(price.innerText);
    if(balancePay.innerText < 0){
        notEnough.innerText = "잔액이 부족해 결제가 불가능합니다.";
    }
}
balancePay();

function clickBuyBtn() {
    const notEnough = document.querySelector('.notEnough');
    const payBtn = document.querySelector('.pay-btn');
    if(notEnough.innerText === "잔액이 부족해 결제가 불가능합니다."){
        payBtn.classList.add('simpleDetailChange');
    }else{
        payBtn.classList.remove('simpleDetailChange');        
    }
}
clickBuyBtn();

function price() {
    const price  = document.querySelector('.pay-table-price');
    const inputTag = document.querySelector("#price");
    inputTag.vlaue = price.innerText;
}
price();
</script>
