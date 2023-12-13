package com.kh.app.board.contact.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.kh.app.board.contact.vo.QnaMemberCateVo;
import com.kh.app.board.contact.vo.QnaMemberVo;
import com.kh.app.board.contact.vo.QnaSellerCateVo;
import com.kh.app.board.contact.vo.QnaSellerVo;
import com.kh.app.util.db.DateFormat;
import com.kh.app.util.db.JDBCTemplate;

public class QnaDao {
	//**** 문의내역 조회
	//판매자
	public List<QnaSellerVo> getQnaSellerList(Connection conn, String userNo) throws Exception {
		String sql = "SELECT DISTINCT SELLER_QNA_NO ,CATEGORY_ID ,Q.SELLER_NO ,Q.SALES_NO ,Q.TITLE ,CONTENT ,Q.ENROLL_DATE ,Q.MODIFY_DATE ,Q.MODIFY_YN ,REPLY_WRITER_NO ,REPLY_CONTENT ,REPLY_ENROLL_DATE ,REPLY_MODIFY_DATE ,ID ,NICK ,SR.TITLE 상품명 ,SR.THUMBNAIL FROM QNA_SELLER Q JOIN SELLER S ON Q.SELLER_NO = S.SELLER_NO JOIN MEMBER M ON M.MEMBER_NO = S.MEMBER_NO JOIN SALES_REGISTR SR ON Q.SALES_NO = SR.SALES_NO WHERE Q.SELLER_NO = ?";
		PreparedStatement pstmt = conn.prepareStatement(sql);
		pstmt.setString(1, userNo);
		ResultSet rs = pstmt.executeQuery();
		List<QnaSellerVo> qnaVoList = new ArrayList<QnaSellerVo> ();
		while(rs.next()) {
			String sellerQnaNo = rs.getString("SELLER_QNA_NO");
			String categoryId = rs.getString("CATEGORY_ID");
			String SellerNo = rs.getString("SELLER_NO");
			String SalesNo = rs.getString("SALES_NO");
			String Title = rs.getString("TITLE");
			String content = rs.getString("CONTENT");
			String EnrollDate = rs.getString("ENROLL_DATE");
			String ModifyDate = rs.getString("MODIFY_DATE");
			String ModifyYn = rs.getString("MODIFY_YN");
			String replyWriterNo = rs.getString("REPLY_WRITER_NO");
			String replyContent = rs.getString("REPLY_CONTENT");
			String replyEnrollDate = rs.getString("REPLY_ENROLL_DATE");
			String replyModifyDate = rs.getString("REPLY_MODIFY_DATE");
			String id = rs.getString("ID");
			String nick = rs.getString("NICK");
			String sTitle = rs.getString("상품명");
			String Thumbnail = rs.getString("THUMBNAIL");

		    
			QnaSellerVo vo = new QnaSellerVo();
			vo.setSellerQnaNo(sellerQnaNo);
			vo.setCategoryId(categoryId);
			vo.setSellerNo(SellerNo);
			vo.setSalesNo(SalesNo);
			vo.setTitle(Title);
			vo.setContent(content);
			vo.setEnrollDate(DateFormat.formattedDate(EnrollDate));
			vo.setModifyDate(DateFormat.formattedDate(ModifyDate));
			vo.setModifyYn(ModifyYn);
			vo.setReplyWriterNo(replyWriterNo);
			vo.setReplyContent(replyContent);
			vo.setReplyEnrollDate(DateFormat.formattedDate(replyEnrollDate));
			vo.setReplyModifyDate(DateFormat.formattedDate(replyModifyDate));
			vo.setId(id);
			vo.setNick(nick);
			vo.setsTitle(sTitle);
			vo.setThumbnail(Thumbnail);
			
			qnaVoList.add(vo);
		}
		JDBCTemplate.close(rs);
		JDBCTemplate.close(pstmt);
		return qnaVoList;
	}
	
