package com.kh.app.seller.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.kh.app.seller.service.SellerService;
import com.kh.app.seller.vo.SellerVo;

@WebServlet("/seller/modifyBusiness")
public class modityBusinessInfoController extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.getRequestDispatcher("/WEB-INF/views/seller/sellerInfo/modityBusinessInfo.jsp").forward(req, resp);
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		HttpSession session = req.getSession();
		try {
			SellerVo loginSeller = (SellerVo)session.getAttribute("loginSeller");
			String businessForm  = req.getParameter("business_form");
			String businessName  = req.getParameter("business_name");
			String businessPhone  = req.getParameter("business_phone");
			String busineesZipcode = req.getParameter("businees_zipcode");
			String businessAdr = req.getParameter("business_address");
			String uptae = req.getParameter("uptae");
			String upjong = req.getParameter("upjong");
			String bank = req.getParameter("bank");
			String depositor = req.getParameter("depositor");
			String account = req.getParameter("account");
			String corporationName = req.getParameter("corporation_name");
			
			SellerVo vo = new SellerVo();
			
			vo.setBusinessForm(businessForm);
			vo.setBusineesName(businessName);
			vo.setBusineesPhone(businessPhone);
			vo.setBusineesZipCode(busineesZipcode);
			vo.setBusineesAdr(businessAdr);
			vo.setUptae(uptae);
			vo.setUpjong(upjong);
			vo.setBank(bank);
			vo.setDepositor(depositor);
			vo.setAccount(account);
			vo.setCorporationName(corporationName);
			vo.setSellerNo(loginSeller.getSellerNo());
			
			SellerService ss = new SellerService();
			
			int result = ss.businessInfo(vo);
			
			if(result != result) {
				throw new Exception();
			}
			
			loginSeller.setBusinessForm(businessForm);
			loginSeller.setBusineesName(busineesZipcode);
			loginSeller.setBusineesPhone(busineesZipcode);
			loginSeller.setBusineesZipCode(busineesZipcode);
			loginSeller.setBusineesAdr(busineesZipcode);
			loginSeller.setUptae(uptae);
			loginSeller.setUpjong(upjong);
			loginSeller.setBank(bank);
			loginSeller.setDepositor(depositor);
			loginSeller.setAccount(account);
			loginSeller.setCorporationName(corporationName);
			
			session.setAttribute("alertMsg", "수정이 완료되었습니다.");
			session.setAttribute("loginSeller", loginSeller);
			resp.sendRedirect("/nongra/seller/businessInfo");
			
		}catch (Exception e) {
			System.out.println("회원수정중 예외발생");
			e.printStackTrace();
			session.setAttribute("alertMsg", "수정이 실패했습니다.");
			resp.sendRedirect("/nongra/seller/select");
		}
	
	}
	
}
