package com.kh.app.board.event.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.kh.app.board.event.vo.EventFileVo;
import com.kh.app.board.event.vo.EventReplyVo;
import com.kh.app.board.event.vo.EventVo;
import com.kh.app.page.vo.PageVo;
import com.kh.app.util.db.DateFormat;
import com.kh.app.util.db.JDBCTemplate;

public class EventDao {
	//*** 이벤트 수 조회 
	//현재 진행중인 이벤트 수 조회 
	public int selectPresentEventCount(Connection conn) throws Exception {
		String sql = "SELECT COUNT(*) FROM BOARD_EVENT WHERE DEL_YN = 'N' AND SYSDATE BETWEEN START_DATE AND END_DATE";
		PreparedStatement pstmt = conn.prepareStatement(sql);
		ResultSet rs = pstmt.executeQuery();
		int eventCount = 0;
		if(rs.next()) {
			eventCount = rs.getInt(1);
		}
		JDBCTemplate.close(rs);
		JDBCTemplate.close(pstmt);
		return eventCount;
	}

	//진행 예정인 이벤트 수 조회 
	public int selectFutureEventCount(Connection conn) throws Exception {
		String sql = "SELECT COUNT(*) FROM BOARD_EVENT WHERE DEL_YN = 'N' AND SYSDATE < START_DATE";
		PreparedStatement pstmt = conn.prepareStatement(sql);
		ResultSet rs = pstmt.executeQuery();
		int eventCount = 0;
		if(rs.next()) {
			eventCount = rs.getInt(1);
		}
		JDBCTemplate.close(rs);
		JDBCTemplate.close(pstmt);
		return eventCount;
	}

	//종료된 이벤트 수 조회 
	public int selectPastEventCount(Connection conn) throws Exception {
		String sql = "SELECT COUNT(*) FROM BOARD_EVENT WHERE DEL_YN = 'N' AND SYSDATE > END_DATE";
		PreparedStatement pstmt = conn.prepareStatement(sql);
		ResultSet rs = pstmt.executeQuery();
		int eventCount = 0;
		if(rs.next()) {
			eventCount = rs.getInt(1);
		}
		JDBCTemplate.close(rs);
		JDBCTemplate.close(pstmt);
		return eventCount;
	} 

	//*** 이벤트 목록 조회 
	//진행중 이벤트 목록 
	public List<EventVo> selectPresentEventList (Connection conn, PageVo pvo) throws Exception{
		String sql = "SELECT * FROM ( SELECT ROWNUM RNUM, T.* FROM (SELECT EVENT_NO , WRITER_NO , TITLE , CONTENT , ENROLL_DATE , MODIFY_DATE , HIT , DEL_YN , START_DATE , END_DATE , FILE_NO , FILE_NAME , MAIN_YN , ID , NICK FROM BOARD_EVENT B JOIN MANAGER M ON M.MANAGER_NO = B.WRITER_NO JOIN BOARD_EVENT_FILE F ON F.BOARD_EVENT_ID = B.EVENT_NO WHERE DEL_YN = 'N' AND MAIN_YN = 'Y' AND SYSDATE BETWEEN START_DATE AND END_DATE ORDER BY START_DATE DESC) T ) WHERE RNUM BETWEEN ? AND ?";
		PreparedStatement pstmt = conn.prepareStatement(sql);
		pstmt.setInt(1, pvo.getStartRow());
		pstmt.setInt(2, pvo.getLastRow());
		ResultSet rs = pstmt.executeQuery();
		List<EventVo> eventVoList = new ArrayList<EventVo>();
		while(rs.next()) {
			String eventNo = rs.getString("EVENT_NO");
			String writerNo = rs.getString("WRITER_NO");
			String title = rs.getString("TITLE");
			String content = rs.getString("CONTENT");
			String enrollDate = rs.getString("ENROLL_DATE");
			String modifyDate = rs.getString("MODIFY_DATE");
			String hit = rs.getString("HIT");
			String delYn = rs.getString("DEL_YN");
			String startDate = rs.getString("START_DATE");
			String endDate = rs.getString("END_DATE");

			String fileNo = rs.getString("FILE_NO");
			String fileName = rs.getString("FILE_NAME");
			String mainYn = rs.getString("MAIN_YN");

			String writerId = rs.getString("ID");
			String writerNick = rs.getString("NICK");

			EventVo vo = new EventVo();
			vo.setEventNo(eventNo);
			vo.setWriterNo(writerNo);
			vo.setTitle(title);
			vo.setContent(content);
			vo.setEnrollDate(enrollDate);
			vo.setModifyDate(modifyDate);
			vo.setHit(hit);
			vo.setDelYn(delYn);
			vo.setStartDate(DateFormat.formattedDate(startDate));
			vo.setEndDate(DateFormat.formattedDate(endDate));
			vo.setFileNo(fileNo);
			vo.setFileName(fileName);
			vo.setMainYn(mainYn);
			vo.setWriterId(writerId);
			vo.setWriterNick(writerNick);

			eventVoList.add(vo);
		}
		JDBCTemplate.close(rs);
		JDBCTemplate.close(pstmt);
		return eventVoList;
	}

