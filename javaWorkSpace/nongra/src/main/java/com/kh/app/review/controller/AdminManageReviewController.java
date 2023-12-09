package com.kh.app.review.controller;

import java.io.IOException;
import java.net.http.HttpResponse.BodySubscriber;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.kh.app.page.vo.PageVo;
import com.kh.app.review.service.ReviewService;
import com.kh.app.review.vo.ReviewVo;


@WebServlet("/admin/manageReview")
public class AdminManageReviewController extends HttpServlet {
		
	
	//	관리자 모든 리뷰 페이지 조회 + 관리창
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
			HttpSession session = req.getSession();
			if(req.getAttribute("DeleteYn") !=null) {
				req.setAttribute("DeleteYn",req.getAttribute("DeleteYn") );	
			}
			
			
		try {
			
			ReviewService rs = new ReviewService();
			//data 
			int listCount = rs.selectReviewCount();
			String currentPage_ =req.getParameter("pno");
			if(currentPage_ ==null) {
				currentPage_ ="1";
			}
			int currentPage = Integer.parseInt(currentPage_);	//현재 페이지
			int pageLimit = 1;
			int boardLimit = 10;
			PageVo pvo =  new PageVo(listCount, currentPage, pageLimit, boardLimit);
			System.out.println("시작"+pvo.getStartRow());
			System.out.println("끝" +pvo.getLastRow());
			
			
		
			//service
			List<ReviewVo> ReviewVoList = rs.manageReviewLookUp(pvo);
			
			
			// result (==view)
			
			req.setAttribute("ReviewVoList", ReviewVoList);
			req.setAttribute("pvo", pvo);
			req.getRequestDispatcher("/WEB-INF/views/review/adminManageReview.jsp").forward(req, resp);
			
			
			
			
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("리뷰 관리자 페이지 에러");
			session.setAttribute("alertMsg", "리뷰 관리자 페이지 실패");
			req.getRequestDispatcher("/WEB-INF/views/common/note/result.jsp").forward(req, resp);
		}
		
		
		
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

	}
}
