package com.kh.app.home.vo;

import java.util.ArrayList;
import java.util.List;

public class SalesVo_v2 {
	
	private String salesNo; // 상품번호
	private String title; // 제목
	private String thumbNail; // 썸네일
	private String price; // 가격
	private String quantity;
	
	// rs에서 꺼낸 데이터를 임시로 담기 위해서만 사용
	private String optionNo; // 옵션번호 
	private String refNo;
	private String optionPrice; // 옵션 가격
	private String optionName; // 옵션이름
	
	private List<OptionVo_v2> OptionVo = new ArrayList<OptionVo_v2>();
	
	private OptionVo_v2 opVo = new OptionVo_v2();

	public SalesVo_v2() {

	}

	public SalesVo_v2(String salesNo, String title, String thumbNail, String price, String optionNo, String refNo,
			String optionPrice, String optionName, List<OptionVo_v2> optionVo, OptionVo_v2 opVo) {
		this.salesNo = salesNo;
		this.title = title;
		this.thumbNail = thumbNail;
		this.price = price;
		this.optionNo = optionNo;
		this.refNo = refNo;
		this.optionPrice = optionPrice;
		this.optionName = optionName;
		OptionVo = optionVo;
		this.opVo = opVo;
	}

	public SalesVo_v2(String salesNo, String title, String thumbNail, String price, String optionNo, String refNo,
			String optionPrice, String optionName) {
		super();
		this.salesNo = salesNo;
		this.title = title;
		this.thumbNail = thumbNail;
		this.price = price;
		this.optionNo = optionNo;
		this.refNo = refNo;
		this.optionPrice = optionPrice;
		this.optionName = optionName;
	}

	public SalesVo_v2(String salesNo, String title, String thumbNail, String price, String quantity, String optionNo,
			String refNo, String optionPrice, String optionName, List<OptionVo_v2> optionVo, OptionVo_v2 opVo) {
		super();
		this.salesNo = salesNo;
		this.title = title;
		this.thumbNail = thumbNail;
		this.price = price;
		this.quantity = quantity;
		this.optionNo = optionNo;
		this.refNo = refNo;
		this.optionPrice = optionPrice;
		this.optionName = optionName;
		OptionVo = optionVo;
		this.opVo = opVo;
	}

	public String getQuantity() {
		return quantity;
	}

	public void setQuantity(String quantity) {
		this.quantity = quantity;
	}

	public String getSalesNo() {
		return salesNo;
	}

	public void setSalesNo(String salesNo) {
		this.salesNo = salesNo;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getThumbNail() {
		return thumbNail;
	}

	public void setThumbNail(String thumbNail) {
		this.thumbNail = thumbNail;
	}

	public String getPrice() {
		return price;
	}

	public void setPrice(String price) {
		this.price = price;
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

	public List<OptionVo_v2> getOptionVo() {
		return OptionVo;
	}

	public void setOptionVo(List<OptionVo_v2> optionVo) {
		OptionVo = optionVo;
	}

	public OptionVo_v2 getOpVo() {
		return opVo;
	}

	public void setOpVo(OptionVo_v2 opVo) {
		this.opVo = opVo;
	}

	@Override
	public String toString() {
		return "SalesVo_v2 [salesNo=" + salesNo + ", title=" + title + ", thumbNail=" + thumbNail + ", price=" + price
				+ ", quantity=" + quantity + ", optionNo=" + optionNo + ", refNo=" + refNo + ", optionPrice="
				+ optionPrice + ", optionName=" + optionName + ", OptionVo=" + OptionVo + ", opVo=" + opVo + "]";
	}

	
	
}