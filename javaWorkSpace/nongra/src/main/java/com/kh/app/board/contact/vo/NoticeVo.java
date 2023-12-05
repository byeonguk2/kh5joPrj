package com.kh.app.board.contact.vo;

public class NoticeVo {
	private String noticeNo;
	private String writerNo;
	private String title;
	private String content;
	private String enrollDate;
	private String modifyDate;
	private String openYn;
	private String readPermission;
	private String topDisplay;
	public NoticeVo() {
		
	}
	public NoticeVo(String noticeNo, String writerNo, String title, String content, String enrollDate,
			String modifyDate, String openYn, String readPermission, String topDisplay) {
		super();
		this.noticeNo = noticeNo;
		this.writerNo = writerNo;
		this.title = title;
		this.content = content;
		this.enrollDate = enrollDate;
		this.modifyDate = modifyDate;
		this.openYn = openYn;
		this.readPermission = readPermission;
		this.topDisplay = topDisplay;
	}
	public String getNoticeNo() {
		return noticeNo;
	}
	public void setNoticeNo(String noticeNo) {
		this.noticeNo = noticeNo;
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
	public String getTopDisplay() {
		return topDisplay;
	}
	public void setTopDisplay(String topDisplay) {
		this.topDisplay = topDisplay;
	}
	@Override
	public String toString() {
		return "NoticeVo [noticeNo=" + noticeNo + ", writerNo=" + writerNo + ", title=" + title + ", content=" + content
				+ ", enrollDate=" + enrollDate + ", modifyDate=" + modifyDate + ", openYn=" + openYn
				+ ", readPermission=" + readPermission + ", topDisplay=" + topDisplay + "]";
	}
	
	
}
