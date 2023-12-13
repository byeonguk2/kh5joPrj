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
			
		}catch (Exception e) {
			e.printStackTrace();
			System.out.println("[ERROR-M001] 마이페이지 주문상세페이지 불러오는중 예외 발생");
		}
	}
}
