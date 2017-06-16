package com.guide.controller;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.HashMap;

import javax.annotation.Resource;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.guide.pojo.User;
import com.guide.service.UserService;
import com.guide.utils.JsonUtil;

@Controller
@RequestMapping("/")
public class UserController {
	SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
	SimpleDateFormat fmr = new SimpleDateFormat("MM-dd");
	DecimalFormat df = new DecimalFormat();
	// 处理业务逻辑的userService
	@Resource(name = "userService")
	private UserService userService;
	@SuppressWarnings("unused")
	private Logger logger;

	public UserController() {
		this.logger = Logger.getLogger(UserController.class);
	}

	// 退出登录
	@RequestMapping(value = "logout", method = RequestMethod.GET)
	public String logout(HttpServletRequest request, HttpSession session) {
		// 删除session登录信息
		session.setAttribute("isLogin", false);
		session.setAttribute("login_level", "logout");
		return "login";
	}

	// 登录验证
	@ResponseBody
	@RequestMapping(value = "val_level", method = RequestMethod.GET, produces = "text/plain;charset=UTF-8")
	public String val_level(@RequestParam("level") String level, HttpServletRequest request, HttpSession session,
			HttpServletResponse response) throws Exception {
		if (session.getAttribute("login_level").equals(level)) {
			return "success";
		} else {
			return "error";
		}
	}

	// 登录验证
	@ResponseBody
	@RequestMapping(value = "Validate_b", method = RequestMethod.POST, produces = "text/plain;charset=UTF-8")
	public String Validate_b(@RequestParam("username") String username, @RequestParam("password") String password,
			@RequestParam("level") String level, HttpServletRequest request, HttpSession session,
			HttpServletResponse response) throws Exception {
		HashMap<String, String> map = new HashMap<String, String>();
		User users = new User();
		users.setUsername(username);
		users.setPassword(password);
		users.setLevel(level);
		session.setAttribute("username", username);
		int u = userService.validate_user(users);
		if (u != 0) {
			int s = userService.validate_right(users);
			if (s == 0) {
				map.put("error_1", "用户名密码错误！");
			} else {
				map.put("success", "success");
				session.setAttribute("isLogin", true);
				session.setAttribute("login_level", level);
				addCookie(username, password, response, request);
			}
		} else {
			map.put("error_0", "用户 【" + username + "】 不存在！");
		}
		return JsonUtil.map2json(map);
	}

	private void addCookie(String username, String password, HttpServletResponse response, HttpServletRequest request)
			throws UnsupportedEncodingException {
		if (!username.equals("") && !password.equals("")) {
			// 创建Cookie
			Cookie nameCookie = new Cookie("name", URLEncoder.encode(username, "utf-8"));
			Cookie pswCookie = new Cookie("psw", password);
			// 设置Cookie的父路径
			nameCookie.setPath(request.getContextPath() + "/");
			pswCookie.setPath(request.getContextPath() + "/");

			// 获取是否保存Cookie
			String rememberMe = request.getParameter("rember");
			if (rememberMe == null || rememberMe.equals(false)) {// 不保存Cookie
				nameCookie.setMaxAge(0);
				pswCookie.setMaxAge(0);
			} else {// 保存Cookie的时间长度，单位为秒
				nameCookie.setMaxAge(7 * 24 * 60 * 60);
				pswCookie.setMaxAge(7 * 24 * 60 * 60);
			}
			// 加入Cookie到响应头
			response.addCookie(nameCookie);
			response.addCookie(pswCookie);
		}
	}
}
