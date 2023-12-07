package com.kh.app.admin.service;

import java.sql.Connection;
import java.util.HashMap;
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

	public Map<String, Object> selectBusinessInfo(String no) throws Exception {
		
		Connection conn = JDBCTemplate.getConnection();
		
		AdminDao dao = new AdminDao();
		
		SellerVo vo = dao.selectBusinessInfo(conn,no);
		List<SellerVo> fileList = dao.selectBusinessFile(conn,no);
		
		Map<String, Object> map = new HashMap<>();
		
		map.put("vo", vo);
		map.put("fileList", fileList.get(0).getFileSrc());
		map.put("fileList2", fileList.get(1).getFileSrc());
		
		JDBCTemplate.close(conn);
		
		return map;
	}

	public int requestOk(String no) throws Exception {
		
		// connection
		Connection conn = JDBCTemplate.getConnection();
		
		// dao 호출 
		AdminDao dao = new AdminDao();
		int result = dao.requestOk(no,conn);
		
		// result가 4면 커밋 아니면 롤백 
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

	public int selectSearchSellerCount(Map<String, String> map) throws Exception {
		Connection conn = JDBCTemplate.getConnection();
		
		AdminDao dao = new AdminDao();
		int listCount = dao.selectSearchSellerCount(conn,map);
		
		JDBCTemplate.close(conn);
		
		return listCount;
	
	}

	public List<SellerVo> search(Map<String, String> map, PageVo pvo) throws Exception {
		
		// conn
		Connection conn = JDBCTemplate.getConnection();
				
		// DAO
		AdminDao dao = new AdminDao();
		List<SellerVo> sellerVoList = dao.search(conn , map, pvo);
				
		//close
		JDBCTemplate.close(conn);
				
		return sellerVoList;
		
	}

	public List<SellerVo> memberBen(PageVo pvo) throws Exception{
		Connection conn = JDBCTemplate.getConnection();
		
		AdminDao as = new AdminDao();
		List<SellerVo> voList = as.memberBen(conn,pvo);
		
		JDBCTemplate.close(conn);
		
		return voList;
	}

	public int selectMemberSellerCount()throws Exception {
		
		Connection conn = JDBCTemplate.getConnection();
		
		AdminDao dao = new AdminDao();
		int listCount = dao.selectMemberSellerCount(conn);
		
		JDBCTemplate.close(conn);
		
		return listCount;
		
	}

	public int selectMemberSearchCount(Map<String, String> map)throws Exception  {
		Connection conn = JDBCTemplate.getConnection();
		
		AdminDao dao = new AdminDao();
		int listCount = dao.selectMemberSearchCount(conn);
		
		JDBCTemplate.close(conn);
		
		return listCount;
	}
	
}
