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
import com.kh.app.member.vo.MemberVo;
import com.kh.app.page.vo.PageVo;
import com.kh.app.page.vo.PageVoTest;

//**** 공지 목록 조회 
//판매자 -> 판매자 공지를 보여주고, 소비자 또는 로그인 안한 상태 -> 소비자 공지를 보여줄 것 
@WebServlet("/contact/notice")
public class NoticeListController extends HttpServlet {
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
			NoticeService ns = new NoticeService();

			int totalNoticeCnt = ns.selectNoticeCount(readPermissionNo); 
			int initialPostCnt = 10;
			int additionalPostCnt = 5;
			int requestedPageCnt = 0;
			PageVoTest pvo = new PageVoTest(totalNoticeCnt, initialPostCnt, additionalPostCnt, requestedPageCnt);

			List<NoticeVo> noticeVoList = ns.selectNoticeList(readPermissionNo, pvo);
			req.setAttribute("noticeVoList", noticeVoList);
			req.setAttribute("pvo", pvo);    
			req.getRequestDispatcher("/WEB-INF/views/board/contact/notice/notice_list.jsp").forward(req, resp);
		}catch (Exception e) {
			System.out.println("[ERROR-N001] 공지사항 목록조회 중 에러 발생");
			e.printStackTrace();
			req.setAttribute("errorMsg", "공지사항 조회 실패");
			req.getRequestDispatcher("/WEB-INF/views/common/error.jsp").forward(req, resp);
		}
	}
}


