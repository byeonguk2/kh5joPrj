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
		
		Connection conn = JDBCTemplate.getConnection();
		
		SellerDao dao = new SellerDao();
		int result = dao.join(joinVo,conn,strArr);
		
		if(result == 4) {
			JDBCTemplate.commit(conn);
		}else {
			JDBCTemplate.rollback(conn);
		}
				
		JDBCTemplate.close(conn);
		
		return result;
	}


	public SellerVo login(SellerVo vo) throws Exception {
		
		Connection conn = JDBCTemplate.getConnection();
		
		SellerDao ss = new SellerDao();
		SellerVo loginSeller = ss.login(vo,conn);
		
		JDBCTemplate.close(conn);
		
		
		return loginSeller;
	}

}
