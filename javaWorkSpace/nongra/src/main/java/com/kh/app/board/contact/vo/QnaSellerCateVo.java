package com.kh.app.board.contact.vo;

public class QnaSellerCateVo {
	private String categoryId;
	private String categoryParentId;
	private String categoryName;
	public QnaSellerCateVo() {
		super();
		// TODO Auto-generated constructor stub
	}
	public QnaSellerCateVo(String categoryId, String categoryParentId, String categoryName) {
		super();
		this.categoryId = categoryId;
		this.categoryParentId = categoryParentId;
		this.categoryName = categoryName;
	}
	public String getCategoryId() {
		return categoryId;
	}
	public void setCategoryId(String categoryId) {
		this.categoryId = categoryId;
	}
	public String getCategoryParentId() {
		return categoryParentId;
	}
	public void setCategoryParentId(String categoryParentId) {
		this.categoryParentId = categoryParentId;
	}
	public String getCategoryName() {
		return categoryName;
	}
	public void setCategoryName(String categoryName) {
		this.categoryName = categoryName;
	}
	@Override
	public String toString() {
		return "QnaSellerCateVo [categoryId=" + categoryId + ", categoryParentId=" + categoryParentId
				+ ", categoryName=" + categoryName + "]";
	}
	
	
}
