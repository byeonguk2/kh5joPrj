package com.kh.app.productInquiry.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import com.kh.app.page.vo.PageVo;
import com.kh.app.productInquiry.vo.ProductInquiryVo;
import com.kh.app.review.vo.ReviewVo;
import com.kh.app.util.db.JDBCTemplate;

public class ProductInquiryDao {
	
	// 유저 번호 기준으로 상품문의 갯수 가져오기 [멤버]
	public int selectInquiryCountByMemberNo(Connection conn, String memberNo) throws SQLException {

		 //SQL
		  String sql = "SELECT COUNT(*) FROM INQUIRE I JOIN MEMBER M ON M.MEMBER_NO  = I.CONSUMER_NO WHERE   I.DEL_YN ='N' AND M.MEMBER_NO = ? ORDER BY I.INQUIRE_NO DESC";
		  PreparedStatement pstmt = conn.prepareStatement(sql);
	      pstmt.setString(1, memberNo);
	      
	      ResultSet rs = pstmt.executeQuery();
	      
	      //rs
	      int cnt = 0;
	      if(rs.next()) {
	         cnt = rs.getInt(1); //첫번째 열을 가져오겠다 라는 뜻, 계산에 써야되기 때문에 String이 아닌 Int로 받아줌
	      }
	      
	      //close
	      JDBCTemplate.close(rs);
	      JDBCTemplate.close(pstmt);
	      
	     
	      return cnt;
	      
	
	}
	// 유저 번호 기준으로 상품문의 가져오기 [멤버]
	public List<ProductInquiryVo> memberInquiryLookUp(Connection conn, PageVo pvo, String memberNo) throws Exception {
		
		//sql
		
		String sql = "SELECT I.INQUIRE_NO ,I.CONSUMER_NO ,I.SALES_NO , I.CONTENT ,I.ENROLL_DATE ,I.DEL_YN ,I.INQUIRE_REPLY , I.SECRET_YN ,I.INQUIRE_REPLY_ENROLL_DATE ,I.REPLY_UPDATE_DATE ,I.REPLY_DEL_YN ,IF.INQUIRE_FILE ,IF.FILE_SRC ,SR.TITLE ,S.SELLER_NO ,BUSINESS_NAME ,M.NAME FROM INQUIRE I LEFT JOIN INQUIRE_FILE IF ON I.INQUIRE_NO = IF.INQUIRE_NO JOIN SALES_REGISTR SR ON I.SALES_NO = SR.SALES_NO JOIN SELLER S  ON S.SELLER_NO = SR.SELLER_NO JOIN MEMBER M ON M.MEMBER_NO  = I.CONSUMER_NO WHERE I.DEL_YN = 'N' AND I.CONSUMER_NO = ? ORDER BY I.INQUIRE_NO DESC";
		PreparedStatement pstmt = conn.prepareStatement(sql);
		pstmt.setString(1, memberNo);
		System.out.println("sql문 성공");
		
		
		
		//rs
		ResultSet rs = pstmt.executeQuery();
		
		//list
		List<ProductInquiryVo> list = new ArrayList<ProductInquiryVo>();
		
		while(rs.next()) {
			
			while(rs.next()) {
				
				ProductInquiryVo vo = new ProductInquiryVo();
				
				 String inquireNo  		=rs.getString("INQUIRE_NO");
				 String consumerNo 		=rs.getString("CONSUMER_NO");
				 String salesNo    		=rs.getString("SALES_NO"); 
				 String content    		=rs.getString("CONTENT");
	 			 String enrollDate 		=rs.getString("ENROLL_DATE");
				 String  delYn      	=rs.getString("DEL_YN");
				 String  inquireReply  	=rs.getString("INQUIRE_REPLY");
				 String  secretYn 		=rs.getString("SECRET_YN");
				 String  sellerNo 		=rs.getString("SELLER_NO");
				 String  itemtitle 		=rs.getString("TITLE");
				 String  businessName	=rs.getString("BUSINESS_NAME");
				 String  userName    	=rs.getString("NAME");
				String 	 inquireReplyEnrollDate = rs.getString("INQUIRE_REPLY_ENROLL_DATE");
				String 	 replyUpdateDate	=rs.getString("REPLY_UPDATE_DATE");
				String 	 replyDelYn			=rs.getString("REPLY_DEL_YN");
				 
				 
				 String fileSrc = rs.getString("FILE_SRC");
				 String INQUIREFile = rs.getString("INQUIRE_FILE");
				 
				 vo.getProductInquriyFileVo().setFileSrc(fileSrc);
				 vo.getProductInquriyFileVo().setInquireFile(INQUIREFile);
				 
				vo.setReplyEnrollDate(inquireReplyEnrollDate);
				vo.setReplyUpdateDate(replyUpdateDate);
				vo.setReplyDelYn(replyDelYn);
				vo.setInquireNo(inquireNo);
				vo.setConsumerNo(consumerNo);
				vo.setSalesNo(salesNo);
				vo.setContent(content);
				vo.setEnrollDate(enrollDate);
				vo.setDelYn(delYn);
				vo.setInquireReply(inquireReply);
				vo.setSecretYn(secretYn);
				vo.setSellerNo(sellerNo);
				vo.setItemtitle(itemtitle);
				vo.setBusinessName(businessName);
				vo.setUserName(userName);
				 
				 list.add(vo);
			}
		}
		
		
		
		
		
		Map tempmap = new LinkedHashMap<String, ProductInquiryVo >();
		for (ProductInquiryVo productInquiryVo : list) {
			tempmap.put(productInquiryVo.getInquireNo(), productInquiryVo );
		}
				
		for (ProductInquiryVo productInquiryVo : list) {
			ProductInquiryVo targetVo = (ProductInquiryVo)tempmap.get(productInquiryVo.getInquireNo());
				targetVo.getList().add(productInquiryVo.getProductInquriyFileVo());
		}
		
		
		
			
		ArrayList<ProductInquiryVo> ProductInquiryVoList = new ArrayList<ProductInquiryVo>(tempmap.values());
		
		if(ProductInquiryVoList.size()<pvo.getLastRow()) {
			pvo.setLastRow(ProductInquiryVoList.size());
		}
		
		ArrayList<ProductInquiryVo> ProductInquiryresult = new ArrayList<ProductInquiryVo> ();
		
		for(int i = pvo.getStartRow()-1; i<pvo.getLastRow(); i++) {
			ProductInquiryresult.add(ProductInquiryVoList.get(i));
		}
			
		//close
		JDBCTemplate.close(rs);
		JDBCTemplate.close(pstmt);
			
		return ProductInquiryVoList;
		
	}

