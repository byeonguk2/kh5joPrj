package com.kh.app.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebFilter("/admin/*")
public class AdminLoginFilter implements Filter {

	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) 
	throws IOException , ServletException{
	
		HttpServletRequest req = (HttpServletRequest)request;
		HttpServletResponse resp = (HttpServletResponse)response;
		
			if( req.getSession().getAttribute("loginAdmin") == null ) {
				req.getSession().setAttribute("alertMsg", "로그인 후 이용해 주세요");
				resp.sendRedirect("/nongra/loginA");
			}else {
				//다음단계 ㄱㄱ
				chain.doFilter(request, response);
			}
	
	}
	
}
