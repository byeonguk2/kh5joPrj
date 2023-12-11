package com.kh.app.category.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;
import com.kh.app.category.service.CategoryService;
import com.kh.app.category.vo.CategoryVo;


@WebServlet("/category/twoList")
public class CategoryTwoListController extends HttpServlet{
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		resp.setCharacterEncoding("UTF-8");
		try {
			String categoryOneNo = req.getParameter("no");
			CategoryService cs = new CategoryService();
			List<CategoryVo> categoryTwoVoList = cs.categoryTwoList(categoryOneNo);
			
			Gson gson = new Gson();
			String str = gson.toJson(categoryTwoVoList);
			resp.getWriter().write(str);
			
			
		}catch(Exception e) {
			e.printStackTrace();
			System.out.println("카테고리2 목록 불러오는중 오류 발생");
		}
		
	}

}
