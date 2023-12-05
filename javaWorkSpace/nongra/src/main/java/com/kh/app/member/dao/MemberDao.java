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
		System.out.println("next확인");
		System.out.println("next확인2");
		//rs
		MemberVo loginMember = null;
		if(rs.next()) {
			System.out.println("next확인");
			
			String no=rs.getString("MEMBER_NO");
			String id=rs.getString("ID");
			String nick=rs.getString("NICK");
			String pwd=rs.getString("PWD");
			String email=rs.getString("EMAIL");
			String name=rs.getString("NAME");
			String phone=rs.getString("PHONE");
			String addr=rs.getString("ADDRESS");
			String birth=rs.getString("BIRTH_DATE");
			String joinDate=rs.getString("JOIN_DATE");
			String modifyDate=rs.getString("MODIFY_DATE");
			String point=rs.getString("POINT");
			String profile=rs.getString("PROFILE");
			
			
			loginMember= new MemberVo();
			loginMember.setNo(no);
			loginMember.setMemberId(id);
			loginMember.setMemberNick(nick);
			loginMember.setMemberPwd(pwd);
			loginMember.setEmail(email);
			loginMember.setName(name);
			loginMember.setPhone(phone);
			loginMember.setAddr(addr);
			loginMember.setBirth(birth);
			loginMember.setJoinDate(joinDate);
			loginMember.setModifyDate(modifyDate);
			loginMember.setPoint(point);
			loginMember.setProfile(profile);
		}
		
		//close
		JDBCTemplate.close(rs);
		JDBCTemplate.close(pstmt);
		return loginMember;
	}

}
