package com.kh.app.admin.vo;

public class MemberDTO {

	// 기본 생성자 
	public MemberDTO() {

	}
	
	// 필드 생성자
	public MemberDTO(String memberNo, String id, String pwd, String nick, String name, String phone, String address,
			String detailAddress, String birthDate, String profile, String quitYn, String joinDate, String modifyDate,
			int point, String email, String freezeYn, String sellerYn, String sellerNo, String businessNo,
			String businessForm, String businessName, String businessPhone, String busineesZipcode,
			String businessAddress, String detailedAddress, String corporationName, String uptae, String upjong,
			String reportNumber, String bank, String permitYn, String depositor, String account, String requestQuitYn,
			String modifyYn) {
		super();
		this.memberNo = memberNo;
		this.id = id;
		this.pwd = pwd;
		this.nick = nick;
		this.name = name;
		this.phone = phone;
		this.address = address;
		this.detailAddress = detailAddress;
		this.birthDate = birthDate;
		this.profile = profile;
		this.quitYn = quitYn;
		this.joinDate = joinDate;
		this.modifyDate = modifyDate;
		this.point = point;
		this.email = email;
		this.freezeYn = freezeYn;
		this.sellerYn = sellerYn;
		this.sellerNo = sellerNo;
		this.businessNo = businessNo;
		this.businessForm = businessForm;
		this.businessName = businessName;
		this.businessPhone = businessPhone;
		this.busineesZipcode = busineesZipcode;
		this.businessAddress = businessAddress;
		this.detailedAddress = detailedAddress;
		this.corporationName = corporationName;
		this.uptae = uptae;
		this.upjong = upjong;
		this.reportNumber = reportNumber;
		this.bank = bank;
		this.permitYn = permitYn;
		this.depositor = depositor;
		this.account = account;
		this.requestQuitYn = requestQuitYn;
		this.modifyYn = modifyYn;
	}
	
	// 일반 회원 생성자
	public MemberDTO(String memberNo, String id, String pwd, String nick, String name, String phone, String address,
			String detailAddress, String birthDate, String profile, String quitYn, String joinDate, String modifyDate,
			int point, String email) {
		super();
		this.memberNo = memberNo;
		this.id = id;
		this.pwd = pwd;
		this.nick = nick;
		this.name = name;
		this.phone = phone;
		this.address = address;
		this.detailAddress = detailAddress;
		this.birthDate = birthDate;
		this.profile = profile;
		this.quitYn = quitYn;
		this.joinDate = joinDate;
		this.modifyDate = modifyDate;
		this.point = point;
		this.email = email;
	}

	// 판매자 생성자
	public MemberDTO(String memberNo, String id, String pwd, String nick, String name, String phone,
			String detailAddress, String profile, String quitYn, String joinDate, String modifyDate,
			String email, String freezeYn, String sellerYn, String sellerNo, String businessNo, String businessForm,
			String businessName, String businessPhone, String busineesZipcode, String businessAddress,
			String corporationName, String uptae, String upjong, String reportNumber, String bank, String permitYn,
			String depositor, String account, String requestQuitYn, String modifyYn) {
		super();
		this.memberNo = memberNo;
		this.id = id;
		this.pwd = pwd;
		this.nick = nick;
		this.name = name;
		this.phone = phone;
		this.detailAddress = detailAddress;
		this.profile = profile;
		this.quitYn = quitYn;
		this.joinDate = joinDate;
		this.modifyDate = modifyDate;
		this.email = email;
		this.freezeYn = freezeYn;
		this.sellerYn = sellerYn;
		this.sellerNo = sellerNo;
		this.businessNo = businessNo;
		this.businessForm = businessForm;
		this.businessName = businessName;
		this.businessPhone = businessPhone;
		this.busineesZipcode = busineesZipcode;
		this.businessAddress = businessAddress;
		this.corporationName = corporationName;
		this.uptae = uptae;
		this.upjong = upjong;
		this.reportNumber = reportNumber;
		this.bank = bank;
		this.permitYn = permitYn;
		this.depositor = depositor;
		this.account = account;
		this.requestQuitYn = requestQuitYn;
		this.modifyYn = modifyYn;
	}


	// 회원 테이블 정보
	private String memberNo;
	private String id;
	private String pwd;
	private String nick;
	private String name;
	private String phone;
	private String address;
	private String detailAddress;
	private String birthDate;
	private String profile;
	private String quitYn;
	private String joinDate;
	private String modifyDate;
	private int point;
	private String email;
	private String freezeYn;
	private String sellerYn;
	
	// 판매자 테이블 정보
	private String sellerNo;
	private String businessNo;
	private String businessForm;
	private String businessName;
	private String businessPhone;
	private String busineesZipcode;
	private String businessAddress;
	private String detailedAddress;
	private String corporationName;
	private String uptae;
	private String upjong;
	private String reportNumber;
	private String bank;
	private String permitYn;
	private String depositor;
	private String account;
	private String requestQuitYn;
	private String modifyYn;
	public String getMemberNo() {
		return memberNo;
	}

