package com.kh.app.sales.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.kh.app.sails.vo.SalesVo;
import com.kh.app.util.db.JDBCTemplate;

public class SalesDao {
	
	//상품 목록 조회
	public List<SalesVo> salesListSelect(Connection conn) throws Exception{
		String sql = "SELECT R.SALES_NO ,R.SELLER_NO ,R.TITLE ,R.CONTENT ,R.PRICE ,R.STATUS ,R.ENROLL_DATE ,M.NICK AS MEMBER_NICK ,M.NAME AS MEMBER_NAME ,C.CATEGORY ,C.CATEGORY_NO ,C.CATEGORY_NO2 ,F.FILE_NAME FROM SALES_REGISTR R JOIN SALES_FILE F ON R.SALES_NO = F.SALES_NO JOIN CATEGORY C ON R.CATEGORY_NO = C.CATEGORY_NO JOIN SELLER S ON R.SELLER_NO = S.SELLER_NO JOIN MEMBER M ON S.MEMBER_NO = M.MEMBER_NO WHERE R.DEL_YN = 'N' AND R.STATUS = '판매중' ORDER BY R.ENROLL_DATE DESC";
		PreparedStatement pstmt = conn.prepareStatement(sql);
		ResultSet rs = pstmt.executeQuery();
		
		List<SalesVo> salesVoList = new ArrayList<SalesVo>();
		while(rs.next()) {
			String salesNo = rs.getString("SALES_NO");
			String sellerNo = rs.getString("SELLER_NO");
			String title = rs.getString("TITLE");
			String content = rs.getString("CONTENT");
			String price = rs.getString("PRICE");
			String status = rs.getString("STATUS");
			String enrollDate = rs.getString("ENROLL_DATE");
			String memberNick = rs.getString("MEMBER_NICK");
			String memberName = rs.getString("MEMBER_NAME");
			String category = rs.getString("CATEGORY");
			String categoryNo = rs.getString("CATEGORY_NO");
			String categoryNo2 = rs.getString("CATEGORY_NO2");
			String fileName = rs.getString("FILE_NAME");
			
			SalesVo sv = new SalesVo();
			sv.setSalesNo(salesNo);
			sv.setSellerNo(sellerNo);
			sv.setTitle(title);
			sv.setContent(content);
			sv.setPrice(price);
			sv.setStatus(status);
			sv.setEnrollDate(enrollDate);
			sv.setMemberNick(memberNick);
			sv.setMemberName(memberName);
			sv.setCategory(category);
			sv.setCategoryNo(categoryNo);
			sv.setCategoryNo2(categoryNo2);
			sv.setFileName(fileName);
			
			salesVoList.add(sv);
		}
		
		
		JDBCTemplate.close(rs);
		JDBCTemplate.close(pstmt);
		
		return salesVoList;
		
	}

}
