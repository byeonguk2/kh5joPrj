package com.kh.app.seller.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.kh.app.seller.service.SellerNoteService;
import com.kh.app.seller.vo.SellerNoteVo;
import com.kh.app.seller.vo.SellerVo;

@WebServlet("/seller/note/send")
public class SellerNoteSendController extends HttpServlet{
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		HttpSession session = req.getSession();
		try {
			SellerVo sv = (SellerVo)session.getAttribute("loginSeller");
			String sellerNo = sv.getSellerNo();
			
			SellerNoteService sns = new SellerNoteService();
			List<SellerNoteVo> sendNoteList = sns.sendNoteSelectList(sellerNo);
			
			if(sendNoteList == null) {
				throw new Exception("리스트 불러오는 중에 오류");
			}
			
			session.setAttribute("sendNoteList", sendNoteList);
			req.getRequestDispatcher("/WEB-INF/views/seller/note/sendNote.jsp").forward(req, resp);
		}catch(Exception e) {
			e.printStackTrace();
			System.out.println("보낸 쪽지 목록 불러오는 중에 오류");
		}
		
		
		
	}
	
}