	public void setMemberNo(String memberNo) {
		this.memberNo = memberNo;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getPwd() {
		return pwd;
	}

	public void setPwd(String pwd) {
		this.pwd = pwd;
	}

	public String getNick() {
		return nick;
	}

	public void setNick(String nick) {
		this.nick = nick;
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

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getDetailAddress() {
		return detailAddress;
	}

	public void setDetailAddress(String detailAddress) {
		this.detailAddress = detailAddress;
	}

	public String getBirthDate() {
		return birthDate;
	}

	public void setBirthDate(String birthDate) {
		this.birthDate = birthDate;
	}

	public String getProfile() {
		return profile;
	}

	public void setProfile(String profile) {
		this.profile = profile;
	}

	public String getQuitYn() {
		return quitYn;
	}

	public void setQuitYn(String quitYn) {
		this.quitYn = quitYn;
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

	public int getPoint() {
		return point;
	}

	public void setPoint(int point) {
		this.point = point;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getFreezeYn() {
		return freezeYn;
	}

	public void setFreezeYn(String freezeYn) {
		this.freezeYn = freezeYn;
	}

	public String getSellerYn() {
		return sellerYn;
	}

	public void setSellerYn(String sellerYn) {
		this.sellerYn = sellerYn;
	}

	public String getSellerNo() {
		return sellerNo;
	}

	public void setSellerNo(String sellerNo) {
		this.sellerNo = sellerNo;
	}

	public String getBusinessNo() {
		return businessNo;
	}

	public void setBusinessNo(String businessNo) {
		this.businessNo = businessNo;
	}

	public String getBusinessForm() {
		return businessForm;
	}

	public void setBusinessForm(String businessForm) {
		this.businessForm = businessForm;
	}

	public String getBusinessName() {
		return businessName;
	}

	public void setBusinessName(String businessName) {
		this.businessName = businessName;
	}

	public String getBusinessPhone() {
		return businessPhone;
	}

	public void setBusinessPhone(String businessPhone) {
		this.businessPhone = businessPhone;
	}

	public String getBusineesZipcode() {
		return busineesZipcode;
	}

	public void setBusineesZipcode(String busineesZipcode) {
		this.busineesZipcode = busineesZipcode;
	}

	public String getBusinessAddress() {
		return businessAddress;
	}

	public void setBusinessAddress(String businessAddress) {
		this.businessAddress = businessAddress;
	}

	public String getDetailedAddress() {
		return detailedAddress;
	}

	public void setDetailedAddress(String detailedAddress) {
		this.detailedAddress = detailedAddress;
	}

	public String getCorporationName() {
		return corporationName;
	}

	public void setCorporationName(String corporationName) {
		this.corporationName = corporationName;
	}

	public String getUptae() {
		return uptae;
	}

	public void setUptae(String uptae) {
		this.uptae = uptae;
	}

	public String getUpjong() {
		return upjong;
	}

	public void setUpjong(String upjong) {
		this.upjong = upjong;
	}

	public String getReportNumber() {
		return reportNumber;
	}

	public void setReportNumber(String reportNumber) {
		this.reportNumber = reportNumber;
	}

	public String getBank() {
		return bank;
	}

	public void setBank(String bank) {
		this.bank = bank;
	}

	public String getPermitYn() {
		return permitYn;
	}

	public void setPermitYn(String permitYn) {
		this.permitYn = permitYn;
	}

	public String getDepositor() {
		return depositor;
	}

	public void setDepositor(String depositor) {
		this.depositor = depositor;
	}

	public String getAccount() {
		return account;
	}

	public void setAccount(String account) {
		this.account = account;
	}

	public String getRequestQuitYn() {
		return requestQuitYn;
	}

	public void setRequestQuitYn(String requestQuitYn) {
		this.requestQuitYn = requestQuitYn;
	}

	public String getModifyYn() {
		return modifyYn;
	}

	public void setModifyYn(String modifyYn) {
		this.modifyYn = modifyYn;
	}

	@Override
	public String toString() {
		return "MemberDTO [memberNo=" + memberNo + ", id=" + id + ", pwd=" + pwd + ", nick=" + nick + ", name=" + name
				+ ", phone=" + phone + ", address=" + address + ", detailAddress=" + detailAddress + ", birthDate="
				+ birthDate + ", profile=" + profile + ", quitYn=" + quitYn + ", joinDate=" + joinDate + ", modifyDate="
				+ modifyDate + ", point=" + point + ", email=" + email + ", freezeYn=" + freezeYn + ", sellerYn="
				+ sellerYn + ", sellerNo=" + sellerNo + ", businessNo=" + businessNo + ", businessForm=" + businessForm
				+ ", businessName=" + businessName + ", businessPhone=" + businessPhone + ", busineesZipcode="
				+ busineesZipcode + ", businessAddress=" + businessAddress + ", detailedAddress=" + detailedAddress
				+ ", corporationName=" + corporationName + ", uptae=" + uptae + ", upjong=" + upjong + ", reportNumber="
				+ reportNumber + ", bank=" + bank + ", permitYn=" + permitYn + ", depositor=" + depositor + ", account="
				+ account + ", requestQuitYn=" + requestQuitYn + ", modifyYn=" + modifyYn + "]";
	}
	
}
