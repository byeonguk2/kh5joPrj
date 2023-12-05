package com.kh.app.purchase.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import org.apache.tomcat.dbcp.dbcp2.Jdbc41Bridge;

import com.kh.app.member.vo.MemberVo;
import com.kh.app.purchase.vo.PurchaseCartVo;
import com.kh.app.util.db.JDBCTemplate;

public class PurchaseDao {

	//장바구니 목록
	public List<PurchaseCartVo> cart(Connection conn, MemberVo loginMember) throws Exception {
		//sql
		String sql = "SELECT SR.TITLE AS \"상품명\", SR.PRICE AS \"상품가격\", SO.OPTION_NAME AS \"상품옵션명\", SO.OPTION_PRICE AS \"옵션가격\", SF.FILE_NAME AS \"상품사진주소\", CB.EA AS \"상품수량\" , S.BUSINESS_NAME AS \"판매점\" FROM MEMBER M JOIN CART C ON C.MEMBER_NO = M.MEMBER_NO JOIN CART_BREAKDOWN CB ON CB.CART_NO = C.NO JOIN SALES_REGISTR SR ON SR.SALES_NO = CB.SALES_NO JOIN SALES_OPTION SO ON SO.SALES_NO = SR.SALES_NO JOIN SALES_FILE SF ON SF.SALES_NO = SR.SALES_NO JOIN SELLER S ON S.SELLER_NO = SR.SELLER_NO WHERE M.MEMBER_NO = ?";
		PreparedStatement pstmt = conn.prepareStatement(sql);
		pstmt.setString(1, "1");
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
			
			PurchaseCartVo vo = new PurchaseCartVo();
			
			vo.setGoodsName(goodsName);
			vo.setGoodsPrice(goodsPrice);
			vo.setOptionName(optionName);
			vo.setOptionPrice(optionPrice);
			vo.setGoodsPicture(goodsPicture);
			vo.setGoodsEA(goodsEA);
			vo.setSeller(seller);
			
			PurchaseCartVoList.add(vo);
		}
		
		//close
		JDBCTemplate.close(rs);
		JDBCTemplate.close(pstmt);
		
		return PurchaseCartVoList;
	}

}
