package com.kh.app.review.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.kh.app.review.service.ReviewService;

@WebServlet("/seller/replyWrite")
public class SellerReplyController extends HttpServlet {
	// 판매자 리뷰 작성
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		HttpSession session = req.getSession();
		try {
			
			
			
			//데이터
			String content  = req.getParameter("content");
			String reviewNo = req.getParameter("reviewNo");
			//서비스 
			
			ReviewService service = new ReviewService();
			int result = service.replyWrite(content,reviewNo);
			//결과
			if(result!=1) {
				throw new Exception();
			}
			
			session.setAttribute("alertMsg", "답글 작성 성공");
			
		} catch (Exception e) {
			
			e.printStackTrace();
			session.setAttribute("alertMsg", "답글 작성 실패");
			System.out.println("리뷰작성 실패");
		}
		resp.sendRedirect("/nongra/seller/manageReview");
		
		
	}
	
}
