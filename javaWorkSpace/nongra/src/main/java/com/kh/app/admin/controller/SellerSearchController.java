package com.kh.app.admin.controller;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.kh.app.admin.service.AdminService;
import com.kh.app.page.vo.PageVo;
import com.kh.app.seller.vo.SellerVo;

@WebServlet("/admin/search")
public class SellerSearchController extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		try {
			AdminService as = new AdminService();
			// data
			String option = req.getParameter("option");
			String searchValue = req.getParameter("searchValue");
			
			System.out.println(option);
			System.out.println(searchValue);
			
			Map<String,String> map = new HashMap<String,String>();
			map.put("option", option);
			map.put("searchValue", searchValue);
			
			int listCount = as.selectMemberSearchCount(map);
			
			int currentPage = 1;
			if(req.getParameter("pno") != null) {
				currentPage = Integer.parseInt(req.getParameter("pno"));
			}
			
			int pageLimit = 5;
			int boardLimit = 10;
			PageVo pvo = new PageVo(listCount, currentPage,pageLimit,boardLimit);
			
			// service 
			List<SellerVo> SellerVoList = as.search(map,pvo);
			
			req.setAttribute("map", map);
			req.setAttribute("pvo", pvo);
			req.setAttribute("voList", SellerVoList);
			req.getRequestDispatcher("/WEB-INF/views/admin/member/memberRequest.jsp").forward(req, resp);
		}catch (Exception e) {
			System.out.println("게시물 검색기능 예외발생..");
			e.printStackTrace();
			req.setAttribute("arrorMsg", "게시물 검색 오류");
			req.getRequestDispatcher("/WEB-INF/views/common/error.jsp").forward(req, resp);
		}
	}
	
}
