package com.kh.app.admin.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.kh.app.admin.service.AdminService;
import com.kh.app.admin.vo.MemberDTO;
import com.kh.app.page.vo.PageVo;
import com.kh.app.seller.vo.SellerVo;

@WebServlet("/admin/findAllMembers")
public class FindAllMembersController extends HttpServlet {

	// 모든 회원 조회 / 수정
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		try {
			
			// service 객체 생성 
			AdminService adminService = new AdminService();
			
			// 모든 회원 총 카운트 구하기 
			int listCount = adminService.totalOfAllMembers();
			
			// 현재 페이지 설정
			String currentPagr_ = req.getParameter("pno");
			if(currentPagr_ == null) {
				currentPagr_ = "1";
			}
			int currentPage = Integer.parseInt(currentPagr_); 
			
			// 한 페이지 페이징 수 최대값 설정 
			int pageLimit = 5; // (우리가 정함) 한 페이지에 5개씩 나오게 할거다
			
			// 한 페이지 게시물 최대값 설정
			int boardLimit = 10; // (우리가 정함) 한페이지당 게시물이 10개씩 나오게 할거다
			
			// pageVo 이용해서 페이징 처리 계산하기 
			PageVo pvo = new PageVo(listCount, currentPage, pageLimit, boardLimit);
			
			// service (리턴값 voList)
			List<MemberDTO> memberVoList = adminService.findAllMembers(pvo);
			
			// 데이터 보내기 
			req.setAttribute("memberVoList", memberVoList);
			req.setAttribute("pvo", pvo);
			
			// 회원 조회/수정 페이지 이동
			req.getRequestDispatcher("/WEB-INF/views/admin/member/findAllMembers.jsp").forward(req, resp);
			
		}catch (Exception e) {
		
			// 모든 회원 조회중 문제발생시 예외처리후 어드민 로그인 페이지로이동
			e.printStackTrace();
			req.getSession().setAttribute("alert","관리자 회원 조회/수정 페이지 이동실패");
			resp.sendRedirect("/nongra/admin/login");
		
		} // catch
	
	} // doGet
	
} // class
