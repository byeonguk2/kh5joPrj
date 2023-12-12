package com.kh.app.board.contact.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.kh.app.board.contact.service.FaqService;
import com.kh.app.board.contact.service.NoticeService;
import com.kh.app.board.contact.vo.FaqVo;
import com.kh.app.board.contact.vo.NoticeVo;
import com.kh.app.member.vo.MemberVo;
import com.kh.app.page.vo.PageVoTest;

//**** 공지 목록 조회 
//판매자 -> 판매자 글, 소비자 또는 로그인 안한 상태 -> 소비자 글
@WebServlet("/contact/faq")
public class FaqListController extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		try {
			String readPermissionNo = "1";
			String sellerYn = "N";
			MemberVo loginMember = (MemberVo) req.getSession().getAttribute("loginMember");
			if(loginMember == null) {
				readPermissionNo = "1";
			}else {
				sellerYn = loginMember.getSellerYn();
				if(sellerYn.equals("Y")){
					readPermissionNo = "2";
				}
			}
			String cateNo = "1"; // 처음에 1번 카테고리 보여주도록,,, 
			FaqService fs = new FaqService();

			int totalFaqCnt = fs.selectFaqCount(readPermissionNo, cateNo); 
			int initialPostCnt = 10;
			int additionalPostCnt = 5;
			int requestedPageCnt = 0;
			PageVoTest pvo = new PageVoTest(totalFaqCnt, initialPostCnt, additionalPostCnt, requestedPageCnt);

			List<FaqVo> faqVoList = fs.selectFaqList(readPermissionNo, cateNo, pvo);
			req.setAttribute("faqVoList", faqVoList);
			req.setAttribute("pvo", pvo);    
			req.getRequestDispatcher("/WEB-INF/views/board/contact/faq/faq_list.jsp").forward(req, resp);
		}catch (Exception e) {
			System.out.println("[ERROR-F001] FAQ 목록조회 중 에러 발생");
			e.printStackTrace();
			req.setAttribute("errorMsg", "FAQ 조회 실패");
			req.getRequestDispatcher("/WEB-INF/views/common/error.jsp").forward(req, resp);
		}
	}
}