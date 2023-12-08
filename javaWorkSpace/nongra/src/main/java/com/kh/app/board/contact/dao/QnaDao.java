package com.kh.app.board.contact.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.kh.app.board.contact.vo.QnaMemberCateVo;
import com.kh.app.board.contact.vo.QnaMemberVo;
import com.kh.app.board.contact.vo.QnaSellerVo;
import com.kh.app.util.db.JDBCTemplate;

public class QnaDao {

	public List<QnaMemberCateVo> getParentCateList(Connection conn) {
		// TODO Auto-generated method stub
		return null;
	}

	public List<QnaSellerVo> getQnaSellerList(Connection conn, String userNo) throws Exception {
		String sql = "SELECT S.SELLER_QNA_NO , S.CATEGORY_ID , S.SALES_NO , S.SELLER_NO , S.TITLE , S.CONTENT , S.ENROLL_DATE , S.MODIFY_DATE , S.MODIFY_YN , S.REPLY_WRITER_NO , S.REPLY_CONTENT , S.REPLY_ENROLL_DATE , S.REPLY_MODIFY_DATE , C.CATEGORY_PARENT_ID , C.CATEGORY_NAME FROM QNA_SELLER S JOIN QNA_SELLER_CATEGORY C ON S.CATEGORY_ID = C.CATEGORY_ID WHERE S.SELLER_NO = ? ORDER BY S.ENROLL_DATE";
		PreparedStatement pstmt = conn.prepareStatement(sql);
		pstmt.setString(1, userNo);
		ResultSet rs = pstmt.executeQuery();
		List<QnaSellerVo> qnaVoList = new ArrayList<QnaSellerVo> ();
		while(rs.next()) {
			String sellerQnaNo = rs.getString("SELLER_QNA_NO");
			String categoryId = rs.getString("CATEGORY_ID");
			String salesNo = rs.getString("SALES_NO");
			String sellerNo = rs.getString("SELLER_NO");
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
		    
			QnaSellerVo qvo = new QnaSellerVo();
			qvo.setSellerQnaNo(sellerQnaNo);
			qvo.setCategoryId(categoryId);
			qvo.setSalesNo(salesNo);
			qvo.setSellerNo(sellerNo);
			qvo.setTitle(title);
			qvo.setContent(replyContent);
			qvo.setEnrollDate(enrollDate);
			qvo.setModifyDate(modifyDate);
			qvo.setModifyYn(modifyYn);
			qvo.setReplyWriterNo(replyWriterNo);
			qvo.setReplyContent(replyContent);
			qvo.setReplyEnrollDate(replyEnrollDate);
			qvo.setReplyModifyDate(replyModifyDate);
			qvo.setCategoryParentId(categoryParentId);
			qvo.setCategoryName(categoryName);
			
			qnaVoList.add(qvo);
		}
		JDBCTemplate.close(rs);
		JDBCTemplate.close(pstmt);
		return qnaVoList;
	}

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
		    
			QnaMemberVo mvo = new QnaMemberVo();
			mvo.setMemberQnaNo(memberQnaNo);
			mvo.setCategoryId(categoryId);
			mvo.setPayNo(payNo);
			mvo.setMemberNo(memberNo);
			mvo.setTitle(title);
			mvo.setContent(replyContent);
			mvo.setEnrollDate(enrollDate);
			mvo.setModifyDate(modifyDate);
			mvo.setModifyYn(modifyYn);
			mvo.setReplyWriterNo(replyWriterNo);
			mvo.setReplyContent(replyContent);
			mvo.setReplyEnrollDate(replyEnrollDate);
			mvo.setReplyModifyDate(replyModifyDate);
			mvo.setCategoryParentId(categoryParentId);
			mvo.setCategoryName(categoryName);
			
			qnaVoList.add(mvo);
		}
		JDBCTemplate.close(rs);
		JDBCTemplate.close(pstmt);
		return qnaVoList;
	}

}
