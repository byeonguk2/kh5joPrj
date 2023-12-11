package com.kh.app.email.service;

import java.sql.Connection;

import com.kh.app.admin.dao.AdminDao;
import com.kh.app.email.dao.EmailDao;
import com.kh.app.util.db.JDBCTemplate;

public class EmailService {

	public String[] EmailCheck(String email) throws Exception {
		
		// connection
		Connection conn = JDBCTemplate.getConnection();
		
		// dao 호출 
		EmailDao dao = new EmailDao();
		String[] result = dao.EmailCheck(email,conn);
			
		// connection close 
		JDBCTemplate.close(conn);
		
		return result;
		
	}

}
