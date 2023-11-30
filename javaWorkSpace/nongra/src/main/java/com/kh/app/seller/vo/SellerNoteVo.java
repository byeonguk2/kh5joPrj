package com.kh.app.seller.vo;

public class SellerNoteVo {
	
	private String noteNo;
	private String toNo;
	private String toNick;
	private String fromNo;
	private String fromNick;
	private String title;
	private String content;
	private String sendDate;
	private String checkDate;
	public SellerNoteVo() {
		super();
		// TODO Auto-generated constructor stub
	}
	public SellerNoteVo(String noteNo, String toNo, String toNick, String fromNo, String fromNick, String title,
			String content, String sendDate, String checkDate) {
		super();
		this.noteNo = noteNo;
		this.toNo = toNo;
		this.toNick = toNick;
		this.fromNo = fromNo;
		this.fromNick = fromNick;
		this.title = title;
		this.content = content;
		this.sendDate = sendDate;
		this.checkDate = checkDate;
	}
	public String getNoteNo() {
		return noteNo;
	}
	public void setNoteNo(String noteNo) {
		this.noteNo = noteNo;
	}
	public String getToNo() {
		return toNo;
	}
	public void setToNo(String toNo) {
		this.toNo = toNo;
	}
	public String getToNick() {
		return toNick;
	}
	public void setToNick(String toNick) {
		this.toNick = toNick;
	}
	public String getFromNo() {
		return fromNo;
	}
	public void setFromNo(String fromNo) {
		this.fromNo = fromNo;
	}
	public String getFromNick() {
		return fromNick;
	}
	public void setFromNick(String fromNick) {
		this.fromNick = fromNick;
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
	public String getSendDate() {
		return sendDate;
	}
	public void setSendDate(String sendDate) {
		this.sendDate = sendDate;
	}
	public String getCheckDate() {
		return checkDate;
	}
	public void setCheckDate(String checkDate) {
		this.checkDate = checkDate;
	}
	@Override
	public String toString() {
		return "SellerNoteVo [noteNo=" + noteNo + ", toNo=" + toNo + ", toNick=" + toNick + ", fromNo=" + fromNo
				+ ", fromNick=" + fromNick + ", title=" + title + ", content=" + content + ", sendDate=" + sendDate
				+ ", checkDate=" + checkDate + "]";
	}
	
	
	
}
