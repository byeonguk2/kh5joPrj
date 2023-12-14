<%@page import="com.kh.app.home.vo.SalesVo_v2"%>
<%@page import="java.util.Map"%>
<%@page import="org.apache.jasper.tagplugins.jstl.core.ForEach"%>
<%@page import="java.util.List"%>
<%@page import="com.kh.app.sales.vo.SalesVo"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
pageEncoding="UTF-8"%>
    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<!-- Latest compiled and minified CSS -->
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/css/bootstrap.min.css" rel="stylesheet">
<style>

	/* 레이아웃 잡기 */
	.header-area{
		display: grid;
		grid-template-columns: 1fr 1050px 1fr;
	}

	#shadow{
		box-shadow: 0px 3px 4px 0px rgba(0, 0, 0, 0.07);
	}

	/* 슬라이드 */
	#demo{
		margin-bottom: 100px;
	}

	.carousel-item{
		background-size: cover;
	}

	/* 상품소개 */
	.ItemIntroduction-box{
		margin: auto; 
		width: 1050px; 
		height: 600px;
		padding: 40px 0px;
		margin-bottom: 20px;
	}

	.title-area{
		display: flex;
		flex-direction: column;
	}

	.title-top{
		color: rgb(51, 51, 51);
		font-size: 28px;
		line-height: 1.15;
		letter-spacing: -0.26px;
		font-weight: 500;
		text-align: center;
	}

	.title-bottom{
		font-size: 16px;
		font-weight: normal;
		line-height: 1.45;
		letter-spacing: -0.2px;
		text-align: center;
		color: rgb(153, 153, 153);
		margin-top: 2px;
	}

	.item-area{
		display: grid;
		grid-template-columns: 1fr 1fr 1fr 1fr;
	}

	.item > img {
		width: 250px;
		height: 300px;
		background-size: cover;
	}

	.shopingCart-btn{
		display: flex;
		-webkit-box-pack: center;
		justify-content: center;
		-webkit-box-align: center;
		align-items: center;
		width: 250px;
		height: 36px;
		margin-top: 6px;
		padding-bottom: 1px;
		font-size: 16px;
		line-height: 29px;
		border: 1px solid rgb(221, 221, 221);
		border-radius: 4px;
	}

	.cart-icon{
		background-image: url("https://w7.pngwing.com/pngs/833/426/png-transparent-black-shopping-cart-icon-for-free-black-shopping-cart-icon.png");
		width: 22px;
		height: 22px;
		margin: 1px 4px 0px 0px;
		background-size: cover;
	}

	.item-guide{
		font-size: 16px;
		line-height: 23px;
		font-weight: 400;
		margin-bottom: 8px;
		overflow: hidden;
		text-overflow: ellipsis;
		display: -webkit-box;
		-webkit-line-clamp: 2;
		-webkit-box-orient: vertical;
		letter-spacing: normal;
		word-break: break-word;
		overflow-wrap: break-word;
	}

	.price{
		font-size: 16px;
		font-weight: 800;
		line-height: 1.5;
		white-space: nowrap;
	}

	.event-area{
		margin: auto;
		margin-bottom: 100px;
		padding: 30px 50px 30px 50px;
		height: 140px;
		width: 1050px;
		border: 1px solid #754327;
		display: flex;
    	flex-direction: column;
	}
	
	.event-area > span {
		font-size: 32px;
		color: #754327;
	}
	
	.event-area > a {
	    padding-top: 11px;
	    font-size: 16px;
	    color: rgb(153, 153, 153);
	    font-weight: normal;
	    line-height: 1.3;
	    letter-spacing: normal;
	    text-decoration-line: none;
	}
	
	/* 모달창 */
	.modal {
	display: flex;
	justify-content: center;
	align-items: center;
	position:fixed;
	left: 0;
	right: 0;
	top: 0;
	bottom: 0;
	background: rgba(0,0,0,0.3);

	}
	/* 여기안에서 작업하면되고 */
	.dialog {
	width: 440px;
    height: 400px;
    padding: 2em;
    border-radius: 1em;
    background: white;
	}

	/* 토글로 열고 닫기 style */
	.modal-none{
		display: none;
	} 

	.sales-title{
		display: flex;
		gap: 20px;
		padding: 10px 0px;
		border-bottom: 1px solid rgb(244, 244, 244);
	}

	.sales-title > div > img{
		background-size: cover;
		width: 50px;
		height: 50px;
	}
	.sales-title > div > span{
		font-weight: 500;
		font-size: 16px;
		line-height: 50px;
	}

	.middle{
		display: flex;
		flex-direction: column;
		padding: 10px 0px;
		border-bottom: 1px solid rgb(244, 244, 244);
	}

	.detail-name{
		font-size: 14px;
		line-height: 19px;
		color: rgb(51, 51, 51);
		padding-top: 10px;
	}

	.guide {
		font-size: 12px;
		line-height: 1.33;
		margin-top: 2px;
		color: rgb(102, 102, 102);
	}

	.modal-price{
		font-weight: bold;
		font-size: 14px;
		color: rgb(51, 51, 51);
		line-height: 28px;
	}

	.calculation-area{
		display: flex;
		justify-content: space-between;
		margin-top: 7px;
	}

	.calculation{
		display: flex;
	}

	.minus{
		width: 28px;
		height: 28px;
		color: transparent;
		border: none;
		border-top: 1px solid gainsboro;
		border-left: 1px solid gainsboro;
		border-bottom: 1px solid gainsboro;
		background-color: white;
		background-size: cover;
		background-image: url("data:image/svg+xml;base64,PHN2ZyB3aWR0aD0iMzAiIGhlaWdodD0iMzAiIHZpZXdCb3g9IjAgMCAzMCAzMCIgeG1sbnM9Imh0dHA6Ly93d3cudzMub3JnLzIwMDAvc3ZnIj4KICAgIDxwYXRoIGQ9Ik0yMCAxNHYySDEwdi0yeiIgZmlsbD0iI0RERCIgZmlsbC1ydWxlPSJub256ZXJvIi8+Cjwvc3ZnPgo=");
	}

	.quantity {
		width: 31px;
		height: 28px;
		border: none;
		border-top: 1px solid gainsboro;
		border-bottom: 1px solid gainsboro;
		background-color: white;
		text-align: center;
	}

	.plus {
		width: 28px;
		height: 28px;
		border: none;
		color: transparent;
		border-top: 1px solid gainsboro;
		border-right: 1px solid gainsboro;
		border-bottom: 1px solid gainsboro;
		background-color: white;
		background-size: cover;
		background-image: url("data:image/svg+xml;base64,PHN2ZyB3aWR0aD0iMzAiIGhlaWdodD0iMzAiIHZpZXdCb3g9IjAgMCAzMCAzMCIgeG1sbnM9Imh0dHA6Ly93d3cudzMub3JnLzIwMDAvc3ZnIj4KICAgIDxwYXRoIGQ9Ik0xNiAxMHY0aDR2MmgtNHY0aC0ydi00aC00di0yaDR2LTRoMnoiIGZpbGw9IiMzMzMiIGZpbGwtcnVsZT0ibm9uemVybyIvPgo8L3N2Zz4K");
	}

	.total-price-area{
		display: flex;
		justify-content: space-between;
	}

	.total{
		font-weight: bold;
		font-size: 14px;
		color: rgb(51, 51, 51);
		line-height: 19px;
	}

	.real-price{
		font-size: 24px;
		font-weight: 500;
		line-height: 24px;
	}

	.bottom{
		padding: 14px 0px 20px;
	}

	.modal-point {
		font-size: 13px;
		line-height: 18px;
		color: rgb(51, 51, 51);
		text-align: right;
	}

	.btn-area{
		display: flex;
   	 	flex-direction: row;
	}

	.btn-area > button {
		width: 50%;
    	margin: 0px 4px;
		display: block;
		padding: 0px 10px;
		text-align: center;
		overflow: hidden;
		height: 56px;
		border-radius: 3px;
		border: 1px solid rgb(221, 221, 221);
	}

	.cart-btn{
		background-color: #754327;
		color: white;
	}

	#modal-close{
		color: rgb(51, 51, 51);
		background-color: white;
	}

	.select{
		width: 150px;
	}

