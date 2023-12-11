package com.kh.app.board.event.controller;

import java.io.IOException;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.kh.app.board.event.service.EventService;
import com.kh.app.board.event.vo.EventVo;

@WebServlet("/event/detail")
public class EventDetailController extends HttpServlet{
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		try {
			String no = req.getParameter("no");
			EventService es = new EventService();
			List<EventVo> voList = es.selectDetailByNo(no);
//			EventVo vo = (EventVo) map.get("vo");
			
//			req.setAttribute("vo", vo);
			req.setAttribute("voList", voList);
			req.setAttribute("currPage", req.getParameter("currPage"));
			req.getRequestDispatcher("/WEB-INF/views/board/event/event_detail.jsp").forward(req, resp);
		}catch (Exception e) {
			System.out.println("[ERROR-E004] 이벤트 상세조회 중 에러 발생");
			e.printStackTrace();
			req.setAttribute("errorMsg", "이벤트 상세조회 실패");
			req.getRequestDispatcher("/WEB-INF/views/common/error.jsp").forward(req, resp);
		}
	}
}
