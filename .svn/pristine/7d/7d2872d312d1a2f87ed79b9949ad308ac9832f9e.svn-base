package com.guide.interceptors;

import java.util.Enumeration;
import java.util.HashMap;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

public class CommunityInterceptor implements HandlerInterceptor{

	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		HttpSession session = request.getSession();
		Enumeration<String> e = session.getAttributeNames();
		HashMap< String, String> map = new HashMap<String, String>();
		while(e.hasMoreElements()){
			map.put(e.nextElement(),"");
		}
		if (map.containsKey("login_level")) {
			if ("lpt2".equals(session.getAttribute("login_level"))) {
				return true;
			}else{
				//response.sendError(405, "您已经退出。请重新登录");
				response.sendRedirect("/GuideVisual/login.jsp");
				return false;
			}
		}else{
			//response.sendError(405, "这里有点问题，请访问登录页面！");
			response.sendRedirect("/GuideVisual/login.jsp");
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
