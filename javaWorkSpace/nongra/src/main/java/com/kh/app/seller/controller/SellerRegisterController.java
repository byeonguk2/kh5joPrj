package com.kh.app.seller.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.kh.app.category.vo.CategoryVo;

@WebServlet("/seller/register")
public class SellerRegisterController extends HttpServlet{
	
	@Override
	protected void doGet(HttpServletRequest req, javax.servlet.http.HttpServletResponse resp)
			throws ServletException, IOException {
		
		
		req.getRequestDispatcher("/WEB-INF/views/seller/sellerItem/register.jsp").forward(req, resp);
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String title = req.getParameter("title");
		String price = req.getParameter("price");
		String stock = req.getParameter("stock");
		String origin = req.getParameter("origin");
		
		
		
	}
	
	
}
