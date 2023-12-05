package com.kh.app.board.contact.vo;

public class FaqVo {
	private String faqNo;
	private String categoryId;
	private String writerNo;
	private String title;
	private String content;
	private String enrollDate;
	private String modifyDate;
	private String openYn;
	private String readPermission;
	public FaqVo() {
		super();
		// TODO Auto-generated constructor stub
	}
	public FaqVo(String faqNo, String categoryId, String writerNo, String title, String content, String enrollDate,
			String modifyDate, String openYn, String readPermission) {
		super();
		this.faqNo = faqNo;
		this.categoryId = categoryId;
		this.writerNo = writerNo;
		this.title = title;
		this.content = content;
		this.enrollDate = enrollDate;
		this.modifyDate = modifyDate;
		this.openYn = openYn;
		this.readPermission = readPermission;
	}
	public String getFaqNo() {
		return faqNo;
	}
	public void setFaqNo(String faqNo) {
		this.faqNo = faqNo;
	}
	public String getCategoryId() {
		return categoryId;
	}
	public void setCategoryId(String categoryId) {
		this.categoryId = categoryId;
	}
	public String getWriterNo() {
		return writerNo;
	}
	public void setWriterNo(String writerNo) {
		this.writerNo = writerNo;
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
	public String getOpenYn() {
		return openYn;
	}
	public void setOpenYn(String openYn) {
		this.openYn = openYn;
	}
	public String getReadPermission() {
		return readPermission;
	}
	public void setReadPermission(String readPermission) {
		this.readPermission = readPermission;
	}
	@Override
	public String toString() {
		return "FaqVo [faqNo=" + faqNo + ", categoryId=" + categoryId + ", writerNo=" + writerNo + ", title=" + title
				+ ", content=" + content + ", enrollDate=" + enrollDate + ", modifyDate=" + modifyDate + ", openYn="
				+ openYn + ", readPermission=" + readPermission + "]";
	}
	
	
	
	
}
