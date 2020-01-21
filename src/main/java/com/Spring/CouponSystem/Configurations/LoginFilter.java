package com.Spring.CouponSystem.Configurations;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebFilter("/rest/*")
public class LoginFilter implements Filter {

	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {

		HttpServletRequest httpServletRequest = (HttpServletRequest) request;
		HttpSession session = httpServletRequest.getSession(false);
		if(session!=null&&session.getAttribute("user")!=null) {
			chain.doFilter(request, response);
			System.out.println("Login Filter: " + httpServletRequest.getRequestURI());
		}else {
			((HttpServletResponse)response).sendError(HttpServletResponse.SC_UNAUTHORIZED);
		}
			
		

		
	}

}