package com.kh.app.admin.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.kh.app.admin.service.AdminService;
import com.kh.app.admin.vo.AdminVo;

@WebServlet("/admin/login")
public class AdminLoginController extends HttpServlet{

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		HttpSession session = req.getSession();;
		try {
			String id = req.getParameter("id");
			String password = req.getParameter("password");
			
			AdminVo vo = new AdminVo();
			vo.setAdminId(id);
			vo.setAdminPwd(password);
			
			AdminService adminService = new AdminService();
			AdminVo loginAdmin = adminService.login(vo);
			
			if(loginAdmin == null) {
				throw new Exception("어드민 로그인 실패..");
			}
		}catch (Exception e) {
			session.setAttribute("alertMsg", "로그인이 실패했습니다.");
		}

	}
	
}
