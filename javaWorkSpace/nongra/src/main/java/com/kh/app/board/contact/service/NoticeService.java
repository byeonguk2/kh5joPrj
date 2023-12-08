package com.kh.app.board.contact.service;

import java.sql.Connection;
import java.util.List;

import com.kh.app.board.contact.dao.NoticeDao;
import com.kh.app.board.contact.vo.NoticeVo;
import com.kh.app.page.vo.PageVoTest;
import com.kh.app.util.db.JDBCTemplate;

public class NoticeService {
	public int selectNoticeCount(String readPermissionNo) throws Exception {
		Connection conn = JDBCTemplate.getConnection();
		NoticeDao dao = new NoticeDao();  // 나중에 밖으로 빼도 되나? 
		int totalNoticeCnt = dao.selectNoticeCount(conn, readPermissionNo);
		JDBCTemplate.close(conn);
		return totalNoticeCnt;
	}

	public List<NoticeVo> selectNoticeList(String readPermissionNo, PageVoTest pvo) throws Exception {
		Connection conn = JDBCTemplate.getConnection();
		NoticeDao dao = new NoticeDao();
		List<NoticeVo> noticeVoList = dao.selectNoticeList(conn, readPermissionNo, pvo);
		JDBCTemplate.close(conn);
		return noticeVoList;
	}
}
