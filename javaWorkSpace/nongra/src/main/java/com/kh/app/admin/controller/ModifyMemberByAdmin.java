package com.kh.app.admin.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.kh.app.admin.service.AdminService;
import com.kh.app.member.vo.MemberVo;
import com.kh.app.seller.vo.SellerVo;

// 회원 정보수정 컨트롤러
@WebServlet("/admin/modify")
public class ModifyMemberByAdmin extends HttpServlet {

	// 포스트 방식으로 정보들을 받아옴
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		HttpSession session = req.getSession();
		String checkMemberTypeByMsg = null;
		
		try {
			// 회원 데이터 받아옴
			String sellerYn = req.getParameter("sellerYn");
			System.out.println("yn: "+sellerYn);
			
			// 서비스 생성
			AdminService adminService = new AdminService();
			
			// sellerYn 값이 null이라면 예외가 발생
			if(sellerYn == null) {
				checkMemberTypeByMsg = "소비자인지 판매자인지 여부를 알수 없습니다.";
				throw new Exception(checkMemberTypeByMsg);
			}
			
			// 회원의 공통 데이터
			String memberNo = req.getParameter("memberNo");
			String id = req.getParameter("id");
			String password = req.getParameter("password");
			String nick = req.getParameter("nick");
			String name = req.getParameter("name");
			String email = req.getParameter("email");
			String phone = req.getParameter("phone");
			String address = req.getParameter("address");
			String detailAddress = req.getParameter("detailAddress");
			
			// 회원의 유형에 따라 서비스가 다름
			if(sellerYn.equals("Y")) {
				
				// 판매자의 추가 정보
				String businessNo = req.getParameter("businessNo");
				String businessForm = req.getParameter("businessForm");
				String busineesName = req.getParameter("busineesName");
				String busineesZipCode = req.getParameter("busineesZipCode");
				String corporationName = req.getParameter("corporationName");
				String uptae = req.getParameter("uptae");
				String upjong = req.getParameter("upjong");
				String reportNumber = req.getParameter("reportNumber");
				String bank = req.getParameter("bank");
				String depositor = req.getParameter("depositor");
				String account = req.getParameter("account");
				
				SellerVo  vo = new SellerVo(memberNo, sellerYn, nick, id, password, password, email, nick, email, memberNo, memberNo, name, phone, businessNo, businessForm, busineesName, phone, corporationName, uptae, upjong, busineesZipCode, address, detailAddress, reportNumber, bank, depositor, account, uptae, upjong, reportNumber, bank, depositor, account, sellerYn,account);
				
				System.out.println("사업자번호 길이"+businessNo.length());
				
				if(businessNo.length() != 10) {
					// 수정이 실패했다면 예외 발생
					checkMemberTypeByMsg = "사업자 번호는 10자리로 입력하세요.";
					throw new Exception(checkMemberTypeByMsg);
				}
				System.out.println(phone.length());
				if(phone.length() >= 11) {
					// 수정이 실패했다면 예외 발생
					checkMemberTypeByMsg = "전화번호는 11자리 미만으로 입력하세요.";
					throw new Exception(checkMemberTypeByMsg);
				}
				
				// 판매자 정보 수정.
				int result = adminService.ModifySellerByAdmin(vo);
				
				// 수정이 잘 됬는지 체크
				if(result != 2) {
					// 수정이 실패했다면 예외 발생
					checkMemberTypeByMsg = "판매자 정보 수정이 실패했습니다.";
					throw new Exception(checkMemberTypeByMsg);
				}
				
				checkMemberTypeByMsg = "수정이 완료 되었습니다.";
				
				session.setAttribute("alert", checkMemberTypeByMsg);
				resp.sendRedirect("/nongra/admin/select");
				
			}else {
				
				// 소비자 추가정보
				String birthDay = req.getParameter("birthDay");
				String point = req.getParameter("point");
				
				MemberVo vo = new MemberVo(memberNo, id, password, password, nick, name, birthDay, phone, email, address, detailAddress, point, birthDay, point, point, sellerYn);
				
				System.out.println(vo);
				
				// 소비자 정보 수정.
				int result = adminService.ModifyMemberByAdmin(vo);
				
				// 수정이 잘 됬는지 체크
				if(result != 1) {
					// 수정이 실패했다면 예외 발생
					checkMemberTypeByMsg = "소비자 정보 수정이 실패했습니다.";
					throw new Exception(checkMemberTypeByMsg);
				}
				
				checkMemberTypeByMsg = "수정이 완료 되었습니다.";
				
				session.setAttribute("alert", checkMemberTypeByMsg);
				resp.sendRedirect("/nongra/admin/select");
				
			}
			
		}catch (Exception e) {
			
			// 오류내용 콘솔에 출력
			System.out.println(e.getMessage());
			e.printStackTrace();
			
			// 세션에 오류내용 추가후 에러메시지로 안내 
			session.setAttribute("alert", checkMemberTypeByMsg);
			resp.sendRedirect("/nongra/admin/select");
			
		}
		
	}
	
}