	// 셀러 번호 기준으로 상품문의 갯수 가져오기 [셀러]
	public int selectInquiryCountBySellerNo(Connection conn, String sellerNO) throws SQLException {

		 //SQL
		  String sql = "SELECT COUNT(*) FROM INQUIRE I JOIN SALES_REGISTR SR ON I.SALES_NO = SR.SALES_NO JOIN SELLER S  ON S.SELLER_NO = SR.SELLER_NO WHERE  I.DEL_YN ='N' AND S.SELLER_NO = ? ORDER BY I.INQUIRE_NO DESC";
		  PreparedStatement pstmt = conn.prepareStatement(sql);
	      pstmt.setString(1, sellerNO);
	      
	      ResultSet rs = pstmt.executeQuery();
	      
	      //rs
	      int cnt = 0;
	      if(rs.next()) {
	         cnt = rs.getInt(1); //첫번째 열을 가져오겠다 라는 뜻, 계산에 써야되기 때문에 String이 아닌 Int로 받아줌
	      }
	      
	      //close
	      JDBCTemplate.close(rs);
	      JDBCTemplate.close(pstmt);
	      
	     
	      return cnt;	
	}
	// 판매자 번호 기준으로 상품문의 가져오기 [셀러]

	public List<ProductInquiryVo> sellerInquiryLookUp(Connection conn, PageVo pvo, String sellerNo1) throws Exception {
				
				//sql
				String sql = "SELECT I.INQUIRE_NO ,I.CONSUMER_NO ,I.SALES_NO , I.CONTENT ,I.ENROLL_DATE ,I.DEL_YN ,I.INQUIRE_REPLY , I.SECRET_YN ,I.INQUIRE_REPLY_ENROLL_DATE ,I.REPLY_UPDATE_DATE ,I.REPLY_DEL_YN ,IF.INQUIRE_FILE ,IF.FILE_SRC ,SR.TITLE ,S.SELLER_NO ,BUSINESS_NAME ,M.NAME FROM INQUIRE I LEFT JOIN INQUIRE_FILE IF ON I.INQUIRE_NO = IF.INQUIRE_NO JOIN SALES_REGISTR SR ON I.SALES_NO = SR.SALES_NO JOIN SELLER S  ON S.SELLER_NO = SR.SELLER_NO JOIN MEMBER M ON M.MEMBER_NO  = I.CONSUMER_NO WHERE I.DEL_YN = 'N' AND SR.SELLER_NO = ? ORDER BY I.INQUIRE_NO DESC";
				PreparedStatement pstmt = conn.prepareStatement(sql);
				pstmt.setString(1, sellerNo1);
				System.out.println("sql문 성공");
				
				
				
				//rs
				ResultSet rs = pstmt.executeQuery();
				
				//list
				List<ProductInquiryVo> list = new ArrayList<ProductInquiryVo>();
				
				while(rs.next()) {
					
					ProductInquiryVo vo = new ProductInquiryVo();
					
					 String inquireNo  		=rs.getString("INQUIRE_NO");
					 String consumerNo 		=rs.getString("CONSUMER_NO");
					 String salesNo    		=rs.getString("SALES_NO"); 
					 String content    		=rs.getString("CONTENT");
		 			 String enrollDate 		=rs.getString("ENROLL_DATE");
					 String  delYn      	=rs.getString("DEL_YN");
					 String  inquireReply  	=rs.getString("INQUIRE_REPLY");
					 String  secretYn 		=rs.getString("SECRET_YN");
					 String  sellerNo 		=rs.getString("SELLER_NO");
					 String  itemtitle 		=rs.getString("TITLE");
					 String  businessName	=rs.getString("BUSINESS_NAME");
					 String  userName    	=rs.getString("NAME");
					String 	 inquireReplyEnrollDate = rs.getString("INQUIRE_REPLY_ENROLL_DATE");
					String 	 replyUpdateDate	=rs.getString("REPLY_UPDATE_DATE");
					String 	 replyDelYn			=rs.getString("REPLY_DEL_YN");
					 
					 
					 String fileSrc = rs.getString("FILE_SRC");
					 String INQUIREFile = rs.getString("INQUIRE_FILE");
					 
					 vo.getProductInquriyFileVo().setFileSrc(fileSrc);
					 vo.getProductInquriyFileVo().setInquireFile(INQUIREFile);
					 
					vo.setReplyEnrollDate(inquireReplyEnrollDate);
					vo.setReplyUpdateDate(replyUpdateDate);
					vo.setReplyDelYn(replyDelYn);
					vo.setInquireNo(inquireNo);
					vo.setConsumerNo(consumerNo);
					vo.setSalesNo(salesNo);
					vo.setContent(content);
					vo.setEnrollDate(enrollDate);
					vo.setDelYn(delYn);
					vo.setInquireReply(inquireReply);
					vo.setSecretYn(secretYn);
					vo.setSellerNo(sellerNo);
					vo.setItemtitle(itemtitle);
					vo.setBusinessName(businessName);
					vo.setUserName(userName);
					 
					 list.add(vo);
				}
				
				
				
				
				
				Map tempmap = new LinkedHashMap<String, ProductInquiryVo >();
				for (ProductInquiryVo productInquiryVo : list) {
					tempmap.put(productInquiryVo.getInquireNo(), productInquiryVo );
				}
						
				for (ProductInquiryVo productInquiryVo : list) {
					ProductInquiryVo targetVo = (ProductInquiryVo)tempmap.get(productInquiryVo.getInquireNo());
						targetVo.getList().add(productInquiryVo.getProductInquriyFileVo());
				}
				
				
				
					
				ArrayList<ProductInquiryVo> ProductInquiryVoList = new ArrayList<ProductInquiryVo>(tempmap.values());
				
				if(ProductInquiryVoList.size()<pvo.getLastRow()) {
					pvo.setLastRow(ProductInquiryVoList.size());
				}
				
				ArrayList<ProductInquiryVo> ProductInquiryresult = new ArrayList<ProductInquiryVo> ();
				
				for(int i = pvo.getStartRow()-1; i<pvo.getLastRow(); i++) {
					ProductInquiryresult.add(ProductInquiryVoList.get(i));
				}
					
				//close
				JDBCTemplate.close(rs);
				JDBCTemplate.close(pstmt);
					
				return ProductInquiryVoList;
				
		}
	// 상품번호 기준으로 문의 개수 가져오기 
	public int selectInquiryCountByItemNo(Connection conn, String saleNo, String memberNo) throws SQLException {
		
		 //SQL
		  String sql = "SELECT COUNT(*) FROM INQUIRE I JOIN SALES_REGISTR SR ON I.SALES_NO = SR.SALES_NO JOIN SELLER S  ON S.SELLER_NO = SR.SELLER_NO WHERE  I.DEL_YN ='N' AND SR.SALES_NO = ? ORDER BY I.INQUIRE_NO DESC";
		  PreparedStatement pstmt = conn.prepareStatement(sql);
	      pstmt.setString(1, saleNo);
	      
	      ResultSet rs = pstmt.executeQuery();
	      
	      //rs
	      int cnt = 0;
	      if(rs.next()) {
	         cnt = rs.getInt(1); //첫번째 열을 가져오겠다 라는 뜻, 계산에 써야되기 때문에 String이 아닌 Int로 받아줌
	      }
	      
	      //close
	      JDBCTemplate.close(rs);
	      JDBCTemplate.close(pstmt);
	           
	      return cnt;	
	}
	// 상품 번호 기준으로 문의 리스트 가져오기[전체]
	public List<ProductInquiryVo> memberInquiryShow(Connection conn, PageVo pvo, String saleNo, String memberNo) throws Exception {
		
		//sql
		String sql = "SELECT I.INQUIRE_NO ,I.CONSUMER_NO ,I.SALES_NO , I.CONTENT ,I.ENROLL_DATE ,I.DEL_YN ,I.INQUIRE_REPLY , I.SECRET_YN ,I.INQUIRE_REPLY_ENROLL_DATE ,I.REPLY_UPDATE_DATE ,I.REPLY_DEL_YN ,IF.INQUIRE_FILE ,IF.FILE_SRC ,SR.TITLE ,S.SELLER_NO ,BUSINESS_NAME ,M.NAME FROM INQUIRE I LEFT JOIN INQUIRE_FILE IF ON I.INQUIRE_NO = IF.INQUIRE_NO JOIN SALES_REGISTR SR ON I.SALES_NO = SR.SALES_NO JOIN SELLER S  ON S.SELLER_NO = SR.SELLER_NO JOIN MEMBER M ON M.MEMBER_NO  = I.CONSUMER_NO WHERE I.DEL_YN = 'N' AND SR.SALES_NO = ? ORDER BY I.INQUIRE_NO DESC";
		PreparedStatement pstmt = conn.prepareStatement(sql);
		pstmt.setString(1, saleNo);
		System.out.println("sql문 성공");
		
		//rs
		ResultSet rs = pstmt.executeQuery();
		
		//list
		List<ProductInquiryVo> list = new ArrayList<ProductInquiryVo>();
		
		while(rs.next()) {
			
			ProductInquiryVo vo = new ProductInquiryVo();
			
			 String inquireNo  		=rs.getString("INQUIRE_NO");
			 String consumerNo 		=rs.getString("CONSUMER_NO");
			 String salesNo    		=rs.getString("SALES_NO"); 
			 String content    		=rs.getString("CONTENT");
 			 String enrollDate 		=rs.getString("ENROLL_DATE");
			 String  delYn      	=rs.getString("DEL_YN");
			 String  inquireReply  	=rs.getString("INQUIRE_REPLY");
			 String  secretYn 		=rs.getString("SECRET_YN");
			 String  sellerNo 		=rs.getString("SELLER_NO");
			 String  itemtitle 		=rs.getString("TITLE");
			 String  businessName	=rs.getString("BUSINESS_NAME");
			 String  userName    	=rs.getString("NAME");
			String 	 inquireReplyEnrollDate = rs.getString("INQUIRE_REPLY_ENROLL_DATE");
			String 	 replyUpdateDate	=rs.getString("REPLY_UPDATE_DATE");
			String 	 replyDelYn			=rs.getString("REPLY_DEL_YN");
			 
			 
			 String fileSrc = rs.getString("FILE_SRC");
			 String INQUIREFile = rs.getString("INQUIRE_FILE");
			 
			 vo.getProductInquriyFileVo().setFileSrc(fileSrc);
			 vo.getProductInquriyFileVo().setInquireFile(INQUIREFile);
			 
			vo.setReplyEnrollDate(inquireReplyEnrollDate);
			vo.setReplyUpdateDate(replyUpdateDate);
			vo.setReplyDelYn(replyDelYn);
			vo.setInquireNo(inquireNo);
			vo.setConsumerNo(consumerNo);
			vo.setSalesNo(salesNo);
			vo.setContent(content);
			vo.setEnrollDate(enrollDate);
			vo.setDelYn(delYn);
			vo.setInquireReply(inquireReply);
			vo.setSecretYn(secretYn);
			vo.setSellerNo(sellerNo);
			vo.setItemtitle(itemtitle);
			vo.setBusinessName(businessName);
			vo.setUserName(userName);
			 
			 list.add(vo);
		}
		
		
		
		
		
		Map tempmap = new LinkedHashMap<String, ProductInquiryVo >();
		for (ProductInquiryVo productInquiryVo : list) {
			tempmap.put(productInquiryVo.getInquireNo(), productInquiryVo );
		}
				
		for (ProductInquiryVo productInquiryVo : list) {
			ProductInquiryVo targetVo = (ProductInquiryVo)tempmap.get(productInquiryVo.getInquireNo());
				targetVo.getList().add(productInquiryVo.getProductInquriyFileVo());
		}
		
		
		
			
		ArrayList<ProductInquiryVo> ProductInquiryVoList = new ArrayList<ProductInquiryVo>(tempmap.values());
		
		if(ProductInquiryVoList.size()<pvo.getLastRow()) {
			pvo.setLastRow(ProductInquiryVoList.size());
		}
		
		ArrayList<ProductInquiryVo> ProductInquiryresult = new ArrayList<ProductInquiryVo> ();
		
		for(int i = pvo.getStartRow()-1; i<pvo.getLastRow(); i++) {
			ProductInquiryresult.add(ProductInquiryVoList.get(i));
		}
			
		//close
		JDBCTemplate.close(rs);
		JDBCTemplate.close(pstmt);
		
			
		return ProductInquiryVoList;
		
}
	// 상품문의 파일받기 
	public int memberInquiryWrite(Connection conn, ProductInquiryVo vo) throws Exception {
		//sql
		String sql = "INSERT INTO INQUIRE (inquire_no,consumer_no,sales_no,content,enroll_date,secret_yn) VALUES (SEQ_INQUIRE.NEXTVAL,?,?,?,sysdate,?)";
		PreparedStatement pstmt = conn.prepareStatement(sql);
		pstmt.setString(1, vo.getConsumerNo());	
		pstmt.setString(2, vo.getSalesNo());	
		pstmt.setString(3, vo.getContent());
		pstmt.setString(4, vo.getSecretYn());
		int result = pstmt.executeUpdate();		

		//close
		JDBCTemplate.close(pstmt);

		return result;
	}
	// 상품문의 파일받기 사진
	public int memberInquiryWritePicture(Connection conn, ArrayList<String> strlist) throws SQLException {
		
		String	sql = "INSERT INTO INQUIRE_FILE (inquire_file,inquire_no,file_src) values (SEQ_INQUIRE_FILE.NEXTVAL,SEQ_INQUIRE.CURRVAL,?)";
		PreparedStatement pstmt = conn.prepareStatement(sql);
		int result =0;
		for (String str :strlist) {
			System.out.println("리뷰사진"  );
			pstmt.setString(1, str);
			result = pstmt.executeUpdate();
			if(result !=1) {
				return 0;
			}
		}
		
		//close
		JDBCTemplate.close(pstmt);


		return result;
		
	}
		
	
}//class

