package com.kh.app.admin.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/admin/logout")
public class AdminLogoutController extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// 기존 세션있으니까, 가져와서 만료시킴
		req.getSession().invalidate();

		req.getSession().setAttribute("alertMsg", "로그아웃 완료!!!");
		resp.sendRedirect("/nongra/admin/login");
	}
	
}
