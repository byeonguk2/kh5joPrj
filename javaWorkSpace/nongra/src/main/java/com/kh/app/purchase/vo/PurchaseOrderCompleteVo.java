package com.kh.app.purchase.vo;

public class PurchaseOrderCompleteVo {
	private String totalPrice;
	private String orderNo;

	public String getTotalPrice() {
		return totalPrice;
	}
	public void setTotalPrice(String totalPrice) {
		this.totalPrice = totalPrice;
	}
	public String getOrderNo() {
		return orderNo;
	}
	public void setOrderNo(String orderNo) {
		this.orderNo = orderNo;
	}

	@Override
	public String toString() {
		return "PurchaseOrderCompleteVo [totalPrice=" + totalPrice + ", orderNo=" + orderNo + "]";
	}

	public PurchaseOrderCompleteVo() {
		super();
		// TODO Auto-generated constructor stub
	}
	public PurchaseOrderCompleteVo(String totalPrice, String orderNo) {
		super();
		this.totalPrice = totalPrice;
		this.orderNo = orderNo;
	}

	
	
	
	
	
}
