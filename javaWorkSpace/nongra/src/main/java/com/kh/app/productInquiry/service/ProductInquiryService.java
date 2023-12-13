package com.kh.app.productInquiry.service;

import java.sql.Connection;
import java.util.List;

import com.kh.app.page.vo.PageVo;
import com.kh.app.productInquiry.dao.ProductInquiryDao;
import com.kh.app.productInquiry.vo.ProductInquiryVo;
import com.kh.app.review.dao.ReviewDao;
import com.kh.app.review.vo.ReviewVo;
import com.kh.app.util.db.JDBCTemplate;

public class ProductInquiryService {
	// 유저 번호 기준으로 상품문의 갯수 가져오기 [멤버]
	public int selectInquiryCountByMemberNo(String memberNo) throws Exception {
		
		// conn
		Connection conn = JDBCTemplate.getConnection();
						
		// dao
		ProductInquiryDao dao = new ProductInquiryDao();
		int cnt = dao.selectInquiryCountByMemberNo(conn,memberNo);
		
		// close
		JDBCTemplate.close(conn);
		
		return cnt;
	}
	// 유저 번호 기준으로 상품문의 가져오기 [멤버]
	public List<ProductInquiryVo> memberInquiryLookUp(PageVo pvo, String memberNo) throws Exception {
		
		// conn
		Connection conn = JDBCTemplate.getConnection();
				
		// dao
		ProductInquiryDao dao = new ProductInquiryDao();
		List<ProductInquiryVo> list = dao.memberInquiryLookUp(conn,pvo,memberNo);
		// close 
				
		JDBCTemplate.close(conn);
		
		return list; 
		
	}
	
	// 셀러 번호 기준으로 상품문의 갯수 가져오기 [셀러]
	public int selectInquiryCountBySellerNo(String sellerNO) throws Exception {
		// conn
		Connection conn = JDBCTemplate.getConnection();
						
		// dao
		ProductInquiryDao dao = new ProductInquiryDao();
		int cnt = dao.selectInquiryCountBySellerNo(conn,sellerNO);
		
		// close
		JDBCTemplate.close(conn);
		
		return cnt;
	}
	// 판매자 번호 기준으로 상품문의 가져오기 [셀러]
	public List<ProductInquiryVo> sellerInquiryLookUp(PageVo pvo, String sellerNO)throws Exception {
		// conn
		Connection conn = JDBCTemplate.getConnection();
				
		// dao
		ProductInquiryDao dao = new ProductInquiryDao();
		List<ProductInquiryVo> list = dao.sellerInquiryLookUp(conn,pvo,sellerNO);
		// close 
				
		JDBCTemplate.close(conn);
		
		return list; 
		
	}
	// 상품번호 기준으로 문의 개수 가져오기[전체]
	public int selectInquiryCountByItemNo(String saleNo, String memberNo) throws Exception {
		// conn
		Connection conn = JDBCTemplate.getConnection();
						
		// dao
		ProductInquiryDao dao = new ProductInquiryDao();
		int cnt = dao.selectInquiryCountByItemNo(conn,saleNo,memberNo);
		
		// close
		JDBCTemplate.close(conn);
		
		return cnt;
	}
	// 상품 번호 기준으로 문의 리스트 가져오기[전체]
	public List<ProductInquiryVo> memberInquiryShow(PageVo pvo, String saleNo, String memberNo) throws Exception {
		// conn
		Connection conn = JDBCTemplate.getConnection();
				
		// dao
		ProductInquiryDao dao = new ProductInquiryDao();
		List<ProductInquiryVo> list = dao.sellerInquiryLookUp(conn,pvo,saleNo,memberNo);
		// close 
				
		JDBCTemplate.close(conn);
		
		return list; 
				
		}		
	}
	



