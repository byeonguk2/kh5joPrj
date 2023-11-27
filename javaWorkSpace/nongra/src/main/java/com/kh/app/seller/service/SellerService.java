package com.kh.app.seller.service;

import java.sql.Connection;

import com.kh.app.seller.dao.SellerDao;
import com.kh.app.seller.vo.SellerVo;
import com.kh.app.util.db.JDBCTemplate;


public class SellerService {

	public int idCheck(String id) throws Exception {
		
		Connection conn = JDBCTemplate.getConnection();
		
		SellerDao dao = new SellerDao();
		int returnId = dao.idCheck(conn, id);
		
		JDBCTemplate.close(conn);
		
		return returnId;
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

	public int insertNo(SellerVo vo) throws Exception {
		
		Connection conn = JDBCTemplate.getConnection();
		
		SellerDao dao = new SellerDao();
		int result = dao.insertNo(vo,conn);
		
		if(result == 1) {
			JDBCTemplate.commit(conn);
		}else {
			JDBCTemplate.rollback(conn);
		}
				
		JDBCTemplate.close(conn);
		
		return result;
	}

	public String selectNo(SellerVo vo) throws Exception {
		
		Connection conn = JDBCTemplate.getConnection();
		
		SellerDao dao = new SellerDao();
		String sellerNo = dao.selectNo(vo,conn);
		
		JDBCTemplate.close(conn);
		
		if(sellerNo == null) {
			throw new Exception("사업자 번호가 존재하지 않음");
		}
		
		return sellerNo;
	}

	public SellerVo login(SellerVo vo) throws Exception {
		
		Connection conn = JDBCTemplate.getConnection();
		
		SellerDao ss = new SellerDao();
		SellerVo loginSeller = ss.login(vo,conn);
		
		JDBCTemplate.close(conn);
		
		
		return loginSeller;
	}

}
