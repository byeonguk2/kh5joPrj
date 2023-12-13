package com.kh.app.purchase.vo;

public class PurchaseCartVo {
	private String goodsName;
	private String goodsPrice;
	private String optionName;
	private String optionPrice;
	private String goodsPicture;
	private String orderNumber;
	private String goodsEA;
	private String seller;
	private String totalPrice;
	
	public String getGoodsName() {
		return goodsName;
	}
	public void setGoodsName(String goodsName) {
		this.goodsName = goodsName;
	}
	public String getGoodsPrice() {
		return goodsPrice;
	}
	public void setGoodsPrice(String goodsPrice) {
		this.goodsPrice = goodsPrice;
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
	public String getGoodsPicture() {
		return goodsPicture;
	}
	public void setGoodsPicture(String goodsPicture) {
		this.goodsPicture = goodsPicture;
	}
	public String getOrderNumber() {
		return orderNumber;
	}
	public void setOrderNumber(String orderNumber) {
		this.orderNumber = orderNumber;
	}
	public String getGoodsEA() {
		return goodsEA;
	}
	public void setGoodsEA(String goodsEA) {
		this.goodsEA = goodsEA;
	}
	public String getSeller() {
		return seller;
	}
	public void setSeller(String seller) {
		this.seller = seller;
	}
	@Override
	public String toString() {
		return "PurchaseCartVo [goodsName=" + goodsName + ", goodsPrice=" + goodsPrice + ", optionName=" + optionName
				+ ", optionPrice=" + optionPrice + ", goodsPicture=" + goodsPicture + ", orderNumber=" + orderNumber
				+ ", goodsEA=" + goodsEA + ", seller=" + seller + "]";
	}
	public PurchaseCartVo() {
		super();
		// TODO Auto-generated constructor stub
	}
	public PurchaseCartVo(String goodsName, String goodsPrice, String optionName, String optionPrice,
			String goodsPicture, String orderNumber, String goodsEA, String seller) {
		super();
		this.goodsName = goodsName;
		this.goodsPrice = goodsPrice;
		this.optionName = optionName;
		this.optionPrice = optionPrice;
		this.goodsPicture = goodsPicture;
		this.orderNumber = orderNumber;
		this.goodsEA = goodsEA;
		this.seller = seller;
		this.totalPrice = Integer.toString((Integer.parseInt(goodsPrice) + Integer.parseInt(optionPrice))*Integer.parseInt(goodsEA));
	}

	public String getTotalPrice() {
		int totalPrice = (Integer.parseInt(goodsPrice) + Integer.parseInt(optionPrice))*Integer.parseInt(goodsEA);
		return Integer.toString(totalPrice);
	}



	
	
}