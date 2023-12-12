package com.kh.app.sales.service;

import java.sql.Connection;
import java.util.List;

import com.kh.app.sales.dao.SalesDao;
import com.kh.app.sales.vo.SalesVo;
import com.kh.app.util.db.JDBCTemplate;

public class SalesService {
	
	//상품 목록 조회
	public List<SalesVo> salesListSelect() throws Exception{
		
		Connection conn = JDBCTemplate.getConnection();
		
		SalesDao sd = new SalesDao();
		List<SalesVo> salesVoList = sd.salesListSelect(conn);
		
		return salesVoList;
	}
	// 상품 등록
	public int salesRegister(SalesVo vo) throws Exception{
		Connection conn = JDBCTemplate.getConnection();
		SalesDao dao = new SalesDao();
		int result = dao.salesRegister(conn , vo);
		
		if(result != 1) {
			JDBCTemplate.rollback(conn);
		}
		JDBCTemplate.close(conn);
		
		return result;
	}

}
