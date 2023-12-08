package com.kh.app.board.contact.service;

import java.sql.Connection;
import java.util.List;

import com.kh.app.board.contact.dao.NoticeDao;
import com.kh.app.board.contact.dao.QnaDao;
import com.kh.app.board.contact.vo.QnaMemberCateVo;
import com.kh.app.board.contact.vo.QnaMemberVo;
import com.kh.app.board.contact.vo.QnaSellerVo;
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
	public List<QnaSellerVo> getQnaSellerList(String userNo) throws Exception {
		Connection conn = JDBCTemplate.getConnection();
		QnaDao dao = new QnaDao();  
		List<QnaSellerVo> qnaVoList = dao.getQnaSellerList(conn, userNo);
		JDBCTemplate.close(conn);
		return qnaVoList;
	}
	public List<QnaMemberVo> getQnaMemberList(String userNo) throws Exception {
		Connection conn = JDBCTemplate.getConnection();
		QnaDao dao = new QnaDao();  
		List<QnaMemberVo> qnaVoList = dao.getQnaMemberList(conn, userNo);
		JDBCTemplate.close(conn);
		return qnaVoList;
	}
	
}
