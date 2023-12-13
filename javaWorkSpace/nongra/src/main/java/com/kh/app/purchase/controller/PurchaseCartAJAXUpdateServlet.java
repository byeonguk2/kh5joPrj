package com.kh.app.purchase.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.kh.app.purchase.service.PurchaseService;

@WebServlet("/cart/AJAX/update")
public class PurchaseCartAJAXUpdateServlet extends HttpServlet{
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		try {

			//data
			String cartBreakDownNo = req.getParameter("cartBreakDownNo"); //장바구니 내역 번호
			String cartBreakDownEa = req.getParameter("cartBreakDownEa"); //장바구니 내역 변경된 수량
			
			//service
			PurchaseService ps = new PurchaseService();
			int result = ps.cartEAUpdate(cartBreakDownNo, cartBreakDownEa);
			
			//result
			PrintWriter out = resp.getWriter();
			String str = "{\"cartBreakDownNo\" : " + Integer.parseInt(cartBreakDownNo) + ", \"cartBreakDownEa\" : " + Integer.parseInt(cartBreakDownEa) + "}";
			out.write(str);
			
		}catch(Exception e) {
			System.out.println("[ERROR-P_AJAX001] 장바구니 내역 수량 업데이트 중 예외 발생");
			e.printStackTrace();
		}
	}

}
