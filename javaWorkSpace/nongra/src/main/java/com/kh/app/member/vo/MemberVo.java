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
	private String addr2;
	private String joinDate;
	private String modifyDate;
	private String point;
	private String profile;
	private String sellerYn;
	public MemberVo() {
		super();
		// TODO Auto-generated constructor stub
	}
	public MemberVo(String no, String memberId, String memberPwd, String memberPwd2, String memberNick, String name,
			String birth, String phone, String email, String addr, String addr2, String joinDate, String modifyDate,
			String point, String profile, String sellerYn) {
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
		this.addr2 = addr2;
		this.joinDate = joinDate;
		this.modifyDate = modifyDate;
		this.point = point;
		this.profile = profile;
		this.sellerYn = sellerYn;
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
	public String getAddr2() {
		return addr2;
	}
	public void setAddr2(String addr2) {
		this.addr2 = addr2;
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
	public String getSellerYn() {
		return sellerYn;
	}
	public void setSellerYn(String sellerYn) {
		this.sellerYn = sellerYn;
	}
	@Override
	public String toString() {
		return "MemberVo [no=" + no + ", memberId=" + memberId + ", memberPwd=" + memberPwd + ", memberPwd2="
				+ memberPwd2 + ", memberNick=" + memberNick + ", name=" + name + ", birth=" + birth + ", phone=" + phone
				+ ", email=" + email + ", addr=" + addr + ", addr2=" + addr2 + ", joinDate=" + joinDate
				+ ", modifyDate=" + modifyDate + ", point=" + point + ", profile=" + profile + ", sellerYn=" + sellerYn
				+ "]";
	}
	
}
	
	
	