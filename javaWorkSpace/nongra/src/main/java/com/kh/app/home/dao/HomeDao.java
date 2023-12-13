package com.kh.app.home.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.kh.app.home.vo.OptionVo_v2;
import com.kh.app.home.vo.SalesVo_v2;
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
	public List<SalesVo_v2> selectItemList(List<String> noList, Connection conn) throws Exception {
		
		// 해당하는 상품 구하기
		String sql = "SELECT SR.SALES_NO, SR.PRICE, SR.THUMBNAIL, SR.TITLE, SO.OPTION_NO, SO.OPTION_NAME, SO.OPTION_PRICE FROM SALES_REGISTR SR JOIN SALES_OPTION SO ON SR.SALES_NO = SO.SALES_NO WHERE SR.SALES_NO = ?";
		
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		List<SalesVo_v2> salesVoList = new ArrayList<SalesVo_v2>();
		List<SalesVo_v2> result = null;
		
		for (String no : noList) {
			
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, no);
			
			rs = pstmt.executeQuery();
			
			while(rs.next()) {
				
				// 데이터 받아오기
				String salesNo = rs.getString("SALES_NO");
				String price = rs.getString("PRICE");
				String thumbnail = rs.getString("THUMBNAIL");
				String title = rs.getString("TITLE");
				String optionNo = rs.getString("OPTION_NO");
				String optionName = rs.getString("OPTION_NAME");
				String optionPrice = rs.getString("OPTION_PRICE");
				
				SalesVo_v2 SalesVo = new SalesVo_v2(salesNo, title, thumbnail, price, optionNo, salesNo, optionPrice, optionName);
				
				// 이객체에 모든 데이터들을 다 받았을 것이다.
				salesVoList.add(SalesVo);
				
			}
			
			// 맵 생성
			Map<String,SalesVo_v2> map = new HashMap<String,SalesVo_v2>();
			for(SalesVo_v2 salesVo : salesVoList) {
				// 키값을 상품번호로 두고 밸류로 상품vo를 가진다.
				map.put(salesVo.getSalesNo() , salesVo);
			}
			
			for(SalesVo_v2 salesVo : salesVoList) {
				
				// 옵션값들만 따로 저장
				String optionNo = salesVo.getOptionNo();
				String optionName = salesVo.getOptionName();
				String optionPrice = salesVo.getOptionPrice();
				String refNo = salesVo.getRefNo();
				
				OptionVo_v2 optionVo = new OptionVo_v2(optionNo, refNo, optionPrice, optionName);
				SalesVo_v2 target = map.get(optionVo.getRefNo());
				target.getOptionVo().add(optionVo);
				
			}
			
			result = new ArrayList(map.values());
			
			for(SalesVo_v2 salesVo : result) {
				List<OptionVo_v2> optionList = salesVo.getOptionVo();
				for(OptionVo_v2 optionVo : optionList) {
					salesVo.setOpVo(optionVo);
				}
			}
			
		}
		
		JDBCTemplate.close(pstmt);
		JDBCTemplate.close(rs);
		
		System.out.println(result);
		
		return result;
	}

}
