package com.kh.app.sales.service;

import java.sql.Connection;
import java.util.List;

import com.kh.app.option.vo.OptionVo;
import com.kh.app.sales.dao.SalesDao;
import com.kh.app.sales.vo.SalesVo;
import com.kh.app.util.db.JDBCTemplate;

public class SalesService {
	
	//상품 목록 조회
	public List<SalesVo> salesListSelect() throws Exception{
		
		Connection conn = JDBCTemplate.getConnection();
		
		SalesDao sd = new SalesDao();
		List<SalesVo> salesVoList = sd.salesListSelect(conn);
		
		return salesVoList;
	}
	// 상품 등록
	public int salesRegister(SalesVo vo, List<String> fileNameList, List<OptionVo> optionVoList) throws Exception{
		Connection conn = JDBCTemplate.getConnection();
		SalesDao dao = new SalesDao();
		int result = dao.salesRegister(conn , vo , fileNameList , optionVoList);
		
		if(result == 1) {
			JDBCTemplate.commit(conn);
		}else {
			JDBCTemplate.rollback(conn);
		}
		
		JDBCTemplate.close(conn);
		
		return result;
	}
	// 카테고리 별 상품 조회
	public List<SalesVo> salesCategoryNoSelect(String categoryNo) throws Exception{
		Connection conn = JDBCTemplate.getConnection();
		
		SalesDao sd = new SalesDao();
		List<SalesVo> salesVoList = sd.salesCategoryNoSelect(conn , categoryNo);
		
		return salesVoList;
	}
	// 카테고리 별 상품 갯수
	public int selectSalesCount(String categoryNo) throws Exception{
		Connection conn = JDBCTemplate.getConnection();
		
		SalesDao sd = new SalesDao();
		int result = sd.selectSalesCount(conn , categoryNo);
		
		return result;
	}
	public int selectSalesAllCount() throws Exception{
		Connection conn = JDBCTemplate.getConnection();
		
		SalesDao sd = new SalesDao();
		int result = sd.selectSalesAllCount(conn );
		
		return result;
	}
	// 상품 상세보기
	public List<SalesVo> selectSalesDetail() throws Exception{
		Connection conn = JDBCTemplate.getConnection();
		
		SalesDao dao = new SalesDao();
		List<SalesVo> salesVoList = dao.selectSalesDetail();
		
		return salesVoList;
		
	}

}
