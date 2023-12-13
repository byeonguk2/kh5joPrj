package com.kh.app.home.service;

import java.sql.Connection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.kh.app.home.dao.HomeDao;
import com.kh.app.home.vo.SalesVo_v2;
import com.kh.app.sales.vo.SalesVo;
import com.kh.app.util.db.JDBCTemplate;

public class HomeService {

	public Map<String , Object>  selectItemList() throws Exception {
		
		// conn 
		Connection conn = JDBCTemplate.getConnection();
		
		HomeDao dao = new HomeDao();
		List<String> bestReviewNoList = dao.selectBestReviewCount(conn);
		List<String> bestOrderNoList = dao.selectBestOrderCount(conn);
		List<String> bestReviewLikeNoList = dao.selectBestReviewLikeCount(conn);
		
		// 리뷰 많은순
		List<SalesVo_v2> salesBestReviewVoList = dao.selectItemList(bestReviewNoList,conn);
		List<SalesVo_v2> salesBestOrderVoList = dao.selectItemList(bestOrderNoList,conn);
		List<SalesVo_v2> salesBestReviewLikeVoList = dao.selectItemList(bestReviewLikeNoList,conn);
		
		Map<String , Object> map = new HashMap<>();
		
		map.put("salesBestReviewVoList", salesBestReviewVoList);
		map.put("salesBestOrderVoList", salesBestOrderVoList);
		map.put("salesBestReviewLikeVoList", salesBestReviewLikeVoList);
		
		JDBCTemplate.close(conn);
		
		return map;
		
	}

	
	
}
