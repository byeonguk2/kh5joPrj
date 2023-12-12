package com.kh.app.email.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Map;

import com.kh.app.member.vo.MemberVo;
import com.kh.app.util.db.JDBCTemplate;

public class EmailDao {

	public boolean EmailCheck(String email, Connection conn) throws Exception {
		
		String sql = "SELECT EMAIL FROM MEMBER WHERE EMAIL = ? AND QUIT_YN = 'N'";
		PreparedStatement pstmt = conn.prepareStatement(sql);
		pstmt.setString(1, email);
		
		ResultSet rs = pstmt.executeQuery();
		
		boolean result = false;
		if(rs.next()) {
			result = true;
		}
		
		System.out.println(result);
		
		JDBCTemplate.close(pstmt);
		JDBCTemplate.close(rs);
		
		return result;
		
	}

	public String selectId(String email, Connection conn) throws Exception {
		
		String sql = "SELECT ID FROM MEMBER WHERE EMAIL = ? AND QUIT_YN = 'N'";
		PreparedStatement pstmt = conn.prepareStatement(sql);
		pstmt.setString(1, email);
		
		ResultSet rs = pstmt.executeQuery();

		String id = null;
		if(rs.next()) {
			id = rs.getString("ID");
		}
		
		System.out.println(id);
		
		JDBCTemplate.close(pstmt);
		JDBCTemplate.close(rs);
		
		return id;
		
		
	}

	public int updatePwd(MemberVo vo, Connection conn) throws Exception {
	
	String sql = "UPDATE MEMBER SET PWD = ? WHERE ID = ? AND EMAIL = ? AND QUIT_YN = 'N'";
	
	PreparedStatement pstmt = conn.prepareStatement(sql);
	
	pstmt.setString(1, vo.getMemberPwd());
	pstmt.setString(2, vo.getMemberId());
	pstmt.setString(3, vo.getEmail());
	
	int result = pstmt.executeUpdate();
	
	JDBCTemplate.close(pstmt);
	
	return result;
		
		
	}
	
}
