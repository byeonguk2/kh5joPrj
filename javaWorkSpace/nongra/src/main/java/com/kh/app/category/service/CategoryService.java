package com.kh.app.category.service;

import java.sql.Connection;
import java.util.List;

import com.kh.app.category.dao.CategoryDao;
import com.kh.app.category.vo.CategoryVo;
import com.kh.app.util.db.JDBCTemplate;

public class CategoryService {
	
	
	//카테고리1 조회
	public List<CategoryVo> categoryOneList() throws Exception{
		
		Connection conn = JDBCTemplate.getConnection();
		
		CategoryDao dao = new CategoryDao();
		
		List<CategoryVo> categoryList = dao.categoryOneDao(conn);
		
		JDBCTemplate.close(conn);
		
		return categoryList;
		
	}
	//카테고리2 조회
	public List<CategoryVo> categoryTwoList(String categoryNo1) throws Exception{
		
		Connection conn = JDBCTemplate.getConnection();
		
		CategoryDao dao = new CategoryDao();
		
		List<CategoryVo> categoryList = dao.categoryTwoDao(conn , categoryNo1);
		
		JDBCTemplate.close(conn);
		
		return categoryList;
	}

}
