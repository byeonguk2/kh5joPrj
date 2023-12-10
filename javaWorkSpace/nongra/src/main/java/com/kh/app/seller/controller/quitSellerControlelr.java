package com.kh.app.seller.controller;

import java.io.IOException;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.kh.app.seller.service.SellerService;
import com.kh.app.seller.vo.SellerVo;

@WebServlet("/seller/quit")
public class quitSellerControlelr extends HttpServlet{

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		try {
			
			// 세션에 담겨있는 로그인 정보 가져오기
			SellerVo loginSeller = (SellerVo)req.getSession().getAttribute("loginSeller");
			
			// 서비스 호출후 map리턴받기 (다오에서 받아온 카운트한 정보를 가져옴)
			SellerService ss = new SellerService();
			Map<String,Object> map = ss.bringProductRelatedInformation(loginSeller);
			
			// request 저장소에 map저장
			req.setAttribute("map", map);
			req.getRequestDispatcher("/WEB-INF/views/seller/sellerInfo/quitSeller.jsp").forward(req, resp);
			
		}catch (Exception e) {
			
			System.out.println("판매내역 조회중 문제발생..");
			
			
		}
		
		
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		String alertMsg = ""; 
		HttpSession session = req.getSession();
		try {
			
			String completedOrderCnt = req.getParameter("completedOrderCnt");
			String allRefundCnt = req.getParameter("allRefundCnt");
			String allProductCnt = req.getParameter("allProductCnt");
			SellerVo loginSeller = (SellerVo)session.getAttribute("loginSeller");
			
			System.err.println(loginSeller.getRequestQuitYn());
			if(loginSeller.getRequestQuitYn().equals("Y")) {
				alertMsg = "이미 탈퇴요청을 보낸 상태 입니다.";
				throw new Exception(alertMsg);
			}
			
			if(!completedOrderCnt.equals("0")) {
				alertMsg = "탈퇴조건이 알맞지 않습니다";
				throw new Exception(alertMsg);
			}
			if(!allRefundCnt.equals("0")) {
				alertMsg = "탈퇴조건이 알맞지 않습니다";
				throw new Exception(alertMsg);
			}
			if(!allProductCnt.equals("0")) {
				alertMsg = "탈퇴조건이 알맞지 않습니다";
				throw new Exception(alertMsg);
			}
			
			SellerService ss = new SellerService();
			int result = ss.quitSeller(loginSeller);
			
			if(result != 1 ) {
				alertMsg = "회원 탈퇴실패..";
				throw new Exception("result가 1이 아님");
			}
			
			alertMsg = "회원탈퇴 요청이 완료되었습니다.";
			loginSeller.setRequestQuitYn("Y");
			session.setAttribute("alertMsg", alertMsg);
			resp.sendRedirect("/nongra/seller/quit");
			
		}catch (Exception e) {
			
			System.out.println("회원 탈퇴중 예외발생..");
			System.out.println(e.getMessage());
			e.printStackTrace();
			session.setAttribute("alertMsg", alertMsg);
			resp.sendRedirect("/nongra/seller/quit");
			
		}
		
		
		
		
	}
}
