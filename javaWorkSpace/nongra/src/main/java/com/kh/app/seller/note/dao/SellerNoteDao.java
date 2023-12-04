package com.kh.app.seller.note.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
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
		
		String sql = "SELECT * FROM NOTE WHERE FROM_NO = ? AND FROM_DEL_YN = 'N' ORDER BY SEND_DATE DESC";
		PreparedStatement pstmt = conn.prepareStatement(sql);
		pstmt.setString(1, sellerNo);
		
		
		
		
		
		return null;
	}

}