</style>
</head>
<body>
	<div id="wrap">
		<div class="header-area">
			<div id="shadow"></div>
			<%@	include file="/WEB-INF/views/common/header/header_sobi.jsp" %>
			<div id="shadow"></div>
		</div>
	<main>
		<!-- 부트 스트랩 사진 슬라이드 -->
		<!-- Carousel -->
		<div id="demo" class="carousel slide" data-bs-ride="carousel">

			<!-- Indicators/dots -->
			<div class="carousel-indicators">
			<button type="button" data-bs-target="#demo" data-bs-slide-to="0" class="active"></button>
			<button type="button" data-bs-target="#demo" data-bs-slide-to="1"></button>
			<button type="button" data-bs-target="#demo" data-bs-slide-to="2"></button>
			</div>
		
			<!-- The slideshow/carousel -->
			<div class="carousel-inner">
			<div class="carousel-item active">
				<img src="https://product-image.kurly.com/cdn-cgi/image/width=1900,height=370,quality=85/banner/main/pc/img/cc2f7b09-2c3a-4526-892e-3afc0ed79d61.png" alt="Los Angeles" class="d-block w-100">
			</div>
			<div class="carousel-item">
				<img src="https://product-image.kurly.com/cdn-cgi/image/width=1900,height=370,quality=85/banner/main/pc/img/d302a6ae-1ea5-484c-9faa-be1e508f0ac7.jpg" alt="Chicago" class="d-block w-100">
			</div>
			<div class="carousel-item">
				<img src="https://product-image.kurly.com/cdn-cgi/image/width=1900,height=370,quality=85/banner/main/pc/img/eb7244c9-dd99-4153-8ce2-b87586e5b52e.jpg" alt="New York" class="d-block w-100">
			</div>
			</div>
		
			<!-- Left and right controls/icons -->
			<button class="carousel-control-prev" type="button" data-bs-target="#demo" data-bs-slide="prev">
			<span class="carousel-control-prev-icon"></span>
			</button>
			<button class="carousel-control-next" type="button" data-bs-target="#demo" data-bs-slide="next">
			<span class="carousel-control-next-icon"></span>
			</button>
		</div>

		<!-- 상품 보여주기 -->
		<div class="ItemIntroduction-box">
			<div class="title-area">
				<span class="title-top">✨리뷰 작성이 많은순🏅</span>
				<p class="title-bottom">농라 추천 득템 기회❗️</p>
			</div>
			<div class="item-area first modal-open">
				
			</div>
		</div>
		
		
		<div class="ItemIntroduction-box">
			<div class="title-area">
				<span class="title-top">✨가장 많이 주문한 상품🏅</span>
				<p class="title-bottom">농라 회원들의 베스트 상품들❗️</p>
			</div>
			<div class="item-area tow modal-open">
				<!-- 자바스크립트로 처리할거임 -->
					
			</div>
		</div>

		<div class="event-area">
			<span>현재 진행중인 이벤트❗</span>
			<a href="/nongra/event/list">현재 진행중인 이벤트를 확인하러 가기</a>
			
		</div>

		<div class="ItemIntroduction-box">
			<div class="title-area">
				<!-- 이 라인은 겨울픽 음식 넣기 -->
				<span class="title-top">✨겨울철 최고의 음식 🍠</span>
				<p class="title-bottom">추운 겨울을 따듯하고 든든하게❗️</p>
			</div>
			<div class="item-area">
				<div class="item">
					<img src="https://product-image.kurly.com/cdn-cgi/image/fit=crop,width=360,height=468,quality=85/product/image/fc3eb710-126d-4c18-b776-ac6809b07a73.jpeg" alt="">
					<button class="modal-open shopingCart-btn">
						<!-- 카트 ajax -->
						<span class="cart-icon"></span>
						담기
					</button>
					<h3 class="item-guide">[델리치오] 호주산 목초육 안심 스테이크 250g (냉장)</h3>
					<span class="price">20000원</span>
				</div>
				<div class="item">
					<img src="https://product-image.kurly.com/cdn-cgi/image/fit=crop,width=360,height=468,quality=85/product/image/fc3eb710-126d-4c18-b776-ac6809b07a73.jpeg" alt="">
					<button class="modal-open shopingCart-btn">
						<span class="cart-icon"></span>
						담기
					</button>
					<h3 class="item-guide">[델리치오] 호주산 목초육 안심 스테이크 250g (냉장)</h3>
					<span class="price">20000원</span>
				</div>
				<div class="item">
					<img src="https://product-image.kurly.com/cdn-cgi/image/fit=crop,width=360,height=468,quality=85/product/image/fc3eb710-126d-4c18-b776-ac6809b07a73.jpeg" alt="">
					<button class="shopingCart-btn">
						<span class="cart-icon"></span>
						"담기"
					</button>
					<h3 class="item-guide">[델리치오] 호주산 목초육 안심 스테이크 250g (냉장)</h3>
					<span class="price">20000원</span>
				</div>
				<div class="item">
					<img src="https://product-image.kurly.com/cdn-cgi/image/fit=crop,width=360,height=468,quality=85/product/image/fc3eb710-126d-4c18-b776-ac6809b07a73.jpeg" alt="">
					<button class="shopingCart-btn">
						<span class="cart-icon"></span>
						담기
					</button>
					<h3 class="item-guide">[델리치오] 호주산 목초육 안심 스테이크 250g (냉장)</h3>
					<span class="price">20000원</span>
				</div>
			</div>
		</div> 

		<div class="ItemIntroduction-box">
			<div class="title-area">
				<span class="title-top">✨리뷰 좋아요가 많은 상품들🥩</span>
				<p class="title-bottom">농라 회원님들의 평가가 좋은 상품❗️</p>
			</div>
			<div class="item-area three modal-open">
				
			</div>
		</div>
	</main>
	
	<!-- 풋터 영역 -->
	
		
	</div>
