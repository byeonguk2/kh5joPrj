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
import com.kh.app.seller.vo.SellerVo;

@WebServlet("/seller/manageReview")
public class SellerManageReviewController extends HttpServlet {

   // 판매자 상점 모든 리뷰 페이지 조회 + 관리창[Seller]
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
			HttpSession session = req.getSession();
			
			SellerVo sellerVo = (SellerVo)session.getAttribute("loginSeller");
			
			if(req.getAttribute("DeleteYn") !=null) {
				req.setAttribute("DeleteYn",req.getAttribute("DeleteYn") );	
			}
			
		try {
			
			ReviewService rs = new ReviewService();
			//data 
//			int listCount = rs.selectSellerReviewCount(sellerVo.getSellerNo());
			
//			int listCount = rs.selectReviewCountBySellerNo(sellerVo.getSellerNo());
			int listCount = rs.selectReviewCountBySellerNo("1");
			String currentPage_ =req.getParameter("pno");
			if(currentPage_ == null) {
				currentPage_ ="1";
			}
			int currentPage = Integer.parseInt(currentPage_);	//현재 페이지
			int pageLimit = 1;
			int boardLimit = 10;
			PageVo pvo =  new PageVo(listCount, currentPage, pageLimit, boardLimit);
			
			
		
			//service
//			List<ReviewVo> ReviewVoList = rs.sellerReviewLookUp(pvo,sellerVo.getSellerNo());
			
			List<ReviewVo> ReviewVoList = rs.sellerReviewLookUp(pvo,"1");
			
			
			// result (==view)
			
			req.setAttribute("ReviewVoList", ReviewVoList);
			req.setAttribute("pvo", pvo);
			req.getRequestDispatcher("/WEB-INF/views/review/sellerManageReview.jsp").forward(req, resp);
			
			
			
			
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("리뷰 셀러 페이지 에러");
			session.setAttribute("alertMsg", "리뷰 셀러 페이지 실패");
			req.getRequestDispatcher("/WEB-INF/views/common/note/result.jsp").forward(req, resp);
		}		
	}
			
}
	
	
	

