package com.kh.app.member.vo;

public class MemberVo {
	private String no;
	private String memberId;
	private String memberPwd;
	private String memberPwd2;
	private String memberNick;
	private String name;	
	private String birth;	
	private String phone;
	private String email;
	private String addr;
	private String joinDate;
	private String modifyDate;
	private String point;
	private String profile;
	public MemberVo() {
		super();
		// TODO Auto-generated constructor stub
	}
	public MemberVo(String no, String memberId, String memberPwd, String memberPwd2, String memberNick, String name,
			String birth, String phone, String email, String addr, String joinDate, String modifyDate, String point,
			String profile) {
		super();
		this.no = no;
		this.memberId = memberId;
		this.memberPwd = memberPwd;
		this.memberPwd2 = memberPwd2;
		this.memberNick = memberNick;
		this.name = name;
		this.birth = birth;
		this.phone = phone;
		this.email = email;
		this.addr = addr;
		this.joinDate = joinDate;
		this.modifyDate = modifyDate;
		this.point = point;
		this.profile = profile;
	}
	public String getNo() {
		return no;
	}
	public void setNo(String no) {
		this.no = no;
	}
	public String getMemberId() {
		return memberId;
	}
	public void setMemberId(String memberId) {
		this.memberId = memberId;
	}
	public String getMemberPwd() {
		return memberPwd;
	}
	public void setMemberPwd(String memberPwd) {
		this.memberPwd = memberPwd;
	}
	public String getMemberPwd2() {
		return memberPwd2;
	}
	public void setMemberPwd2(String memberPwd2) {
		this.memberPwd2 = memberPwd2;
	}
	public String getMemberNick() {
		return memberNick;
	}
	public void setMemberNick(String memberNick) {
		this.memberNick = memberNick;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getBirth() {
		return birth;
	}
	public void setBirth(String birth) {
		this.birth = birth;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getAddr() {
		return addr;
	}
	public void setAddr(String addr) {
		this.addr = addr;
	}
	public String getJoinDate() {
		return joinDate;
	}
	public void setJoinDate(String joinDate) {
		this.joinDate = joinDate;
	}
	public String getModifyDate() {
		return modifyDate;
	}
	public void setModifyDate(String modifyDate) {
		this.modifyDate = modifyDate;
	}
	public String getPoint() {
		return point;
	}
	public void setPoint(String point) {
		this.point = point;
	}
	public String getProfile() {
		return profile;
	}
	public void setProfile(String profile) {
		this.profile = profile;
	}
	@Override
	public String toString() {
		return "MemberVo [no=" + no + ", memberId=" + memberId + ", memberPwd=" + memberPwd + ", memberPwd2="
				+ memberPwd2 + ", memberNick=" + memberNick + ", name=" + name + ", birth=" + birth + ", phone=" + phone
				+ ", email=" + email + ", addr=" + addr + ", joinDate=" + joinDate + ", modifyDate=" + modifyDate
				+ ", point=" + point + ", profile=" + profile + "]";
	}
	
	
	
	
	
	
	
	
	
	
}
