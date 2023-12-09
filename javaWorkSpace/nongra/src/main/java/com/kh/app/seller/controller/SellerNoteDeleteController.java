package com.kh.app.seller.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.kh.app.seller.service.SellerNoteService;
import com.kh.app.seller.vo.SellerVo;

@WebServlet("/seller/note/delete")
public class SellerNoteDeleteController extends HttpServlet{
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		HttpSession session = req.getSession();
		try {
			SellerVo sv = (SellerVo)session.getAttribute("loginSeller");
			String noteNo = req.getParameter("noteNo");
			SellerNoteService sns = new SellerNoteService();
			int result = sns.noteDelete(sv.getMemberNo() , noteNo);
			if(result != 1) {
				throw new Exception("삭제 중 오류 발생");
			}
			resp.sendRedirect("/nongra/seller/note/send");
			
		}catch(Exception e) {
			e.printStackTrace();
		}
		
	}
	
}
