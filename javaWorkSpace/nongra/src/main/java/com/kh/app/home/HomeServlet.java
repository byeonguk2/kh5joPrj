package com.kh.app.home;

import java.io.IOException;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.kh.app.home.service.HomeService;
import com.kh.app.sales.vo.SalesVo;

@WebServlet("/home")
public class HomeServlet extends HttpServlet{

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		try {
			HomeService hs = new HomeService();
			Map<String , Object> map = hs.selectItemList();
			
			req.setAttribute("map", map);
			
			req.getRequestDispatcher("/WEB-INF/views/home.jsp").forward(req, resp);
			
		}catch (Exception e) {
			
			e.printStackTrace();
			req.setAttribute("alret", "홈페이지 접속 실패..");
			req.getRequestDispatcher("/WEB-INF/views/common/error.jsp").forward(req, resp);
			
		}
		
		
	}

}
