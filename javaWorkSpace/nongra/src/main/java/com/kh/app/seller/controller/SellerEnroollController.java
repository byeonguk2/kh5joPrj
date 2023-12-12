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
			
			// 회원가입 정보 가져오기
			SellerVo joinVo = (SellerVo)session.getAttribute("joinVo");
			session.removeAttribute("joinVo");
			
			// 사업자 정보 받아오기
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
			Part f = req.getPart("f");			
			Part f2 = req.getPart("f2");
			
			// 스트림 널 로 만들기
			InputStream in = null;
			InputStream in2 = null;
			
			// 유효성 검사 
			
			// 읽기 (만약 파일경로가 안들어오면 에러 발생)
			if(f.getSubmittedFileName() != null && !f.getSubmittedFileName().equals("")) {
				in2 = f2.getInputStream();
			}else {
				throw new Exception("사진 첨부를 안함..");
			}
			
			// 사업자 번호 길이체크 
			if(business_no.length() < 10) {
				throw new Exception("사업자 번호 길이가 짧음");
			}
			
			// 사업자 형태 값이 없으면 오류
			if(business_form == null || business_form.equals("")) {
				throw new Exception("사업자 형태가 널임");
			}
			
			// 사업자 명이 널임
			if(business_name == null || business_name.equals("")) {
				throw new Exception("사업자 명이 널임");
			}
			
			// 사업자 전화번호 널 체크
			if(business_phone == null || business_phone.equals("")) {
				throw new Exception("사업자 전화번호가 널임");
			}
			
			// 법인명 체크(법인사업자로 체크시)
			if(business_form.equals("법인사업자")) {
				if(corporation_name == null || corporation_name.equals("")) {
					throw new Exception("법인명이 널임");
				}
			}
			
			// 업태 널 체크
			if(uptae == null || uptae.equals("")) {
				throw new Exception("업태가 널임");
			}
			
			// 업종 널 체크
			if(upjong == null || upjong.equals("")) {
				throw new Exception("업종이 널임");
			}
			
			// 우편번호 널 체크
			if(businees_zipCode == null || businees_zipCode.equals("")) {
				throw new Exception("우편번호가 널임");
			}
			
			// 사업자 주소 널 체크
			if(businees_adr == null || businees_adr.equals("")) {
				throw new Exception("사업자 주소가 널임");
			}
			
			// 사업자 상세주소 널 체크
			if(detailed_adr == null || detailed_adr.equals("")) {
				throw new Exception("사업자 상세주소가 널임");
			}
			
			// 통신 판매업 번호 널 체크
			if(report_number == null || report_number.equals("")) {
				throw new Exception("통신 판매업 번호가 널임");
			}
			
			// 은행 널 체크
			if(bank == null || bank.equals("")) {
				throw new Exception("은행이 널임");
			}
			
			// 입금자명이 널임
			if(depositor == null || depositor.equals("")) {
				throw new Exception("입금자명이 널임");
			}
			
			// 입금 계좌가 널임
			if(account == null || account.equals("")) {
				throw new Exception("입금계좌가 널임");
			}
			
			// 읽기 (만약 파일경로가 안들어오면 에러 발생)
			if(f2.getSubmittedFileName() != null && !f2.getSubmittedFileName().equals("")) {
				in = f.getInputStream();
			}else {
				throw new Exception("사진 첨부를 안함..");
			}
			
			
			// 구분자 생성
			String sep = File.separator;
			
			// 파일 이름 변수로 할당
			String fileName = sep+f.getSubmittedFileName();
			String fileName2 = sep+f2.getSubmittedFileName();
			
			// 경로 설정
			String path = req.getServletContext().getRealPath(sep+"resources"+sep+"upload"+sep+"img");
			
			System.out.println("경로"+path+sep+fileName+"/"+"경로2"+path+sep+fileName2);
			
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
			
			// 스트림 close
			in.close();
			out.close();
			in2.close();
			out2.close();
			
			// 업로드한 파일 경로 디비에 저장
			String[] strArr = new String[2];
			strArr[0] = sep+"nongra"+sep+"resources"+sep+"upload"+sep+"img"+fileName;
			strArr[1] = sep+"nongra"+sep+"resources"+sep+"upload"+sep+"img"+fileName2;
			System.out.println(strArr);
			
			// vo에 값들 전부 할당
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
			
			//service 호출 
			SellerService ss = new SellerService();
			int result = ss.join(joinVo,strArr);
			
			// result의 값이 4가 아니면 회원가입 실패 
			if(result != 4) {
				throw new Exception("[ERROR-S002] 디비 인서트 값 4가아님");
			}
			
			// 성공시 세션으로 회원가입 성공메세지 할당
			session.setAttribute("alertMsg", "회원가입 성공");
			resp.sendRedirect("/nongra/seller/login");
			
		}catch (Exception e) {
			// 실패시 회원가입 페이지로 이동후 알림
			System.out.println(e.getMessage());
			System.out.println("[ERROR-S001] 회원가입중 예외발생..");
			e.printStackTrace();
			session.setAttribute("alertMsg", "회원가입 실패");
			resp.sendRedirect("/nongra/seller/join");
		}
		
	}
}
