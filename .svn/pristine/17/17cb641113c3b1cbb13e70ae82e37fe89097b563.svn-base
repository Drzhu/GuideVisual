package com.guide.interceptors;

import java.util.Enumeration;
import java.util.HashMap;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

public class LoginInterceptor implements HandlerInterceptor{

	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		HttpSession session = request.getSession();
		Enumeration<String> e = session.getAttributeNames();
		HashMap< String, String> map = new HashMap<String, String>();
		while(e.hasMoreElements()){
			map.put(e.nextElement(),"");
		}
		if (map.containsKey("isLogin")) {
			if (session.getAttribute("isLogin").equals(true)) {
				return true;
			}else{
				response.sendError(501, "你还没有登录呢！");
				//response.sendRedirect("/GuideVisual/login.jsp");
				return false;
			}
		}else{
			response.sendError(502, "这里有点问题，请访问登录页面！");
			//response.sendRedirect("/GuideVisual/login.jsp");
			return false;
		}
		
		
	}

	public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler,
			ModelAndView modelAndView) throws Exception {
		// TODO Auto-generated method stub
	}

	public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex)
			throws Exception {
		// TODO Auto-generated method stub
	}

}
