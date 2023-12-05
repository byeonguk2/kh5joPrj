package com.kh.app.purchase.vo;

public class PurchaseCartVo {
	private String goodsName;
	private int goodsPrice;
	private String optionName;
	private int optionPrice;
	private String goodsPicture;
	private int orderNumber;
	private int ea;
	public String getGoodsName() {
		return goodsName;
	}
	public void setGoodsName(String goodsName) {
		this.goodsName = goodsName;
	}
	public int getGoodsPrice() {
		return goodsPrice;
	}
	public void setGoodsPrice(int goodsPrice) {
		this.goodsPrice = goodsPrice;
	}
	public String getOptionName() {
		return optionName;
	}
	public void setOptionName(String optionName) {
		this.optionName = optionName;
	}
	public int getOptionPrice() {
		return optionPrice;
	}
	public void setOptionPrice(int optionPrice) {
		this.optionPrice = optionPrice;
	}
	public String getGoodsPicture() {
		return goodsPicture;
	}
	public void setGoodsPicture(String goodsPicture) {
		this.goodsPicture = goodsPicture;
	}
	public int getOrderNumber() {
		return orderNumber;
	}
	public void setOrderNumber(int orderNumber) {
		this.orderNumber = orderNumber;
	}
	public int getEa() {
		return ea;
	}
	public void setEa(int ea) {
		this.ea = ea;
	}
	@Override
	public String toString() {
		return "PurchaseVo [goodsName=" + goodsName + ", goodsPrice=" + goodsPrice + ", optionName=" + optionName
				+ ", optionPrice=" + optionPrice + ", goodsPicture=" + goodsPicture + ", orderNumber=" + orderNumber
				+ ", ea=" + ea + "]";
	}
	public PurchaseCartVo() {
		super();
		// TODO Auto-generated constructor stub
	}
	public PurchaseCartVo(String goodsName, int goodsPrice, String optionName, int optionPrice, String goodsPicture,
			int orderNumber, int ea) {
		super();
		this.goodsName = goodsName;
		this.goodsPrice = goodsPrice;
		this.optionName = optionName;
		this.optionPrice = optionPrice;
		this.goodsPicture = goodsPicture;
		this.orderNumber = orderNumber;
		this.ea = ea;
	}
	
	
}
