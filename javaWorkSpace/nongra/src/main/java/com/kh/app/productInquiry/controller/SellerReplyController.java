package com.kh.app.productInquiry.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.kh.app.productInquiry.service.ProductInquiryService;
import com.kh.app.review.service.ReviewService;

@WebServlet("/seller/InquiryreplyWrite")
public class SellerReplyController extends HttpServlet {
			// 판매자 문의 답변 작성
		@Override
		protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
			System.out.println("문의 포스트 호출");
			HttpSession session = req.getSession();
			try {
				
				//데이터
				String content  = req.getParameter("content");
				String inquireNo = req.getParameter("inquireNo");
				//서비스 
				
				ProductInquiryService service = new ProductInquiryService();
				int result = service.replyWrite(content,inquireNo);
				//결과
				if(result!=1) {
					throw new Exception();
				}
				
				session.setAttribute("alertMsg", "문의 답변 작성 성공");
				
			} catch (Exception e) {
				
				e.printStackTrace();
				session.setAttribute("alertMsg", "문의 답변 작성 실패");
				System.out.println("리뷰작성 실패");
			}
			resp.sendRedirect("/nongra/seller/manageInquiry");
			
			
		}
		
	}