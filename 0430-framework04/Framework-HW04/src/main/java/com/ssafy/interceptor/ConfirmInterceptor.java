package com.ssafy.interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import com.ssafy.homework.model.dto.User;

public class ConfirmInterceptor extends HandlerInterceptorAdapter {

	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		HttpSession session = request.getSession();
		User user = (User) session.getAttribute("userinfo");
		if(user == null) {
			System.out.println("로그인 필요");
			response.sendRedirect(request.getContextPath());
			return false;
		}
		return true;
	}

	
	
}
