package com.kh.app.board.contact.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import com.kh.app.board.contact.vo.FaqCateVo;
import com.kh.app.board.contact.vo.FaqVo;
import com.kh.app.page.vo.PageVoTest;
import com.kh.app.util.db.DateFormat;
import com.kh.app.util.db.JDBCTemplate;




public class FaqDao {
	//**** 목록 
	//읽기권한 + 카테고리별 글 수 조회
	public int selectFaqCount(Connection conn, String readPermissionNo, String cateNo) throws Exception {
		String sql = "SELECT COUNT(*) AS CNT FROM FAQ WHERE OPEN_YN = 'Y' AND READ_PERMISSION = ? AND CATEGORY_ID = ? ";
		PreparedStatement pstmt = conn.prepareStatement(sql);
		pstmt.setString(1, readPermissionNo);
		pstmt.setString(2, cateNo);
		ResultSet rs = pstmt.executeQuery();
		int totalFaqCnt = 0;
		if(rs.next()) {
			totalFaqCnt = rs.getInt(1);
		}
		JDBCTemplate.close(rs);
		JDBCTemplate.close(pstmt);
		return totalFaqCnt;
	}
	
	// 읽기권한 + 카테고리별 글 목록 조회 
	public List<FaqVo> selectFaqList(Connection conn, String readPermissionNo, String cateNo, PageVoTest pvo) throws Exception {
		String sql = "SELECT * FROM ( SELECT ROWNUM RNUM, T.* FROM ( SELECT FAQ_NO , B.CATEGORY_ID , B.WRITER_NO , TITLE , CONTENT , ENROLL_DATE , MODIFY_DATE , OPEN_YN , READ_PERMISSION , ID , NICK , CATEGORY_NAME FROM FAQ B JOIN FAQ_CATEGORY C ON C.CATEGORY_ID = B.CATEGORY_ID JOIN MANAGER W ON W.MANAGER_NO = B.WRITER_NO WHERE OPEN_YN = 'Y' AND READ_PERMISSION = ? AND B.CATEGORY_ID = ? ORDER BY ENROLL_DATE DESC ) T ) WHERE RNUM BETWEEN ? AND ?";
		PreparedStatement pstmt = conn.prepareStatement(sql);
		pstmt.setString(1, readPermissionNo);
		pstmt.setString(2, cateNo);
		pstmt.setInt(3, pvo.getStartRow());
		pstmt.setInt(4, pvo.getLastRow());
		ResultSet rs = pstmt.executeQuery();
		List<FaqVo> faqVoList = new ArrayList<FaqVo>();
		while(rs.next()) {

			String faqNo = rs.getString("FAQ_NO");
			String categoryId = rs.getString("CATEGORY_ID");
			String writerNo = rs.getString("WRITER_NO");
			String title = rs.getString("TITLE");
			String content = rs.getString("CONTENT");
			String enrollDate = rs.getString("ENROLL_DATE");
			String modifyDate = rs.getString("MODIFY_DATE");
			String openYn = rs.getString("OPEN_YN");
			String readPermission = rs.getString("READ_PERMISSION");
			String id = rs.getString("ID");
			String nick = rs.getString("NICK");
			String categoryName = rs.getString("CATEGORY_NAME");

			FaqVo vo = new FaqVo();
			vo.setFaqNo(faqNo);
			vo.setCategoryId(categoryId);
			vo.setWriterNo(writerNo);
			vo.setTitle(title);
			vo.setContent(content);
			vo.setEnrollDate(DateFormat.formattedDate(enrollDate));
			vo.setModifyDate(DateFormat.formattedDate(modifyDate));
			vo.setOpenYn(openYn);
			vo.setReadPermission(readPermission);
			vo.setWriterId(id);
			vo.setWriterNick(nick);
			vo.setCategoryName(categoryName);

			faqVoList.add(vo);
		}
		JDBCTemplate.close(rs);
		JDBCTemplate.close(pstmt);
		return faqVoList;
	}
	
