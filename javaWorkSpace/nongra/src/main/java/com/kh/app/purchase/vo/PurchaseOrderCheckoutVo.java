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
	
	public int getTotalPrice() {
		int totalPrice = 0;
		for(PurchaseCartVo vo : CartVoList) {
			totalPrice = totalPrice + (Integer.parseInt(vo.getGoodsPrice())+Integer.parseInt(vo.getOptionPrice()))*(Integer.parseInt(vo.getGoodsEA()));
		}
		return totalPrice;
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
