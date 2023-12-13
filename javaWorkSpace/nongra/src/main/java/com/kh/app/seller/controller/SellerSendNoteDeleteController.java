package com.kh.app.seller.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.kh.app.member.vo.MemberVo;
import com.kh.app.seller.service.SellerNoteService;
import com.kh.app.seller.vo.SellerNoteVo;
import com.kh.app.seller.vo.SellerVo;

@WebServlet("/sendNote/delete")
public class SellerSendNoteDeleteController extends HttpServlet{
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		HttpSession session = req.getSession();
		try {
			int result = 0;
			SellerVo sv = (SellerVo)session.getAttribute("loginSeller");
			MemberVo mv = (MemberVo)session.getAttribute("loginMember");
			String noteNo = req.getParameter("noteNo");
			SellerNoteService sns = new SellerNoteService();
			SellerNoteVo noteVo = new SellerNoteVo();
			noteVo.setNoteNo(noteNo);
			if(sv == null) {
				result = sns.sendNoteDelete(noteVo , mv.getNo());
			}else if(mv == null){
				result = sns.sendNoteDelete(noteVo , sv.getMemberNo());
			}
			
			
			if(result != 1) {
				throw new Exception("삭제 중 오류 발생");
			}
			resp.getWriter().write("삭제 성공");
		}catch(Exception e) {
			e.printStackTrace();
		}
		
	}
	
}
