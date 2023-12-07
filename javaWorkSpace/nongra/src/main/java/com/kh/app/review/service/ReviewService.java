package com.kh.app.review.service;

import java.sql.Connection;
import java.util.List;

import com.kh.app.page.vo.PageVo;
import com.kh.app.review.dao.ReviewDao;
import com.kh.app.review.vo.ReviewVo;
import com.kh.app.util.db.JDBCTemplate;


public class ReviewService {

	//	관리자 모든 리뷰 페이지 조회 + 관리창
	public List<ReviewVo> manageReviewLookUp() throws Exception {
		
		// conn
		Connection conn = JDBCTemplate.getConnection();
		
		// dao
		ReviewDao dao = new ReviewDao();
		List<ReviewVo> list = dao.manageReviewLookUp(conn);
		// close 
		
		JDBCTemplate.close(conn);
		
		return list; 
		
	}



}