	//**** 검색창
	//읽기권한 + 카테고리별 글 수 조회
		public int searchFaqCount(Connection conn, String readPermissionNo, Map<String, String> map) throws Exception {
			String sql = "SELECT COUNT(*) FROM FAQ B JOIN FAQ_CATEGORY C ON C.CATEGORY_ID = B.CATEGORY_ID JOIN MANAGER W ON W.MANAGER_NO = B.WRITER_NO WHERE OPEN_YN = 'Y' AND READ_PERMISSION = ? AND TITLE LIKE '%' || ? ||'%' OR CONTENT LIKE '%' || ? || '%' ORDER BY ENROLL_DATE DESC";
			PreparedStatement pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, readPermissionNo);
			pstmt.setString(2, map.get("search"));
			pstmt.setString(3, map.get("search"));
			ResultSet rs = pstmt.executeQuery();
			int cnt = 0;
			if(rs.next()) {
				cnt = rs.getInt(1);
			}
			JDBCTemplate.close(rs);
			JDBCTemplate.close(pstmt);
			return cnt;
		}
		
		// 읽기권한 + 카테고리별 글 목록 조회 
		public List<FaqVo> searchFaqList(Connection conn, String readPermissionNo, Map<String, String> map) throws Exception {
			String sql = "SELECT FAQ_NO , B.CATEGORY_ID , B.WRITER_NO , TITLE , CONTENT , ENROLL_DATE , MODIFY_DATE , OPEN_YN , READ_PERMISSION , ID , NICK , CATEGORY_NAME FROM FAQ B JOIN FAQ_CATEGORY C ON C.CATEGORY_ID = B.CATEGORY_ID JOIN MANAGER W ON W.MANAGER_NO = B.WRITER_NO WHERE OPEN_YN = 'Y' AND READ_PERMISSION = ? AND (TITLE LIKE '%' || ? ||'%' OR CONTENT LIKE '%' || ? ||'%') ORDER BY ENROLL_DATE DESC";
			PreparedStatement pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, readPermissionNo);
			pstmt.setString(2, map.get("search"));
			pstmt.setString(3, map.get("search"));

			System.out.println("읽기권한번호 : " + readPermissionNo);
			
			
			ResultSet rs = pstmt.executeQuery();
			List<FaqVo> faqVoList = new ArrayList<FaqVo>();
			while(rs.next()) {

				String faqNo = rs.getString("FAQ_NO");
				String categoryId = rs.getString("CATEGORY_ID");
				String writerNo = rs.getString("WRITER_NO");
				String title = rs.getString("TITLE");
				String content = rs.getString("CONTENT");
				String enrollDate = rs.getString("ENROLL_DATE");
				String modifyDate = rs.getString("MODIFY_DATE");
				String openYn = rs.getString("OPEN_YN");
				String readPermission = rs.getString("READ_PERMISSION");
				String id = rs.getString("ID");
				String nick = rs.getString("NICK");
				String categoryName = rs.getString("CATEGORY_NAME");

				FaqVo vo = new FaqVo();
				vo.setFaqNo(faqNo);
				vo.setCategoryId(categoryId);
				vo.setWriterNo(writerNo);
				vo.setTitle(title);
				vo.setContent(content);
				vo.setEnrollDate(DateFormat.formattedDate(enrollDate));
				vo.setModifyDate(DateFormat.formattedDate(modifyDate));
				vo.setOpenYn(openYn);
				vo.setReadPermission(readPermission);
				vo.setWriterId(id);
				vo.setWriterNick(nick);
				vo.setCategoryName(categoryName);

				faqVoList.add(vo);
			}
			JDBCTemplate.close(rs);
			JDBCTemplate.close(pstmt);
			
			System.out.println("검색된 faqVoList :" + faqVoList);
			
			return faqVoList;
		}

}
