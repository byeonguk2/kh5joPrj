package com.kh.app.purchase.service;

import java.sql.Connection;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import com.kh.app.member.vo.MemberVo;
import com.kh.app.purchase.dao.PurchaseDao;
import com.kh.app.purchase.vo.PurchaseAddressVo;
import com.kh.app.purchase.vo.PurchaseCartVo;
import com.kh.app.purchase.vo.PurchaseOrderCheckoutVo;
import com.kh.app.purchase.vo.PurchaseOrderCompleteVo;
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
		PurchaseDao dao = new PurchaseDao();
		int result = dao.cartEAUpdate(conn, cartBreakDownNo, cartBreakDownEa);
		
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
		PurchaseDao dao = new PurchaseDao();
		int result = dao.cartListRemove(conn, cartBreakDownNo);
		
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

	//주문서 불러오기
	public PurchaseOrderCheckoutVo orderCheckOut(MemberVo loginMember) throws Exception {
		//conn
		Connection conn = JDBCTemplate.getConnection();
		
		//dao
		PurchaseDao dao = new PurchaseDao();
		PurchaseOrderCheckoutVo orderCheckOutVo = new PurchaseOrderCheckoutVo();
			//장바구니 목록
			List<PurchaseCartVo> purchaseCartVoList = dao.cart(conn, loginMember);
			orderCheckOutVo.setCartVoList(purchaseCartVoList);
			
			//배송지 정보
			PurchaseAddressVo addressVo = dao.takeAddress(conn, loginMember);
			orderCheckOutVo.setAddressVo(addressVo);
			
		//close
		JDBCTemplate.close(conn);
		
		return orderCheckOutVo;
	}

	//배송지 전체 가지고 오기
	public List<PurchaseAddressVo> takeAllAddress(MemberVo loginMember) throws Exception {
		//conn
		Connection conn = JDBCTemplate.getConnection();
		
		//dao
		PurchaseDao dao = new PurchaseDao();
		List<PurchaseAddressVo> voList = dao.takeAllAddress(conn, loginMember);
		
		//close
		JDBCTemplate.close(conn);
		
		
		
		return voList;		
	}

	//결제확인
	public String orderComplete(HttpServletRequest req, String totalPrice, String addressNo, String request, MemberVo loginMember) throws Exception {
		//conn
		Connection conn = JDBCTemplate.getConnection();
		
		//dao
		PurchaseDao dao = new PurchaseDao();
		
			//해당 멤버 장바구니 번호 불러오기
		String orderNo = dao.takeCartNo(conn, loginMember);
			//장바구니 END_YN 'Y'로 변경
		int updateResult = dao.cartEndYnUpdate(conn, orderNo);
			//주문 정보 입력
		int orderInformationResult = dao.putOrderInformation(conn, addressNo, totalPrice, request);
			//방금 넣은 주문 정보 번호 가져오기
		String orderInformationNo = dao.takeorderInformation(conn, addressNo, totalPrice);
			//주문 이력 입력
		int orderHistoryResult = dao.putOrderHistory(conn, orderInformationNo, orderNo);
			//잔액에서 결제 금액 차감
		int balanceResult = dao.balanceUpdate(conn, loginMember, totalPrice);
			//남은 잔액 가져옴
		String balancePoint = dao.takePoint(conn, loginMember);
			//로그인 정보에 포인트 업데이트
		loginMember.setPoint(Integer.parseInt(balancePoint));
		HttpSession session=req.getSession();
		session.setAttribute("loginMember",loginMember );
		
		//tx
		if(orderNo != null && updateResult == 1 && orderInformationResult ==1 && orderInformationNo != null && orderHistoryResult == 1 && balanceResult == 1 && balancePoint != null) {
			JDBCTemplate.commit(conn);
		}else {
			JDBCTemplate.rollback(conn);
		}
		
		//close
		JDBCTemplate.close(conn);
		
		return orderInformationNo;
		
	}

	//마이페이지 수정할 배송지 가져오기
	public PurchaseAddressVo takeAddress(String addressNo) throws Exception {
		//conn
		Connection conn = JDBCTemplate.getConnection();
		
		//dao
		PurchaseDao dao = new PurchaseDao();
		PurchaseAddressVo addressVo = dao.takeAddress(conn, addressNo);
		
		//close
		JDBCTemplate.close(conn);
		
		return addressVo;
	}

	//마이페이지 수정된 배송지 DB에 넣기
	public int updateAddress(String no, String name, String phone, String defaultAddress) throws Exception {
		//conn
		Connection conn = JDBCTemplate.getConnection();
		
		///business logic??
		if(defaultAddress == null) {
			defaultAddress = "N";
			
		}else {
			defaultAddress = "Y";
		}
		PurchaseAddressVo addressVo = new PurchaseAddressVo();
		addressVo.setNo(no);
		addressVo.setName(name);
		addressVo.setPhone(phone);
		addressVo.setDefaultAddress(defaultAddress);
		
		//dao
		PurchaseDao dao = new PurchaseDao();
		int result = dao.updateAddress(conn, addressVo);
		
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

	//마이페이지 배송지 주소 새롭게 추가
	public int addAddress(PurchaseAddressVo addressVo, MemberVo loginMember) throws Exception {
		//conn
		Connection conn = JDBCTemplate.getConnection();
		
		//dao
		PurchaseDao dao = new PurchaseDao();
		int result = dao.addAddress(conn, addressVo, loginMember);
		
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

	//마이페이지 주문서 가져오기
	public PurchaseOrderCheckoutVo takeOrderCheckOut(String orderNo) throws Exception {
		//conn
		Connection conn = JDBCTemplate.getConnection();
		
		//dao
		PurchaseDao dao = new PurchaseDao();
		PurchaseOrderCheckoutVo orderCheckOutVo = new PurchaseOrderCheckoutVo();
			//주문번호에 맞는 장바구니 목록
		List<PurchaseCartVo> purchaseCartVoList = dao.endOrderCart(conn, orderNo);
		
		
			//주문번호에 맞는 배송지 정보
//		PurchaseAddressVo addressVo = dao.endOrderAddress(conn, orderNo);
//		orderCheckOutVo.setAddressVo(addressVo);
//		
		//tx

		
		//close
		JDBCTemplate.close(conn);
		
		return null;
	}

}






