<!-- Latest compiled JavaScript -->
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/js/bootstrap.bundle.min.js"></script>

<!-- 모달창 -->
<div class="modal modal-none">
	<div class="dialog">
			<div class="sales-title">
				<div>
					<img src="" alt="" class="madal-img">
				</div>
				<div>
					<span class="option-title"></span>
				</div>
			</div>
			<div class="middle">
				<input type="hidden" class="modal-hidden">
				<span class="detail-name">[KF365] 간편한 6가지 해물 모듬 600g</span>
				<span class="guide">적립제외상품</span>
				<div class="calculation-area">
					<span class="modal-price"></span>
					<div class="calculation">
						<button class="minus">  </button>
						<div class="quantity">1</div>
						<button class="plus"></button>
					</div>
				</div>
			</div>
			<div class="bottom">
				<div class="total-price-area">
					<select class="select">
						
					</select>
					<div class="real-price">
						<span class="total-price">8200</span>
						<span>원</span>
					</div>
				</div>
				<p class="modal-point">로그인 후, 적립 혜택 제공</p>
			</div>
			<div class="btn-area">
				<button id="modal-close">취소</button>
				<button class="cart-btn" onclick="insertCart()">장바구니</button>
			</div>
	</div>	
</div>

<script>
	
	getSales();

    function getSales() {
	// 모든 데이터 바로 요청받기
	fetch("/nongra/home/select")
	.then((resp)=>{return resp.json();})
	.then((data)=>{
		console.log(data);

		const list = data.salesBestReviewVoList;
		const orderList = data.salesBestOrderVoList;
		const ReviewLikeList = data.salesBestReviewLikeVoList;

		// 리뷰 작성이 많은순
		for (const x in list) {

			const frist = document.querySelector(".first");

			// 디브 생성
			let div = document.createElement('div');
			let textNode = document.createTextNode(data);

			frist.appendChild(div);
			div.classList.add("item");

			let img = document.createElement('img');
			div.appendChild(img);
			img.src = '/nongra'+list[x].thumbNail;

			let btn = document.createElement('button');
			btn.classList.add("modal-open");
			btn.classList.add("shopingCart-btn");
			let span = document.createElement('span');
			span.classList.add('cart-icon');
			btn.appendChild(span);
			btn.appendChild(document.createTextNode("담기"));
			div.appendChild(btn);

			let h3 = document.createElement('h3');
			h3.classList.add("item-guide");
			h3.appendChild(document.createTextNode(list[x].title))
			div.appendChild(h3);

			let span2 = document.createElement('span');
			span2.classList.add("price");
			span2.appendChild(document.createTextNode(list[x].price+'원'))
			div.appendChild(span2);
			let input = document.createElement('input');
			input.type = 'hidden';
			input.value = list[x].salesNo;
			btn.appendChild(input);
			localStorage.setItem(list[x].salesNo, JSON.stringify({ "List" : list[x] }));

		}

		for (const x in orderList) {

		const frist = document.querySelector(".tow");

		// 디브 생성
		let div = document.createElement('div');
		let textNode = document.createTextNode(data);

		frist.appendChild(div);
		div.classList.add("item");

		let img = document.createElement('img');
		div.appendChild(img);
		img.src = '/nongra'+orderList[x].thumbNail;

		let btn = document.createElement('button');
		btn.classList.add("modal-open");
		btn.classList.add("shopingCart-btn");
		let span = document.createElement('span');
		span.classList.add('cart-icon');
		btn.appendChild(span);
		btn.appendChild(document.createTextNode("담기"));
		div.appendChild(btn);

		let h3 = document.createElement('h3');
		h3.classList.add("item-guide");
		h3.appendChild(document.createTextNode(orderList[x].title))
		div.appendChild(h3);

		let span2 = document.createElement('span');
		span2.classList.add("price");
		span2.appendChild(document.createTextNode(orderList[x].price+'원'))
		div.appendChild(span2);

		let input = document.createElement('input');
		input.type = 'hidden';
		input.value = orderList[x].salesNo;
		console.log(input);
		btn.appendChild(input);

		localStorage.setItem(orderList[x].salesNo, JSON.stringify({ "List" : orderList[x] }));

		}

		for (const x in ReviewLikeList) {

		const frist = document.querySelector(".three");
		// 디브 생성
		let div = document.createElement('div');
		let textNode = document.createTextNode(data);

		frist.appendChild(div);
		div.classList.add("item");

		let img = document.createElement('img');
		div.appendChild(img);
		img.src = '/nongra'+ReviewLikeList[x].thumbNail;

		let btn = document.createElement('button');
		btn.classList.add("modal-open");
		btn.classList.add("shopingCart-btn");
		let span = document.createElement('span');
		span.classList.add('cart-icon');
		btn.appendChild(span);
		btn.appendChild(document.createTextNode("담기"));
		div.appendChild(btn);

		let h3 = document.createElement('h3');
		h3.classList.add("item-guide");
		h3.appendChild(document.createTextNode(ReviewLikeList[x].title))
		div.appendChild(h3);

		let span2 = document.createElement('span');
		span2.classList.add("price");
		span2.appendChild(document.createTextNode(ReviewLikeList[x].price+'원'))
		div.appendChild(span2);

		let input = document.createElement('input');
		input.type = 'hidden';
		input.value = ReviewLikeList[x].salesNo;
		btn.appendChild(input);
		localStorage.setItem(ReviewLikeList[x].salesNo, JSON.stringify({ "List" : ReviewLikeList[x] }));

		}

	})
	}
    

