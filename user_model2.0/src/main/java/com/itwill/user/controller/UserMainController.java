package com.itwill.user.controller;

import com.itwill.spring.mvc.Controller;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class UserMainController implements Controller{
	
	@Override
	public String handleRequest(HttpServletRequest arg0, HttpServletResponse arg1) {
		
		return "forward:/WEB-INF/views/user_main.jsp";
	}
}
