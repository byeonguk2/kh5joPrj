package com.kh.app.board.contact.controller;

import java.io.IOException;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.kh.app.board.contact.service.QnaService;
import com.kh.app.board.contact.vo.QnaMemberCateVo;
import com.kh.app.board.contact.vo.QnaMemberVo;
import com.kh.app.board.contact.vo.QnaSellerVo;
import com.kh.app.member.vo.MemberVo;

@WebServlet("/contact/inquiry")
public class QnaListController extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		try {
			MemberVo loginMember = (MemberVo) req.getSession().getAttribute("loginMember");
			if(loginMember == null) {
				req.getSession().setAttribute("alertMsg", "로그인 후 사용가능합니다.");
				resp.sendRedirect("/nongra/member/login");
			}else {
				String userNo = loginMember.getNo();
				QnaService qs = new QnaService();
				if(loginMember.getSellerYn().equals("Y")) {
					
					List<QnaSellerVo> qnaVoList = qs.getQnaSellerList(userNo);
					req.setAttribute("qnaVoList", qnaVoList);
				} else {
					List<QnaMemberVo> qnaVoList = qs.getQnaMemberList(userNo);

					req.setAttribute("qnaVoList", qnaVoList);
				}
				req.getRequestDispatcher("/WEB-INF/views/board/contact/qna/qna_list.jsp").forward(req, resp);
				
				
			}
		}catch (Exception e) {
			e.printStackTrace();
			req.setAttribute("errorMsg", "1:1문의 화면 불러오기 실패");
			req.getRequestDispatcher("/WEB-INF/views/common/error.jsp").forward(req, resp);
		}
		
	}
	
	
		
		
	}

