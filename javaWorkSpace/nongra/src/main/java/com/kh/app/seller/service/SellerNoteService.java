package com.kh.app.seller.service;

import java.sql.Connection;
import java.util.List;

import com.kh.app.seller.note.dao.SellerNoteDao;
import com.kh.app.seller.vo.SellerNoteVo;
import com.kh.app.util.db.JDBCTemplate;

public class SellerNoteService {
	
	//쪽지작성
	public int noteWrite(SellerNoteVo snv) throws Exception{
		Connection conn = JDBCTemplate.getConnection();
		SellerNoteDao dao = new SellerNoteDao();
		int result = dao.noteWrite(snv, conn);
		
		if(result == 1) {
			JDBCTemplate.commit(conn);
		}else {
			JDBCTemplate.rollback(conn);
		}
		JDBCTemplate.close(conn);
		
		return result;
		
	}
	//보낸쪽지 목록
	public List<SellerNoteVo> sendNoteSelectList(String sellerNo) throws Exception{
		Connection conn = JDBCTemplate.getConnection();
		
		SellerNoteDao dao = new SellerNoteDao();
		
		List<SellerNoteVo> sendNoteList = dao.sendNoteSelectList(sellerNo , conn);
		
		JDBCTemplate.close(conn);
		
		return sendNoteList;
		
	}

}
