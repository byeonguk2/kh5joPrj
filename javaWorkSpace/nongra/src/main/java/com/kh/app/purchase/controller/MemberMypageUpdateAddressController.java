package com.kh.app.purchase.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.kh.app.purchase.service.PurchaseService;
import com.kh.app.purchase.vo.PurchaseAddressVo;

@WebServlet("/address/shipping-address/update")
public class MemberMypageUpdateAddressController extends HttpServlet{
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		try {
			//data
			String addressNo = req.getParameter("addressNo");
			
			//service
			PurchaseService ps = new PurchaseService();
			PurchaseAddressVo addressVo = ps.takeAddress(addressNo);
			
			//result
			req.setAttribute("addressVo", addressVo);
			req.getRequestDispatcher("/WEB-INF/views/member/addressEdit.jsp").forward(req, resp);
		}catch(Exception e) {
			e.printStackTrace();
			System.out.println("[ERROR-A002] 마이페이지에서 수정 배송지 가져오다가 예외 발생");
		}
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		try {
			//data
			String no = req.getParameter("no");
			String name = req.getParameter("name");
			String phone = req.getParameter("phone");
			String defaultAddress = req.getParameter("defaultAddress");
			
			//service
			PurchaseService ps = new PurchaseService();
			int result = ps.updateAddress(no, name, phone, defaultAddress);
			
			//result
            resp.sendRedirect("/nongra/mypage/address");
			
		}catch(Exception e) {
			e.printStackTrace();
			System.out.println("[ERROR-A003] 마이페이지에서 변경된 배송지 정보 DB에 넣다가 예외 발생");
		}
	}





}

