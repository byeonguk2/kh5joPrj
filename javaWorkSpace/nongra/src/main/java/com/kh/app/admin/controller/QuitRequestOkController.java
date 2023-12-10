package com.kh.app.admin.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;
import com.google.gson.JsonObject;
import com.kh.app.admin.service.AdminService;
import com.kh.app.page.vo.PageVo;
import com.kh.app.seller.vo.SellerVo;

@WebServlet("/admin/quitReqestOk")
public class QuitRequestOkController extends HttpServlet{

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		resp.setCharacterEncoding("UTF-8");
		try {
			
			String no = req.getParameter("no");
			System.out.println(no);
			
			AdminService as = new AdminService(); 
			
			int result = as.QuitRequestOk(no);
			
			if(result != 1) {
				throw new Exception();
			}
			 Gson gson = new Gson();
			 JsonObject jsonObject = new JsonObject();    
			 
			 jsonObject.addProperty("result", "회원정지 수락 완료");
			 String jsonStr = gson.toJson(jsonObject);
			 System.out.println(jsonStr);
			 
			PrintWriter out = resp.getWriter();
			
			out.write(jsonStr);
			
		}catch (Exception e) {
			System.out.println("판매자 정지중 문제발생..");
			e.printStackTrace(); 
			PrintWriter out = resp.getWriter();
			
			out.write("");
		}
		
	}	

}
