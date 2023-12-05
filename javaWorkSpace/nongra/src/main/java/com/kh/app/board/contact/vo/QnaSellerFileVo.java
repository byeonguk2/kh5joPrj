package com.kh.app.board.contact.vo;

public class QnaSellerFileVo {
	private String fileNo;
	private String sellerQnaNo;
	private String fileName;
	public QnaSellerFileVo() {
		super();
		// TODO Auto-generated constructor stub
	}
	public QnaSellerFileVo(String fileNo, String sellerQnaNo, String fileName) {
		super();
		this.fileNo = fileNo;
		this.sellerQnaNo = sellerQnaNo;
		this.fileName = fileName;
	}
	public String getFileNo() {
		return fileNo;
	}
	public void setFileNo(String fileNo) {
		this.fileNo = fileNo;
	}
	public String getSellerQnaNo() {
		return sellerQnaNo;
	}
	public void setSellerQnaNo(String sellerQnaNo) {
		this.sellerQnaNo = sellerQnaNo;
	}
	public String getFileName() {
		return fileName;
	}
	public void setFileName(String fileName) {
		this.fileName = fileName;
	}
	@Override
	public String toString() {
		return "QnaSellerFileVo [fileNo=" + fileNo + ", sellerQnaNo=" + sellerQnaNo + ", fileName=" + fileName + "]";
	}
	
}
