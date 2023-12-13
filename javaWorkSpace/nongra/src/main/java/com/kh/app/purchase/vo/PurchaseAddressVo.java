package com.kh.app.purchase.vo;

public class PurchaseAddressVo {
	private String no;
	private String address;
	private String name;
	private String phone;
	private String delYn;
	private String defaultAddress;

	public String getNo() {
		return no;
	}
	public void setNo(String no) {
		this.no = no;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public String getDelYn() {
		return delYn;
	}
	public void setDelYn(String delYn) {
		this.delYn = delYn;
	}
	public String getDefaultAddress() {
		return defaultAddress;
	}
	public void setDefaultAddress(String defaultAddress) {
		this.defaultAddress = defaultAddress;
	}

	@Override
	public String toString() {
		return "PurchaseAddressVo [no=" + no + ", address=" + address + ", name=" + name + ", phone=" + phone
				+ ", delYn=" + delYn + ", defaultAddress=" + defaultAddress + "]";
	}

	public PurchaseAddressVo() {
		super();
		// TODO Auto-generated constructor stub
	}
	public PurchaseAddressVo(String no, String address, String name, String phone, String delYn,
			String defaultAddress) {
		super();
		this.no = no;
		this.address = address;
		this.name = name;
		this.phone = phone;
		this.delYn = delYn;
		this.defaultAddress = defaultAddress;
	}
	public PurchaseAddressVo(String address, String name, String phone, String defaultAddress) {
		super();
		if(defaultAddress == null || defaultAddress.equals("Y")) {
			defaultAddress = "N";
		}else {
			defaultAddress = "Y";
		}
		this.address = address;
		this.name = name;
		this.phone = phone;
		this.defaultAddress = defaultAddress;
	}

	
	
}