	//소비자
	public List<QnaMemberVo> getQnaMemberList(Connection conn, String userNo) throws Exception {
		String sql = "SELECT M.MEMBER_QNA_NO , M.CATEGORY_ID , M.PAY_NO , M.MEMBER_NO , M.TITLE , M.CONTENT , M.ENROLL_DATE , M.MODIFY_DATE , M.MODIFY_YN , M.REPLY_WRITER_NO , M.REPLY_CONTENT , M.REPLY_ENROLL_DATE , M.REPLY_MODIFY_DATE , C.CATEGORY_PARENT_ID , C.CATEGORY_NAME FROM QNA_MEMBER M JOIN QNA_MEMBER_CATEGORY C ON M.CATEGORY_ID = C.CATEGORY_ID WHERE M.MEMBER_NO = ? ORDER BY M.ENROLL_DATE";
		PreparedStatement pstmt = conn.prepareStatement(sql);
		pstmt.setString(1, userNo);
		ResultSet rs = pstmt.executeQuery();
		List<QnaMemberVo> qnaVoList = new ArrayList<QnaMemberVo> ();
		while(rs.next()) {
			String memberQnaNo = rs.getString("MEMBER_QNA_NO");
			String categoryId = rs.getString("CATEGORY_ID");
			String memberNo = rs.getString("MEMBER_NO");
			String payNo = rs.getString("PAY_NO");
			String title = rs.getString("TITLE");
			String content = rs.getString("CONTENT");
			String enrollDate = rs.getString("ENROLL_DATE");
			String modifyDate = rs.getString("MODIFY_DATE");
			String modifyYn = rs.getString("MODIFY_YN");
			String replyWriterNo = rs.getString("REPLY_WRITER_NO");
			String replyContent = rs.getString("REPLY_CONTENT");
			String replyEnrollDate = rs.getString("REPLY_ENROLL_DATE");
			String replyModifyDate = rs.getString("REPLY_MODIFY_DATE");
			String categoryParentId = rs.getString("CATEGORY_PARENT_ID");
			String categoryName = rs.getString("CATEGORY_NAME");
		    
			QnaMemberVo vo = new QnaMemberVo();
			vo.setMemberQnaNo(memberQnaNo);
			vo.setCategoryId(categoryId);
			vo.setPayNo(payNo);
			vo.setMemberNo(memberNo);
			vo.setTitle(title);
			vo.setContent(replyContent);
			vo.setEnrollDate(DateFormat.formattedDate(enrollDate));
			vo.setModifyDate(DateFormat.formattedDate(modifyDate));
			vo.setModifyYn(modifyYn);
			vo.setReplyWriterNo(replyWriterNo);
			vo.setReplyContent(replyContent);
			vo.setReplyEnrollDate(DateFormat.formattedDate(replyEnrollDate));
			vo.setReplyModifyDate(DateFormat.formattedDate(replyModifyDate));
			vo.setCategoryParentId(categoryParentId);
			vo.setCategoryName(categoryName);
			
			qnaVoList.add(vo);
		}
		JDBCTemplate.close(rs);
		JDBCTemplate.close(pstmt);
		return qnaVoList;
	}
		
		
		
		
		
//		String sql = "SELECT DISTINCT Q.MEMBER_QNA_NO, QC.CATEGORY_ID, QC.CATEGORY_PARENT_ID, QC.CATEGORY_NAME AS CHILD_CATEGORY_NAME, PC.CATEGORY_NAME AS PARENT_CATEGORY_NAME, Q.MEMBER_NO, Q.PAY_NO, Q.TITLE, Q.CONTENT, F.FILE_NO, F.FILE_NAME, Q.ENROLL_DATE, Q.MODIFY_DATE, Q.MODIFY_YN, Q.REPLY_WRITER_NO, Q.REPLY_CONTENT, Q.REPLY_ENROLL_DATE, Q.REPLY_MODIFY_DATE, M.ID, M.NICK, ORDER_NO, TOTAL_PRICE FROM QNA_MEMBER Q JOIN QNA_MEMBER_CATEGORY QC ON QC.CATEGORY_ID = Q.CATEGORY_ID LEFT JOIN QNA_MEMBER_FILE F ON Q.MEMBER_QNA_NO = F.MEMBER_QNA_NO JOIN MEMBER M ON Q.MEMBER_NO = M.MEMBER_NO LEFT JOIN ORDER_HISTORY OH ON Q.PAY_NO = OH.NO LEFT JOIN ORDER_INFORMATION OI ON OH.ORDER_NO = OI.NO LEFT JOIN CART C ON C.NO = OH.CART_NO LEFT JOIN CART_BREAKDOWN CB ON CB.CART_NO = C.NO LEFT JOIN QNA_MEMBER_CATEGORY PC ON QC.CATEGORY_PARENT_ID = PC.CATEGORY_ID WHERE M.MEMBER_NO = ?";
//		PreparedStatement pstmt = conn.prepareStatement(sql);
//		pstmt.setString(1, userNo);
//		ResultSet rs = pstmt.executeQuery();
//		List<QnaMemberVo> qnaVoList = new ArrayList<QnaMemberVo> ();
//		while(rs.next()) {
//			String memberQnaNo = rs.getString("MEMBER_QNA_NO");
//			String categoryId = rs.getString("CATEGORY_ID");
//			String categoryParentId = rs.getString("CATEGORY_PARENT_ID");
//			String categoryName = rs.getString("CATEGORY_NAME");
//			String memberNo = rs.getString("MEMBER_NO");
//			String payNo = rs.getString("PAY_NO");
//			String title = rs.getString("TITLE");
//			String content = rs.getString("CONTENT");
//			String fileNo = rs.getString("FILE_NO");
//			String fileName = rs.getString("FILE_NAME");
//			String enrollDate = rs.getString("ENROLL_DATE");
//			String modifyDate = rs.getString("MODIFY_DATE");
//			String modifyYn = rs.getString("MODIFY_YN");
//			String replyWriterNo = rs.getString("REPLY_WRITER_NO");
//			String replyContent = rs.getString("REPLY_CONTENT");
//			String replyEnrollDate = rs.getString("REPLY_ENROLL_DATE");
//			String replyModifyDate = rs.getString("REPLY_MODIFY_DATE");
//			String id = rs.getString("ID");
//			String nick = rs.getString("NICK");
//			String orderNo = rs.getString("ORDER_NO");
//			String totalPrice = rs.getString("TOTAL_PRICE");
//			QnaMemberVo vo = new QnaMemberVo();
//			
//			
//			vo.setMemberQnaNo(memberQnaNo);
//			vo.setCategoryId(categoryId);
//			vo.setCategoryParentId(categoryParentId);
//			vo.setCategoryName(categoryName);
//			vo.setMemberNo(memberNo);
//			vo.setPayNo(payNo);
//			vo.setTitle(title);
//			vo.setContent(content);
//			vo.setFileNo(fileNo);
//			vo.setFileName(fileName);
//			vo.setEnrollDate(DateFormat.formattedDate(enrollDate));
//			vo.setModifyDate(DateFormat.formattedDate(modifyDate));
//			vo.setModifyYn(modifyYn);
//			vo.setReplyWriterNo(replyWriterNo);
//			vo.setReplyContent(replyContent);
//			vo.setReplyEnrollDate(DateFormat.formattedDate(replyEnrollDate));
//			vo.setReplyModifyDate(DateFormat.formattedDate(replyModifyDate));
//			vo.setId(id);
//			vo.setNick(nick);
//			vo.setOrderNo(orderNo);
//			vo.setTotalPrice(totalPrice);
//
//			qnaVoList.add(vo);
//		}
//		JDBCTemplate.close(rs);
//		JDBCTemplate.close(pstmt);
//		return qnaVoList;
//	}
	
