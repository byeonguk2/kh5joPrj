package com.kh.app.home;

import java.io.IOException;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;
import com.kh.app.home.service.HomeService;

@WebServlet("/home/select")
public class selectSalesHomeController extends HttpServlet {
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		try {
			
			HomeService hs = new HomeService();
			Map<String , Object> map = hs.selectItemList();
			
			Gson gson = new Gson();
			String jsonStr = gson.toJson(map); 
			
			resp.getWriter().write(jsonStr);
			
		}catch (Exception e) {
			
			e.printStackTrace();
			
		}
		
	}
	
}
