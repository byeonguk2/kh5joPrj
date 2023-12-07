package com.kh.app.seller.service;

import java.sql.Connection;
import java.util.List;

import com.kh.app.page.vo.PageVo;
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
	public List<SellerNoteVo> sendNoteSelectList(String memberNo, PageVo pvo) throws Exception{
		Connection conn = JDBCTemplate.getConnection();
		
		SellerNoteDao dao = new SellerNoteDao();
		
		List<SellerNoteVo> sendNoteList = dao.sendNoteSelectList(memberNo , pvo ,conn);
		
		JDBCTemplate.close(conn);
		
		return sendNoteList;
		
	}
	
	// 전체 쪽지 갯수 조회
	public int selectNoteCount() throws Exception{
		
		Connection conn = JDBCTemplate.getConnection();
		
		SellerNoteDao dao = new SellerNoteDao();
		int cnt = dao.selectNoteCount(conn);
		
		JDBCTemplate.close(conn);
		
		return cnt;
		
	}
	//받은 쪽지 목록
	public List<SellerNoteVo> reciveNoteSelectList(String memberNo, PageVo pvo) throws Exception{
		Connection conn = JDBCTemplate.getConnection();
		
		SellerNoteDao dao = new SellerNoteDao();
		
		List<SellerNoteVo> sendNoteList = dao.reciveNoteSelectList(memberNo , pvo ,conn);
		
		JDBCTemplate.close(conn);
		
		return sendNoteList;
	}
    // 쪽지 상세보기
    public SellerNoteVo noteDetail(String noteNo) throws Exception{
        Connection conn = JDBCTemplate.getConnection();
        
        SellerNoteDao dao = new SellerNoteDao();
        SellerNoteVo noteVo =dao.noteDetail(noteNo, conn);
        
        JDBCTemplate.close(conn);
        
        return noteVo;
        
    }
	
	
}
