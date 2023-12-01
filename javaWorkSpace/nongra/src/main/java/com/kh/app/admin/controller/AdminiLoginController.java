package com.kh.app.admin.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.kh.app.admin.vo.AdminVo;

@WebServlet("/admin/login")
public class AdminiLoginController extends HttpServlet{

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.getRequestDispatcher("/WEB-INF/views/admin/login/login.jsp").forward(req, resp);
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		// 요청값 받고 변수에 할당
		String id = req.getParameter("id");
		String pwd = req.getParameter("pwd");
		
		// vo객체 선언 
		AdminVo vo = new AdminVo();
		vo.setAdminId(id);
		vo.setAdminPwd(pwd);
		
	}
	
}
