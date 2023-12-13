package com.kh.app.admin.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.kh.app.admin.service.AdminService;
import com.kh.app.admin.vo.MemberDTO;
import com.kh.app.member.vo.MemberVo;
import com.kh.app.seller.vo.SellerVo;

// 회원 정보수정 컨트롤러
@WebServlet("/admin/modify")
public class ModifyAllMembersController extends HttpServlet {

	// 포스트 방식으로 정보들을 받아옴
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		HttpSession session = req.getSession();
		
		try {
			// 회원 데이터 받아옴
			String sellerYn = req.getParameter("sellerYn");
			
			// 서비스 생성
			AdminService adminService = new AdminService();
			
			// sellerYn 값이 null이라면 예외가 발생
			if(sellerYn == null) {
				throw new Exception("소비자인지 판매자인지 구분불가");
			}
			
			// 회원의 공통 데이터
			String memberNo = req.getParameter("memberNo");
			String id = req.getParameter("id");
			String pwd = req.getParameter("password");
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
				
				MemberDTO memberDTO = new MemberDTO(memberNo, id, pwd, nick, name, phone, detailAddress, detailAddress, pwd, nick, name, phone, detailAddress, 0, email, busineesName, sellerYn, sellerYn, businessNo, businessForm, busineesName, phone, busineesZipCode, address, detailAddress, corporationName, uptae, upjong, reportNumber, bank, bank, depositor, account, depositor, account);
				
				System.out.println("DTO: "+memberDTO);
				
				// 판매자 정보 수정.
				int result = adminService.ModifySellerByAdmin(memberDTO);
				
				// 수정이 잘 됬는지 체크
				if(result != 2) {
					// 수정이 실패했다면 예외 발생
					throw new Exception("판매자 정보 수정이 실패했습니다.");
				}
				
				// 성공시 메세지랑 같이 이동
				session.setAttribute("alertMsg", "수정이 완료 되었습니다.");
				resp.sendRedirect("/nongra/admin/findAllMembers");
				
			}else {
				
				// 소비자 추가정보
				String birthDay = req.getParameter("birthDay");
				int point = Integer.parseInt(req.getParameter("point"));
				
				MemberDTO memberDTO = new MemberDTO(memberNo, id, pwd, nick, name, phone, address, detailAddress, birthDay, phone, address, detailAddress, birthDay, point, email);

				// 소비자 정보 수정.
				int result = adminService.ModifyMemberByAdmin(memberDTO);
				
				// 수정이 잘 됬는지 체크
				if(result != 1) {
					// 수정이 실패했다면 예외 발생
					throw new Exception("소비자 정보 수정이 실패했습니다.");
				}
				
				session.setAttribute("alertMsg", "수정이 완료 되었습니다.");
				resp.sendRedirect("/nongra/admin/findAllMembers");
				
			}
			
		}catch (Exception e) {
			
			// 오류내용 콘솔에 출력
			System.out.println(e.getMessage());
			e.printStackTrace();
			
			// 세션에 오류내용 추가후 에러메시지로 안내 
			session.setAttribute("alertMsg", "소비자 정보 수정이 실패했습니다.");
			resp.sendRedirect("/nongra/admin/findAllMembers");
			
		}
		
	}
	
}
