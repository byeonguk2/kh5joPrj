package com.kh.app.admin.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;
import com.google.gson.JsonObject;
import com.kh.app.admin.service.AdminService;

@WebServlet("/admin/freeze")
public class memberFreezeCotroller extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		resp.setCharacterEncoding("UTF-8");
		try {
			// 회원번호 받아오기
			String no = req.getParameter("no");
			String yn = req.getParameter("yn");
			System.out.println(yn);
			
			// 서비스 생성,호출
			AdminService as = new AdminService();
			int result = as.freezeMember(no,yn);
			
			// result 검사
			if(result != 1) {
				throw new Exception();
			}
			
			Gson gson = new Gson();
			JsonObject jsonObject = new JsonObject();  
			if(yn.equals("N")) {
				jsonObject.addProperty("succees", "회원 정지가 성공하였습니다");
			}else {
				jsonObject.addProperty("succees", "회원 정지해제가 성공하였습니다");
			}
			
			String jsonStr = gson.toJson(jsonObject);
			
			resp.getWriter().write(jsonStr);
			
		}catch (Exception e) {
			e.printStackTrace();
			Gson gson = new Gson();
			JsonObject jsonObject = new JsonObject();        
			jsonObject.addProperty("fail", "회원정지가 실패하였습니다");
			 String jsonStr = gson.toJson(jsonObject);
			System.out.println("회원정지중 실패..");
			resp.getWriter().write(jsonStr);
		}
		
	}
	
}
