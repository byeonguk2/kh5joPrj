package com.kh.app.seller.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.kh.app.seller.service.SellerService;

@WebServlet("/seller/emailCheck")
public class SellerEmailCheckController extends HttpServlet {
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		
		try {
			resp.setCharacterEncoding("UTF-8");
			String check = null;
			//데이터
			String email = req.getParameter("email");
			
			
			//서비스
			SellerService ss = new SellerService();
			int returnEmail = ss.emailCheck(email);
			
//			check = returnId == 1;
			
			if(returnEmail == 1) {
				check = "중복된 이메일 입니다.";
			}else {
				check = "사용가능한 이메일 입니다.";
			}
			
			resp.getWriter().print(check);
			
		}catch (Exception e) {
			e.printStackTrace();
			throw new RuntimeException(e);
		}
		
	}
	
}
