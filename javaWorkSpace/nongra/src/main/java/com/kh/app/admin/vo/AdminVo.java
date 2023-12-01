package com.kh.app.admin.vo;

public class AdminVo {
	
	public AdminVo(String managerNo, String adminId, String adminPwd, String adminNick) {
		ManagerNo = managerNo;
		this.adminId = adminId;
		this.adminPwd = adminPwd;
		this.adminNick = adminNick;
	}
	public AdminVo() {

	}
	private String ManagerNo;
	private String adminId;
	private String adminPwd;
	private String adminNick;
	public String getManagerNo() {
		return ManagerNo;
	}
	public void setManagerNo(String managerNo) {
		ManagerNo = managerNo;
	}
	public String getAdminId() {
		return adminId;
	}
	public void setAdminId(String adminId) {
		this.adminId = adminId;
	}
	public String getAdminPwd() {
		return adminPwd;
	}
	public void setAdminPwd(String adminPwd) {
		this.adminPwd = adminPwd;
	}
	public String getAdminNick() {
		return adminNick;
	}
	public void setAdminNick(String adminNick) {
		this.adminNick = adminNick;
	}
	@Override
	public String toString() {
		return "AdminVo [ManagerNo=" + ManagerNo + ", adminId=" + adminId + ", adminPwd=" + adminPwd + ", adminNick="
				+ adminNick + "]";
	}
	
}
