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

@WebServlet("/seller/enroll")
public class SellerEnroollController extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.getRequestDispatcher("/WEB-INF/views/seller/join/enrollSeller.jsp").forward(req, resp);
	}
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		try {
			req.setCharacterEncoding("UTF-8");
			HttpSession session = req.getSession();
			SellerVo joinVo = (SellerVo)session.getAttribute("joinVo");
			session.removeAttribute("joinVo");
			
			String business_no = req.getParameter("business_no");
			System.out.println(business_no);
			String business_form = req.getParameter("business_form");
			String business_name = req.getParameter("business_name");
			String business_phone = req.getParameter("business_phone");
			String businees_adr = req.getParameter("businees_adr");
			
			String businees_zipCode = req.getParameter("businees_zipCode");
			String corporation_name = req.getParameter("corporation_name");
			String uptae = req.getParameter("uptae");
			String upjong = req.getParameter("upjong");
			String detailed_adr = req.getParameter("detailed_adr");
			
			String report_number = req.getParameter("report_number");
			String bank = req.getParameter("bank");
			String depositor = req.getParameter("depositor");
			String account = req.getParameter("account");

			joinVo.setBusinessNo(business_no);
			joinVo.setBusinessForm(business_form);
			joinVo.setBusineesName(business_name);
			joinVo.setBusineesPhone(business_phone);
			joinVo.setCorporationName(corporation_name);
			joinVo.setUptae(uptae);
			joinVo.setUpjong(upjong);
			joinVo.setBusineesAdr(businees_adr);
			joinVo.setBusineesZipCode(businees_zipCode);
			joinVo.setDetailedAdr(detailed_adr);
			joinVo.setReportNumber(report_number);
			joinVo.setBank(bank);
			joinVo.setDepositor(depositor);
			joinVo.setAccount(account);
			
			SellerService ss = new SellerService();
			int result = ss.join(joinVo);
			
			if(result != 2) {
				throw new Exception("[ERROR-S002] 디비 인서트 값 2가아님");
			}
			
			req.setAttribute("joinVo", joinVo);
			req.getRequestDispatcher("/seller/insertNo").forward(req, resp);
			
		}catch (Exception e) {
			System.out.println("[ERROR-S001] 회원가입중 예외발생..");
			e.printStackTrace();
			System.out.println(e.getMessage());
			req.setAttribute("errorMsg", "회원가입중 실패..");
			req.getRequestDispatcher("/WEB-INF/views/common/fail.jsp").forward(req, resp);
		}
		
	}
}
