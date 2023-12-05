package com.kh.app.board.tip.vo;

public class TipLikeVo {
	private String tipNo;
	private String memberNo;
	public TipLikeVo() {
		super();
		// TODO Auto-generated constructor stub
	}
	public TipLikeVo(String tipNo, String memberNo) {
		super();
		this.tipNo = tipNo;
		this.memberNo = memberNo;
	}
	public String getTipNo() {
		return tipNo;
	}
	public void setTipNo(String tipNo) {
		this.tipNo = tipNo;
	}
	public String getMemberNo() {
		return memberNo;
	}
	public void setMemberNo(String memberNo) {
		this.memberNo = memberNo;
	}
	@Override
	public String toString() {
		return "TipLikeVo [tipNo=" + tipNo + ", memberNo=" + memberNo + "]";
	}
	
}
