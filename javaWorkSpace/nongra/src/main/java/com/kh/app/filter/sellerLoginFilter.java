//package com.kh.app.filter;
//
//import java.io.IOException;
//
//import javax.servlet.Filter;
//import javax.servlet.FilterChain;
//import javax.servlet.ServletException;
//import javax.servlet.ServletRequest;
//import javax.servlet.ServletResponse;
//import javax.servlet.annotation.WebFilter;
//import javax.servlet.http.HttpServletRequest;
//import javax.servlet.http.HttpServletResponse;
//
//@WebFilter("/seller/*")
//public class sellerLoginFilter implements Filter {
//
////	@Override
////	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) 
////	throws IOException , ServletException{
////	
////		HttpServletRequest req = (HttpServletRequest)request;
////		HttpServletResponse resp = (HttpServletResponse)response;
////		
////			if( req.getSession().getAttribute("loginSeller") == null ) {
////				req.getSession().setAttribute("alertMsg", "로그인 후 이용해 주세요.");
////				req.getSession().removeAttribute("alertMsg");
////				resp.sendRedirect("/nongra/loginS");
////			}else {
////				//다음단계 ㄱㄱ
////				chain.doFilter(request, response);
////			}
////	
////	}
//	
//}
