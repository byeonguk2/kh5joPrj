package com.kh.app.purchase.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.kh.app.member.vo.MemberVo;
import com.kh.app.purchase.service.PurchaseService;
import com.kh.app.purchase.vo.PurchaseCartVo;

@WebServlet("/cart")
public class PurchaseCartController extends HttpServlet{
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		try {
			//data
			MemberVo loginMember = (MemberVo) req.getSession().getAttribute("loginMember");
//			if(loginMember == null) {
//				throw new Exception("잘못된 접근입니다.(로그인 정보 없음)");
//			}
			
			//service
			PurchaseService ps = new PurchaseService();
			List<PurchaseCartVo> purchaseCartVoList= ps.cartList(loginMember);
			
			//result(==view)
			req.setAttribute("purchaseVoList", purchaseCartVoList);
			req.getRequestDispatcher("/WEB-INF/views/purchase/cart.jsp").forward(req, resp);
			
		}catch(Exception e) {
			System.out.println("[ERROR-P001]장바구니 목록 불러오는 중 예외 발생");
			e.printStackTrace();
		}
	}//doGet
}//class
