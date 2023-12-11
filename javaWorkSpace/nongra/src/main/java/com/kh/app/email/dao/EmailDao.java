package com.kh.app.email.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Map;

import com.kh.app.util.db.JDBCTemplate;

public class EmailDao {

	public String[] EmailCheck(String email, Connection conn) throws Exception {
		
		String sql = "SELECT EMAIL,ID FROM MEMBER WHERE EMAIL = ?";
		PreparedStatement pstmt = conn.prepareStatement(sql);
		pstmt.setString(1, email);
		
		ResultSet rs = pstmt.executeQuery();
		
		String[] result = null;
		if(rs.next()) {
			result = new String[2];
			result[0] = rs.getString("ID");
			result[1] = rs.getString("EMAIL");
		}
		
		JDBCTemplate.close(pstmt);
		JDBCTemplate.close(rs);
		
		return result;
		
	}

	
	
}
