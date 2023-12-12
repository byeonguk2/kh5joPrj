package com.kh.app.orderdetails.controller;
import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.kh.app.member.vo.MemberVo;
import com.kh.app.orderdetails.service.OrderDetailService;
import com.kh.app.orderdetails.vo.OrderDetailVo;
import com.kh.app.page.vo.PageVo;
import com.kh.app.review.service.ReviewService;
import com.kh.app.review.vo.ReviewVo;

@WebServlet("/member/orderDetail")
class MemberOrderDetailController extends HttpServlet {
//  유저 모든 주문내역 조회[Member]
  @Override
  protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
      
          HttpSession session = req.getSession();
          MemberVo loginMember = (MemberVo)session.getAttribute("loginMember");
      
          if(req.getAttribute("DeleteYn") !=null) {
              req.setAttribute("DeleteYn",req.getAttribute("DeleteYn") );    
          }
          
      try {
          
          OrderDetailService os = new OrderDetailService();
          //data 
//          int listCount = rs.selectReviewCount(loginMember.getNo());
          int listCount = os.selectOrderDetailCountByMemberNo("4");
          String currentPage_ =req.getParameter("pno");
          if(currentPage_ ==null) {
              currentPage_ ="1";
          }
          int currentPage = Integer.parseInt(currentPage_);    //현재 페이지
          int pageLimit = 1;
          int boardLimit = 10;
          PageVo pvo =  new PageVo(listCount, currentPage, pageLimit, boardLimit);
      
          

          //service
//          List<ReviewVo> ReviewVoList = rs.memberReviewLookUp(pvo,loginMember.getNo());
          List<OrderDetailVo> orderDetailVoList = os.memberOrderDetailLookUp(pvo,"4");
          
      
      
      
          
          
          // result (==view)
          
          req.setAttribute("orderDetailVoList", orderDetailVoList);
          req.setAttribute("pvo", pvo);
          req.getRequestDispatcher("/WEB-INF/views/orderDetail/memberManageOrderDetail.jsp").forward(req, resp);
          
          
          
          
      } catch (Exception e) {
          e.printStackTrace();
      System.out.println("리뷰 멤버 페이지 에러");
          session.setAttribute("alertMsg", "리뷰 멤버 페이지 실패");
      req.getRequestDispatcher("/WEB-INF/views/common/note/result.jsp").forward(req, resp);
      }
  }
  
}        
  