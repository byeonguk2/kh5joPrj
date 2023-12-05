package com.kh.app.seller.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.kh.app.seller.service.SellerService;

@WebServlet("/seller/nickCheck")
public class NickCheckServlet extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
			response.setCharacterEncoding("UTF-8");
			String check = null;
			//데이터
			String nick = request.getParameter("nick");
			
			//서비스
			SellerService ss = new SellerService();
			int returnNick = ss.nickCheck(nick);
			
//			check = returnId == 1;
			
			if(returnNick == 1) {
				check = "중복된 닉네임 입니다.";
				System.out.println(returnNick);
			}else {
				check = "사용가능한 닉네임 입니다.";
				System.out.println(returnNick);
			}
			
			response.getWriter().print(check);
			
			
		}catch (Exception e) {
			e.printStackTrace();
			throw new RuntimeException(e);
		}
	}
}
