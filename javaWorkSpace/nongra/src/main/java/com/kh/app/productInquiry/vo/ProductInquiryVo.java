package com.kh.app.productInquiry.vo;

import java.util.ArrayList;
import java.util.List;

public class ProductInquiryVo {

	private String inquireNo; // 문의번호
	private String consumerNo; // 소비자 번호
	private String salesNo;  //판매 번호   
	private String content; // 문의 내용
	private String enrollDate; // 작성일
	private String  delYn; // 삭제여부
	private String  inquireReply; // 문의 답변
	private String  secretYn; // 비밀글여부
	private String   sellerNo; // 판매자번호
	private String   itemtitle; //판매글 제목
	private String   businessName; //가게명
	private String   userName;  // 유저네임
	
	private String replyEnrollDate; // 답글 작성시간
	private String replyUpdateDate; // 답글 업데이트 날짜
	private String replyDelYn;		// 답글 삭제 여부 		
	 
	private ProductInquriyFileVo productInquriyFileVo = new ProductInquriyFileVo();
	private List<ProductInquriyFileVo> list = new ArrayList<ProductInquriyFileVo>();
	
	
	
	
	
	public ProductInquiryVo(String inquireNo, String consumerNo, String salesNo, String content, String enrollDate,
			String delYn, String inquireReply, String secretYn, String sellerNo, String itemtitle, String businessName,
			String userName, String replyEnrollDate, String replyUpdateDate, String replyDelYn,
			ProductInquriyFileVo productInquriyFileVo, List<ProductInquriyFileVo> list) {
		super();
		this.inquireNo = inquireNo;
		this.consumerNo = consumerNo;
		this.salesNo = salesNo;
		this.content = content;
		this.enrollDate = enrollDate;
		this.delYn = delYn;
		this.inquireReply = inquireReply;
		this.secretYn = secretYn;
		this.sellerNo = sellerNo;
		this.itemtitle = itemtitle;
		this.businessName = businessName;
		this.userName = userName;
		this.replyEnrollDate = replyEnrollDate;
		this.replyUpdateDate = replyUpdateDate;
		this.replyDelYn = replyDelYn;
		this.productInquriyFileVo = productInquriyFileVo;
		this.list = list;
	}
	
	public ProductInquiryVo() {
		super();
		// TODO Auto-generated constructor stub
	}
	public String getInquireNo() {
		return inquireNo;
	}
	public void setInquireNo(String inquireNo) {
		this.inquireNo = inquireNo;
	}
	public String getConsumerNo() {
		return consumerNo;
	}
	public void setConsumerNo(String consumerNo) {
		this.consumerNo = consumerNo;
	}
	public String getSalesNo() {
		return salesNo;
	}
	public void setSalesNo(String salesNo) {
		this.salesNo = salesNo;
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
		if(enrollDate!=null) {
		this.enrollDate = enrollDate.substring(0,10);
		}else {
		this.enrollDate = enrollDate;
		}
	}
	public String getDelYn() {
		return delYn;
	}
	public void setDelYn(String delYn) {
		this.delYn = delYn;
	}
	public String getInquireReply() {
		return inquireReply;
	}
	public void setInquireReply(String inquireReply) {
		this.inquireReply = inquireReply;
	}
	public String getSecretYn() {
		return secretYn;
	}
	public void setSecretYn(String secretYn) {
		if(secretYn == null) {
			this.secretYn ="N";
		}else {
			this.secretYn =secretYn;
		}
	}
	public String getSellerNo() {
		return sellerNo;
	}
	public void setSellerNo(String sellerNo) {
		this.sellerNo = sellerNo;
	}
	public String getItemtitle() {
		return itemtitle;
	}
	public void setItemtitle(String itemtitle) {
		this.itemtitle = itemtitle;
	}
	public String getBusinessName() {
		return businessName;
	}
	public void setBusinessName(String businessName) {
		this.businessName = businessName;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		 if (userName.length() == 3) {
		        this.userName = userName.substring(0,1) + "*" + userName.substring(2);  // 세 글자일 때
		    } else if (userName.length() == 2) {
		        this.userName =  userName.substring(0,1) + "*";  // 두 글자일 때
		    } else if (userName.length() >= 4) {
		        this.userName = userName.substring(0,1) + "***";  // 네 글자 이상일 때
		    } else {
		        this.userName = userName;  // 그 외의 경우에는 그대로 설정
		    }
	}
	public ProductInquriyFileVo getProductInquriyFileVo() {
		return productInquriyFileVo;
	}
	public void setProductInquriyFileVo(ProductInquriyFileVo productInquriyFileVo) {
		this.productInquriyFileVo = productInquriyFileVo;
	}
	public List<ProductInquriyFileVo> getList() {
		return list;
	}
	public void setList(List<ProductInquriyFileVo> list) {
		this.list = list;
	}
	public String getReplyEnrollDate() {
		return replyEnrollDate;
	}
	public void setReplyEnrollDate(String replyEnrollDate) {
		this.replyEnrollDate = replyEnrollDate;
	}
	public String getReplyUpdateDate() {
		return replyUpdateDate;
	}
	public void setReplyUpdateDate(String replyUpdateDate) {
		this.replyUpdateDate = replyUpdateDate;
	}
	public String getReplyDelYn() {
		return replyDelYn;
	}
	public void setReplyDelYn(String replyDelYn) {
		this.replyDelYn = replyDelYn;
	}
	@Override
	public String toString() {
		return "ProductInquiryVo [inquireNo=" + inquireNo + ", consumerNo=" + consumerNo + ", salesNo=" + salesNo
				+ ", content=" + content + ", enrollDate=" + enrollDate + ", delYn=" + delYn + ", inquireReply="
				+ inquireReply + ", secretYn=" + secretYn + ", sellerNo=" + sellerNo + ", itemtitle=" + itemtitle
				+ ", businessName=" + businessName + ", userName=" + userName + ", replyEnrollDate=" + replyEnrollDate
				+ ", replyUpdateDate=" + replyUpdateDate + ", replyDelYn=" + replyDelYn + ", productInquriyFileVo="
				+ productInquriyFileVo + ", list=" + list + "]";
	}
	
	
	
	
	
	
	
	
	
	
}
