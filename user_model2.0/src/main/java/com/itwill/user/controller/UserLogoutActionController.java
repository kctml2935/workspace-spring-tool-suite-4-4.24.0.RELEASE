package com.itwill.user.controller;

import com.itwill.spring.mvc.Controller;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

public class UserLogoutActionController implements Controller {

	@Override
	public String handleRequest(HttpServletRequest request, HttpServletResponse response) {
		/***************로그인체크[loginCheck.jspf]***********/
		HttpSession session=request.getSession();
		String sUserId=(String)session.getAttribute("sUserId");
		if(sUserId==null) {
			return "redirect:user_login_form.do";
		}
		/*****************************************/
		session.invalidate();
		return "redirect:user_main.do";
	}

}