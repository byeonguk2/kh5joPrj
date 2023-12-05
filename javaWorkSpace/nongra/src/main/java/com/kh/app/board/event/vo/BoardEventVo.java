package com.kh.app.board.event.vo;

public class BoardEventVo {
	private String eventNo;
	private String writerNo;
	private String title;
	private String content;
	private String enrollDate;
	private String modifyDate;
	private String hit;
	private String delYn;
	private String startDate;
	private String endDate;
	public BoardEventVo() {
		super();
		// TODO Auto-generated constructor stub
	}
	public BoardEventVo(String eventNo, String writerNo, String title, String content, String enrollDate,
			String modifyDate, String hit, String delYn, String startDate, String endDate) {
		super();
		this.eventNo = eventNo;
		this.writerNo = writerNo;
		this.title = title;
		this.content = content;
		this.enrollDate = enrollDate;
		this.modifyDate = modifyDate;
		this.hit = hit;
		this.delYn = delYn;
		this.startDate = startDate;
		this.endDate = endDate;
	}
	public String getEventNo() {
		return eventNo;
	}
	public void setEventNo(String eventNo) {
		this.eventNo = eventNo;
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
	public String getStartDate() {
		return startDate;
	}
	public void setStartDate(String startDate) {
		this.startDate = startDate;
	}
	public String getEndDate() {
		return endDate;
	}
	public void setEndDate(String endDate) {
		this.endDate = endDate;
	}
	@Override
	public String toString() {
		return "BoardEventVo [eventNo=" + eventNo + ", writerNo=" + writerNo + ", title=" + title + ", content="
				+ content + ", enrollDate=" + enrollDate + ", modifyDate=" + modifyDate + ", hit=" + hit + ", delYn="
				+ delYn + ", startDate=" + startDate + ", endDate=" + endDate + "]";
	}
	
	
}
