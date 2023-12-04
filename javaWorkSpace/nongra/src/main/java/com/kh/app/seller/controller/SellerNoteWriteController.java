package com.kh.app.seller.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.kh.app.seller.service.SellerNoteService;
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
		
		HttpSession session = req.getSession();
		resp.setCharacterEncoding("UTF-8");
		try {
			SellerVo loginSeller = (SellerVo) session.getAttribute("loginSeller");
			System.out.println(loginSeller.getMemberNo());
			String toId = req.getParameter("toId");
			String title = req.getParameter("title");
			String content = req.getParameter("content");
			
			
			SellerNoteVo snv = new SellerNoteVo();
			snv.setFromNo(loginSeller.getMemberNo());
			snv.setFromId(loginSeller.getId());
			snv.setToId(toId);
			snv.setTitle(title);
			snv.setContent(content);
			System.out.println(snv);
			
			SellerNoteService sns = new SellerNoteService();
			
			int result = sns.noteWrite(snv);
			
			if(result != 1) {
				throw new Exception("디비 문제 발생");
			}
			
			session.setAttribute("alertMsg", "작성 성공");
			req.getRequestDispatcher("/WEB-INF/views/common/note/result.jsp").forward(req, resp);
			
		}catch(Exception e) {
			e.printStackTrace();
			System.out.println("쪽지작성에러에러");
			session.setAttribute("alertMsg", "작성 실패");
			req.getRequestDispatcher("/WEB-INF/views/common/note/result.jsp").forward(req, resp);
		}
		
	}
}
