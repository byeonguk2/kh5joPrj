package com.kh.app.board.contact.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import com.kh.app.board.contact.vo.NoticeVo;
import com.kh.app.page.vo.PageVoTest;
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

	public List<NoticeVo> selectNoticeList(Connection conn, String readPermissionNo, PageVoTest pvo) {
		
		return null;
	}


}
