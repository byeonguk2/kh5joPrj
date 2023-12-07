package com.kh.app.member.controller;

import java.io.IOException;
import java.util.regex.Pattern;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.kh.app.member.service.MemberService;
import com.kh.app.member.vo.MemberVo;

@WebServlet("/member/join")
public class MemberJoinController extends HttpServlet{
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.getRequestDispatcher("/WEB-INF/views/member/join.jsp").forward(req, resp);
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		try {
			//data
			String memberId=req.getParameter("id");
			String memberPwd=req.getParameter("password");
			String memberPwd2=req.getParameter("password_re");
			String memberNick=req.getParameter("nick");
			String memberName=req.getParameter("name");
			String memberBirth=req.getParameter("birth");
			String memberPhone=req.getParameter("phone");
			String memberEmail=req.getParameter("email");
			String memberAddr=req.getParameter("loadnum");
			String memberAddr2=req.getParameter("detailaddress");
			
			

			// 자바 정규식 (유효성 검사)
			if(!memberId.matches("[a-z0-9]{4,12}")) {
				throw new Exception("아이디형식이 올바르지 않습니다.");
			}
			if(memberNick == null || memberNick.equals("")) {
				throw new Exception("닉네임이 널값입니다.");
			}
			if(!memberPwd.matches("^(?=.*[a-z])(?=.*[A-Z])(?=.*\\d)(?=.*[@$!%*?&])[A-Za-z\\d@$!%*?&]{8,}$")) {
				throw new Exception("비밀번호 형식이 올바르지 않습니다.");
			}
			if(!memberPwd.equals(memberPwd2)) {
				throw new Exception("비밀번호가 일치하지 않습니다.");
			}
			if(!memberEmail.matches("[0-9a-zA-Z]+(.[_a-z0-9-]+)*@(?:\\w+\\.)+\\w+$")) {
				throw new Exception("이메일 형식이 아닙니다.");
			}
			if(memberName == null || memberName.equals("")) {
				throw new Exception("이름이 널값입니다");
			}
			if(!Pattern.matches("010\\d{3,4}\\d{4}", memberPhone)) {
				throw new Exception("전화번호 형식이 올바르지 않습니다.");
			}
			
			
			MemberVo vo= new MemberVo();
			vo.setMemberId(memberId);
			vo.setMemberPwd(memberPwd);
			vo.setMemberPwd2(memberPwd2);
			vo.setMemberNick(memberNick);
			vo.setName(memberName);
			vo.setBirth(memberBirth);
			vo.setPhone(memberPhone);
			vo.setEmail(memberEmail);
			vo.setAddr(memberAddr);
			vo.setAddr2(memberAddr2);
			
			//서비스
			MemberService ms =new MemberService();
			int result=ms.join(vo);
			
			
			//결과
			if(result==1) {
				HttpSession session=req.getSession();
				session.setAttribute("alertMsg", "회원가입 성공");
				resp.sendRedirect("/nongra/member/login");
			}//else {
//				resp.sendRedirect("/nongra/member/join");
//			}
			
			
		} catch (Exception e) {
			// 실패시 다시 회원가입 페이지로 이동후 알람메세지 
			System.out.println("[ERROR-M001] 회원가입 중 예외 발생");
			e.printStackTrace();
			req.setAttribute("alertMsg", "회원가입 실패");
			resp.sendRedirect("/nongra/member/join");
		}
	}

}