// 디브 선택
const modal = document.querySelector(".modal");
// 모달창 열기버튼
const open = document.querySelectorAll(".modal-open");

//모달창 닫기버튼
const close = document.querySelector("#modal-close");


for (let i = 0; i < open.length; ++i) {
    open[i].addEventListener('click', (node) => {
		let x = node.target.lastChild.value;
        console.log("버튼이 클릭되었습니다:");
		let item = localStorage.getItem(x);
		const itemData = JSON.parse(item);
		let optionVo = itemData.List.OptionVo;

		// 중복을 제거한 새로운 배열 생성
		let uniqueOptionNosSet = new Set(optionVo.map(option => option.optionNo));
		console.log(uniqueOptionNosSet.size);

		// uniqueOptionNos를 이용하여 중복이 제거된 배열 사용
		for (const optionNo of uniqueOptionNosSet) {
			// Find the first option with the corresponding optionNo
			const uniqueOption = optionVo.find(option => option.optionNo === optionNo);

			const select = document.querySelector(".select");
			let option = document.createElement('option');
			option.value = uniqueOption.optionNo;
			option.innerHTML = "옵션이름:" + uniqueOption.optionName + "/ 옵션가격" + uniqueOption.optionPrice;
			select.appendChild(option);
		}
		
		const inputHidden = document.querySelector(".modal-hidden");
		inputHidden.value = itemData.List.salesNo;

		document.querySelector(".option-title").innerHTML = itemData.List.title;
		document.querySelector(".madal-img").src = "/nongra"+itemData.List.thumbNail;

		document.querySelector(".modal-price").innerHTML = itemData.List.price+"원";
		document.querySelector(".total-price").innerHTML = itemData.List.price;

        modal.classList.toggle("modal-none", false);
    });
}

