package com.kh.app.orderdetails.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import com.kh.app.orderdetails.vo.OrderDetailVo;
import com.kh.app.page.vo.PageVo;
import com.kh.app.review.vo.ReviewVo;
import com.kh.app.util.db.JDBCTemplate;

public class OrderDetailDao {

	public int selectOrderDetailCountByMemberNo(Connection conn, String memberNo) throws Exception {
		
		 //SQL
	      String sql = "SELECT * FROM  CART_BREAKDOWN CB LEFT JOIN CART C ON CB.CART_NO = C.NO JOIN MEMBER M ON M.MEMBER_NO = C.MEMBER_NO WHERE M.MEMBER_NO =? AND C.END_YN = 'Y' ORDER BY CB.NO DESC";
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

	//주문 상세 정보 멤버 넘버로 가져오기 [멤버] 
	public List<OrderDetailVo> manageOrderDetailLookUp(Connection conn, PageVo pvo, String memberNo1) throws Exception {
		
		//sql
				String sql ="SELECT CB.NO AS CART_BREAKDWON_NO ,CB.EA ,C.NO AS CART_NO ,C.END_YN ,OH.ORDER_NO ,OH.TOTAL_PRICE ,OH.ENROLL_DATE ,OH.DELIVERY_YN ,OH.REFUND_YN ,OH.REFUND__DATE ,M.MEMBER_NO ,SR.SALES_NO ,SR.TITLE AS ITEM_TITLE ,S.SELLER_NO ,S.BUSINESS_NAME ,R.REVIEW_NO FROM CART_BREAKDOWN CB JOIN CART C ON CB.CART_NO = C.NO JOIN ORDER_HISTORY OH ON C.NO = OH.CART_NO JOIN MEMBER M ON M.MEMBER_NO = C.MEMBER_NO JOIN SALES_REGISTR SR ON CB.SALES_NO = SR.SALES_NO JOIN SELLER S ON SR.SELLER_NO = S.SELLER_NO LEFT JOIN REVIEW R ON R.CART_BREAKDOWN_NO = CB.NO WHERE C.END_YN = 'Y' AND M.MEMBER_NO = ? ORDER BY OH.NO DESC";
				PreparedStatement pstmt = conn.prepareStatement(sql);
				pstmt.setString(1,memberNo1 );
				//rs
				ResultSet rs = pstmt.executeQuery();
				
				//list
				List<OrderDetailVo> list = new ArrayList<OrderDetailVo>();
				
				while(rs.next()) {
					
					
					  String  cartBreakdwonNo = rs.getString("CART_BREAKDWON_NO");     // 장바구니 목록 번호  
					  String  ea = rs.getString("EA");				  // 수량                       
					  String  cartNo = rs.getString("CART_NO");             //장바구니           
					  String  endYn = rs.getString("END_YN");    		    // 장바구니 결제완료                
					  String  orderNo = rs.getString("ORDER_NO"); 		   // 주문번호                  
					  String  totalPrice = rs.getString("TOTAL_PRICE");   	  // 총금액            
					  String  EnrollDate = rs.getString("ENROLL_DATE");     //  결제일              
					  String  DeliveryYn = rs.getString("DELIVERY_YN");    // 배달여부 (구매 확정 시 업데이트)             
					  String  refundYn   = rs.getString("REFUND_YN");     // 환불여부            
					  String  refundDate = rs.getString("REFUND__DATE");  //  환불 일             
					  String  memberNo   = rs.getString("MEMBER_NO");   // 유저번호                   
					  String  salesNo    = rs.getString("SALES_NO");   // 판매번호                  
					  String  itemTitle  = rs.getString("ITEM_TITLE");  // 아이템 타이틀       
					  String  sellerNo   = rs.getString("SELLER_NO"); //판매자 번호                 
					  String  businessName = rs.getString("BUSINESS_NAME"); // 가게명    
					  String  reviewNo     = rs.getString("REVIEW_NO");   
					  
					  OrderDetailVo vo = new OrderDetailVo();
					  
					  vo.setCartBreakdwonNo(cartBreakdwonNo);
					  vo.setEa(ea);
					  vo.setCartNo(cartNo);
					  vo.setEndYn(endYn);
					  vo.setOrderNo(orderNo);
					  vo.setTotalPrice(totalPrice);
					  vo.setEnrollDate(EnrollDate);
					  vo.setDeliveryYn(DeliveryYn);
					  vo.setRefundYn(refundYn);
					  vo.setRefundDate(refundDate);
					  vo.setMemberNo(memberNo);
					  vo.setSalesNo(salesNo);
					  vo.setItemTitle(itemTitle);
					  vo.setSellerNo(sellerNo);
					  vo.setBusinessName(businessName);
					  vo.setReviewNo(reviewNo);
					  
					 list.add(vo);
				}
			
				// 리스트 페이징처리를 
				
				if(list.size()<pvo.getLastRow()) {
					pvo.setLastRow(list.size());
				}
				
				ArrayList<OrderDetailVo> reviewVoListresult = new ArrayList<OrderDetailVo> ();
				for(int i = pvo.getStartRow()-1; i<pvo.getLastRow(); i++) {
					reviewVoListresult.add(list.get(i));
				}
				
			
				
			
				//close
				JDBCTemplate.close(rs);
				JDBCTemplate.close(pstmt);
				
				
				return reviewVoListresult;
				
				
			}
	}		



