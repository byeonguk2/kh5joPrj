package com.kh.app.category.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.kh.app.category.vo.CategoryVo;
import com.kh.app.util.db.JDBCTemplate;

public class CategoryDao {
	
	//카테고리 1조회
	public List<CategoryVo> categoryOneDao(Connection conn) throws Exception{
		
		String sql = "SELECT CATEGORY_NO , CATEGORY FROM CATEGORY WHERE CATEGORY_NO2 IS NULL";
		PreparedStatement pstmt = conn.prepareStatement(sql);
		ResultSet rs = pstmt.executeQuery();
		
		ArrayList<CategoryVo> categoryList = new ArrayList<CategoryVo>();
		while(rs.next()) {
			String categoryNo = rs.getString("CATEGORY_NO");
			String category = rs.getString("CATEGORY");
			
			CategoryVo vo = new CategoryVo();
			vo.setCategoryNo(categoryNo);
			vo.setCategory(category);
			
			categoryList.add(vo);
		}
		
		JDBCTemplate.close(rs);
		JDBCTemplate.close(pstmt);
		
		return categoryList;
	}
	//카테고리2 조회
	public List<CategoryVo> categoryTwoDao(Connection conn, String categoryNo1) throws Exception{
		String sql = "SELECT CATEGORY_NO , CATEGORY FROM CATEGORY WHERE CATEGORY_NO2 = ?";
		PreparedStatement pstmt = conn.prepareStatement(sql);
		pstmt.setString(1, categoryNo1);
		ResultSet rs = pstmt.executeQuery();
		
		ArrayList<CategoryVo> categoryList = new ArrayList<CategoryVo>();
		while(rs.next()) {
			String categoryNo = rs.getString("CATEGORY_NO");
			String category = rs.getString("CATEGORY");
			
			CategoryVo vo = new CategoryVo();
			vo.setCategoryNo(categoryNo);
			vo.setCategory(category);
			
			categoryList.add(vo);
		}

		JDBCTemplate.close(rs);
		JDBCTemplate.close(pstmt);
		
		return categoryList;
	}

}
