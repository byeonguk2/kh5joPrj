package com.kh.app.review.service;

import java.sql.Connection;
import java.util.List;
import java.util.Map;

import com.kh.app.page.vo.PageVo;
import com.kh.app.review.dao.ReviewDao;
import com.kh.app.review.vo.ReviewVo;
import com.kh.app.util.db.JDBCTemplate;


public class ReviewService {

	//	관리자 모든 리뷰 페이지 조회 + 관리창
	public List<ReviewVo> manageReviewLookUp(PageVo pvo) throws Exception {
		
		
		
		// conn
		Connection conn = JDBCTemplate.getConnection();
		
		// dao
		ReviewDao dao = new ReviewDao();
		List<ReviewVo> list = dao.manageReviewLookUp(conn,pvo);
		// close 
		
		JDBCTemplate.close(conn);
		
		return list; 
		
	}
	// 번호 받아서 리뷰 삭제 (관리자)
	public int adminManagerReviewDelete(String deleteNo) throws Exception {


		// conn
		Connection conn = JDBCTemplate.getConnection();
				
		// dao
		ReviewDao dao = new ReviewDao();
		int result = dao.adminManagerReviewDelete(conn,deleteNo);
		
		if(result ==1 ) {
			JDBCTemplate.commit(conn);
		}else {
			JDBCTemplate.rollback(conn);
		}
		
		// close 
		
		JDBCTemplate.close(conn);
		
		return result; 

	}
	// 리뷰 페이지 전체 갯수 조회
	public int selectReviewCount() throws Exception {
		
		// conn
		Connection conn = JDBCTemplate.getConnection();
		
		// dao
		ReviewDao dao = new ReviewDao();
		int cnt = dao.selectReviewCount(conn);
		
		// close
		JDBCTemplate.close(conn);
		
		return cnt;

	}
	// 리뷰 검색 페이지 갯수 조회
	public int selectSearchBoardCount(Map<String, String> m) throws Exception {
		
		// conn
		Connection conn = JDBCTemplate.getConnection();
		
		// dao
		ReviewDao dao = new ReviewDao();
		int cnt = dao.selectReviewCount(conn,m);
		
		// close
		JDBCTemplate.close(conn);
		
		return cnt;
	}
	// 리뷰 검색 관리자
	public List<ReviewVo> adminsearch(Map<String, String> m, PageVo pvo) throws Exception {
		
		// conn
		Connection conn = JDBCTemplate.getConnection();
		
		// dao
		ReviewDao dao = new ReviewDao();
		List<ReviewVo> list = dao.adminsearch(conn,m,pvo);
		// close 
			
		JDBCTemplate.close(conn);
			
		return list; 
}
	
	//리뷰관리 갯수 회원번호 기준 [유저]
	public int selectReviewCountByMemberNo(String memberNo) throws Exception {
			
		
		// conn
		Connection conn = JDBCTemplate.getConnection();
				
		// dao
		ReviewDao dao = new ReviewDao();
		int cnt = dao.selectReviewCountByMemberNo(conn,memberNo);
		
		// close
		JDBCTemplate.close(conn);
		
		return cnt;
	
	
	}
	
	//리뷰 관리 회원번호로 가져오기 [유저]
	public List<ReviewVo> memberReviewLookUp(PageVo pvo, String memberNo) throws Exception {
		
		// conn
		Connection conn = JDBCTemplate.getConnection();
				
		// dao
		ReviewDao dao = new ReviewDao();
		List<ReviewVo> list = dao.memberReviewLookUp(conn,pvo,memberNo);
		// close 
				
		JDBCTemplate.close(conn);
		
		return list; 
	
	}
	

	



}
