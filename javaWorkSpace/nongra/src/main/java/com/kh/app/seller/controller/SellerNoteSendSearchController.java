package com.kh.app.seller.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.kh.app.seller.service.SellerNoteService;
import com.kh.app.seller.vo.SellerNoteVo;

@WebServlet("/nongra/seller/note/send/search")
public class SellerNoteSendSearchController extends HttpServlet{
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		try {
			String search = req.getParameter("search");
			String searchName = req.getParameter("searchName");
			SellerNoteService sns = new SellerNoteService();
//			List<SellerNoteVo> sendNoteList= sns.noteSendSearch(search , searchName);
			
//			for (SellerNoteVo sellerNoteVo : sendNoteList) {
//				System.out.println(sellerNoteVo);
//			}
//			req.setAttribute("sendNoteList", sendNoteList);
			req.getRequestDispatcher("").forward(req, resp);
		}catch(Exception e) {
			e.printStackTrace();
		}
		
		
	}
	
	
}
