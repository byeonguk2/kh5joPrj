package com.kh.app.seller.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.kh.app.category.service.CategoryService;
import com.kh.app.category.vo.CategoryVo;

@WebServlet("/seller/register/category2")
public class SellerRegisterCategoryTwoListController extends HttpServlet{
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		try {
			
			String categoryNo1 = req.getParameter("categoryNo1");
			CategoryService cs = new CategoryService();
			
			
			List<CategoryVo> categoryList = cs.categoryTwoList(categoryNo1);
			
			if(categoryList == null) {
				throw new Exception();
			}
			
			req.setAttribute("categoryList", categoryList);
			req.getRequestDispatcher("/WEB-INF/views/category/categoryTwoList.jsp").forward(req, resp);
		}catch(Exception e) {
			e.printStackTrace();
		}
		
	}

}
