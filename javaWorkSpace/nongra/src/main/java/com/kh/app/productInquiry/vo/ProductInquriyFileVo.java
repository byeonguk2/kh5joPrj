package com.kh.app.productInquiry.vo;

public class ProductInquriyFileVo {
	private String   inquireFile; //파일번호 
	private String   fileSrc; // 파일주소
	
	public ProductInquriyFileVo() {
		super();
		// TODO Auto-generated constructor stub
	}
	public ProductInquriyFileVo(String inquireFile, String fileSrc) {
		super();
		this.inquireFile = inquireFile;
		this.fileSrc = fileSrc;
	}
	
	
	
	
	public String getInquireFile() {
		return inquireFile;
	}
	public void setInquireFile(String inquireFile) {
		this.inquireFile = inquireFile;
	}
	public String getFileSrc() {
		return fileSrc;
	}
	public void setFileSrc(String fileSrc) {
		this.fileSrc = fileSrc;
	}
	@Override
	public String toString() {
		return "ProductInquriyFileVo [inquireFile=" + inquireFile + ", fileSrc=" + fileSrc + "]";
	}
	
	
	
	
	
	
	
}
