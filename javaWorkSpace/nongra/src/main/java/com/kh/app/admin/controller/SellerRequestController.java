package com.kh.app.admin.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.kh.app.admin.service.AdminService;
import com.kh.app.seller.vo.SellerVo;

@WebServlet("/admin/request")
public class SellerRequestController extends HttpServlet{
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		AdminService as = new AdminService();
		
		List<SellerVo> voList = as.request();
		
		req.getRequestDispatcher("/WEB-INF/views/admin/member/memberRequest.jsp").forward(req, resp);
		
	}
	
}
