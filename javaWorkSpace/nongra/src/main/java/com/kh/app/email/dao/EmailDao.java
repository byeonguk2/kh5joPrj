package com.kh.app.email.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Map;

import com.kh.app.util.db.JDBCTemplate;

public class EmailDao {

	public boolean EmailCheck(String email, Connection conn) throws Exception {
		
		String sql = "SELECT EMAIL,ID FROM MEMBER WHERE EMAIL = ? AND QUIT_YN = 'N'";
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

	
	
}
