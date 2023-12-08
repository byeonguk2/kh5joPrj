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

	//장바구니 상품 수량 변경
	public int cartEAUpdate(String cartBreakDownNo, String cartBreakDownEa) throws Exception {
		//conn
		Connection conn = JDBCTemplate.getConnection();
		
		//dao
		PurchaseDao pd = new PurchaseDao();
		int result = pd.cartEAUpdate(conn, cartBreakDownNo, cartBreakDownEa);
		
		//tx
		if(result == 1) {
			JDBCTemplate.commit(conn);
		}else {
			JDBCTemplate.rollback(conn);
		}
		
		//close
		JDBCTemplate.close(conn);
		
		return result;
	}

	//장바구니 목록 삭제
	public int cartListRemove(String cartBreakDownNo) throws Exception {
		//conn
		Connection conn = JDBCTemplate.getConnection();
		
		//dao
		PurchaseDao pd = new PurchaseDao();
		int result = pd.cartListRemove(conn, cartBreakDownNo);
		
		//tx
		if(result == 1) {
			JDBCTemplate.commit(conn);
		}else {
			JDBCTemplate.rollback(conn);
		}
		
		//close
		JDBCTemplate.close(conn);
		
		return result;
	}

}
