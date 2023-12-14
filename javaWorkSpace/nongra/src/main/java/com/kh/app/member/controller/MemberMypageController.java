package com.kh.app.member.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.kh.app.member.service.MemberService;
import com.kh.app.member.vo.MemberVo;
import com.kh.app.orderdetails.service.OrderDetailService;
import com.kh.app.orderdetails.vo.OrderDetailVo;
import com.kh.app.page.vo.PageVo;
import com.kh.app.review.vo.ReviewVo;

@WebServlet("/member/mypage")
public class MemberMypageController extends HttpServlet {
	 @Override
	  protected void doGet (HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
	      	
		  	
	          HttpSession session = req.getSession();
	          MemberVo loginMember = (MemberVo)session.getAttribute("loginMember");
	      
	          if(req.getAttribute("DeleteYn") !=null) {
	              req.setAttribute("DeleteYn",req.getAttribute("DeleteYn") );    
	          }
	          
	      try {
	          
	          MemberService ms= new MemberService();
	          //data 
	          int listCount = ms.selectReviewCount(loginMember.getNo());
//	          int listCount = os.selectOrderDetailCountByMemberNo("1");
	          String currentPage_ =req.getParameter("pno");
	          if(currentPage_ ==null) {
	              currentPage_ ="1";
	          }
	          int currentPage = Integer.parseInt(currentPage_);    //현재 페이지
	          int pageLimit = 1;
	          int boardLimit = 10;
	          PageVo pvo =  new PageVo(listCount, currentPage, pageLimit, boardLimit);
	          
	       
	      
	          

	          //service
	          List<OrderDetailVo> ReviewVoList = ms.memberReviewLookUp(pvo,loginMember.getNo());
//	          List<OrderDetailVo> orderDetailVoList = os.memberOrderDetailLookUp(pvo,"1");
	          
	          
	          
	          // result (==view)
     
     req.setAttribute("ReviewVoList", ReviewVoList);
     System.out.println(ReviewVoList);
     req.setAttribute("pvo", pvo);
     req.getRequestDispatcher("/WEB-INF/views/member/mypage.jsp").forward(req, resp);
     
	          
	      } catch (Exception e) {
	          e.printStackTrace();
	      System.out.println("[ERROR-M007]마이페이지 조회 중 문제 발생.");
	      req.setAttribute("errorMsg", "마이페이지 조회 실패.,.");
			req.getRequestDispatcher("/WEB-INF/views/common/error.jsp").forward(req, resp);
	      }
}
	
	
}
