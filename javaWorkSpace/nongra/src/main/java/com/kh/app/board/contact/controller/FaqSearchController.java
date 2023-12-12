package com.kh.app.board.contact.controller;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.kh.app.board.contact.service.FaqService;
import com.kh.app.board.contact.vo.FaqVo;
import com.kh.app.member.vo.MemberVo;

@WebServlet("/contact/faq/search")
public class FaqSearchController extends HttpServlet {
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
			String search = req.getParameter("search");
			
			
			
			Map<String,String> map = new HashMap<String, String>();
			map.put("search", search);
			FaqService fs = new FaqService();
			int searchCnt = fs.searchFaqCount(readPermissionNo, map);
			List<FaqVo> faqVoList = fs.searchFaqList(readPermissionNo, map);
			req.setAttribute("searchCnt", searchCnt);
			req.setAttribute("faqVoList", faqVoList);
			
			System.out.println("searchCtrller searchVoList 출력:" + faqVoList);
			
			req.setAttribute("searhMap", map);
			req.getRequestDispatcher("/WEB-INF/views/board/contact/faq/faq_list.jsp").forward(req, resp);
		}catch (Exception e) {
			System.out.println("[ERROR-F003] 검색 기능 에러");
			e.printStackTrace();
			req.setAttribute("errorMsg", "FAQ 검색 실패");
			req.getRequestDispatcher("/WEB-INF/views/common/error.jsp").forward(req, resp);
		}
	}
}
