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
		String sql="";
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
			String birth=rs.getString("BIRTH_DATE");
			
			loginMember= new MemberVo();
			loginMember.setNo(no);
			loginMember.setMemberId(id);
			loginMember.setMemberNick(nick);
			loginMember.setMemberPwd(pwd);
			loginMember.setEmail(email);
			loginMember.setName(name);
			loginMember.setPhone(phone);
			loginMember.setAddr(addr);
			
		}
		
		//close
		JDBCTemplate.close(rs);
		JDBCTemplate.close(pstmt);
	}

}
