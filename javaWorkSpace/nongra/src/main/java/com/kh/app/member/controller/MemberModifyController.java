package com.kh.app.member.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebFilter;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.kh.app.member.service.MemberService;
import com.kh.app.member.vo.MemberVo;

@WebServlet("/member/modify")
public class MemberModifyController extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.getRequestDispatcher("/WEB-INF/views/member/modify.jsp").forward(req, resp);
		
	}
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		HttpSession session=req.getSession();
		MemberVo loginMember= (MemberVo)session.getAttribute("loginMember");
		
		try {
			//data
			String nick=req.getParameter("nick");
			String password=req.getParameter("password");
			String password_re=req.getParameter("password_re");
			String road_address=req.getParameter("road_address");
			String detail_address=req.getParameter("detail_address");
			String phone=req.getParameter("mobile");
			String email=req.getParameter("email");
			
			if(!password.equals(password_re)) {
				throw new Exception("패스워드가 일치하지 않습니다.");
			}
			
			MemberVo vo=new MemberVo();
			vo.setNo(loginMember.getNo());
			vo.setMemberNick(nick);
			vo.setMemberPwd(password);
			vo.setMemberPwd2(password_re);
			vo.setAddr(road_address);
			vo.setAddr2(detail_address);
			vo.setPhone(phone);
			vo.setEmail(email);
			
			//service
			MemberService ms=new MemberService();
			int result= ms.modify(vo);
			
			//result
			if(result==1) {
				session.setAttribute("alertMsg", "회원정보 수정 성공!!!");
				resp.sendRedirect("/nongra/home");
			}else {
				
				throw new Exception();
			}
			
		} catch (Exception e) {
			System.out.println("[ERROR-M004]로그인중 문제 발생.");
			e.printStackTrace();
			req.setAttribute("alertMsg", "회원정보 수정 실패.,.");
			resp.sendRedirect("/nongra/member/modify");
		}
		
		
	}
	

}
