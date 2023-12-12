package com.kh.app.member.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.kh.app.member.vo.MemberVo;
import com.kh.app.point.vo.PointVo;
import com.kh.app.util.db.JDBCTemplate;

public class MemberDao {

	public MemberVo login(Connection conn, MemberVo vo) throws SQLException {
		// sql
		String sql="SELECT * FROM MEMBER WHERE ID=? AND PWD=? AND QUIT_YN='N'";
		PreparedStatement pstmt=conn.prepareStatement(sql);
		pstmt.setString(1, vo.getMemberId());
		pstmt.setString(2, vo.getMemberPwd());
		ResultSet rs=pstmt.executeQuery();
		//rs
		MemberVo loginMember = null;
		if(rs.next()) {
			
			String no=rs.getString("MEMBER_NO");
			String id=rs.getString("ID");
			String nick=rs.getString("NICK");
			String pwd=rs.getString("PWD");
			String email=rs.getString("EMAIL");
			String name=rs.getString("NAME");
			String phone=rs.getString("PHONE");
			String addr=rs.getString("ADDRESS");
			String addr2=rs.getString("DETAIL_ADDRESS");
			String birth=rs.getString("BIRTH_DATE");
			String joinDate=rs.getString("JOIN_DATE");
			String modifyDate=rs.getString("MODIFY_DATE");
			String point=rs.getString("POINT");
			String profile=rs.getString("PROFILE");
			String sellerYn=rs.getString("SELLER_YN");
			
			
			loginMember= new MemberVo();
			loginMember.setNo(no);
			loginMember.setMemberId(id);
			loginMember.setMemberNick(nick);
			loginMember.setMemberPwd(pwd);
			loginMember.setEmail(email);
			loginMember.setName(name);
			loginMember.setPhone(phone);
			loginMember.setAddr(addr);
			loginMember.setAddr2(addr2);
			loginMember.setBirth(birth);
			loginMember.setJoinDate(joinDate);
			loginMember.setModifyDate(modifyDate);
			loginMember.setPoint(Integer.parseInt(point));
			loginMember.setProfile(profile);
			loginMember.setSellerYn(sellerYn);
		}
		
		//close
		JDBCTemplate.close(rs);
		JDBCTemplate.close(pstmt);
		return loginMember;
	}

	private int Integer(String point) {
		// TODO Auto-generated method stub
		return 0;
	}

	public int join(Connection conn, MemberVo vo) throws Exception {
		System.out.println(vo);
		//sql
		String sql="INSERT INTO MEMBER (MEMBER_NO ,ID ,NICK ,PWD ,EMAIL ,NAME ,PHONE,ADDRESS,DETAIL_ADDRESS,BIRTH_DATE,SELLER_YN)VALUES (SEQ_MEMBER.NEXTVAL,?,?,?,?,?,?,?,?,?,'N')";
		PreparedStatement pstmt=conn.prepareStatement(sql);
		pstmt.setString(1, vo.getMemberId());
		pstmt.setString(2, vo.getMemberNick());
		pstmt.setString(3, vo.getMemberPwd());
		pstmt.setString(4, vo.getEmail());
		pstmt.setString(5, vo.getName());
		pstmt.setString(6, vo.getPhone());
		pstmt.setString(7, vo.getAddr());
		pstmt.setString(8, vo.getAddr2());
		pstmt.setString(9, vo.getBirth());
		int result=pstmt.executeUpdate();
		//rs
		
		//close
		JDBCTemplate.close(pstmt);
		return result;
		
	}
	
	//회원탈퇴
	public int delete(Connection conn, String no) throws Exception {
		//sql
		String sql="UPDATE MEMBER SET QUIT_YN='Y', MODIFY_DATE= SYSDATE WHERE MEMBER_NO=?";
		PreparedStatement pstmt=conn.prepareStatement(sql);
		pstmt.setString(1, no);
		int result=pstmt.executeUpdate();
				
		//rs
		
		//close
		JDBCTemplate.close(pstmt);
		return result;
	}
	
	//회원정보 수정
	public int modify(Connection conn, MemberVo vo) throws Exception {
		System.out.println(vo);
		// sql
		String sql="UPDATE MEMBER SET NICK=?, PWD=?, ADDRESS=?, DETAIL_ADDRESS=?, PHONE=?,EMAIL=?, MODIFY_DATE = SYSDATE WHERE MEMBER_NO=?";
		PreparedStatement pstmt=conn.prepareStatement(sql);
		pstmt.setString(1, vo.getMemberNick());
		pstmt.setString(2, vo.getMemberPwd());
		pstmt.setString(3, vo.getAddr());
		pstmt.setString(4, vo.getAddr2());
		pstmt.setString(5, vo.getPhone());
		pstmt.setString(6, vo.getEmail());
		pstmt.setString(7, vo.getNo());
		int result=pstmt.executeUpdate();
		
		//rs
		
		
		//close
		JDBCTemplate.close(pstmt);
		return result;
	}
	
	//포인트
	public PointVo checkPoint(Connection conn, MemberVo loginMember) throws Exception {
		//sql
		String sql="SELECT (SELECT TOTAL_PRICE FROM ( SELECT TOTAL_PRICE, ROW_NUMBER() OVER (ORDER BY O.ENROLL_DATE DESC) AS RN FROM MEMBER M JOIN CART C ON (M.MEMBER_NO = C.MEMBER_NO) JOIN ORDER_HISTORY O ON (C.NO = O.CART_NO) WHERE M.MEMBER_NO = ? ) WHERE RN = 1) AS USE_POINT, (SELECT RELOAD_LIST FROM PAY WHERE MEMBER_NO = ? ORDER BY RELOAD_DATE DESC FETCH FIRST 1 ROW ONLY) AS CHARGE_POINT FROM DUAL";
		PreparedStatement pstmt=conn.prepareStatement(sql);
		pstmt.setString(1, loginMember.getNo());
		pstmt.setString(2, loginMember.getNo());
		ResultSet rs=pstmt.executeQuery();
		
		//rs
		PointVo memberPoint=null;
		if(rs.next()) {
			int chargePoint=rs.getInt("CHARGE_POINT");
			int usePoint=rs.getInt("USE_POINT");
			
			memberPoint = new PointVo();
			memberPoint.setChargePoint(chargePoint);
			memberPoint.setUsePoint(usePoint);
			
		}
		//close
		JDBCTemplate.close(rs);
		JDBCTemplate.close(pstmt);
		return memberPoint;
	}
	
	//포인트 충전
	public int charge(Connection conn, MemberVo loginMember, String chargePoint) throws Exception {
		//sql
		String sql="INSERT INTO PAY (PAY_NO, MEMBER_NO, RELOAD_LIST) VALUES(SEQ_PAY_NO.NEXTVAL,?,?)";
		PreparedStatement pstmt=conn.prepareStatement(sql);
		pstmt.setString(1, loginMember.getNo());
		pstmt.setString(2, chargePoint);
		int result=pstmt.executeUpdate();
		
		//close
		JDBCTemplate.close(pstmt);
		return result;
	}

	public int update(Connection conn, MemberVo loginMember,String chargePoint) throws Exception {
		//sql
		
		String sql="UPDATE MEMBER SET POINT=? WHERE MEMBER_NO=? ";
		PreparedStatement pstmt=conn.prepareStatement(sql);
		pstmt.setInt(1, loginMember.getPoint()+Integer.parseInt(chargePoint));
		pstmt.setString(2, loginMember.getNo());
		int result=pstmt.executeUpdate();
		
		//close
		JDBCTemplate.close(pstmt);
		return result;
		
	}
	
	

}