	//진행예정 이벤트 목록 
	public List<EventVo> selectFutureEventList (Connection conn, PageVo pvo) throws Exception{
		String sql = "SELECT * FROM ( SELECT ROWNUM RNUM, T.* FROM (SELECT EVENT_NO , WRITER_NO , TITLE , CONTENT , ENROLL_DATE , MODIFY_DATE , HIT , DEL_YN , START_DATE , END_DATE , FILE_NO , FILE_NAME , MAIN_YN , ID , NICK FROM BOARD_EVENT B JOIN MANAGER M ON M.MANAGER_NO = B.WRITER_NO JOIN BOARD_EVENT_FILE F ON F.BOARD_EVENT_ID = B.EVENT_NO WHERE DEL_YN = 'N' AND MAIN_YN = 'Y' AND SYSDATE < START_DATE ORDER BY START_DATE DESC) T ) WHERE RNUM BETWEEN ? AND ?";
		PreparedStatement pstmt = conn.prepareStatement(sql);
		pstmt.setInt(1, pvo.getStartRow());
		pstmt.setInt(2, pvo.getLastRow());
		ResultSet rs = pstmt.executeQuery();
		List<EventVo> eventVoList = new ArrayList<EventVo>();
		while(rs.next()) {
			String eventNo = rs.getString("EVENT_NO");
			String writerNo = rs.getString("WRITER_NO");
			String title = rs.getString("TITLE");
			String content = rs.getString("CONTENT");
			String enrollDate = rs.getString("ENROLL_DATE");
			String modifyDate = rs.getString("MODIFY_DATE");
			String hit = rs.getString("HIT");
			String delYn = rs.getString("DEL_YN");
			String startDate = rs.getString("START_DATE");
			String endDate = rs.getString("END_DATE");

			String fileNo = rs.getString("FILE_NO");
			String fileName = rs.getString("FILE_NAME");
			String mainYn = rs.getString("MAIN_YN");

			String writerId = rs.getString("ID");
			String writerNick = rs.getString("NICK");

			EventVo vo = new EventVo();
			vo.setEventNo(eventNo);
			vo.setWriterNo(writerNo);
			vo.setTitle(title);
			vo.setContent(content);
			vo.setEnrollDate(enrollDate);
			vo.setModifyDate(modifyDate);
			vo.setHit(hit);
			vo.setDelYn(delYn);
			vo.setStartDate(DateFormat.formattedDate(startDate));
			vo.setEndDate(DateFormat.formattedDate(endDate));
			vo.setFileNo(fileNo);
			vo.setFileName(fileName);
			vo.setMainYn(mainYn);
			vo.setWriterId(writerId);
			vo.setWriterNick(writerNick);

			eventVoList.add(vo);
		}
		JDBCTemplate.close(rs);
		JDBCTemplate.close(pstmt);
		return eventVoList;
	}

