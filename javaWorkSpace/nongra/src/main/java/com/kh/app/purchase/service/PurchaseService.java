package com.kh.app.purchase.service;

import java.sql.Connection;
import java.util.List;

import com.kh.app.member.vo.MemberVo;
import com.kh.app.purchase.dao.PurchaseDao;
import com.kh.app.purchase.vo.PurchaseCartVo;
import com.kh.app.util.db.JDBCTemplate;

public class PurchaseService {
	
	//장바구니 목록
	public List<PurchaseCartVo> cartList(MemberVo loginMember) throws Exception {
		//conn
		Connection conn = JDBCTemplate.getConnection();
		
		//dao
		PurchaseDao dao = new PurchaseDao();
		List<PurchaseCartVo> purchaseCartVoList = dao.cart(conn, loginMember);
		
		//close
		JDBCTemplate.close(conn);
		
		return purchaseCartVoList;
	}

}
