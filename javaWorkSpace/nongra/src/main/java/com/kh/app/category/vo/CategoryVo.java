package com.kh.app.category.vo;

public class CategoryVo {
	private String categoryNo;
	private String categoryNo2;
	private String category;
	public CategoryVo() {
		super();
		// TODO Auto-generated constructor stub
	}
	public CategoryVo(String categoryNo, String categoryNo2, String category) {
		super();
		this.categoryNo = categoryNo;
		this.categoryNo2 = categoryNo2;
		this.category = category;
	}
	public String getCategoryNo() {
		return categoryNo;
	}
	public void setCategoryNo(String categoryNo) {
		this.categoryNo = categoryNo;
	}
	public String getCategoryNo2() {
		return categoryNo2;
	}
	public void setCategoryNo2(String categoryNo2) {
		this.categoryNo2 = categoryNo2;
	}
	public String getCategory() {
		return category;
	}
	public void setCategory(String category) {
		this.category = category;
	}
	@Override
	public String toString() {
		return "CategoryVo [categoryNo=" + categoryNo + ", categoryNo2=" + categoryNo2 + ", category=" + category + "]";
	}
	
	
}
