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

@WebServlet("/seller/join")
public class SellerJoinController extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.getRequestDispatcher("/WEB-INF/views/seller/join/sellerJoin.jsp").forward(req, resp);
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		try {
			req.setCharacterEncoding("UTF-8");
			String nick = req.getParameter("nick");
			String id = req.getParameter("id");
			String password = req.getParameter("password");
			
			String password_re = req.getParameter("password_re");
			String email = req.getParameter("email");
			String name = req.getParameter("name");
			String phone = req.getParameter("phone");
			//문제있음
			if(!id.matches("[a-z0-9]{4,12}")) {
				throw new Exception("아이디형식이 올바르지 않습니다.");
			}
			if(!password.matches("^(?=.*[a-z])(?=.*[A-Z])(?=.*\\d)(?=.*[@$!%*?&])[A-Za-z\\d@$!%*?&]{8,}$")) {
				throw new Exception("비밀번호 형식이 올바르지 않습니다.");
			}
			if(!password.equals(password_re)) {
				throw new Exception("비밀번호가 일치하지 않습니다.");
			}
			if(!email.matches("[0-9a-zA-Z]+(.[_a-z0-9-]+)*@(?:\\w+\\.)+\\w+$")) {
				throw new Exception("이메일 형식이 아닙니다.");
			}
			if(phone.matches(" ^01(?:0|1|[6-9])(?:\\\\d{3}|\\\\d{4})\\\\d{4}$\n")) {
				throw new Exception("전화번호 형식이 올바르지 않습니다.");
			}
			SellerVo vo = new SellerVo();
			vo.setNick(nick);
			vo.setId(id);
			vo.setPassword(password);
			vo.setPassword_re(password_re);
			vo.setEmail(email);
			vo.setName(name);
			vo.setPhone(phone);
			System.out.println(vo);
			HttpSession session = req.getSession();
			session.setAttribute("joinVo", vo);
			resp.sendRedirect("/nongra/seller/enroll");
		}catch (Exception e) {
			e.printStackTrace();
			System.out.println("[ERROR-S001] 회원가입중 예외발생");
			req.setAttribute("errorMsg", "회원가입중 예외발생");
			req.getRequestDispatcher("/WEB-INF/views/common/fail.jsp").forward(req, resp);
		}
		
		
		
	}
	
}
