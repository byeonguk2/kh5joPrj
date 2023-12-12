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

@WebServlet("/member/orderSure")
public class MemberOrderSureController extends HttpServlet{
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
			
		 HttpSession session = req.getSession();
         MemberVo loginMember = (MemberVo)session.getAttribute("loginMember");
         String ohNo = "21"; 
//        		 (String) req.getParameter("ohNo");
        
                              
     try {
                 
    	 OrderDetailService os = new OrderDetailService();

         //service
//    	 int result = os.memberorderSure(ohNo);
         int result = os.memberorderSure(ohNo);
         
//          result (==view)
         if(result !=1 ) {
        	throw new Exception(); 
         }  
         resp.sendRedirect("/nongra/member/orderDetail");
         req.setAttribute("DeleteYn",req.getAttribute("DeleteYn"));
         
     } catch (Exception e) {
         e.printStackTrace();
     System.out.println(" 멤버 페이지 에러");
         session.setAttribute("alertMsg", "구매 확정 실패");
     req.getRequestDispatcher("/WEB-INF/views/common/note/result.jsp").forward(req, resp);
     }
}
	
	}
	
	
	

