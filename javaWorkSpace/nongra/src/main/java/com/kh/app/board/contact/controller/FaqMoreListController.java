package com.kh.app.board.contact.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;
import com.kh.app.board.contact.service.FaqService;
import com.kh.app.board.contact.vo.FaqVo;
import com.kh.app.member.vo.MemberVo;
import com.kh.app.page.vo.PageVoTest;


@WebServlet("/contact/faq/ask")
public class FaqMoreListController extends HttpServlet{
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
			FaqService fs = new FaqService();
			String cateNo = req.getParameter("cateNo");
			int totalNoticeCnt = fs.selectFaqCount(readPermissionNo, cateNo); 
			int initialPostCnt = 10;
			int additionalPostCnt = 5;
			String requestedPageCnt_ = req.getParameter("pno");
			if(requestedPageCnt_ == null) {
				requestedPageCnt_ = "1";
			}
			int requestedPageCnt = Integer.parseInt(requestedPageCnt_);
			PageVoTest pvo = new PageVoTest(totalNoticeCnt, initialPostCnt, additionalPostCnt, requestedPageCnt);
			System.out.println("requestedPageCnt : " + requestedPageCnt + ", startRow:" + pvo.getStartRow() + ", lastRow:" + pvo.getLastRow());

			List<FaqVo> addedVoList = fs.selectFaqList(readPermissionNo, cateNo, pvo);
			Gson gson = new Gson();
			System.out.println(addedVoList.size());
			String str = gson.toJson(addedVoList);
			resp.setCharacterEncoding("UTF-8"); 
			PrintWriter out = resp.getWriter();
			out.write(str);
		}catch (Exception e) {
			e.printStackTrace();
			System.out.println("[ERROR-F002] FAQ 추가조회 에러");
		}
	}
}