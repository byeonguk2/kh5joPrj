package com.kh.app.seller.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.kh.app.sales.service.SalesService;
import com.kh.app.sales.vo.SalesVo;
import com.kh.app.seller.vo.SellerVo;

@WebServlet("/seller/salesList")
public class SellerSalesList extends HttpServlet{
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		HttpSession session = req.getSession();
		
		try {
			SellerVo loginSeller = (SellerVo)session.getAttribute("loginSeller");
			String sellerNo = loginSeller.getSellerNo();
			
			SalesService ss = new SalesService();
			
//			List<SalesVo> salesList = ss.salesList(sellerNo);
			
			
			
			
		}catch(Exception e) {
			e.printStackTrace();
		}
		
	}
	
	
}
