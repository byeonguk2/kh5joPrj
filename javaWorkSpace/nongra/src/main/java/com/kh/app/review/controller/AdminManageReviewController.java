package com.kh.app.review.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.kh.app.page.vo.PageVo;
import com.kh.app.review.service.ReviewService;


@WebServlet("/admin/manageReview")
public class AdminManageReviewController extends HttpServlet {
		
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//		
//		try {
//			ReviewService rs = new ReviewService();
//			
//			int listCount = rs.selectReviewCount();
//			
//			
//			int currentPage =0;
//			PageVo pvo = null;
//			int pageLimit = 1;  // 내가 정함
//			int boardLimit = 10;  //내가 정함
//			
//			if(req.getParameter("pno")!=null) {
//			 currentPage = Integer.valueOf(req.getParameter("pno")); // 현재 페이지
//			
//			}else {
//				currentPage =1;
//			}
//			pvo = new PageVo(listCount, currentPage, pageLimit, boardLimit);
//			
//			
//			req.getRequestDispatcher("/WEB-INF/views/review/adminManageReview.jsp").forward(req, resp);
//			
//		} catch (Exception e) {
//			// TODO: handle exception
//		}
//		
		
		
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

	}
}
