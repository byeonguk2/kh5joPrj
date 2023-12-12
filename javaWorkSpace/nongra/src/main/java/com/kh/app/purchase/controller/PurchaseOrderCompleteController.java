package com.kh.app.purchase.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.kh.app.member.vo.MemberVo;
import com.kh.app.purchase.service.PurchaseService;
import com.kh.app.purchase.vo.PurchaseOrderCompleteVo;

@WebServlet("/order/complete")
public class PurchaseOrderCompleteController extends HttpServlet{
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		try {
			//data
			String totalPrice = req.getParameter("price");
			String addressNo = req.getParameter("addressNo");
			String request = req.getParameter("REQUEST");
			MemberVo loginMember = (MemberVo) req.getSession().getAttribute("loginMember");


			
			//service
			PurchaseService ps = new PurchaseService();
			String orderInformationNo = ps.orderComplete(req, totalPrice, addressNo, request, loginMember);
			
			
			//result
			PurchaseOrderCompleteVo vo = new PurchaseOrderCompleteVo(totalPrice, orderInformationNo);
			
			
			req.setAttribute("orderCompleteVo", vo);
			req.getRequestDispatcher("/WEB-INF/views/purchase/orderComplete.jsp").forward(req, resp);
		}catch (Exception e) {
			System.out.println("[ERROR-OC001] 주문완료하던 중 예외 발생");
			e.printStackTrace();
		}
	}
}
