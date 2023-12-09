package com.kh.app.member.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.kh.app.member.vo.MemberVo;
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
			loginMember.setPoint(point);
			loginMember.setProfile(profile);
			loginMember.setSellerYn(sellerYn);
		}
		
		//close
		JDBCTemplate.close(rs);
		JDBCTemplate.close(pstmt);
		return loginMember;
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

}