	//**** 부모카테고리 조회 
	//소비자
	public List<QnaMemberCateVo> getQnaMemberParentCateList (Connection conn) throws Exception{
		String sql = "SELECT * FROM (SELECT ROWNUM RNUM, T.* FROM ( SELECT CATEGORY_ID ,CATEGORY_NAME FROM QNA_MEMBER_CATEGORY WHERE CATEGORY_PARENT_ID IS NULL ORDER BY CATEGORY_ID )T)";
		PreparedStatement pstmt = conn.prepareStatement(sql);
		ResultSet rs = pstmt.executeQuery();
		
		List<QnaMemberCateVo> parentCateVoList = new ArrayList<QnaMemberCateVo> ();
		while(rs.next()) {
			String categoryId= rs.getString("CATEGORY_ID");
			String categoryName= rs.getString("CATEGORY_NAME");
			
			QnaMemberCateVo vo = new QnaMemberCateVo(categoryId, categoryName);
			vo.setCategoryId(categoryId);
			vo.setCategoryName(categoryName);
			
			parentCateVoList.add(vo);
		}
		JDBCTemplate.close(rs);
		JDBCTemplate.close(pstmt);
		return parentCateVoList;
	}
	
	//판매자
	public List<QnaSellerCateVo> getQnaSellerParentCateList (Connection conn) throws Exception{
		String sql = "SELECT * FROM (SELECT ROWNUM RNUM, T.* FROM ( SELECT CATEGORY_ID ,CATEGORY_NAME FROM QNA_SELLER_CATEGORY WHERE CATEGORY_PARENT_ID IS NULL ORDER BY CATEGORY_ID )T)";
		PreparedStatement pstmt = conn.prepareStatement(sql);
		ResultSet rs = pstmt.executeQuery();
		
		List<QnaSellerCateVo> parentCateVoList = new ArrayList<QnaSellerCateVo> ();
		while(rs.next()) {
			String categoryId= rs.getString("CATEGORY_ID");
			String categoryName= rs.getString("CATEGORY_NAME");
			
			QnaSellerCateVo vo = new QnaSellerCateVo(categoryId, categoryName);
			vo.setCategoryId(categoryId);
			vo.setCategoryName(categoryName);
			
			parentCateVoList.add(vo);
		}
		JDBCTemplate.close(rs);
		JDBCTemplate.close(pstmt);
		return parentCateVoList;
	}
	//**** 자식카테고리 조회 
	//소비자
	public Map<String, QnaMemberCateVo> getQnaMemberChildCateList (Connection conn) throws Exception{
		String sql = "SELECT CATEGORY_PARENT_ID , CATEGORY_ID , CATEGORY_NAME FROM QNA_MEMBER_CATEGORY WHERE CATEGORY_PARENT_ID IS NOT NULL ORDER BY CATEGORY_ID";
		PreparedStatement pstmt = conn.prepareStatement(sql);
		ResultSet rs = pstmt.executeQuery();
		
		List<QnaMemberCateVo> childCateVoList = new ArrayList<QnaMemberCateVo> ();
		while(rs.next()) {
			String categoryParentId= rs.getString("CATEGORY_PARENT_ID");
			String categoryId= rs.getString("CATEGORY_ID");
			String categoryName= rs.getString("CATEGORY_NAME");
			
			QnaMemberCateVo vo = new QnaMemberCateVo(categoryParentId, categoryId, categoryName);
			childCateVoList.add(vo);
		}
		Map<String, QnaMemberCateVo> map = new HashMap<String, QnaMemberCateVo>();
		for (QnaMemberCateVo vo : childCateVoList) {
			map.put(vo.getCategoryParentId(), vo);
		}
		JDBCTemplate.close(rs);
		JDBCTemplate.close(pstmt);
		return map;
	}
	
