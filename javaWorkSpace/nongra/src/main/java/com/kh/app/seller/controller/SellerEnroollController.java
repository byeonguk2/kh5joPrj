package com.kh.app.seller.controller;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Collection;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.servlet.http.Part;

import com.kh.app.seller.service.SellerService;
import com.kh.app.seller.vo.SellerVo;

// 업로드한 파일 크기 지정
@MultipartConfig(
		maxFileSize = 1024*1024*10		//파일 하나당 크기
		,maxRequestSize = 1024*1024*50  // 리퀘스트 전체 크기
		)
// 맵핑 
@WebServlet("/seller/enroll")
public class SellerEnroollController extends HttpServlet {
	
	// GET요청 받음 (enrollSeller)
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.getRequestDispatcher("/WEB-INF/views/seller/join/enrollSeller.jsp").forward(req, resp);
	}
	
	// POST 요청 받음 
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		HttpSession session = req.getSession();
		try {
			req.setCharacterEncoding("UTF-8");
			SellerVo joinVo = (SellerVo)session.getAttribute("joinVo");
			session.removeAttribute("joinVo");
			
			String business_no = req.getParameter("business_no");
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
			
			// 첨부파일 전부 받아오기 
			Collection<Part> parts = req.getParts();
			
			Part f = req.getPart("f");
			System.out.println(f);
			System.out.println(f.getSubmittedFileName());
			
			Part f2 = req.getPart("f2");
			System.out.println(f2);
			System.out.println(f2.getSubmittedFileName());
			
			InputStream in = null;
			InputStream in2 = null;
			// 읽기
			if(f2.getSubmittedFileName() != null && f.getSubmittedFileName() != null) {
			in = f.getInputStream();
			in2 = f2.getInputStream();
			}else {
				throw new Exception("사진 첨부를 안함..");
			}
			
			//내보내기
			String sep = File.separator;
			
			String fileName = sep+f.getSubmittedFileName();
			String fileName2 = sep+f2.getSubmittedFileName();
			
			String path = req.getServletContext().getRealPath(sep+"resources"+sep+"upload"+sep+"img");
			System.out.println(path);
			
			File target = new File (path+sep+fileName);
			File target2 = new File (path+sep+fileName2);
			
			FileOutputStream out = new FileOutputStream(target);
			FileOutputStream out2 = new FileOutputStream(target2);
			
			// 1024	바이트를 전부 읽는다.
			byte[] buf = new byte[1024];
			int size = 0;
			while((size =in.read(buf)) != -1) {
				out.write(buf,0,size);
			}
			byte[] buf2 = new byte[1024];
			int size2 = 0;
			while((size =in.read(buf)) != -1) {
				out2.write(buf,0,size);
			}
			
			in.close();
			out.close();
			
			String[] strArr = new String[2];
			strArr[0] = path+sep+fileName;
			strArr[1] = path+sep+fileName2;
			
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
			int result = ss.join(joinVo,strArr);
			
			if(result != 4) {
				throw new Exception("[ERROR-S002] 디비 인서트 값 4가아님");
			}
			
			session.setAttribute("alertMsg", "회원가입 성공");
			resp.sendRedirect("/nongra/seller/login");
			
		}catch (Exception e) {
			System.out.println("[ERROR-S001] 회원가입중 예외발생..");
			e.printStackTrace();
			System.out.println(e.getMessage());
			session.setAttribute("alertMsg", "회원가입 실패");
			resp.sendRedirect("/nongra/seller/join");
		}
		
	}
}
