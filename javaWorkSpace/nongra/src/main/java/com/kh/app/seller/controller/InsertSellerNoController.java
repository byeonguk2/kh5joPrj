package com.kh.app.seller.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.kh.app.seller.service.SellerService;
import com.kh.app.seller.vo.SellerVo;

@WebServlet("/seller/insertNo")
public class InsertSellerNoController extends HttpServlet {

	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		try {
			SellerVo vo = (SellerVo)req.getAttribute("joinVo");
			
			SellerService ss = new SellerService();
			String sellerNo = ss.selectNo(vo);
			vo.setSellerNo(sellerNo);
			int result = ss.insertNo(vo);
			
			if(result != 1) {
				throw new Exception();
			}
			HttpSession session = req.getSession();
			session.setAttribute("alertMsg", "회원가입이 완료되었습니다.");
			resp.sendRedirect("/nongra/seller/login");
			
		}catch (Exception e) {
			System.out.println("번호 입력중 문제생김..");
			e.printStackTrace();
			req.setAttribute("errorMsg", "번호 입력중 문제생김..");
			req.getRequestDispatcher("/WEB-INF/views/common/fail.jsp").forward(req, resp);
		}
		
	}
	
}
