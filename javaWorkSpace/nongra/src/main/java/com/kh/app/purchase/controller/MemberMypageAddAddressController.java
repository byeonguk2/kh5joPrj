package com.kh.app.purchase.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.kh.app.member.vo.MemberVo;
import com.kh.app.purchase.service.PurchaseService;
import com.kh.app.purchase.vo.PurchaseAddressVo;

@WebServlet("/address/shipping-address")
public class MemberMypageAddAddressController extends HttpServlet{
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.getRequestDispatcher("/WEB-INF/views/member/addressAdd.jsp").forward(req, resp);
	}
	
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		try{
			//data
			MemberVo loginMember = (MemberVo)req.getSession().getAttribute("loginMember");
			String address1 = req.getParameter("address1");
			String address2 = req.getParameter("address2");
			String address3 = req.getParameter("address3");
			String name = req.getParameter("name");
			String phone = req.getParameter("phone");
			String defaultAddress = req.getParameter("defaultAddress");
			String address = address1 + address2 + address3;
			PurchaseAddressVo addressVo = new PurchaseAddressVo(address, name, phone, defaultAddress);
			
			//service
			PurchaseService ps = new PurchaseService();
			int result = ps.addAddress(addressVo, loginMember);
			
			//result
            resp.sendRedirect("/nongra/mypage/address");
			
		}catch(Exception e) {
			
		}
	}
}
