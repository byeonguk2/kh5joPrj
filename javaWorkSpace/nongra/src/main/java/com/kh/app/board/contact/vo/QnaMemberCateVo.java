package com.kh.app.board.contact.vo;

public class QnaMemberCateVo {
	private String categoryId;
	private String categoryParentId;
	private String categoryName;
	private String categoryParentName;
	public QnaMemberCateVo() {
		super();
		// TODO Auto-generated constructor stub
	}
	public QnaMemberCateVo(String categoryId, String categoryParentId, String categoryName, String categoryParentName) {
		super();
		this.categoryId = categoryId;
		this.categoryParentId = categoryParentId;
		this.categoryName = categoryName;
		this.categoryParentName = categoryParentName;
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
	public String getCategoryParentName() {
		return categoryParentName;
	}
	public void setCategoryParentName(String categoryParentName) {
		this.categoryParentName = categoryParentName;
	}
	@Override
	public String toString() {
		return "QnaMemberCateVo [categoryId=" + categoryId + ", categoryParentId=" + categoryParentId
				+ ", categoryName=" + categoryName + ", categoryParentName=" + categoryParentName + "]";
	}
	public QnaMemberCateVo(String categoryId, String categoryParentId, String categoryName) {
		super();
		this.categoryId = categoryId;
		this.categoryParentId = categoryParentId;
		this.categoryName = categoryName;
	}
	public QnaMemberCateVo(String categoryId, String categoryName) {
		super();
		this.categoryId = categoryId;
		this.categoryName = categoryName;
	}

	
	
}
