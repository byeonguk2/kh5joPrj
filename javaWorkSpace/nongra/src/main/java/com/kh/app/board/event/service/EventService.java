package com.kh.app.board.event.service;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.kh.app.board.event.dao.EventDao;
import com.kh.app.board.event.vo.EventReplyVo;
import com.kh.app.board.event.vo.EventVo;
import com.kh.app.page.vo.PageVo;
import com.kh.app.util.db.JDBCTemplate;

public class EventService {
	//*** 이벤트 수 조회 
	//현재 진행중인 이벤트 수 조회 
	public int selectPresentEventCount() throws Exception {
		Connection conn = JDBCTemplate.getConnection();
		EventDao dao = new EventDao();
		int eventCount = dao.selectPresentEventCount(conn);
		JDBCTemplate.close(conn);
		return eventCount;
	}

	//진행 예정인 이벤트 수 조회 
	public int selectFutureEventCount() throws Exception {
		Connection conn = JDBCTemplate.getConnection();
		EventDao dao = new EventDao();
		int eventCount = dao.selectFutureEventCount(conn);
		JDBCTemplate.close(conn);
		return eventCount;
	}

	//종료된 이벤트 수 조회 
	public int selectPastEventCount() throws Exception {
		Connection conn = JDBCTemplate.getConnection();
		EventDao dao = new EventDao();
		int eventCount = dao.selectPastEventCount(conn);
		JDBCTemplate.close(conn);
		return eventCount;
	}

	//*** 이벤트 목록조회
	//진행중 이벤트 목록
	public List<EventVo> selectPresentEventList (PageVo pvo) throws Exception{
		Connection conn = JDBCTemplate.getConnection();
		EventDao dao = new EventDao();
		List<EventVo> eventVoList = dao.selectPresentEventList(conn, pvo);
		JDBCTemplate.close(conn);
		return eventVoList;
	}

	//진행예정 이벤트 목록
	public List<EventVo> selectFutureEventList (PageVo pvo) throws Exception{
		Connection conn = JDBCTemplate.getConnection();
		EventDao dao = new EventDao();
		List<EventVo> eventVoList = dao.selectFutureEventList(conn, pvo);
		JDBCTemplate.close(conn);
		return eventVoList;
	}

	//종료 이벤트 목록
	public List<EventVo> selectPastEventList (PageVo pvo) throws Exception{
		Connection conn = JDBCTemplate.getConnection();
		EventDao dao = new EventDao();
		List<EventVo> eventVoList = dao.selectPastEventList(conn, pvo);
		JDBCTemplate.close(conn);
		return eventVoList;
	}

	//*** 글번호로 글내용 상세조회
	//	public Map<String, Object> selectDetailByNo(String no) throws Exception {
	public List<EventVo> selectDetailByNo(String no) throws Exception {

		Connection conn = JDBCTemplate.getConnection();
		EventDao dao = new EventDao();
		int result = dao.increaseHit(conn, no);
		List<EventVo> voList = null;
		if(result == 1) {
			voList = dao.selectDetailByNo(conn, no);
		}
		if(result == 1) {
			JDBCTemplate.commit(conn);
		}else {
			JDBCTemplate.rollback(conn);
		}
		JDBCTemplate.close(conn);
		//		Map<String,Object> map = new HashMap<String, Object>();
		//		map.put("vo", voList);
		//		return map;
		return voList;
	}

	//*** 글번호로 댓글 목록 조회
	public List<EventReplyVo> selectReplyByNo(String no) throws Exception{
		Connection conn = JDBCTemplate.getConnection();
		EventDao dao = new EventDao();
		List<EventReplyVo> replyVoList = dao.selectReplyByNo(conn, no);
		JDBCTemplate.close(conn);
		return replyVoList;
	}


}
