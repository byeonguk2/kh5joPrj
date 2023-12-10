package com.kh.app.board.event.vo;

public class EventReplyVo {
	private String replyNo;
	private String eventNo;
	private String writerNo;
	private String content;
	private String enrollDate;
	private String modifyDate;
	private String delYn;
	public EventReplyVo() {
		super();
		// TODO Auto-generated constructor stub
	}
	public EventReplyVo(String replyNo, String eventNo, String writerNo, String content, String enrollDate,
			String modifyDate, String delYn) {
		super();
		this.replyNo = replyNo;
		this.eventNo = eventNo;
		this.writerNo = writerNo;
		this.content = content;
		this.enrollDate = enrollDate;
		this.modifyDate = modifyDate;
		this.delYn = delYn;
	}
	public String getReplyNo() {
		return replyNo;
	}
	public void setReplyNo(String replyNo) {
		this.replyNo = replyNo;
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
	public String getDelYn() {
		return delYn;
	}
	public void setDelYn(String delYn) {
		this.delYn = delYn;
	}
	@Override
	public String toString() {
		return "BoardEventReplyVo [replyNo=" + replyNo + ", eventNo=" + eventNo + ", writerNo=" + writerNo
				+ ", content=" + content + ", enrollDate=" + enrollDate + ", modifyDate=" + modifyDate + ", delYn="
				+ delYn + "]";
	}
	
	
}