	//종료 이벤트 목록 
	public List<EventVo> selectPastEventList (Connection conn, PageVo pvo) throws Exception{
		String sql = "SELECT * FROM ( SELECT ROWNUM RNUM, T.* FROM (SELECT EVENT_NO , WRITER_NO , TITLE , CONTENT , ENROLL_DATE , MODIFY_DATE , HIT , DEL_YN , START_DATE , END_DATE , FILE_NO , FILE_NAME , MAIN_YN , ID , NICK FROM BOARD_EVENT B JOIN MANAGER M ON M.MANAGER_NO = B.WRITER_NO JOIN BOARD_EVENT_FILE F ON F.BOARD_EVENT_ID = B.EVENT_NO WHERE DEL_YN = 'N' AND MAIN_YN = 'Y' AND SYSDATE < START_DATE ORDER BY START_DATE DESC) T ) WHERE RNUM BETWEEN ? AND ?";
		PreparedStatement pstmt = conn.prepareStatement(sql);
		pstmt.setInt(1, pvo.getStartRow());
		pstmt.setInt(2, pvo.getLastRow());
		ResultSet rs = pstmt.executeQuery();
		List<EventVo> eventVoList = new ArrayList<EventVo>();
		while(rs.next()) {
			String eventNo = rs.getString("EVENT_NO");
			String writerNo = rs.getString("WRITER_NO");
			String title = rs.getString("TITLE");
			String content = rs.getString("CONTENT");
			String enrollDate = rs.getString("ENROLL_DATE");
			String modifyDate = rs.getString("MODIFY_DATE");
			String hit = rs.getString("HIT");
			String delYn = rs.getString("DEL_YN");
			String startDate = rs.getString("START_DATE");
			String endDate = rs.getString("END_DATE");

			String fileNo = rs.getString("FILE_NO");
			String fileName = rs.getString("FILE_NAME");
			String mainYn = rs.getString("MAIN_YN");

			String writerId = rs.getString("ID");
			String writerNick = rs.getString("NICK");

			EventVo vo = new EventVo();
			vo.setEventNo(eventNo);
			vo.setWriterNo(writerNo);
			vo.setTitle(title);
			vo.setContent(content);
			vo.setEnrollDate(enrollDate);
			vo.setModifyDate(modifyDate);
			vo.setHit(hit);
			vo.setDelYn(delYn);
			vo.setStartDate(DateFormat.formattedDate(startDate));
			vo.setEndDate(DateFormat.formattedDate(endDate));
			vo.setFileNo(fileNo);
			vo.setFileName(fileName);
			vo.setMainYn(mainYn);
			vo.setWriterId(writerId);
			vo.setWriterNick(writerNick);

			eventVoList.add(vo);
		}
		JDBCTemplate.close(rs);
		JDBCTemplate.close(pstmt);
		return eventVoList;
	}
	
	//*** 글내용조회하면 조회수 증가  
	public int increaseHit (Connection conn, String no) throws Exception {
		String sql = "UPDATE BOARD_EVENT SET HIT = HIT + 1 WHERE EVENT_NO = ? AND DEL_YN = 'N'";
		PreparedStatement pstmt= conn.prepareStatement(sql);
		pstmt.setString(1, no);
		int result = pstmt.executeUpdate();
		JDBCTemplate.close(pstmt);
		return result;
	}

