package com.kh.app.purchase.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.kh.app.member.vo.MemberVo;
import com.kh.app.purchase.service.PurchaseService;
import com.kh.app.purchase.vo.PurchaseAddressVo;

@WebServlet("/mypage/address")
public class MemberMypageAddress extends HttpServlet{
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		try {
			//data
			MemberVo loginMember = (MemberVo) req.getSession().getAttribute("loginMember");
			
			//service
			PurchaseService ps = new PurchaseService();
			List<PurchaseAddressVo> voList = ps.takeAllAddress(loginMember);
			
			//result
			
			req.setAttribute("voList", voList);
			req.getRequestDispatcher("/WEB-INF/views/member/address.jsp").forward(req, resp);
			
		}catch(Exception e) {
			e.printStackTrace();
			System.out.println("[ERROR-M001] 마이페이지에서 배송지 전체 목록 불러오던 중 예외 발생");
		}
	}
}
