package com.kh.app.seller.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.kh.app.seller.vo.SellerNoteVo;
import com.kh.app.seller.vo.SellerVo;

@WebServlet("/seller/note/write")
public class SellerNoteWriteController extends HttpServlet{
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.getRequestDispatcher("/WEB-INF/views/common/note/noteWrite.jsp").forward(req, resp);

	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		HttpSession session2 = req.getSession();
		SellerVo loginSeller2 = (SellerVo) session2.getAttribute("loginSeller");
		System.out.println(loginSeller2.getNick());
		String toNick = req.getParameter("toNick");
		String title = req.getParameter("title");
		String content = req.getParameter("content");
		
		SellerNoteVo snv = new SellerNoteVo();
//		snv.setFromNick(loginSeller.getNick());
		snv.setToNick(toNick);
		snv.setTitle(title);
		snv.setContent(content);
		
//		SellerNoteService sns = new SellerNoteService(snv);
	}
}
