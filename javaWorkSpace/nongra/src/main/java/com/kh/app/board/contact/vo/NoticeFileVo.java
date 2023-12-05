package com.kh.app.board.contact.vo;

public class NoticeFileVo {
	private String fileNo;
	private String noticeNo;
	private String fileName;
	public NoticeFileVo() {
		super();
		// TODO Auto-generated constructor stub
	}
	public NoticeFileVo(String fileNo, String noticeNo, String fileName) {
		super();
		this.fileNo = fileNo;
		this.noticeNo = noticeNo;
		this.fileName = fileName;
	}
	public String getFileNo() {
		return fileNo;
	}
	public void setFileNo(String fileNo) {
		this.fileNo = fileNo;
	}
	public String getNoticeNo() {
		return noticeNo;
	}
	public void setNoticeNo(String noticeNo) {
		this.noticeNo = noticeNo;
	}
	public String getFileName() {
		return fileName;
	}
	public void setFileName(String fileName) {
		this.fileName = fileName;
	}
	@Override
	public String toString() {
		return "NoticeFileVo [fileNo=" + fileNo + ", noticeNo=" + noticeNo + ", fileName=" + fileName + "]";
	}
	
	
}
