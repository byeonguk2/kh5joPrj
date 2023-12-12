package com.kh.app.member.controller;

import java.io.IOException;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.kh.app.member.service.MemberService;
import com.kh.app.member.vo.MemberVo;
import com.kh.app.point.vo.PointVo;

@WebServlet("/member/point")
public class MemberPointController extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		try {
			
			//데이터
			HttpSession session =req.getSession();
			MemberVo loginMember=(MemberVo)session.getAttribute("loginMember");
			
			
			//서비스
			MemberService ms=new MemberService();
			PointVo pv=ms.checkPoint(loginMember);
			
			//결과
			if(pv==null) {
				throw new Exception();
			}
			req.setAttribute("pv",pv);
			req.getRequestDispatcher("/WEB-INF/views/member/point.jsp").forward(req, resp);
			
		} catch (Exception e) {
			System.out.println("[ERROR-M005]포인트 조회 중 문제 발생.");
			e.printStackTrace();
			req.setAttribute("errorMsg", "로그인 실패.,.");
			req.getRequestDispatcher("/WEB-INF/views/common/error.jsp").forward(req, resp);
		}

	}
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		try {
			//데이터
			HttpSession session =req.getSession();
			MemberVo loginMember=(MemberVo)session.getAttribute("loginMember");
			String chargePoint=req.getParameter("point");
			System.out.println(chargePoint);
			//서비스
			MemberService ms=new MemberService();
			int result=ms.charge(loginMember,chargePoint);
			
			//결과
			if(result==2) {
				session.setAttribute("alertMsg", "포인트 충전 성공");
				loginMember.setPoint(loginMember.getPoint()+Integer.parseInt(chargePoint));
				resp.sendRedirect("/nongra/home");
			}else {
				throw new Exception();
			}
			
			
			
		} catch (Exception e) {
			System.out.println("[ERROR-M006]포인트 충전 중 문제 발생.");
			e.printStackTrace();
			req.setAttribute("errorMsg", "로그인 실패.,.");
			req.getRequestDispatcher("/WEB-INF/views/common/error.jsp").forward(req, resp);
		}
	}
}
