package com.kh.app.home;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;
import com.kh.app.home.service.HomeService;
import com.kh.app.home.vo.SalesVo_v2;
import com.kh.app.member.vo.MemberVo;


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
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
			try {
				System.out.println("요청이 들어옴");
				
		        // Set response content type
		        resp.setContentType("application/json");
		        resp.setCharacterEncoding("UTF-8");

		        // Create a BufferedReader object to read the JSON data from the request
		        BufferedReader reader = new BufferedReader(new InputStreamReader(req.getInputStream()));
		        StringBuilder jsonData = new StringBuilder();

		        // Read the JSON data line by line
		        String line;
		        while ((line = reader.readLine()) != null) {
		            jsonData.append(line);
		        }

		        // Use Gson library to convert the JSON data to a Java object
		        Gson gson = new Gson();
		        System.out.println(jsonData);

		        SalesVo_v2 vo = gson.fromJson(jsonData.toString(), SalesVo_v2.class);
		        
		        HomeService service = new HomeService();
		        
		        MemberVo loginMember= (MemberVo)req.getSession().getAttribute("loginMember");
		        
		        int result = service.insertCart(vo,loginMember);
		        
		        if(result != 1) {
		        	throw new Exception();
		        }
		       
		        // Send a response back to the client
		        resp.getWriter().write("장바구니 담기 성공");
			}catch (Exception e) {
				e.printStackTrace();
				 resp.getWriter().write("장바구니 담기 실패");
			}
		
			
	    
		
	}
	
}
