package com.kh.app.board.contact.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.kh.app.board.contact.service.NoticeService;
import com.kh.app.board.contact.vo.NoticeVo;

@WebServlet("/contact/notice")
public class NoticeListController extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		try {
			
			NoticeService ns = new NoticeService();
			int notiCnt = ns.getAllNotiCnt();
			List<NoticeVo> notiVoList = ns.getAllNotiList();
			req.setAttribute("notiVoList", notiVoList);
			
			
			
			
			req.getRequestDispatcher("/WEB-INF/views/board/contact/notice/notice_list.jsp").forward(req, resp);
		}catch (Exception e) {
			System.out.println("[ERROR-N001] 공지사항 목록조회 중 에러 발생");
			e.printStackTrace();
			req.setAttribute("errorMsg", "공지사항 조회 실패");
			req.getRequestDispatcher("/WEB-INF/views/common/error.jsp").forward(req, resp);
		}
	
	}
}
