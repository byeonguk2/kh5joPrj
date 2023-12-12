package com.kh.app.board.contact.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.kh.app.board.contact.vo.NoticeVo;
import com.kh.app.page.vo.PageVoTest;
import com.kh.app.util.db.DateFormat;
import com.kh.app.util.db.JDBCTemplate;

public class NoticeDao {
//할일 : 관리자는 공개여부 N인것도 조회해야하니까 admin 조회 메서드 따로 만들기 아니면 쿼리 계층 나눠서 메서드 재사용**=> 명칭들도 공적으로 바꿔야지~
	public int selectNoticeCount(Connection conn, String readPermissionNo) throws Exception {
		String sql = "SELECT COUNT(*) AS CNT FROM NOTICE WHERE OPEN_YN = 'Y' AND READ_PERMISSION = ?";
		PreparedStatement pstmt = conn.prepareStatement(sql);
		pstmt.setString(1, readPermissionNo);
		ResultSet rs = pstmt.executeQuery();
		int totalNoticeCnt = 0;
		if(rs.next()) {
			totalNoticeCnt = rs.getInt(1);
		}
		JDBCTemplate.close(rs);
		JDBCTemplate.close(pstmt);
		return totalNoticeCnt;
	}

	public List<NoticeVo> selectNoticeList(Connection conn, String readPermissionNo, PageVoTest pvo) throws Exception {
		String sql = "SELECT * FROM ( SELECT ROWNUM RNUM, T.* FROM ( SELECT * FROM NOTICE WHERE OPEN_YN = 'Y' AND READ_PERMISSION = ? ORDER BY CASE TOP_DISPLAY WHEN 'Y' THEN 0 WHEN 'N' THEN 1 END , ENROLL_DATE DESC ) T ) WHERE RNUM BETWEEN ? AND ?";
		PreparedStatement pstmt = conn.prepareStatement(sql);
		pstmt.setString(1, readPermissionNo);
		pstmt.setInt(2, pvo.getStartRow());
		pstmt.setInt(3, pvo.getLastRow());
		ResultSet rs = pstmt.executeQuery();
		List<NoticeVo> noticeVoList = new ArrayList<NoticeVo>();
		while(rs.next()) {
			String noticeNo = rs.getString("NOTICE_NO");
			String writerNo = rs.getString("WRITER_NO");
			String title = rs.getString("TITLE");
			String content = rs.getString("CONTENT");
			String enrollDate = rs.getString("ENROLL_DATE");
			String modifyDate = rs.getString("MODIFY_DATE");
			String openYn = rs.getString("OPEN_YN");
			String readPermission = rs.getString("READ_PERMISSION");
			String topDisplay = rs.getString("TOP_DISPLAY");
			
			NoticeVo nvo = new NoticeVo();
			nvo.setNoticeNo(noticeNo);
			nvo.setWriterNo(writerNo);
			nvo.setTitle(title);
			nvo.setContent(content);
			nvo.setEnrollDate(DateFormat.formattedDate(enrollDate));
			nvo.setModifyDate(DateFormat.formattedDate(modifyDate));
			nvo.setOpenYn(openYn);
			nvo.setReadPermission(readPermission);
			nvo.setTopDisplay(topDisplay);
			
			noticeVoList.add(nvo);

		}
		JDBCTemplate.close(rs);
		JDBCTemplate.close(pstmt);
		
		for(int i = 0; i < noticeVoList.size(); i++) {
			System.out.println(noticeVoList.get(i));
			
	
			
		}
		return noticeVoList;
	}


}
