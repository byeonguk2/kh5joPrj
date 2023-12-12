package com.kh.app.board.contact.vo;

public class QnaMemberVo {
	private String memberQnaNo;
	private String categoryId;
	private String memberNo;
	private String payNo;
	private String title;
	private String content;
	private String enrollDate;
	private String modifyDate;
	private String modifyYn;
	private String replyWriterNo;
	private String replyContent;
	private String replyEnrollDate;
	private String replyModifyDate;
	private String categoryParentId;
	private String categoryName;
	
	private String id;
	private String nick;
	private String orderNo;
	private String totalPrice;

	private String fileNo;
	private String fileName;
	public QnaMemberVo() {
		super();
		// TODO Auto-generated constructor stub
	}
	public QnaMemberVo(String memberQnaNo, String categoryId, String memberNo, String payNo, String title,
			String content, String enrollDate, String modifyDate, String modifyYn, String replyWriterNo,
			String replyContent, String replyEnrollDate, String replyModifyDate, String categoryParentId,
			String categoryName, String id, String nick, String orderNo, String totalPrice, String fileNo,
			String fileName) {
		super();
		this.memberQnaNo = memberQnaNo;
		this.categoryId = categoryId;
		this.memberNo = memberNo;
		this.payNo = payNo;
		this.title = title;
		this.content = content;
		this.enrollDate = enrollDate;
		this.modifyDate = modifyDate;
		this.modifyYn = modifyYn;
		this.replyWriterNo = replyWriterNo;
		this.replyContent = replyContent;
		this.replyEnrollDate = replyEnrollDate;
		this.replyModifyDate = replyModifyDate;
		this.categoryParentId = categoryParentId;
		this.categoryName = categoryName;
		this.id = id;
		this.nick = nick;
		this.orderNo = orderNo;
		this.totalPrice = totalPrice;
		this.fileNo = fileNo;
		this.fileName = fileName;
	}
	public String getMemberQnaNo() {
		return memberQnaNo;
	}
	public void setMemberQnaNo(String memberQnaNo) {
		this.memberQnaNo = memberQnaNo;
	}
	public String getCategoryId() {
		return categoryId;
	}
	public void setCategoryId(String categoryId) {
		this.categoryId = categoryId;
	}
	public String getMemberNo() {
		return memberNo;
	}
	public void setMemberNo(String memberNo) {
		this.memberNo = memberNo;
	}
	public String getPayNo() {
		return payNo;
	}
	public void setPayNo(String payNo) {
		this.payNo = payNo;
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
	public String getModifyYn() {
		return modifyYn;
	}
	public void setModifyYn(String modifyYn) {
		this.modifyYn = modifyYn;
	}
	public String getReplyWriterNo() {
		return replyWriterNo;
	}
	public void setReplyWriterNo(String replyWriterNo) {
		this.replyWriterNo = replyWriterNo;
	}
	public String getReplyContent() {
		return replyContent;
	}
	public void setReplyContent(String replyContent) {
		this.replyContent = replyContent;
	}
	public String getReplyEnrollDate() {
		return replyEnrollDate;
	}
	public void setReplyEnrollDate(String replyEnrollDate) {
		this.replyEnrollDate = replyEnrollDate;
	}
	public String getReplyModifyDate() {
		return replyModifyDate;
	}
	public void setReplyModifyDate(String replyModifyDate) {
		this.replyModifyDate = replyModifyDate;
	}
	public String getCategoryParentId() {
		return categoryParentId;
	}
	public void setCategoryParentId(String categoryParentId) {
		this.categoryParentId = categoryParentId;
	}
	public String getCategoryName() {
		return categoryName;
	}
	public void setCategoryName(String categoryName) {
		this.categoryName = categoryName;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getNick() {
		return nick;
	}
	public void setNick(String nick) {
		this.nick = nick;
	}
	public String getOrderNo() {
		return orderNo;
	}
	public void setOrderNo(String orderNo) {
		this.orderNo = orderNo;
	}
	public String getTotalPrice() {
		return totalPrice;
	}
	public void setTotalPrice(String totalPrice) {
		this.totalPrice = totalPrice;
	}
	public String getFileNo() {
		return fileNo;
	}
	public void setFileNo(String fileNo) {
		this.fileNo = fileNo;
	}
	public String getFileName() {
		return fileName;
	}
	public void setFileName(String fileName) {
		this.fileName = fileName;
	}
	@Override
	public String toString() {
		return "QnaMemberVo [memberQnaNo=" + memberQnaNo + ", categoryId=" + categoryId + ", memberNo=" + memberNo
				+ ", payNo=" + payNo + ", title=" + title + ", content=" + content + ", enrollDate=" + enrollDate
				+ ", modifyDate=" + modifyDate + ", modifyYn=" + modifyYn + ", replyWriterNo=" + replyWriterNo
				+ ", replyContent=" + replyContent + ", replyEnrollDate=" + replyEnrollDate + ", replyModifyDate="
				+ replyModifyDate + ", categoryParentId=" + categoryParentId + ", categoryName=" + categoryName
				+ ", id=" + id + ", nick=" + nick + ", orderNo=" + orderNo + ", totalPrice=" + totalPrice + ", fileNo="
				+ fileNo + ", fileName=" + fileName + "]";
	}
	
	
	
}
