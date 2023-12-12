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
          String sql = "SELECT count(*) FROM MEMBER M JOIN CART C ON C.MEMBER_NO = M.MEMBER_NO JOIN CART_BREAKDOWN CB ON CB.CART_NO = C.NO JOIN SALES_REGISTR SR ON SR.SALES_NO = CB.SALES_NO JOIN SALES_OPTION SO ON SO.OPTION_NO = CB.OPTION_NO JOIN SELLER S ON S.SELLER_NO = SR.SELLER_NO JOIN ORDER_HISTORY OH ON C.NO = OH.CART_NO LEFT JOIN REVIEW R ON CB.NO = R.CART_BREAKDOWN_NO WHERE M.MEMBER_NO = ? AND  C.END_YN = 'Y' ORDER BY CB.NO DESC";
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
    			String sql = "SELECT OH.DELIVERY_YN   AS 구매확정여부 ,  OH.NO            AS 결제이력번호 , OH.ORDER_NO      AS 주문번호 , OH.ENROLL_DATE   AS   주문일자 , OH.REFUND_YN    AS   환불여부 , OH.REFUND__DATE AS   환불일 , SR.TITLE AS 상품명 , SR.PRICE AS 상품가격 , SR.SALES_NO AS 상품번호 , SO.OPTION_NAME AS 상품옵션명 , SO.OPTION_PRICE AS 옵션가격 , SR.THUMBNAIL AS 상품사진주소 , CB.EA AS 상품수량 , CB.EA * (SO.OPTION_PRICE + SR.PRICE) as 총가격 , S.BUSINESS_NAME AS 판매점 , CB.NO AS 내역번호 , R.REVIEW_NO AS 리뷰여부 FROM MEMBER M JOIN CART C ON C.MEMBER_NO = M.MEMBER_NO JOIN CART_BREAKDOWN CB ON CB.CART_NO = C.NO JOIN SALES_REGISTR SR ON SR.SALES_NO = CB.SALES_NO JOIN SALES_OPTION SO ON SO.OPTION_NO = CB.OPTION_NO JOIN SELLER S ON S.SELLER_NO = SR.SELLER_NO JOIN ORDER_HISTORY OH ON C.NO = OH.CART_NO LEFT JOIN REVIEW R ON CB.NO = R.CART_BREAKDOWN_NO WHERE M.MEMBER_NO = ? AND  C.END_YN = 'Y' ORDER BY CB.NO DESC";
                PreparedStatement pstmt = conn.prepareStatement(sql);
                pstmt.setString(1,memberNo1 );
                //rs
                ResultSet rs = pstmt.executeQuery();
                
                //list
                List<OrderDetailVo> list = new ArrayList<OrderDetailVo>();
                
                while(rs.next()) {
                	
                String  deliveryYn 		=rs.getString("구매확정여부");    						//"구매확정여부"
                String  payNo 			=rs.getString("결제이력번호");             					//"결제이력번호"
                String  orderNo 		=rs.getString("주문번호");       						//"주문번호"
                String  orderEnrollDate =rs.getString("주문일자");    				//  "주문일자"
                String  refundYn      	=rs.getString("환불여부");			// "환불여부"
                String  refundDte   	=rs.getString("환불일");			// "환불일"
                String  itemtitle       =rs.getString("상품명");			// "상품명" 
                String  price 		 	=rs.getString("상품가격");			//"상품가격"
                String  salesNo 	 	=rs.getString("상품번호");			//"상품번호"
                String  optionName  	=rs.getString("상품옵션명");			//"상품옵션명" 
                String  optionPrice 	=rs.getString("옵션가격");			//"옵션가격"
                String   thumbnail  	=rs.getString("상품사진주소");			//"상품사진주소" 
                String    ea 			=rs.getString("상품수량");			//"상품수량"
                String   totalPrice  	=rs.getString("총가격");			//"총가격"
                String    businessName 	=rs.getString("판매점");		//"판매점" 
                String    cbNo 			=rs.getString("내역번호");		//"내역번호"
                String    reviewNo  	=rs.getString("리뷰여부");			//"리뷰여부"   
                
                OrderDetailVo vo = new OrderDetailVo();
                    
                vo.setDeliveryYn("N");     
                vo.setPayNo(payNo);
                vo.setOrderNo(orderNo);
                vo.setOrderEnrollDate(orderEnrollDate);
                vo.setRefundYn(refundYn);
                vo.setRefundDte(refundDte);
                vo.setItemtitle(itemtitle);
	            vo.setPrice(totalPrice); 
	            vo.setSalesNo(salesNo);
	            vo.setOptionName(optionName);
	            vo.setOptionPrice(optionPrice);
	            vo.setThumbnail(thumbnail);
	            vo.setEa(ea);
	            vo.setTotalPrice(totalPrice);
	            vo.setBusinessName(businessName);
	            vo.setCbNo(cbNo);
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
    }//class        

