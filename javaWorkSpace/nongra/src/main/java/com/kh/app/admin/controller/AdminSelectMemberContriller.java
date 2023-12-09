package com.kh.app.admin.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.kh.app.admin.service.AdminService;
import com.kh.app.page.vo.PageVo;
import com.kh.app.seller.vo.SellerVo;

@WebServlet("/admin/select")
public class AdminSelectMemberContriller extends HttpServlet {

	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		try {
			
			AdminService as = new AdminService();
			
			int listCount = as.selectMemberSellerCount(); //(디비가서 조회하기) 전체게시글 갯수
			System.out.println(listCount);
			String currentPagr_ = req.getParameter("pno");
			if(currentPagr_ == null) {
				currentPagr_ = "1";
			}
			int currentPage = Integer.parseInt(currentPagr_); //(화면에서 전달받기) 현재 페이지
			int pageLimit = 5; // (우리가 정함) 한 페이지에 5개씩 나오게 할거다
			int boardLimit = 10; // (우리가 정함) 한페이지당 게시물이 10개씩 나오게 할거다
			
			
			PageVo pvo = new PageVo(listCount, currentPage, pageLimit, boardLimit);
			
			List<SellerVo> voList = as.memberBen(pvo);
			
			req.setAttribute("voList", voList);
			req.setAttribute("pvo", pvo);
		req.getRequestDispatcher("/WEB-INF/views/admin/member/selectMember.jsp").forward(req, resp);
	}catch (Exception e) {
		
		System.out.println("판매자 조회중 문제생김");
		e.printStackTrace();
		
		
	}
	}
	
}
