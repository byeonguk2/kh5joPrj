package com.kh.app.seller.vo;

public class SellerSalesRegistrVo {
	private String salesNo;
	private String sellerNo;
	private String categoryNo;
	private String title;
	private String content;
	private String price;
	private String stock;
	private String origin;
	private String status;
	private String enrollDate;
	private String modifyDate;
	public SellerSalesRegistrVo() {
		super();
		// TODO Auto-generated constructor stub
	}
	public SellerSalesRegistrVo(String salesNo, String sellerNo, String categoryNo, String title, String content,
			String price, String stock, String origin, String status, String enrollDate, String modifyDate) {
		super();
		this.salesNo = salesNo;
		this.sellerNo = sellerNo;
		this.categoryNo = categoryNo;
		this.title = title;
		this.content = content;
		this.price = price;
		this.stock = stock;
		this.origin = origin;
		this.status = status;
		this.enrollDate = enrollDate;
		this.modifyDate = modifyDate;
	}
	public String getSalesNo() {
		return salesNo;
	}
	public void setSalesNo(String salesNo) {
		this.salesNo = salesNo;
	}
	public String getSellerNo() {
		return sellerNo;
	}
	public void setSellerNo(String sellerNo) {
		this.sellerNo = sellerNo;
	}
	public String getCategoryNo() {
		return categoryNo;
	}
	public void setCategoryNo(String categoryNo) {
		this.categoryNo = categoryNo;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public String getPrice() {
		return price;
	}
	public void setPrice(String price) {
		this.price = price;
	}
	public String getStock() {
		return stock;
	}
	public void setStock(String stock) {
		this.stock = stock;
	}
	public String getOrigin() {
		return origin;
	}
	public void setOrigin(String origin) {
		this.origin = origin;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public String getEnrollDate() {
		return enrollDate;
	}
	public void setEnrollDate(String enrollDate) {
		this.enrollDate = enrollDate;
	}
	public String getModifyDate() {
		return modifyDate;
	}
	public void setModifyDate(String modifyDate) {
		this.modifyDate = modifyDate;
	}
	@Override
	public String toString() {
		return "SellerSalesRegistrVo [salesNo=" + salesNo + ", sellerNo=" + sellerNo + ", categoryNo=" + categoryNo
				+ ", title=" + title + ", content=" + content + ", price=" + price + ", stock=" + stock + ", origin="
				+ origin + ", status=" + status + ", enrollDate=" + enrollDate + ", modifyDate=" + modifyDate + "]";
	}
	
	
}
