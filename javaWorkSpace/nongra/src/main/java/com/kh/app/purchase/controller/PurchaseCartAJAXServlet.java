package com.kh.app.purchase.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/cart/AJAX")
public class PurchaseCartAJAXServlet extends HttpServlet{
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String cartBreakDownNo = req.getParameter("cartBreakDownNo");
		String cartBreakDownEa = req.getParameter("cartBreakDownEa");
		System.out.println(cartBreakDownNo);
		System.out.println(cartBreakDownEa);
	}

}
