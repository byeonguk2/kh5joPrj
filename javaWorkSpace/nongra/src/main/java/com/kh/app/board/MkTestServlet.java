package com.kh.app.board;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/faq")
public class MkTestServlet extends HttpServlet{
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//		req.getRequestDispatcher("/WEB-INF/views/board/board_event/event_list.jsp").forward(req, resp);
//		req.getRequestDispatcher("/WEB-INF/views/board/board_event/event_detail.jsp").forward(req, resp);
//		req.getRequestDispatcher("/WEB-INF/views/board/board_event/event_write.jsp").forward(req, resp);
//		req.getRequestDispatcher("/WEB-INF/views/board/contact/sidebar_contact.jsp").forward(req, resp);
//		req.getRequestDispatcher("/WEB-INF/views/board/event/sidebar_event.jsp").forward(req, resp);
//		req.getRequestDispatcher("/WEB-INF/views/board/contact/notice/notice_list.jsp").forward(req, resp);
		req.getRequestDispatcher("/WEB-INF/views/board/contact/faq/faq_list.jsp").forward(req, resp);
	}
}
