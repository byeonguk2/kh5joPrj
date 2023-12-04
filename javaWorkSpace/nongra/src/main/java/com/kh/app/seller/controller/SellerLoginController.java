package com.kh.app.seller.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.kh.app.seller.service.SellerService;
import com.kh.app.seller.vo.SellerVo;

@WebServlet("/seller/login")
public class SellerLoginController extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.getRequestDispatcher("/WEB-INF/views/seller/login/sellerLogin.jsp").forward(req, resp);
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		HttpSession session = req.getSession();
		try {
			
			String id = req.getParameter("id");
			String pwd = req.getParameter("pwd");
			
			SellerVo vo = new SellerVo();
			
			vo.setId(id);
			vo.setPassword(pwd);
			
			SellerService ss = new SellerService();
			SellerVo loginSeller = ss.login(vo);
			
			if(loginSeller == null) {
				throw new Exception();
			}
			
			System.out.println(loginSeller.getPermitYn());
			session.setAttribute("alertMsg", "로그인성공");
			session.setAttribute("loginSeller", loginSeller);
			
			resp.sendRedirect("/nongra/seller/home");
		}catch (Exception e) {
			System.out.println("[ERROR-S004]로그인중 문제 발생.");
			e.printStackTrace();
			session.setAttribute("alertMsg", "로그인실패..");
			resp.sendRedirect("/nongra/seller/login");
		}
		
	}
	
}
