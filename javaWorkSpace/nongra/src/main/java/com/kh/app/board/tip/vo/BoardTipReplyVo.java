package com.kh.app.board.tip.vo;

public class BoardTipReplyVo {
	private String replyNo;
	private String tipNo;
	private String writerNo;
	private String content;
	private String enrollDate;
	private String modifyDate;
	private String delYn;
	public BoardTipReplyVo() {
		super();
		// TODO Auto-generated constructor stub
	}
	public BoardTipReplyVo(String replyNo, String tipNo, String writerNo, String content, String enrollDate,
			String modifyDate, String delYn) {
		super();
		this.replyNo = replyNo;
		this.tipNo = tipNo;
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
		return "BoardTipReplyVo [replyNo=" + replyNo + ", tipNo=" + tipNo + ", writerNo=" + writerNo + ", content="
				+ content + ", enrollDate=" + enrollDate + ", modifyDate=" + modifyDate + ", delYn=" + delYn + "]";
	}
	
	
}
