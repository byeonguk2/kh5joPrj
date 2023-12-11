package com.kh.app.purchase.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.apache.tomcat.dbcp.dbcp2.Jdbc41Bridge;

import com.kh.app.member.vo.MemberVo;
import com.kh.app.purchase.vo.PurchaseAddressVo;
import com.kh.app.purchase.vo.PurchaseCartVo;
import com.kh.app.purchase.vo.PurchaseOrderCheckoutVo;
import com.kh.app.util.db.JDBCTemplate;

public class PurchaseDao {

	//장바구니 목록
	public List<PurchaseCartVo> cart(Connection conn, MemberVo loginMember) throws Exception {
		//sql
		String sql = "SELECT SR.TITLE AS \"상품명\" , SR.PRICE AS \"상품가격\" , SO.OPTION_NAME AS \"상품옵션명\" , SO.OPTION_PRICE AS \"옵션가격\" , SF.FILE_NAME AS \"상품사진주소\" , CB.EA AS \"상품수량\" , S.BUSINESS_NAME AS \"판매점\" , CB.NO AS \"내역번호\" FROM MEMBER M JOIN CART C ON C.MEMBER_NO = M.MEMBER_NO JOIN CART_BREAKDOWN CB ON CB.CART_NO = C.NO JOIN SALES_REGISTR SR ON SR.SALES_NO = CB.SALES_NO JOIN SALES_OPTION SO ON SO.OPTION_NO = CB.OPTION_NO JOIN SALES_FILE SF ON SF.SALES_NO = SR.SALES_NO JOIN SELLER S ON S.SELLER_NO = SR.SELLER_NO WHERE M.MEMBER_NO = ? AND  C.END_YN = 'N' ORDER BY CB.NO DESC";
		PreparedStatement pstmt = conn.prepareStatement(sql);
		pstmt.setString(1, loginMember.getNo());
		ResultSet rs = pstmt.executeQuery();
		
		//rs
		List<PurchaseCartVo> PurchaseCartVoList = new ArrayList<PurchaseCartVo>();
		while(rs.next()) {
			String goodsName = rs.getString("상품명");
			String goodsPrice = rs.getString("상품가격");
			String optionName = rs.getString("상품옵션명");
			String optionPrice = rs.getString("옵션가격");
			String goodsPicture = rs.getString("상품사진주소");
			String goodsEA = rs.getString("상품수량");
			String seller = rs.getString("판매점");
			String orderNumber = rs.getString("내역번호");
			
			PurchaseCartVo vo = new PurchaseCartVo();
			
			vo.setGoodsName(goodsName);
			vo.setGoodsPrice(goodsPrice);
			vo.setOptionName(optionName);
			vo.setOptionPrice(optionPrice);
			vo.setGoodsPicture(goodsPicture);
			vo.setGoodsEA(goodsEA);
			vo.setSeller(seller);
			vo.setOrderNumber(orderNumber);
			
			PurchaseCartVoList.add(vo);
		}
		
		//close
		JDBCTemplate.close(rs);
		JDBCTemplate.close(pstmt);
		
		return PurchaseCartVoList;
	}

	//장바구니 상품 수량 변경
	public int cartEAUpdate(Connection conn, String cartBreakDownNo, String cartBreakDownEa) throws Exception {
		//sql
		String sql = "UPDATE CART_BREAKDOWN SET EA = ? WHERE NO = ?";
		PreparedStatement pstmt = conn.prepareStatement(sql);
		pstmt.setString(1, cartBreakDownEa);
		pstmt.setString(2, cartBreakDownNo);
		int result = pstmt.executeUpdate();
				
		//close
		JDBCTemplate.close(pstmt);
		
		return result;
	}

	//장바구니 목록 삭제
	public int cartListRemove(Connection conn, String cartBreakDownNo) throws Exception {
		//sql
		String sql = "DELETE FROM CART_BREAKDOWN WHERE NO = ?";
		PreparedStatement pstmt = conn.prepareStatement(sql);
		pstmt.setString(1, cartBreakDownNo);
		int result = pstmt.executeUpdate();
		
		//close
		JDBCTemplate.close(pstmt);
		
		return result;
	}

	//배송지 하나만 불러오기
	public PurchaseAddressVo takeAddress(Connection conn, MemberVo loginMember) throws Exception {
		//sql
		String sql = "SELECT A.NO AS \"배송지정보번호\" , A.ADDRESS AS \"배송지\" , A.NAME AS \"받는사람\" , A.PHONE AS \"받는사람전화번호\" , A.DEL_YN AS \"삭제여부\" , A.DEFAULT_ADDRESS AS \"기본배송지\" FROM MEMBER M JOIN ADDRESS A ON M.MEMBER_NO = A.MEMBER_NO WHERE M.MEMBER_NO = ? AND DEL_YN = 'N' ORDER BY A.DEFAULT_ADDRESS DESC";
		PreparedStatement pstmt = conn.prepareStatement(sql);
		pstmt.setString(1, loginMember.getNo());
		ResultSet rs = pstmt.executeQuery();
		
		//rs
		PurchaseAddressVo vo = null;
		if(rs.next()) {
			String no = rs.getString("배송지정보번호");
			String address = rs.getString("배송지");
			String name = rs.getString("받는사람");
			String phone = rs.getString("받는사람전화번호");
			String delYn = rs.getString("삭제여부");
			String defaultAddress = rs.getString("기본배송지");
			
			vo = new PurchaseAddressVo();
			
			vo.setNo(no);
			vo.setAddress(address);
			vo.setName(name);
			vo.setPhone(phone);
			vo.setDelYn(delYn);
			vo.setDefaultAddress(defaultAddress);
		}
		
		//close
		JDBCTemplate.close(rs);
		JDBCTemplate.close(pstmt);
		
		return vo;
	}

	//배송지 전체 불러오기
	public List<PurchaseAddressVo> takeAllAddress(Connection conn, MemberVo loginMember) throws Exception {
		//sql
		String sql = "SELECT A.NO AS \"배송지정보번호\" , A.ADDRESS AS \"배송지\" , A.NAME AS \"받는사람\" , A.PHONE AS \"받는사람전화번호\" , A.DEL_YN AS \"삭제여부\" , A.DEFAULT_ADDRESS AS \"기본배송지\" FROM MEMBER M JOIN ADDRESS A ON M.MEMBER_NO = A.MEMBER_NO WHERE M.MEMBER_NO = ? AND DEL_YN = 'N' ORDER BY A.DEFAULT_ADDRESS DESC";
		PreparedStatement pstmt = conn.prepareStatement(sql);
		pstmt.setString(1, loginMember.getNo());
		ResultSet rs = pstmt.executeQuery();
		
		//rs
		List<PurchaseAddressVo> voList = null;
		while(rs.next()) {
			String no = rs.getString("배송지정보번호");
			String address = rs.getString("배송지");
			String name = rs.getString("받는사람");
			String phone = rs.getString("받는사람전화번호");
			String delYn = rs.getString("삭제여부");
			String defaultAddress = rs.getString("기본배송지");
			
			PurchaseAddressVo vo = new PurchaseAddressVo();
			
			vo.setNo(no);
			vo.setAddress(address);
			vo.setName(name);
			vo.setPhone(phone);
			vo.setDelYn(delYn);
			vo.setDefaultAddress(defaultAddress);

			voList = new ArrayList<PurchaseAddressVo>();
			voList.add(vo);
		}
		
		
		//close
		JDBCTemplate.close(rs);
		JDBCTemplate.close(pstmt);
		
		
		return voList;
	}





}