package com.kh.app.seller.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.kh.app.seller.service.SellerService;

@WebServlet("/seller/idCheck")
public class sellerIdCheckController extends HttpServlet {
	
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		try {
			resp.setCharacterEncoding("UTF-8");
			String check = null;
			//데이터
			String id = req.getParameter("id");
			
			//서비스
			SellerService ss = new SellerService();
			int returnId = ss.idCheck(id);
			
//			check = returnId == 1;
			
			if(returnId == 1) {
				check = "중복된 아이디 입니다.";
			}else {
				check = "사용가능한 아이디 입니다.";
			}
			
			resp.getWriter().print(check);
			
		}catch (Exception e) {
			e.printStackTrace();
			throw new RuntimeException(e);
		}
	
	}
}
