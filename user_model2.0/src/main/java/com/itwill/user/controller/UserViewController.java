package com.itwill.user.controller;

import com.itwill.spring.mvc.Controller;
import com.itwill.user.User;
import com.itwill.user.UserService;
import com.itwill.user.UserServiceImpl;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

public class UserViewController implements Controller{
	private UserService userService;
	public UserViewController() {
		try {
			userService=new UserServiceImpl();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	@Override
	public String handleRequest(HttpServletRequest request, HttpServletResponse response) {
		/***************로그인체크[loginCheck.jspf]***********/
		HttpSession session=request.getSession();
		String sUserId=(String)session.getAttribute("sUserId");
		if(sUserId==null) {
			return "redirect:user_login_form.do";
		}
		/*****************************************/
		/*
		1. UserService객체생성
		2. 세션의 sUserId를 사용해서 UserService.findUser()메쏘드호출
		 */
		try {
			User loginUser=userService.findUser(sUserId);
			request.setAttribute("loginUser", loginUser);
			return "forward:/WEB-INF/views/user_view.jsp";
		}catch (Exception e) {
			e.printStackTrace();
			return "forward:/WEB-INF/views/user_error.jsp";
		}
		
	}

}