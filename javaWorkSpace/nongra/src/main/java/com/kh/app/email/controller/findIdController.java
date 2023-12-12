package com.kh.app.email.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.google.gson.Gson;

@WebServlet("/email/findId")
public class findIdController extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.getRequestDispatcher("/WEB-INF/views/seller/login/findId.jsp").forward(req, resp);
	}
	
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		HttpSession session = req.getSession();
		System.out.println("요청이 들어");
		try {
			// 입력 인증키
			String AuthenticationKey = req.getParameter("AuthenticationKey");
			System.out.println(AuthenticationKey);
			// 세션 인증키
			String sessionAuthenticationKey = (String)session.getAttribute("AuthenticationKey");
			System.out.println(sessionAuthenticationKey);
			
			// 입력 인증키랑 세션 인증키가 다를경우 에러
			if(!AuthenticationKey.equals(sessionAuthenticationKey)) {
				throw new Exception("인증키가 다름");
			}
			// 인증이 성공하는 경우 성공 메세지 전송
			String success = "인증이 성공하였습니다.";
			Gson gson = new Gson();
			resp.getWriter().write(gson.toJson(success));
			
		}catch (Exception e) {
			// 실패하는경우 실패 메세지 전송
			e.printStackTrace();
			Gson gson = new Gson();
			String fail = "인증번호가 틀렸습니다.";
			resp.getWriter().write(gson.toJson(fail));
		}
		
	}
}
