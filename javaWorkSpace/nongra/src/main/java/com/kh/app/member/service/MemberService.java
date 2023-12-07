package com.kh.app.member.service;

import java.sql.Connection;

import com.kh.app.member.dao.MemberDao;
import com.kh.app.member.vo.MemberVo;
import com.kh.app.util.db.JDBCTemplate;

public class MemberService {
	//로그인
	public MemberVo login(MemberVo vo) throws Exception {
		//conn
		Connection conn=JDBCTemplate.getConnection();
		
		//dao
		MemberDao dao=new MemberDao();
		MemberVo loginMember=dao.login(conn,vo);
	
		//close
		JDBCTemplate.close(conn);
		return loginMember;
	}
	
	//회원가입
	public int join(MemberVo vo) throws Exception {
		//conn
		Connection conn=JDBCTemplate.getConnection();
		
		//dao
		MemberDao dao=new MemberDao();
		int result=dao.join(conn,vo);
		
		//tx
		if(result==1) {
			JDBCTemplate.commit(conn);
		}else {
			JDBCTemplate.rollback(conn);
		}
		
		//close
		JDBCTemplate.close(conn);
		return result;
	}
	
}
