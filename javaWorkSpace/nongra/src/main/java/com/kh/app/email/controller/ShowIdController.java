package com.kh.app.email.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;
import com.google.gson.JsonObject;
import com.kh.app.email.service.EmailService;

@WebServlet("/email/selectId")
public class showIdController extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		try {
			
			String email = req.getParameter("email");
			System.out.println(email);
			
			EmailService es = new EmailService();
			String id = es.selectId(email);
			
			System.out.println(id);
			
			if(id == null) {
				throw new Exception();
			}
			
			resp.getWriter().write("회원님의 아이디: "+id);
			
		}catch (Exception e) {
			e.printStackTrace();

			resp.getWriter().write("아이디 조회를 실패했습니다.");
		}
		
	}
	
}
