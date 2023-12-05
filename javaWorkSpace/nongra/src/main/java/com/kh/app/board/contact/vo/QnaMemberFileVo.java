package com.kh.app.board.contact.vo;

public class QnaMemberFileVo {
	private String fileNo;
	private String memberQnaNo;
	private String fileName;
	public QnaMemberFileVo() {
		super();
		// TODO Auto-generated constructor stub
	}
	public QnaMemberFileVo(String fileNo, String memberQnaNo, String fileName) {
		super();
		this.fileNo = fileNo;
		this.memberQnaNo = memberQnaNo;
		this.fileName = fileName;
	}
	public String getFileNo() {
		return fileNo;
	}
	public void setFileNo(String fileNo) {
		this.fileNo = fileNo;
	}
	public String getMemberQnaNo() {
		return memberQnaNo;
	}
	public void setMemberQnaNo(String memberQnaNo) {
		this.memberQnaNo = memberQnaNo;
	}
	public String getFileName() {
		return fileName;
	}
	public void setFileName(String fileName) {
		this.fileName = fileName;
	}
	@Override
	public String toString() {
		return "QnaMemberFileVo [fileNo=" + fileNo + ", memberQnaNo=" + memberQnaNo + ", fileName=" + fileName + "]";
	}
	
	
}
