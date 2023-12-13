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

@WebServlet("/sales/categoryList")
public class SalesCategoryNoListController extends HttpServlet{
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		try {
			String categoryNo = req.getParameter("categoryNo");
			SalesService ss = new SalesService();
			
			int listCount = ss.selectSalesCount(categoryNo);
			List<SalesVo> salesVoList =  ss.salesCategoryNoSelect(categoryNo);
			
			System.out.println(salesVoList);
			
			if(salesVoList == null) {
				throw new Exception("상품 목록 가져오는 중에 디비 문제 발생");
			}
			
			req.setAttribute("listCount", listCount);
			req.setAttribute("salesVoList", salesVoList);
			req.getRequestDispatcher("/WEB-INF/views/sales/salesList.jsp").forward(req, resp);
		}catch(Exception e) {
			e.printStackTrace();
		}
		
	}

}
