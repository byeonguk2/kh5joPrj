
 package com.kh.app.review.controller;
  
  import java.io.IOException;
  
  import javax.servlet.ServletException; 
  import javax.servlet.annotation.WebServlet; 
  import javax.servlet.http.HttpServlet;
  
 import javax.servlet.http.HttpServletRequest; 
 import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.kh.app.admin.controller.requestOkControlle;
import com.kh.app.member.vo.MemberVo;
import com.kh.app.review.service.ReviewService;
  
  	@WebServlet("/admin/reviewDelete") 
  	public class AdminManagerReviewDeleteController extends HttpServlet{
  //번호 받아서 리뷰 삭제 (관리자) , (유저)
  @Override 
  protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
	 
		HttpSession session = req.getSession();
	  	MemberVo loginMember = (MemberVo)session.getAttribute("loginMember");
	  	
		  try {
		  
		  //  data 
		  String deleteNo = req.getParameter("DeleteNo"); //service
		  ReviewService rs = new ReviewService();
		  
		  //  result
		  int result = rs.adminManagerReviewDelete(deleteNo);
		  
		  if(result !=1) { throw new Exception(); } 
		  
		  
		  if(loginMember== null) {
		  req.setAttribute("DeleteYn", "성공");
		  req.getRequestDispatcher("/admin/manageReview").forward(req, resp);
		  }else {
			 req.setAttribute("DeleteYn", "성공");
			 req.getRequestDispatcher("/member/manageReview").forward(req, resp);
		}
		    
		 } catch (Exception e) { 
			if(loginMember== null) {
		  req.setAttribute("DeleteYn", "실패");
		  req.getRequestDispatcher("/admin/manageReview").forward(req, resp);
			}else {
				 req.setAttribute("DeleteYn", "실패");
				  req.getRequestDispatcher("/member/manageReview").forward(req, resp);
			}
		 }
	} 
  			
  		
  
  }
  //
