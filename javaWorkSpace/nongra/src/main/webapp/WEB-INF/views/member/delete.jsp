<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet"
	href="/nongra/resources/css/member/member_delete.css">
</head>
<body>
	<div id="wrap_event">
	<%@ include file="/WEB-INF/views/common/header/header_sobi.jsp"%>
	<form id="form" action="/nongra/member/delete" method="post">
	<div class="main">
                <h2 class="member_drop">
                    <span>회원탈퇴</span>
                </h2>
                
                <h3 class="drop01">회원탈퇴 주의사항</h3>
                <div id="box">
                    <dl class="text">
                        <dt>1. ㈜농라 제휴사이트 이용 불가</dt>
                        <dd> ㈜농라 멤버십을 통해 이용 가능한 <span>구매서비스</span> 및 ㈜농라 멤버십을 이용한 <span>판매 서비스에서 동시에 탈퇴처리</span> 됩니다.</dd>
                    </dl>
                    <dl class="text">
                        <dt>2. 개인정보 및 이용정보 삭제</dt>
                        <dd>회원 탈퇴와 동시에 <span>개인정보 및 모든 이용정보가 초기화 되어 삭제</span> 되므로 절대 복구 불가합니다.
                            <dl >
                                <dt>삭제대상 정보</dt>
                                <dd>- 가입 시 기재한 <span>모든 개인정보</span> 및 <span>서비스 이용 내역(판매글, 게시글 등)</span></dd>
                                <dd>- <span>보유중인 페이</span> 및 <span>모든 게시글과 판매글</span></dd>
                            </dl>
                        </dd>
                        <dd>탈퇴한 개인정보는 관련법령에 따라 즉시 파기되며, 전자상거래법에 의거하여 결제 내역이 있을 경우 결제 내역은 5년간 별도<br>보관 합니다.</dd>
                    </dl>
                    <dl class="text">
                        <dt>3. 탈퇴 후 동일 정보로 90일간 재가입 금지</dt>
                        <dd>탈퇴/가입 반복을 통한 부정 행위를 막기 위하여 탈퇴 후 90일간은 재가입 하실 수 없습니다.</dd>
                    </dl>
                    <dl class="text">
                        <dt>4. 탈퇴 후 동일 아이디는 6개월간 사용하실 수 없습니다.</dt>
                        <dd></dd>
                    </dl>
                    <div class="check1">
                        <input type="checkbox"  id="check">
                        <label for="check">회원탈퇴 시 주의사항을 모두 확인하였습니다.</label>
                    </div>
                </div>
                <h3 class="drop02">캐시 현황</h3>
                <div id="box2">
                    <dl class="cash">
                        <dt>보유중인 페이</dt>
                        <dd>0원</dd>
                    </dl>
                    <dl class="text2">
                        <dt >·페이 환불 안내</dt>
                        <dd>- 보유중인 페이는 <span>탈퇴 시 모두 소멸되어 환불이 불가합니다.</span></dd>
                        <dd>- 직접 충전하신 페이 중 회원탈퇴 시점에 직접 충전한 페이 잔액이 1,000원을 초과하는 경우 유료서비스 이용약관
                            <br>제19조  에 따라 환불이 가능하오니 아래 캐시 환불신청 방법에 따라 환불 신청 후 탈퇴해 주시기 바랍니다.
                        </dd>
                        
                        <dd class="way">
                            - <b>환불신청 방법</b>
                            <br>가입자 명의와 동일한 계좌번호, 은행명, 연락처를 기재하시어 고객센터 1:1 문의 하기로 환불신청 하시면 됩니다.
                            <br>(계좌주가 가입자 명의와 일치하지 않을 경우 환불이 불가합니다.)
                        </dd>
                    </dl>
                    <div class="check1">
                        <input type="checkbox"  id="check1">
                        <label for="check1">보유중인 페이 및 환불 안내사항을 확인하였습니다</label>
                    </div>
                </div>
                <div class="btn">
                    <a href="/nongra/home" class="button1">탈퇴</a>
                    <a href="" class="button2">탈퇴취소</a>

                </div>
            </div>
            </form>
            </div>
</body>
</html>