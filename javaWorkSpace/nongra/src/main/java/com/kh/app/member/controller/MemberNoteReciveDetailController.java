package com.kh.app.member.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.kh.app.seller.service.SellerNoteService;
import com.kh.app.seller.vo.SellerNoteVo;

@WebServlet("/member/reciveNote/detail")
public class MemberNoteReciveDetailController extends HttpServlet{
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		try {
			String noteNo = req.getParameter("noteNo");
			
			SellerNoteService service = new SellerNoteService();
			SellerNoteVo noteVo = service.noteReciveDetail(noteNo);
			
			if(noteVo == null) {
				throw new Exception("쪽지 상세보기 하는중 오류발생");
			}
			
			req.setAttribute("noteVo", noteVo);
			req.getRequestDispatcher("/WEB-INF/views/member/reciveNoteDetail.jsp").forward(req, resp);
		}catch(Exception e) {
			e.printStackTrace();
			
		}

		
	}
	
}
