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

@WebServlet("/member/delete")
public class MemberDeleteController extends HttpServlet	 {
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.getRequestDispatcher("/WEB-INF/views/member/delete.jsp").forward(req, resp);
	}
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		try {
			//data
			req.setCharacterEncoding("UTF-8");
			String no=req.getParameter("no");
			
			
			//서비스
			MemberService ms=new MemberService();
			int result=ms.delete(no);
			
			//result
			if(result==1) {
				HttpSession session=req.getSession();
				session.setAttribute("alertMsg", "회원탈퇴 성공");
				resp.sendRedirect("/nongra/home");
			}else {
				throw new Exception();
			}
		} catch (Exception e) {
			System.out.println("[ERROR-M004]로그인중 문제 발생.");
			e.printStackTrace();
			req.setAttribute("alertMsg", "회원탈퇴 실패.,.");
			resp.sendRedirect("/nongra/member/delete");
		}
	}
}
