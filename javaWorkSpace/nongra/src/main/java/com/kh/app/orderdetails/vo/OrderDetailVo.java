package com.kh.app.orderdetails.vo;

public class OrderDetailVo {
    
	private String  deliveryYn;    						//"구매확정여부"
	private String  payNo;             					//"결제이력번호"
	private String  orderNo;       						//"주문번호"
	private String  orderEnrollDate;    				//  "주문일자"
	private String  refundYn;      						// "환불여부"
	private String  refundDte;   						// "환불일"
	private String  itemtitle;       					// "상품명" 
	private String  price; 		 						//"상품가격"
	private String  salesNo; 	 						//"상품번호"
	private String  optionName;  						//"상품옵션명" 
	private String  optionPrice; 						//"옵션가격"
	private String   thumbnail;  						//"상품사진주소" 
	private String    ea; 								//"상품수량"
	private String   totalPrice;  						//"총가격"
	private String    businessName; 					//"판매점" 
	private String    cbNo; 							//"내역번호"
	private String    reviewNo;  						//"리뷰여부"   
	@Override
	public String toString() {
		return "OrderDetailVo [deliveryYn=" + deliveryYn + ", payNo=" + payNo + ", orderNo=" + orderNo
				+ ", orderEnrollDate=" + orderEnrollDate + ", refundYn=" + refundYn + ", refundDte=" + refundDte
				+ ", itemtitle=" + itemtitle + ", price=" + price + ", salesNo=" + salesNo + ", optionName="
				+ optionName + ", optionPrice=" + optionPrice + ", thumbnail=" + thumbnail + ", ea=" + ea
				+ ", totalPrice=" + totalPrice + ", businessName=" + businessName + ", cbNo=" + cbNo + ", reviewNo="
				+ reviewNo + "]";
	}
	public OrderDetailVo(String deliveryYn, String payNo, String orderNo, String orderEnrollDate, String refundYn,
			String refundDte, String itemtitle, String price, String salesNo, String optionName, String optionPrice,
			String thumbnail, String ea, String totalPrice, String businessName, String cbNo, String reviewNo) {
		super();
		this.deliveryYn = deliveryYn;
		this.payNo = payNo;
		this.orderNo = orderNo;
		this.orderEnrollDate = orderEnrollDate;
		this.refundYn = refundYn;
		this.refundDte = refundDte;
		this.itemtitle = itemtitle;
		this.price = price;
		this.salesNo = salesNo;
		this.optionName = optionName;
		this.optionPrice = optionPrice;
		this.thumbnail = thumbnail;
		this.ea = ea;
		this.totalPrice = totalPrice;
		this.businessName = businessName;
		this.cbNo = cbNo;
		this.reviewNo = reviewNo;
	}
	public OrderDetailVo() {
		super();
		// TODO Auto-generated constructor stub
	}
	public String getDeliveryYn() {
		return deliveryYn;
	}
	public void setDeliveryYn(String deliveryYn) {
		this.deliveryYn = deliveryYn;
	}
	public String getPayNo() {
		return payNo;
	}
	public void setPayNo(String payNo) {
		this.payNo = payNo;
	}
	public String getOrderNo() {
		return orderNo;
	}
	public void setOrderNo(String orderNo) {
		this.orderNo = orderNo;
	}
	public String getOrderEnrollDate() {
		return orderEnrollDate;
	}
	public void setOrderEnrollDate(String orderEnrollDate) {
		if(orderEnrollDate !=null) { this.orderEnrollDate = orderEnrollDate.substring(0,10); }
		else {
		this.orderEnrollDate = orderEnrollDate;
		}
	}
	public String getRefundYn() {
		return refundYn;
	}
	public void setRefundYn(String refundYn) {
		this.refundYn = refundYn;
	}
	public String getRefundDte() {
		return refundDte;
	}
	public void setRefundDte(String refundDte) {
		if(refundDte !=null) { this.refundDte = refundDte.substring(0,10); }
		else {
		this.refundDte = refundDte;
		}
	}
	public String getItemtitle() {
		return itemtitle;
	}
	public void setItemtitle(String itemtitle) {
		this.itemtitle = itemtitle;
	}
	public String getPrice() {
		return price;
	}
	public void setPrice(String price) {
		this.price = price;
	}
	public String getSalesNo() {
		return salesNo;
	}
	public void setSalesNo(String salesNo) {
		this.salesNo = salesNo;
	}
	public String getOptionName() {
		return optionName;
	}
	public void setOptionName(String optionName) {
		this.optionName = optionName;
	}
	public String getOptionPrice() {
		return optionPrice;
	}
	public void setOptionPrice(String optionPrice) {
		this.optionPrice = optionPrice;
	}
	public String getThumbnail() {
		return thumbnail;
	}
	public void setThumbnail(String thumbnail) {
		this.thumbnail = thumbnail;
	}
	public String getEa() {
		return ea;
	}
	public void setEa(String ea) {
		this.ea = ea;
	}
	public String getTotalPrice() {
		return totalPrice;
	}
	public void setTotalPrice(String totalPrice) {
		this.totalPrice = totalPrice;
	}
	public String getBusinessName() {
		return businessName;
	}
	public void setBusinessName(String businessName) {
		this.businessName = businessName;
	}
	public String getCbNo() {
		return cbNo;
	}
	public void setCbNo(String cbNo) {
		this.cbNo = cbNo;
	}
	public String getReviewNo() {
		return reviewNo;
	}
	public void setReviewNo(String reviewNo) {
		this.reviewNo = reviewNo;
	}
	
	

	
	
	
	
}


 
 

/*
 * public void setEnrollDate(String enrollDate) {
 * 
 * if(enrollDate !=null) { this.EnrollDate = enrollDate.substring(0,10); } }
 */
 
 
//public void setRefundDate(String refundDate) {
//    
//    if(refundDate !=null) {
//        this.refundDate = refundDate.substring(0,10);
//        }
//    }