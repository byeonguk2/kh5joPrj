package com.kh.app.seller.controller;

import java.io.IOException;
import java.util.regex.Pattern;

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

	// GET요청 받은 동시에 jsp 파일로 보내줌 
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.getRequestDispatcher("/WEB-INF/views/seller/join/sellerJoin.jsp").forward(req, resp);
	}
	
	// POST파
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		HttpSession session = req.getSession();
		try {
			
			// data 받아오기
			String nick = req.getParameter("nick");
			String id = req.getParameter("id");
			String password = req.getParameter("password");
			
			String password_re = req.getParameter("password_re");
			String email = req.getParameter("email");
			String name = req.getParameter("name");
			String phone = req.getParameter("phone");
			
			// 자바 정규식 (유효성 검사)
			if(!id.matches("[a-z0-9]{4,12}")) {
				throw new Exception("아이디형식이 올바르지 않습니다.");
			}
			if(nick == null || nick.equals("")) {
				throw new Exception("닉네임이 널값입니다.");
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
			if(name == null || name.equals("")) {
				throw new Exception("이름이 널값입니다");
			}
			if(!Pattern.matches("010\\d{3,4}\\d{4}", phone)) {
				throw new Exception("전화번호 형식이 올바르지 않습니다.");
			}
			
			// 판매자 vo 생성 후 데이터 할당 
			SellerVo vo = new SellerVo();
			vo.setNick(nick);
			vo.setId(id);
			vo.setPassword(password);
			vo.setPassword_re(password_re);
			vo.setEmail(email);
			vo.setName(name);
			vo.setPhone(phone);
			
			// 할당 완료된 데이터 세션에 넣기
			session.setAttribute("joinVo", vo);
			
			// 판매자 권한 요청으로 이동
			resp.sendRedirect("/nongra/seller/enroll");
			
		}catch (Exception e) {
			// 실패시 다시 회원가입 페이지로 이동후 알람메세지 
			e.printStackTrace();
			session.setAttribute("alertMsg", "회원가입 실패");
			System.out.println("[ERROR-S001] 회원가입중 예외발생");
			resp.sendRedirect("/nongra/seller/join");
		}
		
		
		
	}
	
}
