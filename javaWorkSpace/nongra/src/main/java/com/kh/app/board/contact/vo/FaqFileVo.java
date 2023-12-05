package com.kh.app.board.contact.vo;

public class FaqFileVo {
	private String fileNo;
	private String faqNo;
	private String fileName;
	public FaqFileVo() {
		super();
		// TODO Auto-generated constructor stub
	}
	public FaqFileVo(String fileNo, String faqNo, String fileName) {
		super();
		this.fileNo = fileNo;
		this.faqNo = faqNo;
		this.fileName = fileName;
	}
	public String getFileNo() {
		return fileNo;
	}
	public void setFileNo(String fileNo) {
		this.fileNo = fileNo;
	}
	public String getFaqNo() {
		return faqNo;
	}
	public void setFaqNo(String faqNo) {
		this.faqNo = faqNo;
	}
	public String getFileName() {
		return fileName;
	}
	public void setFileName(String fileName) {
		this.fileName = fileName;
	}
	@Override
	public String toString() {
		return "FaqFileVo [fileNo=" + fileNo + ", faqNo=" + faqNo + ", fileName=" + fileName + "]";
	}
	
}