	//판매자
	public Map<String, QnaSellerCateVo> getQnaSellerChildCateList (Connection conn) throws Exception{
		String sql = "SELECT CATEGORY_PARENT_ID , CATEGORY_ID , CATEGORY_NAME FROM QNA_SELLER_CATEGORY WHERE CATEGORY_PARENT_ID IS NOT NULL ORDER BY CATEGORY_ID";
		PreparedStatement pstmt = conn.prepareStatement(sql);
		ResultSet rs = pstmt.executeQuery();
		
		List<QnaSellerCateVo> childCateVoList = new ArrayList<QnaSellerCateVo> ();
		while(rs.next()) {
			String categoryParentId= rs.getString("CATEGORY_PARENT_ID");
			String categoryId= rs.getString("CATEGORY_ID");
			String categoryName= rs.getString("CATEGORY_NAME");
			
			QnaSellerCateVo vo = new QnaSellerCateVo(categoryParentId, categoryId, categoryName);
			childCateVoList.add(vo);
		}
		Map<String, QnaSellerCateVo> map = new HashMap<String, QnaSellerCateVo>();
		for (QnaSellerCateVo vo : childCateVoList) {
			map.put(vo.getCategoryParentId(), vo);
		}
		JDBCTemplate.close(rs);
		JDBCTemplate.close(pstmt);
		return map;
	}
	
	//소비자 부모 카테고리명 조회
	public QnaMemberCateVo getQnaMemberParentCateName (Connection conn, String parentCateId) throws Exception{
		String sql = "SELECT CATEGORY_NAME FROM QNA_MEMBER_CATEGORY WHERE CATEGORY_PARENT_ID = ?";
		PreparedStatement pstmt = conn.prepareStatement(sql);
		pstmt.setString(1, parentCateId);
		ResultSet rs = pstmt.executeQuery();
		QnaMemberCateVo vo = new QnaMemberCateVo();
		
		while(rs.next()) {
			String parentCateName= rs.getString("CATEGORY_NAME");
			
			vo.setCategoryParentName(parentCateName);
			
		}
		JDBCTemplate.close(rs);
		JDBCTemplate.close(pstmt);
		return vo;
	}
	
}
