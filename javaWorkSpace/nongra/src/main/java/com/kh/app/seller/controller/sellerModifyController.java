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

@WebServlet("/seller/modify")
public class sellerModifyController extends HttpServlet{

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.getRequestDispatcher("/WEB-INF/views/seller/sellerInfo/sellerModify.jsp").forward(req, resp);
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		HttpSession session = req.getSession();
		try {	
			
			String pwd  = req.getParameter("password");
			String pwd2  = req.getParameter("password_re");
			String nick  = req.getParameter("nick");
			String name = req.getParameter("name");
			String phone = req.getParameter("phone");
			String email = req.getParameter("email");
			
			SellerVo loginSeller = (SellerVo)session.getAttribute("loginSeller");
			
			SellerVo vo = new SellerVo();
			vo.setPassword(pwd);
			vo.setPassword_re(pwd2);
			vo.setNick(nick);
			vo.setName(name);
			vo.setPhone(phone);
			vo.setEmail(email);
			vo.setMemberNo(loginSeller.getMemberNo());
			
			//서비스 호출
			SellerService ss = new SellerService();
			int result = ss.modify(vo);
			
			if(result != 1) {
				throw new Exception("result 값이 널임");
			}
			
			loginSeller.setPassword(email);
			loginSeller.setNick(nick);
			loginSeller.setName(name);
			loginSeller.setPhone(phone);
			loginSeller.setEmail(email);
			
			session.setAttribute("alertMsg", "수정이 완료되었습니다.");
			session.setAttribute("loginSeller", loginSeller);
			
			
			resp.sendRedirect("/nongra/seller/select");
			
		}catch (Exception e) {
			System.out.println("회원수정중 예외발생");
			e.printStackTrace();
			session.setAttribute("alertMsg", "수정이 실패했습니다.");
			resp.sendRedirect("/nongra/seller/select");
		}
		
		
		
	}
	
}
