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


//리뷰관리 (회원)
@WebServlet("/member/manageReview")
public class MemberMangeReviewController extends HttpServlet{
	
	
	//	유저 모든 리뷰 조회[Member]
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
	
		
			HttpSession session = req.getSession();
			
			MemberVo loginMember = (MemberVo)session.getAttribute("loginMember");
		
					
			
			
			if(req.getAttribute("DeleteYn") !=null) {
				req.setAttribute("DeleteYn",req.getAttribute("DeleteYn") );	
			}
			
			
		try {
			
			ReviewService rs = new ReviewService();
			//data 
		    int listCount = rs.selectReviewCountByMemberNo(loginMember.getNo());
			//int listCount = rs.selectReviewCountByMemberNo("1");
			String currentPage_ =req.getParameter("pno");
			if(currentPage_ ==null) {
				currentPage_ ="1";
			}
			int currentPage = Integer.parseInt(currentPage_);	//현재 페이지
//			int currentPage = Integer.parseInt("2");
			int pageLimit = 1;
			int boardLimit = 10;
			PageVo pvo =  new PageVo(listCount, currentPage, pageLimit, boardLimit);
		
			
			
		
			//service
			List<ReviewVo> ReviewVoList = rs.memberReviewLookUp(pvo,loginMember.getNo());
//			List<ReviewVo> ReviewVoList = rs.memberReviewLookUp(pvo,"1");
			
			for (ReviewVo reviewVo : ReviewVoList) {
				System.out.println(reviewVo.getReviewFileVolist());
			}
		
			
			
			// result (==view)
			
			req.setAttribute("ReviewVoList", ReviewVoList);
			req.setAttribute("pvo", pvo);
			req.getRequestDispatcher("/WEB-INF/views/review/memberManageReview.jsp").forward(req, resp);
			
			
			
			
		} catch (Exception e) {
			e.printStackTrace();
		System.out.println("리뷰 멤버 페이지 에러");
			session.setAttribute("alertMsg", "리뷰 멤버 페이지 실패");
		req.getRequestDispatcher("/WEB-INF/views/common/note/result.jsp").forward(req, resp);
		}
	}
	
}		
		
		
	
	

	


