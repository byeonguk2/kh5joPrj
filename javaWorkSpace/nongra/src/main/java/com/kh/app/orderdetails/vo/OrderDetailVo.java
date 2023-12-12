package com.kh.app.orderdetails.vo;

public class OrderDetailVo {
    
 private String     cartBreakdwonNo;      // 장바구니 목록 번호  
 private String  ea;                   // 수량                       
 private String  cartNo;             //장바구니           
 private String  endYn;                // 장바구니 결제완료                
 private String  orderNo;            // 주문번호                  
 private String  totalPrice;         // 총금액            
 private String  EnrollDate;     //  결제일              
 private String  DeliveryYn;    // 배달여부 (구매 확정 시 업데이트)             
 private String  refundYn;     // 환불여부            
 private String  refundDate;  //  환불 일             
 private String  memberNo;   // 유저번호                   
 private String  salesNo;   // 판매번호                  
 private String  itemTitle;// 아이템 타이틀       
 private String  sellerNo;// 판매자 번호                 
 private String  businessName; // 가게명    
 private String  reviewNo;     // 리뷰 번호
public OrderDetailVo(String cartBreakdwonNo, String ea, String cartNo, String endYn, String orderNo, String totalPrice,
        String enrollDate, String deliveryYn, String refundYn, String refundDate, String memberNo, String salesNo,
        String itemTitle, String sellerNo, String businessName, String reviewNo) {
    super();
    this.cartBreakdwonNo = cartBreakdwonNo;
    this.ea = ea;
    this.cartNo = cartNo;
    this.endYn = endYn;
    this.orderNo = orderNo;
    this.totalPrice = totalPrice;
    EnrollDate = enrollDate;
    DeliveryYn = deliveryYn;
    this.refundYn = refundYn;
    this.refundDate = refundDate;
    this.memberNo = memberNo;
    this.salesNo = salesNo;
    this.itemTitle = itemTitle;
    this.sellerNo = sellerNo;
    this.businessName = businessName;
    this.reviewNo = reviewNo;
}
@Override
public String toString() {
    return "OrderDetailVo [cartBreakdwonNo=" + cartBreakdwonNo + ", ea=" + ea + ", cartNo=" + cartNo + ", endYn="
            + endYn + ", orderNo=" + orderNo + ", totalPrice=" + totalPrice + ", EnrollDate=" + EnrollDate
            + ", DeliveryYn=" + DeliveryYn + ", refundYn=" + refundYn + ", refundDate=" + refundDate + ", memberNo="
            + memberNo + ", salesNo=" + salesNo + ", itemTitle=" + itemTitle + ", sellerNo=" + sellerNo
            + ", businessName=" + businessName + ", reviewNo=" + reviewNo + "]";
}
public OrderDetailVo() {
    super();
    // TODO Auto-generated constructor stub
}
public String getCartBreakdwonNo() {
    return cartBreakdwonNo;
}
public void setCartBreakdwonNo(String cartBreakdwonNo) {
    this.cartBreakdwonNo = cartBreakdwonNo;
}
public String getEa() {
    return ea;
}
public void setEa(String ea) {
    this.ea = ea;
}
public String getCartNo() {
    return cartNo;
}
public void setCartNo(String cartNo) {
    this.cartNo = cartNo;
}
public String getEndYn() {
    return endYn;
}
public void setEndYn(String endYn) {
    this.endYn = endYn;
}
public String getOrderNo() {
    return orderNo;
}
public void setOrderNo(String orderNo) {
    this.orderNo = orderNo;
}
public String getTotalPrice() {
    return totalPrice;
}
public void setTotalPrice(String totalPrice) {
    this.totalPrice = totalPrice;
}
public String getEnrollDate() {
    return EnrollDate;
}


public String getDeliveryYn() {
    return DeliveryYn;
}
public void setDeliveryYn(String deliveryYn) {
    DeliveryYn = deliveryYn;
}
public String getRefundYn() {
    return refundYn;
}
public void setRefundYn(String refundYn) {
    this.refundYn = refundYn;
}
public String getRefundDate() {
    return refundDate;
}

public String getMemberNo() {
    return memberNo;
}
public void setMemberNo(String memberNo) {
    this.memberNo = memberNo;
}
public String getSalesNo() {
    return salesNo;
}
public void setSalesNo(String salesNo) {
    this.salesNo = salesNo;
}
public String getItemTitle() {
    return itemTitle;
}
public void setItemTitle(String itemTitle) {
    this.itemTitle = itemTitle;
}
public String getSellerNo() {
    return sellerNo;
}
public void setSellerNo(String sellerNo) {
    this.sellerNo = sellerNo;
}
public String getBusinessName() {
    return businessName;
}
public void setBusinessName(String businessName) {
    this.businessName = businessName;
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