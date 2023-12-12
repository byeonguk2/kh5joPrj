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

@WebServlet("/sales/list")
public class SalesListController extends HttpServlet{
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		try {
			SalesService ss = new SalesService();
			List<SalesVo> salesVoList = ss.salesListSelect();
			
			if(salesVoList == null) {
				throw new Exception("목록 불러오는 중에 오류 발생");
			}
			
			for (SalesVo salesVo : salesVoList) {
				System.out.println(salesVo);
			}
			
			req.setAttribute("salesVoList", salesVoList);
			req.getRequestDispatcher("/WEB-INF/views/sales/salesList.jsp").forward(req, resp);
		}catch(Exception e) {
			e.printStackTrace();
		}
		
		
	}

}
