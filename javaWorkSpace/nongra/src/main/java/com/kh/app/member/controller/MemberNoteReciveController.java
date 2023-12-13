package com.kh.app.member.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.kh.app.member.vo.MemberVo;
import com.kh.app.page.vo.PageVo;
import com.kh.app.seller.service.SellerNoteService;
import com.kh.app.seller.vo.SellerNoteVo;

@WebServlet("/member/reciveNote")
public class MemberNoteReciveController extends HttpServlet{
	
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		HttpSession session = req.getSession();
		try {
			SellerNoteService sns = new SellerNoteService();
			MemberVo sv = (MemberVo)session.getAttribute("loginMember");
			
			int listCount = sns.selectReciveNoteCount(sv.getNo());
			String currentPage_ = req.getParameter("pno");
			if(currentPage_ == null) {
				currentPage_ = "1";
			}
			int currentPage = Integer.parseInt(currentPage_);
			int pageLimit = 10;
			int boardLimit = 10;
			PageVo pvo = new PageVo(listCount, currentPage,pageLimit, boardLimit);
			System.out.println(pvo);
			List<SellerNoteVo> sendNoteList = sns.reciveNoteSelectList(sv.getNo() , pvo);
			
			if(sendNoteList == null) {
				throw new Exception("리스트 불러오는 중에 오류");
			}
			
			req.setAttribute("sendNoteList", sendNoteList);
			req.setAttribute("pvo", pvo);
			req.getRequestDispatcher("/WEB-INF/views/member/reciveNote.jsp").forward(req, resp);
		}catch(Exception e) {
			e.printStackTrace();
			System.out.println("받은 쪽지 목록 불러오는 중에 오류");
			req.getRequestDispatcher("/WEB-INF/views/member/reciveNote.jsp").forward(req, resp);
		}
		
	}
	
}
