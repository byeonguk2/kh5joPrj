package com.kh.app.point.vo;

public class PointVo {
	private String payNo;
	private String memberNO;
	private int chargePoint;
	private int usePoint;
	private int myPoint;
	private String reloadDate;
	public PointVo() {
		super();
		// TODO Auto-generated constructor stub
	}
	public PointVo(String payNo, String memberNO, int chargePoint, int usePoint, int myPoint, String reloadDate) {
		super();
		this.payNo = payNo;
		this.memberNO = memberNO;
		this.chargePoint = chargePoint;
		this.usePoint = usePoint;
		this.myPoint = myPoint;
		this.reloadDate = reloadDate;
	}
	public String getPayNo() {
		return payNo;
	}
	public void setPayNo(String payNo) {
		this.payNo = payNo;
	}
	public String getMemberNO() {
		return memberNO;
	}
	public void setMemberNO(String memberNO) {
		this.memberNO = memberNO;
	}
	public int getChargePoint() {
		return chargePoint;
	}
	public void setChargePoint(int chargePoint) {
		this.chargePoint = chargePoint;
	}
	public int getUsePoint() {
		return usePoint;
	}
	public void setUsePoint(int usePoint) {
		this.usePoint = usePoint;
	}
	public int getMyPoint() {
		this.myPoint=this.chargePoint-this.usePoint;
		return myPoint;
	}
	
	public void setMyPoint(int myPoint) {
		this.myPoint = myPoint;
	}
	public String getReloadDate() {
		return reloadDate;
	}
	public void setReloadDate(String reloadDate) {
		this.reloadDate = reloadDate;
	}
	@Override
	public String toString() {
		return "PointVo [payNo=" + payNo + ", memberNO=" + memberNO + ", chargePoint=" + chargePoint + ", usePoint="
				+ usePoint + ", myPoint=" + myPoint + ", reloadDate=" + reloadDate + "]";
	}
	
	
	
	
}
