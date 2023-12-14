package com.kh.app.seller.home;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.kh.app.seller.vo.SellerVo;

@WebServlet("/seller/home")
public class SellerHomeServlet extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		try {
			
			HttpSession session = req.getSession();
			SellerVo loginSeller = (SellerVo)session.getAttribute("loginSeller");

			if(loginSeller.getPermitYn().equals("N")) {
				session.setAttribute("alertMsg", "사업자 권한 수락후 로그인 가능합니다.");
				throw new Exception();
			}
				
			req.getRequestDispatcher("/WEB-INF/views/seller/sellerHome.jsp").forward(req, resp);
				
		}catch (Exception e) {
			e.printStackTrace();
			System.out.println("로그인 실패");
			resp.sendRedirect("/nongra/loginS");
		}
		
		
	}
	
}
