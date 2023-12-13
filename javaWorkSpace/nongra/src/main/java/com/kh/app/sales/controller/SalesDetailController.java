package com.kh.app.sales.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.kh.app.sales.service.SalesService;
import com.kh.app.sales.vo.SalesVo;

@WebServlet("/sales/detail")
public class SalesDetailController extends HttpServlet{
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		try {
			String salesNo = req.getParameter("salesNo");
			
			SalesService ss = new SalesService();
			
			List<SalesVo> salesVoList = ss.selectSalesDetail();
			
			
			
			req.getRequestDispatcher("/WEB-INF/views").forward(req, resp);
		}catch(Exception e){
			e.printStackTrace();
		}
		
		
		
	}
	
}
