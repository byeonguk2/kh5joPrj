package com.kh.app.purchase.vo;

import java.util.List;

public class PurchaseOrderCheckoutVo {
	private List<PurchaseCartVo> CartVoList;
	private PurchaseAddressVo addressVo;

	public List<PurchaseCartVo> getCartVoList() {
		return CartVoList;
	}
	public void setCartVoList(List<PurchaseCartVo> cartVoList) {
		CartVoList = cartVoList;
	}
	public PurchaseAddressVo getAddressVo() {
		return addressVo;
	}
	public void setAddressVo(PurchaseAddressVo addressVo) {
		this.addressVo = addressVo;
	}

	@Override
	public String toString() {
		return "PurchaseOrderCheckoutVo [CartVoList=" + CartVoList + ", addressVo=" + addressVo + "]";
	}

	public PurchaseOrderCheckoutVo() {
		super();
		// TODO Auto-generated constructor stub
	}
	public PurchaseOrderCheckoutVo(List<PurchaseCartVo> cartVoList, PurchaseAddressVo addressVo) {
		super();
		CartVoList = cartVoList;
		this.addressVo = addressVo;
	}

	
	
	
	
}
