package com.kh.app.home.vo;

public class OptionVo_v2 {

	private String optionNo; // 옵션번호 
	private String refNo; // 참조번호 
	private String optionPrice; // 옵션 가격
	private String optionName; // 옵션이름
	
	public OptionVo_v2() {

	}

	public OptionVo_v2(String optionNo, String refNo, String optionPrice, String optionName) {
		this.optionNo = optionNo;
		this.refNo = refNo;
		this.optionPrice = optionPrice;
		this.optionName = optionName;
	}

	public String getOptionNo() {
		return optionNo;
	}

	public void setOptionNo(String optionNo) {
		this.optionNo = optionNo;
	}

	public String getRefNo() {
		return refNo;
	}

	public void setRefNo(String refNo) {
		this.refNo = refNo;
	}

	public String getOptionPrice() {
		return optionPrice;
	}

	public void setOptionPrice(String optionPrice) {
		this.optionPrice = optionPrice;
	}

	public String getOptionName() {
		return optionName;
	}

	public void setOptionName(String optionName) {
		this.optionName = optionName;
	}

	@Override
	public String toString() {
		return "OptionVo_v2 [optionNo=" + optionNo + ", refNo=" + refNo + ", optionPrice=" + optionPrice
				+ ", optionName=" + optionName + "]";
	}
	
}
