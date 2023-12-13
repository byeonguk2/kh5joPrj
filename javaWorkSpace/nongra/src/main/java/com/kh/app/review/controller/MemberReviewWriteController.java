package com.kh.app.review.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.servlet.http.Part;

import com.kh.app.member.vo.MemberVo;
import com.kh.app.page.vo.PageVo;
import com.kh.app.review.service.ReviewService;
import com.kh.app.review.vo.ReviewVo;

@MultipartConfig(
		maxFileSize = 1024 * 1024 * 10 , 
		maxRequestSize =  1024*1024*10 *5 
		)   // 50 MB
@WebServlet("/member/ReviewWrite")
public class MemberReviewWriteController extends HttpServlet {

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		System.out.println("포스트호출되는데");
		HttpSession session = req.getSession();		
		MemberVo loginMember = (MemberVo)session.getAttribute("loginMember");
		String cbNo = req.getParameter("cbNo"); 
		String secret = req.getParameter("secret");
		String content = req.getParameter("content");
		 
	try {
		
		Collection<Part> parts = req.getParts();
		ArrayList<Part> fileList = new ArrayList<Part>();
		for (Part part : parts) {
            if (part.getSubmittedFileName() != null) {
            		fileList.add(part);
            }
            
            System.out.println(fileList.size());
		
		
		
		
		ReviewService rs = new ReviewService();
		// data 
		// int listCount = rs.selectReviewCount(loginMember.getNo());
		
		
		
		//service
		//int result = rs.memberReiewWrite(loginMember.getNo(),cbNo);
		/*
		 * int result = rs.memberReiewWrite("1",cbNo);
		 * 
		 * 
		 * 
		 * 
		 * // result (==view)
		 * 
		 * if(result)
		 */
		
		//-> getRequestDispatcher()는 요청을 그대로 들고 가는 걸 알고 있으면 된다.
		resp.sendRedirect(req.getContextPath()+"/member/orderDetail");
//		resp.sendRedirect(req.getContextPath()+"/member/orderDetail");
		req.setAttribute("WriteYn", "리뷰 작성");	
		
		
		
		
	} catch (Exception e) {
		e.printStackTrace();
	System.out.println("리뷰 멤버 페이지 에러");
		session.setAttribute("alertMsg", "리뷰 멤버 페이지 실패");
	req.getRequestDispatcher("/WEB-INF/views/common/note/result.jsp").forward(req, resp);
	}
	}
}
