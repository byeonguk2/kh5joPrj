package com.kh.app.option.vo;

public class OptionVo {
	private String optionNo;
	private String salesNo;
	private String optionName;
	private String optionPrice;
	public OptionVo() {
		super();
		// TODO Auto-generated constructor stub
	}
	public OptionVo(String optionNo, String salesNo, String optionName, String optionPrice) {
		super();
		this.optionNo = optionNo;
		this.salesNo = salesNo;
		this.optionName = optionName;
		this.optionPrice = optionPrice;
	}
	public String getOptionNo() {
		return optionNo;
	}
	public void setOptionNo(String optionNo) {
		this.optionNo = optionNo;
	}
	public String getSalesNo() {
		return salesNo;
	}
	public void setSalesNo(String salesNo) {
		this.salesNo = salesNo;
	}
	public String getOptionName() {
		return optionName;
	}
	public void setOptionName(String optionName) {
		this.optionName = optionName;
	}
	public String getOptionPrice() {
		return optionPrice;
	}
	public void setOptionPrice(String optionPrice) {
		this.optionPrice = optionPrice;
	}
	@Override
	public String toString() {
		return "OptionVo [optionNo=" + optionNo + ", salesNo=" + salesNo + ", optionName=" + optionName
				+ ", optionPrice=" + optionPrice + "]";
	}
	
	
}
