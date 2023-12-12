package com.kh.app.review.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.kh.app.member.vo.MemberVo;
import com.kh.app.page.vo.PageVo;
import com.kh.app.review.service.ReviewService;
import com.kh.app.review.vo.ReviewVo;

@WebServlet("/member/ReviewWrite")
public class MemberReviewWriteController extends HttpServlet {

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		HttpSession session = req.getSession();		
		MemberVo loginMember = (MemberVo)session.getAttribute("loginMember");
	
		 
			
		
		
		
	try {
		
		ReviewService rs = new ReviewService();
		//data 
//		int listCount = rs.selectReviewCount(loginMember.getNo());
		
	
	
		//service 
	
		
		
		// result (==view)
		
		req.getRequestDispatcher("/WEB-INF/views/review/memberManageReview.jsp").forward(req, resp);
		req.setAttribute("WriteYn", "리뷰 작성");	
		
		
		
		
	} catch (Exception e) {
		e.printStackTrace();
	System.out.println("리뷰 멤버 페이지 에러");
		session.setAttribute("alertMsg", "리뷰 멤버 페이지 실패");
	req.getRequestDispatcher("/WEB-INF/views/common/note/result.jsp").forward(req, resp);
	}
}
