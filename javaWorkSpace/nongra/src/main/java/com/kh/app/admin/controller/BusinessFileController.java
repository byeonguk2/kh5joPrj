package com.kh.app.admin.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;
import com.kh.app.admin.service.AdminService;

@WebServlet("/admin/businessFile")
public class BusinessFileController extends HttpServlet{
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		try {
			resp.setCharacterEncoding("UTF-8");

			// ajax로 요청보냄 
			String no = req.getParameter("no");
			
			// 서비스호출
			AdminService as = new AdminService(); 
			
			Map<String,Object> map = as.selectBusinessInfo(no);
			
			Gson gson = new Gson();
			
			String jsonStr = gson.toJson(map);
			
			PrintWriter out = resp.getWriter();
			out.write(jsonStr);
			
		}catch (Exception e) {
			
		}

		
		
		
		
		
	}
	
}
