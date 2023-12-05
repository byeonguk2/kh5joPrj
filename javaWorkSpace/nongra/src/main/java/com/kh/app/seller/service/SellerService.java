package com.kh.app.seller.service;

import java.sql.Connection;

import com.kh.app.seller.dao.SellerDao;
import com.kh.app.seller.vo.SellerVo;
import com.kh.app.util.db.JDBCTemplate;


public class SellerService {
	
	//아이디 체크 (회원가입시 클라이언트에게 아이디를 받아온다)
	public int idCheck(String id) throws Exception {
		
		// conn 가져오기 
		Connection conn = JDBCTemplate.getConnection();
		
		// dao 선언 / 호출 
		SellerDao dao = new SellerDao();
		
		// 디비 조회후 받아온 값 저장 
		int num = dao.idCheck(conn, id);
		
		// close
		JDBCTemplate.close(conn);
		
		//return
		return num;
	}

	public int join(SellerVo joinVo, String[] strArr) throws Exception {
		
		// connection
		Connection conn = JDBCTemplate.getConnection();
		
		// dao 호출 
		SellerDao dao = new SellerDao();
		int result = dao.join(joinVo,conn,strArr);
		
		// result가 4면 커밋 아니면 롤백 
		if(result == 4) {
			JDBCTemplate.commit(conn);
		}else {
			JDBCTemplate.rollback(conn);
		}
			
		// connection close 
		JDBCTemplate.close(conn);
		
		// result return
		return result;
	}


	public SellerVo login(SellerVo vo) throws Exception {
		
		Connection conn = JDBCTemplate.getConnection();
		
		SellerDao ss = new SellerDao();
		SellerVo loginSeller = ss.login(vo,conn);
		
		JDBCTemplate.close(conn);
		
		
		return loginSeller;
	}

	public int nickCheck(String nick) throws Exception {
		// conn 가져오기 
		Connection conn = JDBCTemplate.getConnection();
				
		// dao 선언  호출 
		SellerDao dao = new SellerDao();
				
		// 디비 조회후 받아온 값 저장 
		int num = dao.nickCheck(conn, nick);
				
		// close
		JDBCTemplate.close(conn);
				
		//return
		return num;
	}

	public int modify(SellerVo vo) throws Exception {
		Connection conn = JDBCTemplate.getConnection();
		
		// dao 호출 
		SellerDao dao = new SellerDao();
		int result = dao.modify(vo,conn);

		if(result == 1) {
			JDBCTemplate.commit(conn);
		}else {
			JDBCTemplate.rollback(conn);
		}
			
		// connection close 
		JDBCTemplate.close(conn);
		
		// result return
		return result;
	}

	
	public int businessInfo(SellerVo vo) throws Exception {
		
Connection conn = JDBCTemplate.getConnection();
		
		// dao 호출 
		SellerDao dao = new SellerDao();
		int result = dao.businessInfo(vo,conn);

		if(result == 1) {
			JDBCTemplate.commit(conn);
		}else {
			JDBCTemplate.rollback(conn);
		}
			
		// connection close 
		JDBCTemplate.close(conn);
		
		// result return
		return result;
	}

}
