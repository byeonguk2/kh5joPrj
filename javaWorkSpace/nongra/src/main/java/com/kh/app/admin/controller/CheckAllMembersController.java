package com.kh.app.admin.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;
import com.kh.app.admin.service.AdminService;
import com.kh.app.seller.vo.SellerVo;

@WebServlet("/admin/checkAllMembers")
public class CheckAllMembersController extends HttpServlet{

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		try {
			
			String no = req.getParameter("no");
			
			System.out.println("번호가 들어옴 :"+no);
			
			AdminService service = new AdminService();
			SellerVo vo = service.checkAllMembers(no);
			
			Gson gson = new Gson();
			
			String jsonStr = gson.toJson(vo);
			
			PrintWriter out = resp.getWriter();
			out.write(jsonStr);
			
		}catch (Exception e) {
			
		}

	}
	
}
