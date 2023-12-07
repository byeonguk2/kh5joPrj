package com.kh.app.review.controller;

import java.io.IOException;
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
		try {
			ReviewService rs = new ReviewService();
			
			
			List<ReviewVo> ReviewVoList = rs.manageReviewLookUp();
			
			if(ReviewVoList.size()==0) {
				throw new Exception();
			}
			
			req.setAttribute("ReviewVoList", ReviewVoList);
			req.getRequestDispatcher("/WEB-INF/views/review/adminManageReview.jsp").forward(req, resp);
			
			
			
			
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
			
			
			
			
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("쪽지작성에러에러");
			session.setAttribute("alertMsg", "조회 실패");
			req.getRequestDispatcher("/WEB-INF/views/common/note/result.jsp").forward(req, resp);
		}
		
		
		
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

	}
}
