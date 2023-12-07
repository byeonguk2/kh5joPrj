package com.kh.app.seller.note.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.kh.app.page.vo.PageVo;
import com.kh.app.seller.vo.SellerNoteVo;
import com.kh.app.util.db.JDBCTemplate;

public class SellerNoteDao {
	
	//쪽지작성
	public int noteWrite(SellerNoteVo snv, Connection conn) throws Exception{
		
		String sql = "INSERT INTO NOTE(NOTE_NO, FROM_NO, TO_NO, TITLE, CONTENT)VALUES (SEQ_NOTE_NO.NEXTVAL, ?, (SELECT MEMBER_NO FROM MEMBER WHERE ID = ? AND NOT ID = ?), ? ,?)";
		PreparedStatement pstmt = conn.prepareStatement(sql);
		pstmt.setString(1, snv.getFromNo());
		pstmt.setString(2, snv.getToId());
		pstmt.setString(3, snv.getFromId());
		pstmt.setString(4, snv.getTitle());
		pstmt.setString(5, snv.getContent());
		
		int result = pstmt.executeUpdate();
		
		JDBCTemplate.close(pstmt);
		
		return result;
		
	}
	//보낸 쪽지 목록 
	public List<SellerNoteVo> sendNoteSelectList(String memberNo, PageVo pvo, Connection conn) throws Exception{
		
        String sql = "SELECT * FROM (SELECT ROWNUM RNUM, T.* FROM ( SELECT N.NOTE_NO ,N.FROM_NO ,N.TO_NO ,N.TITLE ,N.CONTENT ,TO_CHAR(N.SEND_DATE , 'YY-MM-DD HH24-MI') AS SEND_DATE ,N.CHECK_YN ,M.ID AS TO_ID FROM NOTE N JOIN MEMBER M ON N.TO_NO = M.MEMBER_NO WHERE N.FROM_NO = ? AND N.FROM_DEL_YN = 'N' ORDER BY N.SEND_DATE DESC )T) WHERE RNUM BETWEEN ? AND ?";
		PreparedStatement pstmt = conn.prepareStatement(sql);
		pstmt.setString(1, memberNo);
		pstmt.setInt(2, pvo.getStartRow());
		pstmt.setInt(3, pvo.getLastRow());
		ResultSet rs = pstmt.executeQuery();
		
		
		List<SellerNoteVo> sendNoteList = new ArrayList<SellerNoteVo>();
		while(rs.next()) {
            String noteNo = rs.getString("NOTE_NO");
			String fromNo = rs.getString("FROM_NO");
			String toId = rs.getString("TO_ID");
			String title = rs.getString("TITLE");
			String content = rs.getString("CONTENT");
			String sendDate = rs.getString("SEND_DATE");
			String checkYn = rs.getString("CHECK_YN");
			String toNo = rs.getString("TO_NO");
			
			SellerNoteVo snv = new SellerNoteVo();
            snv.setNoteNo(noteNo);
			snv.setFromNo(fromNo);
			snv.setToId(toId);
			snv.setTitle(title);
			snv.setContent(content);
			snv.setSendDate(sendDate);
			snv.setCheckDate(checkYn);
			snv.setToNo(toNo);
			
			sendNoteList.add(snv);
		}
		
		
		JDBCTemplate.close(rs);
		JDBCTemplate.close(pstmt);
		
		return sendNoteList;
	}
	
	//전체 쪽지 갯수 조회
	public int selectNoteCount(Connection conn) throws Exception{
		
		String sql = "SELECT COUNT(*) AS CNT FROM NOTE WHERE FROM_DEL_YN = 'N'";
		PreparedStatement pstmt = conn.prepareStatement(sql);
		
		ResultSet rs = pstmt.executeQuery();
		
		int cnt = 0;
		if(rs.next()) {
			cnt = rs.getInt(1);
		}
		
		JDBCTemplate.close(rs);
		JDBCTemplate.close(pstmt);
		
		return cnt;
	}
	// 받은 쪽지 목록 
	public List<SellerNoteVo> reciveNoteSelectList(String memberNo, PageVo pvo, Connection conn) throws Exception{
        String sql = "SELECT * FROM (SELECT ROWNUM RNUM, T.* FROM ( SELECT N.NOTE_NO ,N.FROM_NO ,N.TO_NO ,N.TITLE ,N.CONTENT ,TO_CHAR(N.SEND_DATE , 'YY-MM-DD HH24-MI') AS SEND_DATE ,N.CHECK_YN ,M.ID AS TO_ID FROM NOTE N JOIN MEMBER M ON N.TO_NO = M.MEMBER_NO WHERE N.TO_NO = ? AND N.FROM_DEL_YN = 'N' ORDER BY N.SEND_DATE DESC )T) WHERE RNUM BETWEEN ? AND ?";
		PreparedStatement pstmt = conn.prepareStatement(sql);
		pstmt.setString(1, memberNo);
		pstmt.setInt(2, pvo.getStartRow());
		pstmt.setInt(3, pvo.getLastRow());
		ResultSet rs = pstmt.executeQuery();
		
		
		List<SellerNoteVo> sendNoteList = new ArrayList<SellerNoteVo>();
		while(rs.next()) {
			String fromNo = rs.getString("FROM_NO");
			String toId = rs.getString("TO_ID");
			String title = rs.getString("TITLE");
			String content = rs.getString("CONTENT");
			String sendDate = rs.getString("SEND_DATE");
			String checkYn = rs.getString("CHECK_YN");
			String toNo = rs.getString("TO_NO");
			
			SellerNoteVo snv = new SellerNoteVo();
			snv.setFromNo(fromNo);
			snv.setToId(toId);
			snv.setTitle(title);
			snv.setContent(content);
			snv.setSendDate(sendDate);
			snv.setCheckDate(checkYn);
			snv.setToNo(toNo);
			
			sendNoteList.add(snv);
		}
		
		
		JDBCTemplate.close(rs);
		JDBCTemplate.close(pstmt);
		
		return sendNoteList;
	}
    //쪽지 상세보기
    public SellerNoteVo noteDetail(String noteNo, Connection conn) throws Exception{
        
        String sql = " SELECT N.NOTE_NO , N.FROM_NO ,N.TO_NO ,N.TITLE ,N.CONTENT ,TO_CHAR(N.SEND_DATE , 'YY-MM-DD HH24-MI') AS SEND_DATE ,N.CHECK_YN ,M.ID AS TO_ID FROM NOTE N JOIN MEMBER M ON N.TO_NO = M.MEMBER_NO WHERE N.NOTE_NO = ? AND N.FROM_DEL_YN = 'N'";
        PreparedStatement pstmt = conn.prepareStatement(sql);
        pstmt.setString(1, noteNo);
        ResultSet rs = pstmt.executeQuery();
        
        SellerNoteVo noteVo = null;
        if(rs.next()) {
            String fromNo = rs.getString("FROM_NO");
            String toId = rs.getString("TO_ID");
            String title = rs.getString("TITLE");
            String content = rs.getString("CONTENT");
            String sendDate = rs.getString("SEND_DATE");
            String checkYn = rs.getString("CHECK_YN");
            String toNo = rs.getString("TO_NO");
            
            noteVo = new SellerNoteVo();
            noteVo.setFromNo(fromNo);
            noteVo.setToId(toId);
            noteVo.setTitle(title);
            noteVo.setContent(content);
            noteVo.setSendDate(sendDate);
            noteVo.setCheckDate(checkYn);
            noteVo.setToNo(toNo);
        }
        
        JDBCTemplate.close(rs);
        JDBCTemplate.close(pstmt);
        
        return noteVo;
    }

}
