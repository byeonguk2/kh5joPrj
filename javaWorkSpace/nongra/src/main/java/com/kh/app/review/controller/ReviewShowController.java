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

import oracle.jdbc.internal.XSSessionNamespace;

// [상품번호랑 유저번호로] 리뷰조회 및 좋아요 수행
@WebServlet("/member/showReviewByItem")
public class ReviewShowController extends HttpServlet {
	
//	관리자 모든 리뷰 페이지 조회 + 관리창
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
			HttpSession session = req.getSession();
			
			MemberVo loginMember = (MemberVo)session.getAttribute("loginMember");
			String salesNo = req.getParameter("salesNo");
			
		try {
			
			ReviewService rs = new ReviewService();
			//data 
//			int listCount =rs.selectReviewCountByItemNo(salesNo,loginMember.getNo());
			
			int listCount = rs.selectReviewCountByItemNo("1","1");
			String currentPage_ =req.getParameter("pno");
			if(currentPage_ ==null) {
				currentPage_ ="1";
			}
			int currentPage = Integer.parseInt(currentPage_);	//현재 페이지
			int pageLimit = 1;
			int boardLimit = 10;
			PageVo pvo =  new PageVo(listCount, currentPage, pageLimit, boardLimit);
			
			//service
			 List<ReviewVo> ReviewVoList = rs.memberReviewShow(pvo,"1","1");
			//List<ReviewVo> ReviewVoList = rs.memberReviewShow(pvo,salesNo,loginMember.getNo());
			
			
			// result (==view)
			
			req.setAttribute("ReviewVoList", ReviewVoList);
			req.setAttribute("pvo", pvo);
			req.getRequestDispatcher("/WEB-INF/views/review/showReviewByItem.jsp").forward(req, resp);
			
			
			
			
			
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("리뷰 페이지 에러");
			session.setAttribute("alertMsg", "리뷰 페이지 실패");
			req.getRequestDispatcher("/WEB-INF/views/common/note/result.jsp").forward(req, resp);
		}
	}

}
