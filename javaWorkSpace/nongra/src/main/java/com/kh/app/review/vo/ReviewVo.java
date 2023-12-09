package com.kh.app.review.vo;

import java.util.List;

public class ReviewVo {
	
private String  reviewNo;
private String  consumerNo;
private String	cartBreakdownNo;
private String	content;
private String	WriteDate;
private String	updateDate;
private String	replyDate;
private String	replyDelYn;
private String	replyContent;
private String	ItemTitle	;		//상품 제목
// BUSINESS_NAME 이거 비지니스 네임
private String	corporationName;   
private String	nick;
private String	likeCnt;
private String src;
private String profile;
private List<String> fileSrc;



public ReviewVo(String reviewNo, String consumerNo, String cartBreakdownNo, String content, String writeDate,
		String updateDate, String replyDate, String replyDelYn, String replyContent, String itemTitle,
		String corporationName, String nick, String likeCnt, String src, String profile, List<String> fileSrc) {
	super();
	this.reviewNo = reviewNo;
	this.consumerNo = consumerNo;
	this.cartBreakdownNo = cartBreakdownNo;
	this.content = content;
	WriteDate = writeDate;
	this.updateDate = updateDate;
	this.replyDate = replyDate;
	this.replyDelYn = replyDelYn;
	this.replyContent = replyContent;
	ItemTitle = itemTitle;
	this.corporationName = corporationName;
	this.nick = nick;
	this.likeCnt = likeCnt;
	this.src = src;
	this.profile = profile;
	this.fileSrc = fileSrc;
}
public String getReviewNo() {
	return reviewNo;
}
public void setReviewNo(String reviewNo) {
	this.reviewNo = reviewNo;
}
public String getConsumerNo() {
	return consumerNo;
}
public void setConsumerNo(String consumerNo) {
	this.consumerNo = consumerNo;
}
public String getCartBreakdownNo() {
	return cartBreakdownNo;
}
public void setCartBreakdownNo(String cartBreakdownNo) {
	this.cartBreakdownNo = cartBreakdownNo;
}
public String getContent() {
	return content;
}
public void setContent(String content) {
	this.content = content;
}
public String getWriteDate() {
	return WriteDate;
}
public void setWriteDate(String writeDate) {
	if(writeDate!=null) {
	WriteDate = writeDate.substring(0,10);
	}
}
public String getUpdateDate() {
	return updateDate;
}
public void setUpdateDate(String updateDate) {
	if(updateDate !=null) {
	this.updateDate =  updateDate.substring(0,10);
	}
}
public String getReplyDate() {
	return replyDate;
}
public void setReplyDate(String replyDate) {
	if(replyDate !=null) {
		this.replyDate = replyDate.substring(0,10);
	}
}
public String getReplyDelYn() {
	return replyDelYn;
}
public void setReplyDelYn(String replyDelYn) {
	this.replyDelYn = replyDelYn;
}
public String getReplyContent() {
	return replyContent;
}
public void setReplyContent(String replyContent) {
	this.replyContent = replyContent;
}
public String getItemTitle() {
	return ItemTitle;
}
public void setItemTitle(String itemTitle) {
	ItemTitle = itemTitle;
}
public String getCorporationName() {
	return corporationName;
}
public void setCorporationName(String corporationName) {
	this.corporationName = corporationName;
}
public String getNick() {
	return nick;
}
public void setNick(String nick) {
	this.nick = nick;
}
public String getLikeCnt() {
	return likeCnt;
}
public void setLikeCnt(String likeCnt) {
	
	if(likeCnt ==null) {
		this.likeCnt = "0";
	}else {
	this.likeCnt = likeCnt;
	}
}
public String getSrc() {
	return src;
}
public void setSrc(String src) {
	this.src = src;
}
public String getProfile() {
	return profile;
}
public void setProfile(String profile) {
	this.profile = profile;
}
public List<String> getFileSrc() {
	return fileSrc;
}
public void setFileSrc(List<String> fileSrc) {
	this.fileSrc = fileSrc;
}
public ReviewVo() {
	super();
	// TODO Auto-generated constructor stub
}
@Override
public String toString() {
	return "ReviewVo [reviewNo=" + reviewNo + ", consumerNo=" + consumerNo + ", cartBreakdownNo=" + cartBreakdownNo
			+ ", content=" + content + ", WriteDate=" + WriteDate + ", updateDate=" + updateDate + ", replyDate="
			+ replyDate + ", replyDelYn=" + replyDelYn + ", replyContent=" + replyContent + ", ItemTitle=" + ItemTitle
			+ ", corporationName=" + corporationName + ", nick=" + nick + ", likeCnt=" + likeCnt + ", src=" + src
			+ ", profile=" + profile + ", fileSrc=" + fileSrc + "]";
}





}

