package com.kh.app.board.contact.controller;

import java.io.IOException;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.kh.app.board.contact.service.QnaService;
import com.kh.app.board.contact.vo.QnaMemberCateVo;
import com.kh.app.member.vo.MemberVo;

@WebServlet("/contact/inquiry/write")
public class QnaWriteController extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		try {
			MemberVo loginMember = (MemberVo) req.getSession().getAttribute("loginMember");
			if(loginMember == null) {
				req.setAttribute("alertMsg", "로그인 후 사용가능합니다.");
				resp.sendRedirect("/nongra/member/login");
			}
			
			//할일 : 사용자 번호받아서 어떤메소드 실행할지 if문 추가 
			QnaService qs = new QnaService();
			List<QnaMemberCateVo> parentCateVoList = qs.getParentCateList();
			Map<String, QnaMemberCateVo> cateMap = qs.getMemberChildCateList();
			
			//할일 결제 이력 조회 메서드 
			
		//	List<QnaSellerCateVo> parentCateVoList = qs.getParentCateList();
		//	List<QnaSellerCateVo> childCateVoList = qs.getChildCateList();
			
			req.setAttribute("parentCateVoList", parentCateVoList);
			req.setAttribute("cateMap", cateMap);
			req.getRequestDispatcher("/WEB-INF/views/board/contact/qna/qna_write.jsp").forward(req, resp);
			
		}catch (Exception e) {
			e.printStackTrace();
			req.setAttribute("errorMsg", "1:1문의 화면 불러오기 실패");
			req.getRequestDispatcher("/WEB-INF/views/common/error.jsp").forward(req, resp);
		}
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		try {
			HttpSession session = req.getSession();
			String qnaCategory2 = req.getParameter("qna_category2");
			String payNo = req.getParameter("payNo");
			String qnaTitle = req.getParameter("qna_title");
			String qnaContent = req.getParameter("qna_content");
			
			QnaService qs = new QnaService();
			
		}catch (Exception e) {
			
		}
		
		
	}
}
