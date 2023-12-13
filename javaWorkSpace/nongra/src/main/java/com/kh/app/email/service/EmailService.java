package com.kh.app.email.service;

import java.sql.Connection;

import com.kh.app.admin.dao.AdminDao;
import com.kh.app.email.dao.EmailDao;
import com.kh.app.member.vo.MemberVo;
import com.kh.app.util.db.JDBCTemplate;

public class EmailService {

	public boolean EmailCheck(String email) throws Exception {
		
		// connection
		Connection conn = JDBCTemplate.getConnection();
		
		// dao 호출 
		EmailDao dao = new EmailDao();
		boolean result = dao.EmailCheck(email,conn);
			
		// connection close 
		JDBCTemplate.close(conn);
		
		return result;
		
	}

	public String selectId(String email) throws Exception {
		
		// connection
		Connection conn = JDBCTemplate.getConnection();
		
		// dao 호출 
		EmailDao dao = new EmailDao();
		String id = dao.selectId(email,conn);
			
		// connection close 
		JDBCTemplate.close(conn);
		
		return id;
		
	}
	
		public int updatePwd(MemberVo vo) throws Exception {
		
		// connection
		Connection conn = JDBCTemplate.getConnection();
		
		if(!vo.getMemberPwd().equals(vo.getMemberPwd2())) {
			throw new Exception("비밀번호가 일치하지 않습니다.");
		}
		
		// dao 호출 
		EmailDao dao = new EmailDao();
		int result = dao.updatePwd(vo,conn);
			
		if(result==1) {
			JDBCTemplate.commit(conn);
		}else {
			JDBCTemplate.rollback(conn);
		}
		
		// connection close 
		JDBCTemplate.close(conn);
		
		return result;
		
	}

}
