package com.kh.app.review.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import javax.naming.spi.DirStateFactory.Result;

import com.kh.app.review.vo.ReviewVo;
import com.kh.app.util.db.JDBCTemplate;

public class ReviewDao {

	//	관리자 모든 리뷰 페이지 조회 + 관리창
	public List<ReviewVo> manageReviewLookUp(Connection conn) throws Exception {

		//sql
		String sql ="SELECT R.REVIEW_NO ,R.CONSUMER_NO ,R.CART_BREAKDOWN_NO ,R.CONTENT ,R.WRITE_DATE ,R.UPDATE_DATE ,R.REPLY_DATE ,R.REPLY_DEL_YN ,R.REPLY_CONTENT ,SR.TITLE AS ITEM_TITLE ,S.BUSINESS_NAME ,M.NICK ,M.PROFILE ,T.LIKE_CNT ,RF.FILE_SRC FROM REVIEW R JOIN CART_BREAKDOWN CB ON R.CART_BREAKDOWN_NO = CB.NO JOIN SALES_REGISTR SR ON CB.SALES_NO = SR.SALES_NO JOIN SELLER S ON SR.SELLER_NO = S.SELLER_NO JOIN MEMBER M ON R.CONSUMER_NO = M.MEMBER_NO LEFT JOIN ( SELECT R.REVIEW_NO ,COUNT(*) AS LIKE_CNT FROM REVIEW R JOIN REVIEW_LIKE RL ON R.REVIEW_NO = RL.REVIEW_NO GROUP BY R.REVIEW_NO ORDER BY R.REVIEW_NO ) T ON T.REVIEW_NO = R.REVIEW_NO FULL JOIN REVIEW_FILE RF ON R.REVIEW_NO = RF.REVIEW_NO WHERE REVIEW_DEL_YN = 'N' ORDER BY R.REVIEW_NO";
		PreparedStatement pstmt = conn.prepareStatement(sql);
		
		
		//rs
		ResultSet rs = pstmt.executeQuery();
		
		
		
		//list
		List<ReviewVo> list = new ArrayList<ReviewVo>();
		
		while(rs.next()) {
			
			
			
			 ReviewVo vo = new ReviewVo();
			 String reviewNo = rs.getString("REVIEW_NO");
			 String consumerNo = rs.getString("CONSUMER_NO");
			 String	cartBreakdownNo = rs.getString("CART_BREAKDOWN_NO");
			 String	content = rs.getString("CONTENT");
			 String	writeDate = rs.getString("WRITE_DATE");
			 String	updateDate = rs.getString("UPDATE_DATE");
			 String	replyDate = rs.getString("REPLY_DATE");
			 String	replyDelYn = rs.getString("REPLY_DEL_YN");
			 String	replyContent = rs.getString("REPLY_CONTENT");
			 String	ItemTitle = rs.getString("ITEM_TITLE");    //상품 제목
			 String	corporationName = rs.getString("BUSINESS_NAME");
			 String	nick =  rs.getString("NICK");
			 String	likeCnt = rs.getString("LIKE_CNT");
			 String fileSrc = rs.getString("FILE_SRC");
			 String profile = rs.getString("PROFILE");
			 
			 List<String> fileSrcList =  new ArrayList<String>();
			 
			 vo.setReviewNo(reviewNo);
			 vo.setConsumerNo(consumerNo);
			 vo.setCartBreakdownNo(cartBreakdownNo);
			 vo.setContent(content);
			 vo.setWriteDate(writeDate);
			 vo.setUpdateDate(updateDate);
			 vo.setReplyDate(replyDate);
			 vo.setReplyDelYn(replyDelYn);
			 vo.setReplyContent(replyContent);
			 vo.setItemTitle(ItemTitle);
			 vo.setCorporationName(corporationName);
			 vo.setNick(nick);
			 vo.setLikeCnt(likeCnt);
			 vo.setSrc(fileSrc);
			 vo.setFileSrc(fileSrcList);
			 vo.setProfile(profile);
			 
			 list.add(vo);
		}
		
		
		
		
	
		
		
		
		
		Map tempmap = new HashMap<String, ReviewVo >();
		for (ReviewVo reviewVo : list) {
			tempmap.put(reviewVo.getReviewNo(), reviewVo );
		}
//		키값은 중복이 
		
		
		
		
	
		
	
		for (ReviewVo reviewVo : list) {
				ReviewVo targetVo = (ReviewVo) tempmap.get(reviewVo.getReviewNo());
				targetVo.getFileSrc().add(reviewVo.getSrc());
		}
		
		
	
		
		
		
		ArrayList<ReviewVo> reviewVoList = new ArrayList<ReviewVo>(tempmap.values());
		
		
		
		 
		
		//close
		JDBCTemplate.close(rs);
		JDBCTemplate.close(pstmt);
		
		
		return reviewVoList;
		
		
	}

}
