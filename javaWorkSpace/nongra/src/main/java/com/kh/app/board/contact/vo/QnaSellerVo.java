package com.kh.app.board.contact.vo;

public class QnaSellerVo {
	private String sellerQnaNo;
	private String categoryId;
	private String salesNo;
	private String sellerNo;
	private String title;
	private String content;
	private String enrollDate;
	private String modifyDate;
	private String modifyYn;
	private String replyWriterNo;
	private String replyContent;
	private String replyEnrollDate;
	private String replyModifyDate;
	private String categoryParentId;
	private String categoryName;
	public QnaSellerVo() {
		super();
		// TODO Auto-generated constructor stub
	}
	public QnaSellerVo(String sellerQnaNo, String categoryId, String salesNo, String sellerNo, String title,
			String content, String enrollDate, String modifyDate, String modifyYn, String replyWriterNo,
			String replyContent, String replyEnrollDate, String replyModifyDate, String categoryParentId,
			String categoryName) {
		super();
		this.sellerQnaNo = sellerQnaNo;
		this.categoryId = categoryId;
		this.salesNo = salesNo;
		this.sellerNo = sellerNo;
		this.title = title;
		this.content = content;
		this.enrollDate = enrollDate;
		this.modifyDate = modifyDate;
		this.modifyYn = modifyYn;
		this.replyWriterNo = replyWriterNo;
		this.replyContent = replyContent;
		this.replyEnrollDate = replyEnrollDate;
		this.replyModifyDate = replyModifyDate;
		this.categoryParentId = categoryParentId;
		this.categoryName = categoryName;
	}
	public String getSellerQnaNo() {
		return sellerQnaNo;
	}
	public void setSellerQnaNo(String sellerQnaNo) {
		this.sellerQnaNo = sellerQnaNo;
	}
	public String getCategoryId() {
		return categoryId;
	}
	public void setCategoryId(String categoryId) {
		this.categoryId = categoryId;
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
	public String getModifyYn() {
		return modifyYn;
	}
	public void setModifyYn(String modifyYn) {
		this.modifyYn = modifyYn;
	}
	public String getReplyWriterNo() {
		return replyWriterNo;
	}
	public void setReplyWriterNo(String replyWriterNo) {
		this.replyWriterNo = replyWriterNo;
	}
	public String getReplyContent() {
		return replyContent;
	}
	public void setReplyContent(String replyContent) {
		this.replyContent = replyContent;
	}
	public String getReplyEnrollDate() {
		return replyEnrollDate;
	}
	public void setReplyEnrollDate(String replyEnrollDate) {
		this.replyEnrollDate = replyEnrollDate;
	}
	public String getReplyModifyDate() {
		return replyModifyDate;
	}
	public void setReplyModifyDate(String replyModifyDate) {
		this.replyModifyDate = replyModifyDate;
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
		return "QnaSellerVo [sellerQnaNo=" + sellerQnaNo + ", categoryId=" + categoryId + ", salesNo=" + salesNo
				+ ", sellerNo=" + sellerNo + ", title=" + title + ", content=" + content + ", enrollDate=" + enrollDate
				+ ", modifyDate=" + modifyDate + ", modifyYn=" + modifyYn + ", replyWriterNo=" + replyWriterNo
				+ ", replyContent=" + replyContent + ", replyEnrollDate=" + replyEnrollDate + ", replyModifyDate="
				+ replyModifyDate + ", categoryParentId=" + categoryParentId + ", categoryName=" + categoryName + "]";
	}
	
	
	
	
}   
