package com.kh.app.board.contact.service;

import java.sql.Connection;
import java.util.List;

import com.kh.app.board.contact.dao.NoticeDao;
import com.kh.app.board.contact.dao.QnaDao;
import com.kh.app.board.contact.vo.QnaMemberCateVo;
import com.kh.app.board.contact.vo.QnaMemberVo;
import com.kh.app.util.db.JDBCTemplate;

public class QnaService {

	public List<QnaMemberCateVo> getParentCateList() throws Exception {
		Connection conn = JDBCTemplate.getConnection();
		QnaDao dao = new QnaDao();  
		List<QnaMemberCateVo> parentCateVoList = dao.getParentCateList(conn);
		JDBCTemplate.close(conn);
		return parentCateVoList;
	}

	public List<QnaMemberCateVo> getChildCateList() throws Exception {
		Connection conn = JDBCTemplate.getConnection();
		QnaDao dao = new QnaDao();  
		List<QnaMemberCateVo> childCateVoList = dao.getParentCateList(conn);
		JDBCTemplate.close(conn);
		return childCateVoList;
	}
	public List<QnaMemberVo> getQnaList(String userNo) {
		// TODO Auto-generated method stub
		return null;
	}
	
	/*
	public List<QnaSellerVo> getQnaList(String userNo) {
		// TODO Auto-generated method stub
		return null;
	}
*/
}
