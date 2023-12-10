package com.kh.app.review.vo;

/**
 * 
 */
public class ReviewFileVo {

	
	private String reviewFileNo;
	
	private String reviewFielSrc;

	public ReviewFileVo(String reviewFileNo, String reviewFielSrc) {
		super();
		this.reviewFileNo = reviewFileNo;
		this.reviewFielSrc = reviewFielSrc;
	}

	

	@Override
	public String toString() {
		return "ReviewFileVo [reviewFileNo=" + reviewFileNo + ", reviewFielSrc=" + reviewFielSrc + "]";
	}



	public String getReviewFileNo() {
		return reviewFileNo;
	}

	public void setReviewFileNo(String reviewFileNo) {
		this.reviewFileNo = reviewFileNo;
	}

	public String getReviewFielSrc() {
		return reviewFielSrc;
	}

	public void setReviewFielSrc(String reviewFielSrc) {
		this.reviewFielSrc = reviewFielSrc;
	}

	public ReviewFileVo() {
		super();
		
	}
	
	
	
}
