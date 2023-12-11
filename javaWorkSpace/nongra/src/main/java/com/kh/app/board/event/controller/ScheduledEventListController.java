package com.kh.app.board.event.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.kh.app.board.event.service.EventService;
import com.kh.app.board.event.vo.EventVo;
import com.kh.app.page.vo.PageVo;

//진행예정 이벤트 목록 조회 (+ 페이징 처리)
@WebServlet("/event/scheduled")
public class ScheduledEventListController extends HttpServlet{
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		try {
			EventService es = new EventService();
			int listCount = es.selectFutureEventCount();
			String currentPage_ = req.getParameter("pno");
			if(currentPage_ == null) {
				currentPage_ = "1";
			}
			int currentPage = Integer.parseInt(currentPage_);
			int pageLimit = 3;
			int boardLimit = 6;
			PageVo pvo = new PageVo(listCount, currentPage, pageLimit, boardLimit);
			List<EventVo> eventVoList = es.selectFutureEventList(pvo);
			
			req.setAttribute("eventVoList", eventVoList);
			req.setAttribute("pvo", pvo);
			req.getRequestDispatcher("/WEB-INF/views/board/event/event_scheduled_list.jsp").forward(req, resp);
		}catch (Exception e) {
			System.out.println("[EVENT-E002] 예정된 이벤트 목록조회 중 에러 발생");
			e.printStackTrace();
			req.setAttribute("errorMsg", "이벤트 목록조회 실패");
			req.getRequestDispatcher("/WEB-INF/views/common/error.jsp").forward(req, resp);
		}
	}
}