	//*** 글번호로 글내용 상세조회
	public ArrayList<EventVo> selectDetailByNo(Connection conn, String no) throws Exception {
		String sql = "SELECT EVENT_NO , WRITER_NO , TITLE , CONTENT , ENROLL_DATE , MODIFY_DATE , HIT , DEL_YN , START_DATE , END_DATE , FILE_NO , FILE_NAME , MAIN_YN , ID , NICK FROM BOARD_EVENT B JOIN MANAGER M ON M.MANAGER_NO = B.WRITER_NO JOIN BOARD_EVENT_FILE F ON F.BOARD_EVENT_ID = B.EVENT_NO WHERE DEL_YN = 'N' AND EVENT_NO = ? ORDER BY MAIN_YN DESC, FILE_NO ASC";
		PreparedStatement pstmt = conn.prepareStatement(sql);
		pstmt.setString(1, no);
		ResultSet rs = pstmt.executeQuery();
		List<EventVo> detailVoList = new ArrayList<EventVo>();
		while(rs.next()) {
			String eventNo = rs.getString("EVENT_NO");
			String writerNo = rs.getString("WRITER_NO");
			String title = rs.getString("TITLE");
			String content = rs.getString("CONTENT");
			String enrollDate = rs.getString("ENROLL_DATE");
			String modifyDate = rs.getString("MODIFY_DATE");
			String hit = rs.getString("HIT");
			String delYn = rs.getString("DEL_YN");
			String startDate = rs.getString("START_DATE");
			String endDate = rs.getString("END_DATE");

			String fileNo = rs.getString("FILE_NO");
			String fileName = rs.getString("FILE_NAME");
			String mainYn = rs.getString("MAIN_YN");

			String writerId = rs.getString("ID");
			String writerNick = rs.getString("NICK");

			EventVo vo = new EventVo(eventNo, writerNo, title, content, enrollDate, modifyDate, hit, delYn, startDate, endDate, fileNo, fileName, mainYn, writerId, writerNick);
			vo.setEventNo(eventNo);
			vo.setWriterNo(writerNo);
			vo.setTitle(title);
			vo.setContent(content);
			vo.setEnrollDate(enrollDate);
			vo.setModifyDate(modifyDate);
			vo.setHit(hit);
			vo.setDelYn(delYn);
			vo.setStartDate(DateFormat.formattedDate(startDate));
			vo.setEndDate(DateFormat.formattedDate(endDate));
			vo.setFileNo(fileNo);
			vo.setFileName(fileName);
			vo.setMainYn(mainYn);
			vo.setWriterId(writerId);
			vo.setWriterNick(writerNick);
			detailVoList.add(vo);
		}
		Map<String, EventVo> map = new HashMap<String, EventVo>();
		for (EventVo vo : detailVoList) {
			map.put(vo.getEventNo(), vo);
		}
		for (EventVo vo : detailVoList) {
			String fileNo = vo.getFileNo();
			String fileName = vo.getFileName();
			String mainYn = vo.getMainYn();
			String eventNo = vo.getEventNo();
			
			EventFileVo fileVo = new EventFileVo(fileNo, eventNo, fileName, mainYn);
			map.get(fileVo.getBoardEventNo()).getFileVoList().add(fileVo);
		}
		ArrayList<EventVo> result = new ArrayList<EventVo>(map.values());
		
		for(EventVo vo : result) {
			List<EventFileVo> fileVoList = vo.getFileVoList();
			for (EventFileVo fileVo : fileVoList) {
				String mainYn = fileVo.getMainYn();
				if(mainYn.equals("Y")) {
					vo.setMainVo(fileVo);
					break;
				}
			}
		}
		JDBCTemplate.close(rs);
		JDBCTemplate.close(pstmt);
		return result;
	}
	
	//*** 글번호로 댓글 목록 조회
	public List<EventReplyVo> selectReplyByNo(Connection conn, String no) throws Exception{
		String sql = "SELECT REPLY_NO , EVENT_NO , WRITER_NO , CONTENT , ENROLL_DATE , MODIFY_DATE , DEL_YN FROM BOARD_EVENT_REPLY WHERE DEL_YN = 'N' AND EVENT_NO = ? ORDER BY ENROLL_DATE ASC";
		PreparedStatement pstmt = conn.prepareStatement(sql);
		pstmt.setString(1, no);
		ResultSet rs = pstmt.executeQuery();
		List<EventReplyVo> replyVoList = new ArrayList<EventReplyVo>();
		while(rs.next()) {
			String replyNo = rs.getString("REPLY_NO");
			String eventNo = rs.getString("EVENT_NO");
			String writerNo = rs.getString("WRITER_NO");
			String content = rs.getString("CONTENT");
			String enrollDate = DateFormat.formattedDate(rs.getString("ENROLL_DATE"));
			String modifyDate = DateFormat.formattedDate(rs.getString("MODIFY_DATE"));
			String delYn = rs.getString("DEL_YN");
			
			EventReplyVo vo = new EventReplyVo(replyNo, eventNo, writerNo, content, enrollDate, modifyDate, delYn);
		}
		JDBCTemplate.close(rs);
		JDBCTemplate.close(pstmt);
		return replyVoList;
	}
	


}


