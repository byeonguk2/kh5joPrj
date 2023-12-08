package com.kh.app.purchase.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.kh.app.purchase.service.PurchaseService;

@WebServlet("/cart/AJAX/remove")
public class PurchaseCartAJAXRemoveServlet extends HttpServlet{
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		try {
			//data
			String cartBreakDownNo = req.getParameter("cartBreakDownNo");
			
			//service
			PurchaseService ps = new PurchaseService();
			int result = ps.cartListRemove(cartBreakDownNo);
			
			//result
			PrintWriter out = resp.getWriter();
			String str = "{\"cartBreakDownNo\" : " + Integer.parseInt(cartBreakDownNo) + "}";
			out.write(str);
			
		}catch (Exception e) {
			System.out.println("[ERROR-P_AJAX002] 장바구니 내역 수량 업데이트 중 예외 발생");
			e.printStackTrace();
		}
	}
}
