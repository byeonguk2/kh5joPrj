package com.kh.app.seller.note.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

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
	public List<SellerNoteVo> sendNoteSelectList(String sellerNo, Connection conn) throws Exception{
		
		String sql = "SELECT N.FROM_NO ,N.TO_NO ,N.TITLE ,N.CONTENT ,TO_CHAR(N.SEND_DATE , 'YY-MM-DD HH24:MI') AS SEND_DATE ,N.CHECK_YN ,M.ID AS TO_ID FROM NOTE N JOIN MEMBER M ON N.TO_NO = M.MEMBER_NO WHERE N.FROM_NO = ? AND N.FROM_DEL_YN = 'N' ORDER BY N.SEND_DATE DESC";
		PreparedStatement pstmt = conn.prepareStatement(sql);
		pstmt.setString(1, sellerNo);
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

}
