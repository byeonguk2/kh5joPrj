package com.kh.app.productInquiry.controller;

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
import com.kh.app.productInquiry.dao.ProductInquiryDao;
import com.kh.app.productInquiry.service.ProductInquiryService;
import com.kh.app.productInquiry.vo.ProductInquiryVo;
import com.kh.app.review.service.ReviewService;
import com.kh.app.review.vo.ReviewVo;

@WebServlet("/member/manageInquiry")
public class MemberMangeInquiry extends HttpServlet {
	
	
//	유저 모든 리뷰 조회[Member]
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
	
		
			HttpSession session = req.getSession();
			
			MemberVo loginMember = (MemberVo)session.getAttribute("loginMember");
		
					
			
			
		
				
		try {
			ProductInquiryService ps = new ProductInquiryService();
			//data 
			int listCount = ps.selectInquiryCountByMemberNo(loginMember.getNo());
//			int listCount = ps.selectInquiryCountByMemberNo("1");
			String currentPage_ =req.getParameter("pno");
			if(currentPage_ ==null) {
				currentPage_ ="1";
			}
			int currentPage = Integer.parseInt(currentPage_);	//현재 페이지
			int pageLimit = 1;
			int boardLimit = 10;
			PageVo pvo =  new PageVo(listCount, currentPage, pageLimit, boardLimit);
		
			
			
		
			//service
			List<ProductInquiryVo> produtInquiryVoList  = ps.memberInquiryLookUp(pvo,loginMember.getNo());

			
			
		
			
			
			// result (==view)
			
			req.setAttribute("produtInquiryVoList", produtInquiryVoList);
			req.setAttribute("pvo", pvo);
			req.getRequestDispatcher("/WEB-INF/views/inquiry/memberManageInquiry.jsp").forward(req, resp);
			
			
			
			
		} catch (Exception e) {
			e.printStackTrace();
		System.out.println("상품문의 멤버 페이지 에러");
			session.setAttribute("alertMsg", "상품문의 멤버 페이지 실패");
		req.getRequestDispatcher("/WEB-INF/views/common/note/result.jsp").forward(req, resp);
		}
	}

}
