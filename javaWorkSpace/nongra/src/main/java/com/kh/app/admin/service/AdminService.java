package com.kh.app.admin.service;

import java.sql.Connection;
import java.util.List;
import java.util.Map;

import com.kh.app.admin.dao.AdminDao;
import com.kh.app.page.vo.PageVo;
import com.kh.app.seller.dao.SellerDao;
import com.kh.app.seller.vo.SellerVo;
import com.kh.app.util.db.JDBCTemplate;

public class AdminService {

	public List<SellerVo> request(PageVo pvo) throws Exception {
		
		Connection conn = JDBCTemplate.getConnection();
		
		AdminDao as = new AdminDao();
		List<SellerVo> voList = as.request(conn,pvo);
		
		JDBCTemplate.close(conn);
		
		
		return voList;

	}

	public int selectrequestSellerCount() throws Exception {
		
		Connection conn = JDBCTemplate.getConnection();
		
		AdminDao dao = new AdminDao();
		int listCount = dao.selectrequestSellerCount(conn);
		
		JDBCTemplate.close(conn);
		
		return listCount;
		
	}

}
