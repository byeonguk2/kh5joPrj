package com.kh.app.member.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.kh.app.member.service.MemberService;
import com.kh.app.member.vo.MemberVo;

@WebServlet("/member/login")
public class MemberLoginController extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.getRequestDispatcher("/WEB-INF/views/member/login.jsp").forward(req, resp);
	}
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		HttpSession session=req.getSession();
	
		try {
			req.setCharacterEncoding("UTF-8");
			String memberId=req.getParameter("id");
			String memberPwd=req.getParameter("pwd");

			MemberVo vo=new MemberVo();
			vo.setMemberId(memberId);
			vo.setMemberPwd(memberPwd);
			
			//서비스
			MemberService ms= new MemberService();
			MemberVo loginMember=ms.login(vo);

			
			//결과
			if(loginMember==null) {
				
				throw new Exception("로그인을 실패하였습니다.");
			}
			session.setAttribute("loginMember",loginMember );
			resp.sendRedirect("/nongra/home");
			
		} catch (Exception e) {
			System.out.println("[ERROR-M004]로그인중 문제 발생.");
			e.printStackTrace();
			session.setAttribute("alertMsg", "로그인 실패.,.");
			resp.sendRedirect("/nongra/member/login");
		}
		
	}
	
}//class
