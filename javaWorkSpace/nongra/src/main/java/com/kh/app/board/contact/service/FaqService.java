package com.kh.app.board.contact.service;

import java.sql.Connection;
import java.util.List;
import java.util.Map;

import com.kh.app.board.contact.dao.FaqDao;
import com.kh.app.board.contact.vo.FaqVo;
import com.kh.app.page.vo.PageVoTest;
import com.kh.app.util.db.JDBCTemplate;

public class FaqService {
	//**** 목록조회
	//읽기권한 + 카테고리별 글 수 조회
	public int selectFaqCount(String readPermissionNo, String cateNo) throws Exception {
		Connection conn = JDBCTemplate.getConnection();
		FaqDao dao = new FaqDao();  // 나중에 밖으로 빼도 되나? 
		int totalFaqCnt = dao.selectFaqCount(conn, readPermissionNo, cateNo);
		JDBCTemplate.close(conn);
		return totalFaqCnt;
	}
	// 읽기권한 + 카테고리별 글 목록 조회 
	public List<FaqVo> selectFaqList(String readPermissionNo, String cateNo, PageVoTest pvo) throws Exception {
		Connection conn = JDBCTemplate.getConnection();
		FaqDao dao = new FaqDao();
		List<FaqVo> faqVoList = dao.selectFaqList(conn, readPermissionNo, cateNo, pvo);
		JDBCTemplate.close(conn);
		return faqVoList;
	}

	//**** 검색
	//읽기권한 + 카테고리별 글 수 조회
	public int searchFaqCount(String readPermissionNo, Map<String, String> map) throws Exception {
		Connection conn = JDBCTemplate.getConnection();
		FaqDao dao = new FaqDao();  // 나중에 밖으로 빼도 되나? 
		int cnt = dao.searchFaqCount(conn, readPermissionNo, map);
		JDBCTemplate.close(conn);
		return cnt;
	}
	// 읽기권한 + 카테고리별 글 목록 조회 
	public List<FaqVo> searchFaqList(String readPermissionNo, Map<String, String> map) throws Exception {
		Connection conn = JDBCTemplate.getConnection();
		FaqDao dao = new FaqDao();
		List<FaqVo> faqVoList = dao.searchFaqList(conn, readPermissionNo, map);
		JDBCTemplate.close(conn);
		return faqVoList;
	}
}
