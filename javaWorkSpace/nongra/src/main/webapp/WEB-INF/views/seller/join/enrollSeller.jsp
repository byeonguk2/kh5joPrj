<%@page import="com.kh.app.seller.vo.SellerVo"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<!DOCTYPE html>
<html lang="ko">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>판매자 정보등록</title>
    <link rel="stylesheet" href="/nongra/resources/css/join/enrollSeller.css">
    <script defer type="text/javascript" src="/nongra/resources/js/join/enrollSeller.js"></script>
</head>
<body>
     <form action="/nongra/seller/enroll" method="post" name="joinForm" onsubmit="return enrollCheck()">
        <h1 class="header-Letter">사업자 필수 서류 등록</h1>
        <div>
            <p>사업자 필수서류</p>
            <ul>
                <li>사업자등록첨부</li>
                <li>통자사본첨부(법인명의,대표자명의)</li>
                <li>통신판매업신고증 첨부</li>
            </ul>
        </div>
        <div>
            <p>기본정보</p>
            <div>
                <p class="input-info-letter">사업자등록증 등록</p>
                <p class="input-info-letter2">x 사업자등록</p>
                <div class="filebox">
				    <label for="file">등록하기</label> 
				    <input type="file" id="file">
				</div>
            </div>
        </div>
       <div class="enroll-info-area">
            <p>사업자정보 확인</p>
            <div id="business-join-area">
                <div class="business-join">
                    <p class="p-letter">사업자등록번호</p>
                    <input type="number" placeholder="사업자번호를 입력해주세요." name="business_no">
                </div>
                <div class="css-1og0zk92">
                    	<p class="css-3y93rl"></p>
                    	<div class="rowletter-area">
                        	<span id="business_no"></span>
                    </div>
                 </div>
                <div class="business-join">
                    <p class="p-letter">사업형태</p>
                    <div class="radio-area">
                        <label>
                            <input type="radio" name="business_form" id="bu-check" value="법인사업자" onclick="checkNoaml2(event);"  class="join-radio" checked="true">
                            법인사업자
                        </label>
                        <label>
                            <input type="radio" name="business_form" value="일반사업자" class="join-radio" onclick="checkNoaml(event)">
                            일반사업자
                        </label>
                    </div>
                </div>
                 <div class="business-join">
                    <p class="p-letter">사업장명</p>
                    <input type="text" placeholder="사업장명을 입력해주세요." name="business_name">
                </div>
                <div class="css-1og0zk92">
                    	<p class="css-3y93rl"></p>
                    	<div class="rowletter-area">
                        	<span></span>
                    </div>
                 </div>
                 <div class="business-join">
                    <p class="p-letter">사업장 전화번호</p>
                    <input type="text" placeholder="사업장 전화번호를 입력해주세요." name="business_phone">
                </div>
                <div class="css-1og0zk92">
                    	<p class="css-3y93rl"></p>
                    	<div class="rowletter-area">
                        	<span></span>
                    </div>
                 </div>
                <div class="business-join">
                    <p class="p-letter">상호(법인명)</p>
                    <input type="text" name="corporation_name" placeholder="법인사업자 체크시 작성">
                </div>
                <div class="css-1og0zk92">
                    	<p class="css-3y93rl"></p>
                    	<div class="rowletter-area">
                        	<span id="passMsg_re">법인사업자 번호 입력</span>
                    </div>
                 </div>
                <div class="business-join">
                    <p class="p-letter">업태/업종</p>
                    <div>
                        <input type="text" id="uptae" name="uptae" style="font-size: 14px" placeholder="업태" class="ip2 ip2-1">
                        <input type="text" id="upjong" name="upjong" style="font-size: 14px" placeholder="업종" class="ip2 ip2-1" id="ip1">
                    </div>
                </div>
                <div class="css-1og0zk92">
                    	<p class="css-3y93rl"></p>
                    	<div class="rowletter-area">
                        	<span id="passMsg_re"></span>
                    </div>
                 </div>
                <div class="business-join a">
                    <p class="p-letter">사업장주소</p>
                    <input type="text" name="businees_zipCode" id="sample6_postcode" placeholder="우편번호">
                    <button type="button" onclick="sample6_execDaumPostcode()">우편번호찾기</button>
                </div>
                <div class="css-1og0zk92">
                    	<p class="css-3y93rl"></p>
                    	<div class="rowletter-area">
                        	<span id="passMsg_re"></span>
                    </div>
                 </div>
                <div class="business-join a">
                    <p class="p-letter"></p>
                    <input type="text" name="businees_adr" id="sample6_address" placeholder="주소">
                </div>
                <div class="css-1og0zk92">
                    	<p class="css-3y93rl"></p>
                    	<div class="rowletter-area">
                        	<span id="passMsg_re"></span>
                    </div>
                 </div>
                <div class="business-join">
                    <p class="p-letter"></p>
                    <input type="text" name="detailed_adr" id="sample6_detailAddress" placeholder="상세주소">
                </div>
                <div class="css-1og0zk92">
                    	<p class="css-3y93rl"></p>
                    	<div class="rowletter-area">
                        	<span id="passMsg_re"></span>
                    </div>
                 </div>
                <div class="business-join">
                    <p class="p-letter" >통신판매업신고번호</p>
                    <input type="text" name="report_number" id="sell_no" placeholder="통신 판매업 신고번호를 입력해주세요.">
                </div>
                <div class="css-1og0zk92">
                    	<p class="css-3y93rl"></p>
                    	<div class="rowletter-area">
                        	<span id="passMsg_re"></span>
                    </div>
                 </div>
                <div class="business-join a">
                    <p class="p-letter">정산계좌</p>
                    <div>
                        <select name="bank">
                        <option name="bank" value="none">=== 선택 ===</option>
						<option name="bank" value="1">카카오뱅크</option>
                        </select>
                        <input type="text" name="depositor" class="recipient account-name" placeholder="=== 입금자명 ===">
                    </div>
                </div>
                <div class="css-1og0zk92">
                    	<p class="css-3y93rl"></p>
                    	<div class="rowletter-area">
                        	<span id="passMsg_re"></span>
                    </div>
                 </div>
                <div class="business-join">
                    <p class="p-letter"></p>
                    <input type="text" name="account" class="account-name left-target" placeholder="=== 입금계좌 ===">
                </div>
                <div class="css-1og0zk92">
                    	<p class="css-3y93rl"></p>
                    	<div class="rowletter-area">
                        	<span id="passMsg_re"></span>
                    </div>
                 </div>
            </div>
            <div id="singup-file">
                <p id="check-letter">필수서류등록</p>
                <div class="singup-file-area">
                    <p class="singup-file-letter">통장사본등록</p>
                    <p class="singup-file-letter2">x통장사본등록</p>
                    <div class="filebox">
					    <label for="file">등록하기</label> 
					    <input type="file" id="file">
					</div>
                </div>
            </div>
            <div>
                <button type="button" class="lastbtn btn1">홈으로</button>
                <button class="lastbtn btn2">제출하기</button>
            </div>
            </div>
        </form>
<script src="//t1.daumcdn.net/mapjsapi/bundle/postcode/prod/postcode.v2.js"></script>
</body>
</html>