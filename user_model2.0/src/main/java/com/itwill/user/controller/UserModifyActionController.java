package com.itwill.user.controller;

import com.itwill.spring.mvc.Controller;
import com.itwill.user.User;
import com.itwill.user.UserService;
import com.itwill.user.UserServiceImpl;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

public class UserModifyActionController implements Controller {
	private UserService userService;

	public UserModifyActionController() {
		try {
			userService = new UserServiceImpl();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Override
	public String handleRequest(HttpServletRequest request, HttpServletResponse response) {
		/*************** 로그인체크[loginCheck.jspf] ***********/
		HttpSession session = request.getSession();
		String sUserId = (String) session.getAttribute("sUserId");
		if (sUserId == null) {
			return "redirect:user_login_form.do";
		}
		/*****************************************/
		/*
		0.login 여부체크
		1.GET방식이면 user_main.do redirection
		2.요청객체인코딩설정
		3.파라메타받기(password,name,email)
		4.세션의 sUserId와 파라메타(password,name,email) 로 User객체생성후  UserService.update 메쏘드호출
		5.성공:user_view.do redirection
		  실패:user_error.jsp forward 
		*/
		try {
			if (request.getMethod().equalsIgnoreCase("GET")) {
				return "redirect:user_main.do";
			}
			String password = request.getParameter("password");
			String name = request.getParameter("name");
			String email = request.getParameter("email");
			int rowCount = userService.update(new User(sUserId, password, name, email));
			return "redirect:user_view.do";
			
		} catch (Exception e) {
			e.printStackTrace();
			return "forward:/WEB-INF/views/user_error.jsp";
		}
	
	}

}