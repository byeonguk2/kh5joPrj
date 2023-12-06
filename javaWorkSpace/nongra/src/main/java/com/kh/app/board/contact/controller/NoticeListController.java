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
import com.kh.app.page.vo.PageVo;
import com.kh.app.page.vo.PageVoTest;

//페이징 처리하여 공지 목록조회
//판매자면 판매자 공지를 보여주고, 소비자 + 로그인안한 상태면 소비자 공지를 보여줄 것 
//할일: js 더보기 클릭, DB에 소비자 권한 공지 글 추가 
@WebServlet("/contact/notice")
public class NoticeListController extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		//할일 : 페이징 처리 .. PageVo 수정이나 따로사용할지 고민해볼 것,, 
		try {
			//할일 : req로 요청된 페이지 수 테스트 
			//계층에 따른 글 노출 설정(읽기권한) -> 테스트 이전까지 주석처리해서 readPermissionNo=2 수기로 진행해볼 것 
			String readPermissionNo = "1";
			if(req.getSession().getAttribute("loginSeller") != null) {
				readPermissionNo = "2";
			}
			int requestedPageCnt = 0;
			if(req.getAttribute("requestedPageCnt") !=  null) {              // 먼가 조건식 구린데 함 생각 더 해보기 
				requestedPageCnt = (int) req.getAttribute("requestedPageCnt"); //타입 int로 받는거 확정 ㅇㅇ??
			}
			
			NoticeService ns = new NoticeService();
			
			int totalNoticeCnt = ns.selectNoticeCount(readPermissionNo); 
			int initialPostCnt = 10;
			int additionalPostCnt = 5;
			PageVoTest pvo = new PageVoTest(totalNoticeCnt, initialPostCnt, additionalPostCnt, requestedPageCnt);

			List<NoticeVo> noticeVoList = ns.selectNoticeList(readPermissionNo, pvo);
			req.setAttribute("noticeVoList", noticeVoList);
			req.setAttribute("pvo", pvo);   // 활용 고민 
			req.getRequestDispatcher("/WEB-INF/views/board/contact/notice/notice_list.jsp").forward(req, resp);
		}catch (Exception e) {
			System.out.println("[ERROR-N001] 공지사항 목록조회 중 에러 발생");
			e.printStackTrace();
			req.setAttribute("errorMsg", "공지사항 조회 실패");
			req.getRequestDispatcher("/WEB-INF/views/common/error.jsp").forward(req, resp);
		}
	}
}
