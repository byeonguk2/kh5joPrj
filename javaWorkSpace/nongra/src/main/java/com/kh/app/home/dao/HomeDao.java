package com.kh.app.home.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.kh.app.sales.vo.SalesVo;
import com.kh.app.util.db.JDBCTemplate;

public class HomeDao {

	// 리뷰가 많은 상품번호 구해오기
	public List<String> selectBestReviewCount(Connection conn) throws Exception {
		
		String sql = "SELECT * FROM ( SELECT SR.SALES_NO, COUNT(R.REVIEW_NO) AS REVIEW_COUNT FROM MEMBER M JOIN CART C ON C.MEMBER_NO = M.MEMBER_NO JOIN CART_BREAKDOWN CB ON CB.CART_NO = C.NO JOIN SALES_REGISTR SR ON SR.SALES_NO = CB.SALES_NO JOIN SALES_OPTION SO ON SO.OPTION_NO = CB.OPTION_NO JOIN SELLER S ON S.SELLER_NO = SR.SELLER_NO JOIN ORDER_HISTORY OH ON C.NO = OH.CART_NO LEFT JOIN REVIEW R ON CB.NO = R.CART_BREAKDOWN_NO AND  C.END_YN = 'Y' GROUP BY SR.SALES_NO ORDER BY COUNT(R.REVIEW_NO) DESC ) WHERE ROWNUM <= 4";
		
		PreparedStatement pstmt = conn.prepareStatement(sql);
		ResultSet rs = pstmt.executeQuery();
		List<String> noList = noList = new ArrayList<>();
		while(rs.next()) {
			String str = rs.getString("SALES_NO");
			noList.add(str);
		}
		System.out.println("상품번호"+noList);
		
		JDBCTemplate.close(pstmt);
		JDBCTemplate.close(rs);
		
		return noList;
	}
	
	// 주문수가 많은 상품번호 구해오기
	public List<String> selectBestOrderCount(Connection conn) throws Exception {
		
		String sql = "SELECT * FROM ( SELECT SR.SALES_NO, COUNT(OH.CART_NO) AS ORDER_COUNT FROM MEMBER M JOIN CART C ON C.MEMBER_NO = M.MEMBER_NO JOIN CART_BREAKDOWN CB ON CB.CART_NO = C.NO JOIN SALES_REGISTR SR ON SR.SALES_NO = CB.SALES_NO JOIN SALES_OPTION SO ON SO.OPTION_NO = CB.OPTION_NO JOIN SELLER S ON S.SELLER_NO = SR.SELLER_NO JOIN ORDER_HISTORY OH ON C.NO = OH.CART_NO WHERE  C.END_YN = 'Y' GROUP BY SR.SALES_NO ORDER BY COUNT(OH.CART_NO) DESC )WHERE ROWNUM <= 4";
		
		PreparedStatement pstmt = conn.prepareStatement(sql);
		ResultSet rs = pstmt.executeQuery();
		List<String> noList = noList = new ArrayList<>();
		while(rs.next()) {
			String str = rs.getString("SALES_NO");
			noList.add(str);
		}
		System.out.println("상품번호"+noList);
		
		JDBCTemplate.close(pstmt);
		JDBCTemplate.close(rs);
		
		return noList;
	}
	
		// 리뷰 좋아요가 많은 상품번호 구해오기
		public List<String> selectBestReviewLikeCount(Connection conn) throws Exception {
			
			String sql = "SELECT * FROM (SELECT SR.SALES_NO, COUNT(RL.REVIEW_NO) FROM MEMBER M JOIN CART C ON C.MEMBER_NO = M.MEMBER_NO JOIN CART_BREAKDOWN CB ON CB.CART_NO = C.NO JOIN SALES_REGISTR SR ON SR.SALES_NO = CB.SALES_NO JOIN SALES_OPTION SO ON SO.OPTION_NO = CB.OPTION_NO JOIN SELLER S ON S.SELLER_NO = SR.SELLER_NO JOIN ORDER_HISTORY OH ON C.NO = OH.CART_NO LEFT JOIN REVIEW R ON CB.NO = R.CART_BREAKDOWN_NO LEFT JOIN REVIEW_LIKE RL ON R.REVIEW_NO = RL.REVIEW_NO GROUP BY SR.SALES_NO ORDER BY COUNT(RL.REVIEW_NO) DESC ) WHERE ROWNUM <= 4";
			
			PreparedStatement pstmt = conn.prepareStatement(sql);
			ResultSet rs = pstmt.executeQuery();
			List<String> noList = noList = new ArrayList<>();
			while(rs.next()) {
				String str = rs.getString("SALES_NO");
				noList.add(str);
			}
			System.out.println("상품번호"+noList);
			
			JDBCTemplate.close(pstmt);
			JDBCTemplate.close(rs);
			
			return noList;
		}

	// 
	public List<SalesVo> selectItemList(List<String> noList, Connection conn) throws Exception {
		
		// 해당하는 상품 구하기
		String sql = "SELECT SALES_NO, PRICE, THUMBNAIL, TITLE FROM SALES_REGISTR WHERE SALES_NO = ?";
		List<SalesVo> salesVoList = new ArrayList<SalesVo>();
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		
		for (String no : noList) {
			
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, no);
			
			rs = pstmt.executeQuery();
			
			while(rs.next()) {
				
				String salesNo = rs.getString(1);
				String price = rs.getString(2);
				String thumbnail = rs.getString(3);
				String title = rs.getString(4);
				
				SalesVo vo = new SalesVo();
				vo.setSalesNo(salesNo);
				vo.setPrice(price);
				vo.setTitle(title);
				vo.setFileName(thumbnail);
				
				salesVoList.add(vo);
				
			}
			
		}
		
		JDBCTemplate.close(pstmt);
		JDBCTemplate.close(rs);
		
		return salesVoList;
	}

}
