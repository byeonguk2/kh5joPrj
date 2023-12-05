package com.kh.app.board.tip.vo;

public class BoardTipVo {
	private String tipNo;
	private String writerNo;
	private String title;
	private String content;
	private String enrollDate;
	private String modifyDate;
	private String hit;
	private String delYn;
	public BoardTipVo() {
		super();
		// TODO Auto-generated constructor stub
	}
	public BoardTipVo(String tipNo, String writerNo, String title, String content, String enrollDate, String modifyDate,
			String hit, String delYn) {
		super();
		this.tipNo = tipNo;
		this.writerNo = writerNo;
		this.title = title;
		this.content = content;
		this.enrollDate = enrollDate;
		this.modifyDate = modifyDate;
		this.hit = hit;
		this.delYn = delYn;
	}
	public String getTipNo() {
		return tipNo;
	}
	public void setTipNo(String tipNo) {
		this.tipNo = tipNo;
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
	public String getHit() {
		return hit;
	}
	public void setHit(String hit) {
		this.hit = hit;
	}
	public String getDelYn() {
		return delYn;
	}
	public void setDelYn(String delYn) {
		this.delYn = delYn;
	}
	@Override
	public String toString() {
		return "BoardTipVo [tipNo=" + tipNo + ", writerNo=" + writerNo + ", title=" + title + ", content=" + content
				+ ", enrollDate=" + enrollDate + ", modifyDate=" + modifyDate + ", hit=" + hit + ", delYn=" + delYn
				+ "]";
	}
	
	
}