close.addEventListener('click', () => {
	document.querySelector(".quantity").innerHTML = 1;
	const select = document.querySelector(".select");
	select.innerHTML = "";
    console.log("닫기 버튼이 클릭되었습니다.");
    modal.classList.toggle("modal-none", true);
});
	

let plus = document.querySelectorAll(".plus");
let totalprice = document.querySelector(".total-price");

for (let i = 0; i < plus.length; ++i) {
	plus[i].addEventListener('click', (node) => {

		const num = node.currentTarget.previousElementSibling;
		console.log(num);
		num.innerHTML = parseInt(num.innerText)+1;

		const totalPrice = document.querySelector(".total-price");
		let price = document.querySelector(".modal-price").innerText;
		if (price.length > 0) {
    		price = price.slice(0, -1);
		}
		totalPrice.innerHTML = parseInt(totalPrice.innerText)+parseInt(price);

	});
}

let minus = document.querySelectorAll(".minus");

for (let i = 0; i < minus.length; ++i) {
	minus[i].addEventListener('click', (node) => {

		const num = node.currentTarget.nextElementSibling;

		console.log(num);

		if(parseInt(num.innerText) > 1){
			num.innerHTML = parseInt(num.innerText)-1;
		}

		const totalPrice = document.querySelector(".total-price");
		let price = document.querySelector(".modal-price").innerText;
		if (price.length > 0) {
    		price = price.slice(0, -1);
		}
		totalPrice.innerHTML = parseInt(totalPrice.innerText)-parseInt(price);

	});
}

function insertCart() {

	const optionNo = document.querySelector("select").value; //ok
	const quantity = document.querySelector(".quantity").innerText; //ok
	const salesNo = document.querySelector(".modal-hidden").value; //ok 
	

	// 서버에 전송할 데이터를 객체로 정의
	const dataToSend = {
	optionNo: optionNo,
	quantity: quantity,
	salesNo: salesNo
	};

	fetch("/nongra/home/select", {
	method: "POST",
	headers: {
		"Content-Type": "application/json"
		// 기타 필요한 헤더를 여기에 추가할 수 있습니다.
	},
	body: JSON.stringify(dataToSend) // 데이터를 JSON 문자열로 변환하여 전송
	})
	.then(resp => resp.json())
	.then(data => {
	// 서버에서 받은 응답 데이터를 처리
	console.log(data);
	})
	.catch(error => {
	// 에러 처리
	console.error("Error:", error);
	});

}

</script>

</body>
</html>