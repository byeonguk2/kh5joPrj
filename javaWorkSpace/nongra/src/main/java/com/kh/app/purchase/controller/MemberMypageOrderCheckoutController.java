package com.kh.app.purchase.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.kh.app.purchase.service.PurchaseService;
import com.kh.app.purchase.vo.PurchaseOrderCheckoutVo;

@WebServlet("/mypage/order/checkout")
public class MemberMypageOrderCheckoutController extends HttpServlet{
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		try {
			//data
			String orderNo = req.getParameter("orderNo");
			
			//service
			PurchaseService ps = new PurchaseService();
			PurchaseOrderCheckoutVo orderCheckOutVo = ps.takeOrderCheckOut(orderNo);
			
			//result
			req.setAttribute("orderCheckOutVo", orderCheckOutVo);
			req.getRequestDispatcher("/WEB-INF/views/member/orderDetail.jsp").forward(req, resp);
			
		}catch (Exception e) {
			e.printStackTrace();
			System.out.println("[ERROR-M001] 마이페이지 주문상세페이지 불러오는중 예외 발생");
		}
	}
	
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		try {
			//data
			String orderNo = req.getParameter("orderNo");
			String refundReason = req.getParameter("REFUND_REASON");
			
			//service
			PurchaseService ps = new PurchaseService();
			int result = ps.orderRefund(orderNo, refundReason);
			System.out.println(result);
			//result
			resp.sendRedirect("/nongra/member/orderDetail");
			
		}catch (Exception e) {
			e.printStackTrace();
			System.out.println("[ERROR]환불 진행 중 예외 발생");
		}
	}
	
}
