package com.kh.app.board.contact.vo;

public class FaqCateVo {
	private String categoryId;
	private String categoryName;
	public FaqCateVo() {
		super();
		// TODO Auto-generated constructor stub
	}
	public FaqCateVo(String categoryId, String categoryName) {
		super();
		this.categoryId = categoryId;
		this.categoryName = categoryName;
	}
	public String getCategoryId() {
		return categoryId;
	}
	public void setCategoryId(String categoryId) {
		this.categoryId = categoryId;
	}
	public String getCategoryName() {
		return categoryName;
	}
	public void setCategoryName(String categoryName) {
		this.categoryName = categoryName;
	}
	@Override
	public String toString() {
		return "FaqCategoryVo [categoryId=" + categoryId + ", categoryName=" + categoryName + "]";
	}
	
	
}
